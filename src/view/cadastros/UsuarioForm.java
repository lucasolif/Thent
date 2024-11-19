
package view.cadastros;

import java.util.Base64;
import dao.IgrejaDao;
import model.Usuario;
import dao.UsuarioDao;
import ferramentas.CriptografarSenhas;
import ferramentas.PaletaCores;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Igreja;
public class UsuarioForm extends javax.swing.JInternalFrame {

    private final UsuarioDao usuarioDao = new UsuarioDao();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final PaletaCores cores = new PaletaCores();
    private Usuario userSelec;
    private List<Usuario> listaUser;
      
    public UsuarioForm() {
        initComponents();
        carregarIgrejas();
        cbAtivo.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuarios = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        usuarioNome = new javax.swing.JTextField();
        usuarioEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        usuarioLogin = new javax.swing.JTextField();
        usuarioSenha = new javax.swing.JPasswordField();
        usuarioConfirmSenha = new javax.swing.JPasswordField();
        usuarioCelular = new javax.swing.JFormattedTextField();
        campoIgreja = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        usuarioCodigo = new javax.swing.JTextField();
        cbAtivo = new javax.swing.JCheckBox();
        btnBuscar = new javax.swing.JButton();
        buscarUsuario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Usuários");
        setPreferredSize(new java.awt.Dimension(585, 605));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Usuários", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaUsuarios);
        if (tabelaUsuarios.getColumnModel().getColumnCount() > 0) {
            tabelaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(250);
            tabelaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(160);
        }

        btnSalvar.setBackground(new java.awt.Color(0, 255, 0));
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

        btnAlterar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-editar-16.png"))); // NOI18N
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cadastro", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setText("Usuário*");

        jLabel2.setText("Senha*");

        jLabel3.setText("Confirmar Senha*");

        jLabel4.setText("Nome*");

        jLabel6.setText("E-mail*");

        jLabel7.setText("Celular*");

        try {
            usuarioCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        campoIgreja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Campo/Igreja" }));

        jLabel8.setText("Campo/Igreja");

        jLabel5.setText("Código");

        usuarioCodigo.setEditable(false);
        usuarioCodigo.setBackground(new java.awt.Color(204, 204, 204));
        usuarioCodigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        usuarioCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cbAtivo.setSelected(true);
        cbAtivo.setText("Ativo?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(usuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarioEmail))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(usuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarioConfirmSenha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbAtivo))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(9, 9, 9)
                        .addComponent(usuarioCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoIgreja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usuarioCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarioNome)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(usuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(usuarioCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(usuarioCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(usuarioEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(usuarioConfirmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAtivo))
                .addGap(13, 13, 13))
        );

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        buscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarUsuarioKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(buscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAlterar))
                    .addComponent(btnLimpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvarAlterarCadastro();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirUsuario();
        consultarUsuarios();
        atualizarTabela();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterarUsuario();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarUsuarios();
        atualizarTabela();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void buscarUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarUsuarioKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarUsuarios();
            atualizarTabela();
        }
    }//GEN-LAST:event_buscarUsuarioKeyPressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        userSelec = null;
        limparCampos();
        limparTabela();       
    }//GEN-LAST:event_btnLimparActionPerformed

    private void consultarUsuarios(){
        String textoBusca = buscarUsuario.getText();
        listaUser = usuarioDao.consultar(textoBusca);
    }
    
    private void atualizarTabela(){
        DefaultTableModel model = (DefaultTableModel) tabelaUsuarios.getModel();
        model.setNumRows(0);

        for(Usuario user: listaUser){
            model.addRow(new Object[]{user.getCodigo(), user.getNome(), user.getLogin()});
        }
    }

    private void limparTabela(){
        //Primeiro a condição testa se a quantidade de colunas é maior que 0, depois, limpa os dados
        if(tabelaUsuarios.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) tabelaUsuarios.getModel();
            model.setRowCount(0);
        }
    }

    private void verificandoCamposVazio(String nome, String celular, String email, String login, String senha){
        if(nome.isEmpty() || celular.isEmpty() || email.isEmpty() || login.isEmpty() || senha.isEmpty()){        
            JOptionPane.showMessageDialog(null, "Campos vazios. Preencha todos os campos obrigatórios", "Erro", JOptionPane.WARNING_MESSAGE);
            return;
        }   
    }
    
    private void limparCampos(){
        
        usuarioCodigo.setText("");
        buscarUsuario.setText("");
        usuarioNome.setText("");
        usuarioCelular.setText("");
        usuarioEmail.setText("");
        usuarioLogin.setText("");
        usuarioSenha.setText("");
        usuarioConfirmSenha.setText("");
        carregarIgrejas();
        
    }
     
    private void carregarIgrejas(){
        List<Igreja> listaIgrejas = igrejaDao.consultarTodasIgrejas();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)campoIgreja.getModel();
        modelo.removeAllElements();
        for(Igreja igreja : listaIgrejas){
            modelo.addElement(igreja);
        }
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
    
    private void salvarAlterarCadastro(){
           
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
        
        //Valida se há algum campo vazio
        verificandoCamposVazio(nome, celular, email, login, senha);
        
        //Adicionando o usuário no banco de dados
        if(userSelec == null){
            if(validarIgualdadeSenha(senha, confirmSenha) == true && validarForcaSenha(senha) == true){
                
                try{
                    byte[] salt = CriptografarSenhas.gerarSalt();
                    rashSenha = CriptografarSenhas.gerarHash(senha,salt);
                    saltSenha = Base64.getEncoder().encodeToString(salt);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar criptografar a senha", "Erro",JOptionPane.WARNING_MESSAGE);
                }

                Usuario usuario = new Usuario();
                usuario.setLogin(login);
                usuario.setNome(nome);
                usuario.setEmail(email);
                usuario.setCelular(celular);
                usuario.setAtivo(status);
                usuario.setIgreja(igreja);
                usuario.setSaltSenha(saltSenha);
                usuario.setHashSenha(rashSenha);
                
                usuarioDao.adicionar(usuario);
                limparCampos();
            }
        }else{
            if(validarIgualdadeSenha(senha, confirmSenha) == true && validarForcaSenha(senha) == true){
                //Setando os valores que estão no campo
                userSelec.setNome(nome);
                userSelec.setCelular(celular);
                userSelec.setEmail(email);
                userSelec.setIgreja(igreja);
                userSelec.setAtivo(status);

                usuarioDao.alterar(userSelec);
                limparCampos();
            }
        }
        
        limparTabela();
        userSelec = null;
    }
    
    private void excluirUsuario(){
        //Variavel recebe a quantidade delinhas da tabela de usuario
        int linhaTabelaUsuario = tabelaUsuarios.getSelectedRow();
        
        //Verifica se alguman linha foi selecionada na tabela, ou seja,o usuario
        if(linhaTabelaUsuario < 0){
            JOptionPane.showMessageDialog(null,"Selecione um usuário a ser excluído","Atenção",JOptionPane.WARNING_MESSAGE);
        }else{
            //Recebe a linha que foi selecionada na tabela.
            userSelec = listaUser.get(linhaTabelaUsuario);      

            int confirm = JOptionPane.showConfirmDialog(null,"Excluir o usuário "+userSelec.getLogin()+" ?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                usuarioDao.remover(userSelec.getCodigo());
                consultarUsuarios();
                limparCampos();
            }else if(confirm == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            }
        }
    }
    
    private void alterarUsuario(){
        
        //Criando variável que receberá o usuário selecionado na tabela
        int numLinhaSelec = this.tabelaUsuarios.getSelectedRow();
        this.cbAtivo.setEnabled(true);
        
        
        //Verificando se foi selecionado algum usuario
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null,"Selecione um usuário", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
               
        this.userSelec = this.listaUser.get(numLinhaSelec);
        
        this.usuarioCodigo.setText(Integer.toString(this.userSelec.getCodigo()));
        this.usuarioNome.setText(this.userSelec.getNome());
        this.usuarioEmail.setText(this.userSelec.getEmail());
        this.usuarioCelular.setText(this.userSelec.getCelular());
        this.usuarioLogin.setText(this.userSelec.getLogin());
        this.usuarioSenha.setText(this.userSelec.getHashSenha());
        this.usuarioConfirmSenha.setText(this.userSelec.getHashSenha());
        this.campoIgreja.setSelectedItem(this.userSelec.getIgreja());
        if(this.userSelec.getAtivo() == 1){
            cbAtivo.setSelected(true);
        }else{
            cbAtivo.setSelected(false);
        }
        
        this.usuarioLogin.setEditable(false);
        this.usuarioLogin.setBackground(cores.cinza());
        this.usuarioSenha.setBackground(cores.cinza());
        this.usuarioConfirmSenha.setBackground(cores.cinza());
        this.usuarioSenha.setEditable(false);
        this.usuarioConfirmSenha.setEditable(false);
    }
        
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaUsuarios;
    private javax.swing.JFormattedTextField usuarioCelular;
    private javax.swing.JTextField usuarioCodigo;
    private javax.swing.JPasswordField usuarioConfirmSenha;
    private javax.swing.JTextField usuarioEmail;
    private javax.swing.JTextField usuarioLogin;
    private javax.swing.JTextField usuarioNome;
    private javax.swing.JPasswordField usuarioSenha;
    // End of variables declaration//GEN-END:variables
 
}
