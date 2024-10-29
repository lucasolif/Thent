
package view.cadastros;

import dao.FormaPagtoDao;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import model.FormaPagto;

public class FormaPagtoForm extends javax.swing.JInternalFrame {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFormaPagto = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        iconExcluir = new javax.swing.JButton();
        iconAlterar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        dados = new javax.swing.JPanel();
        codFormaPagto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        descricaoFormaPagto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Formas de Pagamento");

        buscarFormaPagto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarFormaPagtoKeyPressed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formas Pagto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaFormaPagto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tabelaFormaPagto);
        if (tabelaFormaPagto.getColumnModel().getColumnCount() > 0) {
            tabelaFormaPagto.getColumnModel().getColumn(0).setResizable(false);
            tabelaFormaPagto.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabelaFormaPagto.getColumnModel().getColumn(1).setResizable(false);
            tabelaFormaPagto.getColumnModel().getColumn(1).setPreferredWidth(250);
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

        codFormaPagto.setEditable(false);
        codFormaPagto.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setText("Código");

        jLabel1.setText("Descrição*");

        javax.swing.GroupLayout dadosLayout = new javax.swing.GroupLayout(dados);
        dados.setLayout(dadosLayout);
        dadosLayout.setHorizontalGroup(
            dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codFormaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(descricaoFormaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dadosLayout.setVerticalGroup(
            dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dadosLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dadosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descricaoFormaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadosLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codFormaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarFormaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addComponent(dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(iconExcluir)
                        .addComponent(iconAlterar))
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarFormaPagto();
        atualizarTabela();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void iconExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconExcluirActionPerformed
        excluirFormaPagto(); 
        consultarFormaPagto();
        atualizarTabela();
    }//GEN-LAST:event_iconExcluirActionPerformed

    private void iconAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconAlterarActionPerformed
        alterarFormaPagto();
    }//GEN-LAST:event_iconAlterarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvarCadastroAlteracao();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void buscarFormaPagtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarFormaPagtoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarFormaPagto();
            atualizarTabela();
        }
    }//GEN-LAST:event_buscarFormaPagtoKeyPressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        formaPagtoSelec = null;
        limparFormulario();
        limparTabela();
    }//GEN-LAST:event_btnLimparActionPerformed
     
    private void limparFormulario(){
        buscarFormaPagto.setText("");
        descricaoFormaPagto.setText("");
        codFormaPagto.setText("");
    }
    
    private void consultarFormaPagto(){  
        String textoBusca = this.buscarFormaPagto.getText();
        this.listaFormaPagto = this.formaPagtoDao.consultarFormaPagto(textoBusca);
    }
    
    private void atualizarTabela(){
        DefaultTableModel model = (DefaultTableModel) this.tabelaFormaPagto.getModel();
        model.setNumRows(0);

        for(FormaPagto pagto : this.listaFormaPagto){
            model.addRow(new Object[]{pagto.getCodigo(), pagto.getNome()});
        }
    }
    
    private void limparTabela(){
        if(tabelaFormaPagto.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) tabelaFormaPagto.getModel();
            model.setRowCount(0);
        }
    }
    
    private void salvarCadastroAlteracao(){
        String descricao = descricaoFormaPagto.getText();
        
        if(formaPagtoSelec == null){
            if(descricao.isEmpty()){
                JOptionPane.showMessageDialog(null, "Para cadastrar uma forma de pagamento, informe a descrição", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            FormaPagto formaPagto = new FormaPagto();
            formaPagto.setNome(descricao);
            formaPagtoDao.adicionar(formaPagto);
            limparFormulario();
        }else{                 
            formaPagtoSelec.setNome(descricao);
            formaPagtoDao.alterar(formaPagtoSelec);
            limparFormulario();
        }
        
        limparTabela();
        formaPagtoSelec = null;
    }
    
    private void excluirFormaPagto(){
        int numLinhaSelec = tabelaFormaPagto.getSelectedRow();
        
        //Verifica se foi selecionado algum cliente da lista
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null, "Selecione uma forma de pagamento a ser excluída", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //Recebe o a linha que foi selecionada na tabela, ou seja, o cliente
        formaPagtoSelec = listaFormaPagto.get(numLinhaSelec);
       
        int confirm = JOptionPane.showConfirmDialog(null,"Excluir a forma de pagamento "+formaPagtoSelec.getNome()+" ?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            formaPagtoDao.remover(formaPagtoSelec);
        }else if(confirm == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }            
    }
    
    private void alterarFormaPagto(){
        //Variável recebe o número da linha selecionado.
        int numLinhaSelec = tabelaFormaPagto.getSelectedRow();
        
        //Verificando se foi selecionado algum estoque
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null, "Selecione uma forma de pagamento", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
             
        formaPagtoSelec = listaFormaPagto.get(numLinhaSelec);
        
        codFormaPagto.setText(Integer.toString(formaPagtoSelec.getCodigo()));
        buscarFormaPagto.setText(formaPagtoSelec.getNome());
        descricaoFormaPagto.setText(formaPagtoSelec.getNome());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField buscarFormaPagto;
    private javax.swing.JTextField codFormaPagto;
    private javax.swing.JPanel dados;
    private javax.swing.JTextField descricaoFormaPagto;
    private javax.swing.JButton iconAlterar;
    private javax.swing.JButton iconExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaFormaPagto;
    // End of variables declaration//GEN-END:variables
}
