
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.Igreja;
import model.Usuario;


public class UsuarioDao {
    
    Connection conexao = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void adicionar(Usuario usuario){
        
        String sql= "INSERT INTO Usuarios (Nome,Email,Celular,Usuario,Igreja,DataCadastro,Ativo,HashSenha,SaltSenha)VALUES (?,?,?,?,?,GETDATE(),1,?,?)";
             
        try{
            conexao = Conexao.getDataSource().getConnection();
                     
            ps = conexao.prepareStatement(sql);
            ps.setString(1,usuario.getNome());
            ps.setString(2,usuario.getEmail());
            ps.setString(3,usuario.getCelular());
            ps.setString(4,usuario.getLogin());
            ps.setInt(5,usuario.getIgreja().getCodigo());   
            ps.setString(6,usuario.getHashSenha());
            ps.setString(7,usuario.getSaltSenha());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            if (ex.getErrorCode() == 2627) { // Código de erro para violação de UNIQUE
                JOptionPane.showMessageDialog(null, "Já existe um usuário com esse Login", "Erro 001", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o usuário", "Erro 001", JOptionPane.ERROR_MESSAGE);
            }
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {;
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    
    public void alterar(Usuario usuario){
             
        try{            
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "UPDATE Usuarios SET Email=?,Celular=?,Igreja=?,Ativo=?" + " WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setString(1,usuario.getEmail());
            ps.setString(2,usuario.getCelular());
            ps.setInt(3,usuario.getIgreja().getCodigo());
            ps.setInt(4,usuario.getAtivo());
            ps.setInt(5,usuario.getCodigo());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuário "+usuario.getLogin()+" alterada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o usuário "+usuario.getLogin(), "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
    } 
    
    public List<Usuario> consultar(String usuario){
        List<Usuario> listaUsuarios = new ArrayList<>();
         //Estanciando o objeto para consultarIgreja a igreja do usuário

        String sql = "SELECT I.Codigo AS CodIgreja, I.NomeIgreja AS NomeIgreja, * FROM Usuarios AS U "
        + "INNER JOIN Igrejas AS I ON I.Codigo = U.Igreja "       
        + "WHERE ((? IS NULL OR U.Codigo LIKE ?) OR (? IS NULL OR U.Nome LIKE ?) OR (? IS NULL OR U.Usuario LIKE ?))"
        + "AND Ativo = 1";
    
        try{
            conexao = Conexao.getDataSource().getConnection();            
            ps = conexao.prepareStatement(sql);
            
            if (usuario != null) {
                ps.setString(1,  "%" + usuario + "%");
                ps.setString(2,  "%" + usuario + "%");
                ps.setString(3,  "%" + usuario + "%");
                ps.setString(4,  "%" + usuario + "%");    
                ps.setString(5,  "%" + usuario + "%");
                ps.setString(6,  "%" + usuario + "%"); 
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
                ps.setNull(2, java.sql.Types.INTEGER);
                ps.setNull(3, java.sql.Types.INTEGER);
                ps.setNull(4, java.sql.Types.INTEGER);
                ps.setNull(5, java.sql.Types.INTEGER);
                ps.setNull(6, java.sql.Types.INTEGER);                    
            }
            
            rs = ps.executeQuery();

            while(rs.next()){
                Usuario user = new Usuario();
                Igreja igreja = new Igreja();
                igreja.setCodigo(rs.getInt("CodIgreja"));
                igreja.setNome(rs.getString("NomeIgreja"));
                user.setCodigo(rs.getInt("Codigo"));
                user.setNome(rs.getString("Nome"));
                user.setEmail(rs.getString("Email"));
                user.setCelular(rs.getString("Celular"));
                user.setLogin(rs.getString("Usuario"));                
                user.setAtivo(rs.getInt("Ativo"));
                user.setIgreja(igreja);
                user.setHashSenha(rs.getString("HashSenha"));
                user.setSaltSenha(rs.getString("SaltSenha"));

                listaUsuarios.add(user);
            }          
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o usuário", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaUsuarios;
    }
    
    public void remover(int usuario){
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "DELETE FROM Usuarios WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, usuario);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuário excluída com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o usuário", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

}
