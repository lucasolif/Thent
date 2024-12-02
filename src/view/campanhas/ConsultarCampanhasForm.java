
package view.campanhas;

import dao.CampanhaDao;
import ferramentas.Utilitarios;
import interfaces.ConsultaCampanhas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Campanha;
import model.ParticipanteCampanha;
import view.carregamentoConsultas.TelaConsultasCampanhas;


public class ConsultarCampanhasForm extends javax.swing.JInternalFrame implements ConsultaCampanhas{

    private final CampanhaDao campanhaDao =  new CampanhaDao();
    private final Utilitarios conversor = new Utilitarios();
    private List<Campanha> listaCampanhas = null;
    private Campanha campanhaSelec = null;

    public ConsultarCampanhasForm() {
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

        jLabel1 = new javax.swing.JLabel();
        consultaCampanha = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        codCampanha = new javax.swing.JTextField();
        nomeCampanha = new javax.swing.JTextField();
        dataInicioCampanha = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        dataFimCampanha = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        duracaoCampanha = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        valorTotalCampanha = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        statusCampanha = new javax.swing.JTextField();
        valorArrecadado = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        valorPendente = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        qtdParticipante = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        igreja = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        totalParcelasPagas = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaParticipantes = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consultar Campanhas");

        jLabel1.setText("Buscar");

        consultaCampanha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                consultaCampanhaKeyPressed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(0, 153, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados Campanha", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setText("Campanha");

        codCampanha.setEditable(false);
        codCampanha.setFocusable(false);

        nomeCampanha.setEditable(false);
        nomeCampanha.setFocusable(false);

        dataInicioCampanha.setEditable(false);
        try {
            dataInicioCampanha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataInicioCampanha.setFocusable(false);

        jLabel7.setText("Final Campanha");

        dataFimCampanha.setEditable(false);
        try {
            dataFimCampanha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataFimCampanha.setFocusable(false);

        jLabel3.setText("Duração");

        duracaoCampanha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        duracaoCampanha.setModel(new javax.swing.SpinnerNumberModel());
        duracaoCampanha.setEnabled(false);
        duracaoCampanha.setFocusable(false);

        jLabel6.setText("Inicio Campanha");

        valorTotalCampanha.setEditable(false);
        valorTotalCampanha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        valorTotalCampanha.setFocusable(false);

        jLabel4.setText("Total Camp");

        jLabel5.setText("Status Camp");

        statusCampanha.setEditable(false);
        statusCampanha.setFocusable(false);

        valorArrecadado.setEditable(false);
        valorArrecadado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        valorArrecadado.setFocusable(false);

        jLabel8.setText("Val. Arrecadado");

        valorPendente.setEditable(false);
        valorPendente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        valorPendente.setFocusable(false);

        jLabel9.setText("Val. Pendente");

        qtdParticipante.setEditable(false);
        qtdParticipante.setFocusable(false);

        jLabel10.setText("Qtd Partici");

        igreja.setEditable(false);
        igreja.setFocusable(false);

        jLabel11.setText("Igreja Campanha");

        totalParcelasPagas.setEditable(false);
        totalParcelasPagas.setFocusable(false);

        jLabel12.setText("Tot. Parc Paga");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(codCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(duracaoCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataInicioCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataFimCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(valorTotalCampanha, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(statusCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(valorArrecadado, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(valorPendente, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtdParticipante)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(totalParcelasPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorTotalCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicioCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(duracaoCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataFimCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorArrecadado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorPendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtdParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalParcelasPagas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        tabelaParticipantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Nome Participantes", "Status", "Qtd Parc Paga", "Valor Pagor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            tabelaParticipantes.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabelaParticipantes.getColumnModel().getColumn(1).setResizable(false);
            tabelaParticipantes.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabelaParticipantes.getColumnModel().getColumn(2).setResizable(false);
            tabelaParticipantes.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabelaParticipantes.getColumnModel().getColumn(3).setResizable(false);
            tabelaParticipantes.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabelaParticipantes.getColumnModel().getColumn(4).setResizable(false);
            tabelaParticipantes.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(consultaCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)
                                .addGap(0, 339, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(consultaCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultaCampanhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_consultaCampanhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
            limparTabela();
            consultarCampanhas();
            carregarResultadoConsultaCampanha();
        }
    }//GEN-LAST:event_consultaCampanhaKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        limparTabela();
        consultarCampanhas();
        carregarResultadoConsultaCampanha();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formInicial(){
        this.codCampanha.setText("");
        this.nomeCampanha.setText("");
        this.duracaoCampanha.setValue(1);
        this.dataInicioCampanha.setText("");
        this.dataFimCampanha.setText("");
        this.valorTotalCampanha.setText("");
        this.statusCampanha.setText("");
        this.valorArrecadado.setText("");
        this.valorPendente.setText("");
        this.qtdParticipante.setText("");
        this.igreja.setText("");
        this.totalParcelasPagas.setText("");
        limparTabela();
    }
    
    private void limparTabela(){
        if(this.tabelaParticipantes.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) this.tabelaParticipantes.getModel();
            model.setRowCount(0);
        }
    }
     
    private void consultarCampanhas(){
        String textoConsulta = this.consultaCampanha.getText();
        this.listaCampanhas = this.campanhaDao.consultarCampanhas(textoConsulta);
    }
    
    private void carregarResultadoConsultaCampanha(){
        TelaConsultasCampanhas resultadoConsulta = new TelaConsultasCampanhas((Frame) SwingUtilities.getWindowAncestor(this), this.listaCampanhas);
        resultadoConsulta.setCampanhaSelecionada(this);
        resultadoConsulta.setLocationRelativeTo(this);
        resultadoConsulta.setVisible(true);
    }
    
    private void carregarCampanhaEscolhida(Campanha campanha){
        List<ParticipanteCampanha> listaParticiCampanha = this.campanhaDao.consultarParticipantesValores(campanha.getCodigo());
        List<Double> listaValores = this.campanhaDao.consultarValores(campanha.getCodigo());
        campanha.setParticipante(listaParticiCampanha);
        
        this.codCampanha.setText(String.valueOf(campanha.getCodigo()));
        this.nomeCampanha.setText(campanha.getDescricaoCampanha());
        this.duracaoCampanha.setValue(campanha.getDuracaoMeses());
        this.dataInicioCampanha.setText(this.conversor.convertendoDataStringSql((Date) campanha.getDataInicial()));
        this.dataFimCampanha.setText(this.conversor.convertendoDataStringSql((Date) campanha.getDataFinal()));
        this.igreja.setText(campanha.getIgreja().getNome());
        this.valorTotalCampanha.setText(String.valueOf(campanha.getValorTotalCampanha()));
        this.statusCampanha.setText(campanha.getDescricaoStatus());
        this.qtdParticipante.setText(String.valueOf(campanha.getParticipante().size()));
        this.valorArrecadado.setText(String.valueOf(listaValores.get(0)));
        this.valorPendente.setText(String.valueOf(listaValores.get(1)));
        this.totalParcelasPagas.setText(String.valueOf(listaValores.get(2)));
        this.campanhaSelec = campanha;      
          
        for(ParticipanteCampanha part : listaParticiCampanha){
            DefaultTableModel model = (DefaultTableModel) this.tabelaParticipantes.getModel();
            model.addRow(new Object[]{part.getCodigo(),part,part.getDescricaoStatus(),part.getQtdParcelasPagas(),part.getValorTotalPago()});   
        }  
    }
    
        
    @Override
    public void campanhaSelecionada(Campanha campanhaSelecionada) {
        carregarCampanhaEscolhida(campanhaSelecionada);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JTextField codCampanha;
    private javax.swing.JTextField consultaCampanha;
    private javax.swing.JFormattedTextField dataFimCampanha;
    private javax.swing.JFormattedTextField dataInicioCampanha;
    private javax.swing.JSpinner duracaoCampanha;
    private javax.swing.JTextField igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField nomeCampanha;
    private javax.swing.JTextField qtdParticipante;
    private javax.swing.JTextField statusCampanha;
    private javax.swing.JTable tabelaParticipantes;
    private javax.swing.JTextField totalParcelasPagas;
    private javax.swing.JFormattedTextField valorArrecadado;
    private javax.swing.JFormattedTextField valorPendente;
    private javax.swing.JFormattedTextField valorTotalCampanha;
    // End of variables declaration//GEN-END:variables
}
