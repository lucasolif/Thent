
package dao;

import ferramentas.Conversores;
import jdbc.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Pessoa;
import model.Endereco;
import model.Igreja;

public class PessoaDao {
    private Conversores conversor = new Conversores();
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    //Método para adicionar pessoa física
    public void adicionar(Pessoa pessoa){

        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "INSERT INTO Pessoas (Nome,CPF,DataNascimento,RG,Sexo,Celular,Email,Igreja,Logradouro,Numero,Bairro,Cidade,Estado,CEP,Complemento,DataCadastro,Ativo)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,GETDATE(),?)";
            ps = conexao.prepareStatement(sql);

            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getCpfCnpj());
            ps.setString(3, pessoa.getDataNascimento());
            ps.setString(4, pessoa.getRg());
            ps.setString(5, pessoa.getSexo());
            ps.setString(6, pessoa.getCelular());
            ps.setString(7, pessoa.getEmail());
            ps.setInt(8, pessoa.getIgreja().getCodigo());
            ps.setString(9, pessoa.getEndereco().getLogradouro());
            ps.setInt(10, pessoa.getEndereco().getNumero());
            ps.setString(11, pessoa.getEndereco().getBairro());
            ps.setString(12, pessoa.getEndereco().getCidade());
            ps.setString(13, pessoa.getEndereco().getEstado());
            ps.setString(14, pessoa.getEndereco().getCep());
            ps.setString(15, pessoa.getEndereco().getComplemento());
            ps.setInt(16, pessoa.getAtivo());
            ps.execute();
           
            JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            //Se ocorrer um erro, fazer rollback da transação
            if(conexao != null){
                try{
                    conexao.rollback();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }           
            if (ex.getErrorCode() == 2627) { // Código de erro para violação de UNIQUE
                JOptionPane.showMessageDialog(null, "Já existe uma pessoa cadastrado com esses dados (CPF, RG ou Email)", "Erro 001", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar a pessoa.", "Erro 001", JOptionPane.ERROR_MESSAGE);
            }
            
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
    
    //Método para consultar pessoa e listar na tabela
    public List<Pessoa> consultar(String busca){

        String sql = null;
        List<Pessoa> listaPessoas = new ArrayList<>();
        IgrejaDao igrejaDao = new IgrejaDao(); //Estanciando o objeto para consultar a igreja da pessoa
        
        if(busca.length() >= 0){
            if(verificarNumero(busca)){
                sql = "SELECT * FROM Pessoas WHERE Codigo LIKE ?";
            }else{
                sql = "SELECT * FROM Pessoas WHERE Nome LIKE ?";
            }   
        }
        else{
            sql = "SELECT * FROM Pessoas";
        }
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%"+busca+"%");
            
            rs = ps.executeQuery();

            while(rs.next()){
                String dataNasc = conversor.convertendoDataStringSql(rs.getDate("DataNascimento"));
                
                Igreja igreja = igrejaDao.consultarIgrejas(rs.getInt("Igreja")); //Consultando a tabela Igreja, com base no código da igreja, obtido na tabela de pessoas, e retornando o objeto igreja
                Endereco endereco = new Endereco(rs.getString("Logradouro"),rs.getInt("Numero"),rs.getString("CEP"),rs.getString("Bairro"),rs.getString("Cidade"),rs.getString("Estado"),rs.getString("Complemento"));
                Pessoa pessoas = new Pessoa(rs.getString("Nome"), rs.getString("CPF"),dataNasc,rs.getString("RG"),rs.getString("Celular"),rs.getString("Email"),rs.getString("Sexo"),igreja,endereco,rs.getInt("Codigo"),rs.getInt("Ativo"));
                listaPessoas.add(pessoas);
            }
  
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar buscar a pessoa na base de dados", "Erro 001", JOptionPane.ERROR_MESSAGE);
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

        return listaPessoas;     
    }
    
    //Alterar o cadastro das pessoas
    public void alterar(Pessoa pessoa){

        try{ 
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "UPDATE Pessoas SET Nome=?,CPF=?,DataNascimento=?,RG=?,Sexo=?,Celular=?,Email=?,Igreja=?,Logradouro=?,Numero=?,Bairro=?,Cidade=?,Estado=?,CEP=?,Complemento=?,Ativo=?" + " WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getCpfCnpj());
            ps.setString(3, pessoa.getDataNascimento());
            ps.setString(4, pessoa.getRg());
            ps.setString(5, pessoa.getSexo());
            ps.setString(6, pessoa.getCelular());
            ps.setString(7, pessoa.getEmail());
            ps.setInt(8, pessoa.getIgreja().getCodigo());
            ps.setString(9, pessoa.getEndereco().getLogradouro());
            ps.setInt(10, pessoa.getEndereco().getNumero());
            ps.setString(11, pessoa.getEndereco().getBairro());
            ps.setString(12, pessoa.getEndereco().getCidade());
            ps.setString(13, pessoa.getEndereco().getEstado());
            ps.setString(14, pessoa.getEndereco().getCep());
            ps.setString(15, pessoa.getEndereco().getComplemento());
            ps.setInt(16, pessoa.getAtivo());
            ps.setInt(17, pessoa.getCodigo());
            ps.executeUpdate();
 
            JOptionPane.showMessageDialog(null, "Pessoa "+ pessoa.getCodigo()+" alterado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex){;
            JOptionPane.showMessageDialog(null, "Erro ao alterar a pessoa "+pessoa.getCodigo(), "Erro 001", JOptionPane.ERROR_MESSAGE);
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
    
    //Remover o cadastro das pessoas
    public void remover(int codigo){

        try{       
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "DELETE FROM Pessoas WHERE Codigo=?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "Pessoa "+codigo+" excluído com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o cadastro da pessoa "+codigo, "Erro 001", JOptionPane.ERROR_MESSAGE);
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
    
    //Verifica se é String é um número
    private static boolean verificarNumero(String valor) {
        return valor != null && valor.matches("[0-9]*");
    }
    
}
