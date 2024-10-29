
package view.cadastros;

import dao.ContaResultadoDao;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ContaResultado;

public class ContaResultadoForm extends javax.swing.JInternalFrame {

    private final ContaResultadoDao contaResultadoDao = new ContaResultadoDao();
    private ContaResultado contaResultadoSelec;
    private List<ContaResultado> listaContaResultado;
    
    public ContaResultadoForm() {
        initComponents();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buscarContaResultado = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaContaResultado = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        iconExcluir = new javax.swing.JButton();
        iconAlterar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        dados = new javax.swing.JPanel();
        codContaResultado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        descricaoContaResultado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        receitaDespesa = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Conta de Resultado");

        buscarContaResultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarContaResultadoKeyPressed(evt);
            }
        });

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

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Conta de Resultados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaContaResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descrição", "Tipo"
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
        jScrollPane1.setViewportView(tabelaContaResultado);
        if (tabelaContaResultado.getColumnModel().getColumnCount() > 0) {
            tabelaContaResultado.getColumnModel().getColumn(0).setResizable(false);
            tabelaContaResultado.getColumnModel().getColumn(0).setPreferredWidth(130);
            tabelaContaResultado.getColumnModel().getColumn(1).setResizable(false);
            tabelaContaResultado.getColumnModel().getColumn(1).setPreferredWidth(500);
            tabelaContaResultado.getColumnModel().getColumn(2).setResizable(false);
            tabelaContaResultado.getColumnModel().getColumn(2).setPreferredWidth(80);
        }

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

        iconAlterar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        iconAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-editar-16.png"))); // NOI18N
        iconAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconAlterarActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar");

        dados.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        codContaResultado.setEditable(false);
        codContaResultado.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setText("Código");

        jLabel1.setText("Descrição*");

        receitaDespesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "R", "D" }));

        jLabel4.setText("Tipo");

        javax.swing.GroupLayout dadosLayout = new javax.swing.GroupLayout(dados);
        dados.setLayout(dadosLayout);
        dadosLayout.setHorizontalGroup(
            dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosLayout.createSequentialGroup()
                .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(codContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dadosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(descricaoContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(receitaDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        dadosLayout.setVerticalGroup(
            dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosLayout.createSequentialGroup()
                .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dadosLayout.createSequentialGroup()
                        .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descricaoContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(receitaDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dadosLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(buscarContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(iconExcluir)
                        .addComponent(iconAlterar))
                    .addComponent(btnLimpar)
                    .addComponent(btnSalvar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarContaResultadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarContaResultadoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarContaResultado();
            atualizarTabela();
        }
    }//GEN-LAST:event_buscarContaResultadoKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarContaResultado();
        atualizarTabela();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        contaResultadoSelec = null;
        limparFormulario();
        limparTabela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvarAlteracaoCadastro();                     
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void iconExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconExcluirActionPerformed
        excluirContaCaixa();
        consultarContaResultado();
        atualizarTabela();
    }//GEN-LAST:event_iconExcluirActionPerformed

    private void iconAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconAlterarActionPerformed
        alterarContaCaixa();
    }//GEN-LAST:event_iconAlterarActionPerformed

    private void limparFormulario(){
        buscarContaResultado.setText("");
        descricaoContaResultado.setText("");
        codContaResultado.setText("");
        receitaDespesa.setSelectedItem("S");
    }
    
    private void consultarContaResultado(){
        String textoBusca = this.buscarContaResultado.getText();
        this.listaContaResultado = this.contaResultadoDao.consultarContaResultado(textoBusca);
    }
    
    private void atualizarTabela(){               
        DefaultTableModel model = (DefaultTableModel) this.tabelaContaResultado.getModel();
        model.setNumRows(0);

        for(ContaResultado conta : this.listaContaResultado){
            model.addRow(new Object[]{conta.getCodigo(), conta.getNome(), conta.getTipoContaResultado()});
        }
    }
    
    private void limparTabela(){
        if(this.tabelaContaResultado.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) this.tabelaContaResultado.getModel();
            model.setRowCount(0);
        }
    }
    
    private void salvarAlteracaoCadastro(){
        String descricao = this.descricaoContaResultado.getText();
        String tpContaResultado = (String)this.receitaDespesa.getSelectedItem();

        if(this.contaResultadoSelec == null){
            if(descricao.isEmpty()){
                JOptionPane.showMessageDialog(null, "Para cadastrar uma conta de resultado, informe a descrição", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
            ContaResultado contaResultado = new ContaResultado();
            contaResultado.setNome(descricao);
            contaResultado.setTipoContaResultado((String)receitaDespesa.getSelectedItem());           
            contaResultadoDao.adicionar(contaResultado);
            
            limparFormulario();
        }else{
            contaResultadoSelec.setNome(descricao);
            contaResultadoSelec.setTipoContaResultado(tpContaResultado);
            contaResultadoDao.alterar(contaResultadoSelec);

            limparFormulario();
        }

        limparTabela();
        contaResultadoSelec = null;
    }
    
    private void alterarContaCaixa(){
        //Variável recebe o número da linha selecionado.
        int numLinhaSelec = tabelaContaResultado.getSelectedRow();

        //Verificando se foi selecionado algum estoque
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null, "Selecione uma forma de pagamento", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        contaResultadoSelec = listaContaResultado.get(numLinhaSelec);

        codContaResultado.setText(Integer.toString(contaResultadoSelec.getCodigo()));
        descricaoContaResultado.setText(contaResultadoSelec.getNome());
        receitaDespesa.setSelectedItem(contaResultadoSelec.getTipoContaResultado());
    }
    
    private void excluirContaCaixa(){
            int numLinhaSelec = tabelaContaResultado.getSelectedRow();

        //Verifica se foi selecionado algum cliente da lista
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null, "Selecione uma forma de pagamento a ser excluída", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //Recebe o a linha que foi selecionada na tabela, ou seja, o cliente
        contaResultadoSelec = listaContaResultado.get(numLinhaSelec);

        int confirm = JOptionPane.showConfirmDialog(null,"Excluir a forma de pagamento "+contaResultadoSelec.getNome()+" ?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            contaResultadoDao.remover(contaResultadoSelec);
        }else if(confirm == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField buscarContaResultado;
    private javax.swing.JTextField codContaResultado;
    private javax.swing.JPanel dados;
    private javax.swing.JTextField descricaoContaResultado;
    private javax.swing.JButton iconAlterar;
    private javax.swing.JButton iconExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> receitaDespesa;
    private javax.swing.JTable tabelaContaResultado;
    // End of variables declaration//GEN-END:variables
}
