
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
import model.ContaCaixa;
import model.Igreja;
import model.Usuario;


public class AplicacaoDao {
        
    private Connection conexao = null;
    private PreparedStatement stmtSelect = null;
    private PreparedStatement stmtInsert = null;
    private PreparedStatement stmtDelete = null;
    private PreparedStatement stmtUpdate = null;
    private ResultSet rs = null;
    private final LogsDao logsDao = new LogsDao();
    
    
    public void cadastrarAplicacao(Aplicacao aplicacao, Usuario usuarioLogado){
        
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
    
    private void inserirRendimentoCadastroAplicacao(ResultSet generatedKeysAplicacao, Aplicacao aplicacao, Usuario usuarioLogado){    
        
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
    
    private void saidaCaixaValorAplicado(int idRendimento, Aplicacao aplicacao, Usuario usuarioLogado){    
        
        String sql = "INSERT INTO MovimentoCaixa (Pessoa,ValorEntrada,ValorSaida,ContaCaixa,Complemento,Igreja,UsuarioCadastro,DataMovimento,RegistroAplicacao) VALUES(1,0,?,?,?,?,?,GETDATE(),?)";
        String complemento = "Aplicação Financeira | "+ aplicacao.getContaCaixa().getNome();
        
        try{      
            this.stmtInsert = this.conexao.prepareStatement(sql);
            
            this.stmtInsert.setDouble(1, aplicacao.getValorInicial());
            this.stmtInsert.setInt(2, aplicacao.getContaCaixa().getCodigo());
            this.stmtInsert.setString(3, complemento);
            this.stmtInsert.setInt(4, aplicacao.getIgreja().getCodigo());
            this.stmtInsert.setInt(5, usuarioLogado.getCodigo());
            this.stmtInsert.setInt(6, idRendimento);
            this.stmtInsert.execute(); 
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar movimentar o valor aplicado, no caixa", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }
    }   
    
    //Consultar os dados para ser usado no cálculo de rendimento mensal
    public List<Aplicacao> totalRendimentoParaCalcularRendimentoMensal(int dia){
        
        List<Aplicacao> listaAplicacao = new ArrayList<>();
        
        String sql = "SELECT " +
            "RA.AplicacaoID AS CodAplicacao, " +
            "SUM(RA.ValorRendimento) AS ValorRendimento, " +
            "(SELECT PercentualAplicacao FROM Aplicacoes AS A WHERE A.Codigo = RA.AplicacaoID) AS Percentual " +
            "FROM RendimentoAplicacao AS RA " +
            "WHERE (SELECT Status FROM Aplicacoes AS A WHERE A.Codigo = RA.AplicacaoID) = 1 " +
            "AND (SELECT DiaAniversario FROM Aplicacoes AS A WHERE A.Codigo = RA.AplicacaoID) = ? " +
            "AND (SELECT TipoRendimento FROM Aplicacoes AS A WHERE A.Codigo = RA.AplicacaoID) = 'Mensal' " +
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
    
    //Consultar os dados para ser utilizado no cálculo de rendimento diário
    public List<Aplicacao> totalRendimentoParaCalcularRendimentoDiario(){
        
        List<Aplicacao> listaAplicacao = new ArrayList<>();
        
        String sql = "SELECT " +
            "RA.AplicacaoID AS CodAplicacao, " +
            "SUM(RA.ValorRendimento) AS ValorRendimento, " +
            "(SELECT PercentualAplicacao FROM Aplicacoes AS A WHERE A.Codigo = RA.AplicacaoID) AS Percentual " +
            "FROM RendimentoAplicacao AS RA " +
            "WHERE (SELECT Status FROM Aplicacoes AS A WHERE A.Codigo = RA.AplicacaoID) = 1 " +
            "AND (SELECT TipoRendimento FROM Aplicacoes AS A WHERE A.Codigo = RA.AplicacaoID) = 'Diario' " +
            "GROUP BY RA.AplicacaoID";

        try{
            conexao = Conexao.getDataSource().getConnection();
            stmtSelect = conexao.prepareStatement(sql);
            
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
    
    //Inseri o rendimento calculado de forma automatica pelo sistema
    public void inserirRendimentoMensalAutomatico(List<Aplicacao> aplicacao){    
        
        String sql = "Insert Into RendimentoAplicacao (AplicacaoID,ValorRendimento,DataProcessamento) Values (?,?,GETDATE())";           

        try{         
            this.conexao = Conexao.getDataSource().getConnection();
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
    
    //Consultar aplicação no mecanimos de busca
    public  List<Aplicacao> consultarAplicacao(String textoBusca){
        
        List<Aplicacao> listaAplicacao = new ArrayList<>();   
        String sql = "SELECT *, " +
            "(SELECT NomeIgreja FROM Igrejas AS I WHERE A.Igreja = I.Codigo) As NomeIgreja, " +
            "(SELECT Descricao FROM ContasCaixa As CC WHERE CC.Codigo = A.ContaCaixa) As NomeContaCaixa " +
            "FROM Aplicacoes AS A WHERE (? IS NULL OR A.Codigo LIKE ?) OR (? IS NULL OR A.Descricao LIKE ?)";
    
        try{
            this.conexao = Conexao.getDataSource().getConnection();           
            this.stmtSelect = this.conexao.prepareStatement(sql);
            
            if (textoBusca != null) {
                this.stmtSelect.setString(1,  "%" + textoBusca + "%");
                this.stmtSelect.setString(2,  "%" + textoBusca + "%");
                this.stmtSelect.setString(3,  "%" + textoBusca + "%");
                this.stmtSelect.setString(4,  "%" + textoBusca + "%");
            } else {
                this.stmtSelect.setNull(1, java.sql.Types.INTEGER);
                this.stmtSelect.setNull(2, java.sql.Types.INTEGER);
                this.stmtSelect.setNull(3, java.sql.Types.INTEGER);
                this.stmtSelect.setNull(4, java.sql.Types.INTEGER);
            }           
            this.rs = this.stmtSelect.executeQuery();

            while(this.rs.next()){
                Aplicacao aplicacao = new Aplicacao();
                ContaCaixa contaCaixa = new ContaCaixa();
                Igreja igreja = new Igreja();
                contaCaixa.setCodigo(this.rs.getInt("ContaCaixa"));
                contaCaixa.setNome(this.rs.getString("NomeContaCaixa"));
                igreja.setNome(this.rs.getString("NomeIgreja"));
                igreja.setCodigo(this.rs.getInt("Igreja"));
                aplicacao.setCodigo(this.rs.getInt("Codigo"));
                aplicacao.setDescricao(this.rs.getString("Descricao"));
                aplicacao.setValorInicial(this.rs.getDouble("ValorInicialAplicacao"));
                aplicacao.setTipoRendimento(this.rs.getString("TipoRendimento"));
                aplicacao.setPercentual(this.rs.getDouble("PercentualAplicacao"));
                aplicacao.setDataAplicacao(this.rs.getDate("DataAplicacao"));
                aplicacao.setStatusAplicacao(this.rs.getInt("Status"));
                aplicacao.setDiaAniversario(this.rs.getInt("DiaAniversario"));
                aplicacao.setContaCaixa(contaCaixa);
                aplicacao.setIgreja(igreja);
                
                listaAplicacao.add(aplicacao);
            }       
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar as aplicações", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.rs != null) this.rs.close();
                if (this.stmtSelect != null) this.stmtSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return listaAplicacao;
    }
    
    public void alterarAplicacao(Aplicacao aplicacao){
            String sql= "Update Aplicacoes Set Descricao = ?, PercentualAplicacao = ?, DiaAniversario = ? Where Codigo = ?";

        try{
            this.conexao = Conexao.getDataSource().getConnection();       
            this.stmtUpdate = this.conexao.prepareStatement(sql);

            this.stmtUpdate.setString(1, aplicacao.getDescricao());
            this.stmtUpdate.setDouble(2, aplicacao.getPercentual());
            this.stmtUpdate.setInt(3, aplicacao.getDiaAniversario());
            this.stmtUpdate.setInt(4, aplicacao.getCodigo());

            this.stmtUpdate.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Aplicação alterada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);         
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a aplicação", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.stmtUpdate != null) this.stmtUpdate.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void encerrarAplicacao(Aplicacao aplicacao){
        String sql= "Update Aplicacoes Set Status = 0, DataEncerramento = GETDATE() Where Codigo = ?";

        try{
            this.conexao = Conexao.getDataSource().getConnection();       
            this.stmtUpdate = this.conexao.prepareStatement(sql);

            this.stmtUpdate.setInt(1, aplicacao.getCodigo());
            this.stmtUpdate.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Aplicação encerrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);         
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar encerrar a aplicação", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.stmtUpdate != null) this.stmtUpdate.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    //Consulta para mostrar no Dashboar da tela de movimento financeiro
    public Aplicacao consultarValorAplicadoRendido(ContaCaixa contaCaixa){
        
        Aplicacao aplicacao = new Aplicacao();
        
        String sql = "SELECT " +
            "SUM(A.ValorInicialAplicacao) AS ValorAplicado, " +
            "SUM(R.ValorRendimento) AS ValorRendido " +
            "FROM Aplicacoes AS A " +
            "JOIN (SELECT AplicacaoID, SUM(ValorRendimento) AS ValorRendimento FROM RendimentoAplicacao GROUP BY AplicacaoID) AS R ON A.Codigo = R.AplicacaoID " +
            "WHERE A.Status = 1 " +
            "AND A.ContaCaixa = ?";
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();           
            this.stmtSelect = this.conexao.prepareStatement(sql);
            
            this.stmtSelect.setInt(1,  contaCaixa.getCodigo());
            this.rs = this.stmtSelect.executeQuery();

            while(this.rs.next()){
                aplicacao.setValorInicial(this.rs.getDouble("ValorAplicado"));
                aplicacao.setValorRendimento(this.rs.getDouble("ValorRendido"));
            }       
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o valor aplicado e o valor de rendimento", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.rs != null) this.rs.close();
                if (this.stmtSelect != null) this.stmtSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }     
        return aplicacao;  
    }
    
    //Consulta para ser utilizada no relatório de prestação mensal
    public double consultarRendimentoAplicacao(Igreja igreja){
        double valorRendimento = 0;
        
        String sql = "SELECT SUM(RA.ValorRendimento) - Sum(IsNull(RA.ValorRetirada,0)) AS Rendimento " +
            "FROM RendimentoAplicacao AS RA " +
            "WHERE (SELECT Igreja FROM Aplicacoes AS A WHERE A.Codigo = RA.AplicacaoID) = ? " +
            "AND (SELECT Status FROM Aplicacoes AS A WHERE A.Codigo = RA.AplicacaoID) = 1";

        
        try{
            this.conexao = Conexao.getDataSource().getConnection();           
            this.stmtSelect = this.conexao.prepareStatement(sql);
            
            this.stmtSelect.setInt(1,  igreja.getCodigo());
            this.rs = this.stmtSelect.executeQuery();

            while(this.rs.next()){
                valorRendimento = this.rs.getDouble("Rendimento");
            }       
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o rendimento", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.rs != null) this.rs.close();
                if (this.stmtSelect != null) this.stmtSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }     
        return valorRendimento;  
    }
    
}
