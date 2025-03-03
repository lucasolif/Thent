
package view.configuracoes;

import autenticacao.CriptografarSenhas;
import dao.EmailDao;
import dao.UsuarioDao;
import interfaces.ConsultaUsuarios;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.ServidorEmail;
import model.Usuario;
import view.carregamentoConsultas.TelaConsultaUsuarios;


public class ServidorEmailForm extends javax.swing.JInternalFrame implements ConsultaUsuarios {

    private final CriptografarSenhas criptografar = new CriptografarSenhas();
    private final UsuarioDao usuarioDao = new UsuarioDao();
    private final EmailDao servidorEmailDao = new EmailDao();
    private List<Usuario> listaUsuario;
    private Usuario usuarioSelec;
    private ServidorEmail configServidorUsuarioSelec = null;
    
    public ServidorEmailForm() {
        initComponents();
        formInicial();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        codUsuario = new javax.swing.JTextField();
        nomeUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        servidorEmail = new javax.swing.JTextField();
        portaServidor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        enderecoEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbStatusConfiguracao = new javax.swing.JCheckBox();
        btnSalvar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        nomeRemetente = new javax.swing.JTextField();
        senhaEmail = new javax.swing.JPasswordField();
        cbEmailPrincipal = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        tipoSeguranca = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Configuração Servidor de Email");

        codUsuario.setEditable(false);
        codUsuario.setBackground(new java.awt.Color(204, 204, 204));

        nomeUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeUsuarioKeyPressed(evt);
            }
        });

        jLabel1.setText("Usuário");

        jLabel2.setText("Servidor Email");

        jLabel3.setText("Porta");

        jLabel4.setText("Endereço Email");

        jLabel5.setText("Senha");

        cbStatusConfiguracao.setText("Ativo?");

        btnSalvar.setBackground(new java.awt.Color(0, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel6.setText("Nome Remetente");

        cbEmailPrincipal.setText("Principal");

        jLabel7.setText("Tp Segurança");

        tipoSeguranca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SSL", "TLS" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tipoSeguranca, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(enderecoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(senhaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbStatusConfiguracao))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(servidorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(portaServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nomeRemetente, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbEmailPrincipal))))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(servidorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nomeRemetente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbEmailPrincipal)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portaServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enderecoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(senhaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbStatusConfiguracao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoSeguranca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeUsuarioKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarUsuarios();
            carregarResultadoConsultaUsuarios();
            consultarCarregarConfiguracaoServidor();
        }else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.codUsuario.setText("");
            this.nomeUsuario.setText("");
        }
    }//GEN-LAST:event_nomeUsuarioKeyPressed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
         salvarAlterarConfiguracaoServidor();
         formInicial();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void consultarUsuarios(){
        String textoBusca = this.nomeUsuario.getText();
        this.listaUsuario = this.usuarioDao.consultarUsuario(textoBusca);
    }
    
    private void carregarResultadoConsultaUsuarios(){
        TelaConsultaUsuarios resultConsultaUsuarios = new TelaConsultaUsuarios((Frame) SwingUtilities.getWindowAncestor(this), this.listaUsuario);
        resultConsultaUsuarios.setUsuarioSelecionado(this);
        resultConsultaUsuarios.setLocationRelativeTo(this);
        resultConsultaUsuarios.setVisible(true);
    }
    
    private void carregarUsuarioEscolhido(Usuario usuario){
        this.codUsuario.setText(String.valueOf(usuario.getCodigo()));
        this.nomeUsuario.setText(usuario.getNome());
        
        this.usuarioSelec = usuario;
    }
    
    private void formInicial(){
        this.codUsuario.setText("");
        this.nomeUsuario.setText("");
        this.servidorEmail.setText("");
        this.portaServidor.setText("");
        this.nomeRemetente.setText("");
        this.enderecoEmail.setText("");
        this.senhaEmail.setText("");
        this.cbStatusConfiguracao.setSelected(true);
    }
    
    private void salvarAlterarConfiguracaoServidor(){
        if(verificarCamposVazios()){
            
            Integer codUsuario = Integer.valueOf(this.codUsuario.getText());
            String servidorEmail = this.servidorEmail.getText();
            Integer portaServidor = Integer.valueOf(this.portaServidor.getText());
            String nomeRemetente = this.nomeRemetente.getText();
            String enderecoEmail = this.enderecoEmail.getText();
            String senhaCriptografada = criptografar.criarChaveCriptografarSenha(this.senhaEmail.getText());
            String tipoSeguranca = (String) this.tipoSeguranca.getSelectedItem();
            Integer status = 0;
            Integer emailPrincipal = 0;
            if(this.cbStatusConfiguracao.isSelected()){
                status = 1;
            }
            if(this.cbEmailPrincipal.isSelected()){
                emailPrincipal = 1;
            }
            
            if(configServidorUsuarioSelec == null){
                Usuario usuario = new Usuario();
                usuario.setCodigo(codUsuario);
                ServidorEmail serverEmail = new ServidorEmail();
                serverEmail.setServidorEmail(servidorEmail);
                serverEmail.setEnderecoEmail(enderecoEmail);
                serverEmail.setNomeRemetente(nomeRemetente);
                serverEmail.setPortaServidor(portaServidor);
                serverEmail.setUsuario(usuario);  
                serverEmail.setStatus(status);
                serverEmail.setEmailPrincipal(emailPrincipal);
                serverEmail.setSenhaEmail(senhaCriptografada);
                serverEmail.setTipoSeguranca(tipoSeguranca);
                
                this.servidorEmailDao.cadastrarConfigEmailUsuario(serverEmail);
                
            }else{
                ServidorEmail serverEmail = new ServidorEmail();
                serverEmail.setCodigo(configServidorUsuarioSelec.getCodigo());
                serverEmail.setServidorEmail(servidorEmail);
                serverEmail.setEnderecoEmail(enderecoEmail);
                serverEmail.setNomeRemetente(nomeRemetente);
                serverEmail.setPortaServidor(portaServidor); 
                serverEmail.setStatus(status);
                serverEmail.setEmailPrincipal(emailPrincipal);
                serverEmail.setSenhaEmail(senhaCriptografada);
                serverEmail.setTipoSeguranca(tipoSeguranca);
                
                this.servidorEmailDao.alterarConfigEmailUsuario(serverEmail);
            }   
        }else{
            JOptionPane.showMessageDialog(null, "Informe o usuário", "Erro", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    private void consultarCarregarConfiguracaoServidor(){
        ServidorEmail servidorEmail = servidorEmailDao.consultarConfigEmailUsuario(this.usuarioSelec);
        
        if(servidorEmail != null){
            this.servidorEmail.setText(servidorEmail.getServidorEmail());
            this.portaServidor.setText(String.valueOf(servidorEmail.getPortaServidor()));
            this.nomeRemetente.setText(servidorEmail.getNomeRemetente());
            this.enderecoEmail.setText(servidorEmail.getEnderecoEmail());
            this.senhaEmail.setText(servidorEmail.getSenhaEmail());
            this.tipoSeguranca.setSelectedItem(servidorEmail.getTipoSeguranca());
            if(servidorEmail.getStatus() == 1){
                this.cbStatusConfiguracao.setSelected(true);
            }else{
                this.cbStatusConfiguracao.setSelected(false);
            }
            if(servidorEmail.getEmailPrincipal() == 1){
                this.cbEmailPrincipal.setSelected(true);
            }else{
                this.cbEmailPrincipal.setSelected(false);
            }
            
            configServidorUsuarioSelec = servidorEmail;
        }
        
    }
    
    private boolean verificarCamposVazios(){
        boolean preenchido = true;
        
        if(this.codUsuario.getText().isEmpty() || this.nomeRemetente.getText().isEmpty() || this.nomeUsuario.getText().isEmpty() || this.servidorEmail.getText().isEmpty() || this.senhaEmail.getText().isEmpty() || this.portaServidor.getText().isEmpty() || this.enderecoEmail.getText().isEmpty()){
            preenchido = false;
        }

        return preenchido;
    }
    
    
    
    @Override
    public void usuarioSelecionado(Usuario usuarioEscolhido) {
        carregarUsuarioEscolhido(usuarioEscolhido);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbEmailPrincipal;
    private javax.swing.JCheckBox cbStatusConfiguracao;
    private javax.swing.JTextField codUsuario;
    private javax.swing.JTextField enderecoEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nomeRemetente;
    private javax.swing.JTextField nomeUsuario;
    private javax.swing.JTextField portaServidor;
    private javax.swing.JPasswordField senhaEmail;
    private javax.swing.JTextField servidorEmail;
    private javax.swing.JComboBox<String> tipoSeguranca;
    // End of variables declaration//GEN-END:variables


}
