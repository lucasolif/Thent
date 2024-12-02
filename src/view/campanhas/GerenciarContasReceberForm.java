
package view.campanhas;

import dao.CampanhaDao;
import dao.FormaPagtoDao;
import dao.IgrejaDao;
import dao.PessoaDao;
import ferramentas.Utilitarios;
import interfaces.ConsultaPessoas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Campanha;
import model.ContasReceberCampanha;
import model.FormaPagto;
import model.Igreja;
import model.ParticipanteCampanha;
import model.Pessoa;
import view.carregamentoConsultas.TelaConsultasPessoas;


public class GerenciarContasReceberForm extends javax.swing.JInternalFrame implements ConsultaPessoas{

   private final Utilitarios conversor = new Utilitarios();
   private final IgrejaDao igrejaDao = new IgrejaDao();
   private final FormaPagtoDao formaPagtoDao = new FormaPagtoDao();
   private final CampanhaDao campanhaDao = new CampanhaDao();
   private final PessoaDao pessoaDao = new PessoaDao();
   private List<Pessoa> listaParticipantes = null;
   private List<ContasReceberCampanha> listaCrCampanha = null;
   private Pessoa pessoaSelec = null;
   private ParticipanteCampanha participanteSelec = null;
    
    public GerenciarContasReceberForm() {
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

        statusCampanha = new javax.swing.ButtonGroup();
        statusPagamento = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        campanha = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        codParticipante = new javax.swing.JTextField();
        nomeParticipante = new javax.swing.JTextField();
        formaPagto = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        igreja = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCr = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JButton();
        btnBaixar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rbDataVencimento = new javax.swing.JRadioButton();
        rbDataPagamento = new javax.swing.JRadioButton();
        txData = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rbAberto = new javax.swing.JRadioButton();
        rbPago = new javax.swing.JRadioButton();
        rbAmbos = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        rbTodos = new javax.swing.JRadioButton();
        rbEncerrada = new javax.swing.JRadioButton();
        rbAndamento = new javax.swing.JRadioButton();
        rbCancelada = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gerenciar Contas Receber Campanha");

        jLabel1.setText("Campanha");

        campanha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                campanhaMousePressed(evt);
            }
        });
        campanha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campanhaKeyPressed(evt);
            }
        });

        jLabel2.setText("Participante");

        codParticipante.setEditable(false);
        codParticipante.setBackground(new java.awt.Color(204, 204, 204));
        codParticipante.setFocusable(false);

        nomeParticipante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeParticipanteKeyPressed(evt);
            }
        });

        formaPagto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formaPagtoMousePressed(evt);
            }
        });
        formaPagto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formaPagtoKeyPressed(evt);
            }
        });

        jLabel7.setText("Forma Pagto");

        igreja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                igrejaMousePressed(evt);
            }
        });
        igreja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                igrejaKeyPressed(evt);
            }
        });

        jLabel8.setText("Igreja");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Contas/Parcelas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaCr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° CR", "Participante", "Parcela", "Valor", "Dt Venc", "Dt Pagto", "Status", "Campanha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaCr);
        if (tabelaCr.getColumnModel().getColumnCount() > 0) {
            tabelaCr.getColumnModel().getColumn(0).setResizable(false);
            tabelaCr.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabelaCr.getColumnModel().getColumn(1).setResizable(false);
            tabelaCr.getColumnModel().getColumn(1).setPreferredWidth(250);
            tabelaCr.getColumnModel().getColumn(2).setResizable(false);
            tabelaCr.getColumnModel().getColumn(2).setPreferredWidth(30);
            tabelaCr.getColumnModel().getColumn(3).setResizable(false);
            tabelaCr.getColumnModel().getColumn(3).setPreferredWidth(40);
            tabelaCr.getColumnModel().getColumn(4).setResizable(false);
            tabelaCr.getColumnModel().getColumn(4).setPreferredWidth(60);
            tabelaCr.getColumnModel().getColumn(5).setResizable(false);
            tabelaCr.getColumnModel().getColumn(5).setPreferredWidth(60);
            tabelaCr.getColumnModel().getColumn(6).setResizable(false);
            tabelaCr.getColumnModel().getColumn(6).setPreferredWidth(40);
            tabelaCr.getColumnModel().getColumn(7).setResizable(false);
            tabelaCr.getColumnModel().getColumn(7).setPreferredWidth(200);
        }

        btnFiltrar.setBackground(new java.awt.Color(51, 153, 255));
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnBaixar.setBackground(new java.awt.Color(255, 102, 0));
        btnBaixar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBaixar.setText("Baixar");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtros Por Data De:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        rbDataVencimento.setText("Vencimento");
        rbDataVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataVencimentoActionPerformed(evt);
            }
        });

        rbDataPagamento.setText("Pagamento");
        rbDataPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataPagamentoActionPerformed(evt);
            }
        });

        txData.setText("De");

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
                        .addComponent(rbDataVencimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDataPagamento)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDataVencimento)
                    .addComponent(rbDataPagamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataInicial)
                    .addComponent(dataFinal)
                    .addComponent(jLabel4)
                    .addComponent(txData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Status Pagto", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        statusPagamento.add(rbAberto);
        rbAberto.setText("Aberto");

        statusPagamento.add(rbPago);
        rbPago.setText("Pago");

        statusPagamento.add(rbAmbos);
        rbAmbos.setText("Ambos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbAberto)
                    .addComponent(rbPago)
                    .addComponent(rbAmbos))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rbAberto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbAmbos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbPago))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status Campanha", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        statusCampanha.add(rbTodos);
        rbTodos.setText("Todos");

        statusCampanha.add(rbEncerrada);
        rbEncerrada.setText("Encerrada");

        statusCampanha.add(rbAndamento);
        rbAndamento.setText("Andamento");

        statusCampanha.add(rbCancelada);
        rbCancelada.setText("Cancelada");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rbCancelada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbAndamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbTodos)
                    .addComponent(rbEncerrada)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAndamento)
                    .addComponent(rbEncerrada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbTodos)
                    .addComponent(rbCancelada)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBaixar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(codParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nomeParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(campanha, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(igreja, 0, 171, Short.MAX_VALUE)
                                    .addComponent(formaPagto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnFiltrar))))
                        .addGap(0, 299, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFiltrar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBaixar)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeParticipanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeParticipanteKeyPressed
        consultarParticipante();
        carregarResultadoConsultaParticipante();
    }//GEN-LAST:event_nomeParticipanteKeyPressed

    private void campanhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campanhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            DefaultComboBoxModel campanha = (DefaultComboBoxModel)this.campanha.getModel();
            campanha.removeAllElements();
        } 
    }//GEN-LAST:event_campanhaKeyPressed

    private void formaPagtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formaPagtoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            DefaultComboBoxModel campanha = (DefaultComboBoxModel)this.formaPagto.getModel();
            campanha.removeAllElements();
        } 
    }//GEN-LAST:event_formaPagtoKeyPressed

    private void igrejaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_igrejaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            DefaultComboBoxModel igreja = (DefaultComboBoxModel)this.igreja.getModel();
            igreja.removeAllElements();
        } 
    }//GEN-LAST:event_igrejaKeyPressed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        consultarContasReceberCampanha();
        carregarTabelaContasReceber();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void rbDataVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataVencimentoActionPerformed
        this.txData.setText("Vencimento:");
    }//GEN-LAST:event_rbDataVencimentoActionPerformed

    private void rbDataPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataPagamentoActionPerformed
        this.txData.setText("Pagamento:");
    }//GEN-LAST:event_rbDataPagamentoActionPerformed

    private void campanhaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campanhaMousePressed
        carregarCampanha();
    }//GEN-LAST:event_campanhaMousePressed

    private void igrejaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_igrejaMousePressed
        carregarIgreja();
    }//GEN-LAST:event_igrejaMousePressed

    private void formaPagtoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formaPagtoMousePressed
        carregarFormaPagto();
    }//GEN-LAST:event_formaPagtoMousePressed

    private void formInicial(){
        this.codParticipante.setText("");
        this.nomeParticipante.setText("");
        this.dataInicial.setText(conversor.dataAtualString());
        this.dataFinal.setText(conversor.dataAtualString());
        this.rbDataVencimento.setSelected(true);
        this.rbAberto.setSelected(true);
        this.rbAndamento.setSelected(true);
        this.campanha.setSelectedItem("");
        this.igreja.setSelectedItem("");
        this.formaPagto.setSelectedItem("");
        limparTabela();
        
    }
    
     private void limparTabela(){
        if(this.tabelaCr.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) this.tabelaCr.getModel();
            model.setRowCount(0);
        }
    }
    
    private void carregarCampanha(){
        List<Campanha> listaCampanha = this.campanhaDao.consultarTodasCampanhas();
        DefaultComboBoxModel campanha = (DefaultComboBoxModel)this.campanha.getModel();
        campanha.removeAllElements();
        for(Campanha camp : listaCampanha){
            campanha.addElement(camp);
        }
    }
    
    private void carregarIgreja(){
        List<Igreja> listaIgrejas = this.igrejaDao.consultarTodasIgrejas();
        DefaultComboBoxModel igreja = (DefaultComboBoxModel)this.igreja.getModel();
        igreja.removeAllElements();
        for(Igreja igre : listaIgrejas){
            igreja.addElement(igre);
        }
    }
    
    private void carregarFormaPagto(){
        List<FormaPagto> listaFormaPagto = this.formaPagtoDao.consultarFormaPagto();
        DefaultComboBoxModel formaPagto = (DefaultComboBoxModel)this.formaPagto.getModel();
        formaPagto.removeAllElements();
        for(FormaPagto pagto : listaFormaPagto){
            formaPagto.addElement(pagto);
        }
    }
    
    private void consultarParticipante(){
        String textoBusca = this.nomeParticipante.getText();
        this.listaParticipantes = this.pessoaDao.consultarCadastroAtivoPessoa(textoBusca);  
    }
    
    private void carregarResultadoConsultaParticipante(){
        TelaConsultasPessoas resultConsultParticipante = new TelaConsultasPessoas((Frame) SwingUtilities.getWindowAncestor(this), this.listaParticipantes);
        resultConsultParticipante.setPessoaSelecionada(this);
        resultConsultParticipante.setLocationRelativeTo(this);
        resultConsultParticipante.setVisible(true);
    }
    
    private void carregarParticipanteEscolhido(Pessoa pessoa){
        this.codParticipante.setText(String.valueOf(pessoa.getCodigo()));
        this.nomeParticipante.setText(pessoa.getNome());    
        
        ParticipanteCampanha participante = new ParticipanteCampanha();
        participante.setCodigo(pessoa.getCodigo());
        participante.setNome(pessoa.getNome());
        this.participanteSelec = participante;
    }
    
    private void consultarContasReceberCampanha(){
        
        ContasReceberCampanha crCampanha = new ContasReceberCampanha();
        
        Date dataPagamentoInicial = null;
        Date dataPagamentoFinal = null;
        Date dataVencimentoInicial = null;
        Date dataVencimentoFinal = null;
        FormaPagto formaPagto = (FormaPagto) this.formaPagto.getSelectedItem();
        Campanha campanha = (Campanha) this.campanha.getSelectedItem();
        Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        Integer statusPagto = null;
        String statusCampanha = null;
        
        if(this.rbPago.isSelected()){
            statusPagto = 1;
        }else if(this.rbAberto.isSelected()){
            statusPagto = 0;
        }else if(this.rbAmbos.isSelected()){
            statusPagto = null;
        }
        
        if(this.rbAndamento.isSelected()){
            statusCampanha = "A";
        }else if(this.rbCancelada.isSelected()){
            statusCampanha = "C";
        }else if(this.rbEncerrada.isSelected()){
            statusCampanha = "E";
        }else if(this.rbTodos.isSelected()){
            statusCampanha = null;
        }
        
        if(this.rbDataPagamento.isSelected()){
            dataPagamentoInicial = conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataPagamentoFinal = conversor.convertendoStringDateSql(this.dataFinal.getText());
        }else if(this.rbDataVencimento.isSelected()){
            dataVencimentoInicial = conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataVencimentoFinal = conversor.convertendoStringDateSql(this.dataFinal.getText());
        }
        
        crCampanha.setCampanha(campanha);
        crCampanha.setIgreja(igreja);
        crCampanha.setParticipante(this.participanteSelec);
        crCampanha.setStatusPagamento(statusPagto);
        crCampanha.setFormaPagto(formaPagto);
        
        this.listaCrCampanha = this.campanhaDao.consultarContasReceberCampanha(crCampanha,statusCampanha, dataVencimentoInicial, dataVencimentoFinal, dataPagamentoInicial, dataPagamentoFinal);    
    }
    
    private void carregarTabelaContasReceber(){
        
        DefaultTableModel tabelaCr = (DefaultTableModel) this.tabelaCr.getModel();
        tabelaCr.setNumRows(0);

        for(ContasReceberCampanha cr : this.listaCrCampanha){      
            String dataVencimento =  conversor.convertendoDataStringSql((java.sql.Date) cr.getDataVencimento());
            String dataPagamento =  conversor.convertendoDataStringSql((java.sql.Date) cr.getDataPagamento());
            tabelaCr.addRow(new Object[]{cr.getCodigo(),cr.getParticipante(),cr.getNumParcela(), cr.getValorParcela(), dataVencimento, dataPagamento,cr.getDescricaoStatus(),cr.getCampanha()});
        }
    
    }
    
    @Override
    public void pessoaSelecionada(Pessoa pessoaSelecionada) {
        carregarParticipanteEscolhido(pessoaSelecionada);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaixar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox<String> campanha;
    private javax.swing.JTextField codParticipante;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JComboBox<String> formaPagto;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeParticipante;
    private javax.swing.JRadioButton rbAberto;
    private javax.swing.JRadioButton rbAmbos;
    private javax.swing.JRadioButton rbAndamento;
    private javax.swing.JRadioButton rbCancelada;
    private javax.swing.JRadioButton rbDataPagamento;
    private javax.swing.JRadioButton rbDataVencimento;
    private javax.swing.JRadioButton rbEncerrada;
    private javax.swing.JRadioButton rbPago;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.ButtonGroup statusCampanha;
    private javax.swing.ButtonGroup statusPagamento;
    private javax.swing.JTable tabelaCr;
    private javax.swing.JLabel txData;
    // End of variables declaration//GEN-END:variables
}
