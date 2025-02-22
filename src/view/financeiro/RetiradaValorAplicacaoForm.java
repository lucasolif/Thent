
package view.financeiro;

import Ferramentas.Utilitarios;
import dao.AplicacaoDao;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Aplicacao;
import model.Usuario;


public class RetiradaValorAplicacaoForm extends javax.swing.JInternalFrame {

    private final AplicacaoDao aplicacaoDao = new AplicacaoDao();
    private final Utilitarios conversor = new Utilitarios();
    private Usuario usuarioLogado;

    public RetiradaValorAplicacaoForm(Usuario usuarioLogado) {
        initComponents();
        this.usuarioLogado = usuarioLogado;
        formInicial();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aplicacao = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        valorRetirada = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Retirada Valor Aplicação");

        jLabel1.setText("Aplicação");

        valorRetirada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        valorRetirada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                valorRetiradaKeyPressed(evt);
            }
        });

        jLabel2.setText("Valor (R$)");

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
                    .addComponent(jLabel1)
                    .addComponent(aplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addComponent(jLabel2)
                    .addComponent(valorRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        efetuarRetirada();
        formInicial();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void valorRetiradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorRetiradaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            if(!this.valorRetirada.getText().isEmpty()){
                efetuarRetirada();
                formInicial();
            }else{
                JOptionPane.showMessageDialog(null, "Para efetuar o resgate, é obrigatório preencher o valor.", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        } 
    }//GEN-LAST:event_valorRetiradaKeyPressed

    private void carregarAplicacoes(){
        List<Aplicacao> listaAplicacao = aplicacaoDao.consultarTodasAplicacoes(this.usuarioLogado);
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)aplicacao.getModel();
        modelo.removeAllElements();
        for(Aplicacao aplic : listaAplicacao){
            modelo.addElement(aplic);
        }
    }
    
    private void efetuarRetirada(){
        Aplicacao aplicacao = (Aplicacao) this.aplicacao.getSelectedItem();
        double valorDisponivel = aplicacaoDao.consultarValorDisponivel(aplicacao);

        if(!this.valorRetirada.getText().isEmpty()){
            
            double valorRetirada = Double.parseDouble(this.valorRetirada.getText().replace(",", "."));
            
            if(valorRetirada <= valorDisponivel){
                aplicacao.setValorRetirada(valorRetirada);
                this.aplicacaoDao.resgatarRendimento(aplicacao, usuarioLogado);
                
            }else{
                JOptionPane.showMessageDialog(null, "O valor do resgate não pode ser maior que o valor disponível. VALOR DISPONÍVEL: R$ "+valorDisponivel, "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Para efetuar o resgate, é obrigatório preencher o valor.", "Erro 012", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void formInicial(){
        this.valorRetirada.setText("");
        carregarAplicacoes();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> aplicacao;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JFormattedTextField valorRetirada;
    // End of variables declaration//GEN-END:variables
}
