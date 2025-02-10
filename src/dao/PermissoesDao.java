
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.FuncoesUsuario;


public class PermissoesDao {
    
    private final LogsDao logsDao = new LogsDao();
    private Connection conexao = null;
    private PreparedStatement stmtSelect = null;
    private ResultSet rs = null;
    
    //Consulta para popular o JComboBox
    public List<FuncoesUsuario> consultarFuncoesUsuario(){
        
        List<FuncoesUsuario> listaFuncoes = new ArrayList<>();
        
        try{
            conexao = Conexao.getDataSource().getConnection();
            
            String sql = "SELECT * FROM Funcoes ORDER BY Nome";
            stmtSelect = conexao.prepareStatement(sql);
            rs = stmtSelect.executeQuery();

            while(rs.next()){
                FuncoesUsuario funcoes = new FuncoesUsuario();
                funcoes.setCodigo(rs.getInt("Codigo"));
                funcoes.setNome(rs.getString("Nome"));

                listaFuncoes.add(funcoes);
            }
        }catch (SQLException ex) {
            logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar as funções dos usuário", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (stmtSelect != null) stmtSelect.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro(ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }

        return listaFuncoes;
    }
    
}
