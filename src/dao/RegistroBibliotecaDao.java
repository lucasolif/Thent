
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
import model.Livro;
import model.RegistroBiblioteca;


public class RegistroBibliotecaDao {
    
    private Connection conexao = null;
    private PreparedStatement selectStmt = null;
    private PreparedStatement insertStmt = null;
    private PreparedStatement updateStmt = null;
    private ResultSet rs = null;
    
    public void adicionarLivroBiblioteca(RegistroBiblioteca rgBiblioteca){
        
        String sqlUpdate = "UPDATE RegistroBiblioteca SET Quantidade = Quantidade + 1 WHERE Biblioteca=? AND Livro=?";
        String sqlInsert1 = "INSERT INTO RegistroBiblioteca (Biblioteca,Livro,Quantidade)VALUES (?,?,?)";
        String sqlInsert2 = "INSERT INTO RegistroSaidaEntradaLivro (TipoMovimentacao,DataMovimentacao)VALUES ('ENTRADA - AVULSA',GETDATE())";
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();  
            this.conexao.setAutoCommit(false); //Setando o autocomit como falso

            if(verificarExistenciaLivroBiblioteca(rgBiblioteca)){
                //Caso tenha livro ele atualiza a quantidade
                this.updateStmt = this.conexao.prepareStatement(sqlUpdate);                
                this.updateStmt.setInt(1,  rgBiblioteca.getBiblioteca().getCodigo());
                this.updateStmt.setInt(2,  rgBiblioteca.getLivro().getCodInterno());
                this.updateStmt.executeUpdate();                
            }else{
                //Se o livro não estiver, ele adiciona
                this.insertStmt = this.conexao.prepareStatement(sqlInsert1);         
                this.insertStmt.setInt(1,  rgBiblioteca.getBiblioteca().getCodigo());
                this.insertStmt.setInt(2,  rgBiblioteca.getLivro().getCodInterno());
                this.insertStmt.setInt(3,  rgBiblioteca.getQtdLivro());
                this.insertStmt.execute();
            }
            
            //Insere na tabela a movimentação do tipo entrada
            this.insertStmt = this.conexao.prepareStatement(sqlInsert2);    
            this.insertStmt.execute();  
            
            JOptionPane.showMessageDialog(null, "Livro "+rgBiblioteca.getLivro().getNomeLivro().toUpperCase()+" adicionado na biblioteca "+rgBiblioteca.getBiblioteca().getNomeBiblioteca().toUpperCase()+" com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            this.conexao.commit();
        }catch (SQLException ex) {
            //Se ocorrer um erro, fazer rollback da transação
            if(this.conexao != null){
                try{
                    this.conexao.rollback();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Erro: "+ex.getMessage());
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar adicionar o livro "+rgBiblioteca.getLivro().getNomeLivro().toUpperCase()+" na biblioteca "+rgBiblioteca.getBiblioteca().getNomeBiblioteca().toUpperCase(), "Erro 001", JOptionPane.ERROR_MESSAGE);
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
    
    public List<RegistroBiblioteca> consultarRegistroBiblioteca(Autor filtroAutor, Livro filtroLivro, Editora filtroEditora, Biblioteca filtroBiblioteca, Integer filtroStatus, Integer filtroVolumeLivro){
        
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
            "WHERE (? IS NULL OR RB.Biblioteca = ?) " +
            "AND (? IS NULL OR RB.Livro = ?) " +
            "AND (? IS NULL OR LV.Autor = ?) " +
            "AND (? IS NULL OR LV.Ativo = ?) " +
            "AND (? IS NULL OR LV.Editora = ?) " +
            "AND (? IS NULL OR LV.Volume = ?)";
   
            this.conexao = Conexao.getDataSource().getConnection();         
            this.selectStmt = this.conexao.prepareStatement(sqlSelect);  

            if(filtroBiblioteca != null) {
                this.selectStmt.setInt(1, filtroBiblioteca.getCodigo()); 
                this.selectStmt.setInt(2, filtroBiblioteca.getCodigo());
            }else{
                this.selectStmt.setNull(1, java.sql.Types.INTEGER);
                this.selectStmt.setNull(2, java.sql.Types.INTEGER);
            }
                
            if(filtroLivro != null) {
                this.selectStmt.setInt(3, filtroLivro.getCodInterno());
                this.selectStmt.setInt(4, filtroLivro.getCodInterno());
            } else {
                this.selectStmt.setNull(3, java.sql.Types.INTEGER);
                this.selectStmt.setNull(4, java.sql.Types.INTEGER);
            }

            if (filtroAutor != null) {
                this.selectStmt.setInt(5, filtroAutor.getCodigo());
                this.selectStmt.setInt(6, filtroAutor.getCodigo());
            } else {
                this.selectStmt.setNull(5, java.sql.Types.INTEGER);
                this.selectStmt.setNull(6, java.sql.Types.INTEGER);
            }

            if (filtroStatus != null) {
                this.selectStmt.setInt(7, filtroStatus);
                this.selectStmt.setInt(8, filtroStatus);
            } else {
                this.selectStmt.setNull(7, java.sql.Types.INTEGER);
                this.selectStmt.setNull(8, java.sql.Types.INTEGER);
            }

            if (filtroEditora != null) {
                this.selectStmt.setInt(9, filtroEditora.getCodigo());
                this.selectStmt.setInt(10, filtroEditora.getCodigo());
            } else {
                this.selectStmt.setNull(9, java.sql.Types.INTEGER);
                this.selectStmt.setNull(10, java.sql.Types.INTEGER);
            }

            if (filtroVolumeLivro != null) {
                this.selectStmt.setInt(11, filtroVolumeLivro);
                this.selectStmt.setInt(12, filtroVolumeLivro);
            } else {
                this.selectStmt.setNull(11, java.sql.Types.INTEGER);
                this.selectStmt.setNull(12, java.sql.Types.INTEGER);
            }
                
            // Executando a consulta
            this.rs = this.selectStmt.executeQuery();
            
            // Iterando sobre os resultados
            while (this.rs.next()) {      
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
                biblioteca.setNomeBiblioteca(rs.getString("NomeBiblioteca"));
                
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
                if (this.rs != null) this.rs.close();
                if (this.insertStmt != null) this.insertStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException e) {

            }
        }        
        return listaLivros;      
    }   
    
    public void removerLivroBiblioteca(RegistroBiblioteca rgBiblioteca){
        String sqlUpdate = "UPDATE RegistroBiblioteca SET Quantidade = Quantidade-1 WHERE Biblioteca=? AND Livro=?";
        String sqlInsert = "INSERT INTO RegistroSaidaEntradaLivro (TipoMovimentacao,DataMovimentacao)VALUES ('SAÍDA - AVULSA',GETDATE())";
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();  
            this.conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            if(verificarExistenciaLivroBiblioteca(rgBiblioteca)){
                //Caso tenha livro ele atualiza a quantidade
                this.updateStmt = this.conexao.prepareStatement(sqlUpdate);                
                this.updateStmt.setInt(1,  rgBiblioteca.getBiblioteca().getCodigo());
                this.updateStmt.setInt(2,  rgBiblioteca.getLivro().getCodInterno());
                this.updateStmt.executeUpdate();       
                
                //Insere na tabela a movimentação do tipo entrada
                this.insertStmt = this.conexao.prepareStatement(sqlInsert);    
                this.insertStmt.execute();    
                
                JOptionPane.showMessageDialog(null, "Livro "+rgBiblioteca.getLivro().getNomeLivro().toUpperCase()+" removido da biblioteca "+rgBiblioteca.getBiblioteca().getNomeBiblioteca().toUpperCase()+" com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
                this.conexao.commit();
            }else{
                JOptionPane.showMessageDialog(null, "Livro "+rgBiblioteca.getLivro().getNomeLivro().toUpperCase()+" não encontrado na biblioteca "+rgBiblioteca.getBiblioteca().getNomeBiblioteca().toUpperCase(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

            this.conexao.commit();
        }catch (SQLException ex) {
            //Se ocorrer um erro, fazer rollback da transação
            if(this.conexao != null){
                try{
                    this.conexao.rollback();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar remover o livro "+rgBiblioteca.getLivro().getNomeLivro().toUpperCase()+" da biblioteca "+rgBiblioteca.getBiblioteca().getNomeBiblioteca().toUpperCase(), "Erro 001", JOptionPane.ERROR_MESSAGE);
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
    
    public boolean verificarExistenciaLivroBiblioteca(RegistroBiblioteca rgBiblioteca){
        String sqlSelect = "SELECT * FROM RegistroBiblioteca WHERE Biblioteca=? AND Livro=? AND Quantidade > 0";
        boolean status = false;
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();  
            this.conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            //Consulta para verificar se o livro já está na biblioteca
            this.selectStmt = this.conexao.prepareStatement(sqlSelect,PreparedStatement.RETURN_GENERATED_KEYS);       
            this.selectStmt.setInt(1,  rgBiblioteca.getBiblioteca().getCodigo());
            this.selectStmt.setInt(2,  rgBiblioteca.getLivro().getCodInterno());         
            this.rs = selectStmt.executeQuery();
            
            if(this.rs.next()){
                status = true;
            }
        }catch (SQLException ex) {

        }finally{
            // Fechar recursos
            try{
                if (this.selectStmt != null) this.selectStmt.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
        
        return status;
    }
    
    public List<Livro> verificarDisponibilidadeEmprestimo(Biblioteca biblioteca){
        List<Livro> listaLivros = new ArrayList<>();
        String sqlSelect = "SELECT LV.Codigo AS CodigoInternoLivro, " +
            "LV.CodLivro AS CodLivro, " +
            "LV.Nome AS NomeLivro, " +
            "LV.Volume AS Volume, " +
            "LV.Caracteristica AS Caracteristica, " +
            "LV.Ano AS Ano, " +
            "AUT.Codigo AS CodAutor, " +
            "AUT.Nome AS NomeAutor, " +
            "EDT.Codigo AS CodEditora, " +
            "EDT.Nome AS NomeEditora " +
            "FROM RegistroBiblioteca AS RGB " +
            "INNER JOIN Livros AS LV ON LV.Codigo = RGB.Livro AND LV.Ativo = 1 " +
            "INNER JOIN Autores AS AUT ON AUT.Codigo = LV.Autor " +
            "INNER JOIN Editoras AS EDT ON EDT.Codigo = LV.Editora " +
            "WHERE Biblioteca = ? AND Quantidade > 0";
        try{
            this.conexao = Conexao.getDataSource().getConnection();  
            this.conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            //Consulta para verificar se o livro já está na biblioteca
            this.selectStmt = this.conexao.prepareStatement(sqlSelect);       
            this.selectStmt.setInt(1,  biblioteca.getCodigo());       
            this.rs = selectStmt.executeQuery();
            
            while(this.rs.next()){
                Autor autor = new Autor();
                Livro livro = new Livro();
                Editora editora = new Editora();
                autor.setCodigo(rs.getInt("CodAutor"));
                autor.setNome(rs.getString("NomeAutor"));               
                editora.setCodigo(rs.getInt("CodEditora"));
                editora.setNome(rs.getString("NomeEditora"));                
                livro.setCodInterno(rs.getInt("CodigoInternoLivro"));
                livro.setCodLivro(rs.getInt("CodLivro"));
                livro.setNomeLivro(rs.getString("NomeLivro"));
                livro.setVolume(rs.getInt("Volume"));              
                livro.setCaracteristica(rs.getString("Caracteristica"));
                livro.setAnoPublicacao(rs.getInt("Ano"));
                livro.setEditora(editora);
                livro.setAutor(autor);
                
                listaLivros.add(livro);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar livros disponível para empréstimo na biblioteca: "+biblioteca.getNomeBiblioteca(), "Erro 012", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro: "+ex.getMessage());
        }finally{
            // Fechar recursos
            try{
                if (this.selectStmt != null) this.selectStmt.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }      
        return listaLivros;
    }
    
    public List<Livro> consultarLivrosTodasBibliotecas(){
        
        List<Livro> listaLivros = new ArrayList<>();
        String sqlSelect = "SELECT LV.Codigo AS CodigoInternoLivro, " +
            "LV.CodLivro AS CodLivro, " +
            "LV.Nome AS NomeLivro, " +
            "LV.Volume AS Volume, " +
            "LV.Caracteristica AS Caracteristica, " +
            "LV.Ano AS Ano, " +
            "AUT.Codigo AS CodAutor, " +
            "AUT.Nome AS NomeAutor, " +
            "EDT.Codigo AS CodEditora, " +
            "EDT.Nome AS NomeEditora " +
            "FROM RegistroBiblioteca AS RGB " +
            "INNER JOIN Livros AS LV ON LV.Codigo = RGB.Livro AND LV.Ativo = 1 " +
            "INNER JOIN Autores AS AUT ON AUT.Codigo = LV.Autor " +
            "INNER JOIN Editoras AS EDT ON EDT.Codigo = LV.Editora";
        try{
            this.conexao = Conexao.getDataSource().getConnection();  
            this.conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            //Consulta para verificar se o livro já está na biblioteca
            this.selectStmt = this.conexao.prepareStatement(sqlSelect);            
            this.rs = selectStmt.executeQuery();
            
            while(this.rs.next()){
                Autor autor = new Autor();
                Livro livro = new Livro();
                Editora editora = new Editora();
                autor.setCodigo(rs.getInt("CodAutor"));
                autor.setNome(rs.getString("NomeAutor"));               
                editora.setCodigo(rs.getInt("CodEditora"));
                editora.setNome(rs.getString("NomeEditora"));                
                livro.setCodInterno(rs.getInt("CodigoInternoLivro"));
                livro.setCodLivro(rs.getInt("CodLivro"));
                livro.setNomeLivro(rs.getString("NomeLivro"));
                livro.setVolume(rs.getInt("Volume"));              
                livro.setCaracteristica(rs.getString("Caracteristica"));
                livro.setAnoPublicacao(rs.getInt("Ano"));
                livro.setEditora(editora);
                livro.setAutor(autor);
                
                listaLivros.add(livro);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar livros disponível na biblioteca", "Erro 012", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro: "+ex.getMessage());
        }finally{
            // Fechar recursos
            try{
                if (this.selectStmt != null) this.selectStmt.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }      
        return listaLivros;
    }
    
}
