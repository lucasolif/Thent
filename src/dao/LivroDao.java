
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
import model.Editora;
import model.Livro;

public class LivroDao {
    
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public void cadastrarLivro(Livro livro){

        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "INSERT INTO Livros (CodLivro,Nome,Volume,Autor,Caracteristica,Editora,Ano,DataCadastro,Ativo)VALUES (?,?,?,?,?,?,?,GETDATE(),?)";
            ps = conexao.prepareStatement(sql);

            ps.setInt(1, livro.getCodLivro());
            ps.setString(2, livro.getNomeLivro());
            ps.setInt(3, livro.getVolume());
            ps.setInt(4, livro.getAutor().getCodigo());
            ps.setString(5, livro.getCaracteristica());
            ps.setInt(6, livro.getEditora().getCodigo());
            ps.setInt(7, livro.getAnoPublicacao());
            ps.setInt(8, livro.getStatus());
            
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Livro Cadastrado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            if (ex.getErrorCode() == 2627) { // Código de erro para violação de UNIQUE
                JOptionPane.showMessageDialog(null, "Já existe um livro cadastrado com esse código", "Erro 001", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o livro.", "Erro 001", JOptionPane.ERROR_MESSAGE);
            }
            
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
    
    public void alterarLivro(Livro livro){

       try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "UPDATE Livros SET Nome=?,Volume=?,Autor=?,Caracteristica=?,Editora=?,Ano=?,Ativo=? "
            + "WHERE Codigo=? AND CodLivro=?";
            
            ps = conexao.prepareStatement(sql);

            ps.setString(1, livro.getNomeLivro());
            ps.setInt(2, livro.getVolume());
            ps.setInt(3, livro.getAutor().getCodigo());
            ps.setString(4, livro.getCaracteristica());
            ps.setInt(5, livro.getEditora().getCodigo());
            ps.setInt(6, livro.getAnoPublicacao());
            ps.setInt(7, livro.getStatus());
            ps.setInt(8, livro.getCodInterno());
            ps.setInt(9, livro.getCodLivro());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Livro alterado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o livro", "Erro 001", JOptionPane.ERROR_MESSAGE);
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
    
    public Livro consultarLivro(Integer codLivro){
        
        Livro livro = new Livro();

        String sql = "SELECT AUT.Nome As NomeAutor, EDT.Nome As NomeEditora, * FROM Livros AS LV "
        + "INNER JOIN Autores AUT ON AUT.Codigo = LV.Autor "
        + "INNER JOIN Editoras EDT ON EDT.Codigo = LV.Editora "
        + "WHERE (CodLivro=?)";
        
        try{
            conexao = Conexao.getDataSource().getConnection();            
            ps = conexao.prepareStatement(sql);
               
            ps.setInt(1,  codLivro);
            rs = ps.executeQuery();

            while(rs.next()){
                Autor autor = new Autor();
                autor.setCodigo(rs.getInt("Autor"));
                autor.setNome(rs.getString("NomeAutor"));
                Editora editora = new Editora();
                editora.setCodigo(rs.getInt("Editora"));
                editora.setNome(rs.getString("NomeEditora"));                
                livro.setCodInterno(rs.getInt("Codigo"));
                livro.setCodLivro(rs.getInt("CodLivro"));
                livro.setNomeLivro(rs.getString("Nome"));
                livro.setVolume(rs.getInt("Volume"));
                livro.setAutor(autor);
                livro.setCaracteristica(rs.getString("Caracteristica"));
                livro.setEditora(editora);
                livro.setAnoPublicacao(rs.getInt("Ano"));
                livro.setStatus(rs.getInt("Ativo"));

            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o livro", "Erro 001", JOptionPane.ERROR_MESSAGE);
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

        return livro;
    }
    
    //Consultar para popular o JComboBox
    public List<Livro> consultarLivros(){
        
        List<Livro> listaLivros = new ArrayList<>();
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "SELECT * FROM Livros Order By Nome";
            ps = conexao.prepareStatement(sql);           
            rs = ps.executeQuery();

            while(rs.next()){
                Livro livro = new Livro();
                livro.setCodInterno(rs.getInt("Codigo"));
                livro.setCodLivro(rs.getInt("CodLivro"));
                livro.setNomeLivro(rs.getString("Nome"));
                livro.setVolume(rs.getInt("Volume"));
 
                listaLivros.add(livro);
            }
        }catch (SQLException ex) {
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

        return listaLivros;
    }
    
}
