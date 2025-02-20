
package view.campanhas;

import Ferramentas.PersonalizaTabela;
import dao.CampanhaDao;
import dao.PessoaDao;
import dao.SubContaResultadoDao;
import Ferramentas.Utilitarios;
import interfaces.ConsultaPessoas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Campanha;
import model.ContasReceberCampanha;
import model.ParticipanteCampanha;
import model.Pessoa;
import model.SubContaResultado;
import model.UsuarioLogado;
import view.carregamentoConsultas.TelaConsultasPessoas;


public class GerarContasReceberAvulsaForm extends javax.swing.JInternalFrame implements ConsultaPessoas{

     private final PersonalizaTabela personalizaTabela = new PersonalizaTabela();
    private final CampanhaDao campanhaDao = new CampanhaDao();
    private final PessoaDao pessoaDao = new PessoaDao();
    private final SubContaResultadoDao subContaResultadoDao = new SubContaResultadoDao();
    private final Utilitarios utilitarios = new Utilitarios();
    private Pessoa pessoaSelec = null;
    private ParticipanteCampanha participanteSelec = null;
    private Campanha campanhaSelec = null;
    private List<Pessoa> listaParticipantes = null;
        

    public GerarContasReceberAvulsaForm(UsuarioLogado usuarioLogado) {
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
        codParticipante = new javax.swing.JTextField();
        nomeParticipante = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        campanha = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        dataPrimeiraParcela = new javax.swing.JFormattedTextField();
        quantidadeParcelas = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        valoPagtoMensal = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        btnGerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCrGerada = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        contaResultado = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gerar Conta a Receber ");

        jLabel1.setText("Participante");

        codParticipante.setEditable(false);
        codParticipante.setBackground(new java.awt.Color(204, 204, 204));
        codParticipante.setFocusable(false);

        nomeParticipante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeParticipanteKeyPressed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(51, 153, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Campanha");

        try {
            dataPrimeiraParcela.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        quantidadeParcelas.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));

        jLabel3.setText("Qtd Parc");

        jLabel4.setText("Data 1° Parc");

        jLabel6.setText("ContaResultado");

        valoPagtoMensal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel7.setText("Val. Mensal");

        btnGerar.setBackground(new java.awt.Color(255, 153, 0));
        btnGerar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGerar.setText("Gerar");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Contas a Receber", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaCrGerada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parc", "Valor", "Data Vencimento", "Campanha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        jScrollPane1.setViewportView(tabelaCrGerada);
        if (tabelaCrGerada.getColumnModel().getColumnCount() > 0) {
            tabelaCrGerada.getColumnModel().getColumn(0).setResizable(false);
            tabelaCrGerada.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabelaCrGerada.getColumnModel().getColumn(1).setResizable(false);
            tabelaCrGerada.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabelaCrGerada.getColumnModel().getColumn(2).setResizable(false);
            tabelaCrGerada.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabelaCrGerada.getColumnModel().getColumn(3).setResizable(false);
            tabelaCrGerada.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        btnSalvar.setBackground(new java.awt.Color(0, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
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
                            .addComponent(jLabel3)
                            .addComponent(quantidadeParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dataPrimeiraParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(27, 27, 27))
                                    .addComponent(valoPagtoMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGerar)
                                .addGap(14, 14, 14))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(codParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campanha, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(contaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(111, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantidadeParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnGerar)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataPrimeiraParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(valoPagtoMensal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeParticipanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeParticipanteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
            consultarParticipante();
            carregarResultadoConsultaParticipante();
        }
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.codParticipante.setText("");
        } 
    }//GEN-LAST:event_nomeParticipanteKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarParticipante();
        carregarResultadoConsultaParticipante();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        gerarParcelas();
        formGerarCr();
    }//GEN-LAST:event_btnGerarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(this.tabelaCrGerada.getRowCount() < 0){
            JOptionPane.showMessageDialog(null, "Não há parcelas geradas, gere as parcelas", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            cadastrarContaReceber();
            formInicial();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void formInicial(){
        this.codParticipante.setText("");
        this.nomeParticipante.setText("");
        this.quantidadeParcelas.setValue(1);
        this.dataPrimeiraParcela.setText(utilitarios.dataAtualString());
        this.valoPagtoMensal.setText("");
        this.valoPagtoMensal.setEditable(true);
        this.quantidadeParcelas.setEnabled(true);
        limparTabela();
        carregarSubContaResultado();
        carregarCampanhas();
        alinharConteudoTabela();
        this.personalizaTabela.definirNegritoTituloColuna(tabelaCrGerada);
    }
    
    private void formGerarCr(){
        this.valoPagtoMensal.setEditable(false);
        this.quantidadeParcelas.setEnabled(false);
    }
    
    private void carregarCampanhas(){
        List<Campanha> listaCampanha = this.campanhaDao.consultarTodasCampanhasAtiva();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.campanha.getModel();
        modelo.removeAllElements();
        for(Campanha campanha : listaCampanha){
            modelo.addElement(campanha);
        }
    }
    
    private void carregarSubContaResultado(){
        List<SubContaResultado> listaSubContResult = this.subContaResultadoDao.consultarSubContaResultado();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.contaResultado.getModel();
        modelo.removeAllElements();
        for(SubContaResultado subCont : listaSubContResult){
            modelo.addElement(subCont);
        }
    }
    
    private void limparTabela(){
        if(this.tabelaCrGerada.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) this.tabelaCrGerada.getModel();
            model.setRowCount(0);
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
        participante.setCpfCnpj(pessoa.getCpfCnpj());
        participante.setEndereco(pessoa.getEndereco());
        
        this.participanteSelec = participante;
    }
    
    private void gerarParcelas(){
        Integer qtdParcelas = (Integer) this.quantidadeParcelas.getValue();
        String dataVencimento = this.dataPrimeiraParcela.getText();
        String dataPrimeiraParcela = this.dataPrimeiraParcela.getText();
        String valorMensal = this.valoPagtoMensal.getText();
        Campanha campanha = (Campanha) this.campanha.getSelectedItem();
        
        if(!this.codParticipante.getText().isEmpty() && !this.valoPagtoMensal.getText().isEmpty()){
            for(int i=0; i < qtdParcelas; i++){
                dataVencimento = this.utilitarios.somarDatas(dataPrimeiraParcela, i);                       
                DefaultTableModel model = (DefaultTableModel) this.tabelaCrGerada.getModel();
                model.addRow(new Object[]{i+1,valorMensal,dataVencimento,campanha});
            }
        }
    }
    
    private void cadastrarContaReceber(){
        List<ContasReceberCampanha> listaCr = new ArrayList<>();
        double valorMensal = Double.parseDouble(this.valoPagtoMensal.getText().replace(",", "."));
        Campanha campanha = (Campanha) this.campanha.getSelectedItem();
        SubContaResultado contaResultado = (SubContaResultado) this.contaResultado.getSelectedItem();
        int qtdLinhasTabela = this.tabelaCrGerada.getRowCount();
        
        for(int i=0; i < qtdLinhasTabela; i++){
            Integer parcela  = (Integer)tabelaCrGerada.getModel().getValueAt(i, 0);
            String data = (String) tabelaCrGerada.getModel().getValueAt(i, 2);
            Date dataVencimento = utilitarios.convertendoStringDateSql(data);
            
            ContasReceberCampanha crCampanha = new ContasReceberCampanha();           
            crCampanha.setCampanha(campanha);
            crCampanha.setContaResultado(contaResultado);
            crCampanha.setDataVencimento(dataVencimento);
            crCampanha.setDescricaoStatus("Aberto");
            crCampanha.setIgreja(campanha.getIgreja());
            crCampanha.setParcela(parcela);
            crCampanha.setParticipante(this.participanteSelec);
            crCampanha.setStatusPagamento(0);
            crCampanha.setValorParcela(valorMensal);
            crCampanha.setValorPendente(valorMensal);
            
            listaCr.add(crCampanha);
        }
        this.participanteSelec.setListaCrCampanha(listaCr);
        boolean verificarParticipante = this.campanhaDao.verificarParticipanteCampanha(campanha, this.participanteSelec);
        
        if(verificarParticipante){          
            this.campanhaDao.gerarContasReceberAvulsaCampanha(this.participanteSelec, campanha.getCodigo());   
        }else{
            int confirm = JOptionPane.showConfirmDialog(null,"Participante não está na campanha, continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                this.campanhaDao.gerarContasReceberAvulsaCampanha(this.participanteSelec, campanha.getCodigo());
            }else if(confirm == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            }     
        }          
    }
    
    private void alinharConteudoTabela(){
        
        // Alinhamento do Ofertante (à esquerda)
        DefaultTableCellRenderer primeiraColuna = new DefaultTableCellRenderer();
        primeiraColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaCrGerada.getColumnModel().getColumn(0).setCellRenderer(primeiraColuna);

        // Alinhamento do Valor (centro)
        DefaultTableCellRenderer segundaColuna = new DefaultTableCellRenderer();
        segundaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaCrGerada.getColumnModel().getColumn(1).setCellRenderer(segundaColuna);

        //Alinhamento do tipo de oferta
        DefaultTableCellRenderer terceiraColuna = new DefaultTableCellRenderer();
        terceiraColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaCrGerada.getColumnModel().getColumn(2).setCellRenderer(terceiraColuna);
        
        //Alinhamento da igreja
        DefaultTableCellRenderer quartaColuna = new DefaultTableCellRenderer();
        quartaColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaCrGerada.getColumnModel().getColumn(3).setCellRenderer(quartaColuna);    

    }
    
    @Override
    public void pessoaSelecionada(Pessoa pessoaSelecionada) {
        carregarParticipanteEscolhido(pessoaSelecionada);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGerar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> campanha;
    private javax.swing.JTextField codParticipante;
    private javax.swing.JComboBox<String> contaResultado;
    private javax.swing.JFormattedTextField dataPrimeiraParcela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeParticipante;
    private javax.swing.JSpinner quantidadeParcelas;
    private javax.swing.JTable tabelaCrGerada;
    private javax.swing.JFormattedTextField valoPagtoMensal;
    // End of variables declaration//GEN-END:variables
}
