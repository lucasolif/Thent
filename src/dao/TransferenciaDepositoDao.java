
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.ContaCaixa;
import model.MovimentoCaixa;
import model.TransferenciaConta;
import model.UsuarioLogado;

public class TransferenciaDepositoDao {
    
    private final LogsDao logsDao = new LogsDao();
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private PreparedStatement stmSelect = null;
    private ResultSet rs = null;
    
    public void realizarOperacoesBancarias(MovimentoCaixa mvCaixa, int tpOpe, UsuarioLogado usuarioLogado){

        PreparedStatement psRegistro = null;
        PreparedStatement psMovimento = null;
        ResultSet generatedKeys = null;
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            //Query que será executada
            String sqlReg = "INSERT INTO TransferenciaDeposito (DataOperacao, DepositoTesourariaGeral, Usuario) VALUES(GETDATE(), ?,?)";
            //Adicionando e obtendo a primaryKey
            psRegistro = conexao.prepareStatement(sqlReg, PreparedStatement.RETURN_GENERATED_KEYS);
            psRegistro.setInt(1, mvCaixa.getTransferecia().getDpTesourariaGeral());
            psRegistro.setInt(2, usuarioLogado.getCodUsuario());
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
                    psMovimento.setInt(8, usuarioLogado.getCodUsuario());
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
                    psMovimento.setInt(8, usuarioLogado.getCodUsuario());
                    psMovimento.setDate(9, (Date) mvCaixa.getDataPagamentoRecebimento());
                    psMovimento.executeUpdate();
                }         
            }
           
            //Confimar a transação, ou seja, a inserção dos dados
            conexao.commit();
            JOptionPane.showMessageDialog(null, "Serviço bancário efetuado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);           
        }catch(SQLException ex){
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            //Se ocorrer um erro, fazer rollback da transação
            if(conexao != null){
                try{
                    conexao.rollback();
                }catch(SQLException e){
                    logsDao.gravaLogsErro(e.getSQLState()+" - "+e.getMessage());
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
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
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
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
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
    
    public List<MovimentoCaixa> consultarDepositoTerourariaGeral(Integer mes, Integer ano, ContaCaixa contaCaixa){
              
        List<MovimentoCaixa> listaMovimentoCaixa = new ArrayList<>();

        // Montando a query SQL com placeholders
        String sql = "SELECT MC.Complemento AS Complemento, " +
            "SUM(MC.ValorSaida) AS ValorSaida " +
            "FROM MovimentoCaixa AS MC " +
            "WHERE MC.ContaCaixa = ? " +
            "AND MONTH((SELECT DataOperacao FROM TransferenciaDeposito AS TD WHERE MC.TransferenciaDeposito = TD.Codigo)) = ? " +
            "AND YEAR((SELECT DataOperacao FROM TransferenciaDeposito AS TD WHERE MC.TransferenciaDeposito = TD.Codigo)) = ? " +
            "AND (SELECT DepositoTesourariaGeral FROM TransferenciaDeposito AS TD WHERE MC.TransferenciaDeposito = TD.Codigo) = 1 " +
            "AND MC.TransferenciaDeposito IS NOT NULL " +
            "AND MC.ValorSaida > 0 " +
            "GROUP BY MC.Complemento";     
        
        try {
            this.conexao = Conexao.getDataSource().getConnection();         
            this.stmSelect = this.conexao.prepareStatement(sql);  
            
            //Paramentro para o mes e ano
            this.stmSelect.setInt(1, contaCaixa.getCodigo());
            this.stmSelect.setInt(2, mes);
            this.stmSelect.setInt(3, ano);
    
            this.rs = this.stmSelect.executeQuery();

            // Iterando sobre os resultados
            while (rs.next()) {

                MovimentoCaixa movimentoCaixa = new MovimentoCaixa();
                movimentoCaixa.setComplemento(this.rs.getString("Complemento"));
                movimentoCaixa.setValorSaida(this.rs.getDouble("ValorSaida"));
                
                listaMovimentoCaixa.add(movimentoCaixa);
            }

        } catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar as operações do caixa referente ao deposito da tesouraria geral", "Erro 001", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (this.rs != null) this.rs.close();
                if (this.stmSelect != null) this.stmSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaMovimentoCaixa;   
    }
}
