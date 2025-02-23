
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
    
    private final LogsDao logsDao = new LogsDao();
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private PreparedStatement insertStmt = null;
    private PreparedStatement updateStmt = null;
    private PreparedStatement selectStmt = null;
    private ResultSet rs = null;
    
    public void cadastrarLivro(Livro livro){
        
        String sql= "INSERT INTO Livros (CodLivro,Nome,Volume,Autor,Caracteristica,Editora,Ano,DataCadastro,Ativo)VALUES (?,?,?,?,?,?,?,GETDATE(),?)";
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();            
            this.insertStmt = this.conexao.prepareStatement(sql);

            this.insertStmt.setInt(1, livro.getCodLivro());
            this.insertStmt.setString(2, livro.getNomeLivro());
            this.insertStmt.setInt(3, livro.getVolume());
            this.insertStmt.setInt(4, livro.getAutor().getCodigo());
            this.insertStmt.setString(5, livro.getCaracteristica());
            this.insertStmt.setInt(6, livro.getEditora().getCodigo());
            this.insertStmt.setInt(7, livro.getAnoPublicacao());
            this.insertStmt.setInt(8, livro.getStatus());         
            this.insertStmt.execute();
            
            JOptionPane.showMessageDialog(null, "Livro Cadastrado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            logsDao.gravaLogsErro("LivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
            if (ex.getErrorCode() == 2627) { // Código de erro para violação de UNIQUE
                JOptionPane.showMessageDialog(null, "Já existe um livro cadastrado com esse código", "Erro 001", JOptionPane.ERROR_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o livro.", "Erro 001", JOptionPane.ERROR_MESSAGE);
            }            
        }finally{
            // Fechar recursos
            try{
                if (this.insertStmt != null) this.insertStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("LivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void alterarLivro(Livro livro){
        
        String sql= "UPDATE Livros SET Nome=?,Volume=?,Autor=?,Caracteristica=?,Editora=?,Ano=?,Ativo=? "
        + "WHERE Codigo=? AND CodLivro=?";          

       try{
            this.conexao = Conexao.getDataSource().getConnection();
            this.updateStmt = this.conexao.prepareStatement(sql);

            this.updateStmt.setString(1, livro.getNomeLivro());
            this.updateStmt.setInt(2, livro.getVolume());
            this.updateStmt.setInt(3, livro.getAutor().getCodigo());
            this.updateStmt.setString(4, livro.getCaracteristica());
            this.updateStmt.setInt(5, livro.getEditora().getCodigo());
            this.updateStmt.setInt(6, livro.getAnoPublicacao());
            this.updateStmt.setInt(7, livro.getStatus());
            this.updateStmt.setInt(8, livro.getCodInterno());
            this.updateStmt.setInt(9, livro.getCodLivro());          
            this.updateStmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Livro alterado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);           
        }catch (SQLException ex) {
            logsDao.gravaLogsErro("LivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o livro", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.updateStmt != null) this.updateStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("LivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public List<Livro> consultarLivro(String busca){

        String sql = "SELECT AUT.Nome As NomeAutor, AUT.Codigo As CodAutor, EDT.Nome As NomeEditora, EDT.Codigo AS CodEditora, * FROM Livros AS LV "
        + "INNER JOIN Autores AUT ON AUT.Codigo = LV.Autor "
        + "INNER JOIN Editoras EDT ON EDT.Codigo = LV.Editora "
        + "WHERE (? IS NULL OR LV.CodLivro LIKE ?) OR (? IS NULL OR LV.Nome LIKE ?) OR (? IS NULL OR AUT.Nome LIKE ?)";
 
        List<Livro> listaLivros = new ArrayList<>();
 
        try{
            this.conexao = Conexao.getDataSource().getConnection();        
            this.selectStmt = this.conexao.prepareStatement(sql);
                 
            if (busca != null) {
                this.selectStmt.setString(1,  "%" + busca + "%");
                this.selectStmt.setString(2,  "%" + busca + "%");
                this.selectStmt.setString(3,  "%" + busca + "%");
                this.selectStmt.setString(4,  "%" + busca + "%");
                this.selectStmt.setString(5,  "%" + busca + "%");
                this.selectStmt.setString(6,  "%" + busca + "%");
            } else {
                this.selectStmt.setNull(1, java.sql.Types.INTEGER);
                this.selectStmt.setNull(2, java.sql.Types.INTEGER);
                this.selectStmt.setNull(3, java.sql.Types.INTEGER);
                this.selectStmt.setNull(4, java.sql.Types.INTEGER);
                this.selectStmt.setNull(5, java.sql.Types.INTEGER);
                this.selectStmt.setNull(6, java.sql.Types.INTEGER);
            }
            this.rs = this.selectStmt.executeQuery();

            while(this.rs.next()){
                Livro livro = new Livro();
                Autor autor = new Autor();
                Editora editora = new Editora();
                autor.setCodigo(this.rs.getInt("CodAutor"));
                autor.setNome(this.rs.getString("NomeAutor"));
                editora.setCodigo(this.rs.getInt("CodEditora"));
                editora.setNome(this.rs.getString("NomeEditora"));
                livro.setCodInterno(this.rs.getInt("Codigo"));
                livro.setCodLivro(this.rs.getInt("CodLivro"));
                livro.setNomeLivro(this.rs.getString("Nome"));
                livro.setVolume(this.rs.getInt("Volume"));
                livro.setCaracteristica(this.rs.getString("Caracteristica"));
                livro.setAnoPublicacao(this.rs.getInt("Ano"));
                livro.setStatus(this.rs.getInt("Ativo"));
                livro.setAutor(autor);
                livro.setEditora(editora);

                listaLivros.add(livro);
            }
            this.selectStmt.execute();
          
        }catch(SQLException ex){
            logsDao.gravaLogsErro("LivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao consultar o livro", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("LivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaLivros;
    }
    
    //Consultar para popular o JComboBox
    public List<Livro> consultarLivros(){
        
        List<Livro> listaLivros = new ArrayList<>();
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();
            
            String sql = "SELECT A.Codigo AS CodAutor, A.Nome AS NomeLivro, * "
                + "FROM Livros AS L "                  
                + "INNER JOIN Autores AS A ON A.Codigo = L.Autor "
                + "Order By L.Nome ";
            this.selectStmt = this.conexao.prepareStatement(sql);           
            this.rs = this.selectStmt.executeQuery();

            while(this.rs.next()){
                Livro livro = new Livro();
                Autor autor = new Autor();
                autor.setCodigo(this.rs.getInt("CodAutor"));
                autor.setNome(this.rs.getString("NomeLivro"));
                livro.setCodInterno(this.rs.getInt("Codigo"));
                livro.setCodLivro(this.rs.getInt("CodLivro"));
                livro.setNomeLivro(this.rs.getString("Nome"));
                livro.setVolume(this.rs.getInt("Volume"));
                livro.setAutor(autor);
 
                listaLivros.add(livro);
            }
        }catch (SQLException ex) {
            logsDao.gravaLogsErro("LivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar livros", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("LivroDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaLivros;
    }
    
}
