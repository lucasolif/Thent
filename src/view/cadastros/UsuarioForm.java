
package view.cadastros;

import java.util.Base64;
import dao.IgrejaDao;
import model.Usuario;
import dao.UsuarioDao;
import Services.CriptografarSenhas;
import Services.PaletaCores;
import dao.PermissoesDao;
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
import model.FuncoesUsuario;
import model.Igreja;
import model.UsuarioLogado;
import view.carregamentoConsultas.TelaConsultaUsuarios;
public class UsuarioForm extends javax.swing.JInternalFrame implements ConsultaUsuarios{

    private final PermissoesDao permissaoDao = new PermissoesDao();
    private final UsuarioDao usuarioDao = new UsuarioDao();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final PaletaCores cores = new PaletaCores();
    private Usuario userSelec;
    private List<Usuario> listaUser;
      
    public UsuarioForm(UsuarioLogado usuarioLogado) {
        initComponents();
        formInicial();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        usuarioLogin = new javax.swing.JTextField();
        buscarUsuario = new javax.swing.JTextField();
        usuarioSenha = new javax.swing.JPasswordField();
        btnBuscar = new javax.swing.JButton();
        usuarioConfirmSenha = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        usuarioNome = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        usuarioCodigo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        usuarioCelular = new javax.swing.JFormattedTextField();
        usuarioEmail = new javax.swing.JTextField();
        campoIgreja = new javax.swing.JComboBox<>();
        cbAtivo = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        funcaoCargo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Usuários");
        setPreferredSize(new java.awt.Dimension(475, 320));

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

        jLabel9.setText("Campo/Igreja");

        jLabel10.setText("Celular*");

        jLabel12.setText("Senha*");

        buscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarUsuarioKeyPressed(evt);
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

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Buscar");

        jLabel14.setText("Código");

        jLabel15.setText("Confirmar Senha*");

        usuarioCodigo.setEditable(false);
        usuarioCodigo.setBackground(new java.awt.Color(204, 204, 204));
        usuarioCodigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        usuarioCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        usuarioCodigo.setFocusable(false);

        jLabel16.setText("Nome*");

        try {
            usuarioCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cbAtivo.setSelected(true);
        cbAtivo.setText("Ativo?");

        jLabel17.setText("Usuário*");

        jLabel18.setText("E-mail*");

        jLabel1.setText("Função/Cargo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(usuarioEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(campoIgreja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(98, 98, 98)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(usuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(usuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                    .addComponent(usuarioConfirmSenha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(funcaoCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(usuarioCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(usuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(usuarioCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 24, Short.MAX_VALUE)))
                        .addGap(8, 8, 8))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(btnBuscar)
                    .addComponent(buscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usuarioCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usuarioCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAtivo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarioEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usuarioConfirmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(funcaoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
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
            formInicial();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro no formulário, ao tentar cadastrar/alterar usuário", "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirUsuario();
        formInicial();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        formInicial();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void buscarUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarUsuarioKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarUsuarios();
            carregarResultadoConsultaUsuarios();
            formAtualizacao();
        }
    }//GEN-LAST:event_buscarUsuarioKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarUsuarios();
        carregarResultadoConsultaUsuarios();
        formAtualizacao();
    }//GEN-LAST:event_btnBuscarActionPerformed

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
        carregarFuncoesCargos();
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
    
    private void carregarFuncoesCargos(){
        List<FuncoesUsuario> listaFuncoes = permissaoDao.consultarFuncoesUsuario();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)funcaoCargo.getModel();
        modelo.removeAllElements();
        for(FuncoesUsuario funcoes : listaFuncoes){
            modelo.addElement(funcoes);
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
                }else{
                    JOptionPane.showMessageDialog(null, "Se senha precisa ser iguais e conter letras maísculo e números", "Erro", JOptionPane.WARNING_MESSAGE);
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
    
    /*private void abrirTelaAcesso(){
        AcessosUsuarios acessoUsuario = new AcessosUsuarios((Frame) SwingUtilities.getWindowAncestor(this), this.userSelec);
        acessoUsuario.setUsuarioSelecionado(this);
        acessoUsuario.setLocationRelativeTo(this);
        acessoUsuario.setVisible(true);
    }*/
    
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
    private javax.swing.JComboBox<String> funcaoCargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JFormattedTextField usuarioCelular;
    private javax.swing.JTextField usuarioCodigo;
    private javax.swing.JPasswordField usuarioConfirmSenha;
    private javax.swing.JTextField usuarioEmail;
    private javax.swing.JTextField usuarioLogin;
    private javax.swing.JTextField usuarioNome;
    private javax.swing.JPasswordField usuarioSenha;
    // End of variables declaration//GEN-END:variables
 
}
