
package view.campanhas;

import dao.TipoCampanhaDao;
import ferramentas.PaletaCores;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.TipoCampanha;


public class TipoCampanhaForm extends javax.swing.JInternalFrame {

    PaletaCores cores = new PaletaCores();
    TipoCampanhaDao tpCampanhaDao = new TipoCampanhaDao();
    TipoCampanha tpCampanhaSelec = null;

    public TipoCampanhaForm() {
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

        codigoCampanha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nomeCampanha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbAtivo = new javax.swing.JCheckBox();
        btnSalvar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Tipos de Campanha");
        setToolTipText("Tela para cadastrar tipos de campanhas");
        setNextFocusableComponent(nomeCampanha);

        codigoCampanha.setEditable(false);
        codigoCampanha.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Código");

        nomeCampanha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeCampanhaKeyPressed(evt);
            }
        });

        jLabel2.setText("Nome");

        cbAtivo.setSelected(true);
        cbAtivo.setText("Ativo");
        cbAtivo.setEnabled(false);

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
                            .addComponent(codigoCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(nomeCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbAtivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAtivo)
                    .addComponent(btnSalvar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        cadastrarAlterarTipoCampanha();
        formInicial();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void nomeCampanhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeCampanhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){      
            consultarTipoCampanha();
            carregarFormTipoCampanha();
        }
    }//GEN-LAST:event_nomeCampanhaKeyPressed

    private void formInicial(){
        this.codigoCampanha.setText("");
        this.nomeCampanha.setText("");
        this.cbAtivo.setSelected(true);
        this.cbAtivo.setEnabled(false);
    }
    
    private void consultarTipoCampanha(){
        if(this.nomeCampanha.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Para consutar é preciso informar o código do tipo da campanha", "Erro 001", JOptionPane.WARNING_MESSAGE);
        }else{  
            Integer codCampanha = Integer.valueOf(this.nomeCampanha.getText());
            this.tpCampanhaSelec = this.tpCampanhaDao.consultarTipoCampanha(codCampanha);
        } 
    }
    
    private void carregarFormTipoCampanha(){  
        String nomeCampanha = this.tpCampanhaSelec.getNome();
        String codCampanha = String.valueOf(this.tpCampanhaSelec.getCodigo());

        this.cbAtivo.setEnabled(true);
        this.nomeCampanha.setEditable(false);
        this.nomeCampanha.setBackground(cores.CorCinza());
        this.codigoCampanha.setText(codCampanha);
        this.nomeCampanha.setText(nomeCampanha);
        if(this.tpCampanhaSelec.getStatus() == 1){
            this.cbAtivo.setSelected(true);
        }else{
            this.cbAtivo.setSelected(false);
        }     
    }
    
    private void cadastrarAlterarTipoCampanha(){
        
        if(this.tpCampanhaSelec == null){
            if(this.nomeCampanha.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informa o nome da campanha para cadastrar.", "Warning", JOptionPane.WARNING_MESSAGE);
            }else{
                String nomeCampanha = this.nomeCampanha.getText();
                TipoCampanha tpCampanha = new TipoCampanha();
                tpCampanha.setNome(nomeCampanha);
                tpCampanha.setStatus(1);
                
                this.tpCampanhaDao.cadastrarTipoCampanha(tpCampanha);
            }
        }else{
            Integer codCampanha = Integer.valueOf(this.codigoCampanha.getText());
            String nomeCampanha = this.nomeCampanha.getText();
            Integer status = 0;
            if(this.cbAtivo.isSelected()){
                status = 1;
             }

            this.tpCampanhaSelec.setCodigo(codCampanha);
            this.tpCampanhaSelec.setNome(nomeCampanha);
            this.tpCampanhaSelec.setStatus(status);           
            this.tpCampanhaDao.alterarTipoCampanha(this.tpCampanhaSelec);    
            
            this.tpCampanhaSelec = null;
        }   
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbAtivo;
    private javax.swing.JTextField codigoCampanha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nomeCampanha;
    // End of variables declaration//GEN-END:variables
}
