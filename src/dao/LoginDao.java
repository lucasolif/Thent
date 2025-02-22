
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.Igreja;
import model.Usuario;


public class LoginDao {
    
    private final LogsDao logsDao = new LogsDao();
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
  
    //Adiciona o login na tabela de Login
    public void adicionarLogin(int codUsuario){
        
        try{  
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "INSERT INTO LogsLogin (Usuario,DataCadastro)VALUES (?,GETDATE())";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1,codUsuario);
            ps.execute();
             
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o login", "Erro 005", JOptionPane.ERROR_MESSAGE);
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
  
    //Consultar para validar os dados do login
    public Usuario consultarLogin(String usuario){

        String sql = "SELECT Codigo, Usuario, HashSenha, SaltSenha, Igreja FROM Usuarios WHERE Usuario=? AND Ativo = 1";
        Usuario userLogin = new Usuario();
              
        try{           
            conexao = Conexao.getDataSource().getConnection();
            
            ps = conexao.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            while(rs.next()){              
                Igreja igreja = new Igreja();
                igreja.setCodigo(rs.getInt("Igreja"));
                userLogin.setCodigo(rs.getInt("Codigo"));
                userLogin.setLogin(rs.getString("Usuario"));
                userLogin.setHashSenha(rs.getString("HashSenha"));
                userLogin.setSaltSenha(rs.getString("SaltSenha"));
                userLogin.setIgreja(igreja);
            }
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar validar os dados do login", "Erro 004", JOptionPane.ERROR_MESSAGE);
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
        return userLogin;
    } 

}




    