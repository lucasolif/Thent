
package view.biblioteca;

import dao.EditoraDao;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Editora;


public class EditoraForm extends javax.swing.JDialog {

    Editora editoraSelec = null;
    private final EditoraDao editoraDao = new EditoraDao();
    private List<Editora> listaEditora;

    public EditoraForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editora = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codigoEditora = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEditora = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editora");

        editora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editoraKeyPressed(evt);
            }
        });

        jLabel1.setText("Editora/Publicadora");

        jLabel2.setText("Cod");

        codigoEditora.setEditable(false);
        codigoEditora.setBackground(new java.awt.Color(204, 204, 204));
        codigoEditora.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel3.setText("Buscar:");

        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarKeyPressed(evt);
            }
        });

        btnOk.setBackground(new java.awt.Color(204, 204, 204));
        btnOk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        tabelaEditora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Editora/Publicadora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
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
        tabelaEditora.setShowGrid(true);
        jScrollPane1.setViewportView(tabelaEditora);
        if (tabelaEditora.getColumnModel().getColumnCount() > 0) {
            tabelaEditora.getColumnModel().getColumn(0).setResizable(false);
            tabelaEditora.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabelaEditora.getColumnModel().getColumn(1).setResizable(false);
            tabelaEditora.getColumnModel().getColumn(1).setPreferredWidth(500);
        }

        btnSalvar.setBackground(new java.awt.Color(0, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAlterar.setBackground(new java.awt.Color(51, 153, 255));
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-editar-16.png"))); // NOI18N
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lixeira-16.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codigoEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editora, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))))
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOk))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarEditora();
            atualizarTabela();
        }
    }//GEN-LAST:event_buscarKeyPressed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        consultarEditora();
        atualizarTabela();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        cadastrarAlterarEditora();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterarEditora();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirEditora();
        consultarEditora();
        atualizarTabela();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void editoraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editoraKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        cadastrarAlterarEditora();
        }
    }//GEN-LAST:event_editoraKeyPressed

    private void consultarEditora(){        
        String textoBusca = this.buscar.getText(); // Texto digitado na busca       
        this.listaEditora = this.editoraDao.consultarEditora(textoBusca); //Lista recebe a busca retornada do banco
    }
    
    private void atualizarTabela(){
        //Adicionando os dados encontrados, dentro da tabela
        DefaultTableModel tabela = (DefaultTableModel) this.tabelaEditora.getModel();
        tabela.setNumRows(0);

        for(Editora edit : this.listaEditora){
            tabela.addRow(new Object[]{edit.getCodigo(), edit.getNome()});
        } 
    }
    
    private void cadastrarAlterarEditora(){
        String nomeEditora = this.editora.getText();
               
        if(this.editoraSelec == null){
            if(nomeEditora.isEmpty()){
                JOptionPane.showMessageDialog(null, "Para cadastrar a editora, informe o nome da mesmoa", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                Editora editora = new Editora();
                editora.setNome(nomeEditora);

                this.editoraDao.cadastrarEditoras(editora);  
                limparFormulario();
            }
        }else{  
            Integer codEditora = Integer.valueOf(this.codigoEditora.getText()); //Código da editora
            
            Editora editora = new Editora();
            editora.setCodigo(codEditora);
            editora.setNome(nomeEditora);
           
            editoraDao.alterarEditora(editora); //Chamando o método que altera os dados da editora
            limparFormulario();
        }       
        this.editoraSelec = null; //Variável de controle setada como nula, para saber se é um novo cadastro ou uma alteração
        limparTabela();
    }
    
    private void alterarEditora(){
        //Variável recebe o número da linha selecionado.
        int numLinhaSelec = this.tabelaEditora.getSelectedRow();
        
        //Verificando se foi selecionado alguma conta caixa
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null, "Selecione uma editora", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            //Objeto ContaCaixa recebe os dados que estavam na lista, ou seja, que foram selecionados
            this.editoraSelec = this.listaEditora.get(numLinhaSelec);

            this.codigoEditora.setText(Integer.toString(this.editoraSelec.getCodigo()));
            this.editora.setText(this.editoraSelec.getNome());
        }      
    }
    
    private void excluirEditora(){
        int numLinhaSelec = this.tabelaEditora.getSelectedRow();
        
        //Verifica se foi selecionado algum cliente da lista
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null, "Selecione uma editora a ser excluída", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //Recebe o a linha que foi selecionada na tabela, ou seja, a editora
        this.editoraSelec = this.listaEditora.get(numLinhaSelec);
        
        int confirm = JOptionPane.showConfirmDialog(null,"Excluir a editora "+this.editoraSelec.getNome()+" ?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            editoraDao.removerEditora(this.editoraSelec);
        }else if(confirm == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }
    }
    
    private void limparFormulario(){
        this.editora.setText("");
        this.codigoEditora.setText("");
    }
    
    private void limparTabela(){
        if(this.tabelaEditora.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) this.tabelaEditora.getModel();
            model.setRowCount(0);
        }
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField buscar;
    private javax.swing.JTextField codigoEditora;
    private javax.swing.JTextField editora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaEditora;
    // End of variables declaration//GEN-END:variables
}
