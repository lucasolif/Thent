
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
import model.Editora;
import model.Igreja;
import model.Livro;

public class BibliotecaDao {
    
    private Connection conexao = null;
    private PreparedStatement selectStmt = null;
    private PreparedStatement insertStmt = null;
    private PreparedStatement updateStmt = null;
    private ResultSet rs = null;
    
    public void adicionar(Livro livro, Igreja igreja, Integer qtd){
        
        String sqlConsulta = "SELECT * FROM Biblioteca WHERE Livro = ?";
        String sqlInsert = "INSERT INTO Biblioteca (Livro,Quantidade,DataCadastro,Igreja)VALUES (?,?,GETDATE(),?)";
        String sqlUpdate = "UPDATE Biblioteca SET Quantidade = ? WHERE Livro = ?";

        try{
            this.conexao = Conexao.getDataSource().getConnection();           
            this.selectStmt = this.conexao.prepareStatement(sqlConsulta);
            
            //Executa a query para consultar se o livro já existe
            this.selectStmt.setInt(1,  livro.getCodInterno());
            this.rs = selectStmt.executeQuery();
            
            if(rs.next()){
                final Integer qtdAtual = rs.getInt("Quantidade");
                final Integer qtdTotal = qtdAtual + qtd;
                
                this.updateStmt = this.conexao.prepareStatement(sqlUpdate);
                
                this.updateStmt.setInt(1, qtdTotal);
                this.updateStmt.setInt(2, livro.getCodInterno());
                this.updateStmt.executeUpdate();
                
            }else{
                this.insertStmt = this.conexao.prepareStatement(sqlInsert);

                this.insertStmt.setInt(1, livro.getCodInterno());
                this.insertStmt.setInt(2, qtd);
                this.insertStmt.setInt(3, igreja.getCodigo());
                this.insertStmt.execute();
            }

            JOptionPane.showMessageDialog(null, "Livro adicionado na biblioteca com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar adicionar o livro na biblioteca", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.insertStmt != null) this.insertStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public List<Biblioteca> consultarBiblioteca(Biblioteca biblioteca, String busca){
        
        List<Biblioteca> listaLivros = new ArrayList();
            
        try {                             
            String sql = "SELECT LV.Codigo AS CodigoInterno, " +
            "LV.CodLivro AS CodigoLivro, " +
            "LV.Nome AS NomeLivro, " +
            "LV.Volume AS VolumeLivro, " +
            "LV.Ativo AS Status, " +
            "AUT.Codigo AS CodigoAutor, " +
            "AUT.Nome AS NomeAutor, " +
            "IG.Codigo AS CodigoIgreja, " +
            "IG.NomeIgreja AS NomeIgreja, " +
            "BL.Quantidade AS QuantidadeLivro, " +
            "BL.Codigo AS CodigoBiblioteca " +
            "FROM Biblioteca AS BL " +
            "INNER JOIN Livros AS LV ON LV.Codigo = BL.Livro " +
            "INNER JOIN Autores AS AUT ON AUT.Codigo = LV.Autor " +
            "INNER JOIN Igrejas AS IG ON IG.Codigo = BL.Igreja "+
            "WHERE (? IS NULL OR BL.Livro = ?) " +
            "AND (? IS NULL OR BL.Igreja = ?) " +
            "AND (? IS NULL OR LV.Autor = ?) " +
            "AND (? IS NULL OR LV.Editora = ?) " +
            "AND (? IS NULL OR LV.Ativo = ?) " +
            "AND (? IS NULL OR LV.Volume = ?)";

            conexao = Conexao.getDataSource().getConnection();         
            insertStmt = conexao.prepareStatement(sql);  

            if (biblioteca.getLivro().getCodInterno() != null) {
                insertStmt.setInt(1, biblioteca.getLivro().getCodInterno());
                insertStmt.setInt(2, biblioteca.getLivro().getCodInterno());
            } else {
                insertStmt.setNull(1, java.sql.Types.INTEGER);
                insertStmt.setNull(2, java.sql.Types.INTEGER);
            }

            if (biblioteca.getIgreja() != null) {
                insertStmt.setInt(3, biblioteca.getIgreja().getCodigo()); 
                insertStmt.setInt(4, biblioteca.getIgreja().getCodigo());
            } else {
                insertStmt.setNull(3, java.sql.Types.INTEGER);
                insertStmt.setNull(4, java.sql.Types.INTEGER);
            }

            if (biblioteca.getLivro().getAutor() != null) {
                insertStmt.setInt(5, biblioteca.getLivro().getAutor().getCodigo());
                insertStmt.setInt(6, biblioteca.getLivro().getAutor().getCodigo());
            } else {
                insertStmt.setNull(5, java.sql.Types.INTEGER);
                insertStmt.setNull(6, java.sql.Types.INTEGER);
            }

            if (biblioteca.getLivro().getEditora() != null) {
                insertStmt.setInt(7, biblioteca.getLivro().getEditora().getCodigo());
                insertStmt.setInt(8, biblioteca.getLivro().getEditora().getCodigo());
            } else {
                insertStmt.setNull(7, java.sql.Types.INTEGER);
                insertStmt.setNull(8, java.sql.Types.INTEGER);
            }

            if (biblioteca.getLivro().getStatus() != null) {
                insertStmt.setInt(9, biblioteca.getLivro().getStatus());
                insertStmt.setInt(10, biblioteca.getLivro().getStatus());
            } else {
                insertStmt.setNull(9, java.sql.Types.INTEGER);
                insertStmt.setNull(10, java.sql.Types.INTEGER);
            }

            if (biblioteca.getLivro().getVolume() != null) {
                insertStmt.setInt(11, biblioteca.getLivro().getVolume());
                insertStmt.setInt(12, biblioteca.getLivro().getVolume());
            } else {
                insertStmt.setNull(11, java.sql.Types.INTEGER);
                insertStmt.setNull(12, java.sql.Types.INTEGER);
            }

            // Executando a consulta
            rs = insertStmt.executeQuery();

            // Iterando sobre os resultados
            while (rs.next()) {
                //Convertendo as datas do tipo Date para String
        
                Igreja igreja = new Igreja();
                Livro livro = new Livro();
                Autor autor = new Autor();
                Biblioteca bibliotec =  new Biblioteca();
                autor.setCodigo(rs.getInt("CodigoAutor"));
                autor.setNome(rs.getString("NomeAutor"));
                igreja.setCodigo(rs.getInt("CodigoIgreja"));
                igreja.setNome(rs.getString("NomeIgreja"));
                livro.setCodInterno(rs.getInt("CodigoInterno"));
                livro.setCodLivro(rs.getInt("CodigoLivro"));
                livro.setAutor(autor);
                livro.setNomeLivro(rs.getString("NomeLivro"));
                livro.setVolume(rs.getInt("VolumeLivro"));
                livro.setStatus(rs.getInt("Status"));
                bibliotec.setCodigo(rs.getInt("CodigoBiblioteca"));
                bibliotec.setLivro(livro);
                bibliotec.setIgreja(igreja);
                bibliotec.setQuantidade(rs.getInt("QuantidadeLivro"));

                listaLivros.add(bibliotec);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os dados da biblioteca", "Erro 001", JOptionPane.ERROR_MESSAGE);
            System.out.println("Código de erro: " + e.getErrorCode());
            System.out.println("Mensagem: " + e.getMessage());
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
    
    public List<Livro> consultarLivroDisponivel(Igreja igrejaSelec){
        
        List<Livro> listaLivros = new ArrayList<>();

        String sql = "SELECT " +
            "L.Codigo AS CodInterno, " +
            "L.CodLivro AS CodLivro, " +
            "L.Nome AS NomeLivro, " +
            "L.Volume AS VolumeLivro, " +
            "A.Codigo AS CodigoAutor, " +
            "A.Nome AS NomeAutor " +
            "FROM Biblioteca AS B " +
            "INNER JOIN Livros AS L ON L.Codigo = B.Livro " +
            "INNER JOIN Autores AS A ON A.Codigo = L.Autor " +
            "WHERE L.Ativo = 1 " +
            "AND B.Igreja = ? " +
            "AND B.Quantidade > 0";
        
        try{
            conexao = Conexao.getDataSource().getConnection();            
            insertStmt = conexao.prepareStatement(sql);
               
            insertStmt.setInt(1,  igrejaSelec.getCodigo());
            rs = insertStmt.executeQuery();

            while(rs.next()){     
                Livro livro = new Livro();
                Autor autor = new Autor();
                autor.setCodigo(rs.getInt("CodigoAutor"));
                autor.setNome(rs.getString("NomeAutor"));
                livro.setCodInterno(rs.getInt("CodInterno"));
                livro.setCodLivro(rs.getInt("CodLivro"));
                livro.setNomeLivro(rs.getString("NomeLivro"));
                livro.setVolume(rs.getInt("VolumeLivro"));
                livro.setAutor(autor);
                
                listaLivros.add(livro);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar o livro na biblioteca", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (insertStmt != null) insertStmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaLivros;
    }
    
}
