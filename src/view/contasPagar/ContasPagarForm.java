
package view.contasPagar;

import dao.ContasPagarDao;
import dao.FormaPagtoDao;
import dao.IgrejaDao;
import dao.PessoaDao;
import dao.SubContaResultadoDao;
import Services.Utilitarios;
import interfaces.ConsultaPessoas;
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
import model.ContasPagar;
import model.FormaPagto;
import model.Igreja;
import model.Pessoa;
import model.SubContaResultado;
import view.carregamentoConsultas.TelaConsultasPessoas;


public class ContasPagarForm extends javax.swing.JInternalFrame implements ConsultaPessoas{

    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final PessoaDao pessoaDao = new PessoaDao();
    private final FormaPagtoDao formaPagtoDao = new FormaPagtoDao();
    private final SubContaResultadoDao subContResultDao = new SubContaResultadoDao();
    private final ContasPagarDao contasPagarDao = new ContasPagarDao(); 
    private final Pessoa fornecedor = new Pessoa();
    private List<Pessoa> listaFornecedor = null;
    private final Utilitarios conversor = new Utilitarios();
    
    public ContasPagarForm() {
        initComponents();
        carregarSubContaResultado();
        carregarFormaPagto();
        carregarIgrejas();
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        codFornecedor = new javax.swing.JTextField();
        nomeFornecedor = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        numNota = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        primeiroVencimento = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        valorTotal = new javax.swing.JFormattedTextField();
        formasPagto = new javax.swing.JComboBox<>();
        numParcela = new javax.swing.JTextField();
        numBoleto = new javax.swing.JTextField();
        observacaoConta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnGerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaParcelas = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        descricaoConta = new javax.swing.JTextField();
        subContaResultado = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        iconAlterar = new javax.swing.JButton();
        igreja = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Contas a Pagar");

        codFornecedor.setEditable(false);
        codFornecedor.setBackground(new java.awt.Color(204, 204, 204));
        codFornecedor.setFocusable(false);

        nomeFornecedor.setBackground(new java.awt.Color(255, 255, 255));
        nomeFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeFornecedorKeyPressed(evt);
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

        jLabel1.setText("Fornecedor*");

        jLabel2.setText("N° Nota*");

        try {
            primeiroVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("1° Vencimento*");

        valorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel8.setText("Observação");

        btnGerar.setBackground(new java.awt.Color(255, 153, 0));
        btnGerar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGerar.setText("Gerar");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Parcelas Geradas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Nota", "Descrição", "Parcela", "Valor (R$)", "Data Vencimento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaParcelas.setShowGrid(true);
        jScrollPane1.setViewportView(tabelaParcelas);
        if (tabelaParcelas.getColumnModel().getColumnCount() > 0) {
            tabelaParcelas.getColumnModel().getColumn(0).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaParcelas.getColumnModel().getColumn(1).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabelaParcelas.getColumnModel().getColumn(2).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(2).setPreferredWidth(10);
            tabelaParcelas.getColumnModel().getColumn(3).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabelaParcelas.getColumnModel().getColumn(4).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        btnSalvar.setBackground(new java.awt.Color(51, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
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

        jLabel9.setText("Descrição*");

        jLabel10.setText("N° Parcela*");

        jLabel12.setText("Valor Total (R$)*");

        jLabel13.setText("Forma Pagto*");

        jLabel4.setText("SubConta Resultado*");

        jLabel5.setText("N° Boleto");

        iconAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-editar-16.png"))); // NOI18N
        iconAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconAlterarActionPerformed(evt);
            }
        });

        jLabel6.setText("Igreja/Campo*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numNota, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(descricaoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(primeiroVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iconAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalvar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(numParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(formasPagto, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel13))))
                                    .addComponent(observacaoConta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(igreja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnGerar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(subContaResultado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(numBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descricaoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(primeiroVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formasPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(observacaoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGerar)
                    .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar)
                    .addComponent(iconAlterar))
                .addGap(33, 33, 33))
        );

        codFornecedor.getAccessibleContext().setAccessibleName("Código do Fornecedor");
        nomeFornecedor.getAccessibleContext().setAccessibleName("Nome do Fornecedor");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        removerParcelaGerada();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparTabela();
        limparFormulario();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarFornecedor();
        carregarResultadoConsultaFornecedor();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        if(validarCampos()){
            gerarParcelas();
            this.tabelaParcelas.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(null, "Para efetuar o lançamento de uma conta a pagar, tem que preencher os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGerarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        List<ContasPagar> contaPagar = lançarContasPagar();
        this.contasPagarDao.adicionarContasPagar(contaPagar);
        limparTabela();
        limparFormulario();
        contaPagar.clear(); //Limpando a lista com os dados
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void iconAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconAlterarActionPerformed
        this.tabelaParcelas.setEnabled(true);
    }//GEN-LAST:event_iconAlterarActionPerformed

    private void nomeFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeFornecedorKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscarFornecedor();
            carregarResultadoConsultaFornecedor();
        } 
    }//GEN-LAST:event_nomeFornecedorKeyPressed

    private void carregarFormaPagto(){
        List<FormaPagto> listaFormaPagto = this.formaPagtoDao.consultarFormaPagto();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.formasPagto.getModel();
        modelo.removeAllElements();
        for(FormaPagto pagto : listaFormaPagto){
            modelo.addElement(pagto);
        }
    }
    
    private void carregarSubContaResultado(){
        List<SubContaResultado> listaSubContResult = this.subContResultDao.consultarSubContaResultado();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.subContaResultado.getModel();
        modelo.removeAllElements();
        for(SubContaResultado subCont : listaSubContResult){
            modelo.addElement(subCont);
        }
    }
    
    private void carregarIgrejas(){ 
        List<Igreja> listaIgrejas = this.igrejaDao.consultarTodasIgrejas();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.igreja.getModel();
        modelo.removeAllElements();
        for(Igreja igreja : listaIgrejas){
            modelo.addElement(igreja);
        }
    }
    
    //Gera as parcela(s) para ser adicionada no banco e mostrar na tabela. Cada parcela é adicionada separada no banco
    private void gerarParcelas(){
        if(validarContaPagarExiste()){
            JOptionPane.showMessageDialog(null, "Já existe um contas a pagar com esse número, escolha outro número", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            limparTabela(); //Limpando a tabela, antes de inserir qualquer dado
            Integer codForn = Integer.valueOf(this.codFornecedor.getText());
            this.fornecedor.setCodigo(codForn);
            Integer numNota = Integer.valueOf(this.numNota.getText());
            Integer qtdParcela = Integer.valueOf(this.numParcela.getText());
            String descricao = this.descricaoConta.getText().toUpperCase();
            double valorTotal = Double.parseDouble(this.valorTotal.getText().replace(",", "."));
            double valorParcela = valorTotal/qtdParcela; //Gerando o valor da parcela
            String primeiroVencimento = this.primeiroVencimento.getText();

            for(int i=0; i<qtdParcela; i++){      
                String dataVencimento = this.conversor.somarDatas(primeiroVencimento, i); //Passa a primeira data e parcela, para somar os meses.          
                DefaultTableModel model = (DefaultTableModel) this.tabelaParcelas.getModel();
                model.addRow(new Object[]{numNota,descricao,i+1,valorParcela,dataVencimento});
            }
        }
    }
    
    private void buscarFornecedor(){
        String textoBusca = this.nomeFornecedor.getText(); // Texto digitado na busca        
        this.listaFornecedor = this.pessoaDao.consultarPessoa(textoBusca); //Lista recebe a busca retornada do banco      
    } 
    
    private void carregarResultadoConsultaFornecedor(){
        TelaConsultasPessoas resultConsultParticipante = new TelaConsultasPessoas((Frame) SwingUtilities.getWindowAncestor(this), this.listaFornecedor);
        resultConsultParticipante.setPessoaSelecionada(this);
        resultConsultParticipante.setLocationRelativeTo(this);
        resultConsultParticipante.setVisible(true);
    }
    
    private void carregarFornecedorEscolhido(Pessoa pessoa){
        this.codFornecedor.setText(Integer.toString(pessoa.getCodigo()));
        this.nomeFornecedor.setText(pessoa.getNome());
    }
    
    //Salvar os dados no banco de dados
    private List<ContasPagar> lançarContasPagar(){
        
        List<ContasPagar> listaContasPagar = new ArrayList<>();
        int qtdLinhasTabela = this.tabelaParcelas.getRowCount();
        
        if(validarCampos()){           
            Integer codForne = Integer.valueOf(this.codFornecedor.getText());
            Integer status = 0; //Status "0" singifica que não foi paga, como se trata do lançamento, então não foi paga.
            String descricaoStatus = "Aberto";
            this.fornecedor.setCodigo(codForne);
            String boleto = this.numBoleto.getText();
            String observacao = this.observacaoConta.getText();
            FormaPagto formaPagto = (FormaPagto) this.formasPagto.getSelectedItem();
            SubContaResultado subContResult = (SubContaResultado) this.subContaResultado.getSelectedItem();
            Igreja igreja = (Igreja) this.igreja.getSelectedItem();
                       
            for(int i = 0; i < qtdLinhasTabela; i++){           
                int numNota  = (Integer)this.tabelaParcelas.getModel().getValueAt(i, 0);
                String descricao = (String) this.tabelaParcelas.getModel().getValueAt(i, 1);  
                int parcela = (Integer) this.tabelaParcelas.getModel().getValueAt(i, 2);
                double valorParcela = (Double) this.tabelaParcelas.getModel().getValueAt(i, 3);
                double valorPago = 0;
                double valorPendente = valorParcela;
                String StringDataVencimento = (String) this.tabelaParcelas.getModel().getValueAt(i, 4);
                Date dataVencimento = this.conversor.convertendoStringDateSql(StringDataVencimento);
            
                ContasPagar contasPagar  = new ContasPagar(this.fornecedor, parcela, numNota, status, descricaoStatus, descricao, dataVencimento, boleto, observacao, valorParcela, valorPago, valorPendente, formaPagto, subContResult, igreja);     
                
                listaContasPagar.add(contasPagar);
            }    
        }else{
            JOptionPane.showMessageDialog(null, "Para efetuar o lançamento de uma conta a pagar, tem que preencher os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);
        }      
        return listaContasPagar;
    }
    

    
    private void limparTabela(){
        if(this.tabelaParcelas.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) this.tabelaParcelas.getModel();
            model.setRowCount(0);
        }
    }
    
    private void limparFormulario(){
        codFornecedor.setText("");
        nomeFornecedor.setText("");
        numNota.setText("");
        primeiroVencimento.setText("");
        valorTotal.setText("");
        numParcela.setText("");
        numBoleto.setText("");
        observacaoConta.setText("");
        descricaoConta.setText("");
        btnGerar.setEnabled(true);
    }
    
    private boolean validarCampos(){
        
        String codForn = this.codFornecedor.getText();
        String nomeForn = this.nomeFornecedor.getText();
        String numNota = this.numNota.getText();
        String primeiroVenc = this.primeiroVencimento.getText();
        String valTotal = this.valorTotal.getText();
        String numParce = this.numParcela.getText();
        String descrConta = this.descricaoConta.getText();
        
        if(codForn.isEmpty() || nomeForn.isEmpty() || numNota.isEmpty() || primeiroVenc.isEmpty() || valTotal.isEmpty() || numParce.isEmpty() || descrConta.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    
    private void removerParcelaGerada(){
        int numLinhaSelec = this.tabelaParcelas.getSelectedRow();
        int novaParcela = 1; //Variável de controle da nova parcela após a exclusão
        String primeiroVenc = this.primeiroVencimento.getText();

        //Verifica se foi selecionado algum registro da lista
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null, "Selecione um registro para ser excluído", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(null,"Remover a parcela selecionada?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            DefaultTableModel model = (DefaultTableModel) this.tabelaParcelas.getModel();
            model.removeRow(numLinhaSelec);
        }else if(confirm == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }
               
        //Atualizando o valor e data das demais parcelas, após a remoção
        int qtdLinhaTabela = this.tabelaParcelas.getRowCount(); // Recebendo o número de linhas da tabela após a exclusão e uma das parcelas
        double valTotal = Double.parseDouble(this.valorTotal.getText().replace(",", ".")); //Recebendo o valor total, para atualizar os valores das parcelas, quando uma delas forem excluídas
        double novoValorParcela = this.conversor.arrendodarValores(valTotal/qtdLinhaTabela) ; //Calculando o novo valor das parcelas, após a exclusão
        
        //Percorrendo a tabela com base na quantidade de linhas
        for(int i=0; i<qtdLinhaTabela; i++){ 
            DefaultTableModel model = (DefaultTableModel) this.tabelaParcelas.getModel();
    
            String novoVencimento = this.conversor.somarDatas(primeiroVenc, i); //Passa a primeira data e parcela, para somar os meses.
            model.setValueAt(novaParcela, i, 2); //Alterando a parcela
            model.setValueAt(novoValorParcela, i, 3);
            model.setValueAt(novoVencimento, i, 4);
            
            novaParcela++;
        }
    } 
    
    private boolean validarContaPagarExiste(){
        Integer nota = Integer.valueOf(this.numNota.getText());
        Integer forne = Integer.valueOf(this.codFornecedor.getText());
        boolean cpExiste = this.contasPagarDao.verificarExistenciaContaPagar(nota, forne);
        
        return cpExiste;
    }
    
    @Override
    public void pessoaSelecionada(Pessoa pessoaSelecionada) {
        carregarFornecedorEscolhido(pessoaSelecionada);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGerar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField codFornecedor;
    private javax.swing.JTextField descricaoConta;
    private javax.swing.JComboBox<String> formasPagto;
    private javax.swing.JButton iconAlterar;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeFornecedor;
    private javax.swing.JTextField numBoleto;
    private javax.swing.JTextField numNota;
    private javax.swing.JTextField numParcela;
    private javax.swing.JTextField observacaoConta;
    private javax.swing.JFormattedTextField primeiroVencimento;
    private javax.swing.JComboBox<String> subContaResultado;
    private javax.swing.JTable tabelaParcelas;
    private javax.swing.JFormattedTextField valorTotal;
    // End of variables declaration//GEN-END:variables
}
