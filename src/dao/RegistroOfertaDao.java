
package dao;

import Services.Utilitarios;
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


public class RegistroOfertaDao {
    
    private final Utilitarios converteData = new Utilitarios();
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    //Adiciona todos os registros de oferta e dizimos, na tabela de registros e no movimento financeiro ao mesmo tempo
    public void adicionarRegistroOfertaDizimo(List<RegistroDizimoOferta> registros){

        PreparedStatement psRegistro = null;
        PreparedStatement psMovimento = null;
        ResultSet generatedKeys = null;

        try{
            conexao = Conexao.getDataSource().getConnection();
            conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            for(RegistroDizimoOferta rg : registros){ 
                String sql = "INSERT INTO RegistroDizimoOferta (Ofertante,TipoOferta,Valor,FormaPagto,SubContaResultado,DataOferta,Efetivado,Igreja,UsuarioCadastro,DataCadastro,ContaCaixa) VALUES(?,?,?,?,?,?,?,?,?,GETDATE(),?)";
                psRegistro = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); 

                psRegistro.setInt(1, rg.getOfertante().getCodigo());
                psRegistro.setDouble(2, rg.getTpOferta().getCodigo());
                psRegistro.setDouble(3, rg.getValorOferta());
                psRegistro.setInt(4, rg.getFormaPagto().getCodigo());
                psRegistro.setInt(5, rg.getSubContaResultado().getCodigo());
                psRegistro.setDate(6, (java.sql.Date) rg.getDataOferta());
                psRegistro.setInt(7, 1);
                psRegistro.setInt(8, rg.getIgreja().getCodigo());
                psRegistro.setInt(9, 2);
                psRegistro.setInt(10, rg.getContaCaixa().getCodigo());
                psRegistro.executeUpdate();

                // Recuperar a chave primária gerada
                generatedKeys = psRegistro.getGeneratedKeys();
                
                if (generatedKeys.next()) {
                    int idRegistro = generatedKeys.getInt(1);

                    // Inserir dados na segunda tabela usando a chave primária da primeira tabela
                    String sql2 = "INSERT INTO MovimentoCaixa (Pessoa,RegistroOferta,ValorEntrada,ValorSaida,ContaCaixa,Complemento,FormaPagto,Igreja,UsuarioCadastro,DataMovimento,DataPagamentoRecebimento) VALUES(?,?,?,?,?,?,?,?,?,GETDATE(),?)";
                    psMovimento = conexao.prepareStatement(sql2);
                    
                    psMovimento.setInt(1, rg.getOfertante().getCodigo());
                    psMovimento.setInt(2, idRegistro);
                    psMovimento.setDouble(3, rg.getValorOferta());
                    psMovimento.setDouble(4, 0);
                    psMovimento.setInt(5, rg.getContaCaixa().getCodigo());
                    psMovimento.setString(6, rg.getTpOferta().getNome().toUpperCase());
                    psMovimento.setInt(7, rg.getFormaPagto().getCodigo());
                    psMovimento.setInt(8, rg.getIgreja().getCodigo());
                    psMovimento.setInt(9, 2);
                    psMovimento.setDate(10, (java.sql.Date) rg.getDataOferta());
                    
                    psMovimento.execute();

                }
            }
            //Confimar a transação, ou seja, a inserção dos dados
            conexao.commit();
            JOptionPane.showMessageDialog(null, "Dizimos e ofertas registrado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            //Se ocorrer um erro, fazer rollback da transação
            if(conexao != null){
                try{
                    conexao.rollback();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar os registros de dízimos e ofertas", "Erro 007", JOptionPane.ERROR_MESSAGE);
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
    
    //Consulta todos os registros de ofertas e dizimos
    public List<RegistroDizimoOferta> consultarRegistrosOfertas(RegistroDizimoOferta rgDizimoOferta, Date dataLancInicial, Date dataLancFinal, Date dataOfertaInicial, Date dataOfertaFinal){

        List<RegistroDizimoOferta> listaRegistros = new ArrayList<>();

        String sql = "SELECT " +
            "RG.Codigo As Codigo, " +
            "RG.Ofertante As CodOfertante, " +
            "P.Nome As Ofertante, " +
            "RG.TipoOferta As CodTipoOferta, " +
            "T.Descricao As TipoOferta, " +
            "RG.Valor As ValorOferta, " +
            "RG.FormaPagto As CodFormaPagto, " +
            "FP.Descricao As FormaPagto, " +
            "RG.DataOferta As DataOferta, " +
            "RG.Igreja As CodIgreja, " +
            "IG.NomeIgreja As Igreja, " +
            "RG.DataCadastro As DataCadastro, " +
            "RG.ContaCaixa As CodContaCaixa, " +
            "CC.Descricao As ContaCaixa " +
            "FROM RegistroDizimoOferta As RG " +
            "INNER JOIN ContasCaixa As CC ON RG.ContaCaixa = CC.Codigo " +
            "INNER JOIN Pessoas As P ON RG.Ofertante = P.Codigo " +
            "INNER JOIN TiposOfertas As T ON RG.TipoOferta = T.Codigo " +
            "INNER JOIN FormasPagamento As FP ON RG.FormaPagto = FP.Codigo " +
            "INNER JOIN Igrejas As IG ON RG.Igreja = IG.Codigo " +
            "WHERE (? IS NULL OR RG.ContaCaixa = ?) " +
            "AND (? IS NULL OR RG.TipoOferta = ?) " +
            "AND (? IS NULL OR RG.FormaPagto = ?) " +
            "AND (? IS NULL OR RG.Ofertante = ?) " +
            "AND (? IS NULL OR RG.Igreja = ?) " +
            "AND (? IS NULL OR RG.DataOferta BETWEEN ? AND ?) " +
            "AND (? IS NULL OR RG.DataCadastro BETWEEN ? AND ?) " +
            "AND (? IS NULL OR RG.SubContaResultado = ?) ";

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
            
            //Parametro Ofertante
            if(rgDizimoOferta.getOfertante().getCodigo() != null){
                ps.setInt(7, rgDizimoOferta.getOfertante().getCodigo());
                ps.setInt(8, rgDizimoOferta.getOfertante().getCodigo());
            }else{
                ps.setNull(7, java.sql.Types.INTEGER);
                ps.setNull(8, java.sql.Types.INTEGER);
            }
            
            //Parametro Igreja
            if(rgDizimoOferta.getIgreja() != null){
                ps.setInt(9, rgDizimoOferta.getIgreja().getCodigo());
                ps.setInt(10, rgDizimoOferta.getIgreja().getCodigo());
            }else{
                ps.setNull(9, java.sql.Types.INTEGER);
                ps.setNull(10, java.sql.Types.INTEGER);
            }
            
            // Parametros referente a data da oferta
            if (dataOfertaInicial != null && dataOfertaFinal != null){
                ps.setDate(11, new java.sql.Date(dataOfertaInicial.getTime()));
                ps.setDate(12, new java.sql.Date(dataOfertaInicial.getTime()));
                ps.setDate(13, new java.sql.Date(dataOfertaFinal.getTime()));
            }else{
                ps.setNull(11, java.sql.Types.DATE);
                ps.setNull(12, java.sql.Types.DATE);
                ps.setNull(13, java.sql.Types.DATE);
            }
            
            //Parametro referente a data de lançamento
            if (dataLancInicial != null && dataLancFinal != null){
                ps.setDate(14, new java.sql.Date(dataLancInicial.getTime()));
                ps.setDate(15, new java.sql.Date(dataLancInicial.getTime()));
                ps.setDate(16, new java.sql.Date(dataLancFinal.getTime()));
            }else{
                ps.setNull(14, java.sql.Types.DATE);
                ps.setNull(15, java.sql.Types.DATE);
                ps.setNull(16, java.sql.Types.DATE);
            }
            
            if(rgDizimoOferta.getSubContaResultado() != null){
                ps.setInt(17, rgDizimoOferta.getSubContaResultado().getCodigo());
                ps.setInt(18, rgDizimoOferta.getSubContaResultado().getCodigo());
            }else{
                ps.setNull(17, java.sql.Types.INTEGER);
                ps.setNull(18, java.sql.Types.INTEGER);
            }
                      
            rs = ps.executeQuery();

            while(rs.next()){               
                //Instanciando os objetos
                Igreja igreja = new Igreja();
                TipoOferta tpOferta = new TipoOferta();
                Pessoa ofertante = new Pessoa();
                FormaPagto formaPagto = new FormaPagto();
                ContaCaixa contaCaixa = new ContaCaixa();
                Integer codRegistro = rs.getInt("Codigo");
                double valorOferta = rs.getDouble("ValorOferta");
                Integer codOfertante = rs.getInt("CodOfertante");
                Integer codTpOferta = rs.getInt("CodTipoOferta");
                Integer codFormPagto = rs.getInt("CodFormaPagto");
                Integer codIgreja = rs.getInt("CodIgreja");
                Integer codContaCx = rs.getInt("CodContaCaixa");
                igreja.setCodigo(codIgreja);
                igreja.setNome(rs.getString("Igreja"));
                tpOferta.setCodigo(codTpOferta);
                tpOferta.setNome(rs.getString("TipoOferta"));
                ofertante.setCodigo(codOfertante);
                ofertante.setNome(rs.getString("Ofertante"));
                formaPagto.setCodigo(codFormPagto);
                formaPagto.setNome(rs.getString("FormaPagto"));
                contaCaixa.setCodigo(codContaCx);
                contaCaixa.setNome(rs.getString("ContaCaixa"));
              
                Date dataLanc = rs.getDate("DataCadastro");
                Date dataOfer = rs.getDate("DataOferta");
                
                RegistroDizimoOferta registrosDizimoOferta = new RegistroDizimoOferta(codRegistro, tpOferta, valorOferta, formaPagto, ofertante, dataOfer, igreja, contaCaixa, dataLanc);
                listaRegistros.add(registrosDizimoOferta);
            }     
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar os registros de dizimo e ofertas", "Erro 011", JOptionPane.ERROR_MESSAGE);
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

        return listaRegistros;     
    }
    
    //Deleta um registro da tabela de registro e movimento financeiro ao mesmo tempo
    public void deletarRegistros(List<RegistroDizimoOferta> listaRgExcluidos){
        
        PreparedStatement ps = null;
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            String sqlRegistro = "DELETE FROM RegistroDizimoOferta WHERE Codigo=? And Ofertante=?";
            
            for(RegistroDizimoOferta rg : listaRgExcluidos){             
                
                ps = conexao.prepareStatement(sqlRegistro);
                ps.setInt(1, rg.getCodRegistro());
                ps.setInt(2, rg.getOfertante().getCodigo());

                ps.executeUpdate();
            }
            
        }catch (SQLException ex) {
            // Reverter a transação em caso de erro
            if (conexao != null) {
                try {
                    conexao.rollback();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar fazer o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
        }finally {
            // Fechar recursos
            try {
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void deletarRegistrosMovimento(RegistroDizimoOferta rgExcluido){
        
        PreparedStatement ps = null;
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            String sqlRegistro = "DELETE FROM RegistroDizimoOferta WHERE Codigo=?";  
                
            ps = conexao.prepareStatement(sqlRegistro);
            ps.setInt(1, rgExcluido.getCodRegistro());

            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dizimo/Oferta excluída com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
                 
        }catch (SQLException ex) {
            // Reverter a transação em caso de erro
            if (conexao != null) {
                try {
                    conexao.rollback();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar fazer o rollback", "Erro 013", JOptionPane.ERROR_MESSAGE);
                }
            }
        }finally {
            // Fechar recursos
            try {
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
