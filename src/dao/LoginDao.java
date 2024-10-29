
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.Login;


public class LoginDao {
    
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
  
    //Adiciona o login na tabela de Login
    public void adicionarLogin(int codUsuario){
        
        try{  
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "INSERT INTO Login (Usuario,DataCadastro)VALUES (?,GETDATE())";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1,codUsuario);
            ps.execute();
             
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o login", "Erro 005", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void alterarSenha(String senha, int codUsuario){
            
        try{    
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "UPDATE Usuarios SET Senha=?" + " WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, senha);
            ps.setInt(2, codUsuario);

            ps.executeUpdate();
            ps.close();
            conexao.close();   
            
            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a senha ", "Erro 006", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
  
    //Consultar para validar os dados do login
    public Login consultarLogin(String usuario){

        String sql = "SELECT Codigo, Usuario, HashSenha, SaltSenha FROM Usuarios WHERE Usuario=?";
        Login login = new Login();
              
        try{           
            conexao = Conexao.getDataSource().getConnection();
            
            ps = conexao.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            while(rs.next()){              
                login.setCodUsuario(rs.getInt("Codigo"));
                login.setUsuario(rs.getString("Usuario"));
                login.setHashSenha(rs.getString("HashSenha"));
                login.setSaltSenha(rs.getString("SaltSenha"));
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar validar os dados do login", "Erro 004", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return login;
    } 
    
    
}




    