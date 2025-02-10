
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.Autor;


public class AutorDao {
    
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private final LogsDao logsDao = new LogsDao();
    
    public void cadastrarAutor(Autor autor){
        
        String sql = "INSERT INTO Autores(Nome,DataCadastro) VALUES(?,GETDATE())";
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();
            
            this.ps = this.conexao.prepareStatement(sql);
            this.ps.setString(1, autor.getNome());
            this.ps.execute();
            
            JOptionPane.showMessageDialog(null, "Autor(a) "+autor.getNome().toUpperCase()+" cadastrado(a) com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {            
            if (ex.getErrorCode() == 2627) { // Código de erro para violação de UNIQUE
                JOptionPane.showMessageDialog(null, "O autor "+autor.getNome().toUpperCase()+" já está cadastrado", "Erro 001", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o novo autor", "Erro 001", JOptionPane.ERROR_MESSAGE);
            }   
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
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
    
    public void alterarAutor(Autor autor){
        
        String sql= "UPDATE Autores SET Nome=?" + " WHERE Codigo=?";
         
        try{          
            conexao = Conexao.getDataSource().getConnection();
                     
            ps = conexao.prepareStatement(sql);
            ps.setString(1, autor.getNome());
            ps.setInt(2, autor.getCodigo());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Autor "+autor.getNome().toUpperCase()+" alterado(a) com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o(a) autor(a) "+autor.getNome().toUpperCase(), "Erro 001", JOptionPane.ERROR_MESSAGE);
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
    
    public List<Autor> consultarAutor(String buscaAutor){
        List<Autor> listaAutores = new ArrayList<>();

        String sql = "SELECT * FROM Autores "
        + "WHERE (? IS NULL OR Codigo LIKE ?) OR (? IS NULL OR Nome LIKE ?)";

        try{
            conexao = Conexao.getDataSource().getConnection();           
            ps = conexao.prepareStatement(sql);
            
            if (buscaAutor != null) {
                ps.setString(1,  "%" + buscaAutor + "%");
                ps.setString(2,  "%" + buscaAutor + "%");
                ps.setString(3,  "%" + buscaAutor + "%");
                ps.setString(4,  "%" + buscaAutor + "%");
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
                ps.setNull(2, java.sql.Types.INTEGER);
                ps.setNull(3, java.sql.Types.INTEGER);
                ps.setNull(4, java.sql.Types.INTEGER);
            }

            rs = ps.executeQuery();

            while(rs.next()){
                Autor autor = new Autor();
                autor.setCodigo(rs.getInt("Codigo"));
                autor.setNome(rs.getString("Nome"));

                listaAutores.add(autor);
            }
            
            ps.execute();
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o autor "+buscaAutor.toUpperCase(), "Erro 001", JOptionPane.ERROR_MESSAGE);
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

        return listaAutores;
    }
    
    public void removerAutor(Autor autor){
        
        try{          
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "DELETE FROM Autores WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, autor.getCodigo());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Autor "+autor.getNome().toUpperCase()+" excluído com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o autor "+autor.getNome().toUpperCase(), "Erro 001", JOptionPane.ERROR_MESSAGE);
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
    public List<Autor> consultarAutores(){
        
        List<Autor> listaAutores = new ArrayList<>();
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "SELECT * FROM Autores ORDER BY Nome";
            ps = conexao.prepareStatement(sql);           
            rs = ps.executeQuery();

            while(rs.next()){
                Integer codPublic = rs.getInt("Codigo");
                String nomePublic = rs.getString("Nome");
                
                Autor autor = new Autor();
                autor.setCodigo(codPublic);
                autor.setNome(nomePublic);
                
                listaAutores.add(autor);
            }
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar os autores", "Erro 001", JOptionPane.ERROR_MESSAGE);
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

        return listaAutores;
    }
}
