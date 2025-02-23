
package view.cadastros;

import dao.ContaCaixaDao;
import dao.IgrejaDao;
import dao.UsuarioDao;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.ContaCaixa;
import view.carregamentoConsultas.TelaConsultaContaCaixa;
import interfaces.ConsultaContaCaixa;
import javax.swing.DefaultComboBoxModel;
import model.Igreja;
import model.Usuario;


public class ContaCaixaForm extends javax.swing.JInternalFrame implements ConsultaContaCaixa{

    private final ContaCaixaDao contaCaixaDao = new ContaCaixaDao();
    private ContaCaixa contaCaixaSelec;
    private List<ContaCaixa> listaContaCaixa = null;
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final UsuarioDao usuarioDao = new UsuarioDao();
    private String filtroIgreja = "";
    

    public ContaCaixaForm(Usuario usuarioLogado) {
        initComponents();
        this.filtroIgreja = usuarioDao.gerarFiltroIgreja(usuarioLogado);
        
        formInicial();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoBusca = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        iconExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        codContaCaixa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        descricaoContaCaixa = new javax.swing.JTextField();
        cbAtivo = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        igreja = new javax.swing.JComboBox<>();
        constaRelatorioMensal = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Contas Caixa");

        campoBusca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        campoBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoBuscaKeyPressed(evt);
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

        iconExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lixeira-16.png"))); // NOI18N
        iconExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconExcluirActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar");

        codContaCaixa.setEditable(false);
        codContaCaixa.setBackground(new java.awt.Color(204, 204, 204));
        codContaCaixa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        codContaCaixa.setFocusable(false);

        jLabel5.setText("Código");

        btnSalvar.setBackground(new java.awt.Color(0, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel1.setText("Descrição*");

        btnBuscar.setBackground(new java.awt.Color(51, 153, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cbAtivo.setText("Ativo");

        jLabel3.setText("Igreja");

        constaRelatorioMensal.setText("Consta Relatório Mensal?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(codContaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(descricaoContaCaixa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbAtivo))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(constaRelatorioMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 161, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codContaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descricaoContaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAtivo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(constaRelatorioMensal))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLimpar)
                            .addComponent(iconExcluir)))
                    .addComponent(btnSalvar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    
    private void iconExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconExcluirActionPerformed
        excluirContaCaixa();
        formInicial();
    }//GEN-LAST:event_iconExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvarAlteracaoCadastroContaCaixa();  
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarContaCaixa();
        carregarResultadoConsultaContaCaixa();
        formAlteracao();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void campoBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarContaCaixa();
            carregarResultadoConsultaContaCaixa();
            formAlteracao();
        }
    }//GEN-LAST:event_campoBuscaKeyPressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        formInicial();
    }//GEN-LAST:event_btnLimparActionPerformed
    
    private void formInicial(){
        this.campoBusca.setText("");
        this.igreja.setEnabled(true);
        this.descricaoContaCaixa.setText("");
        this.descricaoContaCaixa.requestFocusInWindow();
        this.codContaCaixa.setText("");
        this.cbAtivo.setSelected(true);
        this.cbAtivo.setEnabled(false);
        this.contaCaixaSelec = null;
        this.constaRelatorioMensal.setSelected(false);
        carregarIgreja();    
    }
    
    private void formAlteracao(){
        this.cbAtivo.setEnabled(true);
        this.igreja.setEnabled(false);
    }
    
    private void consultarContaCaixa(){        
        String textoBusca = this.campoBusca.getText(); // Texto digitado na busca       
        this.listaContaCaixa = this.contaCaixaDao.consultar(textoBusca, this.filtroIgreja); //Lista recebe a busca retornada do banco
    }
    
    private void carregarIgreja(){
        List<Igreja> listaIgrejas = this.igrejaDao.consultarTodasIgrejas(this.filtroIgreja);
        DefaultComboBoxModel igreja = (DefaultComboBoxModel)this.igreja.getModel();
        igreja.removeAllElements();
        for(Igreja igre : listaIgrejas){
            igreja.addElement(igre);
        }
    }
    
    private void carregarResultadoConsultaContaCaixa(){
        TelaConsultaContaCaixa resultConsultaContaCaixa = new TelaConsultaContaCaixa((Frame) SwingUtilities.getWindowAncestor(this), this.listaContaCaixa);
        resultConsultaContaCaixa.setContaCaixaSelecionada(this);
        resultConsultaContaCaixa.setLocationRelativeTo(this);
        resultConsultaContaCaixa.setVisible(true);
    }
    
    private void carregarContaCaixaEscolhida(ContaCaixa contaCaixa){
        this.codContaCaixa.setText(String.valueOf(contaCaixa.getCodigo()));
        this.descricaoContaCaixa.setText(contaCaixa.getNome());  
        this.igreja.setSelectedItem(contaCaixa.getIgreja());
        if(contaCaixa.getStatus() == 1){
            this.cbAtivo.setSelected(true);
        }else{
            this.cbAtivo.setSelected(false);
        }
        
        if(contaCaixa.getConstaRelatorio() == 1){
            this.constaRelatorioMensal.setSelected(true);
        }
        
        this.contaCaixaSelec = contaCaixa;
    }
 
    private void salvarAlteracaoCadastroContaCaixa(){
               
        if(contaCaixaSelec == null){
            if(this.descricaoContaCaixa.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Para cadastrar uma conta caixa, informe a descrição", "Atenção", JOptionPane.WARNING_MESSAGE);
            }else{
                Integer constaRelatorio = 0;
                if(this.constaRelatorioMensal.isSelected()){
                    constaRelatorio = 1;
                }
                Igreja igreja = (Igreja) this.igreja.getSelectedItem();
                ContaCaixa contaCaixa = new ContaCaixa();             
                contaCaixa.setNome(this.descricaoContaCaixa.getText());
                contaCaixa.setStatus(1);
                contaCaixa.setIgreja(igreja);    
                contaCaixa.setConstaRelatorio(constaRelatorio);

                this.contaCaixaDao.adicionar(contaCaixa);  
                formInicial();
            }       
        }else{  
            Integer constaRelatorio = 0;
            if(this.constaRelatorioMensal.isSelected()){
                constaRelatorio = 1;
            }
            ContaCaixa contaCaixa = new ContaCaixa();
            contaCaixa.setCodigo(Integer.valueOf(this.codContaCaixa.getText()));
            contaCaixa.setNome(this.descricaoContaCaixa.getText());
            contaCaixa.setConstaRelatorio(constaRelatorio);
            if(this.cbAtivo.isSelected()){
                contaCaixa.setStatus(1);
            }else{
                contaCaixa.setStatus(0);
            }
                 
            contaCaixaDao.alterar(contaCaixa); 
            formInicial();
        }    
    }  
    
    private void excluirContaCaixa(){
        
        if(this.codContaCaixa.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione uma conta caixa a ser excluída", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            int confirm = JOptionPane.showConfirmDialog(null,"Excluir a conta caixa "+contaCaixaSelec.getNome().toUpperCase()+" ?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                this.contaCaixaDao.remover( this.contaCaixaSelec);
            }else if(confirm == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            } 
        }
    }
    
    @Override
    public void contaCaixaSelecionada(ContaCaixa contaCaixaSelecionada) {
        carregarContaCaixaEscolhida(contaCaixaSelecionada);    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField campoBusca;
    private javax.swing.JCheckBox cbAtivo;
    private javax.swing.JTextField codContaCaixa;
    private javax.swing.JCheckBox constaRelatorioMensal;
    private javax.swing.JTextField descricaoContaCaixa;
    private javax.swing.JButton iconExcluir;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables


}
