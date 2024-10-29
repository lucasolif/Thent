
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
import model.Igreja;
import model.Livro;

public class BibliotecaDao {
    
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public void adicionar(Livro livro, Igreja igreja, Integer qtd){

        try{
            this.conexao = Conexao.getDataSource().getConnection();
            
            String sql= "INSERT INTO Biblioteca (Livro,Quantidade,DataCadastro,Igreja)VALUES (?,?,GETDATE(),?)";
            this.ps = this.conexao.prepareStatement(sql);

            this.ps.setInt(1, livro.getCodInterno());
            this.ps.setInt(2, qtd);
            this.ps.setInt(3, igreja.getCodigo());
            this.ps.execute();
            
            JOptionPane.showMessageDialog(null, "Livro adicionado na biblioteca, com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar adicionar o livro na biblioteca", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.ps != null) this.ps.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public List<Biblioteca> consultarBiblioteca(Biblioteca biblioteca, String busca){
        
        List<Biblioteca> listaLivros = new ArrayList();
            
         try {             
            if(busca == null){    
                
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
                ps = conexao.prepareStatement(sql);  

                if (biblioteca.getLivro().getCodInterno() != null) {
                    ps.setInt(1, biblioteca.getLivro().getCodInterno());
                    ps.setInt(2, biblioteca.getLivro().getCodInterno());
                } else {
                    ps.setNull(1, java.sql.Types.INTEGER);
                    ps.setNull(2, java.sql.Types.INTEGER);
                }

                if (biblioteca.getIgreja() != null) {
                    ps.setInt(3, biblioteca.getIgreja().getCodigo()); 
                    ps.setInt(4, biblioteca.getIgreja().getCodigo());
                } else {
                    ps.setNull(3, java.sql.Types.INTEGER);
                    ps.setNull(4, java.sql.Types.INTEGER);
                }

                if (biblioteca.getLivro().getAutor() != null) {
                    ps.setInt(5, biblioteca.getLivro().getAutor().getCodigo());
                    ps.setInt(6, biblioteca.getLivro().getAutor().getCodigo());
                } else {
                    ps.setNull(5, java.sql.Types.INTEGER);
                    ps.setNull(6, java.sql.Types.INTEGER);
                }

                if (biblioteca.getLivro().getEditora() != null) {
                    ps.setInt(7, biblioteca.getLivro().getEditora().getCodigo());
                    ps.setInt(8, biblioteca.getLivro().getEditora().getCodigo());
                } else {
                    ps.setNull(7, java.sql.Types.INTEGER);
                    ps.setNull(8, java.sql.Types.INTEGER);
                }

                if (biblioteca.getLivro().getStatus() != null) {
                    ps.setInt(9, biblioteca.getLivro().getStatus());
                    ps.setInt(10, biblioteca.getLivro().getStatus());
                } else {
                    ps.setNull(9, java.sql.Types.INTEGER);
                    ps.setNull(10, java.sql.Types.INTEGER);
                }

                if (biblioteca.getLivro().getVolume() != null) {
                    ps.setInt(11, biblioteca.getLivro().getVolume());
                    ps.setInt(12, biblioteca.getLivro().getVolume());
                } else {
                    ps.setNull(11, java.sql.Types.INTEGER);
                    ps.setNull(12, java.sql.Types.INTEGER);
                }
                 
            }else{
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
                "WHERE (LV.NomeLivro LIKE ?) " +
                "OR (AUT.NomeAutor LIKE ?) ";       
                
                this.conexao = Conexao.getDataSource().getConnection();         
                this.ps =  this.conexao.prepareStatement(sql);

                this.ps.setString(1, "%" + busca + "%"); 
                this.ps.setString(2, "%" + busca + "%");
            }
     
            // Executando a consulta
            rs = ps.executeQuery();

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
                bibliotec.setCodigo(rs.getInt("CodigoBilioteca"));
                bibliotec.setLivro(livro);
                bibliotec.setIgreja(igreja);
                bibliotec.setQuantidade(rs.getInt("QuantidadeLivro"));

                listaLivros.add(bibliotec);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os dados da biblioteca", "Erro 001", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Fechando recursos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {

            }
        }
        
        return listaLivros;
        
    }
    
}
