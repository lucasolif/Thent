
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
import model.Biblioteca;
import model.Livro;
import model.RegistroBiblioteca;


public class RegistroBibliotecaDao {
    
    private Connection conexao = null;
    private PreparedStatement selectStmt = null;
    private PreparedStatement insertStmt = null;
    private PreparedStatement updateStmt = null;
    private ResultSet rs = null;
    
    public void adicionarLivroBiblioteca(Livro livro, Biblioteca biblioteca, Integer qtd){

        String sqlInsert = "INSERT INTO RegistroBiblioteca (Biblioteca,Livro,Quantidade)VALUES (?,?,?)";
        String sqlSelect = "SELECT * FROM RegistroBiblioteca WHERE Biblioteca=? AND Livro=?";
        String sqlUpdate = "UPDATE RegistroBiblioteca SET Quantidade = Quantidade + 1 WHERE Biblioteca=? AND Livro=?";

        try{
            this.conexao = Conexao.getDataSource().getConnection();  
            
            //Consulta para verificar se o livro já está na biblioteca
            this.selectStmt = this.conexao.prepareStatement(sqlSelect);       
            this.selectStmt.setInt(1,  biblioteca.getCodigo());
            this.selectStmt.setInt(1,  livro.getCodInterno());         
            this.rs = selectStmt.executeQuery();
            
            if(rs.next()){
                this.updateStmt = this.conexao.prepareStatement(sqlUpdate);                
                this.updateStmt.setInt(1,  biblioteca.getCodigo());
                this.updateStmt.setInt(1,  livro.getCodInterno());
                this.updateStmt.executeUpdate();                
            }else{
                //Se o livro não estiver, ele adiciona
                this.insertStmt = this.conexao.prepareStatement(sqlInsert);         
                this.insertStmt.setInt(1,  biblioteca.getCodigo());
                this.insertStmt.setInt(1,  livro.getCodInterno());
                this.insertStmt.setInt(1,  qtd);
                this.insertStmt.executeQuery();
            }
            JOptionPane.showMessageDialog(null, "Livro adicionado na biblioteca com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar adicionar o livro na biblioteca", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.updateStmt != null) this.updateStmt.close();
                if (this.insertStmt != null) this.insertStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public List<RegistroBiblioteca> consultarRegistroBiblioteca(RegistroBiblioteca rgBiblioteca){
        
        List<RegistroBiblioteca> listaLivros = new ArrayList();
            
        try {                             
            String sqlSelect = "SELECT LV.Codigo AS CodInternoLivro, " +
            "LV.CodLivro AS CodigoLivro, " +
            "LV.Nome AS NomeLivro, " +
            "LV.Volume AS VolumeLivro, " +
            "LV.Ativo AS AtivoInativo, " +
            "AUT.Codigo AS CodigoAutor, " +
            "AUT.Nome AS NomeAutor, " +
            "RB.Quantidade AS QuantidadeLivro, " +
            "B.Codigo AS CodigoBiblioteca, " +
            "B.NomeBiblioteca AS NomeBiblioteca " +
            "FROM RegistroBiblioteca AS RB " +
            "INNER JOIN Livros AS LV ON LV.Codigo = RB.Livro " +
            "INNER JOIN Autores AS AUT ON AUT.Codigo = LV.Autor " +
            "INNER JOIN Bibliotecas AS B ON B.Codigo = RB.Biblioteca "+
            "WHERE (? IS NULL OR BL.Livro = ?) " +
            "AND (? IS NULL OR RB.Biblioteca = ?) " +
            "AND (? IS NULL OR LV.Autor = ?) " +
            "AND (? IS NULL OR LV.Ativo = ?) " +
            "AND (? IS NULL OR LV.Editora = ?) " +
            "AND (? IS NULL OR LV.Volume = ?)";
   

            this.conexao = Conexao.getDataSource().getConnection();         
            this.selectStmt = this.conexao.prepareStatement(sqlSelect);  

            if (rgBiblioteca.getLivro().getCodInterno() != null) {
                this.selectStmt.setInt(1, rgBiblioteca.getLivro().getCodInterno());
                this.selectStmt.setInt(2, rgBiblioteca.getLivro().getCodInterno());
            } else {
                this.selectStmt.setNull(1, java.sql.Types.INTEGER);
                this.selectStmt.setNull(2, java.sql.Types.INTEGER);
            }

            if (rgBiblioteca.getCodigo() != null) {
                this.selectStmt.setInt(3, rgBiblioteca.getCodigo()); 
                this.selectStmt.setInt(4, rgBiblioteca.getCodigo());
            } else {
                this.selectStmt.setNull(3, java.sql.Types.INTEGER);
                this.selectStmt.setNull(4, java.sql.Types.INTEGER);
            }

            if (rgBiblioteca.getLivro().getAutor() != null) {
                this.selectStmt.setInt(5, rgBiblioteca.getLivro().getAutor().getCodigo());
                this.selectStmt.setInt(6, rgBiblioteca.getLivro().getAutor().getCodigo());
            } else {
                this.selectStmt.setNull(5, java.sql.Types.INTEGER);
                this.selectStmt.setNull(6, java.sql.Types.INTEGER);
            }
            
            if (rgBiblioteca.getLivro().getStatus() != null) {
                this.selectStmt.setInt(7, rgBiblioteca.getLivro().getStatus());
                this.selectStmt.setInt(8, rgBiblioteca.getLivro().getStatus());
            } else {
                this.selectStmt.setNull(7, java.sql.Types.INTEGER);
                this.selectStmt.setNull(8, java.sql.Types.INTEGER);
            }

            if (rgBiblioteca.getLivro().getEditora() != null) {
                this.selectStmt.setInt(9, rgBiblioteca.getLivro().getEditora().getCodigo());
                this.selectStmt.setInt(10, rgBiblioteca.getLivro().getEditora().getCodigo());
            } else {
                this.selectStmt.setNull(9, java.sql.Types.INTEGER);
                this.selectStmt.setNull(10, java.sql.Types.INTEGER);
            }

            if (rgBiblioteca.getLivro().getVolume() != null) {
                this.selectStmt.setInt(11, rgBiblioteca.getLivro().getVolume());
                this.selectStmt.setInt(12, rgBiblioteca.getLivro().getVolume());
            } else {
                this.selectStmt.setNull(11, java.sql.Types.INTEGER);
                this.selectStmt.setNull(12, java.sql.Types.INTEGER);
            }

            // Executando a consulta
            this.rs = this.selectStmt.executeQuery();

            // Iterando sobre os resultados
            while (rs.next()) {
                //Convertendo as datas do tipo Date para String
        
                Livro livro = new Livro();
                Autor autor = new Autor();
                Biblioteca biblioteca = new Biblioteca();
                RegistroBiblioteca rgBibli =  new RegistroBiblioteca();
              
                autor.setCodigo(rs.getInt("CodigoAutor"));
                autor.setNome(rs.getString("NomeAutor"));
                livro.setCodInterno(rs.getInt("CodInternoLivro"));
                livro.setCodLivro(rs.getInt("CodigoLivro"));                
                livro.setNomeLivro(rs.getString("NomeLivro"));
                livro.setVolume(rs.getInt("VolumeLivro"));
                livro.setStatus(rs.getInt("AtivoInativo"));
                livro.setAutor(autor);
                biblioteca.setCodigo(rs.getInt("CodigoBiblioteca"));
                biblioteca.setNomeBiblioteca(rs.getString("CodigoBiblioteca"));
                
                rgBibli.setLivro(livro);
                rgBibli.setBiblioteca(biblioteca);
                rgBibli.setQtdLivro(rs.getInt("QuantidadeLivro"));

                listaLivros.add(rgBibli);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os dados da biblioteca", "Erro 001", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Fechando recursos
            try {
                if (rs != null) rs.close();
                if (insertStmt != null) insertStmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {

            }
        }        
        return listaLivros;      
    }   
    
    public List<Livro> consultarLivroDisponivelBiblioteca(Biblioteca biblioteca){
        
        List<Livro> listaLivros = new ArrayList<>();

        String sqlSelect = "SELECT " +
            "L.Codigo AS CodInterno, " +
            "L.CodLivro AS CodLivro, " +
            "L.Nome AS NomeLivro, " +
            "L.Volume AS VolumeLivro, " +
            "A.Codigo AS CodigoAutor, " +
            "A.Nome AS NomeAutor " +
            "FROM RegistroBiblioteca AS RB " +
            "INNER JOIN Livros AS L ON L.Codigo = RB.Livro " +
            "INNER JOIN Autores AS A ON A.Codigo = L.Autor " +
            "WHERE L.Ativo = 1 " +
            "AND RB.Biblioteca = ? " +
            "AND RB.Quantidade > 0";       
        try{
            this.conexao = Conexao.getDataSource().getConnection();            
            this.selectStmt = this.conexao.prepareStatement(sqlSelect);
               
            this.selectStmt.setInt(1,  biblioteca.getCodigo());
            this.rs = this.selectStmt.executeQuery();

            while(rs.next()){     
                Livro livro = new Livro();
                Autor autor = new Autor();
                autor.setCodigo(this.rs.getInt("CodigoAutor"));
                autor.setNome(this.rs.getString("NomeAutor"));
                livro.setCodInterno(this.rs.getInt("CodInterno"));
                livro.setCodLivro(this.rs.getInt("CodLivro"));
                livro.setNomeLivro(this.rs.getString("NomeLivro"));
                livro.setVolume(this.rs.getInt("VolumeLivro"));
                livro.setAutor(autor);
                
                listaLivros.add(livro);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar o livro na biblioteca", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaLivros;
    }
}
