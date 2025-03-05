
package view.cadastros;

import java.util.Base64;
import dao.IgrejaDao;
import dao.UsuarioDao;
import autenticacao.CriptografarSenhas;
import Ferramentas.PaletaCores;
import dao.PermissoesDao;
import interfaces.ConsultaIgrejas;
import interfaces.ConsultaUsuarios;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import model.AcessosIgreja;
import model.FuncoesUsuario;
import model.Igreja;
import model.Usuario;
import view.carregamentoConsultas.TelaConsultaIgreja;
import view.carregamentoConsultas.TelaConsultaUsuarios;

public class UsuarioForm extends javax.swing.JInternalFrame implements ConsultaUsuarios, ConsultaIgrejas{

    private final PermissoesDao permissaoDao = new PermissoesDao();
    private Igreja igrejaSelec = null;
    private final UsuarioDao usuarioDao = new UsuarioDao();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final PaletaCores cores = new PaletaCores();
    private Usuario userSelec;
    private List<Usuario> listaUser;
    private List<Igreja> listaIgrejasJComboBox;
    private List<Igreja> listaIgrejaConsulta;
    private List<AcessosIgreja> listaAcessosAtual; 
    private String filtroIgreja = "";
      
    public UsuarioForm(Usuario usuarioLogado) {
        initComponents();
        formInicial();
        this.filtroIgreja = usuarioDao.gerarFiltroIgreja(usuarioLogado);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        buscarUsuario = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listagemIgrejaAcesso = new javax.swing.JList<>();
        codIgreja = new javax.swing.JTextField();
        nomeIgreja = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cbAtivo = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        funcaoCargo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        usuarioLogin = new javax.swing.JTextField();
        usuarioSenha = new javax.swing.JPasswordField();
        usuarioConfirmSenha = new javax.swing.JPasswordField();
        usuarioNome = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        usuarioCodigo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        usuarioCelular = new javax.swing.JFormattedTextField();
        usuarioEmail = new javax.swing.JTextField();
        campoIgreja = new javax.swing.JComboBox<>();
        btnLimpar = new javax.swing.JButton();
        adicionarTodasIgreja = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Usuários");
        setPreferredSize(new java.awt.Dimension(745, 375));

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

        jScrollPane2.setViewportView(listagemIgrejaAcesso);

        codIgreja.setEditable(false);
        codIgreja.setBackground(new java.awt.Color(204, 204, 204));
        codIgreja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        nomeIgreja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeIgrejaKeyPressed(evt);
            }
        });

        jLabel2.setText("Igrejas Acesso");

        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adicionar.png"))); // NOI18N
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados Usuário", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        cbAtivo.setSelected(true);
        cbAtivo.setText("Ativo?");

        jLabel17.setText("Usuário*");

        jLabel18.setText("E-mail*");

        jLabel1.setText("Função/Cargo*");

        jLabel9.setText("Campo/Igreja*");

        jLabel10.setText("Celular*");

        jLabel12.setText("Senha*");

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

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(usuarioEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpar)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(funcaoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(campoIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(usuarioCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(usuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usuarioConfirmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usuarioCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(usuarioConfirmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbAtivo))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(funcaoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarioCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usuarioEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        adicionarTodasIgreja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        adicionarTodasIgreja.setText("Adicionar Todas Igrejas");
        adicionarTodasIgreja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adicionarTodasIgreja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                adicionarTodasIgrejaMousePressed(evt);
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
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adicionarTodasIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(codIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nomeIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(btnBuscar)
                            .addComponent(buscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdicionar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalvar)
                            .addComponent(btnExcluir)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(adicionarTodasIgreja)))
                .addContainerGap(32, Short.MAX_VALUE))
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
        excluirAcessoListagem();
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

    private void nomeIgrejaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeIgrejaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarIgreja();
            carregarResultadoConsultaIgreja();
        }else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.nomeIgreja.setText("");
            this.codIgreja.setText("");
        }
    }//GEN-LAST:event_nomeIgrejaKeyPressed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        criarListagemIgrejasLiberadas();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void adicionarTodasIgrejaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adicionarTodasIgrejaMousePressed
        carregarTodosAcessosIgreja();
    }//GEN-LAST:event_adicionarTodasIgrejaMousePressed

    private void formAtualizacao(){ 
        this.usuarioLogin.setFocusable(false);
        this.usuarioLogin.setEditable(false);
        this.usuarioLogin.setBackground(cores.getCinza());
        this.usuarioSenha.setBackground(cores.getCinza());
        this.usuarioConfirmSenha.setBackground(cores.getCinza());
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
        this.usuarioLogin.setBackground(cores.getBranco());
        this.usuarioSenha.setBackground(cores.getBranco());
        this.usuarioConfirmSenha.setBackground(cores.getBranco());
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
        this.listagemIgrejaAcesso.removeAll();
    }
    
    private void consultarUsuarios(){
        String textoBusca = this.buscarUsuario.getText();
        this.listaUser = this.usuarioDao.consultarUsuario(textoBusca);
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
        this.funcaoCargo.setSelectedItem(usuario.getFuncaoCargo());
        
        if(usuario.getAtivo() == 1){
            cbAtivo.setSelected(true);
        }else{
            cbAtivo.setSelected(false);
        }
        
        this.userSelec = usuario;
        carregarAcessosIgrejaUsuario(); //Carrega os acesso dos dados da igreja.
    }
    
    private void consultarIgreja(){        
        listaIgrejaConsulta = igrejaDao.consultarTodasIgrejasSemFiltro(); //Lista recebe a busca retornada do banco
    }
    
    private void carregarResultadoConsultaIgreja(){
        TelaConsultaIgreja resultConsultaContaCaixa = new TelaConsultaIgreja((Frame) SwingUtilities.getWindowAncestor(this), this.listaIgrejaConsulta);
        resultConsultaContaCaixa.setIgrejaSelecionada(this);
        resultConsultaContaCaixa.setLocationRelativeTo(this);
        resultConsultaContaCaixa.setVisible(true);
    }
    
    private void carregarIgrejaEscolhida(Igreja igreja){
        this.codIgreja.setText(String.valueOf(igreja.getCodigo()));
        this.nomeIgreja.setText(igreja.getNome());
    }
    
    private void carregarIgrejas(){
        this.listaIgrejasJComboBox = igrejaDao.consultarTodasIgrejasSemFiltro();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)campoIgreja.getModel();
        modelo.removeAllElements();
        for(Igreja igreja : listaIgrejasJComboBox){
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
    
    private void carregarAcessosIgrejaUsuario(){
        DefaultListModel<String> modelo = new DefaultListModel<>();       
        this.listagemIgrejaAcesso.setModel(modelo);// Acesse o modelo do JList
        
        this.listaAcessosAtual = this.usuarioDao.consultarAcessoIgreja(this.userSelec);
        
        // Adicione os elementos ao modelo
        for (AcessosIgreja acesso : this.listaAcessosAtual) {
            modelo.addElement(acesso.getIgreja().getCodigo()+"-"+acesso.getIgreja().getNome()); // Adiciona o valor do tipo String ao JList
        }
    }
    
    private void carregarTodosAcessosIgreja(){
        DefaultListModel<String> modelo = new DefaultListModel<>();       
        this.listagemIgrejaAcesso.setModel(modelo);// Acesse o modelo do JList
        
        List<Igreja> listaIgreja = igrejaDao.consultarTodasIgrejasSemFiltro();
        
        // Adicione os elementos ao modelo
        for (Igreja igreja : listaIgreja) {
            modelo.addElement(igreja.getCodigo()+"-"+igreja.getNome()); // Adiciona o valor do tipo String ao JList
        }
    }
    
    private void excluirAcessoListagem(){
        
        // Verifica se algum item foi selecionado
        int indiceSelecionado = listagemIgrejaAcesso.getSelectedIndex(); // Obtém o índice do item selecionado

        if (indiceSelecionado >= 0) { // Se um item foi selecionado
            // Remove o item do DefaultListModel
            DefaultListModel<String> modelo = (DefaultListModel<String>) listagemIgrejaAcesso.getModel();
            modelo.remove(indiceSelecionado); // Remove o item na posição do índice selecionado
        } else {
            // Caso não haja nenhum item selecionado
            JOptionPane.showMessageDialog(null, "Selecione um igreja de acesso, para ser excluída", "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void salvarAlterarCadastro() throws Exception{
           
        Integer status = 0;
        Integer todasIgrejas = 0;
        String rashSenha = null;
        String saltSenha = null;
        String nome = usuarioNome.getText();
        String celular = usuarioCelular.getText();
        String email = usuarioEmail.getText();
        Igreja igreja = (Igreja) this.campoIgreja.getSelectedItem();
        String login = usuarioLogin.getText();
        String senha = usuarioSenha.getText();
        String confirmSenha = usuarioConfirmSenha.getText();
        FuncoesUsuario funcaoCargo = (FuncoesUsuario) this.funcaoCargo.getSelectedItem();      
        
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
                    usuario.setFuncaoCargo(funcaoCargo);
                    usuario.setTodasIgrejas(todasIgrejas);
                    
                    int idUsuario = this.usuarioDao.adicionarUsuario(usuario);   //Adiciona o usuário é retorna o código gerado                   
                    usuario.setCodigo(idUsuario);//Seta o código gerado
                    this.usuarioDao.alterarUsuario(usuario); // Adicionar as permissões
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Se senha precisa ser iguais e conter letras maísculo e números", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            }else{
                FuncoesUsuario funcao = (FuncoesUsuario) this.funcaoCargo.getSelectedItem();
                this.userSelec.setNome(nome);
                this.userSelec.setCelular(celular);
                this.userSelec.setEmail(email);
                this.userSelec.setIgreja(igreja);
                this.userSelec.setAtivo(status);
                this.userSelec.setFuncaoCargo(funcao);
                this.userSelec.setTodasIgrejas(todasIgrejas);
                
                this.usuarioDao.alterarUsuario(this.userSelec);  
                adicionarExcluirAcessoIgreja(this.userSelec);
            }
        } 
    }
    
    private void adicionarExcluirAcessoIgreja(Usuario usuario){
        ListModel<String> modelo = listagemIgrejaAcesso.getModel();// Acesse o modelo do JList
        
        List<AcessosIgreja> listaAcessosNovos = new ArrayList<>();

        for (int i = 0; i < modelo.getSize(); i++) {       
            
            //Pegando o código da igreja que está em uma string junto com o nome da igreja
            String igrejaSelec = modelo.getElementAt(i);
            int posicaoCod = igrejaSelec.indexOf("-"); //Pega a posição do traço, pois ele divide o código da igreja e nome
            
            int codIgreja = Integer.parseInt(igrejaSelec.substring(0,posicaoCod));
            
            AcessosIgreja acessosIgreja = new AcessosIgreja();
            Igreja igreja = new Igreja();       
            igreja.setCodigo(codIgreja);
            acessosIgreja.setIgreja(igreja);
            acessosIgreja.setUsuario(usuario);
            
            listaAcessosNovos.add(acessosIgreja);
            
        }
        
        if(!listaAcessosAtual.isEmpty() && !listaAcessosNovos.isEmpty()){
            usuarioDao.excluirAcessoIgreja(this.listaAcessosAtual);
            usuarioDao.adicionarAcessoIgreja(listaAcessosNovos);
        }else if(listaAcessosNovos.isEmpty() && !listaAcessosAtual.isEmpty()){
            usuarioDao.excluirAcessoIgreja(this.listaAcessosAtual);
        }else if(listaAcessosAtual.isEmpty() && !listaAcessosNovos.isEmpty()){
            usuarioDao.adicionarAcessoIgreja(listaAcessosNovos);
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
    
    private void criarListagemIgrejasLiberadas(){
        
        if (!this.codIgreja.getText().isEmpty()) {
        // Verifica se o modelo é uma instância de DefaultListModel
        DefaultListModel<String> igrejasLiberada;

        // Verifica se o modelo atual é do tipo DefaultListModel
        if (this.listagemIgrejaAcesso.getModel() instanceof DefaultListModel) {
            igrejasLiberada = (DefaultListModel<String>) this.listagemIgrejaAcesso.getModel();
        } else {
            // Se o modelo não for um DefaultListModel ou for null, cria um novo
            igrejasLiberada = new DefaultListModel<>();
            this.listagemIgrejaAcesso.setModel(igrejasLiberada);  // Atribui o modelo ao JList
        }

        // Adiciona a igreja no modelo
        String codIgreja = this.codIgreja.getText();
        String nomeIgreja = this.nomeIgreja.getText();
        String igreja = codIgreja + "-" + nomeIgreja; 
        igrejasLiberada.addElement(igreja);  // Adiciona ao modelo do JList

        // Limpa os campos de texto
        this.codIgreja.setText("");
        this.nomeIgreja.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Informe a igreja para ser adicionada na liberação", "Erro", JOptionPane.WARNING_MESSAGE);
        }

    }
    
    @Override
    public void igrejaSelecionada(Igreja igrejaSelecionada) {
        carregarIgrejaEscolhida(igrejaSelecionada);    
    }
    
    @Override
    public void usuarioSelecionado(Usuario usuarioEscolhido) {
        carregarUsuarioEscolhido(usuarioEscolhido);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adicionarTodasIgreja;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField buscarUsuario;
    private javax.swing.JComboBox<String> campoIgreja;
    private javax.swing.JCheckBox cbAtivo;
    private javax.swing.JTextField codIgreja;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listagemIgrejaAcesso;
    private javax.swing.JTextField nomeIgreja;
    private javax.swing.JFormattedTextField usuarioCelular;
    private javax.swing.JTextField usuarioCodigo;
    private javax.swing.JPasswordField usuarioConfirmSenha;
    private javax.swing.JTextField usuarioEmail;
    private javax.swing.JTextField usuarioLogin;
    private javax.swing.JTextField usuarioNome;
    private javax.swing.JPasswordField usuarioSenha;
    // End of variables declaration//GEN-END:variables
 
}
