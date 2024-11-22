
package view.cadastros;

import dao.FormaPagtoDao;
import interfaces.ConsultaFormaPagto;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.FormaPagto;
import view.carregamentoConsultas.TelaConsultaFormaPagto;

public class FormaPagtoForm extends javax.swing.JInternalFrame implements ConsultaFormaPagto{
    private final FormaPagtoDao formaPagtoDao = new FormaPagtoDao();
    private FormaPagto formaPagtoSelec;
    private List<FormaPagto> listaFormaPagto;

    public FormaPagtoForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buscarFormaPagto = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        iconExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        codFormaPagto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        descricaoFormaPagto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Formas de Pagamento");

        buscarFormaPagto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarFormaPagtoKeyPressed(evt);
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

        btnSalvar.setBackground(new java.awt.Color(51, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        iconExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        iconExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lixeira-16.png"))); // NOI18N
        iconExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconExcluirActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar");

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        codFormaPagto.setEditable(false);
        codFormaPagto.setBackground(new java.awt.Color(204, 204, 204));
        codFormaPagto.setFocusable(false);

        jLabel3.setText("Código");

        jLabel1.setText("Descrição*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnLimpar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(iconExcluir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSalvar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buscarFormaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnBuscar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(codFormaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(descricaoFormaPagto))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(buscarFormaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codFormaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descricaoFormaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(iconExcluir)
                        .addComponent(btnLimpar)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarFormaPagto();
        carregarResultadoConsultaContaCaixa();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void iconExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconExcluirActionPerformed
        excluirFormaPagto(); 
        limparFormulario();
    }//GEN-LAST:event_iconExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvarCadastroAlteracao();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void buscarFormaPagtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarFormaPagtoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarFormaPagto();
            carregarResultadoConsultaContaCaixa();
        }
    }//GEN-LAST:event_buscarFormaPagtoKeyPressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparFormulario();
    }//GEN-LAST:event_btnLimparActionPerformed
     
    private void limparFormulario(){
        buscarFormaPagto.setText("");
        descricaoFormaPagto.setText("");
        codFormaPagto.setText("");
        this.formaPagtoSelec = null;
    }
    
    private void consultarFormaPagto(){  
        String textoBusca = this.buscarFormaPagto.getText();
        this.listaFormaPagto = this.formaPagtoDao.consultarFormaPagto(textoBusca);
    }
    
    private void carregarResultadoConsultaContaCaixa(){
        TelaConsultaFormaPagto resultConsultaContaCaixa = new TelaConsultaFormaPagto((Frame) SwingUtilities.getWindowAncestor(this), this.listaFormaPagto);
        resultConsultaContaCaixa.setFormaPagtoSelecionada(this);
        resultConsultaContaCaixa.setLocationRelativeTo(this);
        resultConsultaContaCaixa.setVisible(true);
    }
    
    private void carregarFormaPagtoEscolhida(FormaPagto formaPagto){
        this.codFormaPagto.setText(String.valueOf(formaPagto.getCodigo()));
        this.descricaoFormaPagto.setText(formaPagto.getNome());  
        
        this.formaPagtoSelec = formaPagto;
    }
    
    private void salvarCadastroAlteracao(){
      
        if(this.formaPagtoSelec == null){
            if(this.descricaoFormaPagto.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Para cadastrar uma forma de pagamento, informe a descrição", "Atenção", JOptionPane.WARNING_MESSAGE);
            }else{
                FormaPagto formaPagto = new FormaPagto();
                formaPagto.setNome(this.descricaoFormaPagto.getText());
                
                this.formaPagtoDao.adicionar(formaPagto);
            } 
        }else{                 
            this.formaPagtoSelec.setNome(this.descricaoFormaPagto.getText());
            this.formaPagtoDao.alterar(this.formaPagtoSelec);
        }
        limparFormulario();
    }
    
    private void excluirFormaPagto(){

        if(this.codFormaPagto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione uma forma de pagamento a ser excluída", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            int confirm = JOptionPane.showConfirmDialog(null,"Excluir a forma de pagamento "+formaPagtoSelec.getNome()+" ?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                this.formaPagtoDao.remover(this.formaPagtoSelec);
            }else if(confirm == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            }   
        }      
    } 
    
    @Override
    public void formaPagtoSelecionada(FormaPagto formaPagtoSelecionada) {
        carregarFormaPagtoEscolhida(formaPagtoSelecionada);    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField buscarFormaPagto;
    private javax.swing.JTextField codFormaPagto;
    private javax.swing.JTextField descricaoFormaPagto;
    private javax.swing.JButton iconExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
