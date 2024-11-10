
package view.biblioteca;

import dao.BibliotecaDao;
import dao.IgrejaDao;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Biblioteca;
import model.Igreja;

public class CadastroBibliotecaForm extends javax.swing.JInternalFrame {

    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final BibliotecaDao bibliotecaDao = new BibliotecaDao(); 
    private List<Biblioteca> listaBiblioteca = null;
 
    public CadastroBibliotecaForm() {
        initComponents();
        formInicial();
        carregarIgrejas();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeBiblioteca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        codBiblioteca = new javax.swing.JTextField();
        igreja = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        cbxAtivo = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Bibliotecas");

        nomeBiblioteca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeBibliotecaKeyPressed(evt);
            }
        });

        jLabel1.setText("Nome Biblioteca");

        codBiblioteca.setEditable(false);
        codBiblioteca.setBackground(new java.awt.Color(204, 204, 204));
        codBiblioteca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        igreja.setToolTipText("Informe a igreja que a biblioteca pertence");

        jLabel2.setText("Igreja");

        btnSalvar.setBackground(new java.awt.Color(0, 204, 51));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        cbxAtivo.setText("Ativo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(btnSalvar))
                                .addComponent(cbxAtivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(codBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nomeBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxAtivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        cadastrarAlterarBiblioteca();
        carregarIgrejas();
        formInicial();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void nomeBibliotecaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeBibliotecaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarBiblioteca();
            carregarConsultaBiblioteca();
        } 
    }//GEN-LAST:event_nomeBibliotecaKeyPressed

    private void carregarIgrejas(){
        List<Igreja> listaIgrejas = this.igrejaDao.consultarTodasIgrejas();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.igreja.getModel();
        modelo.removeAllElements();
        for(Igreja igreja : listaIgrejas){
            modelo.addElement(igreja);
        }
    }
    
    private void cadastrarAlterarBiblioteca(){
        Biblioteca biblioteca = new Biblioteca();
        
        if(this.listaBiblioteca == null){
            String nomeBiblioteca = this.nomeBiblioteca.getText();
            Igreja igreja = (Igreja) this.igreja.getSelectedItem();

            biblioteca.setNomeBiblioteca(nomeBiblioteca);
            biblioteca.setIgreja(igreja);

            this.bibliotecaDao.cadastraBiblioteca(biblioteca);
        }else{
            Integer codBiblioteca = Integer.valueOf(this.codBiblioteca.getText());
            Integer status = 0;
            
            if(this.cbxAtivo.isSelected()){
                status = 1;
            }
            
            biblioteca.setCodigo(codBiblioteca);
            biblioteca.setStatus(status);

            this.bibliotecaDao.alterarBiblioteca(biblioteca);
        }
    }
    
    private void consultarBiblioteca(){
        
        String bibliotecaPesq = this.nomeBiblioteca.getText();  
        
        if(bibliotecaPesq != null){
            this.listaBiblioteca = bibliotecaDao.consultarBiblioteca(bibliotecaPesq);
        }else{
            JOptionPane.showMessageDialog(null, "Informe o código ou nome da biblioteca", "Atenção", JOptionPane.WARNING_MESSAGE);
        }   
    }
    
    private void carregarConsultaBiblioteca(){
        for(Biblioteca blt : this.listaBiblioteca){           
            this.codBiblioteca.setText(String.valueOf(blt.getCodigo()));
            this.nomeBiblioteca.setText(blt.getNomeBiblioteca());
            this.igreja.setSelectedItem(blt.getIgreja());  
                 
            if(blt.getStatus() == 1){
                this.cbxAtivo.setSelected(true);
                this.cbxAtivo.setEnabled(true);
            }else{
                this.cbxAtivo.setSelected(false);
                this.cbxAtivo.setEnabled(true);
            }
            
            this.nomeBiblioteca.setEditable(false);
            this.igreja.setEnabled(false);
        }
    }
    
    private void formInicial(){
        this.codBiblioteca.setText("");
        this.nomeBiblioteca.setText("");
        this.cbxAtivo.setSelected(true);
        this.cbxAtivo.setEnabled(false);
    }
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbxAtivo;
    private javax.swing.JTextField codBiblioteca;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nomeBiblioteca;
    // End of variables declaration//GEN-END:variables
}
