
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.MovimentoCaixa;
import model.TransferenciaConta;

public class TransferenciaDepositoDao {
    
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public void realizarOperacoesBancarias(MovimentoCaixa mvCaixa, int tpOpe){

        PreparedStatement psRegistro = null;
        PreparedStatement psMovimento = null;
        ResultSet generatedKeys = null;
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            //Query que será executada
            String sqlReg = "INSERT INTO TransferenciaDeposito (DataOperacao) VALUES(GETDATE())";
            //Adicionando e obtendo a primaryKey
            psRegistro = conexao.prepareStatement(sqlReg, PreparedStatement.RETURN_GENERATED_KEYS);
            psRegistro.executeUpdate();
            
            //Atribuindo a chave primária a uma variável
            generatedKeys = psRegistro.getGeneratedKeys();
            
            //No caso da transfêrencia, ele satisfaz as duas condiçãos, uma para saída e outra para entrada.
            if(generatedKeys.next()){               
                int idRegistro = generatedKeys.getInt(1);             
                String sqlMov = "INSERT INTO MovimentoCaixa (Pessoa,TransferenciaDeposito,ValorEntrada,ValorSaida,ContaCaixa,Complemento,Igreja,UsuarioCadastro,DataMovimento,DataPagamentoRecebimento) VALUES(?,?,?,?,?,?,?,?,GETDATE(),?)";
            
                if(tpOpe == 1 || tpOpe == 3){ //Verifica se a operação é de saída
                    psMovimento = conexao.prepareStatement(sqlMov);                       

                    psMovimento.setInt(1, mvCaixa.getTransferecia().getPessoa().getCodigo());
                    psMovimento.setInt(2, idRegistro);
                    psMovimento.setDouble(3, 0);
                    psMovimento.setDouble(4, mvCaixa.getTransferecia().getValorEntradaSaida());
                    psMovimento.setInt(5, mvCaixa.getTransferecia().getCxSaida().getCodigo());
                    psMovimento.setString(6, mvCaixa.getComplemento());
                    psMovimento.setInt(7, mvCaixa.getIgreja().getCodigo());
                    psMovimento.setInt(8, mvCaixa.getUsuarioCadastro().getCodigo());
                    psMovimento.setDate(9, (Date) mvCaixa.getDataPagamentoRecebimento());
                    psMovimento.executeUpdate();

                }
                
                if(tpOpe == 1 || tpOpe == 2){//Verifica que a operação é de depósito e adiciona a entrada
                    psMovimento = conexao.prepareStatement(sqlMov);

                    psMovimento.setInt(1, mvCaixa.getTransferecia().getPessoa().getCodigo());
                    psMovimento.setInt(2, idRegistro);
                    psMovimento.setDouble(3, mvCaixa.getTransferecia().getValorEntradaSaida());
                    psMovimento.setDouble(4, 0);
                    psMovimento.setInt(5, mvCaixa.getTransferecia().getCxEntrada().getCodigo());
                    psMovimento.setString(6, mvCaixa.getComplemento());
                    psMovimento.setInt(7, mvCaixa.getIgreja().getCodigo());
                    psMovimento.setInt(8, mvCaixa.getUsuarioCadastro().getCodigo());
                    psMovimento.setDate(9, (Date) mvCaixa.getDataPagamentoRecebimento());
                    psMovimento.executeUpdate();
                }         
            }
           
            //Confimar a transação, ou seja, a inserção dos dados
            conexao.commit();
            JOptionPane.showMessageDialog(null, "Serviço bancário efetuado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            //Se ocorrer um erro, fazer rollback da transação
            if(conexao != null){
                try{
                    conexao.rollback();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao efetuar o serviço bancário", "Erro 011", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Fechar os recursos abertos
            try{
                if(rs != null) rs.close();
                if(psRegistro != null) psRegistro.close();
                if(psMovimento != null) psMovimento.close();
                if(conexao != null) conexao.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void excluirOperacaoBancaria(TransferenciaConta transf){
        try{
            conexao = Conexao.getDataSource().getConnection();
            String sql = "DELETE FROM TransferenciaDeposito WHERE Codigo=?";
                    
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, transf.getCodigo());

            ps.executeUpdate();           
            
            JOptionPane.showMessageDialog(null, "Transferência/Deposito excluído com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir a Transferência/Deposito. ", "Erro 014", JOptionPane.ERROR_MESSAGE);
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
