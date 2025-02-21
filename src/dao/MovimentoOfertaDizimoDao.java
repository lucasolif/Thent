
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
import model.Igreja;
import model.RegistroDizimoOferta;
import model.TipoOferta;


public class MovimentoOfertaDizimoDao {
    
    private final LogsDao logsDao = new LogsDao();
    private Connection conexao = null;
    private PreparedStatement stmSelect = null;
    private ResultSet rs = null;
    
    
    public List<RegistroDizimoOferta> consultarMovimentoDizimoOferta(TipoOferta tpOferta, ContaCaixa contaCaixa, Date dataInicial, Date dataFinal){

        List<RegistroDizimoOferta> listaRgDizimoOferta = new ArrayList<>();

        String sql = "Select " +
            "(Select Descricao From TiposOfertas TP Where TP.Codigo = MTO.TipoOferta) As NomeTipoOferta, " +
            "(Select NomeIgreja From Igrejas I Where I.Codigo = MTO.Igreja) As NomeIgreja, " +
            "(Select Descricao From ContasCaixa CC Where CC.Codigo = MTO.ContaCaixa) As NomeContaCaixa, " +
            "MTO.* " +
            "FROM MovimentoTipoOferta MTO " +
            "WHERE MTO.DataMovimento BETWEEN ? AND ? " +
            "AND (? IS NULL OR MTO.TipoOferta = ?) " +
            "AND (? IS NULL OR MTO.ContaCaixa = ?) ";
        
        try {
            this.conexao = Conexao.getDataSource().getConnection();         
            this.stmSelect = this.conexao.prepareStatement(sql);  
            
            this.stmSelect.setDate(1, new java.sql.Date(dataInicial.getTime()));
            this.stmSelect.setDate(2, new java.sql.Date(dataFinal.getTime()));

            // Parâmetro para Cliente
            if (contaCaixa != null) {
                this.stmSelect.setInt(3, contaCaixa.getCodigo());
                this.stmSelect.setInt(4, contaCaixa.getCodigo());
            } else {
                this.stmSelect.setNull(3, java.sql.Types.INTEGER);
                this.stmSelect.setNull(4, java.sql.Types.INTEGER);
            }

            // Parâmetro para Descricao
            if (tpOferta != null) {
                this.stmSelect.setInt(5, tpOferta.getCodigo()); 
                this.stmSelect.setInt(6, tpOferta.getCodigo());
            } else {
                this.stmSelect.setNull(5, java.sql.Types.INTEGER);
                this.stmSelect.setNull(6, java.sql.Types.INTEGER);
            }
               
            rs = this.stmSelect.executeQuery();

            // Iterando sobre os resultados
            while (rs.next()) {
                
                TipoOferta tipoOferta = new TipoOferta();
                ContaCaixa cx = new ContaCaixa();
                Igreja igreja = new Igreja();
                RegistroDizimoOferta rgDizimoOferta = new RegistroDizimoOferta();
                  
                
                tipoOferta.setCodigo(this.rs.getInt("TipoOferta"));
                tipoOferta.setNome(this.rs.getString("NomeTipoOferta"));
                cx.setCodigo(this.rs.getInt("ContaCaixa"));
                cx.setNome(this.rs.getString("NomeContaCaixa"));
                igreja.setCodigo(this.rs.getInt("Igreja"));
                igreja.setNome(this.rs.getString("NomeIgreja"));
                rgDizimoOferta.setValorOfertaEntrada(this.rs.getDouble("Entrada"));
                rgDizimoOferta.setValorOfertaSaida(this.rs.getDouble("Saida"));
                rgDizimoOferta.setComplemento(this.rs.getString("Complemento"));
                rgDizimoOferta.setDataCadastro(this.rs.getDate("DataMovimento"));
                rgDizimoOferta.setContaCaixa(cx);
                rgDizimoOferta.setIgreja(igreja);
                rgDizimoOferta.setTpOferta(tipoOferta);

                listaRgDizimoOferta.add(rgDizimoOferta);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar movimento de dízimo e ofertas", "Erro 001", JOptionPane.ERROR_MESSAGE);
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
        } finally {
            try {
                if (this.rs != null) this.rs.close();
                if (this.stmSelect != null) this.stmSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaRgDizimoOferta;       
    }
    
    public List<RegistroDizimoOferta> consultarTotaisDizimoOferta(TipoOferta tpOferta, ContaCaixa contaCaixa, Date dataInicial, Date dataFinal){

        List<RegistroDizimoOferta> listaRgDizimoOferta = new ArrayList<>();

        String sql = "SELECT TipoOferta, " +
            "SUM(Entrada) - SUM(Saida) As ValorTotal FROM MovimentoTipoOferta MTO " +
            "WHERE MTO.DataMovimento BETWEEN ? AND ? " +
            "AND (? IS NULL OR MTO.TipoOferta = ?) " +
            "AND (? IS NULL OR MTO.ContaCaixa = ?) " +
            "GROUP BY TipoOferta";
        
        try {
            this.conexao = Conexao.getDataSource().getConnection();         
            this.stmSelect = this.conexao.prepareStatement(sql);  
            
            this.stmSelect.setDate(1, new java.sql.Date(dataInicial.getTime()));
            this.stmSelect.setDate(2, new java.sql.Date(dataFinal.getTime()));

            // Parâmetro para Cliente
            if (contaCaixa != null) {
                this.stmSelect.setInt(3, contaCaixa.getCodigo());
                this.stmSelect.setInt(4, contaCaixa.getCodigo());
            } else {
                this.stmSelect.setNull(3, java.sql.Types.INTEGER);
                this.stmSelect.setNull(4, java.sql.Types.INTEGER);
            }

            // Parâmetro para Descricao
            if (tpOferta != null) {
                this.stmSelect.setInt(5, tpOferta.getCodigo()); 
                this.stmSelect.setInt(6, tpOferta.getCodigo());
            } else {
                this.stmSelect.setNull(5, java.sql.Types.INTEGER);
                this.stmSelect.setNull(6, java.sql.Types.INTEGER);
            }
               
            rs = this.stmSelect.executeQuery();

            // Iterando sobre os resultados
            while (rs.next()) {
                
                TipoOferta tipoOferta = new TipoOferta();
                RegistroDizimoOferta rgDizimoOferta = new RegistroDizimoOferta();
                tipoOferta.setCodigo(this.rs.getInt("TipoOferta"));
                rgDizimoOferta.setValorTotal(this.rs.getDouble("ValorTotal"));
                rgDizimoOferta.setTpOferta(tipoOferta);
                
                listaRgDizimoOferta.add(rgDizimoOferta);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o total do movimento de dízimo e ofertas", "Erro 001", JOptionPane.ERROR_MESSAGE);
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
        } finally {
            try {
                if (this.rs != null) this.rs.close();
                if (this.stmSelect != null) this.stmSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listaRgDizimoOferta;       
    }
    
}
