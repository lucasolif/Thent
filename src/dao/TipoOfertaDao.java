
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.TipoOferta;

public class TipoOfertaDao {
    
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    //Consulta para popular o JComboBox
    public List<TipoOferta> consultarTipoOferta(){
        
        List<TipoOferta> listaTipoOferta = new ArrayList<>();
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "SELECT * FROM TiposOfertas ORDER BY Descricao";
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                TipoOferta tipoOferta = new TipoOferta();
                tipoOferta.setCodigo(rs.getInt("Codigo"));
                tipoOferta.setNome(rs.getString("Descricao"));

                listaTipoOferta.add(tipoOferta);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar os tipos de oferta", "Erro 001", JOptionPane.ERROR_MESSAGE);
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

        return listaTipoOferta;
    }
    
    public void adicionar(TipoOferta tipoOferta){

        try{           
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "INSERT INTO TiposOfertas (Descricao,DataCadastro)VALUES (?,GETDATE())";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, tipoOferta.getNome());     
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Tipo de oferta cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o tipo de oferta", "Erro 001", JOptionPane.ERROR_MESSAGE);
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
    
    public void alterar(TipoOferta tipoOferta){

        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "UPDATE TiposOfertas SET Descricao=?" + " WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, tipoOferta.getNome());
            ps.setInt(2, tipoOferta.getCodigo());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Tipo de Oferta "+tipoOferta.getNome()+" alterada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o tipo de oferta "+tipoOferta.getNome(), "Erro 001", JOptionPane.ERROR_MESSAGE);
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
    
    //Consulta para listar todas os tipos de ofertas na tabela
    public List<TipoOferta> consultar(String tipoOferta){

        String sql = null;
        List<TipoOferta> listaTipoOferta = new ArrayList<>();

        sql = "SELECT * FROM TiposOfertas "
        + "WHERE (? IS NULL OR  Codigo LIKE ?) OR (? IS NULL OR Descricao LIKE ?)";
   
        try{
            conexao = Conexao.getDataSource().getConnection();            
            ps = conexao.prepareStatement(sql);
            
            if (tipoOferta != null) {
                ps.setString(1,  "%" + tipoOferta + "%");
                ps.setString(2,  "%" + tipoOferta + "%");
                ps.setString(3,  "%" + tipoOferta + "%");
                ps.setString(4,  "%" + tipoOferta + "%");
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
                ps.setNull(2, java.sql.Types.INTEGER);
                ps.setNull(3, java.sql.Types.INTEGER);
                ps.setNull(4, java.sql.Types.INTEGER);
            }

            rs = ps.executeQuery();

            while(rs.next()){
                TipoOferta tpOferta = new TipoOferta();
                tpOferta.setCodigo(rs.getInt("Codigo"));
                tpOferta.setNome(rs.getString("Descricao"));
                tpOferta.setDataCadastro(rs.getDate("DataCadastro"));

                listaTipoOferta.add(tpOferta);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os tipos de ofertas", "Erro 001", JOptionPane.ERROR_MESSAGE);
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

        return listaTipoOferta;
    }
    
    public void remover(TipoOferta tipoOferta){

        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "DELETE FROM TiposOfertas WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, tipoOferta.getCodigo());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Tipo de Oferta "+tipoOferta.getNome()+" excluída com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o tipo de oferta "+tipoOferta.getNome(), "Erro 001", JOptionPane.ERROR_MESSAGE);
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
}
