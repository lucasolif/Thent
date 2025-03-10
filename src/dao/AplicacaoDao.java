
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
            
            // Recuperar a chave prim�ria gerada
            generatedKeys = stmtInsert.getGeneratedKeys();
            
            if (generatedKeys.next()) {
                //Inserindo o valor na tabela de rendimento
                inserirRendimentoCadastroAplicacao(generatedKeys,aplicacao, usuarioLogado);               
            }
            //Confimar a transa��o, ou seja, a inser��o dos dados
            conexao.commit();
            JOptionPane.showMessageDialog(null, "Aplica��o cadastrada com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);        
        }catch (SQLException ex) {            
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a aplica��o", "Erro 001", JOptionPane.ERROR_MESSAGE);
            logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
        }
        finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (stmtSelect != null) stmtSelect.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
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
            logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());  
        }finally{
            try{
                if (this.stmtInsert != null) this.stmtInsert.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
            }
        }
    }
    
    public void resgatarRendimento(Aplicacao aplicacao, Usuario usuarioLogado){
        
        String sql = "Insert Into RendimentoAplicacao (AplicacaoID,ValorRetirada,DataProcessamento) Values (?,?,GETDATE())";           
        
        try{    
            this.conexao = Conexao.getDataSource().getConnection();
            conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            this.stmtInsert = this.conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            this.stmtInsert.setInt(1, aplicacao.getCodigo());
            this.stmtInsert.setDouble(2, aplicacao.getValorRetirada());
            this.stmtInsert.executeUpdate(); 
            
            //Pega a chave primaria gerada na inser��o da tabela de rendimento
            ResultSet generatedKeysRendimento = stmtInsert.getGeneratedKeys();
            
            if (generatedKeysRendimento.next()) {           
                int idRendimento = generatedKeysRendimento.getInt(1);              
                
                //Dando saido no caixa, do valor que foi aplicado
                entradaCaixaValorResgate(idRendimento, aplicacao, usuarioLogado);  
            }       
            
            conexao.commit();
            JOptionPane.showMessageDialog(null, "Resgate efetuado com sucesso, no valor de R$ "+aplicacao.getValorRetirada(), "Conclu�do", JOptionPane.INFORMATION_MESSAGE); 
        }catch(SQLException ex){
            logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o resgate", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }
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
            
            JOptionPane.showMessageDialog(null, "Aplica��o alterada com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);         
        }catch (SQLException ex) {
            logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a aplica��o", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.stmtUpdate != null) this.stmtUpdate.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
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
            
            JOptionPane.showMessageDialog(null, "Aplica��o encerrada com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);         
        }catch (SQLException ex) {
            logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar encerrar a aplica��o", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.stmtUpdate != null) this.stmtUpdate.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void inserirRendimentoCadastroAplicacao(ResultSet generatedKeysAplicacao, Aplicacao aplicacao, Usuario usuarioLogado){    
        
        String sql = "Insert Into RendimentoAplicacao (AplicacaoID,ValorRendimento,DataProcessamento) Values (?,?,GETDATE())";           

        try{ 
            //Recebe a chave primaria gerada na inser��o da tabela de aplica��o
            int idAplicacao = generatedKeysAplicacao.getInt(1);
            
            this.stmtInsert = this.conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.stmtInsert.setInt(1, idAplicacao);
            this.stmtInsert.setDouble(2, aplicacao.getValorInicial());
            this.stmtInsert.executeUpdate(); 
            
            //Pega a chave primaria gerada na inser��o da tabela de rendimento
            ResultSet generatedKeysRendimento = stmtInsert.getGeneratedKeys();
            
            if (generatedKeysRendimento.next()) {           
                int idRendimento = generatedKeysRendimento.getInt(1);              
                
                //Dando saido no caixa, do valor que foi aplicado
                saidaCaixaValorAplicado(idRendimento, aplicacao, usuarioLogado);  
            }       
        }catch(SQLException ex){
            logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastro o rendimento", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void saidaCaixaValorAplicado(int idRendimento, Aplicacao aplicacao, Usuario usuarioLogado){    
        
        String sql = "INSERT INTO MovimentoCaixa (Pessoa,ValorEntrada,ValorSaida,ContaCaixa,Complemento,Igreja,UsuarioCadastro,DataMovimento,RegistroAplicacao) VALUES(1,0,?,?,?,?,?,GETDATE(),?)";
        String complemento = "Aplica��o Financeira | "+ aplicacao.getDescricao();
        
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
            logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar movimentar o valor aplicado, no caixa", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }
    }   
    
    private void entradaCaixaValorResgate(int idRendimento, Aplicacao aplicacao, Usuario usuarioLogado){    
        
        String sql = "INSERT INTO MovimentoCaixa (Pessoa,ValorEntrada,ValorSaida,ContaCaixa,Complemento,Igreja,UsuarioCadastro,DataMovimento,RegistroAplicacao) VALUES(1,?,?,?,?,?,?,GETDATE(),?)";
        String complemento = "Resgate Aplica��o Financeira | "+ aplicacao.getDescricao();
        double valorSaida = 0;
        
        try{      
            this.stmtInsert = this.conexao.prepareStatement(sql);
            
            this.stmtInsert.setDouble(1, aplicacao.getValorRetirada());
            this.stmtInsert.setDouble(2, valorSaida);
            this.stmtInsert.setInt(3, aplicacao.getContaCaixa().getCodigo());
            this.stmtInsert.setString(4, complemento);
            this.stmtInsert.setInt(5, aplicacao.getIgreja().getCodigo());
            this.stmtInsert.setInt(6, usuarioLogado.getCodigo());
            this.stmtInsert.setInt(7, idRendimento);
            this.stmtInsert.execute(); 
        }catch(SQLException ex){
            logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar movimentar o valor do resgate, no caixa", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }
    }  
    
    //Consultar os dados para ser usado no c�lculo de rendimento mensal
    public List<Aplicacao> totalRendimentoParaCalcularRendimentoMensal(int dia){
        
        List<Aplicacao> listaAplicacao = new ArrayList<>();
        
        String sql = "SELECT " +
            "RA.AplicacaoID AS CodAplicacao, " +
            "SUM(ISNULL(RA.ValorRendimento,0)) AS ValorRendimento, " +
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
            logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar os dados para calcular a aplica��o", "Erro 011", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (stmtSelect != null) stmtSelect.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return listaAplicacao;
        
    }  
    
    //Consultar os dados para ser utilizado no c�lculo de rendimento di�rio
    public List<Aplicacao> totalRendimentoParaCalcularRendimentoDiario(){
        
        List<Aplicacao> listaAplicacao = new ArrayList<>();
        
        String sql = "SELECT " +
            "RA.AplicacaoID AS CodAplicacao, " +
            "SUM(ISNULL(RA.ValorRendimento,0)) AS ValorRendimento, " +
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
            logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar os dados para calcular a aplica��o", "Erro 011", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (stmtSelect != null) stmtSelect.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return listaAplicacao;
        
    }   
    
    //Consultar aplica��o no mecanimos de busca
    public  List<Aplicacao> consultarAplicacao(String textoBusca, String filtroIgreja){
        
        List<Aplicacao> listaAplicacao = new ArrayList<>();   
        String sql = "SELECT *, " +
            "(SELECT NomeIgreja FROM Igrejas AS I WHERE A.Igreja = I.Codigo) As NomeIgreja, " +
            "(SELECT Descricao FROM ContasCaixa As CC WHERE CC.Codigo = A.ContaCaixa) As NomeContaCaixa " +
            "FROM Aplicacoes AS A " +
            "WHERE ((? IS NULL OR A.Codigo LIKE ?) OR (? IS NULL OR A.Descricao LIKE ?)) AND A.Igreja IN ("+filtroIgreja+")";
    
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
            logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar as aplica��es", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.rs != null) this.rs.close();
                if (this.stmtSelect != null) this.stmtSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return listaAplicacao;
    }
    
    //Consulta para mostrar no Dashboar da tela de movimento financeiro
    public Aplicacao consultarValorAplicadoRendido(ContaCaixa contaCaixa, Date dataBase){
        
        Aplicacao aplicacao = new Aplicacao();
        
        String sql = "SELECT " +
            "ISNULL(A.ValorInicialAplicacao, 0) AS ValorAplicado, " +
            "SUM(ISNULL(R.ValorRendimento, 0)) - ISNULL(A.ValorInicialAplicacao, 0) AS ValorRendido " +
            "FROM Aplicacoes AS A " +
            "INNER JOIN RendimentoAplicacao R ON A.Codigo = R.AplicacaoID " +
            "WHERE A.Status = 1 " +
            "AND A.ContaCaixa = ? " +
            "AND A.DataCadastro <= ? " +
            "OR R.DataProcessamento <= ? " +
            "GROUP BY A.ValorInicialAplicacao";
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();           
            this.stmtSelect = this.conexao.prepareStatement(sql);
            
            this.stmtSelect.setInt(1,  contaCaixa.getCodigo());
            this.stmtSelect.setDate(2,   dataBase);
            this.stmtSelect.setDate(3,   dataBase);
            this.rs = this.stmtSelect.executeQuery();

            while(this.rs.next()){
                aplicacao.setValorInicial(this.rs.getDouble("ValorAplicado"));
                aplicacao.setValorRendimento(this.rs.getDouble("ValorRendido"));
            }       
        }catch(SQLException ex){
            logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o valor aplicado e o valor de rendimento", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.rs != null) this.rs.close();
                if (this.stmtSelect != null) this.stmtSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }     
        return aplicacao;  
    }
    
    //Consulta para ser utilizada no relat�rio de presta��o mensal
    public double consultarRendimentoAplicacao(Igreja igreja){
        double valorRendimento = 0;
        
        String sql = "SELECT SUM(ISNULL(RA.ValorRendimento,0)) - Sum(ISNULL(RA.ValorRetirada,0)) AS Rendimento " +
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
            logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o rendimento", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.rs != null) this.rs.close();
                if (this.stmtSelect != null) this.stmtSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }     
        return valorRendimento;  
    }
    
    //consultar de aplica��o para inserir no Checkbox
    public List<Aplicacao> consultarTodasAplicacoes (Usuario usuarioLogado, String filtroIgreja){
        
        String sql = "SELECT * FROM Aplicacoes WHERE Status = 1 AND Igreja IN ("+filtroIgreja+") ORDER BY Descricao";
        List<Aplicacao> todasAplicacoes = new ArrayList<>();

        try{
            this.conexao = Conexao.getDataSource().getConnection();           
            this.stmtSelect = this.conexao.prepareStatement(sql);
            
            this.rs = this.stmtSelect.executeQuery();

            while(this.rs.next()){
                Aplicacao aplicacao = new Aplicacao();
                ContaCaixa contaCaixa = new ContaCaixa();
                Igreja igreja = new Igreja();
                igreja.setCodigo(this.rs.getInt("Igreja"));
                contaCaixa.setCodigo(this.rs.getInt("ContaCaixa"));
                aplicacao.setCodigo(this.rs.getInt("Codigo"));
                aplicacao.setDescricao(this.rs.getString("Descricao"));
                aplicacao.setValorInicial(this.rs.getDouble("ValorInicialAplicacao"));
                aplicacao.setTipoRendimento(this.rs.getString("TipoRendimento"));
                aplicacao.setPercentual(this.rs.getDouble("PercentualAplicacao"));
                aplicacao.setDataAplicacao(this.rs.getDate("DataAplicacao"));
                aplicacao.setDataCadastro(this.rs.getDate("DataCadastro"));
                aplicacao.setDiaAniversario(this.rs.getInt("DiaAniversario"));
                aplicacao.setContaCaixa(contaCaixa);
                aplicacao.setIgreja(igreja);
                
                todasAplicacoes.add(aplicacao);
            }       
        }catch(SQLException ex){
            logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar as aplica��s", "Erro", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.rs != null) this.rs.close();
                if (this.stmtSelect != null) this.stmtSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return todasAplicacoes;
    } 
    
    //Consultar valor disponivel para retirada na aplica��o escolhida - Tela Retirada de Aplicaca��o
    public double consultarValorDisponivel (Aplicacao aplicacao){
        
        String sql = "SELECT SUM(ISNULL(ValorRendimento,0)) - SUM(ISNULL(ValorRetirada,0)) As ValorDisponivel From RendimentoAplicacao Where AplicacaoID = ? GROUP BY AplicacaoID";
        double valorDisponivel = 0;
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();           
            this.stmtSelect = this.conexao.prepareStatement(sql);
            
            this.stmtSelect.setInt(1, aplicacao.getCodigo());        
            this.rs = this.stmtSelect.executeQuery();

            while(this.rs.next()){
                valorDisponivel = (this.rs.getDouble("ValorDisponivel"));
            }       
        }catch(SQLException ex){
            logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o valor dispon�vel para retirada", "Erro", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.rs != null) this.rs.close();
                if (this.stmtSelect != null) this.stmtSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("AplicacaoDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return valorDisponivel;
    } 
}
