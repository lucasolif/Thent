
package view.cadastros;

import dao.ContaResultadoDao;
import dao.SubContaResultadoDao;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ContaResultado;
import model.SubContaResultado;


public class SubContaResultadoForm extends javax.swing.JInternalFrame {

    private final SubContaResultadoDao subCtResultDao = new SubContaResultadoDao();
    private final ContaResultadoDao contResultDao = new ContaResultadoDao();
    private SubContaResultado subContaResultadoSelec;
    private List<SubContaResultado> listaSubContaResultado;

    public SubContaResultadoForm() {
        initComponents();
        carregarContaResultado();
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaSubContaResultado = new javax.swing.JTable();
        dados = new javax.swing.JPanel();
        codSubContaResultado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        descricaoSubContaResultado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        contaResultado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buscarSubContaResultado = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        iconExcluir = new javax.swing.JButton();
        iconAlterar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Sub Conta Resultado");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Conta de Resultados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaSubContaResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descrição", "Cont Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaSubContaResultado);
        if (tabelaSubContaResultado.getColumnModel().getColumnCount() > 0) {
            tabelaSubContaResultado.getColumnModel().getColumn(0).setResizable(false);
            tabelaSubContaResultado.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaSubContaResultado.getColumnModel().getColumn(1).setResizable(false);
            tabelaSubContaResultado.getColumnModel().getColumn(1).setPreferredWidth(250);
            tabelaSubContaResultado.getColumnModel().getColumn(2).setResizable(false);
            tabelaSubContaResultado.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        dados.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        codSubContaResultado.setEditable(false);
        codSubContaResultado.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setText("Código");

        jLabel1.setText("Descrição*");

        jLabel4.setText("Conta Resultado");

        javax.swing.GroupLayout dadosLayout = new javax.swing.GroupLayout(dados);
        dados.setLayout(dadosLayout);
        dadosLayout.setHorizontalGroup(
            dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosLayout.createSequentialGroup()
                .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(codSubContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(descricaoSubContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contaResultado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dadosLayout.setVerticalGroup(
            dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosLayout.createSequentialGroup()
                .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dadosLayout.createSequentialGroup()
                        .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(dadosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contaResultado))
                            .addGroup(dadosLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(descricaoSubContaResultado))))
                    .addGroup(dadosLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codSubContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jLabel2.setText("Buscar");

        buscarSubContaResultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarSubContaResultadoKeyPressed(evt);
            }
        });

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

        iconAlterar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        iconAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-editar-16.png"))); // NOI18N
        iconAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarSubContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(0, 154, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(buscarSubContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(iconExcluir, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(iconAlterar, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarSubContaResultadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarSubContaResultadoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarSubContaResultado();
            atualizarTabela();
        }
    }//GEN-LAST:event_buscarSubContaResultadoKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarSubContaResultado();
        atualizarTabela();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        subContaResultadoSelec = null;
        limparFormulario();
        limparTabela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvarAlteracaoCadastro();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void iconExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconExcluirActionPerformed
        excluirContaCaixa();
        consultarSubContaResultado();
        atualizarTabela();
    }//GEN-LAST:event_iconExcluirActionPerformed

    private void iconAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconAlterarActionPerformed
        alterarContaCaixa();
    }//GEN-LAST:event_iconAlterarActionPerformed

    private void limparFormulario(){
        buscarSubContaResultado.setText("");
        descricaoSubContaResultado.setText("");
        codSubContaResultado.setText("");
        carregarContaResultado();
    }
    
    private void consultarSubContaResultado(){      
        String textoBusca = buscarSubContaResultado.getText();
        listaSubContaResultado = subCtResultDao.consultarSubContaResultado(textoBusca);
    }
    
    private void atualizarTabela(){
        DefaultTableModel model = (DefaultTableModel) tabelaSubContaResultado.getModel();
        model.setNumRows(0);

        for(SubContaResultado conta : listaSubContaResultado){
            model.addRow(new Object[]{conta.getCodigo(), conta.getDescricao(), conta.getContaResultado()});
        }
    }
    
    private void limparTabela(){
        if(tabelaSubContaResultado.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) tabelaSubContaResultado.getModel();
            model.setRowCount(0);
        }
    }
    
    private void salvarAlteracaoCadastro(){
        String descricao = descricaoSubContaResultado.getText();
        ContaResultado tpContaResultado = (ContaResultado)this.contaResultado.getSelectedItem();

        if(subContaResultadoSelec == null){
            if(descricao.isEmpty()){
                JOptionPane.showMessageDialog(null, "Para cadastrar uma conta de resultado, informe a descrição", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
            SubContaResultado subContaResultado = new SubContaResultado();
            
            subContaResultado.setDescricao(descricao);
            subContaResultado.setContaResultado(tpContaResultado);           
            subCtResultDao.adicionar(subContaResultado);
            
            limparFormulario();
        }else{
            subContaResultadoSelec.setDescricao(descricao);
            subContaResultadoSelec.setContaResultado(tpContaResultado);
            subCtResultDao.alterar(subContaResultadoSelec);

            limparFormulario();
        }

        limparTabela();
        subContaResultadoSelec = null;
    }
    
    private void alterarContaCaixa(){
        //Variável recebe o número da linha selecionado.
        int numLinhaSelec = tabelaSubContaResultado.getSelectedRow();

        //Verificando se foi selecionado algum estoque
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null, "Selecione uma conta caixa", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        subContaResultadoSelec = listaSubContaResultado.get(numLinhaSelec);

        codSubContaResultado.setText(Integer.toString(subContaResultadoSelec.getCodigo()));
        descricaoSubContaResultado.setText(subContaResultadoSelec.getDescricao());
        contaResultado.setSelectedItem(subContaResultadoSelec.getContaResultado());
    }
    
    private void excluirContaCaixa(){
            int numLinhaSelec = tabelaSubContaResultado.getSelectedRow();

        //Verifica se foi selecionado algum cliente da lista
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null, "Selecione uma sub conta de resultado a ser excluída", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //Recebe o a linha que foi selecionada na tabela, ou seja, o cliente
        subContaResultadoSelec = listaSubContaResultado.get(numLinhaSelec);

        int confirm = JOptionPane.showConfirmDialog(null,"Excluir a forma de pagamento "+subContaResultadoSelec.getDescricao()+" ?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            subCtResultDao.remover(subContaResultadoSelec);
        }else if(confirm == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField buscarSubContaResultado;
    private javax.swing.JTextField codSubContaResultado;
    private javax.swing.JComboBox<String> contaResultado;
    private javax.swing.JPanel dados;
    private javax.swing.JTextField descricaoSubContaResultado;
    private javax.swing.JButton iconAlterar;
    private javax.swing.JButton iconExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaSubContaResultado;
    // End of variables declaration//GEN-END:variables
}
