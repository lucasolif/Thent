
package dao;
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
    

    private final ContasPagarDao cpDao = new ContasPagarDao();
    private final CampanhaDao campanhaDao = new CampanhaDao();
    private Connection conexao = null;
    private PreparedStatement stmInsert = null;
    private PreparedStatement stmSelect = null;
    private PreparedStatement stmDelete = null;
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
             
            this.conexao = Conexao.getDataSource().getConnection();
            this.stmSelect = this.conexao.prepareStatement(sql);  
            
            // Parametro Datas Movimento
            if (dataMovimentoInicial != null && dataMovimentoFinal != null) {
                this.stmSelect.setDate(1, new java.sql.Date(dataMovimentoInicial.getTime()));
                this.stmSelect.setDate(2, new java.sql.Date(dataMovimentoInicial.getTime()));
                this.stmSelect.setDate(3, new java.sql.Date(dataMovimentoFinal.getTime()));
            } else {
                this.stmSelect.setNull(1, java.sql.Types.DATE);
                this.stmSelect.setNull(2, java.sql.Types.DATE);
                this.stmSelect.setNull(3, java.sql.Types.DATE);
            }
            
            // Parametro Datas Pagamento e Recbimento
            if (dataPagtoRecInicial != null && dataPagtoRecFinal != null) {
                this.stmSelect.setDate(4, new java.sql.Date(dataPagtoRecInicial.getTime()));
                this.stmSelect.setDate(5, new java.sql.Date(dataPagtoRecInicial.getTime()));
                this.stmSelect.setDate(6, new java.sql.Date(dataPagtoRecFinal.getTime()));
            } else {
                this.stmSelect.setNull(4, java.sql.Types.DATE);
                this.stmSelect.setNull(5, java.sql.Types.DATE);
                this.stmSelect.setNull(6, java.sql.Types.DATE);
            }
            
            //Parametro da Conta Caixa
            if (movimento.getContaCaixa() != null) {
                this.stmSelect.setInt(7, movimento.getContaCaixa().getCodigo());
                this.stmSelect.setInt(8, movimento.getContaCaixa().getCodigo());
            } else {
                this.stmSelect.setNull(7, java.sql.Types.INTEGER);
                this.stmSelect.setNull(8, java.sql.Types.INTEGER);
            }

            //Parametro da Igreja
            if (movimento.getIgreja() != null) {
                this.stmSelect.setInt(9, movimento.getIgreja().getCodigo());
                this.stmSelect.setInt(10, movimento.getIgreja().getCodigo());
            } else {
                this.stmSelect.setNull(9, java.sql.Types.INTEGER);
                this.stmSelect.setNull(10, java.sql.Types.INTEGER);
            }

            //Parametro da Forma de Pagamento
            if (movimento.getFormaPagto() != null) {
                this.stmSelect.setInt(11, movimento.getFormaPagto().getCodigo());
                this.stmSelect.setInt(12, movimento.getFormaPagto().getCodigo());
            } else {
                this.stmSelect.setNull(11, java.sql.Types.INTEGER);
                this.stmSelect.setNull(12, java.sql.Types.INTEGER);
            }       
            
            //Parametro da descrição/complemento
            if (movimento.getComplemento() != null) {
                this.stmSelect.setString(13, "%" + movimento.getComplemento() + "%");
                this.stmSelect.setString(14, "%" + movimento.getComplemento() + "%");
            } else {
                this.stmSelect.setNull(13, java.sql.Types.VARCHAR);
                this.stmSelect.setNull(14, java.sql.Types.VARCHAR);
            }

            //Parametro de pessoa
            if (movimento.getPessoa().getCodigo() != null) {
                this.stmSelect.setInt(15, movimento.getPessoa().getCodigo());
                this.stmSelect.setInt(16, movimento.getPessoa().getCodigo());
            } else {
                this.stmSelect.setNull(15, java.sql.Types.INTEGER);
                this.stmSelect.setNull(16, java.sql.Types.INTEGER);
            }

            //Parametro do valor de entrada e saída
            if (tpMovimento != null) {
                if(tpMovimento == 1){
                    this.stmSelect.setDouble(17, 0);
                    this.stmSelect.setDouble(18, 0);
                    this.stmSelect.setNull(19, java.sql.Types.DOUBLE);
                    this.stmSelect.setNull(20, java.sql.Types.DOUBLE);
                }else if(tpMovimento == 2){
                    this.stmSelect.setNull(17, java.sql.Types.DOUBLE);
                    this.stmSelect.setNull(18, java.sql.Types.DOUBLE);
                    this.stmSelect.setDouble(19, 0);
                    this.stmSelect.setDouble(20, 0);
                }

            } else {
                this.stmSelect.setNull(17, java.sql.Types.INTEGER);
                this.stmSelect.setNull(18, java.sql.Types.INTEGER);
                this.stmSelect.setNull(19, java.sql.Types.INTEGER);
                this.stmSelect.setNull(20, java.sql.Types.INTEGER);
            }
            
            //Parametro do tipo de oferta
            if (movimento.getRgOferta().getTpOferta() != null) {
                this.stmSelect.setInt(21, movimento.getRgOferta().getTpOferta().getCodigo());
                this.stmSelect.setInt(22, movimento.getRgOferta().getTpOferta().getCodigo());
            } else {
                this.stmSelect.setNull(21, java.sql.Types.INTEGER);
                this.stmSelect.setNull(22, java.sql.Types.INTEGER);
            }   
                      
            // Executando a consultarMovimentacao
            this.rs = this.stmSelect.executeQuery();

            // Iterando sobre os resultados
            while (this.rs.next()) {               
                Pessoa pessoa = new Pessoa(); 
                ContaCaixa contaCaixa = new ContaCaixa();
                FormaPagto formaPagto = new FormaPagto();
                MovimentoCaixa mvCaixa = new MovimentoCaixa();
                TipoOferta tpOferta = new TipoOferta();
                RegistroDizimoOferta rgDizimoOferta = new RegistroDizimoOferta();
                TransferenciaConta transfDepos = new TransferenciaConta();
                ContasPagar contaPagar = new ContasPagar();
                
                pessoa.setNome(this.rs.getString("Pessoa")); 
                contaCaixa.setNome(this.rs.getString("ContaCaixa"));
                formaPagto.setNome(this.rs.getString("FormaPagto"));
                tpOferta.setCodigo(this.rs.getInt("TipoOferta"));
                rgDizimoOferta.setTpOferta(tpOferta);
                rgDizimoOferta.setCodRegistro(this.rs.getInt("RegistroOferta"));
                transfDepos.setCodigo(this.rs.getInt("TransferenciaDeposito"));
                contaPagar.setCodigo(this.rs.getInt("RegistroContaPagar"));               
                mvCaixa.setValorEntrada(this.rs.getDouble("ValorEntrada"));
                mvCaixa.setValorSaida(this.rs.getDouble("ValorSaida"));
                mvCaixa.setComplemento(this.rs.getString("Complemento"));
                mvCaixa.setCodigo(this.rs.getInt("Codigo"));
                mvCaixa.setDataMovimento(this.rs.getDate("DataMovimento"));
                mvCaixa.setDataPagamentoRecebimento(this.rs.getDate("DataPagamentoRecebimento"));
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
                if (this.rs != null) this.rs.close();
                if (this.stmSelect != null) this.stmSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return listaMovimento;
    }

    public void movimentarContasPagar (List<MovimentoCaixa> mvContaPagar){
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();
            this.conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            for(MovimentoCaixa mv : mvContaPagar){ 
                String sql = "INSERT INTO MovimentoCaixa (Pessoa,RegistroContaPagar,ValorEntrada,ValorSaida,ContaCaixa,Complemento,FormaPagto,Igreja,UsuarioCadastro,DataMovimento,DataPagamentoRecebimento) VALUES(?,?,?,?,?,?,?,?,?,GETDATE(),?)";
                this.stmInsert = this.conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                
                this.stmInsert.setInt(1, mv.getContaPagar().getFornecedor().getCodigo());
                this.stmInsert.setInt(2, mv.getContaPagar().getCodigo());
                this.stmInsert.setDouble(3, 0);
                this.stmInsert.setDouble(4, mv.getContaPagar().getValorPago());
                this.stmInsert.setInt(5, mv.getContaCaixa().getCodigo());
                this.stmInsert.setString(6, mv.getComplemento());
                this.stmInsert.setInt(7, mv.getFormaPagto().getCodigo());
                this.stmInsert.setInt(8, mv.getContaPagar().getIgreja().getCodigo());
                this.stmInsert.setInt(9, 1);
                this.stmInsert.setDate(10, (java.sql.Date) mv.getDataPagamentoRecebimento());               
                this.stmInsert.executeUpdate();
                
                this.rs = this.stmInsert.getGeneratedKeys();
                
                if(this.rs.next()){
                    this.cpDao.alterarStatusContaPagar(mv.getContaPagar(), mv.getDataPagamentoRecebimento());
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao tentar baixa a CP no caixa", "Concluído", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            this.conexao.commit();
            JOptionPane.showMessageDialog(null, "Conta(s) efetivada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            //Se ocorrer um erro, fazer rollback da transação
            if(this.conexao != null){
                try{
                    this.conexao.rollback();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetivar a(s) conta(s)", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Fechar os recursos abertos
            try{
                if(this.rs != null) this.rs.close();
                if(this.stmInsert != null) this.stmInsert.close();
                if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void movimentarContasReceberCampanha (MovimentoCaixa CrCampanha){
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();
            this.conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            String sql = "INSERT INTO MovimentoCaixa (Pessoa,RegistroContaReceberCampanha,ValorEntrada,ValorSaida,ContaCaixa,Complemento,FormaPagto,Igreja,UsuarioCadastro,DataMovimento,DataPagamentoRecebimento) VALUES(?,?,?,?,?,?,?,?,?,GETDATE(),?)";
            this.stmInsert = this.conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            this.stmInsert.setInt(1, CrCampanha.getCrCampanha().getParticipante().getCodigo());
            this.stmInsert.setInt(2, CrCampanha.getCrCampanha().getCodigo());
            this.stmInsert.setDouble(3, CrCampanha.getCrCampanha().getValorPago());
            this.stmInsert.setDouble(4, 0);
            this.stmInsert.setInt(5, CrCampanha.getContaCaixa().getCodigo());
            this.stmInsert.setString(6, CrCampanha.getComplemento());
            this.stmInsert.setInt(7, CrCampanha.getCrCampanha().getFormaPagto().getCodigo());
            this.stmInsert.setInt(8, CrCampanha.getCrCampanha().getIgreja().getCodigo());
            this.stmInsert.setInt(9, CrCampanha.getUsuarioCadastro().getCodigo());
            this.stmInsert.setDate(10, (java.sql.Date) CrCampanha.getDataPagamentoRecebimento());
            this.stmInsert.executeUpdate();
            
            this.rs = this.stmInsert.getGeneratedKeys();
            
            if(this.rs.next()){ 
                this.campanhaDao.atualizarContaReceberCampanha(CrCampanha.getCrCampanha());
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao tentar adicionar a baixa no caixa", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            }
            this.conexao.commit();
            JOptionPane.showMessageDialog(null, "Conta(s) baixada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            //Se ocorrer um erro, fazer rollback da transação
            if(this.conexao != null){
                try{
                    this.conexao.rollback();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetivar a(s) conta(s)", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if(this.rs != null) this.rs.close();
                if(this.stmInsert != null) this.stmInsert.close();
                if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
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
            this.conexao = Conexao.getDataSource().getConnection();
            this.stmSelect = this.conexao.prepareStatement(sql);  
              
            this.stmSelect.setInt(1, filtros.getContaCaixa().getCodigo());
    
            // Executando a consultarMovimentacao
            this.rs = this.stmSelect.executeQuery();

            // Iterando sobre os resultados
            while (this.rs.next()) {               
                mvCaixa.setValorEntrada(this.rs.getDouble("ValorEntrada"));
                mvCaixa.setValorSaida(this.rs.getDouble("ValorSaida"));
            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Erro ao tentar consultar as movimentações financeira", "Erro 012", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "Erro ao consultar o saldo dos caixas: " + e.getMessage(), "Erro SQL", JOptionPane.ERROR_MESSAGE);

        } finally {
            // Fechando recursos
            try {
                if (this.rs != null) this.rs.close();
                if (this.stmSelect != null) this.stmSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return mvCaixa;
    }
    
    public void excluirMovimentacao (List<MovimentoCaixa> mvCaixaExcluido){
                
        try{
            this.conexao = Conexao.getDataSource().getConnection();
            String sql = "DELETE FROM MovimentoCaixa WHERE Codigo=?";
            
            for(MovimentoCaixa mv : mvCaixaExcluido){                
                this.stmDelete = this.conexao.prepareStatement(sql);
                this.stmDelete.setInt(1, mv.getCodigo());

                this.stmDelete.executeUpdate();
            }    
            JOptionPane.showMessageDialog(null, "Movimentação excluída com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);           
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir a movimentação. Verifique se a movimentação é referente ao contas a pagar. ", "Erro 014", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.stmDelete != null) this.stmDelete.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
