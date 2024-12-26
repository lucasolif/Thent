
package view.financeiro;

import dao.ContaCaixaDao;
import dao.IgrejaDao;
import dao.TransferenciaDepositoDao;
import Services.Utilitarios;
import java.awt.Dimension;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.ContaCaixa;
import model.Igreja;
import model.MovimentoCaixa;
import model.Pessoa;
import model.TransferenciaConta;
import model.Usuario;


public class TransferenciaContaForm extends javax.swing.JInternalFrame {

    Pessoa pessoa = new Pessoa();
    Usuario usuario = new Usuario();
    private final ContaCaixaDao contaCaixaDao = new ContaCaixaDao();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final TransferenciaDepositoDao transfDepositoDao = new TransferenciaDepositoDao();
    private final Utilitarios conversor = new Utilitarios();
    
    public TransferenciaContaForm() {
        initComponents();
        carregarContaCaixa();
        carregarIgrejas();
        dataOperacao.setText(conversor.dataAtualString());
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoTransferencia = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        contaCaixaEntrada = new javax.swing.JComboBox<>();
        contaCaixaSaida = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        rbTransferencia = new javax.swing.JRadioButton();
        rbDeposito = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        valor = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        igreja = new javax.swing.JComboBox<>();
        rbSaida = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        dataOperacao = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Transferência de Contas");
        setPreferredSize(new java.awt.Dimension(500, 214));

        jLabel2.setText("Conta Caixa Entrada");

        tipoTransferencia.add(rbTransferencia);
        rbTransferencia.setText("Transferência");
        rbTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTransferenciaActionPerformed(evt);
            }
        });

        tipoTransferencia.add(rbDeposito);
        rbDeposito.setText("Depósito");
        rbDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDepositoActionPerformed(evt);
            }
        });

        jLabel1.setText("Conta Caixa Saída");

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

        try {
            dataOperacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(contaCaixaSaida, 0, 181, Short.MAX_VALUE)
                            .addComponent(igreja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(contaCaixaEntrada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(dataOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(120, 120, 120)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbTransferencia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbDeposito)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbSaida))
                            .addComponent(jLabel1))
                        .addContainerGap(110, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTransferencia)
                    .addComponent(rbDeposito)
                    .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbSaida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contaCaixaSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contaCaixaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar)
                    .addComponent(dataOperacao))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        efetuarTransferencia();
        limparFormulario();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void rbDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDepositoActionPerformed
       if(rbDeposito.isSelected()){
           contaCaixaSaida.setEnabled(false);
           contaCaixaEntrada.setEnabled(true);
       }
    }//GEN-LAST:event_rbDepositoActionPerformed

    private void rbSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSaidaActionPerformed
        if(rbSaida.isSelected()){
           contaCaixaEntrada.setEnabled(false);
           contaCaixaSaida.setEnabled(true);
       }
    }//GEN-LAST:event_rbSaidaActionPerformed

    private void rbTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTransferenciaActionPerformed
        if(rbTransferencia.isSelected()){
           contaCaixaEntrada.setEnabled(true);
           contaCaixaSaida.setEnabled(true);
       }
    }//GEN-LAST:event_rbTransferenciaActionPerformed

    private void efetuarTransferencia(){
        String complemento = null;
        ContaCaixa cxSaida = (ContaCaixa) contaCaixaSaida.getSelectedItem();
        ContaCaixa cxEntrada = (ContaCaixa) contaCaixaEntrada.getSelectedItem();
        double valor = Double.parseDouble(this.valor.getText().replace(",", "."));
        Date dataOp = this.conversor.convertendoStringDateSql(dataOperacao.getText());
        this.pessoa.setCodigo(1);
        this.usuario.setCodigo(1);
        Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        
        
        TransferenciaConta transf = new TransferenciaConta(cxSaida, cxEntrada, valor, pessoa);
        MovimentoCaixa mvCaixa = new MovimentoCaixa();
        mvCaixa.setComplemento(complemento);
        mvCaixa.setDataPagamentoRecebimento(dataOp);
        mvCaixa.setUsuarioCadastro(usuario);
        mvCaixa.setIgreja(igreja);
        mvCaixa.setTransferecia(transf);
        
            
        if(!rbTransferencia.isSelected() && !rbDeposito.isSelected() && !rbSaida.isSelected() || valor <= 0){
            JOptionPane.showMessageDialog(null, "Selecione a operação", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else if(rbTransferencia.isSelected()){          
            complemento = "TRANSFERÊNCIA | "+cxSaida.getNome().toUpperCase()+" -  "+cxEntrada.getNome().toUpperCase();
            mvCaixa.setComplemento(complemento);       
            transfDepositoDao.realizarOperacoesBancarias(mvCaixa, 1);
            
        }else if(rbDeposito.isSelected()){   
            
            complemento = "DEPÓSITO | "+cxEntrada.getNome().toUpperCase();
            mvCaixa.setComplemento(complemento);          
            transfDepositoDao.realizarOperacoesBancarias(mvCaixa, 2);
            
        }else{
            
            complemento = "SAQUE | "+cxSaida.getNome().toUpperCase();
            mvCaixa.setComplemento(complemento);
            transfDepositoDao.realizarOperacoesBancarias(mvCaixa, 3);
            
        }
    }
    
    private void limparFormulario(){
        valor.setText("");
        tipoTransferencia.clearSelection();   
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> contaCaixaEntrada;
    private javax.swing.JComboBox<String> contaCaixaSaida;
    private javax.swing.JFormattedTextField dataOperacao;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbDeposito;
    private javax.swing.JRadioButton rbSaida;
    private javax.swing.JRadioButton rbTransferencia;
    private javax.swing.ButtonGroup tipoTransferencia;
    private javax.swing.JFormattedTextField valor;
    // End of variables declaration//GEN-END:variables
}
