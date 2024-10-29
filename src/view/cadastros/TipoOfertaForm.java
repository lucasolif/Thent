
package view.cadastros;

import dao.TipoOfertaDao;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.TipoOferta;


public class TipoOfertaForm extends javax.swing.JInternalFrame {

    private final TipoOfertaDao tpOfertaDao = new TipoOfertaDao();
    private TipoOferta tpOfertaSelecionada;
    private List<TipoOferta> listaTpOferta;
    
    public TipoOfertaForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoBuscar = new javax.swing.JTextField();
        iconExcluir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaTipoOferta = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        codTipoOferta = new javax.swing.JTextField();
        descricaoOferta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        iconLimpar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro Tipo De Oferta");

        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoBuscarKeyPressed(evt);
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

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-editar-16.png"))); // NOI18N
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
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

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos de Oferta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaTipoOferta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaTipoOferta);
        if (tabelaTipoOferta.getColumnModel().getColumnCount() > 0) {
            tabelaTipoOferta.getColumnModel().getColumn(1).setPreferredWidth(500);
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Buscar");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        codTipoOferta.setEditable(false);
        codTipoOferta.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Descrição*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codTipoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(284, 331, Short.MAX_VALUE))
                    .addComponent(descricaoOferta))
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codTipoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descricaoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        iconLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        iconLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        iconLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(iconLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(iconExcluir, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSalvar))
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iconLimpar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    
    private void iconExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconExcluirActionPerformed
        excluirTpOferta();
        consultarTipoOferta();    
        atualizarTabela();
    }//GEN-LAST:event_iconExcluirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarTipoOferta();
        atualizarTabela();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterarTpOferta();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvarCadastroAlteracao();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void campoBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarTipoOferta();
            atualizarTabela();
        }
    }//GEN-LAST:event_campoBuscarKeyPressed

    private void iconLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconLimparActionPerformed
        tpOfertaSelecionada = null;
        limparFormulario();
        limparTabela();
    }//GEN-LAST:event_iconLimparActionPerformed

    private void limparFormulario(){
        campoBuscar.setText("");
        descricaoOferta.setText("");
        codTipoOferta.setText("");
    }
    
    private void consultarTipoOferta(){
        String textoBusca = this.campoBuscar.getText();
        this.listaTpOferta = this.tpOfertaDao.consultar(textoBusca);
    }
    
    private void atualizarTabela(){
        DefaultTableModel model = (DefaultTableModel) this.tabelaTipoOferta.getModel();
        model.setNumRows(0);
        
        for(TipoOferta tpOferta : this.listaTpOferta){
            model.addRow(new Object[]{tpOferta.getCodigo() , tpOferta.getNome()});
        }
    }
    
    private void limparTabela(){
        if(tabelaTipoOferta.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) tabelaTipoOferta.getModel();
            model.setRowCount(0);
        }
    }
    
    private void salvarCadastroAlteracao(){
        String descricao = descricaoOferta.getText();
        
        if(tpOfertaSelecionada == null){
            if(descricao.isEmpty()){
                JOptionPane.showMessageDialog(null, "Para cadastrar um tipo de oferta, informe a descrição", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            TipoOferta tpOferta = new TipoOferta();
            tpOferta.setNome(descricao);
            tpOfertaDao.adicionar(tpOferta);
            limparFormulario();
        }else{                 
            tpOfertaSelecionada.setNome(descricao);
            tpOfertaDao.alterar(tpOfertaSelecionada);
            limparFormulario();
        }
        limparTabela();
        tpOfertaSelecionada = null;
    }
    
    private void excluirTpOferta(){
        int numLinhaSelec = tabelaTipoOferta.getSelectedRow();
        
        //Verifica se foi selecionado algum cliente da lista
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null, "Selecione o tipo de oferta a ser excluída", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //Recebe o a linha que foi selecionada na tabela, ou seja, o cliente
        tpOfertaSelecionada = listaTpOferta.get(numLinhaSelec);
       
        int confirm = JOptionPane.showConfirmDialog(null,"Excluir o tipo de oferta "+tpOfertaSelecionada.getNome()+" ?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            tpOfertaDao.remover(tpOfertaSelecionada);
        }else if(confirm == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }        
    }
    
    private void alterarTpOferta(){
        //Variável recebe o número da linha selecionado.
        int numLinhaSelec = tabelaTipoOferta.getSelectedRow();
        
        //Verificando se foi selecionado algum estoque
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null, "Selecione um tipo de oferta para ser alterada", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
             
        tpOfertaSelecionada = listaTpOferta.get(numLinhaSelec);
        
        codTipoOferta.setText(Integer.toString(tpOfertaSelecionada.getCodigo()));
        campoBuscar.setText(tpOfertaSelecionada.getNome());
        descricaoOferta.setText(tpOfertaSelecionada.getNome());
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JTextField codTipoOferta;
    private javax.swing.JTextField descricaoOferta;
    private javax.swing.JButton iconExcluir;
    private javax.swing.JButton iconLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaTipoOferta;
    // End of variables declaration//GEN-END:variables
}
