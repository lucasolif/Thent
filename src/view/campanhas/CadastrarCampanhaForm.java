
package view.campanhas;

import dao.CampanhaDao;
import dao.IgrejaDao;
import dao.PessoaDao;
import dao.SubContaResultadoDao;
import dao.TipoCampanhaDao;
import ferramentas.Utilitarios;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Campanha;
import model.Igreja;
import model.ContasReceberCampanha;
import model.Pessoa;
import model.SubContaResultado;
import model.TipoCampanha;
import view.carregamentoConsultas.ResultadosConsultasPessoas;

public class CadastrarCampanhaForm extends javax.swing.JInternalFrame{

    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final PessoaDao pessoaDao = new PessoaDao();
    private final CampanhaDao campanhaDao = new CampanhaDao();
    private final TipoCampanhaDao tpCampanhaDao = new TipoCampanhaDao();
    private final SubContaResultadoDao subContResultDao = new SubContaResultadoDao();
    private List<Campanha> listaCampanhas = new ArrayList();
    private List<Pessoa> listaParticipantes = new ArrayList();
    private Utilitarios conversor = new Utilitarios();
    private Campanha campanhaSelec = null;
    private Pessoa participanteSelec = null;
    
    public CadastrarCampanhaForm() {
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

        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        dataFimCampanha = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        dataInicioCampanha = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        descricaoCampanha = new javax.swing.JTextField();
        observacaoCampanha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        igrejaCampanha = new javax.swing.JComboBox<>();
        valorTotalCampanha = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        duracaoCampanha = new javax.swing.JSpinner();
        statusCampanha = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        codCampanha = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tipoCampanha = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nomeParticipante = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        diaPagamento = new javax.swing.JSpinner();
        cbContaReceber = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        contaResultado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaParticipantes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        consultarCampanha = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Campanha");

        btnSalvar.setBackground(new java.awt.Color(0, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Campanha", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        dataFimCampanha.setEditable(false);
        dataFimCampanha.setBackground(new java.awt.Color(204, 204, 204));
        try {
            dataFimCampanha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Data Inicio*");

        try {
            dataInicioCampanha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataInicioCampanha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dataInicioCampanhaKeyPressed(evt);
            }
        });

        jLabel7.setText("Data Final");

        jLabel3.setText("Descrição da Campanha*");

        jLabel8.setText("Observação");

        valorTotalCampanha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel4.setText("Igreja*");

        jLabel9.setText("Valor Total*");

        duracaoCampanha.setModel(new javax.swing.SpinnerNumberModel(12, null, null, 1));
        duracaoCampanha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                duracaoCampanhaMouseClicked(evt);
            }
        });
        duracaoCampanha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                duracaoCampanhaKeyPressed(evt);
            }
        });

        statusCampanha.setSelected(true);
        statusCampanha.setText("Ativo");
        statusCampanha.setEnabled(false);

        jLabel5.setText("Duração (Mês)");

        jLabel10.setText("Status*");

        jLabel11.setText("Dia Pagt*");

        codCampanha.setEditable(false);
        codCampanha.setBackground(new java.awt.Color(204, 204, 204));
        codCampanha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel13.setText("Código");

        jLabel2.setText("Tipo de Campanha*");

        jLabel12.setText("Participante");

        nomeParticipante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeParticipanteKeyPressed(evt);
            }
        });

        btnAdicionar.setBackground(new java.awt.Color(51, 153, 255));
        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        diaPagamento.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        cbContaReceber.setText("Conta Receber");

        jLabel14.setText("Gerar");

        jLabel15.setText("Conta Resultado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(igrejaCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(134, 134, 134)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(valorTotalCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(diaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(statusCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cbContaReceber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(contaResultado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(codCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(descricaoCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(tipoCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(duracaoCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dataInicioCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dataFimCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(observacaoCampanha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nomeParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdicionar)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(duracaoCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel2))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(descricaoCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(codCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tipoCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dataInicioCampanha)
                                    .addComponent(dataFimCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(igrejaCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(valorTotalCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(diaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(statusCampanha)
                                    .addComponent(cbContaReceber)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nomeParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdicionar))
                    .addComponent(observacaoCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Participantes da Campanha", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaParticipantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Participante", "CPF/CNPJ", "Igreja"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaParticipantes);
        if (tabelaParticipantes.getColumnModel().getColumnCount() > 0) {
            tabelaParticipantes.getColumnModel().getColumn(0).setResizable(false);
            tabelaParticipantes.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaParticipantes.getColumnModel().getColumn(1).setResizable(false);
            tabelaParticipantes.getColumnModel().getColumn(1).setPreferredWidth(400);
            tabelaParticipantes.getColumnModel().getColumn(2).setResizable(false);
            tabelaParticipantes.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabelaParticipantes.getColumnModel().getColumn(3).setResizable(false);
            tabelaParticipantes.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        jLabel1.setText("Consultar Campanha");

        consultarCampanha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                consultarCampanhaKeyPressed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(255, 102, 0));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvar)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(consultarCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consultarCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        cadastrarAlterarCampanha();
        gerarContasReceberCampanha();
        formInicial();
        limparTabela();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void consultarCampanhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_consultarCampanhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
            consultarCampanhas();
            carregarResultadoConsultaCampanha();
            carregarCampanhaEscolhida();
            formAlteracao();
        }
    }//GEN-LAST:event_consultarCampanhaKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarCampanhas();
        carregarResultadoConsultaCampanha();
        carregarCampanhaEscolhida();
        formAlteracao();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        consultarParticipante();
        carregarResultadoConsultaParticipante();
        this.nomeParticipante.setText("");
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void nomeParticipanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeParticipanteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
            consultarParticipante();
            carregarResultadoConsultaParticipante();
            this.nomeParticipante.setText("");
        }
    }//GEN-LAST:event_nomeParticipanteKeyPressed

    private void dataInicioCampanhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataInicioCampanhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
            String dataInicio = this.dataInicioCampanha.getText();
            Integer duracao = (Integer)this.duracaoCampanha.getValue();
            String dataFinal = this.conversor.calcularData(dataInicio, duracao);    
            this.dataFimCampanha.setText(dataFinal);
        }
    }//GEN-LAST:event_dataInicioCampanhaKeyPressed

    private void duracaoCampanhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_duracaoCampanhaMouseClicked
        String dataInicio = this.dataInicioCampanha.getText();
        Integer duracao = (Integer)this.duracaoCampanha.getValue();
        String dataFinal = this.conversor.calcularData(dataInicio, duracao);
        this.dataFimCampanha.setText(dataFinal);
    }//GEN-LAST:event_duracaoCampanhaMouseClicked

    private void duracaoCampanhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duracaoCampanhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){  
            String dataInicio = this.dataInicioCampanha.getText();
            Integer duracao = (Integer)this.duracaoCampanha.getValue();
            String dataFinal = this.conversor.calcularData(dataInicio, duracao);
            
            this.dataFimCampanha.setText(dataFinal);
        }
    }//GEN-LAST:event_duracaoCampanhaKeyPressed

    private void carregarIgrejas(){
        List<Igreja> listaIgrejas = igrejaDao.consultarTodasIgrejas();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.igrejaCampanha.getModel();
        modelo.removeAllElements();
        for(Igreja igreja : listaIgrejas){
            modelo.addElement(igreja);
        }
    }
    
    private void carregarSubContaResultado(){
        List<SubContaResultado> listaSubContResult = this.subContResultDao.consultarSubContaResultado();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.contaResultado.getModel();
        modelo.removeAllElements();
        for(SubContaResultado subCont : listaSubContResult){
            modelo.addElement(subCont);
        }
    }
    
    private void carregarTipoCampanha(){
        List<TipoCampanha> listaTipoCampanha = this.tpCampanhaDao.consultarTiposCampanha();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.tipoCampanha.getModel();
        modelo.removeAllElements();
        for(TipoCampanha tpCampanha : listaTipoCampanha){
            modelo.addElement(tpCampanha);
        }
    }
    
    private void cadastrarAlterarCampanha(){       
        String descricaoCampanha = this.descricaoCampanha.getText();
        TipoCampanha tipoCampanha = (TipoCampanha) this.tipoCampanha.getSelectedItem();
        Integer duracaoCampanha = (Integer) this.duracaoCampanha.getValue();
        Date dataInicioCampanha = conversor.convertendoStringDateSql(this.dataInicioCampanha.getText());
        Date dataFimCampanha = conversor.convertendoStringDateSql(this.dataFimCampanha.getText());
        Integer diaPagtCampanha = (Integer) this.diaPagamento.getValue();
        Igreja igreja = (Igreja) this.igrejaCampanha.getSelectedItem();
        double valorTotal = Double.parseDouble(this.valorTotalCampanha.getText());
        String observacao = this.observacaoCampanha.getText();   
        Integer statusCampanha = 1;
        
        if(this.campanhaSelec == null){
            if(this.descricaoCampanha.getText().isEmpty() || this.valorTotalCampanha.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe os campos obrigatórios para cadastrar a campanha", "Atenção", JOptionPane.WARNING_MESSAGE);
            }else{
                boolean geraContasReceber = false;
                List<Pessoa> participantes = cadastrarParticipantes();
                Campanha campanha = new Campanha();
                campanha.setDescricaoCampanha(descricaoCampanha);
                campanha.setTipoCampanha(tipoCampanha);
                campanha.setDuracaoMeses(duracaoCampanha);
                campanha.setDataInicial(dataInicioCampanha);
                campanha.setDataFinal(dataFimCampanha);
                campanha.setDiaPagamento(diaPagtCampanha);
                campanha.setIgreja(igreja);
                campanha.setValorTotalCampanha(valorTotal);
                campanha.setObservacao(observacao);
                campanha.setStatusCampanha(statusCampanha);
                campanha.setParticipante(participantes);
                if(this.cbContaReceber.isSelected()){
                    List<ContasReceberCampanha> listaCrCampanhas = gerarContasReceberCampanha();
                    campanha.setListaCrCampanha(listaCrCampanhas);
                    geraContasReceber = true;
                }              
               this.campanhaDao.cadastrarCampanha(campanha, geraContasReceber);
            }
        }else{
            if(!this.statusCampanha.isSelected()){statusCampanha = 0;}
            this.campanhaSelec.setCodigo(Integer.valueOf(this.codCampanha.getText()));
            this.campanhaSelec.setDescricaoCampanha(descricaoCampanha);
            this.campanhaSelec.setDuracaoMeses(duracaoCampanha);
            this.campanhaSelec.setDataFinal(dataFimCampanha);
            this.campanhaSelec.setDiaPagamento(diaPagtCampanha);
            this.campanhaSelec.setValorTotalCampanha(valorTotal);
            this.campanhaSelec.setObservacao(observacao);
            this.campanhaSelec.setStatusCampanha(statusCampanha);
        }
    }
    
    private List<Pessoa> cadastrarParticipantes(){
        List<Pessoa> listaParticipantes = new ArrayList<>();
        int qtdParticipantes = this.tabelaParticipantes.getRowCount();
        
        if(qtdParticipantes > 0){
            for(int i = 0;i < qtdParticipantes; i++){
                Pessoa pessoa = (Pessoa)this.tabelaParticipantes.getModel().getValueAt(i, 1);
                listaParticipantes.add(pessoa);
            }     
        }

        return listaParticipantes;
    }
 
    private void formInicial(){
        carregarIgrejas();
        carregarTipoCampanha();
        carregarSubContaResultado();
        limparTabela();   
        this.codCampanha.setText("");
        this.descricaoCampanha.setText("");
        this.duracaoCampanha.setValue(1);
        this.dataInicioCampanha.setText(conversor.dataAtualString());
        this.dataInicioCampanha.setEditable(true);
        this.dataFimCampanha.setText(conversor.calcularData(this.dataInicioCampanha.getText(), (Integer)this.duracaoCampanha.getValue()));
        this.statusCampanha.setSelected(true);
        this.statusCampanha.setEnabled(false);
        this.valorTotalCampanha.setText("");
        this.diaPagamento.setValue(1);
        this.observacaoCampanha.setText("");
        this.nomeParticipante.setText("");
        this.consultarCampanha.setText("");
        this.igrejaCampanha.setEnabled(true);
        this.tipoCampanha.setEnabled(true);
        this.btnAdicionar.setEnabled(true);
        this.nomeParticipante.setEditable(true);    
    }
    
    private void formAlteracao(){
        this.tipoCampanha.setEnabled(false);
        this.dataInicioCampanha.setEditable(false);
        this.igrejaCampanha.setEnabled(false);
        this.nomeParticipante.setEditable(false);
        this.btnAdicionar.setEnabled(false);
    }
    
    private void limparTabela(){
        //Primeiro a condição testa se a quantidade de linhas é maior que 0, depois, limpa os dados
        if(this.tabelaParticipantes.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) this.tabelaParticipantes.getModel();
            model.setRowCount(0);
        }
    }
    
    private void consultarCampanhas(){
        if(this.consultarCampanha.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Para consutar a campanha é preciso informar o código ou nome", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{  
            String textoConsulta = this.consultarCampanha.getText();
            this.listaParticipantes = null;
        } 
    }
    
    private void carregarResultadoConsultaCampanha(){
        ResultadosConsultas resultadoConsulta = new ResultadosConsultas((Frame) SwingUtilities.getWindowAncestor(this), true);
        resultadoConsulta.setLocationRelativeTo(this);
        resultadoConsulta.setVisible(true);
        
        for(Campanha camp : this.listaCampanhas){        
            DefaultTableModel model = (DefaultTableModel) resultadoConsulta.tabelaResultadoConsulta.getModel();
            model.setNumRows(0);
        
            model.addRow(new Object[]{camp.getCodigo(),camp});
        }
    }
    
    private void carregarCampanhaEscolhida(){
        ResultadosConsultas resultadoConsulta = new ResultadosConsultas((Frame) SwingUtilities.getWindowAncestor(this), true);
        this.campanhaSelec = resultadoConsulta.campanha;
        
        this.codCampanha.setText(String.valueOf(this.campanhaSelec.getCodigo()));
        this.nomeParticipante.setText(this.campanhaSelec.getDescricaoCampanha());
        this.tipoCampanha.setSelectedItem(this.campanhaSelec.getTipoCampanha());
        this.duracaoCampanha.setValue(this.campanhaSelec.getDuracaoMeses());
        this.dataInicioCampanha.setText(conversor.convertendoDataStringSql((java.sql.Date) this.campanhaSelec.getDataInicial()));
        this.dataFimCampanha.setText(conversor.convertendoDataStringSql((java.sql.Date) this.campanhaSelec.getDataFinal()));
        this.igrejaCampanha.setSelectedItem(this.campanhaSelec.getIgreja());
        this.valorTotalCampanha.setText(String.valueOf(this.campanhaSelec.getValorTotalCampanha()));
        this.diaPagamento.setValue(this.campanhaSelec.getDiaPagamento());
        this.observacaoCampanha.setText(this.campanhaSelec.getObservacao());
        
        if(this.campanhaSelec.getStatusCampanha() == 1){
            this.statusCampanha.setSelected(true);
        }else{
            this.statusCampanha.setSelected(false);
        }
        
        for(Pessoa pessoa : this.campanhaSelec.getParticipante()){
            DefaultTableModel model = (DefaultTableModel) this.tabelaParticipantes.getModel();
            model.addRow(new Object[]{pessoa.getCodigo(),pessoa,pessoa.getCpfCnpj(),pessoa.getIgreja()});
        }
    }
    
    //Consulta os cadastros ativos, de pessoas.
    private void consultarParticipante(){
        String textoBusca = this.nomeParticipante.getText();
        this.listaParticipantes = this.pessoaDao.consultarCadastroAtivoPessoa(textoBusca);  
    }
    
    //Carrrega todos os cadastros de pessoas encontrado, dentro do Dialog que é aberto, possibilitando a escolha
    private void carregarResultadoConsultaParticipante(){
        ResultadosConsultasPessoas resultConsultParticipante = new ResultadosConsultasPessoas((Frame) SwingUtilities.getWindowAncestor(this), this.listaParticipantes, this);
        resultConsultParticipante.setLocationRelativeTo(this);
        resultConsultParticipante.setVisible(true);
    }
    
    // Método para receber a pessoa selecionada no JDialog, e adicionar na tabela de participantes.
    public void adicionarParticipanteEscolhido(Pessoa pessoa){
        DefaultTableModel model = (DefaultTableModel) this.tabelaParticipantes.getModel();
        model.addRow(new Object[]{pessoa.getCodigo(),pessoa,pessoa.getCpfCnpj(),pessoa.getIgreja()});     
    }
    
    //Gera o contas a receber da campanha.
    private List<ContasReceberCampanha> gerarContasReceberCampanha(){
        
        final Integer qtdPessoas = this.tabelaParticipantes.getRowCount();
        List<ContasReceberCampanha> listaCrCampanhas = new ArrayList<>();
        
        if(qtdPessoas > 0){
            final double valorTotal = Double.parseDouble(this.valorTotalCampanha.getText());
            final Integer qtdParcelas = (Integer) this.duracaoCampanha.getValue();
            final SubContaResultado contaResultado = (SubContaResultado) this.contaResultado.getSelectedItem();
            final double valorParcela = (valorTotal/qtdParcelas)/qtdPessoas;
            final String dataInicio = this.dataInicioCampanha.getText();
            final Igreja igreja = (Igreja) this.igrejaCampanha.getSelectedItem();
            final Integer statusPagamento = 0;
            final String descricaoStatus = "Aberto";
          
            for(int i = 0; i < qtdPessoas; i++ ){             
                Pessoa participante = (Pessoa)this.tabelaParticipantes.getModel().getValueAt(i, 1);
                
                for(int j = 1; j <= qtdParcelas; j++ ){
                    String dataVencimento = this.conversor.calcularData(dataInicio, j);
                    
                    ContasReceberCampanha crCampanha = new ContasReceberCampanha();
                    crCampanha.setContaResultado(contaResultado);
                    crCampanha.setDataVencimento(conversor.convertendoStringDateSql(dataVencimento));
                    crCampanha.setParticipante(participante);
                    crCampanha.setParcela(j);
                    crCampanha.setValorParcela(valorParcela);
                    crCampanha.setValorPendente(valorParcela);
                    crCampanha.setStatusPagamento(statusPagamento);
                    crCampanha.setDescricaoStatus(descricaoStatus);
                    crCampanha.setIgreja(igreja);
                    
                    listaCrCampanhas.add(crCampanha);
                }
            }        
        }         
        return listaCrCampanhas;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbContaReceber;
    private javax.swing.JTextField codCampanha;
    private javax.swing.JTextField consultarCampanha;
    private javax.swing.JComboBox<String> contaResultado;
    private javax.swing.JFormattedTextField dataFimCampanha;
    private javax.swing.JFormattedTextField dataInicioCampanha;
    private javax.swing.JTextField descricaoCampanha;
    private javax.swing.JSpinner diaPagamento;
    private javax.swing.JSpinner duracaoCampanha;
    private javax.swing.JComboBox<String> igrejaCampanha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeParticipante;
    private javax.swing.JTextField observacaoCampanha;
    private javax.swing.JCheckBox statusCampanha;
    private javax.swing.JTable tabelaParticipantes;
    private javax.swing.JComboBox<String> tipoCampanha;
    private javax.swing.JFormattedTextField valorTotalCampanha;
    // End of variables declaration//GEN-END:variables

}
