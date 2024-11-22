
package view.campanhas;

import dao.CampanhaDao;
import dao.PessoaDao;
import dao.SubContaResultadoDao;
import ferramentas.PaletaCores;
import ferramentas.Utilitarios;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Campanha;
import interfaces.ConsultaCampanhas;
import interfaces.ConsultaPessoas;
import model.ContasReceberCampanha;
import model.Igreja;
import model.Pessoa;
import model.SubContaResultado;
import view.carregamentoConsultas.TelaConsultasCampanhas;
import view.carregamentoConsultas.TelaConsultasPessoas;

public class CadastrarParticipanteAvulso extends javax.swing.JInternalFrame implements ConsultaCampanhas,ConsultaPessoas{
    
    private final CampanhaDao campanhaDao = new CampanhaDao();
    private final PaletaCores cores = new PaletaCores();
    private final SubContaResultadoDao contaResultadoDao = new SubContaResultadoDao();
    private final PessoaDao pessoaDao = new PessoaDao();
    private final Campanha campanha = new Campanha();
    private List<Campanha> listaCampanha = null;
    private final Utilitarios conversor = new Utilitarios();
    private Pessoa participanteSelec = null;
    private List<Pessoa> listaParticipantes = null;

    public CadastrarParticipanteAvulso() {
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

        codCampanha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nomeCampanha = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        duracaoCampanha = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        dataInicioPagamento = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        dataFimCampanha = new javax.swing.JFormattedTextField();
        valoPagtoMensal = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        diaPagamento = new javax.swing.JTextField();
        cbGerarContasReceber = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        participante = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaParticipantes = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        contaResultado = new javax.swing.JComboBox<>();
        igreja = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Adicionar Participantes Avulso");

        codCampanha.setEditable(false);
        codCampanha.setBackground(new java.awt.Color(204, 204, 204));
        codCampanha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel1.setText("Campanha*");

        nomeCampanha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeCampanhaKeyPressed(evt);
            }
        });

        btnOk.setBackground(new java.awt.Color(51, 153, 255));
        btnOk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jLabel2.setText("Duração");

        duracaoCampanha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        duracaoCampanha.setModel(new javax.swing.SpinnerNumberModel());
        duracaoCampanha.setEnabled(false);

        jLabel6.setText("Data Inicial");

        dataInicioPagamento.setEditable(false);
        dataInicioPagamento.setBackground(new java.awt.Color(204, 204, 204));
        try {
            dataInicioPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("Final Campanha");

        dataFimCampanha.setEditable(false);
        dataFimCampanha.setBackground(new java.awt.Color(204, 204, 204));
        try {
            dataFimCampanha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        valoPagtoMensal.setEditable(false);
        valoPagtoMensal.setBackground(new java.awt.Color(204, 204, 204));
        valoPagtoMensal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel3.setText("Valor Mensal*");

        diaPagamento.setEditable(false);
        diaPagamento.setBackground(new java.awt.Color(204, 204, 204));

        cbGerarContasReceber.setText("Contas Receber");
        cbGerarContasReceber.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbGerarContasReceberItemStateChanged(evt);
            }
        });

        jLabel4.setText("Dia Pagto");

        jLabel8.setText("Participante*");

        btnAdicionar.setBackground(new java.awt.Color(255, 102, 0));
        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        tabelaParticipantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF/CNPJ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tabelaParticipantes);
        if (tabelaParticipantes.getColumnModel().getColumnCount() > 0) {
            tabelaParticipantes.getColumnModel().getColumn(0).setResizable(false);
            tabelaParticipantes.getColumnModel().getColumn(0).setPreferredWidth(70);
            tabelaParticipantes.getColumnModel().getColumn(1).setResizable(false);
            tabelaParticipantes.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabelaParticipantes.getColumnModel().getColumn(2).setResizable(false);
            tabelaParticipantes.getColumnModel().getColumn(2).setPreferredWidth(170);
        }

        btnSalvar.setBackground(new java.awt.Color(51, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel5.setText("Conta de Resultado");

        contaResultado.setEnabled(false);

        igreja.setEnabled(false);

        jLabel9.setText("Gerar");

        jLabel10.setText("Igreja");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(duracaoCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dataInicioPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dataFimCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(cbGerarContasReceber))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(diaPagamento)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(codCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nomeCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(122, 122, 122)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(igreja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 61, Short.MAX_VALUE))
                            .addComponent(contaResultado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valoPagtoMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(participante, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdicionar))
                            .addComponent(jLabel8))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicioPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOk))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(duracaoCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataFimCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbGerarContasReceber)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(diaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valoPagtoMensal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(participante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar)
                    .addComponent(contaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeCampanhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeCampanhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
            consultarCampanhas();
            carregarResultadoConsultaCampanha();
        }
    }//GEN-LAST:event_nomeCampanhaKeyPressed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        consultarCampanhas();
        carregarResultadoConsultaCampanha();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        consultarParticipante();
        carregarResultadoConsultaParticipante();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        cadastrarParticipantesGerarContaReceber();
        formInicial();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cbGerarContasReceberItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbGerarContasReceberItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            formGerarCr(true, cores.branco());     
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            formGerarCr(false, cores.cinza());                         
        }
    }//GEN-LAST:event_cbGerarContasReceberItemStateChanged
  
    private void formInicial(){
        carregarSubContaResultado();
        this.dataInicioPagamento.setText(this.conversor.dataAtualString());
        this.codCampanha.setText("");
        this.nomeCampanha.setText("");
        this.dataFimCampanha.setText("");
        this.duracaoCampanha.setValue(0);
        this.valoPagtoMensal.setText("");
        this.participante.setText("");
        this.diaPagamento.setText("");
        this.contaResultado.setEnabled(false);
        this.igreja.setEnabled(false);
        this.cbGerarContasReceber.setSelected(false);
        limparTabela();
    }
    
    private void formGerarCr(boolean status, Color cor){
        this.dataInicioPagamento.setEditable(status);
        this.valoPagtoMensal.setEditable(status);
        this.igreja.setEnabled(status);
        this.contaResultado.setEnabled(status);          
        this.dataInicioPagamento.setBackground(cor);
        this.valoPagtoMensal.setBackground(cor);
    }
    
    private void limparTabela(){
        if(this.tabelaParticipantes.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) this.tabelaParticipantes.getModel();
            model.setRowCount(0);
        }
    }
    
    private void consultarCampanhas(){
        if(!this.nomeCampanha.getText().isEmpty()){
            String busca = this.nomeCampanha.getText();
            this.listaCampanha = campanhaDao.consultarCampanhasAtiva(busca);
        }else{
            JOptionPane.showMessageDialog(null, "Informe o código ou nome da campanha!", "Atenção", JOptionPane.WARNING_MESSAGE);     
        }        
    }
    
    private void carregarResultadoConsultaCampanha(){
        TelaConsultasCampanhas resultConsultaCampanhas = new TelaConsultasCampanhas((Frame) SwingUtilities.getWindowAncestor(this), this.listaCampanha);
        resultConsultaCampanhas.setCampanhaSelecionada(this);
        resultConsultaCampanhas.setLocationRelativeTo(this);
        resultConsultaCampanhas.setVisible(true);
    }
    
    private void carregarCampanhaEscolhida(Campanha campanhaEscolhida){
        this.codCampanha.setText(String.valueOf(campanhaEscolhida.getCodigo()));
        this.nomeCampanha.setText(String.valueOf(campanhaEscolhida));
        this.duracaoCampanha.setValue(campanhaEscolhida.getDuracaoMeses());
        this.dataFimCampanha.setText(conversor.convertendoDataStringSql((Date) campanhaEscolhida.getDataFinal()));
        this.diaPagamento.setText(String.valueOf(campanha.getDiaPagamento()));
    }
    
    private void carregarSubContaResultado(){
        List<SubContaResultado> listaSubContResult = this.contaResultadoDao.consultarSubContaResultado();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.contaResultado.getModel();
        modelo.removeAllElements();
        for(SubContaResultado subCont : listaSubContResult){
            modelo.addElement(subCont);
        }
    }
    
    private void consultarParticipante(){
        String textoBusca = this.participante.getText();
        this.listaParticipantes = this.pessoaDao.consultarCadastroAtivoPessoa(textoBusca);  
    }
    
    private void carregarResultadoConsultaParticipante(){
        TelaConsultasPessoas resultConsultParticipante = new TelaConsultasPessoas((Frame) SwingUtilities.getWindowAncestor(this), this.listaParticipantes);
        resultConsultParticipante.setPessoaSelecionada(this);
        resultConsultParticipante.setLocationRelativeTo(this);
        resultConsultParticipante.setVisible(true);
    }
    
    private void carregarParticipanteEscolhido(Pessoa pessoa){
        DefaultTableModel model = (DefaultTableModel) this.tabelaParticipantes.getModel();
        model.addRow(new Object[]{pessoa.getCodigo(),pessoa,pessoa.getCpfCnpj()});     
    }
    
    private void cadastrarParticipantesGerarContaReceber(){
        
        final int qtdParticipantes = this.tabelaParticipantes.getRowCount();
        
        if(qtdParticipantes > 0){
            List<Pessoa> participantes = participantesCampanha();
            Integer codCampanha = Integer.valueOf(this.codCampanha.getText());       
            campanhaDao.adicionarParticipantes(participantes, codCampanha);
            
            if(this.cbGerarContasReceber.isSelected()){
                List<ContasReceberCampanha> listaContasReceber = gerarContasReceberCampanha();
                campanhaDao.gerarContasReceberCampanha(listaContasReceber, codCampanha);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Para cadastrar o participante é necessário adicioná-los na tabela de participantes", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private List<Pessoa> participantesCampanha(){
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
    
    private List<ContasReceberCampanha> gerarContasReceberCampanha(){
   
        List<ContasReceberCampanha> listaCrCampanhas = new ArrayList<>();
        final Integer qtdPessoas = this.tabelaParticipantes.getRowCount();
        if(qtdPessoas > 0){
            for(int i = 0; i < qtdPessoas; i++){
                final int qtdParcelas =  conversor.diferencaDatas(this.dataInicioPagamento.getText(), this.dataFimCampanha.getText());
                final SubContaResultado contaResultado = (SubContaResultado) this.contaResultado.getSelectedItem();
                final Igreja igreja = (Igreja) this.igreja.getSelectedItem();
                final double valorParcela = Double.parseDouble(this.valoPagtoMensal.getText().replace(",", "."));
                final String dataInicio = this.dataInicioPagamento.getText();
                final Integer statusPagamento = 0;
                final String descricaoStatus = "Aberto";
                
                Pessoa participante = (Pessoa)this.tabelaParticipantes.getModel().getValueAt(i, 1);

                for(int j = 1; j <= qtdParcelas; j++ ){
                    String dataVencimento = this.conversor.somarDatas(dataInicio, j);

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
    
    @Override
    public void pessoaSelecionada(Pessoa pessoaSelecionada) {
        carregarParticipanteEscolhido(pessoaSelecionada);
    }
    
    @Override
    public void campanhaSelecionada(Campanha campanhaSelecionada) {
        carregarCampanhaEscolhida(campanhaSelecionada);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbGerarContasReceber;
    private javax.swing.JTextField codCampanha;
    private javax.swing.JComboBox<String> contaResultado;
    private javax.swing.JFormattedTextField dataFimCampanha;
    private javax.swing.JFormattedTextField dataInicioPagamento;
    private javax.swing.JTextField diaPagamento;
    private javax.swing.JSpinner duracaoCampanha;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeCampanha;
    private javax.swing.JTextField participante;
    private javax.swing.JTable tabelaParticipantes;
    private javax.swing.JFormattedTextField valoPagtoMensal;
    // End of variables declaration//GEN-END:variables


}
