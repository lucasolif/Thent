
package view.financeiro;

import dao.ContaCaixaDao;
import dao.IgrejaDao;
import dao.TransferenciaDepositoDao;
import Ferramentas.Utilitarios;
import dao.TipoOfertaDao;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.ContaCaixa;
import model.Igreja;
import model.MovimentoCaixa;
import model.Pessoa;
import model.RegistroDizimoOferta;
import model.TipoOferta;
import model.TransferenciaConta;
import model.Usuario;


public class TransferenciaContaForm extends javax.swing.JInternalFrame {

    private Usuario usuarioLogado;
    Pessoa pessoa = new Pessoa();
    Usuario usuario = new Usuario();
    private final ContaCaixaDao contaCaixaDao = new ContaCaixaDao();
    private final TipoOfertaDao tipoOfertaDao = new TipoOfertaDao();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final TransferenciaDepositoDao transfDepositoDao = new TransferenciaDepositoDao();
    private final Utilitarios conversor = new Utilitarios();
    
    public TransferenciaContaForm(Usuario usuarioLogado) {
        initComponents();
        formInicial();
        this.usuarioLogado = usuarioLogado;
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoTransferencia = new javax.swing.ButtonGroup();
        tipoDepositoTesouraria = new javax.swing.ButtonGroup();
        btnConfirmar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        valor = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        igreja = new javax.swing.JComboBox<>();
        contaCaixaEntrada = new javax.swing.JComboBox<>();
        rbSaida = new javax.swing.JRadioButton();
        contaCaixaSaida = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dataOperacao = new javax.swing.JFormattedTextField();
        rbTransferencia = new javax.swing.JRadioButton();
        rbEntrada = new javax.swing.JRadioButton();
        dpTesourariaGeral = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        complemento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rbDepositoDizimo = new javax.swing.JRadioButton();
        rbDepositoOferta = new javax.swing.JRadioButton();
        tpOferta = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Transferência de Contas");
        setPreferredSize(new java.awt.Dimension(510, 275));

        btnConfirmar.setBackground(new java.awt.Color(0, 204, 0));
        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jLabel3.setText("Valor (R$)");

        valor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel4.setText("Igreja/Campo");

        tipoTransferencia.add(rbSaida);
        rbSaida.setText("Saída");
        rbSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSaidaActionPerformed(evt);
            }
        });

        jLabel5.setText("Data Operação");

        jLabel2.setText("Conta Caixa Entrada");

        try {
            dataOperacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tipoTransferencia.add(rbTransferencia);
        rbTransferencia.setText("Transferência");
        rbTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTransferenciaActionPerformed(evt);
            }
        });

        tipoTransferencia.add(rbEntrada);
        rbEntrada.setText("Entrada");
        rbEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEntradaActionPerformed(evt);
            }
        });

        dpTesourariaGeral.setText("Deposito Tesouraria Geral");
        dpTesourariaGeral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dpTesourariaGeralMousePressed(evt);
            }
        });

        jLabel1.setText("Conta Caixa Saída");

        jLabel6.setText("Complemento");

        jLabel7.setText("Tipo Operação");

        tipoDepositoTesouraria.add(rbDepositoDizimo);
        rbDepositoDizimo.setForeground(new java.awt.Color(204, 0, 0));
        rbDepositoDizimo.setText("Deposito Dizimo");

        tipoDepositoTesouraria.add(rbDepositoOferta);
        rbDepositoOferta.setForeground(new java.awt.Color(204, 0, 0));
        rbDepositoOferta.setText("Deposito Oferta");

        jLabel8.setText("Tipo Oferta (Saída Oferta)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(contaCaixaSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(valor)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dataOperacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rbTransferencia)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rbEntrada)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rbSaida))
                                            .addComponent(jLabel7)))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(dpTesourariaGeral)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbDepositoDizimo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbDepositoOferta)))
                        .addGap(0, 62, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(contaCaixaEntrada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tpOferta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(complemento, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbTransferencia)
                            .addComponent(rbEntrada)
                            .addComponent(rbSaida))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contaCaixaSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contaCaixaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(complemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dpTesourariaGeral)
                    .addComponent(rbDepositoDizimo)
                    .addComponent(rbDepositoOferta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnConfirmar)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        efetuarOperacaoBancaria();
        formInicial();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void rbEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEntradaActionPerformed
       if(rbEntrada.isSelected()){
           this.contaCaixaSaida.setEnabled(false);
           this.contaCaixaEntrada.setEnabled(true);
       }
    }//GEN-LAST:event_rbEntradaActionPerformed

    private void rbSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSaidaActionPerformed
        if(rbSaida.isSelected()){
           this.contaCaixaEntrada.setEnabled(false);
           this.contaCaixaSaida.setEnabled(true);
       }
    }//GEN-LAST:event_rbSaidaActionPerformed

    private void rbTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTransferenciaActionPerformed
        if(rbTransferencia.isSelected()){
           this.contaCaixaEntrada.setEnabled(true);
           this.contaCaixaSaida.setEnabled(true);
       }
    }//GEN-LAST:event_rbTransferenciaActionPerformed

    private void dpTesourariaGeralMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dpTesourariaGeralMousePressed
        gerenciarCheckBoxRadioButtons();
    }//GEN-LAST:event_dpTesourariaGeralMousePressed

    private void efetuarOperacaoBancaria(){
        
        Integer dpTesouraria = 0;
        String complemento = this.complemento.getText();
        ContaCaixa cxSaida = (ContaCaixa) contaCaixaSaida.getSelectedItem();
        ContaCaixa cxEntrada = (ContaCaixa) contaCaixaEntrada.getSelectedItem();
        double valor = Double.parseDouble(this.valor.getText().replace(",", "."));
        Date dataOp = this.conversor.convertendoStringDateSql(dataOperacao.getText());
        this.pessoa.setCodigo(1);
        this.usuario.setCodigo(usuarioLogado.getCodigo());
        Igreja igreja = (Igreja) this.igreja.getSelectedItem();

       //Verifica se a movimentação é referente ao deposito da tesouraria geral
        if(this.dpTesourariaGeral.isSelected()){
            dpTesouraria = 1;
        }    

        //Definindo os valores no objeto RegistroDizimo Oferta para utilizar na movimentação do tipo de oferta.
        RegistroDizimoOferta rgDizimoOferta = new RegistroDizimoOferta();
        TipoOferta tpOferta = (TipoOferta) this.tpOferta.getSelectedItem();
        rgDizimoOferta.setTpOferta(tpOferta); 

        MovimentoCaixa mvCaixa = new MovimentoCaixa();
        TransferenciaConta transf = new TransferenciaConta();
        transf.setCxSaida(cxSaida);
        transf.setCxEntrada(cxEntrada);
        transf.setValorEntradaSaida(valor);
        transf.setPessoa(pessoa);
        transf.setDpTesourariaGeral(dpTesouraria);    
        mvCaixa.setComplemento(complemento);
        mvCaixa.setDataPagamentoRecebimento(dataOp);
        mvCaixa.setUsuarioCadastro(usuario);
        mvCaixa.setIgreja(igreja);
        mvCaixa.setTransferecia(transf);
        mvCaixa.setComplemento(complemento); 
        mvCaixa.setRgOferta(rgDizimoOferta);
                

        if(!rbTransferencia.isSelected() && !rbEntrada.isSelected() && !rbSaida.isSelected() || valor <= 0 || this.complemento.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preecha os campos corretamente", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else if(rbTransferencia.isSelected()){                     
            transfDepositoDao.realizarOperacoesBancarias(mvCaixa, 1, this.usuarioLogado);     
        }else if(rbEntrada.isSelected()){             
            transfDepositoDao.realizarOperacoesBancarias(mvCaixa, 2, this.usuarioLogado);          
        }else{         
            transfDepositoDao.realizarOperacoesBancarias(mvCaixa, 3, this.usuarioLogado);         
        }
    }
    
    private void formInicial(){
        this.valor.setText("");
        this.rbTransferencia.setSelected(true);  
        this.dpTesourariaGeral.setSelected(false);
        this.complemento.setText("");
        this.dataOperacao.setText(conversor.dataAtualString());
        this.tipoDepositoTesouraria.clearSelection();
        this.rbDepositoDizimo.setEnabled(false);
        this.rbDepositoOferta.setEnabled(false);
        this.complemento.setEditable(true);
        carregarContaCaixa();
        carregarIgrejas();
        carregarTipoOferta();
        
    }
    
    private void carregarIgrejas(){
        List<Igreja> listaIgrejas = igrejaDao.consultarTodasIgrejas();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)igreja.getModel();
        modelo.removeAllElements();
        for(Igreja igreja : listaIgrejas){
            modelo.addElement(igreja);
        }
    }
    
    private void carregarContaCaixa(){
        List<ContaCaixa> listaContaCaixa = contaCaixaDao.consultarContaCaixa();
        DefaultComboBoxModel modelo1 = (DefaultComboBoxModel)contaCaixaEntrada.getModel();
        DefaultComboBoxModel modelo2 = (DefaultComboBoxModel)contaCaixaSaida.getModel();
        
        modelo1.removeAllElements();
        modelo2.removeAllElements();
        
        for(ContaCaixa cx : listaContaCaixa){
            modelo1.addElement(cx);
            modelo2.addElement(cx);
        }
        
    }
    
    private void carregarTipoOferta(){
        List<TipoOferta> listaTpOferta = tipoOfertaDao.consultarTipoOferta();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)tpOferta.getModel();
        modelo.removeAllElements();
        for(TipoOferta tpOferta : listaTpOferta){
            modelo.addElement(tpOferta);
        }
    }
    
    private void gerenciarCheckBoxRadioButtons(){
        // Adicionando listener para o JCheckBox
        this.dpTesourariaGeral.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                boolean isSelected = e.getStateChange() == ItemEvent.SELECTED; 
                
                // Habilita ou desabilita os RadioButtons dependendo do estado do CheckBox            
                rbDepositoDizimo.setEnabled(isSelected);
                rbDepositoOferta.setEnabled(isSelected);
                rbDepositoDizimo.setFocusable(isSelected);
                rbDepositoOferta.setFocusable(isSelected);
                
                // Se o CheckBox for desmarcado, limpa o JTextField
                if (!isSelected) {
                    complemento.setText("");
                    tipoDepositoTesouraria.clearSelection(); //Limpa os RadioButtons selecionados, ao demarcar o CheckBox
                    complemento.setEditable(true);
                }else{
                    complemento.setEditable(false);
                }
                       
            }
        });
        
        // Verifiquei se o Radio Button foi selecionado
        rbDepositoDizimo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (rbDepositoDizimo.isSelected()) {
                    complemento.setText("Dizimo - Deposito Tesouraria Geral");
                    complemento.setEditable(false);
                }
            }
        });
        
        // Verifiquei se o Radio Button foi selecionado
        rbDepositoOferta.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (rbDepositoOferta.isSelected()) {
                    complemento.setText("Oferta - Deposito Tesouraria Geral");
                    complemento.setEditable(false);
                }
            }
        });
    }
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JTextField complemento;
    private javax.swing.JComboBox<String> contaCaixaEntrada;
    private javax.swing.JComboBox<String> contaCaixaSaida;
    private javax.swing.JFormattedTextField dataOperacao;
    private javax.swing.JCheckBox dpTesourariaGeral;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton rbDepositoDizimo;
    private javax.swing.JRadioButton rbDepositoOferta;
    private javax.swing.JRadioButton rbEntrada;
    private javax.swing.JRadioButton rbSaida;
    private javax.swing.JRadioButton rbTransferencia;
    private javax.swing.ButtonGroup tipoDepositoTesouraria;
    private javax.swing.ButtonGroup tipoTransferencia;
    private javax.swing.JComboBox<String> tpOferta;
    private javax.swing.JFormattedTextField valor;
    // End of variables declaration//GEN-END:variables
}
