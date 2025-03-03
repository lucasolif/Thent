
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.ContaCaixa;
import model.Igreja;
import model.MensagemEmail;
import model.ServidorEmail;
import model.Usuario;


public class EmailDao {
    
    private Connection conexao = null;
    private PreparedStatement stmtInsert = null;
    private PreparedStatement stmtSelect = null;
    private PreparedStatement stmtUpdate = null;
    private ResultSet rs = null;
    private final LogsDao logsDao = new LogsDao();
    
    public void cadastrarConfigEmailUsuario(ServidorEmail servidorEmail){
        
        String sql = "Insert Into ConfiguracaoEmailsUsuarios (NomeRemetente, ServidorEmail, EnderecoEmail, SenhaEmail, PortaServidor, Usuario, Status, EmailPrincipal, TipoSeguranca) Values(?,?,?,?,?,?,?,?,?)";
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();
            
            this.stmtInsert = this.conexao.prepareStatement(sql);
            this.stmtInsert.setString(1, servidorEmail.getNomeRemetente());
            this.stmtInsert.setString(2, servidorEmail.getServidorEmail());
            this.stmtInsert.setString(3, servidorEmail.getEnderecoEmail());
            this.stmtInsert.setString(4, servidorEmail.getSenhaEmail());
            this.stmtInsert.setInt(5, servidorEmail.getPortaServidor());
            this.stmtInsert.setInt(6, servidorEmail.getUsuario().getCodigo());
            this.stmtInsert.setInt(7, servidorEmail.getStatus());
            this.stmtInsert.setInt(8, servidorEmail.getEmailPrincipal());
            this.stmtInsert.setString(9, servidorEmail.getTipoSeguranca());
            this.stmtInsert.execute();
            
            JOptionPane.showMessageDialog(null, "Configurações do cadastrada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex) {            
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar as configurações do email", "Erro 001", JOptionPane.ERROR_MESSAGE);         
            logsDao.gravaLogsErro("ServidorEmailDao - "+ex.getSQLState()+" - "+ex.getMessage());
        }
        finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (stmtInsert != null) stmtInsert.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }   
    
    //Consultar para mostra na tabela todos os caixas cadastrados
    public ServidorEmail consultarConfigEmailUsuario(Usuario usuario){
        
        ServidorEmail servidorEmail = new ServidorEmail();
        String sql = "Select * From ConfiguracaoEmailsUsuarios Where Usuario = ?";

        try{
            this.conexao = Conexao.getDataSource().getConnection();           
            this.stmtSelect = this.conexao.prepareStatement(sql);                   
            this.stmtSelect.setInt(1,  usuario.getCodigo());
     
            this.rs = this.stmtSelect.executeQuery();

            while(this.rs.next()){
                servidorEmail.setCodigo(this.rs.getInt("Codigo"));
                servidorEmail.setNomeRemetente(this.rs.getString("NomeRemetente"));
                servidorEmail.setServidorEmail(this.rs.getString("ServidorEmail"));
                servidorEmail.setEnderecoEmail(this.rs.getString("EnderecoEmail"));
                servidorEmail.setSenhaEmail(this.rs.getString("SenhaEmail"));
                servidorEmail.setPortaServidor(this.rs.getInt("PortaServidor"));
                servidorEmail.setStatus(this.rs.getInt("Status"));
                servidorEmail.setEmailPrincipal(this.rs.getInt("EmailPrincipal"));
                servidorEmail.setTipoSeguranca(this.rs.getString("TipoSeguranca"));
            }
        }catch(SQLException ex){
            logsDao.gravaLogsErro("ServidorEmailDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar as configurações do email", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.stmtSelect != null) this.stmtSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("ServidorEmailDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return servidorEmail;
    }
    
    public void alterarConfigEmailUsuario(ServidorEmail serverEmail){
        
        String sql= "UPDATE ConfiguracaoEmailsUsuarios SET NomeRemetente = ?, ServidorEmail = ?, EnderecoEmail = ?, SenhaEmail = ?, PortaServidor = ?, Status = ?, EmailPrincipal = ?, TipoSeguranca = ? WHERE Codigo = ?";
         
        try{          
            conexao = Conexao.getDataSource().getConnection();                    
            stmtUpdate = conexao.prepareStatement(sql);
            
            stmtUpdate.setString(1, serverEmail.getNomeRemetente());
            stmtUpdate.setString(2, serverEmail.getServidorEmail());
            stmtUpdate.setString(3, serverEmail.getEnderecoEmail());
            stmtUpdate.setString(4, serverEmail.getSenhaEmail());
            stmtUpdate.setInt(5, serverEmail.getPortaServidor());
            stmtUpdate.setInt(6, serverEmail.getStatus());
            stmtUpdate.setInt(7, serverEmail.getEmailPrincipal());
            stmtUpdate.setString(8, serverEmail.getTipoSeguranca());
            stmtUpdate.setInt(9, serverEmail.getCodigo());
            
            stmtUpdate.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Configurações alteradas", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){
            logsDao.gravaLogsErro("ServidorEmailDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar as configurações do email", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (stmtUpdate != null) stmtUpdate.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }   
    }
    
    public ServidorEmail consultarEmailPrincpalRemetente(){
        
        Usuario usuario = new Usuario();
        ServidorEmail servidorEmail = new ServidorEmail();
        String sql = "Select * From ConfiguracaoEmailsUsuarios Where Status = 1 AND EmailPrincipal = 1";

        try{
            this.conexao = Conexao.getDataSource().getConnection();           
            this.stmtSelect = this.conexao.prepareStatement(sql);                   
            this.rs = this.stmtSelect.executeQuery();

            while(this.rs.next()){
                usuario.setCodigo(this.rs.getInt("Usuario"));
                servidorEmail.setCodigo(this.rs.getInt("Codigo"));
                servidorEmail.setNomeRemetente(this.rs.getString("NomeRemetente"));
                servidorEmail.setServidorEmail(this.rs.getString("ServidorEmail"));
                servidorEmail.setEnderecoEmail(this.rs.getString("EnderecoEmail"));
                servidorEmail.setSenhaEmail(this.rs.getString("SenhaEmail"));
                servidorEmail.setPortaServidor(this.rs.getInt("PortaServidor"));
                servidorEmail.setTipoSeguranca(this.rs.getString("TipoSeguranca"));
                servidorEmail.setUsuario(usuario);
            }
        }catch(SQLException ex){
            logsDao.gravaLogsErro("ServidorEmailDao - "+ex.getSQLState()+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar as configurações do email", "Erro 001", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (this.rs != null) this.rs.close();
                if (this.stmtSelect != null) this.stmtSelect.close();
                if (this.conexao != null) this.conexao.close();
            } catch (SQLException ex) {
                logsDao.gravaLogsErro("ServidorEmailDao - "+ex.getSQLState()+" - "+ex.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
        return servidorEmail;
    }
    
    public void gravarDadosEmailEnviado(MensagemEmail mensagem){
        String sql = "Insert Into MensagensEmailEnviada (EmailRemetente,EmailDestinatario,Assunto,Mensagem,DataHoraEnvio,Usuario) Values(?,?,?,?,GETDATE(),?)";
        
        try{
            this.conexao = Conexao.getDataSource().getConnection();
            
            this.stmtInsert = this.conexao.prepareStatement(sql);
            this.stmtInsert.setString(1, mensagem.getServidorEmailRemetente().getEnderecoEmail());
            this.stmtInsert.setString(2, mensagem.getEnderecoEmailDestinatario());
            this.stmtInsert.setString(3, mensagem.getAssunto());
            this.stmtInsert.setString(4, mensagem.getTextoEmail());
            this.stmtInsert.setInt(5, mensagem.getServidorEmailRemetente().getUsuario().getCodigo());

            this.stmtInsert.execute();
        }catch (SQLException ex) {            
            JOptionPane.showMessageDialog(null, "Erro ao salvar a mensagem enviada", "Erro", JOptionPane.ERROR_MESSAGE);         
            logsDao.gravaLogsErro("EmailDao - "+ex.getSQLState()+" - "+ex.getMessage());
        }
        finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (stmtInsert != null) stmtInsert.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
