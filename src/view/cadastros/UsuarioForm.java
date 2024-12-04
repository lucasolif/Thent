
package view.cadastros;

import java.util.Base64;
import dao.IgrejaDao;
import model.Usuario;
import dao.UsuarioDao;
import ferramentas.CriptografarSenhas;
import ferramentas.PaletaCores;
import interfaces.ConsultaUsuarios;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Igreja;
import view.carregamentoConsultas.TelaConsultaUsuarios;
public class UsuarioForm extends javax.swing.JInternalFrame implements ConsultaUsuarios{

    private final UsuarioDao usuarioDao = new UsuarioDao();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final PaletaCores cores = new PaletaCores();
    private Usuario userSelec;
    private List<Usuario> listaUser;
      
    public UsuarioForm() {
        initComponents();
        formInicial();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usuarioCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbAtivo = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        usuarioLogin = new javax.swing.JTextField();
        usuarioSenha = new javax.swing.JPasswordField();
        usuarioConfirmSenha = new javax.swing.JPasswordField();
        usuarioNome = new javax.swing.JTextField();
        usuarioCelular = new javax.swing.JFormattedTextField();
        usuarioEmail = new javax.swing.JTextField();
        campoIgreja = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buscarUsuario = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Usuários");
        setPreferredSize(new java.awt.Dimension(730, 540));

        btnSalvar.setBackground(new java.awt.Color(51, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lixeira-16.png"))); // NOI18N
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(0, 153, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Buscar");

        jLabel5.setText("Código");

        jLabel3.setText("Confirmar Senha*");

        usuarioCodigo.setEditable(false);
        usuarioCodigo.setBackground(new java.awt.Color(204, 204, 204));
        usuarioCodigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        usuarioCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        usuarioCodigo.setFocusable(false);

        jLabel4.setText("Nome*");

        cbAtivo.setSelected(true);
        cbAtivo.setText("Ativo?");

        jLabel6.setText("E-mail*");

        jLabel7.setText("Celular*");

        try {
            usuarioCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("Usuário*");

        jLabel8.setText("Campo/Igreja");

        jLabel2.setText("Senha*");

        buscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarUsuarioKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(usuarioCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(usuarioEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbAtivo))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(usuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(usuarioConfirmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(campoIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(btnBuscar)
                            .addComponent(buscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usuarioCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarioCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usuarioEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAtivo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(usuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarioConfirmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar))
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            salvarAlterarCadastro();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro no formulário, ao tentar cadastrar/alterar usuário", "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirUsuario();
        formInicial();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        formAtualizacao();
        consultarUsuarios();
        carregarResultadoConsultaUsuarios();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        formInicial();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void buscarUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarUsuarioKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            formAtualizacao();
            consultarUsuarios();
            carregarResultadoConsultaUsuarios();
        }
    }//GEN-LAST:event_buscarUsuarioKeyPressed

    private void formAtualizacao(){ 
        this.usuarioLogin.setFocusable(false);
        this.usuarioLogin.setEditable(false);
        this.usuarioLogin.setBackground(cores.cinza());
        this.usuarioSenha.setBackground(cores.cinza());
        this.usuarioConfirmSenha.setBackground(cores.cinza());
        this.usuarioSenha.setEditable(false);
        this.usuarioConfirmSenha.setEditable(false);
        this.usuarioSenha.setFocusable(false);
        this.usuarioConfirmSenha.setFocusable(false);
        this.cbAtivo.setEnabled(true);
    }
    
    private void formInicial(){        
        this.usuarioCodigo.setText("");
        this.buscarUsuario.setText("");
        this.usuarioNome.setText("");
        this.usuarioNome.requestFocusInWindow();
        this.usuarioCelular.setText("");
        this.usuarioEmail.setText("");
        this.usuarioLogin.setText("");
        this.usuarioSenha.setText("");
        this.usuarioConfirmSenha.setText("");
        this.usuarioLogin.setBackground(cores.branco());
        this.usuarioSenha.setBackground(cores.branco());
        this.usuarioConfirmSenha.setBackground(cores.branco());
        this.usuarioSenha.setEditable(true);
        this.usuarioConfirmSenha.setEditable(true);
        this.usuarioLogin.setEnabled(true);
        this.usuarioSenha.setEnabled(true);
        this.usuarioConfirmSenha.setEnabled(true);
        this.cbAtivo.setEnabled(false);
        this.cbAtivo.setSelected(true);
        this.userSelec = null;
        carregarIgrejas();     
    }
    
    private void consultarUsuarios(){
        String textoBusca = this.buscarUsuario.getText();
        this.listaUser = this.usuarioDao.consultar(textoBusca);
    }
    
    private void carregarResultadoConsultaUsuarios(){
        TelaConsultaUsuarios resultConsultaUsuarios = new TelaConsultaUsuarios((Frame) SwingUtilities.getWindowAncestor(this), this.listaUser);
        resultConsultaUsuarios.setUsuarioSelecionado(this);
        resultConsultaUsuarios.setLocationRelativeTo(this);
        resultConsultaUsuarios.setVisible(true);
    }
    
    private void carregarUsuarioEscolhido(Usuario usuario){
        this.usuarioCodigo.setText(String.valueOf(usuario.getCodigo()));
        this.usuarioNome.setText(usuario.getNome());
        this.usuarioEmail.setText(usuario.getEmail());
        this.usuarioCelular.setText(usuario.getCelular());
        this.usuarioLogin.setText(usuario.getLogin());
        this.usuarioSenha.setText(usuario.getHashSenha());
        this.usuarioConfirmSenha.setText(usuario.getHashSenha());
        this.campoIgreja.setSelectedItem(usuario.getIgreja());
        if(usuario.getAtivo() == 1){
            cbAtivo.setSelected(true);
        }else{
            cbAtivo.setSelected(false);
        }
        
        this.userSelec = usuario;
    }
    
    private void carregarIgrejas(){
        List<Igreja> listaIgrejas = igrejaDao.consultarTodasIgrejas();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)campoIgreja.getModel();
        modelo.removeAllElements();
        for(Igreja igreja : listaIgrejas){
            modelo.addElement(igreja);
        }
    }   

    private void salvarAlterarCadastro() throws Exception{
           
        Integer status = 0;
        String rashSenha = null;
        String saltSenha = null;
        String nome = usuarioNome.getText();
        String celular = usuarioCelular.getText();
        String email = usuarioEmail.getText();
        Igreja igreja = (Igreja) this.campoIgreja.getSelectedItem();
        String login = usuarioLogin.getText();
        String senha = usuarioSenha.getText();
        String confirmSenha = usuarioConfirmSenha.getText();        
        
        if(cbAtivo.isSelected()){
            status = 1;
        }   
        
        if(verificandoCamposVazio(nome, celular, email, login, senha)){
            JOptionPane.showMessageDialog(null, "Campos vazios. Preencha todos os campos obrigatórios", "Erro", JOptionPane.WARNING_MESSAGE);
        }else{
            //Adicionando o usuário no banco de dados
            if(userSelec == null){
                if(validarIgualdadeSenha(senha, confirmSenha) && validarForcaSenha(senha)){            
                    byte[] salt = CriptografarSenhas.gerarSalt();
                    rashSenha = CriptografarSenhas.gerarHash(senha,salt);
                    saltSenha = Base64.getEncoder().encodeToString(salt);

                    Usuario usuario = new Usuario();
                    usuario.setLogin(login);
                    usuario.setNome(nome);
                    usuario.setEmail(email);
                    usuario.setCelular(celular);
                    usuario.setAtivo(status);
                    usuario.setIgreja(igreja);
                    usuario.setSaltSenha(saltSenha);
                    usuario.setHashSenha(rashSenha);
                    
                    this.usuarioDao.adicionar(usuario);                  
                    formInicial();
                }
            }else{
                this.userSelec.setNome(nome);
                this.userSelec.setCelular(celular);
                this.userSelec.setEmail(email);
                this.userSelec.setIgreja(igreja);
                this.userSelec.setAtivo(status);
                
                this.usuarioDao.alterar(this.userSelec);               
                formInicial();
            }
        } 
    }
    
    private void excluirUsuario(){
        if(this.usuarioCodigo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Selecione um usuário a ser excluído","Atenção",JOptionPane.WARNING_MESSAGE);
        }else{  
            int confirm = JOptionPane.showConfirmDialog(null,"Excluir o usuário "+userSelec.getLogin()+" ?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                this.usuarioDao.remover(this.userSelec.getCodigo());
                consultarUsuarios();
                formInicial();
            }else if(confirm == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            }
        }
    }
    
    private boolean verificandoCamposVazio(String nome, String celular, String email, String login, String senha){
        if(nome.isEmpty() || celular.isEmpty() || email.isEmpty() || login.isEmpty() || senha.isEmpty()){        
            return true;
        }else{
            return false;
        } 
    }
    
    private boolean validarIgualdadeSenha(String senha, String confirmacaoSenha){
        
        boolean control;
        
        if(confirmacaoSenha.equalsIgnoreCase(senha)){  
            control = true;
        }else{
            JOptionPane.showMessageDialog(null, "Senhas diferente. Digite a mesma senha em ambos os campos", "Erro 003", JOptionPane.WARNING_MESSAGE);
            control = false;
        }       
        return control;
    }
    
    private boolean validarForcaSenha(String senha){
        
        boolean control;
        
        Pattern pattern = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{6,20}$");
        Matcher matcher = pattern.matcher(senha);
        if (matcher.find()) {
            control = true;
        }else{
            JOptionPane.showMessageDialog(null, "Senha fraca, precisa conter: letra maiúscula e número.", "Erro 003", JOptionPane.WARNING_MESSAGE);
            control = false;
        }       
        return control;
    }
        
    @Override
    public void usuarioSelecionado(Usuario usuarioEscolhido) {
        carregarUsuarioEscolhido(usuarioEscolhido);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField buscarUsuario;
    private javax.swing.JComboBox<String> campoIgreja;
    private javax.swing.JCheckBox cbAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JFormattedTextField usuarioCelular;
    private javax.swing.JTextField usuarioCodigo;
    private javax.swing.JPasswordField usuarioConfirmSenha;
    private javax.swing.JTextField usuarioEmail;
    private javax.swing.JTextField usuarioLogin;
    private javax.swing.JTextField usuarioNome;
    private javax.swing.JPasswordField usuarioSenha;
    // End of variables declaration//GEN-END:variables
 
}
