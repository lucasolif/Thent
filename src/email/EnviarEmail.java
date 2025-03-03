
package email;

import dao.LogsDao;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import model.MensagemEmail;


public class EnviarEmail {
    
    private final LogsDao logsDao = new LogsDao();
    
    public void enviarEmail(MensagemEmail dadosEnvioEmail) throws UnsupportedEncodingException{
        
        String server = dadosEnvioEmail.getServidorEmailRemetente().getServidorEmail();  
        String enderecoEmailRemetente = dadosEnvioEmail.getServidorEmailRemetente().getEnderecoEmail();  
        String senha = dadosEnvioEmail.getServidorEmailRemetente().getSenhaEmail();  // Senha do seu email ou senha de aplicativo
        Integer porta = dadosEnvioEmail.getServidorEmailRemetente().getPortaServidor();

        // Configuração das propriedades para a conexão com o servidor SMTP do Gmail
        String tipoSeguranca = null;
        if(dadosEnvioEmail.getServidorEmailRemetente().getTipoSeguranca().equalsIgnoreCase("ssl")){
            tipoSeguranca = "mail.smtp.ssl.enable";
        }else{
            tipoSeguranca = "mail.smtp.starttls.enable";
        }
        Properties propriedades = new Properties();
        propriedades.put("mail.smtp.auth", "true");
        propriedades.put(tipoSeguranca, "true");
        propriedades.put("mail.smtp.host", server);
        propriedades.put("mail.smtp.port", porta);

        // Criando a sessão com as credenciais e autenticando com senha convertida para char[]
        Session sessao = Session.getInstance(propriedades, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                // Usando a classe correta: javax.mail.PasswordAuthentication
                return new javax.mail.PasswordAuthentication(enderecoEmailRemetente, senha);
            }
        });

        try {
            // Criando o objeto de mensagem
            Message mensagemEmail = new MimeMessage(sessao);
            // Configurando o nome do remetente e o endereço de e-mail
            String nomeRemetente = dadosEnvioEmail.getServidorEmailRemetente().getNomeRemetente();  // Substitua pelo nome desejado
            InternetAddress remetente = new InternetAddress(enderecoEmailRemetente, nomeRemetente);
            mensagemEmail.setFrom(remetente);  // Remetente
            mensagemEmail.setRecipients(Message.RecipientType.TO, InternetAddress.parse(dadosEnvioEmail.getEnderecoEmailDestinatario()));  // Destinatário
            mensagemEmail.setSubject(dadosEnvioEmail.getAssunto());  // Assunto
            mensagemEmail.setText(dadosEnvioEmail.getTextoEmail());  // Corpo do e-mail

            // Enviando o e-mail
            Transport.send(mensagemEmail);
            JOptionPane.showMessageDialog(null, "Email enviado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
        } catch (MessagingException ex) {
            logsDao.gravaLogsErro("EmailDao - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar enviar o email", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
