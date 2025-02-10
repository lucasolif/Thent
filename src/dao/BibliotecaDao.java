
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.Biblioteca;
import model.Igreja;


public class BibliotecaDao {
    
    private final LogsDao logsDao = new LogsDao();
    private Connection conexao = null;
    private PreparedStatement selectStmt = null;
    private PreparedStatement insertStmt = null;
    private PreparedStatement updateStmt = null;
    private ResultSet rs = null;
    
    public void cadastraBiblioteca(Biblioteca biblioteca){
        String sqlInsert = "INSERT INTO Bibliotecas (NomeBiblioteca,Igreja,DataCadastro,AtivoInativo)VALUES (?,?,GETDATE(),1)";
        try{
            this.conexao = Conexao.getDataSource().getConnection();  
            this.insertStmt = this.conexao.prepareStatement(sqlInsert);    
            //Executa a query para consultar se o livro já existe
                 
            this.insertStmt.setString(1,  biblioteca.getNomeBiblioteca());
            this.insertStmt.setInt(2,  biblioteca.getIgreja().getCodigo());
            this.insertStmt.execute();         
            
            JOptionPane.showMessageDialog(null, "Biblioteca cadastrada com sucesso", "Erro 001", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a biblioteca", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.insertStmt != null) this.insertStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    
    public List<Biblioteca> consultarBiblioteca(String filtroBiblioteca){
        
        List<Biblioteca> listaBiblitecas = new ArrayList<>();

        String sql = "SELECT IG.NomeIgreja AS NomeIgreja, IG.Codigo AS CodigoIgreja, * FROM Bibliotecas AS B " +
        "INNER JOIN Igrejas AS IG ON IG.Codigo = B.Igreja " +
        "WHERE (? IS NULL OR B.Codigo LIKE ?) OR (? IS NULL OR B.NomeBiblioteca LIKE ?)";

        try{
            this.conexao = Conexao.getDataSource().getConnection();           
            this.selectStmt = this.conexao.prepareStatement(sql);
            
            if (filtroBiblioteca != null) {
                this.selectStmt.setString(1,  "%" + filtroBiblioteca + "%");
                this.selectStmt.setString(2,  "%" + filtroBiblioteca + "%");
                this.selectStmt.setString(3,  "%" + filtroBiblioteca + "%");
                this.selectStmt.setString(4,  "%" + filtroBiblioteca + "%");
            } else {
                this.selectStmt.setNull(1, java.sql.Types.INTEGER);
                this.selectStmt.setNull(2, java.sql.Types.INTEGER);
                this.selectStmt.setNull(3, java.sql.Types.INTEGER);
                this.selectStmt.setNull(4, java.sql.Types.INTEGER);
            }

            this.rs = this.selectStmt.executeQuery();

            while(this.rs.next()){
                Biblioteca biblioteca = new Biblioteca();
                Igreja igreja = new Igreja();
                igreja.setCodigo(rs.getInt("CodigoIgreja"));
                igreja.setNome(rs.getString("Nomeigreja"));
                biblioteca.setCodigo(rs.getInt("Codigo"));
                biblioteca.setNomeBiblioteca(rs.getString("NomeBiblioteca"));
                biblioteca.setStatus(rs.getInt("AtivoInativo"));
                biblioteca.setIgreja(igreja);

                listaBiblitecas.add(biblioteca);
            }            
            
            this.selectStmt.execute();
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar a biblioteca", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaBiblitecas;
    }
    
    public void alterarBiblioteca(Biblioteca biblioteca){
        
        String sqlUpdate = "UPDATE Bibliotecas SET AtivoInativo=?, NomeBiblioteca=? WHERE Codigo=?";

        try{       
            this.conexao = Conexao.getDataSource().getConnection();
            
            this.updateStmt = this.conexao.prepareStatement(sqlUpdate); 
            this.updateStmt.setInt(1, biblioteca.getStatus());
            this.updateStmt.setString(2, biblioteca.getNomeBiblioteca());
            this.updateStmt.setInt(3, biblioteca.getCodigo());
            this.updateStmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Biblioteca alterada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a biblioteca", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Fechar os recursos abertos
            try{
                if(this.rs != null) rs.close();
                if(this.updateStmt != null) this.updateStmt.close();
                if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public List<Biblioteca> consultarBibliotecaJComboBox(){
      
        List<Biblioteca> listaBiblioteca = new ArrayList<>();
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();
            
            String sql = "SELECT * FROM Bibliotecas WHERE AtivoInativo = 1 ORDER BY NomeBiblioteca";
            this.selectStmt = this.conexao.prepareStatement(sql);           
            this.rs = this.selectStmt.executeQuery();

            while(this.rs.next()){
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.setCodigo(rs.getInt("Codigo"));
                biblioteca.setNomeBiblioteca(rs.getString("NomeBiblioteca"));

                listaBiblioteca.add(biblioteca);
            }
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro a(s) biblioteca(s)", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaBiblioteca;
    }  
}
