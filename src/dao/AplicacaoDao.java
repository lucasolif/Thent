
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.Aplicacao;
import model.Igreja;
import model.UsuarioLogado;


public class AplicacaoDao {
        
    private Connection conexao = null;
    private PreparedStatement stmtSelect = null;
    private PreparedStatement stmtInsert = null;
    private PreparedStatement stmtDelete = null;
    private PreparedStatement stmtUpdate = null;
    private ResultSet rs = null;
    private final LogsDao logsDao = new LogsDao();
    
    
    public void cadastrarAplicacao(Aplicacao aplicacao, UsuarioLogado usuarioLogado){
        
        String sql = "INSERT INTO Aplicacoes (Descricao, ContaCaixa, Igreja, ValorInicialAplicacao, TipoRendimento, PercentualAplicacao, DataAplicacao, DataCadastro, Status,DiaAniversario) VALUES (?, ?, ?, ?, ?, ?, ?, GETDATE(), 1,?)";
        ResultSet generatedKeys = null;
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();
            conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            this.stmtInsert = this.conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            this.stmtInsert.setString(1, aplicacao.getDescricao());
            this.stmtInsert.setInt(2, aplicacao.getContaCaixa().getCodigo());
            this.stmtInsert.setInt(3, aplicacao.getIgreja().getCodigo());
            this.stmtInsert.setDouble(4, aplicacao.getValorInicial());
            this.stmtInsert.setString(5, aplicacao.getTipoRendimento());
            this.stmtInsert.setDouble(6, aplicacao.getPercentual());
            this.stmtInsert.setDate(7, (Date) aplicacao.getDataAplicacao());
            this.stmtInsert.setInt(8, aplicacao.getDiaAniversario());
            this.stmtInsert.executeUpdate();
            
            // Recuperar a chave primária gerada
            generatedKeys = stmtInsert.getGeneratedKeys();
            
            if (generatedKeys.next()) {
                //Inserindo o valor na tabela de rendimento
                inserirRendimentoCadastroAplicacao(generatedKeys,aplicacao, usuarioLogado);               
            }
            //Confimar a transação, ou seja, a inserção dos dados
            conexao.commit();
            JOptionPane.showMessageDialog(null, "Aplicação cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);        
        }catch (SQLException ex) {            
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a aplicação", "Erro 001", JOptionPane.ERROR_MESSAGE);
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
        }
        finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (stmtSelect != null) stmtSelect.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }   
    
    private void inserirRendimentoCadastroAplicacao(ResultSet generatedKeysAplicacao, Aplicacao aplicacao, UsuarioLogado usuarioLogado){    
        
        String sql = "Insert Into RendimentoAplicacao (AplicacaoID,ValorRendimento,DataProcessamento) Values (?,?,GETDATE())";           

        try{ 
            //Recebe a chave primaria gerada na inserção da tabela de aplicação
            int idAplicacao = generatedKeysAplicacao.getInt(1);
            
            this.stmtInsert = this.conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.stmtInsert.setInt(1, idAplicacao);
            this.stmtInsert.setDouble(2, aplicacao.getValorInicial());
            this.stmtInsert.executeUpdate(); 
            
            //Pega a chave primaria gerada na inserção da tabela de rendimento
            ResultSet generatedKeysRendimento = stmtInsert.getGeneratedKeys();
            
            if (generatedKeysRendimento.next()) {           
                int idRendimento = generatedKeysRendimento.getInt(1);              
                
                //Dando saido no caixa, do valor que foi aplicado
                saidaCaixaValorAplicado(idRendimento, aplicacao, usuarioLogado);  
            }       
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastro o rendimento", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void saidaCaixaValorAplicado(int idRendimento, Aplicacao aplicacao, UsuarioLogado usuarioLogado){    
        
        String sql = "INSERT INTO MovimentoCaixa (Pessoa,ValorEntrada,ValorSaida,ContaCaixa,Complemento,Igreja,UsuarioCadastro,DataMovimento,RegistroAplicacao) VALUES(1,0,?,?,?,?,?,GETDATE(),?)";
        String complemento = "Aplicação Financeira | "+ aplicacao.getContaCaixa().getNome();
        
        try{      
            this.stmtInsert = this.conexao.prepareStatement(sql);
            
            this.stmtInsert.setDouble(1, aplicacao.getValorInicial());
            this.stmtInsert.setInt(2, aplicacao.getContaCaixa().getCodigo());
            this.stmtInsert.setString(3, complemento);
            this.stmtInsert.setInt(4, aplicacao.getIgreja().getCodigo());
            this.stmtInsert.setInt(5, usuarioLogado.getCodUsuario());
            this.stmtInsert.setInt(6, idRendimento);
            this.stmtInsert.execute(); 
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar movimentar o valor aplicado, no caixa", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }
    }   
    
    public List<Aplicacao> totalRendimentoParaCalcularRendimentoMensal(int dia){
        
        List<Aplicacao> listaAplicacao = new ArrayList<>();
        
        String sql = "SELECT " +
            "RA.AplicacaoID AS CodAplicacao, " +
            "SUM(RA.ValorRendimento) AS ValorRendimento, " +
            "(SELECT PercentualAplicacao FROM Aplicacoes AS A WHERE A.Codigo = RA.AplicacaoID) AS Percentual " +
            "FROM RendimentoAplicacao AS RA " +
            "WHERE (SELECT Status FROM Aplicacoes AS A WHERE A.Codigo = RA.AplicacaoID) = 1 " +
            "AND (SELECT DiaAniversario FROM Aplicacoes AS A WHERE A.Codigo = RA.AplicacaoID) = ? " +
            "GROUP BY RA.AplicacaoID";

        try{
            conexao = Conexao.getDataSource().getConnection();
            stmtSelect = conexao.prepareStatement(sql);
            
            stmtSelect.setInt(1, dia);
               
            rs = stmtSelect.executeQuery();

            while(rs.next()){               
                Aplicacao aplicacao = new Aplicacao();
                aplicacao.setCodigo(rs.getInt("CodAplicacao"));
                aplicacao.setValorRendimento(rs.getDouble("ValorRendimento"));
                aplicacao.setPercentual(rs.getDouble("Percentual"));
                
                listaAplicacao.add(aplicacao);
            }     
        } catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar os dados para calcular a aplicação", "Erro 011", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (stmtSelect != null) stmtSelect.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return listaAplicacao;
        
    }  
    
    public void inserirRendimentoMensalAutomatico(List<Aplicacao> aplicacao){    
        
        String sql = "Insert Into RendimentoAplicacao (AplicacaoID,ValorRendimento,DataProcessamento) Values (?,?,GETDATE())";           

        try{            
            this.stmtInsert = this.conexao.prepareStatement(sql);
            
            for(Aplicacao aplic : aplicacao){
                this.stmtInsert.setInt(1, aplic.getCodigo());
                this.stmtInsert.setDouble(2, aplic.getValorRendimento());

                this.stmtInsert.execute();            
            }
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
        }finally{
            try{
                if (this.stmtInsert != null) this.stmtInsert.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            }
        }
    }
    
    public  List<Aplicacao> consultarAplicacao(String textoBusca){
        
        List<Aplicacao> listaAplicacao = new ArrayList<>();
        
        return listaAplicacao;
    }
    
    //Consultar para popular o JComboBox
    public List<Aplicacao> consultarAutores(Igreja igreja){
        
        List<Aplicacao> listaAplicacoes = new ArrayList<>();
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "Select * From Aplicacoes WHERE Igreja = ? ORDER BY Nome";
            
            stmtSelect = conexao.prepareStatement(sql);           
            this.stmtSelect.setInt(1, igreja.getCodigo());
            rs = stmtSelect.executeQuery();

            while(rs.next()){
                Integer codAplicacao = rs.getInt("Codigo");
                String descAplicacao = rs.getString("Descricao");
                
                Aplicacao aplicacao = new Aplicacao();
                aplicacao.setCodigo(codAplicacao);
                aplicacao.setDescricao(descAplicacao);
                
                listaAplicacoes.add(aplicacao);
            }
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar as aplicações", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (stmtSelect != null) stmtSelect.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaAplicacoes;
    }
}
