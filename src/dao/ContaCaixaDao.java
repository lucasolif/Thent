
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.ContaCaixa;
import model.Igreja;


public class ContaCaixaDao {
    
    private final LogsDao logsDao = new LogsDao();
    private Connection conexao = null;
    private PreparedStatement insertStmt = null;
    private PreparedStatement updateStmt = null;
    private PreparedStatement selectStmt = null;
    private PreparedStatement deleteStmt = null;
    private ResultSet rs = null;
    
    public void adicionar(ContaCaixa contaCaixa){
 
        try{
            this.conexao = Conexao.getDataSource().getConnection();
            
            String sql= "INSERT INTO ContasCaixa (Descricao,DataCadastro,Status,Igreja,ConstaRelatorioPrestacao)VALUES (?,GETDATE(),?,?,?)";
            this.insertStmt = this.conexao.prepareStatement(sql);
            this.insertStmt.setString(1,contaCaixa.getNome());
            this.insertStmt.setInt(2,contaCaixa.getStatus());
            this.insertStmt.setInt(3,contaCaixa.getIgreja().getCodigo());
            this.insertStmt.setInt(4,contaCaixa.getConstaRelatorio());
            this.insertStmt.execute();
            
            JOptionPane.showMessageDialog(null, "Conta Caixa cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);        
        }catch(SQLException ex){
            //Grava o log de erro na tabela de LogsErro
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a Conta Caixa", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.insertStmt != null) this.insertStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                //Grava o log de erro na tabela de LogsErro
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    
    public void alterar(ContaCaixa contaCaixa){
        
        try{          
            this.conexao = Conexao.getDataSource().getConnection();
            
            String sql= "UPDATE ContasCaixa SET Descricao=?,Status=?,ConstaRelatorioPrestacao=? " + "WHERE Codigo=?";
            this.updateStmt = this.conexao.prepareStatement(sql);
            this.updateStmt.setString(1, contaCaixa.getNome());
            this.updateStmt.setInt(2, contaCaixa.getStatus());
            this.updateStmt.setInt(3,contaCaixa.getConstaRelatorio());
            this.updateStmt.setInt(4, contaCaixa.getCodigo());
            
            this.updateStmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Conta caixa "+contaCaixa.getNome().toUpperCase()+" alterada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);        
        }catch(SQLException ex){
            //Grava o log de erro na tabela de LogsErro
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a Conta Caixa "+contaCaixa.getNome().toUpperCase(), "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.updateStmt != null) this.updateStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                //Grava o log de erro na tabela de LogsErro
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());  
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
    }
    
    //Consulta para popular o JComboBox
    public List<ContaCaixa> consultarContaCaixa(){
        String sql = "SELECT * FROM ContasCaixa WHERE Status = 1 ORDER BY Descricao ";  
        List<ContaCaixa> listaCaixas = new ArrayList<>();
 
        try{
            this.conexao = Conexao.getDataSource().getConnection();         
            this.selectStmt = this.conexao.prepareStatement(sql);
            this.rs = this.selectStmt.executeQuery();

            while(rs.next()){
                ContaCaixa caixa = new ContaCaixa();
                caixa.setCodigo(this.rs.getInt("Codigo"));
                caixa.setNome(this.rs.getString("Descricao"));
                caixa.setStatus(this.rs.getInt("status"));
                caixa.setConstaRelatorio(this.rs.getInt("ConstaRelatorioPrestacao"));
                caixa.setDataCadastro(this.rs.getDate("DataCadastro"));

                listaCaixas.add(caixa);
            }
          
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage()); 
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar as Contas Caixa", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage()); 
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaCaixas;
    }
    
    //Consultar para mostra na tabela todos os caixas cadastrados
    public List<ContaCaixa> consultar(String conta){
        
        List<ContaCaixa> listaCaixas = new ArrayList<>();
        String sql = "Select CC.*, " +
        "(Select NomeIgreja From Igrejas As I Where I.Codigo = CC.Igreja) As NomeIgreja " +
        "From ContasCaixa As CC " +
        "WHERE (? IS NULL OR CC.Codigo LIKE ?) OR (? IS NULL OR CC.Descricao LIKE ?)";

        try{
            this.conexao = Conexao.getDataSource().getConnection();           
            this.selectStmt = this.conexao.prepareStatement(sql);
            
            if (conta != null) {
                this.selectStmt.setString(1,  "%" + conta + "%");
                this.selectStmt.setString(2,  "%" + conta + "%");
                this.selectStmt.setString(3,  "%" + conta + "%");
                this.selectStmt.setString(4,  "%" + conta + "%");
            } else {
                this.selectStmt.setNull(1, java.sql.Types.INTEGER);
                this.selectStmt.setNull(2, java.sql.Types.INTEGER);
                this.selectStmt.setNull(3, java.sql.Types.INTEGER);
                this.selectStmt.setNull(4, java.sql.Types.INTEGER);
            }
            this.rs = this.selectStmt.executeQuery();

            while(this.rs.next()){
                ContaCaixa caixa = new ContaCaixa();
                Igreja igreja = new Igreja();
                igreja.setCodigo(this.rs.getInt("Igreja"));
                igreja.setNome(this.rs.getString("NomeIgreja"));
                caixa.setCodigo(this.rs.getInt("Codigo"));
                caixa.setNome(this.rs.getString("Descricao"));
                caixa.setConstaRelatorio(this.rs.getInt("ConstaRelatorioPrestacao"));
                caixa.setStatus(this.rs.getInt("Status"));
                caixa.setDataCadastro(this.rs.getDate("DataCadastro"));
                caixa.setIgreja(igreja);

                listaCaixas.add(caixa);
            }
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar a Conta Caixa", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaCaixas;
    }
    
    public void remover(ContaCaixa contaCaixa){
        
        String sql = "DELETE FROM ContasCaixa WHERE Codigo=?";
        
        try{          
            this.conexao = Conexao.getDataSource().getConnection();
           
            this.deleteStmt = this.conexao.prepareStatement(sql);
            this.deleteStmt.setInt(1, contaCaixa.getCodigo());           
            this.deleteStmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Conta Caixa "+contaCaixa.getNome().toUpperCase()+" excluída com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);     
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir a Conta Caixa "+contaCaixa.getNome().toUpperCase(), "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.deleteStmt != null) this.deleteStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    
}
