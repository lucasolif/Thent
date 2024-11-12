
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.TipoCampanha;


public class TipoCampanhaDao {
    
    private Connection conexao = null;
    private PreparedStatement ps= null;
    private ResultSet rs = null;
     
    public void cadastrarTipoCampanha(TipoCampanha tpCampanha){

        try{
            this.conexao = Conexao.getDataSource().getConnection();
            
            String sql = "INSERT INTO TiposCampanha (Nome,Status,DataCadastro)VALUES (?,?,GETDATE())";
            this.ps = this.conexao.prepareStatement(sql);           
            this.ps.setString(1, tpCampanha.getNome());
            this.ps.setInt(2, tpCampanha.getStatus());
            
            this.ps.execute();
            
            JOptionPane.showMessageDialog(null, "Tipo de Campanha cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);            
        }catch (SQLException ex) {
            if (ex.getErrorCode() == 2627) { // Código de erro para violação de UNIQUE
                JOptionPane.showMessageDialog(null, "Já existe uma campanha com esse nome", "Erro 001", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar o tipo de campanha.", "Erro 001", JOptionPane.ERROR_MESSAGE);
            }            
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
    
    public void alterarTipoCampanha(TipoCampanha tpCampanha){

       try{
            this.conexao = Conexao.getDataSource().getConnection();
            
            String sql= "UPDATE TiposCampanha SET Status=? WHERE Codigo=?";
            
            this.ps = this.conexao.prepareStatement(sql);
            this.ps.setInt(1, tpCampanha.getStatus());
            this.ps.setInt(2, tpCampanha.getCodigo());      
            this.ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Tipo de campanha alterado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);      
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o tipo de campanha", "Erro 001", JOptionPane.ERROR_MESSAGE);
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
    
    public TipoCampanha consultarTipoCampanha(Integer codCampanha){
        
        TipoCampanha tpCampanha = new TipoCampanha();
        String sql = "SELECT Codigo,Nome,Status FROM TiposCampanha WHERE Codigo=?";
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();            
            this.ps = this.conexao.prepareStatement(sql);
               
            this.ps.setInt(1,  codCampanha);
            this.rs = this.ps.executeQuery();

            while(this.rs.next()){
                tpCampanha.setCodigo(this.rs.getInt("Codigo"));
                tpCampanha.setNome(this.rs.getString("Nome"));
                tpCampanha.setStatus(this.rs.getInt("Status"));
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o tipo de campanha", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.ps != null) this.ps.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return tpCampanha;
    }
    
    //Consultar para popular o JComboBox
    public List<TipoCampanha> consultarTiposCampanha(){
        
        List<TipoCampanha> listaTpCampanha =  new ArrayList<>();
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();
            
            String sql = "SELECT * FROM TiposCampanhas WHERE Status = 1 ORDER BY Nome";
            this.ps = this.conexao.prepareStatement(sql);           
            this.rs = this.ps.executeQuery();

            while(this.rs.next()){     
                TipoCampanha tpCampanha = new TipoCampanha();
                tpCampanha.setCodigo(this.rs.getInt("Codigo"));
                tpCampanha.setNome(this.rs.getString("Nome"));
                tpCampanha.setStatus(this.rs.getInt("Status"));

                listaTpCampanha.add(tpCampanha);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar os tipos de campanhas", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.ps != null) this.ps.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaTpCampanha;
    }
    
}
