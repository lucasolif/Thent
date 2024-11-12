
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.Endereco;
import model.Igreja;


public class IgrejaDao {
    
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    
    public void adicionar(Igreja igreja){

        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "INSERT INTO Igrejas (NomeIgreja,Logradouro,Numero,Bairro,Cidade,Estado,CEP,Complemento,DataCadastro)VALUES (?,?,?,?,?,?,?,?,GETDATE())";
            ps = conexao.prepareStatement(sql);

            ps.setString(1, igreja.getNome());
            ps.setString(2, igreja.getEndereco().getLogradouro());
            ps.setInt(3, igreja.getEndereco().getNumero());
            ps.setString(4, igreja.getEndereco().getBairro());
            ps.setString(5, igreja.getEndereco().getCidade());
            ps.setString(6, igreja.getEndereco().getEstado());
            ps.setString(7, igreja.getEndereco().getCep());
            ps.setString(8, igreja.getEndereco().getComplemento());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Igreja cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a igreja", "Erro 001", JOptionPane.ERROR_MESSAGE);
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
    
    public void alterar(Igreja igreja){

        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql= "UPDATE Igrejas SET NomeIgreja=?,Logradouro=?,Numero=?,Bairro=?,Cidade=?,Estado=?,CEP=?,Complemento=?" + " WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);

            ps.setString(1, igreja.getNome());
            ps.setString(2, igreja.getEndereco().getLogradouro());
            ps.setInt(3, igreja.getEndereco().getNumero());
            ps.setString(4, igreja.getEndereco().getBairro());
            ps.setString(5, igreja.getEndereco().getCidade());
            ps.setString(6, igreja.getEndereco().getEstado());
            ps.setString(7, igreja.getEndereco().getCep());
            ps.setString(8, igreja.getEndereco().getComplemento());
            ps.setInt(9, igreja.getCodigo());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Igreja "+igreja.getNome()+" alterada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a igreja "+igreja.getNome(), "Erro 001", JOptionPane.ERROR_MESSAGE);
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
    
    //Consulta a igreja para ser alterada
    public List<Igreja> consultar(String buscaIgreja){

        List<Igreja> listaIgreja = new ArrayList<>();
        String sql = "SELECT * FROM Igrejas WHERE (? IS NULL OR Codigo LIKE ?) OR (? IS NULL OR NomeIgreja LIKE ?)";
        
        try{
            conexao = Conexao.getDataSource().getConnection();          
            ps = conexao.prepareStatement(sql);
            
            if (buscaIgreja != null) {
                ps.setString(1,  "%" + buscaIgreja + "%");
                ps.setString(2,  "%" + buscaIgreja + "%");
                ps.setString(3,  "%" + buscaIgreja + "%");
                ps.setString(4,  "%" + buscaIgreja + "%");
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
                ps.setNull(2, java.sql.Types.INTEGER);
                ps.setNull(3, java.sql.Types.INTEGER);
                ps.setNull(4, java.sql.Types.INTEGER);
            }
            
            rs = ps.executeQuery();

            while(rs.next()){
                Endereco endereco = new Endereco(rs.getString("Logradouro"), rs.getInt("Numero"), rs.getString("CEP"), rs.getString("Bairro"), rs.getString("Cidade"), rs.getString("Estado"), rs.getString("Complemento"));
                Igreja igreja = new Igreja(rs.getInt("Codigo"), rs.getString("NomeIgreja"),rs.getDate("DataCadastro"),endereco);

                listaIgreja.add(igreja);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar as igrejas cadastradas", "Erro 001", JOptionPane.ERROR_MESSAGE);
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
        return listaIgreja;
    } 
    
    // Consulta igreja para popular o JComboBox de Igreja, no cadastro das pessoas
    public List<Igreja> consultarTodasIgrejas(){
        
        String sql = "SELECT * FROM Igrejas ORDER BY NomeIgreja";
        List<Igreja> todasIgrejas = new ArrayList<>();

        try{
            conexao = Conexao.getDataSource().getConnection();
            
            ps = conexao.prepareStatement(sql);
            ps.executeQuery();
            rs = ps.executeQuery();

            while(rs.next()){
                Endereco endereco = new Endereco(rs.getString("Logradouro"), rs.getInt("Numero"), rs.getString("CEP"), rs.getString("Bairro"), rs.getString("Cidade"), rs.getString("Estado"), rs.getString("Complemento"));
                Igreja igreja = new Igreja(rs.getInt("Codigo"), rs.getString("NomeIgreja"),rs.getDate("DataCadastro"),endereco);
                todasIgrejas.add(igreja);
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
        return todasIgrejas;
    } 
    
    //Consulta igreja com base no código da igreja, obtida na tabela de pessoas, para ser utilizado na consulta das pessoas.
    public Igreja consultarIgrejas(int codIgreja){
        String sql = "SELECT * FROM Igrejas WHERE Codigo=?";
        Igreja igreja = new Igreja();
 
        try{
            conexao = Conexao.getDataSource().getConnection();
            
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, codIgreja);
            rs = ps.executeQuery();

            while(rs.next()){
                Endereco endereco = new Endereco(rs.getString("Logradouro"), rs.getInt("Numero"), rs.getString("CEP"), rs.getString("Bairro"), rs.getString("Cidade"), rs.getString("Estado"), rs.getString("Complemento"));
                igreja = new Igreja(rs.getInt("Codigo"), rs.getString("NomeIgreja"),rs.getDate("DataCadastro"),endereco);
            }

            ps.execute();
            ps.close();
            conexao.close();
          
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
        return igreja;
    } 
    
    public void remover(Igreja igreja){
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "DELETE FROM Igrejas WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, igreja.getCodigo());
            ps.executeUpdate();
            ps.close();
            conexao.close();
            
            JOptionPane.showMessageDialog(null, "Igreja "+igreja.getNome()+" excluída com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o cadastro da igreja "+igreja.getNome(), "Erro 001", JOptionPane.ERROR_MESSAGE);
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
