
package dao;

import ferramentas.Conversores;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.ContaCaixa;
import model.ContasPagar;
import model.FormaPagto;
import model.MovimentoCaixa;
import model.Pessoa;
import model.RegistroDizimoOferta;
import model.TipoOferta;
import model.TransferenciaConta;



public class MovimentoCaixaDao {
    
    private Conversores converteData = new Conversores();
    ContasPagarDao cpDao = new ContasPagarDao();
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public List<MovimentoCaixa> consultarMovimentacao(MovimentoCaixa movimento, Date dataPagtoRecInicial, Date dataPagtoRecFinal, Date dataMovimentoInicial, Date dataMovimentoFinal, Integer tpMovimento){
              
        List<MovimentoCaixa> listaMovimento = new ArrayList<>();
        
        String sql = "SELECT "
            + "P.Nome As Pessoa, "
            + "MF.RegistroOferta As RegistroOferta, "
            + "MF.RegistroContaPagar As RegistroContaPagar, "
            + "MF.Complemento As Complemento, "
            + "MF.ValorEntrada As ValorEntrada, "
            + "MF.ValorSaida As ValorSaida, "
            + "CX.Descricao As ContaCaixa, "
            + "FP.Descricao As FormaPagto, "
            + "MF.DataMovimento As DataMovimento, "
            + "MF.DataPagamentoRecebimento As DataPagamentoRecebimento, "
            + "MF.Codigo As Codigo, "
            + "RG.TipoOferta As TipoOferta, "
            + "MF.TransferenciaDeposito As TransferenciaDeposito "
            + "FROM MovimentoCaixa As MF "
            + "INNER JOIN Pessoas As P ON P.Codigo = MF.Pessoa "
            + "INNER JOIN ContasCaixa As CX ON CX.Codigo = MF.ContaCaixa "
            + "LEFT JOIN FormasPagamento As FP ON FP.Codigo = MF.FormaPagto "
            + "LEFT JOIN RegistroDizimoOferta As RG ON RG.Codigo = MF.RegistroOferta "
            + "WHERE (? IS NULL OR MF.DataMovimento BETWEEN ? AND ?) "
            + "AND (? IS NULL OR MF.DataPagamentoRecebimento BETWEEN ? AND ?) "
            + "AND (? IS NULL OR MF.ContaCaixa = ?) "
            + "AND (? IS NULL OR MF.Igreja = ?) "
            + "AND (? IS NULL OR MF.FormaPagto = ?) "
            + "AND (? IS NULL OR MF.Complemento LIKE ?) "
            + "AND (? IS NULL OR MF.Pessoa = ?) "
            + "AND (? IS NULL OR MF.ValorEntrada > ?) "
            + "AND (? IS NULL OR MF.ValorSaida > ?) "
            + "AND (? IS NULL OR RG.TipoOferta = ?) ";
        
        try {    
             
            conexao = Conexao.getDataSource().getConnection();
            ps = conexao.prepareStatement(sql);  
            
            // Parametro Datas Movimento
            if (dataMovimentoInicial != null && dataMovimentoFinal != null) {
                ps.setDate(1, new java.sql.Date(dataMovimentoInicial.getTime()));
                ps.setDate(2, new java.sql.Date(dataMovimentoInicial.getTime()));
                ps.setDate(3, new java.sql.Date(dataMovimentoFinal.getTime()));
            } else {
                ps.setNull(1, java.sql.Types.DATE);
                ps.setNull(2, java.sql.Types.DATE);
                ps.setNull(3, java.sql.Types.DATE);
            }
            
            // Parametro Datas Pagamento e Recbimento
            if (dataPagtoRecInicial != null && dataPagtoRecFinal != null) {
                ps.setDate(4, new java.sql.Date(dataPagtoRecInicial.getTime()));
                ps.setDate(5, new java.sql.Date(dataPagtoRecInicial.getTime()));
                ps.setDate(6, new java.sql.Date(dataPagtoRecFinal.getTime()));
            } else {
                ps.setNull(4, java.sql.Types.DATE);
                ps.setNull(5, java.sql.Types.DATE);
                ps.setNull(6, java.sql.Types.DATE);
            }
            
            //Parametro da Conta Caixa
            if (movimento.getContaCaixa() != null) {
                ps.setInt(7, movimento.getContaCaixa().getCodigo());
                ps.setInt(8, movimento.getContaCaixa().getCodigo());
            } else {
                ps.setNull(7, java.sql.Types.INTEGER);
                ps.setNull(8, java.sql.Types.INTEGER);
            }

            //Parametro da Igreja
            if (movimento.getIgreja() != null) {
                ps.setInt(9, movimento.getIgreja().getCodigo());
                ps.setInt(10, movimento.getIgreja().getCodigo());
            } else {
                ps.setNull(9, java.sql.Types.INTEGER);
                ps.setNull(10, java.sql.Types.INTEGER);
            }

            //Parametro da Forma de Pagamento
            if (movimento.getFormaPagto() != null) {
                ps.setInt(11, movimento.getFormaPagto().getCodigo());
                ps.setInt(12, movimento.getFormaPagto().getCodigo());
            } else {
                ps.setNull(11, java.sql.Types.INTEGER);
                ps.setNull(12, java.sql.Types.INTEGER);
            }       
            
            //Parametro da descrição/complemento
            if (movimento.getComplemento() != null) {
                ps.setString(13, "%" + movimento.getComplemento() + "%");
                ps.setString(14, "%" + movimento.getComplemento() + "%");
            } else {
                ps.setNull(13, java.sql.Types.VARCHAR);
                ps.setNull(14, java.sql.Types.VARCHAR);
            }

            //Parametro de pessoa
            if (movimento.getPessoa().getCodigo() != null) {
                ps.setInt(15, movimento.getPessoa().getCodigo());
                ps.setInt(16, movimento.getPessoa().getCodigo());
            } else {
                ps.setNull(15, java.sql.Types.INTEGER);
                ps.setNull(16, java.sql.Types.INTEGER);
            }

            //Parametro do valor de entrada e saída
            if (tpMovimento != null) {
                if(tpMovimento == 1){
                    ps.setDouble(17, 0);
                    ps.setDouble(18, 0);
                    ps.setNull(19, java.sql.Types.DOUBLE);
                    ps.setNull(20, java.sql.Types.DOUBLE);
                }else if(tpMovimento == 2){
                    ps.setNull(17, java.sql.Types.DOUBLE);
                    ps.setNull(18, java.sql.Types.DOUBLE);
                    ps.setDouble(19, 0);
                    ps.setDouble(20, 0);
                }

            } else {
                ps.setNull(17, java.sql.Types.INTEGER);
                ps.setNull(18, java.sql.Types.INTEGER);
                ps.setNull(19, java.sql.Types.INTEGER);
                ps.setNull(20, java.sql.Types.INTEGER);
            }
            
            //Parametro do tipo de oferta
            if (movimento.getRgOferta().getTpOferta() != null) {
                ps.setInt(21, movimento.getRgOferta().getTpOferta().getCodigo());
                ps.setInt(22, movimento.getRgOferta().getTpOferta().getCodigo());
            } else {
                ps.setNull(21, java.sql.Types.INTEGER);
                ps.setNull(22, java.sql.Types.INTEGER);
            }   
                      
            // Executando a consultarMovimentacao
            rs = ps.executeQuery();

            // Iterando sobre os resultados
            while (rs.next()) {               
                String dataPag = converteData.convertendoDataStringSql(rs.getDate("DataPagamentoRecebimento"));
                String dataMov = converteData.convertendoDataStringSql(rs.getDate("DataMovimento"));
                
                Pessoa pessoa = new Pessoa(); 
                ContaCaixa contaCaixa = new ContaCaixa();
                FormaPagto formaPagto = new FormaPagto();
                MovimentoCaixa mvCaixa = new MovimentoCaixa();
                TipoOferta tpOferta = new TipoOferta();
                RegistroDizimoOferta rgDizimoOferta = new RegistroDizimoOferta();
                TransferenciaConta transfDepos = new TransferenciaConta();
                ContasPagar contaPagar = new ContasPagar();
                
                pessoa.setNome(rs.getString("Pessoa")); 
                contaCaixa.setNome(rs.getString("ContaCaixa"));
                formaPagto.setNome(rs.getString("FormaPagto"));
                tpOferta.setCodigo(rs.getInt("TipoOferta"));
                rgDizimoOferta.setTpOferta(tpOferta);
                rgDizimoOferta.setCodRegistro(rs.getInt("RegistroOferta"));
                transfDepos.setCodigo(rs.getInt("TransferenciaDeposito"));
                contaPagar.setCodigo(rs.getInt("RegistroContaPagar"));
                
                mvCaixa.setValorEntrada(rs.getDouble("ValorEntrada"));
                mvCaixa.setValorSaida(rs.getDouble("ValorSaida"));
                mvCaixa.setComplemento(rs.getString("Complemento"));
                mvCaixa.setCodigo(rs.getInt("Codigo"));
                mvCaixa.setDataMovimento(dataMov);
                mvCaixa.setDataPagamentoRecebimento(dataPag);
                mvCaixa.setContaCaixa(contaCaixa);
                mvCaixa.setFormaPagto(formaPagto);
                mvCaixa.setPessoa(pessoa);
                mvCaixa.setRgOferta(rgDizimoOferta);
                mvCaixa.setTransferecia(transfDepos);
                mvCaixa.setContaPagar(contaPagar);
                
                listaMovimento.add(mvCaixa);
            
            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Erro ao tentar consultar as movimentações financeira", "Erro 012", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "Erro ao consultar as movimentações financeiras: " + e.getMessage(), "Erro SQL", JOptionPane.ERROR_MESSAGE);

        } finally {
            // Fechando recursos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return listaMovimento;
    }

    public void movimentarContasPagar (List<MovimentoCaixa> mvContaPagar){
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            for(MovimentoCaixa mv : mvContaPagar){ 
                String sql = "INSERT INTO MovimentoCaixa (Pessoa,RegistroContaPagar,ValorEntrada,ValorSaida,ContaCaixa,Complemento,FormaPagto,Igreja,UsuarioCadastro,DataMovimento,DataPagamentoRecebimento) VALUES(?,?,?,?,?,?,?,?,?,GETDATE(),?)";
                ps = conexao.prepareStatement(sql);
                
                ps.setInt(1, mv.getContaPagar().getFornecedor().getCodigo());
                ps.setInt(2, mv.getContaPagar().getCodigo());
                ps.setDouble(3, 0);
                ps.setDouble(4, mv.getContaPagar().getValor());
                ps.setInt(5, mv.getContaCaixa().getCodigo());
                ps.setString(6, mv.getComplemento());
                ps.setInt(7, mv.getFormaPagto().getCodigo());
                ps.setInt(8, mv.getContaPagar().getIgreja().getCodigo());
                ps.setInt(9, 1);
                ps.setString(10, mv.getDataPagamentoRecebimento());
                
                ps.executeUpdate();

                //Atualizando o status da conta para "paga"
                cpDao.alterarStatusContaPagar(mv.getContaPagar(), mv.getDataPagamentoRecebimento());
            }
            //Confimar a transação, ou seja, a inserção dos dados
            conexao.commit();
            JOptionPane.showMessageDialog(null, "Conta(s) efetivada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            //Se ocorrer um erro, fazer rollback da transação
            if(conexao != null){
                try{
                    conexao.rollback();
                }catch(SQLException e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetivar a(s) conta(s)", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Fechar os recursos abertos
            try{
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(conexao != null) conexao.close();
            }catch(SQLException ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public MovimentoCaixa consultarSaldo (MovimentoCaixa filtros){
        
        MovimentoCaixa mvCaixa = new MovimentoCaixa();
        
        String sql = "SELECT "
            + "SUM(ValorEntrada) As ValorEntrada, "
            + "SUM(ValorSaida) As ValorSaida "
            + "FROM MovimentoCaixa "
            + "WHERE ContaCaixa = ?";
          
        try {                
            conexao = Conexao.getDataSource().getConnection();
            ps = conexao.prepareStatement(sql);  
              
            ps.setInt(1, filtros.getContaCaixa().getCodigo());
    
            // Executando a consultarMovimentacao
            rs = ps.executeQuery();

            // Iterando sobre os resultados
            while (rs.next()) {               
                mvCaixa.setValorEntrada(rs.getDouble("ValorEntrada"));
                mvCaixa.setValorSaida(rs.getDouble("ValorSaida"));
            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Erro ao tentar consultar as movimentações financeira", "Erro 012", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "Erro ao consultar o saldo dos caixas: " + e.getMessage(), "Erro SQL", JOptionPane.ERROR_MESSAGE);

        } finally {
            // Fechando recursos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return mvCaixa;
    }
    
    public void excluirMovimentacao (List<MovimentoCaixa> mvCaixaExcluido){
                
        try{
            conexao = Conexao.getDataSource().getConnection();
            String sql = "DELETE FROM MovimentoCaixa WHERE Codigo=?";
            
            for(MovimentoCaixa mv : mvCaixaExcluido){                
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, mv.getCodigo());

                ps.executeUpdate();
            }
            
            JOptionPane.showMessageDialog(null, "Movimentação excluída com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir a movimentação. Verifique se a movimentação é referente ao contas a pagar. ", "Erro 014", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
