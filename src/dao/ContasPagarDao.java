
package dao;

import ferramentas.Conversores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.ContasPagar;
import model.Igreja;
import model.Pessoa;

public class ContasPagarDao {
    
    private final Conversores converteData = new Conversores();
    private Connection conexao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    //Adiciona o contas a pagar dentro do banco de dados
    public void adicionarContasPagar(List<ContasPagar> contasPagar){

        try{
            conexao = Conexao.getDataSource().getConnection(); 
            conexao.setAutoCommit(false); //Setando o autocomit como falso
            
            for(ContasPagar cp : contasPagar){ 
                String sql = "INSERT INTO ContasPagar (Fornecedor,FormaPagto,Descricao,Valor,NumNota,Parcela,DataVencimento,SubContaResultado,Baixada,DataCadastro,Observacao,Boleto,Igreja) VALUES(?,?,?,?,?,?,?,?,?,GETDATE(),?,?,?)";
                ps = conexao.prepareStatement(sql); 

                ps.setInt(1, cp.getFornecedor().getCodigo());
                ps.setInt(2, cp.getFormaPagto().getCodigo());
                ps.setString(3, cp.getDescricaoConta());
                ps.setDouble(4, cp.getValor());
                ps.setInt(5, cp.getNumNota());
                ps.setInt(6, cp.getParcela());
                ps.setString(7, cp.getDataVencimento());
                ps.setInt(8, cp.getSubContaResultado().getCodigo());
                ps.setInt(9, cp.getStatus());
                ps.setString(10, cp.getObservacao());
                ps.setString(11, cp.getBoleto());
                ps.setInt(12, cp.getIgreja().getCodigo());
                
                ps.executeUpdate();

            }
            //Confimar a transação, ou seja, a inserção dos dados
            conexao.commit();
            JOptionPane.showMessageDialog(null, "Contas a pagar cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o contas a pagar", "Erro 014", JOptionPane.ERROR_MESSAGE);
        }finally{
            //Fechar os recursos abertos
            try{
                if(ps != null) ps.close();
                if(conexao != null) conexao.close();
            }catch(SQLException ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

    }   
    
    public List<ContasPagar> consultarContasPagar(ContasPagar cpFiltros, Date dataVencimentoInicial, Date dataVencimentoFinal, Date dataCadastroInicial, Date dataCadastroFinal, Date dataPagamentoInicial, Date dataPagamentoFinal){

        List<ContasPagar> listaContasPagar = new ArrayList<>();

        // Montando a query SQL com placeholders
        String sql = "SELECT CP.Codigo AS Codigo, CP.Fornecedor AS Fornecedor, P.Nome AS NomePessoa, " +
            "CP.Descricao AS Descricao, CP.Valor AS Valor, CP.NumNota AS NumNota, " +
            "CP.Parcela AS Parcela, CP.DataVencimento AS DataVencimento, " +
            "CP.DataPagamento AS DataPagamento, CP.DataCadastro AS DataCadastro, " +
            "CP.Baixada AS Baixada, CP.Igreja " +
            "FROM ContasPagar CP " +
            "INNER JOIN Pessoas P ON CP.Fornecedor = P.Codigo " +
            "WHERE (? IS NULL OR CP.DataPagamento BETWEEN ? AND ?) " +
            "AND (? IS NULL OR CP.DataVencimento BETWEEN ? AND ?) " +
            "AND (? IS NULL OR CP.DataCadastro BETWEEN ? AND ?)" +
            "AND (? IS NULL OR CP.Fornecedor = ?) " +
            "AND (? IS NULL OR CP.Descricao LIKE ?) " +
            "AND (? IS NULL OR CP.NumNota = ?) " +
            "AND (? IS NULL OR CP.Baixada = ?) " +
            "AND (? IS NULL OR CP.SubContaResultado = ?)";

        try {
            conexao = Conexao.getDataSource().getConnection();         
            ps = conexao.prepareStatement(sql);  
            
            // Datas Pagamento
            if (dataPagamentoInicial != null && dataPagamentoFinal != null) {
                ps.setDate(1, new java.sql.Date(dataPagamentoInicial.getTime()));
                ps.setDate(2, new java.sql.Date(dataPagamentoInicial.getTime()));
                ps.setDate(3, new java.sql.Date(dataPagamentoFinal.getTime()));
            } else {
                ps.setNull(1, java.sql.Types.DATE);
                ps.setNull(2, java.sql.Types.DATE);
                ps.setNull(3, java.sql.Types.DATE);
            }
            
            //Datas Vencimento
            if (dataVencimentoInicial != null && dataVencimentoFinal != null) {
                ps.setDate(4, new java.sql.Date(dataVencimentoInicial.getTime()));
                ps.setDate(5, new java.sql.Date(dataVencimentoInicial.getTime()));
                ps.setDate(6, new java.sql.Date(dataVencimentoFinal.getTime()));
            } else {
                ps.setNull(4, java.sql.Types.DATE);
                ps.setNull(5, java.sql.Types.DATE);
                ps.setNull(6, java.sql.Types.DATE);
            }
            
            //DatasCadastro
            if (dataCadastroInicial != null && dataCadastroFinal != null) {
                ps.setDate(7, new java.sql.Date(dataCadastroInicial.getTime()));
                ps.setDate(8, new java.sql.Date(dataCadastroInicial.getTime()));
                ps.setDate(9, new java.sql.Date(dataCadastroFinal.getTime()));
            } else {
                ps.setNull(7, java.sql.Types.DATE);
                ps.setNull(8, java.sql.Types.DATE);
                ps.setNull(9, java.sql.Types.DATE);
            }
            
            // Parâmetro para Cliente
            if (cpFiltros.getFornecedor().getCodigo() != null) {
                ps.setInt(10, cpFiltros.getFornecedor().getCodigo());
                ps.setInt(11, cpFiltros.getFornecedor().getCodigo());
            } else {
                ps.setNull(10, java.sql.Types.INTEGER);
                ps.setNull(11, java.sql.Types.INTEGER);
            }

            // Parâmetro para Descricao
            if (cpFiltros.getDescricaoConta() != null && !cpFiltros.getDescricaoConta().isEmpty()) {
                ps.setString(12, "%" + cpFiltros.getDescricaoConta() + "%"); 
                ps.setString(13, "%" + cpFiltros.getDescricaoConta() + "%");
            } else {
                ps.setNull(12, java.sql.Types.VARCHAR);
                ps.setNull(13, java.sql.Types.VARCHAR);
            }

            // Parâmetro para NumNota
            if (cpFiltros.getNumNota() != null) {
                ps.setInt(14, cpFiltros.getNumNota());
                ps.setInt(15, cpFiltros.getNumNota());
            } else {
                ps.setNull(14, java.sql.Types.INTEGER);
                ps.setNull(15, java.sql.Types.INTEGER);
            }

            // Parâmetro para Status (Baixada)
            if (cpFiltros.getStatus() != null) {
                ps.setInt(16, cpFiltros.getStatus());
                ps.setInt(17, cpFiltros.getStatus());
            } else {
                ps.setNull(16, java.sql.Types.INTEGER);
                ps.setNull(17, java.sql.Types.INTEGER);
            }

            // Parâmetro para ContaResultado
            if (cpFiltros.getSubContaResultado()!= null) {
                ps.setInt(18, cpFiltros.getSubContaResultado().getCodigo());
                ps.setInt(19, cpFiltros.getSubContaResultado().getCodigo());
            } else {
                ps.setNull(18, java.sql.Types.INTEGER);
                ps.setNull(19, java.sql.Types.INTEGER);
            }
            
            // Executando a consulta
            rs = ps.executeQuery();

            // Iterando sobre os resultados
            while (rs.next()) {
                //Convertendo as datas do tipo Date para String
                
                Pessoa fornecedor = new Pessoa();
                ContasPagar contaPagar=  new ContasPagar();
                Igreja igreja = new Igreja();
                fornecedor.setNome(rs.getString("NomePessoa"));
                fornecedor.setCodigo(rs.getInt("Fornecedor"));
                igreja.setCodigo(rs.getInt("Igreja"));
                contaPagar.setCodigo(rs.getInt("Codigo"));
                contaPagar.setFornecedor(fornecedor);
                contaPagar.setIgreja(igreja);
                contaPagar.setDescricaoConta(rs.getString("Descricao"));
                contaPagar.setValor(rs.getDouble("Valor"));
                contaPagar.setNumNota(rs.getInt("NumNota"));
                contaPagar.setParcela(rs.getInt("Parcela"));

                String dataVenc = converteData.convertendoDataStringSql(rs.getDate("DataVencimento"));
                String dataPag = converteData.convertendoDataStringSql(rs.getDate("DataPagamento"));
                String dataCad = converteData.convertendoDataStringSql(rs.getDate("DataCadastro"));

                contaPagar.setDataPagamento(dataPag);
                contaPagar.setDataCadastro(dataCad);
                contaPagar.setDataVencimento(dataVenc);

                listaContasPagar.add(contaPagar);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar as contas a pagar", "Erro 001", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Fechando recursos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
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
            
            JOptionPane.showMessageDialog(null, "Contas a Pagar excluída com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o contas a pagar ", "Erro 014", JOptionPane.ERROR_MESSAGE);
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

        } catch (SQLException e) {
            
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
    
    public void alterarStatusContaPagar(ContasPagar cpEfetivada, String dataPagamento){
                     
        try{            
            conexao = Conexao.getDataSource().getConnection();
            String sql= "UPDATE ContasPagar SET Baixada=?,DataPagamento=?" + " WHERE Codigo=?";
                     
            ps = conexao.prepareStatement(sql);
            ps.setInt(1,1);
            ps.setString(2, dataPagamento);
            ps.setInt(3,cpEfetivada.getCodigo());

            ps.executeUpdate();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o status a(s) conta(s) a pagar", "Erro 001", JOptionPane.ERROR_MESSAGE);
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
