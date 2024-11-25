
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
    private PreparedStatement insertStmt = null;
    private PreparedStatement updateStmt = null;
    private PreparedStatement selectStmt = null;
    private PreparedStatement deleteStmt = null;
    private ResultSet rs = null;

    public void cadastrarIgreja(Igreja igreja){
        
        String sql= "INSERT INTO Igrejas (NomeIgreja,Logradouro,Numero,Bairro,Cidade,Estado,CEP,Complemento,DataCadastro,Status)VALUES (?,?,?,?,?,?,?,?,GETDATE(),?)";

        try{
            this.conexao = Conexao.getDataSource().getConnection();
            this.insertStmt= this.conexao.prepareStatement(sql);

            this.insertStmt.setString(1, igreja.getNome());
            this.insertStmt.setString(2, igreja.getEndereco().getLogradouro());
            this.insertStmt.setInt(3, igreja.getEndereco().getNumero());
            this.insertStmt.setString(4, igreja.getEndereco().getBairro());
            this.insertStmt.setString(5, igreja.getEndereco().getCidade());
            this.insertStmt.setString(6, igreja.getEndereco().getEstado());
            this.insertStmt.setString(7, igreja.getEndereco().getCep());
            this.insertStmt.setString(8, igreja.getEndereco().getComplemento());
            this.insertStmt.setInt(9, igreja.getStatus());
            this.insertStmt.execute();
            
            JOptionPane.showMessageDialog(null, "Igreja cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);       
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a igreja", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.insertStmt != null) this.insertStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void alterarIgreja(Igreja igreja){

        String sql= "UPDATE Igrejas SET NomeIgreja=?,Logradouro=?,Numero=?,Bairro=?,Cidade=?,Estado=?,CEP=?,Complemento=?,Status=?" + " WHERE Codigo=?";

        try{
            this.conexao = Conexao.getDataSource().getConnection();       
            this.updateStmt = this.conexao.prepareStatement(sql);

            this.updateStmt.setString(1, igreja.getNome());
            this.updateStmt.setString(2, igreja.getEndereco().getLogradouro());
            this.updateStmt.setInt(3, igreja.getEndereco().getNumero());
            this.updateStmt.setString(4, igreja.getEndereco().getBairro());
            this.updateStmt.setString(5, igreja.getEndereco().getCidade());
            this.updateStmt.setString(6, igreja.getEndereco().getEstado());
            this.updateStmt.setString(7, igreja.getEndereco().getCep());
            this.updateStmt.setString(8, igreja.getEndereco().getComplemento());
            this.updateStmt.setInt(9, igreja.getStatus());
            this.updateStmt.setInt(10, igreja.getCodigo());
            this.updateStmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Igreja "+igreja.getNome().toUpperCase()+" alterada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);         
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a igreja "+igreja.getNome().toUpperCase(), "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.updateStmt != null) this.updateStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    //Consulta a igreja para ser alterada
    public List<Igreja> consultarIgreja(String buscaIgreja){

        List<Igreja> listaIgreja = new ArrayList<>();
        String sql = "SELECT * FROM Igrejas WHERE (? IS NULL OR Codigo LIKE ?) OR (? IS NULL OR NomeIgreja LIKE ?)";
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();          
            this.selectStmt = this.conexao.prepareStatement(sql);
            
            if (buscaIgreja != null) {
                this.selectStmt.setString(1,  "%" + buscaIgreja + "%");
                this.selectStmt.setString(2,  "%" + buscaIgreja + "%");
                this.selectStmt.setString(3,  "%" + buscaIgreja + "%");
                this.selectStmt.setString(4,  "%" + buscaIgreja + "%");
            } else {
                this.selectStmt.setNull(1, java.sql.Types.INTEGER);
                this.selectStmt.setNull(2, java.sql.Types.INTEGER);
                this.selectStmt.setNull(3, java.sql.Types.INTEGER);
                this.selectStmt.setNull(4, java.sql.Types.INTEGER);
            }           
            this.rs = this.selectStmt.executeQuery();

            while(this.rs.next()){
                Endereco endereco = new Endereco(rs.getString("Logradouro"), rs.getInt("Numero"), rs.getString("CEP"), rs.getString("Bairro"), rs.getString("Cidade"), rs.getString("Estado"), rs.getString("Complemento"));
                Igreja igreja = new Igreja();
                igreja.setCodigo(rs.getInt("Codigo"));
                igreja.setNome(rs.getString("NomeIgreja"));
                igreja.setDataCadastro(rs.getDate("DataCadastro"));
                igreja.setStatus(rs.getInt("Status"));
                igreja.setEndereco(endereco);
                
                listaIgreja.add(igreja);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar as igrejas cadastradas", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaIgreja;
    } 
    
    // Consulta igreja para popular o JComboBox de Igreja, no cadastro das pessoas
    public List<Igreja> consultarTodasIgrejas(){
        
        String sql = "SELECT * FROM Igrejas WHERE Status = 1 ORDER BY NomeIgreja";
        List<Igreja> todasIgrejas = new ArrayList<>();

        try{
            this.conexao = Conexao.getDataSource().getConnection();           
            this.selectStmt = this.conexao.prepareStatement(sql);
            
            this.rs = this.selectStmt.executeQuery();

            while(this.rs.next()){
                Endereco endereco = new Endereco(this.rs.getString("Logradouro"), this.rs.getInt("Numero"), this.rs.getString("CEP"), this.rs.getString("Bairro"), this.rs.getString("Cidade"), this.rs.getString("Estado"), this.rs.getString("Complemento"));
                Igreja igreja = new Igreja();
                igreja.setCodigo(this.rs.getInt("Codigo"));
                igreja.setNome(this.rs.getString("NomeIgreja"));
                igreja.setDataCadastro(this.rs.getDate("DataCadastro"));
                igreja.setStatus(this.rs.getInt("Status"));
                igreja.setEndereco(endereco);
                
                todasIgrejas.add(igreja);
            }       
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar as Contas Caixa", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.rs != null) this.rs.close();
                if (this.selectStmt != null) this.selectStmt.close();
                if (this.conexao != null) this.conexao.close();
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
    
    public void removerIgreja(Igreja igreja){
        
        String sql = "DELETE FROM Igrejas WHERE Codigo=?";
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();

            this.deleteStmt = conexao.prepareStatement(sql);
            this.deleteStmt.setInt(1, igreja.getCodigo());
            this.deleteStmt.executeUpdate();
            this.deleteStmt.close();
            
            JOptionPane.showMessageDialog(null, "Igreja "+igreja.getNome().toUpperCase()+" excluída com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o cadastro da igreja "+igreja.getNome(), "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (this.deleteStmt != null) this.deleteStmt.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
