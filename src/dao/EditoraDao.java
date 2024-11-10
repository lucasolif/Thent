
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.Editora;

public class EditoraDao {
    
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public void cadastrarEditoras(Editora editora){
        
        String sqlInsert = "INSERT INTO Editoras (Nome,DataCadastro) VALUES (?,GETDATE())";
        
        try{
            conexao = Conexao.getDataSource().getConnection();
               
            ps = conexao.prepareStatement(sqlInsert);
            ps.setString(1, editora.getNome());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Editora "+editora.getNome().toUpperCase()+" cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            if (ex.getErrorCode() == 2627) { // Código de erro para violação de UNIQUE
                JOptionPane.showMessageDialog(null, "A editora "+editora.getNome().toUpperCase()+" já está cadastrada", "Erro 001", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a nova publicadora", "Erro 001", JOptionPane.ERROR_MESSAGE);
            }    
        }
        finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void alterarEditora(Editora editora){
        
        String sql= "UPDATE Editoras SET Nome=?" + " WHERE Codigo=?";
         
        try{          
            conexao = Conexao.getDataSource().getConnection();
                     
            ps = conexao.prepareStatement(sql);
            ps.setString(1, editora.getNome());
            ps.setInt(2, editora.getCodigo());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Editora "+editora.getNome().toUpperCase()+" alterado(a) com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a editora "+editora.getNome().toUpperCase(), "Erro 001", JOptionPane.ERROR_MESSAGE);
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
    
    public List<Editora> consultarEditora(String buscaEditora){
        List<Editora> listaEditora = new ArrayList<>();

        String sql = "SELECT * FROM Editoras "
        + "WHERE (? IS NULL OR Codigo LIKE ?) OR (? IS NULL OR Nome LIKE ?)";

        try{
            conexao = Conexao.getDataSource().getConnection();           
            ps = conexao.prepareStatement(sql);
            
            if (buscaEditora != null) {
                ps.setString(1,  "%" + buscaEditora + "%");
                ps.setString(2,  "%" + buscaEditora + "%");
                ps.setString(3,  "%" + buscaEditora + "%");
                ps.setString(4,  "%" + buscaEditora + "%");
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
                ps.setNull(2, java.sql.Types.INTEGER);
                ps.setNull(3, java.sql.Types.INTEGER);
                ps.setNull(4, java.sql.Types.INTEGER);
            }

            rs = ps.executeQuery();

            while(rs.next()){
                Editora editora = new Editora();
                editora.setCodigo(rs.getInt("Codigo"));
                editora.setNome(rs.getString("Nome"));

                listaEditora.add(editora);
            }
            
            ps.execute();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar a editora "+buscaEditora.toUpperCase(), "Erro 001", JOptionPane.ERROR_MESSAGE);
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

        return listaEditora;
    }
    
    public void removerEditora(Editora editora){
        
        try{          
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "DELETE FROM Editoras WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, editora.getCodigo());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Editora "+editora.getNome().toUpperCase()+" excluída com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir a editora "+editora.getNome().toUpperCase(), "Erro 001", JOptionPane.ERROR_MESSAGE);
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
    
    //Consultar para popular o JComboBox
    public List<Editora> consultarEditoras(){
        
        List<Editora> listaEditoras = new ArrayList<>();
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "SELECT * FROM Editoras ORDER BY Nome";
            ps = conexao.prepareStatement(sql);           
            rs = ps.executeQuery();

            while(rs.next()){
                Integer codPublic = rs.getInt("Codigo");
                String nomePublic = rs.getString("Nome");
                
                Editora publicadora = new Editora();
                publicadora.setCodigo(codPublic);
                publicadora.setNome(nomePublic);
                
                listaEditoras.add(publicadora);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar as editoras", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaEditoras;
    }
}
