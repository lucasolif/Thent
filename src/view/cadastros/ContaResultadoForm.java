
package view.cadastros;

import dao.ContaResultadoDao;
import interfaces.ConsultaContaResultado;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.ContaResultado;
import model.UsuarioLogado;
import view.carregamentoConsultas.TelaConsultaContaResultado;

public class ContaResultadoForm extends javax.swing.JInternalFrame implements ConsultaContaResultado{

    private final ContaResultadoDao contaResultadoDao = new ContaResultadoDao();
    private ContaResultado contaResultadoSelec;
    private List<ContaResultado> listaContaResultado;
    
    public ContaResultadoForm(UsuarioLogado usuarioLogado) {
        initComponents();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        buscarContaResultado = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        iconExcluir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        codContaResultado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        descricaoContaResultado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        receitaDespesa = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("Conta de Resultado");

        jLabel2.setText("Buscar");

        buscarContaResultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarContaResultadoKeyPressed(evt);
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

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
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

        jLabel4.setText("Tipo");

        codContaResultado.setEditable(false);
        codContaResultado.setBackground(new java.awt.Color(204, 204, 204));
        codContaResultado.setFocusable(false);

        jLabel3.setText("Código");

        jLabel1.setText("Descrição*");

        receitaDespesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "R", "D" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnLimpar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(iconExcluir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSalvar))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(codContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(descricaoContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(receitaDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(buscarContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(28, 28, 28))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(codContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(descricaoContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(receitaDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalvar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(iconExcluir)
                        .addComponent(btnLimpar)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarContaResultadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarContaResultadoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarContaResultado();
            carregarResultadoConsultaContaResultado();
        }
    }//GEN-LAST:event_buscarContaResultadoKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarContaResultado();
        carregarResultadoConsultaContaResultado();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        this.contaResultadoSelec = null;
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
        this.buscarContaResultado.setText("");
        this.descricaoContaResultado.setText("");
        this.descricaoContaResultado.requestFocusInWindow();
        this.codContaResultado.setText("");
        this.receitaDespesa.setSelectedItem("R");
        this.contaResultadoSelec = null;
    }
    
    private void consultarContaResultado(){
        String textoBusca = this.buscarContaResultado.getText();
        this.listaContaResultado = this.contaResultadoDao.consultarContaResultado(textoBusca);
    }
    
    private void carregarResultadoConsultaContaResultado(){
        TelaConsultaContaResultado resultContaResultado = new TelaConsultaContaResultado((Frame) SwingUtilities.getWindowAncestor(this), this.listaContaResultado);
        resultContaResultado.setContaResultadoSelecionada(this);
        resultContaResultado.setLocationRelativeTo(this);
        resultContaResultado.setVisible(true);
    }
    
    private void carregarContaResultadoEscolhido(ContaResultado contaResultado){
        this.codContaResultado.setText(String.valueOf(contaResultado.getCodigo()));
        this.descricaoContaResultado.setText(contaResultado.getNome());  
        this.receitaDespesa.setSelectedItem(contaResultado.getTipoReceitaDespesa());
        
        this.contaResultadoSelec = contaResultado;
    }
    
    private void salvarAlteracaoCadastro(){
        String descricao = this.descricaoContaResultado.getText();
        String tpContaResultado = (String)this.receitaDespesa.getSelectedItem();

        if(this.contaResultadoSelec == null){
            if(descricao.isEmpty()){
                JOptionPane.showMessageDialog(null, "Para cadastrar uma conta de resultado, informe a descrição", "Atenção", JOptionPane.WARNING_MESSAGE);
            }else{
                ContaResultado contaResultado = new ContaResultado();
                contaResultado.setNome(descricao);
                contaResultado.setTipoReceitaDespesa(tpContaResultado);           
                this.contaResultadoDao.adicionar(contaResultado);
            }
        }else{
            this.contaResultadoSelec.setNome(descricao);
            this.contaResultadoSelec.setTipoReceitaDespesa(tpContaResultado);
            this.contaResultadoDao.alterar(this.contaResultadoSelec);
        }
        formInicial();
    }    
    
    private void excluirContaCaixa(){
        if(this.codContaResultado.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione uma conta de resultado a ser excluída", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
        int confirm = JOptionPane.showConfirmDialog(null,"Excluir a conta de resultado"+this.contaResultadoSelec.getNome().toUpperCase()+" ?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            this.contaResultadoDao.remover(this.contaResultadoSelec);
        }else if(confirm == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }
    }
    
    @Override
    public void contaResultadoSelecionada(ContaResultado contaResultadoSelecionada) {
        carregarContaResultadoEscolhido(contaResultadoSelecionada);    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField buscarContaResultado;
    private javax.swing.JTextField codContaResultado;
    private javax.swing.JTextField descricaoContaResultado;
    private javax.swing.JButton iconExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> receitaDespesa;
    // End of variables declaration//GEN-END:variables
}
