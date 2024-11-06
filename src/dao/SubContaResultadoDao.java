
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.ContaResultado;
import model.SubContaResultado;


public class SubContaResultadoDao {
    
    Connection conexao = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //Consulta para popular o JComboBox
    public List<SubContaResultado> consultarSubContaResultado(){
        
        List<SubContaResultado> listaSubContaResultado = new ArrayList<>();
       
        try{ 
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "SELECT * FROM SubContasResultado ORDER BY Descricao";
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                SubContaResultado subCtResult = new SubContaResultado();
                subCtResult.setCodigo(rs.getInt("Codigo"));
                subCtResult.setDescricao(rs.getString("Descricao"));

                listaSubContaResultado.add(subCtResult);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar as sub contas de resultado", "Erro 001", JOptionPane.ERROR_MESSAGE);
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

        return listaSubContaResultado;
    }
    
    public void adicionar(SubContaResultado subCtResultado){
        
        try{            
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "INSERT INTO SubContasResultado (Descricao,ContaResultado,DataCadastro)VALUES (?,?,GETDATE())";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, subCtResultado.getDescricao());
            ps.setInt(2, subCtResultado.getContaResultado().getCodigo());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Sub Conta de Resultado cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a conta de resultado", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void alterar(SubContaResultado subCtResultado){

        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "UPDATE SubContasResultado SET Descricao=?,ContaResultado=?" + " WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, subCtResultado.getDescricao());
            ps.setInt(2, subCtResultado.getContaResultado().getCodigo());
            ps.setInt(3, subCtResultado.getCodigo());
            ps.executeUpdate(); 
            
            JOptionPane.showMessageDialog(null, "Sub Conta de Resultado "+subCtResultado.getDescricao()+" alterada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a sub conta de resultado "+subCtResultado.getDescricao(), "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
 
    }
    
    //Consulta para listar todas as sub contas de resultado na tabela
    public List<SubContaResultado> consultarSubContaResultado(String subCtResultado){

        String sql = null;
        List<SubContaResultado> listaSubCtResult = new ArrayList<>();

        sql = "SELECT SCS.Codigo As Codigo, SCS.Descricao As Descricao, CR.Codigo As CodContaResultado, CR.Descricao As NomeContaResultado "
        + "FROM SubContasResultado As SCS "
        + "INNER JOIN ContasResultado CR ON SCS.ContaResultado = CR.Codigo "
        + "WHERE (? IS NULL OR SCS.Codigo LIKE ?) OR (? IS NULL OR SCS.Descricao LIKE ?)";
     
        try{
            conexao = Conexao.getDataSource().getConnection();           
            ps = conexao.prepareStatement(sql);
            
            if (subCtResultado != null) {
                ps.setString(1,  "%" + subCtResultado + "%");
                ps.setString(2,  "%" + subCtResultado + "%");
                ps.setString(3,  "%" + subCtResultado + "%");
                ps.setString(4,  "%" + subCtResultado + "%");
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
                ps.setNull(2, java.sql.Types.INTEGER);
                ps.setNull(3, java.sql.Types.INTEGER);
                ps.setNull(4, java.sql.Types.INTEGER);
            }

            rs = ps.executeQuery();

            while(rs.next()){
                SubContaResultado subContResult = new SubContaResultado();
                ContaResultado contResult = new ContaResultado();
                
                subContResult.setCodigo(rs.getInt("Codigo"));
                subContResult.setDescricao(rs.getString("Descricao"));
                contResult.setCodigo(rs.getInt("CodContaResultado"));
                contResult.setNome(rs.getString("NomeContaResultado"));
                subContResult.setContaResultado(contResult);

                listaSubCtResult.add(subContResult);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar a sub conta de resultado", "Erro 001", JOptionPane.ERROR_MESSAGE);
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

        return listaSubCtResult;
    }
    
    public void remover(SubContaResultado subContResult){
        
        try{    
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "DELETE FROM SubContasResultado WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, subContResult.getCodigo());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sub Conta de Resultado "+subContResult.getDescricao()+" excluída com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir a sub conta de resultado "+subContResult.getDescricao(), "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

}
