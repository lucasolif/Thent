
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

public class ContaResultadoDao {
    
    private final LogsDao logsDao = new LogsDao();
    Connection conexao = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //Consulta para popular o JComboBox
    public List<ContaResultado> consultarContaResultado(){
        
        List<ContaResultado> listaContaResultado = new ArrayList<>();
       
        try{ 
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "SELECT * FROM ContasResultado ORDER BY Descricao";
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                ContaResultado contaResultado = new ContaResultado();
                contaResultado.setCodigo(rs.getInt("Codigo"));
                contaResultado.setNome(rs.getString("Descricao"));

                listaContaResultado.add(contaResultado);
            }
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar as contas de resultado", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaContaResultado;
    }
    
    public void adicionar(ContaResultado contaResultado){
        
        try{            
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "INSERT INTO ContasResultado (Descricao,ReceitaDespesa,DataCadastro)VALUES (?,?,GETDATE())";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, contaResultado.getNome());
            ps.setString(2, contaResultado.getTipoReceitaDespesa());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Conta Resultado cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a conta de resultado", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void alterar(ContaResultado contaResultado){

        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "UPDATE ContasResultado SET Descricao=?,ReceitaDespesa=?" + " WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, contaResultado.getNome());
            ps.setString(2, contaResultado.getTipoReceitaDespesa());
            ps.setInt(3, contaResultado.getCodigo());
            ps.executeUpdate(); 
            
            JOptionPane.showMessageDialog(null, "Conta de Resultado "+contaResultado.getNome()+" alterada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a conta de resultado "+contaResultado.getNome(), "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
 
    }
    
    //Consulta para listar todas as contas de resultado na tabela
    public List<ContaResultado> consultarContaResultado(String contaResultado){
        
        List<ContaResultado> listaContaResultado = new ArrayList<>();

        String sql = "SELECT * FROM ContasResultado "
        + "WHERE (? IS NULL OR Codigo LIKE ?) OR (? IS NULL OR Descricao LIKE ?)";
        
        try{
            conexao = Conexao.getDataSource().getConnection();            
            ps = conexao.prepareStatement(sql);
            
            if (contaResultado != null) {
                ps.setString(1,  "%" + contaResultado + "%");
                ps.setString(2,  "%" + contaResultado + "%");
                ps.setString(3,  "%" + contaResultado + "%");
                ps.setString(4,  "%" + contaResultado + "%");
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
                ps.setNull(2, java.sql.Types.INTEGER);
                ps.setNull(3, java.sql.Types.INTEGER);
                ps.setNull(4, java.sql.Types.INTEGER);
            }

            rs = ps.executeQuery();

            while(rs.next()){
                ContaResultado cResultado = new ContaResultado();
                cResultado.setCodigo(rs.getInt("Codigo"));
                cResultado.setNome(rs.getString("Descricao"));
                cResultado.setTipoReceitaDespesa(rs.getString("ReceitaDespesa"));
                cResultado.setDataCadastro(rs.getDate("DataCadastro"));

                listaContaResultado.add(cResultado);
            }
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar a conta de resultado", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaContaResultado;
    }
    
    public void remover(ContaResultado contaResultado){
        
        try{    
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "DELETE FROM ContasResultado WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, contaResultado.getCodigo());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Conta de Resultado "+contaResultado.getNome()+" excluída com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir a conta de resultado "+contaResultado.getNome(), "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    
}
