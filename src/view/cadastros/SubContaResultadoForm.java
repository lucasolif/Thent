
package view.cadastros;

import dao.ContaResultadoDao;
import dao.SubContaResultadoDao;
import interfaces.ConsultaSubContaResultado;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.ContaResultado;
import model.SubContaResultado;
import model.Usuario;
import view.carregamentoConsultas.TelaConsultaSubContaResultado;


public class SubContaResultadoForm extends javax.swing.JInternalFrame implements ConsultaSubContaResultado{

    private final SubContaResultadoDao subCtResultDao = new SubContaResultadoDao();
    private final ContaResultadoDao contResultDao = new ContaResultadoDao();
    private SubContaResultado subContaResultadoSelec = null;
    private List<SubContaResultado> listaSubContaResultado = null;

    public SubContaResultadoForm(Usuario usuarioLogado) {
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

        jLabel2 = new javax.swing.JLabel();
        buscarSubContaResultado = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        iconExcluir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        descricaoSubContaResultado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        contaResultado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        codSubContaResultado = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Sub Conta Resultado");

        jLabel2.setText("Buscar");

        buscarSubContaResultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarSubContaResultadoKeyPressed(evt);
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

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
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

        jLabel3.setText("Código");

        jLabel1.setText("Descrição*");

        jLabel4.setText("Conta Resultado");

        codSubContaResultado.setEditable(false);
        codSubContaResultado.setBackground(new java.awt.Color(204, 204, 204));
        codSubContaResultado.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(contaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iconExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvar)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarSubContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(codSubContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(211, 239, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(descricaoSubContaResultado)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(buscarSubContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(descricaoSubContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codSubContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(iconExcluir, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarSubContaResultadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarSubContaResultadoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarSubContaResultado();
            carregarResultadoConsultaSubContaResultado();
        }
    }//GEN-LAST:event_buscarSubContaResultadoKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarSubContaResultado();
        carregarResultadoConsultaSubContaResultado();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        formInicial();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvarAlteracaoCadastro();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void iconExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconExcluirActionPerformed
        excluirContaCaixa();
        formInicial();
    }//GEN-LAST:event_iconExcluirActionPerformed

    private void formInicial(){
        this.buscarSubContaResultado.setText("");
        this.descricaoSubContaResultado.setText("");
        this.descricaoSubContaResultado.requestFocusInWindow();
        this.codSubContaResultado.setText("");
        this.subContaResultadoSelec = null;
        carregarContaResultado();
    }
    
    private void consultarSubContaResultado(){      
        String textoBusca = buscarSubContaResultado.getText();
        listaSubContaResultado = subCtResultDao.consultarSubContaResultado(textoBusca);
    }
    
    private void carregarResultadoConsultaSubContaResultado(){
        TelaConsultaSubContaResultado resultContaResultado = new TelaConsultaSubContaResultado((Frame) SwingUtilities.getWindowAncestor(this), this.listaSubContaResultado);
        resultContaResultado.setSubContaResultadoSelecionada(this);
        resultContaResultado.setLocationRelativeTo(this);
        resultContaResultado.setVisible(true);
    }
    
    private void carregarSubContaResultadoEscolhido(SubContaResultado subContaResultado){
        this.codSubContaResultado.setText(String.valueOf(subContaResultado.getCodigo()));
        this.descricaoSubContaResultado.setText(subContaResultado.getDescricao());  
        this.contaResultado.setSelectedItem(subContaResultado.getContaResultado());
        
        this.subContaResultadoSelec = subContaResultado;
    }

    private void salvarAlteracaoCadastro(){
        String descricao = descricaoSubContaResultado.getText();
        ContaResultado tpContaResultado = (ContaResultado)this.contaResultado.getSelectedItem();

        if(this.subContaResultadoSelec == null){
            if(descricao.isEmpty()){
                JOptionPane.showMessageDialog(null, "Para cadastrar uma sub conta de resultado, informe a descrição", "Atenção", JOptionPane.WARNING_MESSAGE);
            }else{
                SubContaResultado subContaResultado = new SubContaResultado();

                subContaResultado.setDescricao(descricao);
                subContaResultado.setContaResultado(tpContaResultado);           
                this.subCtResultDao.adicionar(subContaResultado);
            }
            formInicial();
        }else{
            this.subContaResultadoSelec.setDescricao(descricao);
            this.subContaResultadoSelec.setContaResultado(tpContaResultado);
            this.subCtResultDao.alterar(this.subContaResultadoSelec);
            formInicial();
        }
    }
    
    private void excluirContaCaixa(){
        if(this.codSubContaResultado.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione uma sub conta de resultado a ser excluída", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            int confirm = JOptionPane.showConfirmDialog(null,"Excluir a sub conta de resultado "+this.subContaResultadoSelec.getDescricao().toUpperCase()+" ?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                this.subCtResultDao.remover(this.subContaResultadoSelec);
            }else if(confirm == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            }
        }    
    }
    
    private void carregarContaResultado(){
        List<ContaResultado> listaContaResultado = contResultDao.consultarContaResultado();
        
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)contaResultado.getModel();
        modelo.removeAllElements();
        for(ContaResultado cr : listaContaResultado){
            modelo.addElement(cr);
        }
    }
    
    @Override
    public void subContaResultadoSelecionada(SubContaResultado subContaResultadoSelecionada) {
        carregarSubContaResultadoEscolhido(subContaResultadoSelecionada);    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField buscarSubContaResultado;
    private javax.swing.JTextField codSubContaResultado;
    private javax.swing.JComboBox<String> contaResultado;
    private javax.swing.JTextField descricaoSubContaResultado;
    private javax.swing.JButton iconExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
