
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.UsuarioLogado;


public class LogsDao {
    
    private Connection conexao = null;
    private PreparedStatement insertStmt = null;
    
    public void gravaLogsErro(String messagem){

        String sqlInsert = "Insert Into LogsErro(DataEvento, Mensagem) Values(GETDATE(),?)";

        try{
            this.conexao = Conexao.getDataSource().getConnection();
            
            this.insertStmt = this.conexao.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS); 
            this.insertStmt.setString(1, messagem);
            this.insertStmt.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar gravar log do erro", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }finally{
            try{
                if(this.insertStmt != null) this.insertStmt.close();
                if(this.conexao != null) this.conexao.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }   
    
}
