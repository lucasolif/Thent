
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.ContaCaixa;
import model.ContaResultado;
import model.ContasPagar;
import model.FormaPagto;
import model.Igreja;
import model.Pessoa;
import model.SubContaResultado;
import model.Usuario;

public class ContasPagarDao {
   
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private PreparedStatement stmInsert = null;
    private PreparedStatement stmSelect = null;
    private ResultSet rs = null;
    private final LogsDao logsDao = new LogsDao();
    
    //Adiciona o contas a pagar dentro do banco de dados
    public void adicionarContasPagar(List<ContasPagar> contasPagar, Usuario usuarioLogado, boolean efetivar, ContaCaixa contaCaixa){

        ResultSet generatedKeys = null;
        String sql = null;
        
        try{
            conexao = Conexao.getDataSource().getConnection(); 
            conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            for(ContasPagar cp : contasPagar){ 
                if(efetivar){
                    sql = "INSERT INTO ContasPagar (Fornecedor,FormaPagto,Descricao,Valor,ValorPago,ValorPendente,NumNota,Parcela,DataVencimento,DataPagamento,SubContaResultado,Status,DescricaoStatus,DataCadastro,Observacao,Boleto,Igreja,UsuarioLancamento) VALUES(?,?,?,?,?,?,?,?,?,GETDATE(),?,?,?,GETDATE(),?,?,?,?)";
                }else{
                    sql = "INSERT INTO ContasPagar (Fornecedor,FormaPagto,Descricao,Valor,ValorPago,ValorPendente,NumNota,Parcela,DataVencimento,SubContaResultado,Status,DescricaoStatus,DataCadastro,Observacao,Boleto,Igreja,UsuarioLancamento) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,GETDATE(),?,?,?,?)";
                }
                ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); 

                ps.setInt(1, cp.getFornecedor().getCodigo());
                ps.setInt(2, cp.getFormaPagto().getCodigo());
                ps.setString(3, cp.getDescricaoConta());
                ps.setDouble(4, cp.getValor());
                ps.setDouble(5, cp.getValorPago());
                ps.setDouble(6, cp.getValorPendente());
                ps.setInt(7, cp.getNumNota());
                ps.setInt(8, cp.getParcela());
                ps.setDate(9, (java.sql.Date) cp.getDataVencimento());
                ps.setInt(10, cp.getSubContaResultado().getCodigo());
                ps.setInt(11, cp.getStatus());
                ps.setString(12, cp.getDescricaoStatus());
                ps.setString(13, cp.getObservacao());
                ps.setString(14, cp.getBoleto());
                ps.setInt(15, cp.getIgreja().getCodigo());
                ps.setInt(16, usuarioLogado.getCodigo());            
                ps.executeUpdate();
                
                // Recuperar a chave prim�ria gerada
                generatedKeys = ps.getGeneratedKeys();
                
                if(generatedKeys.next() && efetivar){
                    int idRegistro = generatedKeys.getInt(1);
                    
                    for(ContasPagar cpEft : contasPagar){ 
                        // Inserir dados na segunda tabela usando a chave prim�ria da primeira tabela
                        String sql2 = "INSERT INTO MovimentoCaixa (Pessoa,RegistroContaPagar,ValorEntrada,ValorSaida,ContaCaixa,Complemento,FormaPagto,Igreja,UsuarioCadastro,DataMovimento,DataPagamentoRecebimento) VALUES(?,?,?,?,?,?,?,?,?,GETDATE(),?)";
                        String complemento = "CP "+cpEft.getNumNota()+"-"+cpEft.getParcela()+" | "+cpEft.getDescricaoConta();
                        stmInsert = conexao.prepareStatement(sql2);

                        this.stmInsert.setInt(1, cpEft.getFornecedor().getCodigo());
                        this.stmInsert.setInt(2, idRegistro);
                        this.stmInsert.setDouble(3, 0);
                        this.stmInsert.setDouble(4, cpEft.getValorPago());
                        this.stmInsert.setInt(5, contaCaixa.getCodigo());
                        this.stmInsert.setString(6, complemento);
                        this.stmInsert.setInt(7, cpEft.getFormaPagto().getCodigo());
                        this.stmInsert.setInt(8, cpEft.getIgreja().getCodigo());
                        this.stmInsert.setInt(9, usuarioLogado.getCodigo());
                        this.stmInsert.setDate(10, (java.sql.Date) cpEft.getDataPagamento());               
                        this.stmInsert.executeUpdate();
                    }
                }
            }
            //Confimar a transa��o, ou seja, a inser��o dos dados
            conexao.commit();
            JOptionPane.showMessageDialog(null, "Contas a pagar cadastrada com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){      
            //Salvar o log do erro no banco de dados
            logsDao.gravaLogsErro("ContasPagarDao - "+ex.getSQLState()+" - "+ex.getMessage());
            if(conexao != null){
                try{
                    conexao.rollback();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o contas a pagar", "Erro 014", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Fechar os recursos abertos
            try{
                if(ps != null) ps.close();
                if(conexao != null) conexao.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

    }   
    
    public List<ContasPagar> consultarContasPagar(ContasPagar cpFiltros, Date dataVencimentoInicial, Date dataVencimentoFinal, Date dataCadastroInicial, Date dataCadastroFinal, Date dataPagamentoInicial, Date dataPagamentoFinal, String filtroIgreja){

        List<ContasPagar> listaContasPagar = new ArrayList<>();
        
        if(cpFiltros.getIgreja() != null){
            filtroIgreja = String.valueOf(cpFiltros.getIgreja().getCodigo());
        }

        // Montando a query SQL com placeholders
        String sql = "SELECT P.Codigo AS CodFornecedor, P.Nome AS NomeFornecedor, P.CPF AS CPFCNPJ, " +
            "I.Codigo AS CodIgreja, I.NomeIgreja AS NomeIgreja, " +
            "FP.Codigo As CodFormaPagto, FP.Descricao As DescricaoFormaPagto, " +
            "SCR.Codigo As CodSubContaResultado, SCR.Descricao As DescricaoSubContaResultado, " +
            "CR.Codigo As CodContaResultado, CR.Descricao As DescricaoContaResultado, " +
            "CP.* " +
            "FROM ContasPagar CP " +
            "INNER JOIN Pessoas As P ON CP.Fornecedor = P.Codigo " +
            "INNER JOIN Igrejas As I ON I.Codigo = CP.Igreja " +
            "INNER JOIN FormasPagamento As FP ON FP.Codigo = CP.FormaPagto " +
            "INNER JOIN SubContasResultado As SCR ON SCR.Codigo = CP.SubContaResultado " +
            "INNER JOIN ContasResultado As CR ON CR.Codigo = SCR.ContaResultado " +
            "WHERE (? IS NULL OR CP.DataPagamento BETWEEN ? AND ?) " +
            "AND (? IS NULL OR CP.DataVencimento BETWEEN ? AND ?) " +
            "AND (? IS NULL OR CP.DataCadastro BETWEEN ? AND ?)" +
            "AND (? IS NULL OR CP.Fornecedor = ?) " +
            "AND (? IS NULL OR CP.Descricao LIKE ?) " +
            "AND (? IS NULL OR CP.NumNota = ?) " +
            "AND (? IS NULL OR CP.Status = ?) " +
            "AND (? IS NULL OR CP.SubContaResultado = ?) " +
            "AND (? IS NULL OR CP.FormaPagto = ?) " +
            "AND CP.Igreja IN ("+filtroIgreja+") ";
        
        try {
            this.conexao = Conexao.getDataSource().getConnection();         
            this.stmSelect = this.conexao.prepareStatement(sql);  
            
            // Datas Pagamento
            if (dataPagamentoInicial != null && dataPagamentoFinal != null) {
                this.stmSelect.setDate(1, new java.sql.Date(dataPagamentoInicial.getTime()));
                this.stmSelect.setDate(2, new java.sql.Date(dataPagamentoInicial.getTime()));
                this.stmSelect.setDate(3, new java.sql.Date(dataPagamentoFinal.getTime()));
            } else {
                this.stmSelect.setNull(1, java.sql.Types.DATE);
                this.stmSelect.setNull(2, java.sql.Types.DATE);
                this.stmSelect.setNull(3, java.sql.Types.DATE);
            }
            
            //Datas Vencimento
            if (dataVencimentoInicial != null && dataVencimentoFinal != null) {
                this.stmSelect.setDate(4, new java.sql.Date(dataVencimentoInicial.getTime()));
                this.stmSelect.setDate(5, new java.sql.Date(dataVencimentoInicial.getTime()));
                this.stmSelect.setDate(6, new java.sql.Date(dataVencimentoFinal.getTime()));
            } else {
                this.stmSelect.setNull(4, java.sql.Types.DATE);
                this.stmSelect.setNull(5, java.sql.Types.DATE);
                this.stmSelect.setNull(6, java.sql.Types.DATE);
            }
            
            //DatasCadastro
            if (dataCadastroInicial != null && dataCadastroFinal != null) {
                this.stmSelect.setDate(7, new java.sql.Date(dataCadastroInicial.getTime()));
                this.stmSelect.setDate(8, new java.sql.Date(dataCadastroInicial.getTime()));
                this.stmSelect.setDate(9, new java.sql.Date(dataCadastroFinal.getTime()));
            } else {
                this.stmSelect.setNull(7, java.sql.Types.DATE);
                this.stmSelect.setNull(8, java.sql.Types.DATE);
                this.stmSelect.setNull(9, java.sql.Types.DATE);
            }
            
            // Par�metro para Cliente
            if (cpFiltros.getFornecedor().getCodigo() != null) {
                this.stmSelect.setInt(10, cpFiltros.getFornecedor().getCodigo());
                this.stmSelect.setInt(11, cpFiltros.getFornecedor().getCodigo());
            } else {
                this.stmSelect.setNull(10, java.sql.Types.INTEGER);
                this.stmSelect.setNull(11, java.sql.Types.INTEGER);
            }

            // Par�metro para Descricao
            if (cpFiltros.getDescricaoConta() != null && !cpFiltros.getDescricaoConta().isEmpty()) {
                this.stmSelect.setString(12, "%" + cpFiltros.getDescricaoConta() + "%"); 
                this.stmSelect.setString(13, "%" + cpFiltros.getDescricaoConta() + "%");
            } else {
                this.stmSelect.setNull(12, java.sql.Types.VARCHAR);
                this.stmSelect.setNull(13, java.sql.Types.VARCHAR);
            }

            // Par�metro para NumNota
            if (cpFiltros.getNumNota() != null) {
                this.stmSelect.setInt(14, cpFiltros.getNumNota());
                this.stmSelect.setInt(15, cpFiltros.getNumNota());
            } else {
                this.stmSelect.setNull(14, java.sql.Types.INTEGER);
                this.stmSelect.setNull(15, java.sql.Types.INTEGER);
            }

            // Par�metro para Status (Baixada)
            if (cpFiltros.getStatus() != null) {
                this.stmSelect.setInt(16, cpFiltros.getStatus());
                this.stmSelect.setInt(17, cpFiltros.getStatus());
            } else {
                this.stmSelect.setNull(16, java.sql.Types.INTEGER);
                this.stmSelect.setNull(17, java.sql.Types.INTEGER);
            }

            // Par�metro para ContaResultado
            if (cpFiltros.getSubContaResultado()!= null) {
                this.stmSelect.setInt(18, cpFiltros.getSubContaResultado().getCodigo());
                this.stmSelect.setInt(19, cpFiltros.getSubContaResultado().getCodigo());
            } else {
                this.stmSelect.setNull(18, java.sql.Types.INTEGER);
                this.stmSelect.setNull(19, java.sql.Types.INTEGER);
            }
            
            // Par�metro para forma de pagamento
            if (cpFiltros.getFormaPagto() != null) {
                this.stmSelect.setInt(20, cpFiltros.getFormaPagto().getCodigo());
                this.stmSelect.setInt(21, cpFiltros.getFormaPagto().getCodigo());
            } else {
                this.stmSelect.setNull(20, java.sql.Types.INTEGER);
                this.stmSelect.setNull(21, java.sql.Types.INTEGER);
            }
            
            rs = this.stmSelect.executeQuery();

            // Iterando sobre os resultados
            while (rs.next()) {
                Pessoa fornecedor = new Pessoa();
                FormaPagto formaPagto = new FormaPagto();
                ContasPagar contaPagar=  new ContasPagar();
                Igreja igreja = new Igreja();
                SubContaResultado subContaResult = new SubContaResultado();
                ContaResultado contaResultado = new ContaResultado();
                formaPagto.setCodigo(this.rs.getInt("CodFormaPagto"));
                formaPagto.setNome(this.rs.getString("DescricaoFormaPagto"));
                fornecedor.setCodigo(this.rs.getInt("CodFornecedor"));
                fornecedor.setNome(this.rs.getString("NomeFornecedor"));
                fornecedor.setCpfCnpj(this.rs.getString("CPFCNPJ"));
                igreja.setCodigo(this.rs.getInt("CodIgreja"));
                igreja.setNome(this.rs.getString("NomeIgreja"));
                subContaResult.setCodigo(this.rs.getInt("CodSubContaResultado"));
                subContaResult.setDescricao(this.rs.getString("DescricaoSubContaResultado"));
                contaResultado.setCodigo(this.rs.getInt("CodContaResultado"));
                contaResultado.setNome(this.rs.getString("DescricaoContaResultado"));              
                contaPagar.setCodigo(this.rs.getInt("Codigo"));     
                contaPagar.setDescricaoConta(this.rs.getString("Descricao"));
                contaPagar.setValor(this.rs.getDouble("Valor"));
                contaPagar.setValorPago(this.rs.getDouble("ValorPago"));
                contaPagar.setValorPendente(this.rs.getDouble("ValorPendente"));
                contaPagar.setNumNota(this.rs.getInt("NumNota"));
                contaPagar.setParcela(this.rs.getInt("Parcela"));
                contaPagar.setDataVencimento(this.rs.getDate("DataVencimento"));
                contaPagar.setDataPagamento(this.rs.getDate("DataPagamento"));
                contaPagar.setDataCadastro(this.rs.getDate("DataCadastro"));
                contaPagar.setStatus(this.rs.getInt("Status"));
                contaPagar.setDescricaoStatus(this.rs.getString("DescricaoStatus"));
                contaPagar.setFornecedor(fornecedor);
                contaPagar.setIgreja(igreja);
                contaPagar.setFormaPagto(formaPagto);
                subContaResult.setContaResultado(contaResultado);
                contaPagar.setSubContaResultado(subContaResult);

                listaContasPagar.add(contaPagar);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar as contas a pagar", "Erro 001", JOptionPane.ERROR_MESSAGE);
            logsDao.gravaLogsErro("ContasPagarDao - "+ex.getSQLState()+" - "+ex.getMessage());
        } finally {
            try {
                if (this.rs != null) this.rs.close();
                if (this.stmSelect != null) this.stmSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaContasPagar;       
    }
    
    public List<ContasPagar> consultarContasPagarRelatorio(FormaPagto filtroFormaPagto, Pessoa filtroPessoa, Igreja filtroIgreja, Integer filtroStatus, SubContaResultado filtroSubContaResultado, String ordemDados, Date dataVencimentoInicial, Date dataVencimentoFinal, Date dataCadastroInicial, Date dataCadastroFinal, Date dataPagamentoInicial, Date dataPagamentoFinal, String filtroIgrejaUsuario){

        List<ContasPagar> listaContasPagar = new ArrayList<>();
        if(filtroIgreja != null){
            filtroIgrejaUsuario = String.valueOf(filtroIgreja.getCodigo());
        }

        // Montando a query SQL com placeholders
        String sql = "SELECT P.Codigo AS CodFornecedor, P.Nome AS NomeFornecedor, P.CPF AS CPFCNPJ, " +
            "I.Codigo AS CodIgreja, I.NomeIgreja AS NomeIgreja, " +
            "FP.Codigo As CodFormaPagto, FP.Descricao As DescricaoFormaPagto, " +
            "SCR.Codigo As CodSubContaResultado, SCR.Descricao As DescricaoSubContaResultado, " +
            "CR.Codigo As CodContaResultado, CR.Descricao As DescricaoContaResultado, " +
            "CAST(CP.Parcela AS NVARCHAR(Max)) + '/' + CAST((SELECT CAST(Count(1) AS NVARCHAR) FROM ContasPagar WHERE CP.NumNota = NumNota AND CP.Fornecedor = Fornecedor) AS NVARCHAR(MAX)) AS Parcela, " +
            "CP.* " +
            "FROM ContasPagar CP " +
            "INNER JOIN Pessoas As P ON CP.Fornecedor = P.Codigo " +
            "INNER JOIN Igrejas As I ON I.Codigo = CP.Igreja " +
            "INNER JOIN FormasPagamento As FP ON FP.Codigo = CP.FormaPagto " +
            "INNER JOIN SubContasResultado As SCR ON SCR.Codigo = CP.SubContaResultado " +
            "INNER JOIN ContasResultado As CR ON CR.Codigo = SCR.ContaResultado " +
            "WHERE (? IS NULL OR CP.DataPagamento BETWEEN ? AND ?) " +
            "AND (? IS NULL OR CP.DataVencimento BETWEEN ? AND ?) " +
            "AND (? IS NULL OR CP.DataCadastro BETWEEN ? AND ?)" +
            "AND (? IS NULL OR CP.Fornecedor = ?) " +
            "AND (? IS NULL OR CP.Status = ?) " +
            "AND (? IS NULL OR CP.SubContaResultado = ?) " +
            "AND (? IS NULL OR CP.FormaPagto = ?) " +
            "AND CP.Igreja IN ("+filtroIgrejaUsuario+") " +
            "ORDER BY CP."+ordemDados;
        
        try {
            this.conexao = Conexao.getDataSource().getConnection();         
            this.stmSelect = this.conexao.prepareStatement(sql);  
            
            // Datas Pagamento
            if (dataPagamentoInicial != null && dataPagamentoFinal != null) {
                this.stmSelect.setDate(1, new java.sql.Date(dataPagamentoInicial.getTime()));
                this.stmSelect.setDate(2, new java.sql.Date(dataPagamentoInicial.getTime()));
                this.stmSelect.setDate(3, new java.sql.Date(dataPagamentoFinal.getTime()));
            } else {
                this.stmSelect.setNull(1, java.sql.Types.DATE);
                this.stmSelect.setNull(2, java.sql.Types.DATE);
                this.stmSelect.setNull(3, java.sql.Types.DATE);
            }
            
            //Datas Vencimento
            if (dataVencimentoInicial != null && dataVencimentoFinal != null) {
                this.stmSelect.setDate(4, new java.sql.Date(dataVencimentoInicial.getTime()));
                this.stmSelect.setDate(5, new java.sql.Date(dataVencimentoInicial.getTime()));
                this.stmSelect.setDate(6, new java.sql.Date(dataVencimentoFinal.getTime()));
            } else {
                this.stmSelect.setNull(4, java.sql.Types.DATE);
                this.stmSelect.setNull(5, java.sql.Types.DATE);
                this.stmSelect.setNull(6, java.sql.Types.DATE);
            }
            
            //DatasCadastro
            if (dataCadastroInicial != null && dataCadastroFinal != null) {
                this.stmSelect.setDate(7, new java.sql.Date(dataCadastroInicial.getTime()));
                this.stmSelect.setDate(8, new java.sql.Date(dataCadastroInicial.getTime()));
                this.stmSelect.setDate(9, new java.sql.Date(dataCadastroFinal.getTime()));
            } else {
                this.stmSelect.setNull(7, java.sql.Types.DATE);
                this.stmSelect.setNull(8, java.sql.Types.DATE);
                this.stmSelect.setNull(9, java.sql.Types.DATE);
            }
            
            // Par�metro para Cliente
            if (filtroPessoa != null) {
                this.stmSelect.setInt(10, filtroPessoa.getCodigo());
                this.stmSelect.setInt(11, filtroPessoa.getCodigo());
            } else {
                this.stmSelect.setNull(10, java.sql.Types.INTEGER);
                this.stmSelect.setNull(11, java.sql.Types.INTEGER);
            }


            // Par�metro para Status (Baixada)
            if (filtroStatus != null) {
                this.stmSelect.setInt(12, filtroStatus);
                this.stmSelect.setInt(13, filtroStatus);
            } else {
                this.stmSelect.setNull(12, java.sql.Types.INTEGER);
                this.stmSelect.setNull(13, java.sql.Types.INTEGER);
            }

            // Par�metro para ContaResultado
            if (filtroSubContaResultado != null) {
                this.stmSelect.setInt(14, filtroSubContaResultado.getCodigo());
                this.stmSelect.setInt(15, filtroSubContaResultado.getCodigo());
            } else {
                this.stmSelect.setNull(14, java.sql.Types.INTEGER);
                this.stmSelect.setNull(15, java.sql.Types.INTEGER);
            }
            
            // Par�metro para forma de pagamento
            if (filtroFormaPagto != null) {
                this.stmSelect.setInt(16, filtroFormaPagto.getCodigo());
                this.stmSelect.setInt(17, filtroFormaPagto.getCodigo());
            } else {
                this.stmSelect.setNull(16, java.sql.Types.INTEGER);
                this.stmSelect.setNull(17, java.sql.Types.INTEGER);
            }          
               
            rs = this.stmSelect.executeQuery();

            // Iterando sobre os resultados
            while (rs.next()) {
                Pessoa fornecedor = new Pessoa();
                FormaPagto formaPagto = new FormaPagto();
                ContasPagar contaPagar=  new ContasPagar();
                Igreja igreja = new Igreja();
                SubContaResultado subContaResult = new SubContaResultado();
                ContaResultado contaResultado = new ContaResultado();
                formaPagto.setCodigo(this.rs.getInt("CodFormaPagto"));
                formaPagto.setNome(this.rs.getString("DescricaoFormaPagto"));
                fornecedor.setCodigo(this.rs.getInt("CodFornecedor"));
                fornecedor.setNome(this.rs.getString("NomeFornecedor"));
                fornecedor.setCpfCnpj(this.rs.getString("CPFCNPJ"));
                igreja.setCodigo(this.rs.getInt("CodIgreja"));
                igreja.setNome(this.rs.getString("NomeIgreja"));
                subContaResult.setCodigo(this.rs.getInt("CodSubContaResultado"));
                subContaResult.setDescricao(this.rs.getString("DescricaoSubContaResultado"));
                contaResultado.setCodigo(this.rs.getInt("CodContaResultado"));
                contaResultado.setNome(this.rs.getString("DescricaoContaResultado"));              
                contaPagar.setCodigo(this.rs.getInt("Codigo"));     
                contaPagar.setDescricaoConta(this.rs.getString("Descricao"));
                contaPagar.setValor(this.rs.getDouble("Valor"));
                contaPagar.setValorPago(this.rs.getDouble("ValorPago"));
                contaPagar.setValorPendente(this.rs.getDouble("ValorPendente"));
                contaPagar.setNumNota(this.rs.getInt("NumNota"));
                contaPagar.setTotalParcela(this.rs.getString("Parcela"));
                contaPagar.setDataVencimento(this.rs.getDate("DataVencimento"));
                contaPagar.setDataPagamento(this.rs.getDate("DataPagamento"));
                contaPagar.setDataCadastro(this.rs.getDate("DataCadastro"));
                contaPagar.setStatus(this.rs.getInt("Status"));
                contaPagar.setDescricaoStatus(this.rs.getString("DescricaoStatus"));
                contaPagar.setFornecedor(fornecedor);
                contaPagar.setIgreja(igreja);
                contaPagar.setFormaPagto(formaPagto);
                subContaResult.setContaResultado(contaResultado);
                contaPagar.setSubContaResultado(subContaResult);

                listaContasPagar.add(contaPagar);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar as contas a pagar", "Erro 001", JOptionPane.ERROR_MESSAGE);
            logsDao.gravaLogsErro("ContasPagarDao - "+ex.getSQLState()+" - "+ex.getMessage());
        } finally {
            try {
                if (this.rs != null) this.rs.close();
                if (this.stmSelect != null) this.stmSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaContasPagar;       
    }
    
    public List<ContasPagar> consultarContasPagarMesAtual(Date dataAtual){
        
        List<ContasPagar> listaContasPagar = new ArrayList<>();

        String sql = "SELECT P.Codigo AS CodFornecedor, P.Nome AS NomeFornecedor, P.CPF AS CPFCNPJ, " +
            "I.Codigo AS CodIgreja, I.NomeIgreja AS NomeIgreja, " +
            "FP.Codigo As CodFormaPagto, FP.Descricao As DescricaoFormaPagto, " +
            "SCR.Codigo As CodSubContaResultado, SCR.Descricao As DescricaoSubContaResultado, " +
            "CR.Codigo As CodContaResultado, CR.Descricao As DescricaoContaResultado, " +
            "CP.* " +
            "FROM ContasPagar CP " +
            "INNER JOIN Pessoas As P ON CP.Fornecedor = P.Codigo " +
            "INNER JOIN Igrejas As I ON I.Codigo = CP.Igreja " +
            "INNER JOIN FormasPagamento As FP ON FP.Codigo = CP.FormaPagto " +
            "INNER JOIN SubContasResultado As SCR ON SCR.Codigo = CP.SubContaResultado " +
            "INNER JOIN ContasResultado As CR ON CR.Codigo = SCR.ContaResultado " +
            "WHERE (CP.ValorPago < CP.Valor AND CP.ValorPendente > 0 AND MONTH(CP.DataVencimento) = MONTH(?)) ";
        
        try {
            this.conexao = Conexao.getDataSource().getConnection();         
            this.stmSelect = this.conexao.prepareStatement(sql);  
            
            this.stmSelect.setDate(1, (java.sql.Date) dataAtual);     
            this.rs = this.stmSelect.executeQuery();

            // Iterando sobre os resultados
            while (rs.next()) {
                Pessoa fornecedor = new Pessoa();
                ContasPagar contaPagar=  new ContasPagar();
                Igreja igreja = new Igreja();
                SubContaResultado subContaResult = new SubContaResultado();
                ContaResultado contaResultado = new ContaResultado();
                fornecedor.setCodigo(this.rs.getInt("CodFornecedor"));
                fornecedor.setNome(this.rs.getString("NomeFornecedor"));
                fornecedor.setCpfCnpj(this.rs.getString("CPFCNPJ"));
                igreja.setCodigo(this.rs.getInt("CodIgreja"));
                igreja.setNome(this.rs.getString("NomeIgreja"));
                subContaResult.setCodigo(this.rs.getInt("CodSubContaResultado"));
                subContaResult.setDescricao(this.rs.getString("DescricaoSubContaResultado"));
                contaResultado.setCodigo(this.rs.getInt("CodContaResultado"));
                contaResultado.setNome(this.rs.getString("DescricaoContaResultado"));              
                contaPagar.setCodigo(this.rs.getInt("Codigo"));     
                contaPagar.setDescricaoConta(this.rs.getString("Descricao"));
                contaPagar.setValor(this.rs.getDouble("Valor"));
                contaPagar.setValorPago(this.rs.getDouble("ValorPago"));
                contaPagar.setValorPendente(this.rs.getDouble("ValorPendente"));
                contaPagar.setNumNota(this.rs.getInt("NumNota"));
                contaPagar.setParcela(this.rs.getInt("Parcela"));
                contaPagar.setDataVencimento(this.rs.getDate("DataVencimento"));
                contaPagar.setDataPagamento(this.rs.getDate("DataPagamento"));
                contaPagar.setDataCadastro(this.rs.getDate("DataCadastro"));
                contaPagar.setStatus(this.rs.getInt("Status"));
                contaPagar.setDescricaoStatus(this.rs.getString("DescricaoStatus"));
                contaPagar.setFornecedor(fornecedor);
                contaPagar.setIgreja(igreja);
                subContaResult.setContaResultado(contaResultado);
                contaPagar.setSubContaResultado(subContaResult);

                listaContasPagar.add(contaPagar);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar as contas a pagar em aberto no m�s atual", "Erro 001", JOptionPane.ERROR_MESSAGE);
            logsDao.gravaLogsErro("ContasPagarDao - "+ex.getSQLState()+" - "+ex.getMessage());
        } finally {
            try {
                if (this.rs != null) this.rs.close();
                if (this.stmSelect != null) this.stmSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaContasPagar;    
   
    }
    
    public void ExcluirContasPagar (List<ContasPagar> cpExcluida){        
        try{
            conexao = Conexao.getDataSource().getConnection();
            String sql = "DELETE FROM ContasPagar WHERE Codigo=? And NumNota=? And Parcela=?";
            
            for(ContasPagar cp : cpExcluida){                
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, cp.getCodigo());
                ps.setInt(2, cp.getNumNota());
                ps.setInt(3, cp.getParcela());

                ps.executeUpdate();
            }
            
            JOptionPane.showMessageDialog(null, "Contas a Pagar exclu�da com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o contas a pagar ", "Erro 014", JOptionPane.ERROR_MESSAGE);
            logsDao.gravaLogsErro("ContasPagarDao - "+ex.getSQLState()+" - "+ex.getMessage());
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
    
    public boolean verificarExistenciaContaPagar(Integer numNota, Integer fornecedor){

        boolean cpExiste = false;

        try {
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "SELECT * FROM ContasPagar WHERE NumNota = ? And Fornecedor = ?";
            ps = conexao.prepareStatement(sql);
            
            ps.setObject(1, numNota);
            ps.setObject(2, fornecedor);
            rs = ps.executeQuery();

            // Iterando sobre os resultados
            if(rs.next()){
                cpExiste = true;
            }
        } catch (SQLException ex) {
            logsDao.gravaLogsErro("ContasPagarDao - "+ex.getSQLState()+" - "+ex.getMessage());
        } finally {
            // Fechando recursos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                
            }
        }
        return cpExiste;
    }
    
    public void alterarStatusContaPaga(ContasPagar cpEfetivada, Date dataPagamento){                   
        try{            
            conexao = Conexao.getDataSource().getConnection();
            String sql= "UPDATE ContasPagar SET Status=?,DescricaoStatus=?,DataPagamento=?,ValorPago=?,ValorPendente=?" + " WHERE Codigo=?";
                     
            ps = conexao.prepareStatement(sql);
            ps.setInt(1,cpEfetivada.getStatus());
            ps.setString(2, cpEfetivada.getDescricaoStatus());
            ps.setDate(3, (java.sql.Date) dataPagamento);
            ps.setDouble(4, cpEfetivada.getValorPago());
            ps.setDouble(5, cpEfetivada.getValorPendente());
            ps.setInt(6,cpEfetivada.getCodigo());

            ps.executeUpdate();           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o status a(s) conta(s) a pagar", "Erro 001", JOptionPane.ERROR_MESSAGE);
            logsDao.gravaLogsErro("ContasPagarDao - "+ex.getSQLState()+" - "+ex.getMessage());
        }finally{
            try{
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
    }
    
}
