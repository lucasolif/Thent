
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
            
            //Query que ser� executada
            String sqlReg = "INSERT INTO TransferenciaDeposito (DataOperacao) VALUES(GETDATE())";
            //Adicionando e obtendo a primaryKey
            psRegistro = conexao.prepareStatement(sqlReg, PreparedStatement.RETURN_GENERATED_KEYS);
            psRegistro.executeUpdate();
            
            //Atribuindo a chave prim�ria a uma vari�vel
            generatedKeys = psRegistro.getGeneratedKeys();
            
            //No caso da transf�rencia, ele satisfaz as duas condi��os, uma para sa�da e outra para entrada.
            if(generatedKeys.next()){               
                int idRegistro = generatedKeys.getInt(1);             
                String sqlMov = "INSERT INTO MovimentoCaixa (Pessoa,TransferenciaDeposito,ValorEntrada,ValorSaida,ContaCaixa,Complemento,Igreja,UsuarioCadastro,DataMovimento,DataPagamentoRecebimento) VALUES(?,?,?,?,?,?,?,?,GETDATE(),?)";
            
                if(tpOpe == 1 || tpOpe == 3){ //Verifica se a opera��o � de sa�da
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
                
                if(tpOpe == 1 || tpOpe == 2){//Verifica que a opera��o � de dep�sito e adiciona a entrada
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
           
            //Confimar a transa��o, ou seja, a inser��o dos dados
            conexao.commit();
            JOptionPane.showMessageDialog(null, "Servi�o banc�rio efetuado com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            //Se ocorrer um erro, fazer rollback da transa��o
            if(conexao != null){
                try{
                    conexao.rollback();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao efetuar o servi�o banc�rio", "Erro 011", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Fechar os recursos abertos
            try{
                if(rs != null) rs.close();
                if(psRegistro != null) psRegistro.close();
                if(psMovimento != null) psMovimento.close();
                if(conexao != null) conexao.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
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
            
            JOptionPane.showMessageDialog(null, "Transfer�ncia/Deposito exclu�do com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir a Transfer�ncia/Deposito. ", "Erro 014", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
