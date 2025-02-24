
package dao;

import Ferramentas.Utilitarios;
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
import model.FormaPagto;
import model.Igreja;
import model.Pessoa;
import model.RegistroDizimoOferta;
import model.TipoOferta;
import model.Usuario;


public class RegistroOfertaDao {
    
    private final LogsDao logsDao = new LogsDao();
    private final Utilitarios converteData = new Utilitarios();
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private PreparedStatement stmSelect = null;
    private PreparedStatement stmInsert = null;
    
    //Adiciona todos os registros de oferta e dizimos, na tabela de registros e no movimento financeiro ao mesmo tempo
    public void adicionarRegistroOfertaDizimo(List<RegistroDizimoOferta> registros, Usuario usuarioLogado){

        PreparedStatement psRegistro = null;
        PreparedStatement psMovimento = null;
        ResultSet generatedKeys = null;

        try{
            conexao = Conexao.getDataSource().getConnection();
            conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            for(RegistroDizimoOferta rg : registros){ 
                String complemento = rg.getTpOferta().getNome()+" - "+rg.getContaCaixa().getNome();
                String sql = "INSERT INTO MovimentoDizimoOferta (Ofertante,TipoOferta,Entrada,Saida,Complemento,FormaPagto,Igreja,ContaCaixa,UsuarioCadastro,DataOferta,DataCadastro) VALUES(?,?,?,?,?,?,?,?,?,?,GETDATE())";
                psRegistro = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); 

                psRegistro.setInt(1, rg.getOfertante().getCodigo());
                psRegistro.setDouble(2, rg.getTpOferta().getCodigo());
                psRegistro.setDouble(3, rg.getValorOfertaEntrada());
                psRegistro.setDouble(4, rg.getValorOfertaSaida());
                psRegistro.setString(5, complemento);
                psRegistro.setInt(6, rg.getFormaPagto().getCodigo());
                psRegistro.setInt(7, rg.getIgreja().getCodigo());
                psRegistro.setInt(8, rg.getContaCaixa().getCodigo());
                psRegistro.setInt(9, usuarioLogado.getCodigo());
                psRegistro.setDate(10, (java.sql.Date) rg.getDataOferta());
                
                psRegistro.executeUpdate();

                // Recuperar a chave prim�ria gerada
                generatedKeys = psRegistro.getGeneratedKeys();
                
                if (generatedKeys.next()) {                
                    //Movimentar no caixa os valores referente ao registro de dizimo e ofertas
                    adicionarOfertaDizimoMovimentoFinanceiro(rg, usuarioLogado, generatedKeys);         
                }
            }
            //Confimar a transa��o, ou seja, a inser��o dos dados
            conexao.commit();
            JOptionPane.showMessageDialog(null, "Dizimos e ofertas registrado com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            logsDao.gravaLogsErro("RegistroOfertaDao - "+ex.getSQLState()+" - "+ex.getMessage());
            //Se ocorrer um erro, fazer rollback da transa��o
            if(conexao != null){
                try{
                    conexao.rollback();
                }catch(SQLException e){
                    logsDao.gravaLogsErro("RegistroOfertaDao - "+e.getSQLState()+" - "+e.getMessage());
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar os registros de d�zimos e ofertas - "+ex.getMessage(), "Erro 007", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Fechar os recursos abertos
            try{
                if(rs != null) rs.close();
                if(psRegistro != null) psRegistro.close();
                if(psMovimento != null) psMovimento.close();
                if(conexao != null) conexao.close();
            }catch(SQLException ex){
                logsDao.gravaLogsErro("RegistroOfertaDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

    }   
    
    //Adicionar os registros de dizimo e ofertas no movimento financeiro
    private void adicionarOfertaDizimoMovimentoFinanceiro (RegistroDizimoOferta registroOferta, Usuario usuarioLogado,ResultSet chaveRgOferta ){
        
        try{
            int idRegistro = chaveRgOferta.getInt(1);

            // Inserir dados na segunda tabela usando a chave prim�ria da primeira tabela
            String sql = "INSERT INTO MovimentoCaixa (RegistroOferta,ValorEntrada,ValorSaida,ContaCaixa,Complemento,FormaPagto,Igreja,UsuarioCadastro,DataMovimento,DataPagamentoRecebimento) VALUES(?,?,?,?,?,?,?,?,?,GETDATE(),?)";
            
            //String complemento = rg.getOfertante().getNome().substring(0, 30)+" | "+rg.getTpOferta().getNome();
            stmInsert = conexao.prepareStatement(sql);

            stmInsert.setInt(1, idRegistro);
            stmInsert.setDouble(2, registroOferta.getValorOfertaEntrada());
            stmInsert.setDouble(3, registroOferta.getValorOfertaSaida());
            stmInsert.setInt(4, registroOferta.getContaCaixa().getCodigo());
            stmInsert.setString(5, registroOferta.getComplemento());
            stmInsert.setInt(6, registroOferta.getFormaPagto().getCodigo());
            stmInsert.setInt(7, registroOferta.getIgreja().getCodigo());
            stmInsert.setInt(8, usuarioLogado.getCodigo());
            stmInsert.setDate(9, (java.sql.Date) registroOferta.getDataOferta());

            stmInsert.execute();
        }catch(SQLException ex){
            logsDao.gravaLogsErro("RegistroOfertaDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar movimentar o dizimo e oferta", "Erro 007", JOptionPane.ERROR_MESSAGE);
        }
    }
       
    //Consulta todos os registros de ofertas e dizimos
    public List<RegistroDizimoOferta> consultarRegistrosOfertas(RegistroDizimoOferta rgDizimoOferta, Date dataLancInicial, Date dataLancFinal, Date dataOfertaInicial, Date dataOfertaFinal, String filtroIgreja){

        List<RegistroDizimoOferta> listaRegistros = new ArrayList<>();
        
        if(rgDizimoOferta.getIgreja()!= null){
            filtroIgreja = String.valueOf(rgDizimoOferta.getIgreja().getCodigo());
        }

        String sql = "Select " +
            "MDO.*, " +
            "(Select Nome From Pessoas P Where P.Codigo = MDO.Ofertante) As NomeOfertante, " +
            "(Select Descricao From TiposOfertas TPO Where TPO.Codigo = MDO.TipoOferta) As NomeTipoOferta, " +
            "(Select Descricao From FormasPagamento FP Where FP.Codigo = MDO.FormaPagto) As NomeFormaPagto, " +
            "(Select NomeIgreja From Igrejas I Where I.Codigo = MDO.Igreja) As NomeIgreja, " +
            "(Select Descricao From ContasCaixa CC Where CC.Codigo = MDO.ContaCaixa) As NomeContaCaixa " +
            "WHERE (? IS NULL OR RG.ContaCaixa = ?) " +
            "AND (? IS NULL OR RG.TipoOferta = ?) " +
            "AND (? IS NULL OR RG.FormaPagto = ?) " +
            "AND RG.Igreja IN ("+filtroIgreja+") " +
            "AND (? IS NULL OR RG.DataOferta BETWEEN ? AND ?) " +
            "AND (? IS NULL OR RG.DataCadastro BETWEEN ? AND ?) ";

        try{
            conexao = Conexao.getDataSource().getConnection();
            ps = conexao.prepareStatement(sql);
            
            //Parametro ContaCaixa
            if(rgDizimoOferta.getContaCaixa() != null){
                ps.setInt(1, rgDizimoOferta.getContaCaixa().getCodigo());
                ps.setInt(2, rgDizimoOferta.getContaCaixa().getCodigo());
            }else{
                ps.setNull(1, java.sql.Types.INTEGER);
                ps.setNull(2, java.sql.Types.INTEGER);
            }
            
            //Parametro Tipo Oferta
            if(rgDizimoOferta.getTpOferta() != null){
                ps.setInt(3, rgDizimoOferta.getTpOferta().getCodigo());
                ps.setInt(4, rgDizimoOferta.getTpOferta().getCodigo());
            }else{
                ps.setNull(3, java.sql.Types.INTEGER);
                ps.setNull(4, java.sql.Types.INTEGER);
            }
            
            //Parametro Forma Pagamento
            if(rgDizimoOferta.getFormaPagto() != null){
                ps.setInt(5, rgDizimoOferta.getFormaPagto().getCodigo());
                ps.setInt(6, rgDizimoOferta.getFormaPagto().getCodigo());
            }else{
                ps.setNull(5, java.sql.Types.INTEGER);
                ps.setNull(6, java.sql.Types.INTEGER);
            }
            
            // Parametros referente a data da oferta
            if (dataOfertaInicial != null && dataOfertaFinal != null){
                ps.setDate(7, new java.sql.Date(dataOfertaInicial.getTime()));
                ps.setDate(8, new java.sql.Date(dataOfertaInicial.getTime()));
                ps.setDate(9, new java.sql.Date(dataOfertaFinal.getTime()));
            }else{
                ps.setNull(7, java.sql.Types.DATE);
                ps.setNull(8, java.sql.Types.DATE);
                ps.setNull(9, java.sql.Types.DATE);
            }
            
            //Parametro referente a data de lan�amento
            if (dataLancInicial != null && dataLancFinal != null){
                ps.setDate(10, new java.sql.Date(dataLancInicial.getTime()));
                ps.setDate(11, new java.sql.Date(dataLancInicial.getTime()));
                ps.setDate(12, new java.sql.Date(dataLancFinal.getTime()));
            }else{
                ps.setNull(10, java.sql.Types.DATE);
                ps.setNull(11, java.sql.Types.DATE);
                ps.setNull(12, java.sql.Types.DATE);
            }          
                      
            rs = ps.executeQuery();

            while(rs.next()){               
                //Instanciando os objetos
                RegistroDizimoOferta registroDizimoOferta = new RegistroDizimoOferta();
                Igreja igreja = new Igreja();
                TipoOferta tpOferta = new TipoOferta();
                FormaPagto formaPagto = new FormaPagto();
                ContaCaixa contaCaixa = new ContaCaixa();                         
                igreja.setCodigo(rs.getInt("Igreja"));
                igreja.setNome(rs.getString("NomeIgreja"));
                tpOferta.setCodigo(rs.getInt("TipoOferta"));
                tpOferta.setNome(rs.getString("NomeTipoOferta"));
                contaCaixa.setCodigo(rs.getInt("ContaCaixa"));
                contaCaixa.setNome(rs.getString("NomeContaCaixa"));
                formaPagto.setCodigo(rs.getInt("FormaPagto"));
                formaPagto.setNome(rs.getString("NomeFormaPagto"));
                registroDizimoOferta.setCodigo(rs.getInt("Codigo"));
                registroDizimoOferta.setValorOfertaEntrada(rs.getDouble("Entrada"));
                registroDizimoOferta.setValorOfertaSaida(rs.getDouble("Saida"));
                registroDizimoOferta.setComplemento(rs.getString("Complemento"));
                registroDizimoOferta.setDataOferta(rs.getDate("DataOferta"));
                registroDizimoOferta.setDataMovimento(rs.getDate("DataMovimento"));
                registroDizimoOferta.setContaCaixa(contaCaixa);
                registroDizimoOferta.setFormaPagto(formaPagto);
                registroDizimoOferta.setIgreja(igreja);
                registroDizimoOferta.setTpOferta(tpOferta);
                
                listaRegistros.add(registroDizimoOferta);
            }     
        } catch (SQLException ex) {
            logsDao.gravaLogsErro("RegistroOfertaDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar os registros de dizimo e ofertas", "Erro 011", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("RegistroOfertaDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaRegistros;     
    }
    
    //Deleta um registro da tabela de registro e movimento financeiro ao mesmo tempo; Fun��o utilizada na tela de registro de dizimo e ofertas
    public void deletarRegistros(List<RegistroDizimoOferta> listaRgExcluidos){
        
        PreparedStatement ps = null;
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            String sqlRegistro = "DELETE FROM MovimentoDizimoOferta WHERE Codigo=?";
            
            for(RegistroDizimoOferta rg : listaRgExcluidos){             
                
                ps = conexao.prepareStatement(sqlRegistro);
                ps.setInt(1, rg.getCodigo());

                ps.executeUpdate();
            }
            
        }catch (SQLException ex) {
            logsDao.gravaLogsErro("RegistroOfertaDao - "+ex.getSQLState()+" - "+ex.getMessage());
            // Reverter a transa��o em caso de erro
            if (conexao != null) {
                try {
                    conexao.rollback();
                } catch (SQLException e) {
                    logsDao.gravaLogsErro("RegistroOfertaDao - "+e.getSQLState()+" - "+e.getMessage());
                    JOptionPane.showMessageDialog(null, "Erro ao tentar fazer o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
        }finally {
            // Fechar recursos
            try {
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    //Deleta o registro da dizimo e ofertas. Fun��o utilizada pela tela de Movimento Financeiro
    public void deletarRegistrosMovimento(RegistroDizimoOferta rgExcluido){
        
        PreparedStatement ps = null;
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            String sqlRegistro = "DELETE FROM MovimentoDizimoOferta WHERE Codigo=?";  
                
            ps = conexao.prepareStatement(sqlRegistro);
            ps.setInt(1, rgExcluido.getCodigo());

            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dizimo/Oferta exclu�da com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
                 
        }catch (SQLException ex) {
            logsDao.gravaLogsErro("RegistroOfertaDao - "+ex.getSQLState()+" - "+ex.getMessage());
            // Reverter a transa��o em caso de erro
            if (conexao != null) {
                try {
                    conexao.rollback();
                } catch (SQLException e) {
                    logsDao.gravaLogsErro("RegistroOfertaDao - "+e.getSQLState()+" - "+e.getMessage());
                    JOptionPane.showMessageDialog(null, "Erro ao tentar fazer o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
        }finally {
            // Fechar recursos
            try {
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    //Consulta registros de d�zimo e ofertas para ser utilizada no relat�rio.
    public List<RegistroDizimoOferta> consultaRegistroDizimoOfertaRelatorio(RegistroDizimoOferta rgDizimoOferta, String ordemDados, Date dataLancInicial, Date dataLancFinal, Date dataOfertaInicial, Date dataOfertaFinal, String filtroIgreja){
        
        List<RegistroDizimoOferta> listaDizimoOferta = new ArrayList<>();
        if(rgDizimoOferta.getIgreja() != null){
            filtroIgreja = String.valueOf(rgDizimoOferta.getIgreja().getCodigo());
        }

        // Montando a query SQL com placeholders
        String sql = "SELECT " +
                    "(Select Nome From Pessoas As P Where P.Codigo = RDO.Ofertante) As Ofertante, " +
                    "(Select Descricao From FormasPagamento As FP Where FP.Codigo = RDO.FormaPagto) As FormaPagto, " +
                    "(SELECT TP.Descricao FROM TiposOfertas AS TP WHERE TP.Codigo = RDO.TipoOferta) AS TipoOferta, " +
                    "RDO.Valor AS ValorOferta, " +
                    "RDO.TipoOferta AS CodTipoOferta, " +
                    "RDO.Igreja AS CodIgreja, " +
                    "RDO.DataOferta AS DataOferta, " +
                    "(SELECT I.NomeIgreja FROM Igrejas AS I WHERE I.Codigo = RDO.Igreja) AS Igreja, " +
                    "(SELECT CC.Descricao FROM ContasCaixa AS CC WHERE CC.Codigo = RDO.ContaCaixa) AS ContaCaixa, " +
                    "RDO.DataCadastro AS DataCadastro " +
                    "FROM RegistroDizimoOferta AS RDO " +
                    "WHERE (? IS NULL OR RDO.DataCadastro BETWEEN ? AND ?) " +
                    "AND (? IS NULL OR RDO.DataOferta BETWEEN ? AND ?) " +
                    "AND RDO.Igreja IN ("+filtroIgreja+")" +
                    "AND (? IS NULL OR RDO.TipoOferta = ?) " +
                    "ORDER BY RDO."+ordemDados;
        
        try {
            this.conexao = Conexao.getDataSource().getConnection();         
            this.stmSelect = this.conexao.prepareStatement(sql);  
            
            // Datas Pagamento
            if (dataOfertaInicial != null && dataOfertaFinal != null) {
                this.stmSelect.setDate(1, new java.sql.Date(dataOfertaInicial.getTime()));
                this.stmSelect.setDate(2, new java.sql.Date(dataOfertaInicial.getTime()));
                this.stmSelect.setDate(3, new java.sql.Date(dataOfertaFinal.getTime()));
            } else {
                this.stmSelect.setNull(1, java.sql.Types.DATE);
                this.stmSelect.setNull(2, java.sql.Types.DATE);
                this.stmSelect.setNull(3, java.sql.Types.DATE);
            }
            
            //Datas Vencimento
            if (dataLancInicial != null && dataLancFinal != null) {
                this.stmSelect.setDate(4, new java.sql.Date(dataLancInicial.getTime()));
                this.stmSelect.setDate(5, new java.sql.Date(dataLancInicial.getTime()));
                this.stmSelect.setDate(6, new java.sql.Date(dataLancFinal.getTime()));
            } else {
                this.stmSelect.setNull(4, java.sql.Types.DATE);
                this.stmSelect.setNull(5, java.sql.Types.DATE);
                this.stmSelect.setNull(6, java.sql.Types.DATE);
            }
            
            // Par�metro para Status (Baixada)
            if (rgDizimoOferta.getTpOferta() != null) {
                this.stmSelect.setInt(7, rgDizimoOferta.getTpOferta().getCodigo());
                this.stmSelect.setInt(8, rgDizimoOferta.getTpOferta().getCodigo());
            } else {
                this.stmSelect.setNull(7, java.sql.Types.INTEGER);
                this.stmSelect.setNull(8, java.sql.Types.INTEGER);
            }
               
            rs = this.stmSelect.executeQuery();

            // Iterando sobre os resultados
            while (rs.next()) {
                Pessoa ofertante = new Pessoa();
                FormaPagto formaPagto = new FormaPagto();
                Igreja igreja = new Igreja();
                TipoOferta tipoOferta = new TipoOferta();
                ContaCaixa contaCaixa = new ContaCaixa();
                RegistroDizimoOferta dizimoOferta = new RegistroDizimoOferta();
                contaCaixa.setNome(this.rs.getString("ContaCaixa"));
                formaPagto.setNome(this.rs.getString("FormaPagto"));
                ofertante.setNome(this.rs.getString("Ofertante"));
                igreja.setNome(this.rs.getString("Igreja"));
                igreja.setCodigo(this.rs.getInt("CodIgreja"));
                tipoOferta.setNome(this.rs.getString("TipoOferta"));    
                tipoOferta.setCodigo(this.rs.getInt("CodTipoOferta"));
                dizimoOferta.setDataMovimento(this.rs.getDate("DataCadastro"));
                dizimoOferta.setDataOferta(this.rs.getDate("DataOferta"));
                dizimoOferta.setValorOfertaEntrada(this.rs.getDouble("ValorOferta"));
                dizimoOferta.setContaCaixa(contaCaixa);
                dizimoOferta.setFormaPagto(formaPagto);
                dizimoOferta.setIgreja(igreja);
                dizimoOferta.setTpOferta(tipoOferta);
                dizimoOferta.setOfertante(ofertante);
                
                listaDizimoOferta.add(dizimoOferta);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os registros de dizimos e ofertas", "Erro 001", JOptionPane.ERROR_MESSAGE);
            logsDao.gravaLogsErro("RegistroOfertaDao - "+ex.getSQLState()+" - "+ex.getMessage());
        } finally {
            try {
                if (this.rs != null) this.rs.close();
                if (this.stmSelect != null) this.stmSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("RegistroOfertaDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaDizimoOferta;       
    }

    //Consulta para gerar o relat�rio de presta��o de contas mensal, referente a valores de dizimos e ofertas
    public List<RegistroDizimoOferta> consultaRelatorioPrestacaoContaMensalIgrejaLocal(Igreja filtroIgreja, Integer mes, Integer ano){
        
        List<RegistroDizimoOferta> listaDizimoOferta = new ArrayList<>();

        // Montando a query SQL com placeholders
        String sql = "SELECT " +
            "(SELECT Descricao FROM TiposOfertas AS TP WHERE TP.Codigo = RDO.TipoOferta) AS NomeTipoOferta, " +
            "SUM(RDO.Valor) AS ValorOferta " +
            "FROM RegistroDizimoOferta AS RDO " +
            "WHERE MONTH(RDO.DataOferta) = ? " +
            "AND YEAR(RDO.DataOferta) = ? " +
            "AND (? IS NULL OR RDO.Igreja = ?)" +
            "GROUP BY RDO.TipoOferta";
        
        try {
            this.conexao = Conexao.getDataSource().getConnection();         
            this.stmSelect = this.conexao.prepareStatement(sql);  
            
            //Paramentro para o mes e ano
            this.stmSelect.setInt(1, mes);
            this.stmSelect.setInt(2, ano);

            // Parametro para igreja
            if (filtroIgreja != null) {
                this.stmSelect.setInt(3, filtroIgreja.getCodigo());
                this.stmSelect.setInt(4, filtroIgreja.getCodigo());
            } else {
                this.stmSelect.setNull(3, java.sql.Types.INTEGER);
                this.stmSelect.setNull(4, java.sql.Types.INTEGER);
            }

            this.rs = this.stmSelect.executeQuery();

            // Iterando sobre os resultados
            while (rs.next()) {
                TipoOferta tipoOferta = new TipoOferta();
                RegistroDizimoOferta dizimoOferta = new RegistroDizimoOferta();
                tipoOferta.setNome(this.rs.getString("NomeTipoOferta"));    
                dizimoOferta.setValorOfertaEntrada(this.rs.getDouble("ValorOferta"));
                dizimoOferta.setTpOferta(tipoOferta);
                
                listaDizimoOferta.add(dizimoOferta);
            }

        } catch (SQLException ex) {
            logsDao.gravaLogsErro("RegistroOfertaDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os registros de dizimos e ofertas", "Erro 001", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (this.rs != null) this.rs.close();
                if (this.stmSelect != null) this.stmSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("RegistroOfertaDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaDizimoOferta;   
    }
    
    //Consulta para gerar o relat�rio de presta��o de contas mensal, referente a valores de dizimos e ofertas
    public List<RegistroDizimoOferta> consultaRelatorioPrestacaoContaMensalAssociacao (Igreja filtroIgreja, Integer mes, Integer ano){
        
        List<RegistroDizimoOferta> listaDizimoOferta = new ArrayList<>();

        // Montando a query SQL com placeholders
        String sql = "SELECT " +
            "(SELECT Descricao FROM TiposOfertas AS TP WHERE TP.Codigo = RDO.TipoOferta) AS NomeTipoOferta, " +
            "SUM(RDO.Valor) AS ValorOferta " +
            "FROM RegistroDizimoOferta AS RDO " +
            "WHERE MONTH(RDO.DataOferta) = ? " +
            "AND YEAR(RDO.DataOferta) = ? " +
            "AND (? IS NULL OR RDO.Igreja = ?)" +
            "GROUP BY RDO.TipoOferta";
        
        try {
            this.conexao = Conexao.getDataSource().getConnection();         
            this.stmSelect = this.conexao.prepareStatement(sql);  
            
            //Paramentro para o mes e ano
            this.stmSelect.setInt(1, mes);
            this.stmSelect.setInt(2, ano);

            // Parametro para igreja
            if (filtroIgreja != null) {
                this.stmSelect.setInt(3, filtroIgreja.getCodigo());
                this.stmSelect.setInt(4, filtroIgreja.getCodigo());
            } else {
                this.stmSelect.setNull(3, java.sql.Types.INTEGER);
                this.stmSelect.setNull(4, java.sql.Types.INTEGER);
            }

            this.rs = this.stmSelect.executeQuery();

            // Iterando sobre os resultados
            while (rs.next()) {
                TipoOferta tipoOferta = new TipoOferta();
                RegistroDizimoOferta dizimoOferta = new RegistroDizimoOferta();
                tipoOferta.setNome(this.rs.getString("NomeTipoOferta"));    
                dizimoOferta.setValorOfertaEntrada(this.rs.getDouble("ValorOferta"));
                dizimoOferta.setTpOferta(tipoOferta);
                
                listaDizimoOferta.add(dizimoOferta);
            }

        } catch (SQLException ex) {
            logsDao.gravaLogsErro("RegistroOfertaDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar os registros de dizimos e ofertas", "Erro 001", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (this.rs != null) this.rs.close();
                if (this.stmSelect != null) this.stmSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("RegistroOfertaDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conex�o com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaDizimoOferta;   
    }

}
