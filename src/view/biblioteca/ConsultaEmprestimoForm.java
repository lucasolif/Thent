
package view.biblioteca;

import dao.BibliotecaDao;
import dao.EmprestimoLivroDao;
import dao.LivroDao;
import dao.PessoaDao;
import dao.RegistroBibliotecaDao;
import Ferramentas.PaletaCores;
import Ferramentas.PersonalizaTabela;
import Ferramentas.Utilitarios;
import interfaces.ConsultaPessoas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import model.Biblioteca;
import model.EmprestimoLivro;
import model.Livro;
import model.Pessoa;
import model.Usuario;
import view.carregamentoConsultas.TelaConsultasPessoas;


public class ConsultaEmprestimoForm extends javax.swing.JInternalFrame implements ConsultaPessoas{
    
    private final PersonalizaTabela personalizaTabela = new PersonalizaTabela();
    private final LivroDao livroDao = new LivroDao();
    private final PessoaDao pessoaDao = new PessoaDao();
    private final Biblioteca biblioteca = new Biblioteca();
    private final RegistroBibliotecaDao rgBibliotecaDao = new RegistroBibliotecaDao();
    private final BibliotecaDao bibliotecaDao = new BibliotecaDao();
    private final EmprestimoLivroDao empLivroDao = new EmprestimoLivroDao();
    private final Utilitarios conversor = new Utilitarios();
    private final PaletaCores paletaCores = new PaletaCores();
    private List<EmprestimoLivro> listaEmpLivros = new ArrayList<>();
    private List<Pessoa> listaPessoa = null;
    

    public ConsultaEmprestimoForm(Usuario usuarioLogado) {
        initComponents();
        formInicial();
        consultarTodosEmprestimos();
        atualizarTabela();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbGrupoData = new javax.swing.ButtonGroup();
        rbGrupoStatus = new javax.swing.ButtonGroup();
        codPessoa = new javax.swing.JTextField();
        nomePessoa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        livros = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbDataEmprestimo = new javax.swing.JRadioButton();
        rbDataDevolucao = new javax.swing.JRadioButton();
        txData = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rbEmprestado = new javax.swing.JRadioButton();
        rbDevolvido = new javax.swing.JRadioButton();
        rbTodos = new javax.swing.JRadioButton();
        rbPerdidos = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEmprestimos = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JButton();
        btnDevolver = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        bibliotecaJComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dataDevolucao = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        statusEmprestimo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Gerenciar Empréstimos de Livros");

        codPessoa.setEditable(false);
        codPessoa.setBackground(new java.awt.Color(204, 204, 204));
        codPessoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        codPessoa.setFocusable(false);

        nomePessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomePessoaKeyPressed(evt);
            }
        });

        jLabel1.setText("Pessoa");

        livros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                livrosMousePressed(evt);
            }
        });
        livros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                livrosKeyPressed(evt);
            }
        });

        jLabel2.setText("Livros");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtros Por Data De:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        rbGrupoData.add(rbDataEmprestimo);
        rbDataEmprestimo.setText("Empréstimo");
        rbDataEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataEmprestimoActionPerformed(evt);
            }
        });

        rbGrupoData.add(rbDataDevolucao);
        rbDataDevolucao.setText("Devolução");
        rbDataDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataDevolucaoActionPerformed(evt);
            }
        });

        txData.setText("Empréstimo");

        try {
            dataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            dataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("até");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbDataEmprestimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDataDevolucao)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDataEmprestimo)
                    .addComponent(rbDataDevolucao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataInicial)
                    .addComponent(dataFinal)
                    .addComponent(jLabel4)
                    .addComponent(txData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Status Empréstimo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        rbGrupoStatus.add(rbEmprestado);
        rbEmprestado.setText("Emprestados");

        rbGrupoStatus.add(rbDevolvido);
        rbDevolvido.setText("Devolvidos");

        rbGrupoStatus.add(rbTodos);
        rbTodos.setText("Todos");

        rbGrupoStatus.add(rbPerdidos);
        rbPerdidos.setText("Perdidos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rbEmprestado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rbDevolvido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbPerdidos, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbEmprestado)
                    .addComponent(rbDevolvido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTodos)
                    .addComponent(rbPerdidos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empréstimos/Devoluçoes de Livros", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Cod Emp", "Cod Livro", "Livro", "Pessoa", "Empréstimo", "Devolução", "Status", "Biblioteca"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaEmprestimos);
        if (tabelaEmprestimos.getColumnModel().getColumnCount() > 0) {
            tabelaEmprestimos.getColumnModel().getColumn(0).setResizable(false);
            tabelaEmprestimos.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabelaEmprestimos.getColumnModel().getColumn(1).setResizable(false);
            tabelaEmprestimos.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabelaEmprestimos.getColumnModel().getColumn(2).setResizable(false);
            tabelaEmprestimos.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabelaEmprestimos.getColumnModel().getColumn(3).setResizable(false);
            tabelaEmprestimos.getColumnModel().getColumn(3).setPreferredWidth(200);
            tabelaEmprestimos.getColumnModel().getColumn(4).setResizable(false);
            tabelaEmprestimos.getColumnModel().getColumn(4).setPreferredWidth(200);
            tabelaEmprestimos.getColumnModel().getColumn(5).setResizable(false);
            tabelaEmprestimos.getColumnModel().getColumn(5).setPreferredWidth(60);
            tabelaEmprestimos.getColumnModel().getColumn(6).setResizable(false);
            tabelaEmprestimos.getColumnModel().getColumn(6).setPreferredWidth(50);
            tabelaEmprestimos.getColumnModel().getColumn(7).setResizable(false);
            tabelaEmprestimos.getColumnModel().getColumn(8).setResizable(false);
            tabelaEmprestimos.getColumnModel().getColumn(8).setPreferredWidth(150);
        }

        btnFiltrar.setBackground(new java.awt.Color(255, 153, 0));
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnDevolver.setBackground(new java.awt.Color(51, 204, 0));
        btnDevolver.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDevolver.setText("Devolver");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        bibliotecaJComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bibliotecaJComboBoxMousePressed(evt);
            }
        });
        bibliotecaJComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bibliotecaJComboBoxKeyPressed(evt);
            }
        });

        jLabel3.setText("Dt Devolução");

        try {
            dataDevolucao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Biblioteca");

        btnBuscar.setBackground(new java.awt.Color(51, 153, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        statusEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cardápio-16.png"))); // NOI18N
        statusEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusEmprestimoActionPerformed(evt);
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(dataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(bibliotecaJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(livros, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)))
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusEmprestimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDevolver))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)
                            .addComponent(codPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bibliotecaJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(livros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDevolver)
                        .addComponent(btnFiltrar))
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusEmprestimo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbDataEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataEmprestimoActionPerformed
        this.txData.setText("Empréstimo:");
    }//GEN-LAST:event_rbDataEmprestimoActionPerformed

    private void rbDataDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataDevolucaoActionPerformed
        this.txData.setText("Devolução:");
    }//GEN-LAST:event_rbDataDevolucaoActionPerformed

    private void nomePessoaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomePessoaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscarPessoa();
            carregarResultadoConsultaPessoa();
        } 
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.codPessoa.setText("");
        } 
    }//GEN-LAST:event_nomePessoaKeyPressed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        consultarEmprestimos();
        atualizarTabela();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        formInicial();
        limparTabela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void livrosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_livrosKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.livros.removeAllItems();
        } 
    }//GEN-LAST:event_livrosKeyPressed

    private void livrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_livrosMousePressed
        carregarLivros();
    }//GEN-LAST:event_livrosMousePressed

    private void bibliotecaJComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bibliotecaJComboBoxKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.bibliotecaJComboBox.removeAllItems();
        } 
    }//GEN-LAST:event_bibliotecaJComboBoxKeyPressed

    private void bibliotecaJComboBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bibliotecaJComboBoxMousePressed
        carregarBibliotecas();
    }//GEN-LAST:event_bibliotecaJComboBoxMousePressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarPessoa();
        carregarResultadoConsultaPessoa();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        devolverEmprestimo();
        formInicial();
        consultarTodosEmprestimos();
        atualizarTabela();
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void statusEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusEmprestimoActionPerformed
        StatusCores statusCores = new StatusCores((Frame) SwingUtilities.getWindowAncestor(this), true);
        statusCores.setLocationRelativeTo(this);
        statusCores.setVisible(true);
    }//GEN-LAST:event_statusEmprestimoActionPerformed

    private void formInicial(){
        this.rbDataEmprestimo.setSelected(true);
        this.rbEmprestado.setSelected(true);
        this.btnDevolver.setEnabled(true);
        this.dataInicial.setText(conversor.dataAtualString());
        this.dataFinal.setText(conversor.dataAtualString());
        this.dataDevolucao.setText(conversor.dataAtualString());
        this.codPessoa.setText("");
        this.nomePessoa.setText("");
        this.livros.setSelectedItem("");
        this.txData.setText("Empréstimo:");
        this.bibliotecaJComboBox.setSelectedItem("");
        personalizaTabela.definirNegritoTituloColuna(tabelaEmprestimos);
        alinharConteudoTabela();
    }
    
    private void carregarLivros(){  
        List<Livro> listaLivro = this.livroDao.consultarLivros();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.livros.getModel();
        modelo.removeAllElements();
        for(Livro livro : listaLivro){
            modelo.addElement(livro);
        }
    }
    
    private void carregarBibliotecas(){  
        List<Biblioteca> listaBiblioteca = this.bibliotecaDao.consultarBibliotecaJComboBox();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.bibliotecaJComboBox.getModel();
        modelo.removeAllElements();
        for(Biblioteca bibli : listaBiblioteca){
            modelo.addElement(bibli);
        }
    }
    
    private void buscarPessoa(){
        String textoBusca = this.nomePessoa.getText(); // Texto digitado na busca        
        this.listaPessoa = this.pessoaDao.consultarPessoa(textoBusca); //Lista recebe a busca retornada do banco    
    } 
    
    private void carregarResultadoConsultaPessoa(){
        TelaConsultasPessoas resultConsultParticipante = new TelaConsultasPessoas((Frame) SwingUtilities.getWindowAncestor(this), this.listaPessoa);
        resultConsultParticipante.setPessoaSelecionada(this);
        resultConsultParticipante.setLocationRelativeTo(this);
        resultConsultParticipante.setVisible(true);
    }
    
    private void carregarPessoaEscolhido(Pessoa pessoa){
        this.codPessoa.setText(String.valueOf(pessoa.getCodigo()));
        this.nomePessoa.setText(pessoa.getNome());
    }
    
    private void consultarEmprestimos(){
        Pessoa pessoa = new Pessoa();
        EmprestimoLivro emprestimoLivro = new EmprestimoLivro();
        Date dataEmprestimoInicial = null;
        Date dataEmprestimoFinal = null;
        Date dataDevolucaoInicial = null;
        Date dataDevolucaoFinal = null;
        Integer codPessoa = null;
        String statusEmprestimo = null;
        String nomePessoa = this.nomePessoa.getText();
        Livro livro =  (Livro) this.livros.getSelectedItem();
        Biblioteca biblioteca = (Biblioteca) this.bibliotecaJComboBox.getSelectedItem();
        
        //Tratando o código da pessoa    
        try {
            codPessoa = Integer.valueOf(this.codPessoa.getText());
            pessoa.setCodigo(codPessoa);
            pessoa.setNome(nomePessoa);
        } catch (NumberFormatException e){

        }
        
        //Verificando quais radios button dos status foram selecionados
        if(this.rbEmprestado.isSelected()){
            statusEmprestimo = "E";
        }else if(this.rbDevolvido.isSelected()){
            statusEmprestimo = "D";
        }else if(this.rbPerdidos.isSelected()){
            statusEmprestimo = "P";
        }else{
            statusEmprestimo = null;
        }
        
        //Validando qual data foi selecionado, e convertendo a String para tipo data
        if(this.rbDataEmprestimo.isSelected()){
            dataEmprestimoInicial = this.conversor.convertendoStringDateSql(this.dataInicial.getText()); 
            dataEmprestimoFinal = this.conversor.convertendoStringDateSql(this.dataFinal.getText());

        }else if(this.rbDataDevolucao.isSelected()){
            dataDevolucaoInicial = conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataDevolucaoFinal = conversor.convertendoStringDateSql(this.dataFinal.getText());
        }       
        
        emprestimoLivro.setLivro(livro);
        emprestimoLivro.setPessoa(pessoa);
        emprestimoLivro.setStatusEmprestimo(statusEmprestimo);
        emprestimoLivro.setBiblioteca(biblioteca);
        
        this.listaEmpLivros = empLivroDao.consultarEmprestimosLivro(emprestimoLivro, dataEmprestimoInicial, dataEmprestimoFinal, dataDevolucaoInicial, dataDevolucaoFinal);       
    }
    
    private void atualizarTabela(){
        DefaultTableModel model = (DefaultTableModel) this.tabelaEmprestimos.getModel();
        model.setNumRows(0);

        for(EmprestimoLivro empLivro : this.listaEmpLivros){    
            String dataEmprestimo = this.conversor.convertendoDataStringSql((java.sql.Date) empLivro.getDataEmprestimo());
            String dataDevolucao = this.conversor.convertendoDataStringSql((java.sql.Date) empLivro.getDataDevolucao());
            for(Livro livro : empLivro.getListaLivro()){
                model.addRow(new Object[]{" ",empLivro.getCodigoEmprestimo(),livro.getCodLivro(),livro, empLivro.getPessoa(), dataEmprestimo, dataDevolucao, empLivro.getDescricaoStatus(), empLivro.getBiblioteca()});
            }        
        }
        
        statusEmprestimo();
    }
    
    private void limparTabela(){
        //Primeiro a condição testa se a quantidade de colunas é maior que 0, depois, limpa os dados
        if(this.tabelaEmprestimos.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) this.tabelaEmprestimos.getModel();
            model.setRowCount(0);
        }
    }
    
    private void devolverEmprestimo(){
     
        int empSelec[] = this.tabelaEmprestimos.getSelectedRows();
        List<EmprestimoLivro> listaEmpDevolvido = new ArrayList<>();
        
        //Verifica se foi selecionado algum registro da lista
        if(empSelec.length < 0){
            JOptionPane.showMessageDialog(null, "Selecione um empréstimo para ser devolvido", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            for(int index : empSelec){
                if(this.listaEmpLivros.get(index).getStatusEmprestimo().equalsIgnoreCase("e")){
                    EmprestimoLivro emprestimoLivro = new EmprestimoLivro();           
                    Pessoa pessoa = this.listaEmpLivros.get(index).getPessoa();
                    List<Livro> livro = this.listaEmpLivros.get(index).getListaLivro();
                    Integer codEmprestimo = this.listaEmpLivros.get(index).getCodigoEmprestimo();
                    Integer codInterno = this.listaEmpLivros.get(index).getCodigoInternoEmprestimo();
                    Biblioteca biblioteca = this.listaEmpLivros.get(index).getBiblioteca();
                    Date dataDevolucao = conversor.convertendoStringDateSql(this.dataDevolucao.getText());
                    String statusEmprestimo = "D";   
                    String descricaoStatus = "Devolvido";

                    emprestimoLivro.setPessoa(pessoa);
                    emprestimoLivro.setListaLivro(livro);
                    emprestimoLivro.setBiblioteca(biblioteca);
                    emprestimoLivro.setDataDevolucao(dataDevolucao);
                    emprestimoLivro.setStatusEmprestimo(statusEmprestimo);
                    emprestimoLivro.setCodigoInternoEmprestimo(codInterno);
                    emprestimoLivro.setDescricaoStatus(descricaoStatus);
                    emprestimoLivro.setCodigoEmprestimo(codEmprestimo);

                    //Lista de exclusão receber o dado da lista de contas a pagar no indice selecionado, uma vez que o indíce da tabela é o mesmo da lista
                    listaEmpDevolvido.add(emprestimoLivro);   
                }else{
                    JOptionPane.showMessageDialog(null, "O livro não está com status de emprestado", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            }
                       
            int confirm = JOptionPane.showConfirmDialog(null,"Confirmar devolução?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                this.empLivroDao.devolverLivroEmprestado(listaEmpDevolvido);
                this.listaEmpLivros.clear();
            }else if(confirm == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            }
        }

    }
    
    private void consultarTodosEmprestimos(){
        this.listaEmpLivros = this.empLivroDao.consultarEmprestimosStatusEmprestado();
    }
    
    private void statusEmprestimo(){
        // Definindo a cor conforme a data de vencimento
        this.tabelaEmprestimos.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                // Criar um JLabel para a célula
                JLabel label = new JLabel(value.toString()) {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g); // Chama o método para garantir a renderização padrão da célula

                        // Definir o tamanho do círculo (ajuste de acordo com o tamanho da célula)
                        int diameter = Math.min(getWidth(), getHeight()) - 4; // Aumente o valor (-5, 0 ou outro valor) para maior bolinha

                        // Determinar a cor do círculo com base no vencimento
                        Color corFundo = Color.GRAY; // Cor padrão
                        String status = (String) tabelaEmprestimos.getValueAt(row, 7);
                        
                        if(status.equalsIgnoreCase("emprestado")){
                            corFundo = paletaCores.getVerdeLimao(); 
                        }else if(status.equalsIgnoreCase("devolvido")){                             
                            corFundo = paletaCores.getAzul();    
                        }else if(status.equalsIgnoreCase("perdido")){
                            corFundo = paletaCores.getVermelho();  
                        }

                        // Definir a cor de preenchimento do círculo
                        g.setColor(corFundo);
                        
                        // Desenhar o círculo (elipse preenchida)
                        g.fillOval((getWidth() - diameter) / 2, (getHeight() - diameter) / 2, diameter, diameter); 
                    }
                };

                // Garantir que o JLabel não tenha borda ou fundo
                //label.setOpaque(false); // Deixar o fundo transparente para desenharmos o círculo
                label.setHorizontalAlignment(SwingConstants.CENTER); // Alinhar o texto ao centro (opcional)
                label.setVerticalAlignment(SwingConstants.CENTER); // Alinhar o texto ao centro (opcional)

                return label; // Retorna o JLabel modificado
            }
        });
    }
    
    private void alinharConteudoTabela(){
        
        // Alinhamento do Ofertante (à esquerda)
        DefaultTableCellRenderer segundaColuna = new DefaultTableCellRenderer();
        segundaColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaEmprestimos.getColumnModel().getColumn(1).setCellRenderer(segundaColuna);

        // Alinhamento do Valor (centro)
        DefaultTableCellRenderer terceiraColuna = new DefaultTableCellRenderer();
        terceiraColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaEmprestimos.getColumnModel().getColumn(2).setCellRenderer(terceiraColuna);

        //Alinhamento do tipo de oferta
        DefaultTableCellRenderer quartaColuna = new DefaultTableCellRenderer();
        quartaColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaEmprestimos.getColumnModel().getColumn(3).setCellRenderer(quartaColuna);
        
        //Alinhamento da igreja
        DefaultTableCellRenderer quintaColuna = new DefaultTableCellRenderer();
        quintaColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaEmprestimos.getColumnModel().getColumn(4).setCellRenderer(quintaColuna);
        
        //Alinhamento da data de oferta
        DefaultTableCellRenderer sextaColuna = new DefaultTableCellRenderer();
        sextaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaEmprestimos.getColumnModel().getColumn(5).setCellRenderer(sextaColuna);
        
        //Alinhamento da data de lançamento
        DefaultTableCellRenderer setimaColuna = new DefaultTableCellRenderer();
        setimaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaEmprestimos.getColumnModel().getColumn(6).setCellRenderer(setimaColuna);
        
        //Alinhamento da data de lançamento
        DefaultTableCellRenderer oitavaColuna = new DefaultTableCellRenderer();
        oitavaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaEmprestimos.getColumnModel().getColumn(7).setCellRenderer(oitavaColuna);
        
        //Alinhamento da data de lançamento
        DefaultTableCellRenderer nonaColuna = new DefaultTableCellRenderer();
        nonaColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaEmprestimos.getColumnModel().getColumn(8).setCellRenderer(nonaColuna);
    }
    
    
    @Override
    public void pessoaSelecionada(Pessoa pessoaSelecionada) {
        carregarPessoaEscolhido(pessoaSelecionada);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bibliotecaJComboBox;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JTextField codPessoa;
    private javax.swing.JFormattedTextField dataDevolucao;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> livros;
    private javax.swing.JTextField nomePessoa;
    private javax.swing.JRadioButton rbDataDevolucao;
    private javax.swing.JRadioButton rbDataEmprestimo;
    private javax.swing.JRadioButton rbDevolvido;
    private javax.swing.JRadioButton rbEmprestado;
    private javax.swing.ButtonGroup rbGrupoData;
    private javax.swing.ButtonGroup rbGrupoStatus;
    private javax.swing.JRadioButton rbPerdidos;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JButton statusEmprestimo;
    private javax.swing.JTable tabelaEmprestimos;
    private javax.swing.JLabel txData;
    // End of variables declaration//GEN-END:variables

}
