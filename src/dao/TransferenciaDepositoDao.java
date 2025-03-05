
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
import model.Igreja;
import model.MovimentoCaixa;
import model.RegistroDizimoOferta;
import model.TransferenciaConta;
import model.Usuario;

public class TransferenciaDepositoDao {
    
    private final LogsDao logsDao = new LogsDao();
    private final RegistroOfertaDao rgOfertaDao = new RegistroOfertaDao();
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private PreparedStatement stmSelect = null;
    private PreparedStatement stmInsert = null;
    private ResultSet rs = null;
    
    public void realizarOperacoesBancarias(MovimentoCaixa mvCaixa, int tpOpe, Usuario usuarioLogado){

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
            psRegistro.setInt(2, usuarioLogado.getCodigo());
            psRegistro.executeUpdate();
            
            //Atribuindo a chave primária a uma variável
            generatedKeys = psRegistro.getGeneratedKeys();
            
            //No caso da transfêrencia, ele satisfaz as duas condiçãos, uma para saída e outra para entrada.
            if(generatedKeys.next()){               
                int idTransfer = generatedKeys.getInt(1);             
                String sqlMov = "INSERT INTO MovimentoCaixa (Pessoa,TransferenciaDeposito,ValorEntrada,ValorSaida,ContaCaixa,Complemento,Igreja,UsuarioCadastro,DataMovimento,DataPagamentoRecebimento) VALUES(?,?,?,?,?,?,?,?,GETDATE(),?)";
            
                if(tpOpe == 1 || tpOpe == 3){ //Verifica se a operação é de saída
                    psMovimento = conexao.prepareStatement(sqlMov);                       

                    psMovimento.setInt(1, mvCaixa.getTransferecia().getPessoa().getCodigo());
                    psMovimento.setInt(2, idTransfer);
                    psMovimento.setDouble(3, 0);
                    psMovimento.setDouble(4, mvCaixa.getTransferecia().getValorEntradaSaida());
                    psMovimento.setInt(5, mvCaixa.getTransferecia().getCxSaida().getCodigo());
                    psMovimento.setString(6, mvCaixa.getComplemento());
                    psMovimento.setInt(7, mvCaixa.getIgreja().getCodigo());
                    psMovimento.setInt(8, usuarioLogado.getCodigo());
                    psMovimento.setDate(9, (Date) mvCaixa.getDataPagamentoRecebimento());
                    psMovimento.executeUpdate();
                    
                    //Para movimento tipo oferta
                    RegistroDizimoOferta rgDizimoOferta = new RegistroDizimoOferta();
                    rgDizimoOferta.setTpOferta(mvCaixa.getRgOferta().getTpOferta());
                    rgDizimoOferta.setValorOfertaEntrada(0);
                    rgDizimoOferta.setValorOfertaSaida(mvCaixa.getTransferecia().getValorEntradaSaida());
                    rgDizimoOferta.setContaCaixa(mvCaixa.getTransferecia().getCxSaida());
                    rgDizimoOferta.setIgreja(mvCaixa.getIgreja());
                    rgDizimoOferta.setComplemento(mvCaixa.getComplemento());
                    rgDizimoOferta.setDataOferta(mvCaixa.getDataPagamentoRecebimento());
                            
                    this.rgOfertaDao.registrarMovimentacaoDizimoOferta(rgDizimoOferta, usuarioLogado);

                }
                
                if(tpOpe == 1 || tpOpe == 2){//Verifica que a operação é de depósito e adiciona a entrada
                    psMovimento = conexao.prepareStatement(sqlMov);

                    psMovimento.setInt(1, mvCaixa.getTransferecia().getPessoa().getCodigo());
                    psMovimento.setInt(2, idTransfer);
                    psMovimento.setDouble(3, mvCaixa.getTransferecia().getValorEntradaSaida());
                    psMovimento.setDouble(4, 0);
                    psMovimento.setInt(5, mvCaixa.getTransferecia().getCxEntrada().getCodigo());
                    psMovimento.setString(6, mvCaixa.getComplemento());
                    psMovimento.setInt(7, mvCaixa.getIgreja().getCodigo());
                    psMovimento.setInt(8, usuarioLogado.getCodigo());
                    psMovimento.setDate(9, (Date) mvCaixa.getDataPagamentoRecebimento());
                    psMovimento.executeUpdate();
                    
                    //Para movimento tipo oferta
                    RegistroDizimoOferta rgDizimoOferta = new RegistroDizimoOferta();
                    rgDizimoOferta.setTpOferta(mvCaixa.getRgOferta().getTpOferta());
                    rgDizimoOferta.setValorOfertaEntrada(mvCaixa.getTransferecia().getValorEntradaSaida());
                    rgDizimoOferta.setValorOfertaSaida(0);
                    rgDizimoOferta.setContaCaixa(mvCaixa.getTransferecia().getCxEntrada());
                    rgDizimoOferta.setIgreja(mvCaixa.getIgreja());
                    rgDizimoOferta.setComplemento(mvCaixa.getComplemento());
                    rgDizimoOferta.setDataOferta(mvCaixa.getDataPagamentoRecebimento());
                            
                    this.rgOfertaDao.registrarMovimentacaoDizimoOferta(rgDizimoOferta, usuarioLogado);
                }         
            }
           
            //Confimar a transação, ou seja, a inserção dos dados
            conexao.commit();
            JOptionPane.showMessageDialog(null, "Serviço bancário efetuado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);           
        }catch(SQLException ex){
            logsDao.gravaLogsErro("TrasnferenciaDepositoDao - "+ex.getSQLState()+" - "+ex.getMessage());
            //Se ocorrer um erro, fazer rollback da transação
            if(conexao != null){
                try{
                    conexao.rollback();
                }catch(SQLException e){
                    logsDao.gravaLogsErro("TrasnferenciaDepositoDao - "+e.getSQLState()+" - "+e.getMessage());
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
                logsDao.gravaLogsErro("TrasnferenciaDepositoDao - "+ex.getSQLState()+" - "+ex.getMessage());
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
            logsDao.gravaLogsErro("TrasnferenciaDepositoDao - "+ex.getSQLState()+" - "+ex.getMessage());
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("TrasnferenciaDepositoDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public List<MovimentoCaixa> consultarDepositoTerourariaGeral(Integer mes, Integer ano, Igreja igreja, String fitroContaCaixa){
              
        List<MovimentoCaixa> listaMovimentoCaixa = new ArrayList<>();

        // Montando a query SQL com placeholders
        String sql = "SELECT MC.Complemento AS Complemento, " +
            "SUM(MC.ValorSaida) AS ValorSaida " +
            "FROM MovimentoCaixa AS MC " +
            "WHERE MC.Igreja = ? " +
            "AND MONTH((SELECT DataOperacao FROM TransferenciaDeposito AS TD WHERE MC.TransferenciaDeposito = TD.Codigo)) = ? " +
            "AND YEAR((SELECT DataOperacao FROM TransferenciaDeposito AS TD WHERE MC.TransferenciaDeposito = TD.Codigo)) = ? " +
            "AND (SELECT DepositoTesourariaGeral FROM TransferenciaDeposito AS TD WHERE MC.TransferenciaDeposito = TD.Codigo) = 1 " +
            "AND MC.TransferenciaDeposito IS NOT NULL " +
            "AND MC.ValorSaida > 0 " +
            "AND MC.ContaCaixa In ("+fitroContaCaixa+") " +
            "GROUP BY MC.Complemento";     
        
        try {
            this.conexao = Conexao.getDataSource().getConnection();         
            this.stmSelect = this.conexao.prepareStatement(sql);  
            
            //Paramentro para o mes e ano
            this.stmSelect.setInt(1, igreja.getCodigo());
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
            logsDao.gravaLogsErro("TrasnferenciaDepositoDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar as operações do caixa referente ao deposito da tesouraria geral", "Erro 001", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (this.rs != null) this.rs.close();
                if (this.stmSelect != null) this.stmSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("TrasnferenciaDepositoDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaMovimentoCaixa;   
    }
    
    //Adicionar os registros de dizimo e ofertas no movimento de dizimo e ofertas
    /*private void adicionarOfertaDizimoMovimentoTipoOferta (RegistroDizimoOferta registroOferta, Usuario usuarioLogado){
        
        try{
            // Inserir dados na segunda tabela usando a chave primária da primeira tabela
            String sql = "INSERT INTO MovimentoDizimoOferta (TipoOferta,Entrada,Saida,Complemento,ContaCaixa,Igreja,UsuarioCadastro,DataOferta,DataMovimento) VALUES(?,?,?,?,?,?,?,?,GETDATE())";
            stmInsert = conexao.prepareStatement(sql);

            stmInsert.setInt(1, registroOferta.getTpOferta().getCodigo());
            stmInsert.setDouble(2, registroOferta.getValorOfertaEntrada());
            stmInsert.setDouble(3, registroOferta.getValorOfertaSaida());
            stmInsert.setString(4, registroOferta.getComplemento());
            stmInsert.setInt(5, registroOferta.getContaCaixa().getCodigo());
            stmInsert.setInt(6, registroOferta.getIgreja().getCodigo());
            stmInsert.setInt(7, usuarioLogado.getCodigo());
            stmInsert.setDate(8, (Date) registroOferta.getDataOferta());
            stmInsert.execute();
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro("TrasnferenciaDepositoDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar movimentação de dizimo e oferta", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }
    }*/
}
