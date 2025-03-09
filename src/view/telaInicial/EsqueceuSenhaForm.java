
package view.telaInicial;

import autenticacao.CriptografarSenhas;
import email.EnviarEmail;
import dao.EmailDao;
import dao.LogsDao;
import dao.UsuarioDao;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;
import model.MensagemEmail;
import model.ServidorEmail;
import model.Usuario;


public class EsqueceuSenhaForm extends javax.swing.JDialog {

    private final UsuarioDao usuarioDao = new UsuarioDao();    
    private final CriptografarSenhas senha = new CriptografarSenhas();
    private final EmailDao serverEmailDao = new EmailDao();
    private final EnviarEmail enviarEmail = new EnviarEmail();
    private final LogsDao logsDao = new LogsDao();

    public EsqueceuSenhaForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        email = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnRecuperar = new javax.swing.JButton();
        login = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Esqueceu sua senha?");

        jLabel1.setText("Email");

        btnRecuperar.setBackground(new java.awt.Color(0, 204, 0));
        btnRecuperar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRecuperar.setText("Recuperar");
        btnRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperarActionPerformed(evt);
            }
        });

        jLabel2.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRecuperar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRecuperar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarActionPerformed
        try {
            recuperarSenhaSistema();
            formInicial();    
        } catch (Exception ex) {
            logsDao.gravaLogsErro("ServidorEmailDao - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Generic error when trying to recover password", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRecuperarActionPerformed

    private void recuperarSenhaSistema() throws Exception{
        if(!this.email.getText().isEmpty() && !this.login.getText().isEmpty()){
            
            String login = this.login.getText();
            String email = this.email.getText();
            //Verificar se há usuario com o login e email informado
            Integer codUsuario = usuarioDao.validarUsuarioRecuperacaoSenha(login, email);
                       
            if(codUsuario != null){
                //Gera a nova senha e altera no banco de dados
                String emailDestinatario = this.email.getText();
                String senhaAleatoria = gerarGravarNovaSenha(codUsuario); //Nova senha do sistema, gerada
                ServidorEmail dadosRemetente = serverEmailDao.consultarEmailPrincpalRemetente();
                SecretKey chave = senha.obterChave(); //Chave para descriptografar a senha do email remetente
                String senhaEmailDescriptografada = senha.descriptografarSenha(dadosRemetente.getSenhaEmail(), chave);
                dadosRemetente.setSenhaEmail(senhaEmailDescriptografada);
                             
                //Dados textuais do email
                String assunto = "Alteração de Senha de acesso ao sistemas";
                String textoEmail = "A sua nova senha é: "+ senhaAleatoria+". Altere-a após o primeiro acesso.";
                
                //Dados para envio do email
                MensagemEmail dadosEnvioEmail = new MensagemEmail();
                dadosEnvioEmail.setAssunto(assunto);
                dadosEnvioEmail.setTextoEmail(textoEmail);
                dadosEnvioEmail.setServidorEmailRemetente(dadosRemetente);
                dadosEnvioEmail.setEnderecoEmailDestinatario(emailDestinatario);
                
                //Envia a nova senha via email
                this.enviarEmail.enviarEmail(dadosEnvioEmail); 
                
                //Salvar os dados da mensagem enviada
                this.serverEmailDao.gravarDadosEmailEnviado(dadosEnvioEmail);
                
                //Fecha a tela
                dispose();
                
            }else{
                JOptionPane.showMessageDialog(null, "Email não cadastrado ou usuário inexistente", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "A sua senha foi enviada para o email cadastrado", "Concluído", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Informe o login e o email cadastrado no seu usuário", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private String gerarGravarNovaSenha(Integer codUsuario) throws Exception{
        
        String senhaAleatorio = senha.geradorSenhaAleatoria(); //Gera uma senha aleatório
        //Criar o Rash e Salt apartir da senha aleatório
        byte[] salt = CriptografarSenhas.gerarSalt();
        String rashSenha = CriptografarSenhas.gerarHash(senhaAleatorio,salt);
        String saltSenha = Base64.getEncoder().encodeToString(salt);

        //Adiciona a senha e o usuário no obejto, e depois altera a senha no banco de dados.
        Usuario usuario = new Usuario();
        usuario.setCodigo(codUsuario);
        usuario.setHashSenha(rashSenha);
        usuario.setSaltSenha(saltSenha);              
        this.usuarioDao.alterarSenha(usuario);
        
        return senhaAleatorio;
    }
    
    private void formInicial(){
        this.login.setText("");
        this.email.setText("");
    }
    
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRecuperar;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField login;
    // End of variables declaration//GEN-END:variables
}
