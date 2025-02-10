
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.FormaPagto;


public class FormaPagtoDao {
    
    private final LogsDao logsDao = new LogsDao();
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    //Consulta para popular o JComboBox
    public List<FormaPagto> consultarFormaPagto(){
      
        List<FormaPagto> listaFormaPagto = new ArrayList<>();
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "SELECT * FROM FormasPagamento ORDER BY Descricao";
            ps = conexao.prepareStatement(sql);           
            rs = ps.executeQuery();

            while(rs.next()){
                FormaPagto formasPagto = new FormaPagto();
                formasPagto.setCodigo(rs.getInt("Codigo"));
                formasPagto.setNome(rs.getString("Descricao"));

                listaFormaPagto.add(formasPagto);
            }
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar as formas de pagamento", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaFormaPagto;
    }
    
    public void adicionar(FormaPagto formaPagto){
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "INSERT INTO FormasPagamento (Descricao,DataCadastro)VALUES (?,GETDATE())";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, formaPagto.getNome());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Forma de Pagamento cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a forma de pagamento", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void alterar(FormaPagto formaPagto){

        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "UPDATE FormasPagamento SET Descricao=?" + " WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, formaPagto.getNome());
            ps.setInt(2, formaPagto.getCodigo());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Forma de Pagamento "+formaPagto.getNome()+" alterada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a forma de pagamento "+formaPagto.getNome(), "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
 
    }
    
    public List<FormaPagto> consultarFormaPagto(String formaPagto){

        List<FormaPagto> listaFormaPagto = new ArrayList<>();

        String sql = "SELECT * FROM FormasPagamento WHERE (? IS NULL OR Codigo LIKE ?) OR (? IS NULL OR Descricao LIKE ?)";
   
        try{
            conexao = Conexao.getDataSource().getConnection();           
            ps = conexao.prepareStatement(sql);
            
            if (formaPagto != null) {
                ps.setString(1,  "%" + formaPagto + "%");
                ps.setString(2,  "%" + formaPagto + "%");
                ps.setString(3,  "%" + formaPagto + "%");
                ps.setString(4,  "%" + formaPagto + "%");
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
                ps.setNull(2, java.sql.Types.INTEGER);
                ps.setNull(3, java.sql.Types.INTEGER);
                ps.setNull(4, java.sql.Types.INTEGER);
            }

            rs = ps.executeQuery();

            while(rs.next()){
                FormaPagto pagto = new FormaPagto();
                pagto.setCodigo(rs.getInt("Codigo"));
                pagto.setNome(rs.getString("Descricao"));
                pagto.setDataCadastro(rs.getDate("DataCadastro"));

                listaFormaPagto.add(pagto);
            }
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar as formas de pagamento", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaFormaPagto;
    }
    
    public void remover(FormaPagto formaPagto){

        try{   
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "DELETE FROM FormasPagamento WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, formaPagto.getCodigo());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Forma de Pagamento "+formaPagto.getNome()+" excluída com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir a forma de pagamento "+formaPagto.getNome(), "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    
}
