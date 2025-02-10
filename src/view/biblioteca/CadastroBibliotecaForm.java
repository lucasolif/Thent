
package view.biblioteca;

import dao.BibliotecaDao;
import dao.IgrejaDao;
import interfaces.ConsultaBibliotecas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;
import model.Biblioteca;
import model.Igreja;
import model.UsuarioLogado;
import view.carregamentoConsultas.TelaConsultasBibliotecas;

public class CadastroBibliotecaForm extends javax.swing.JInternalFrame implements ConsultaBibliotecas{

    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final BibliotecaDao bibliotecaDao = new BibliotecaDao(); 
    private List<Biblioteca> listaBiblioteca = null;
    private Biblioteca bibliotecaSelec = null;
 
    public CadastroBibliotecaForm(UsuarioLogado usuarioLogado) {
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
        jLabel3 = new javax.swing.JLabel();
        buscarBiblioteca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Bibliotecas");

        jLabel1.setText("Nome Biblioteca");

        codBiblioteca.setEditable(false);
        codBiblioteca.setBackground(new java.awt.Color(204, 204, 204));
        codBiblioteca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        codBiblioteca.setFocusable(false);

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

        jLabel3.setText("Buscar");

        buscarBiblioteca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarBibliotecaKeyPressed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(igreja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSalvar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(codBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nomeBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbxAtivo))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(buscarBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxAtivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        cadastrarAlterarBiblioteca();
        carregarIgrejas();
        formInicial();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void buscarBibliotecaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarBibliotecaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarBiblioteca();
            carregarResultadosConsultaBiblioteca();
        } 
    }//GEN-LAST:event_buscarBibliotecaKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarBiblioteca();
        carregarResultadosConsultaBiblioteca();
    }//GEN-LAST:event_btnBuscarActionPerformed

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
        
        if(this.bibliotecaSelec == null){
            String nomeBiblioteca = this.nomeBiblioteca.getText();
            Igreja igreja = (Igreja) this.igreja.getSelectedItem();

            biblioteca.setNomeBiblioteca(nomeBiblioteca);
            biblioteca.setIgreja(igreja);

            this.bibliotecaDao.cadastraBiblioteca(biblioteca);
        }else{
            String nomeBiblioteca = this.nomeBiblioteca.getText();
            Integer codBiblioteca = Integer.valueOf(this.codBiblioteca.getText());
            Integer status = 0;          
            if(this.cbxAtivo.isSelected()){
                status = 1;
            }
            
            biblioteca.setCodigo(codBiblioteca);
            biblioteca.setStatus(status);
            biblioteca.setNomeBiblioteca(nomeBiblioteca);
            this.bibliotecaDao.alterarBiblioteca(biblioteca);
        }
      
        this.bibliotecaSelec = null;
    }
    
    private void consultarBiblioteca(){
        
        String bibliotecaPesq = this.buscarBiblioteca.getText();  
        this.listaBiblioteca = bibliotecaDao.consultarBiblioteca(bibliotecaPesq);
     
    }
    
    private void carregarResultadosConsultaBiblioteca(){
        TelaConsultasBibliotecas resultConsultaBibliotecas = new TelaConsultasBibliotecas((Frame) SwingUtilities.getWindowAncestor(this), this.listaBiblioteca);
        resultConsultaBibliotecas.setBibliotecaEscolhida(this);
        resultConsultaBibliotecas.setLocationRelativeTo(this);
        resultConsultaBibliotecas.setVisible(true);
    }
    
    public void carregarBibliotecaEscolhida(Biblioteca biblioteca){
        this.codBiblioteca.setText(String.valueOf(biblioteca.getCodigo()));
        this.nomeBiblioteca.setText(biblioteca.getNomeBiblioteca());    
        this.bibliotecaSelec = biblioteca;
    }
    
    private void formInicial(){
        this.nomeBiblioteca.requestFocusInWindow();
        this.codBiblioteca.setText("");
        this.nomeBiblioteca.setText("");
        this.cbxAtivo.setSelected(true);
        this.cbxAtivo.setEnabled(false);
    }
    
    @Override
    public void bibliotecaSelecionada(Biblioteca bibliotecaSelecionada) {
        carregarBibliotecaEscolhida(bibliotecaSelecionada);
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField buscarBiblioteca;
    private javax.swing.JCheckBox cbxAtivo;
    private javax.swing.JTextField codBiblioteca;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nomeBiblioteca;
    // End of variables declaration//GEN-END:variables


}
