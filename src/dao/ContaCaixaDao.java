
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.ContaCaixa;


public class ContaCaixaDao {
    
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public void adicionar(ContaCaixa contaCaixa){
 
        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "INSERT INTO ContasCaixa (Descricao,DataCadastro)VALUES (?,GETDATE())";
            ps = conexao.prepareStatement(sql);
            ps.setString(1,contaCaixa.getNome());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Conta Caixa cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a Conta Caixa", "Erro 001", JOptionPane.ERROR_MESSAGE);
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
    
    public void alterar(ContaCaixa contaCaixa){
        
        try{          
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "UPDATE ContasCaixa SET Descricao=?" + " WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, contaCaixa.getNome());
            ps.setInt(2, contaCaixa.getCodigo());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Conta caixa "+contaCaixa.getNome()+" alterada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a Conta Caixa "+contaCaixa.getNome(), "Erro 001", JOptionPane.ERROR_MESSAGE);
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
    
    //Consulta para popular o JComboBox
    public List<ContaCaixa> consultarCaixa(){
        String sql = "SELECT * FROM ContasCaixa ORDER BY Descricao";  
        List<ContaCaixa> listaCaixas = new ArrayList<>();
 
        try{
            conexao = Conexao.getDataSource().getConnection();
            
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                ContaCaixa caixa = new ContaCaixa();
                caixa.setCodigo(rs.getInt("Codigo"));
                caixa.setNome(rs.getString("Descricao"));
                caixa.setDataCadastro(rs.getDate("DataCadastro"));

                listaCaixas.add(caixa);
            }

            ps.execute();
          
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar as Contas Caixa", "Erro 001", JOptionPane.ERROR_MESSAGE);
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

        return listaCaixas;
    }
    
    //Consultar para mostra na tabela todos os caixas cadastrados
    public List<ContaCaixa> consultar(String conta){
        String sql = null;
        List<ContaCaixa> listaCaixas = new ArrayList<>();

        sql = "SELECT * FROM ContasCaixa "
        + "WHERE (? IS NULL OR Codigo LIKE ?) OR (? IS NULL OR Descricao LIKE ?)";

        try{
            conexao = Conexao.getDataSource().getConnection();           
            ps = conexao.prepareStatement(sql);
            
            if (conta != null) {
                ps.setString(1,  "%" + conta + "%");
                ps.setString(2,  "%" + conta + "%");
                ps.setString(3,  "%" + conta + "%");
                ps.setString(4,  "%" + conta + "%");
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
                ps.setNull(2, java.sql.Types.INTEGER);
                ps.setNull(3, java.sql.Types.INTEGER);
                ps.setNull(4, java.sql.Types.INTEGER);
            }
            rs = ps.executeQuery();

            while(rs.next()){
                ContaCaixa caixa = new ContaCaixa();
                caixa.setCodigo(rs.getInt("Codigo"));
                caixa.setNome(rs.getString("Descricao"));
                caixa.setDataCadastro(rs.getDate("DataCadastro"));

                listaCaixas.add(caixa);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar a Conta Caixa", "Erro 001", JOptionPane.ERROR_MESSAGE);
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
        return listaCaixas;
    }
    
    public void remover(ContaCaixa contaCaixa){
        
        try{          
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "DELETE FROM ContasCaixa WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, contaCaixa.getCodigo());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Conta Caixa "+contaCaixa.getNome()+" excluída com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir a Conta Caixa "+contaCaixa.getNome(), "Erro 001", JOptionPane.ERROR_MESSAGE);
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
