
package view.biblioteca;

import dao.AutorDao;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Autor;

public class AutorForm extends javax.swing.JDialog {
    
    Autor autorSelec = null;
    private final AutorDao autorDao = new AutorDao();
    private List<Autor> listaAutor;


    public AutorForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOk = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAutor = new javax.swing.JTable();
        autor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codigoAutor = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        buscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autor");

        btnOk.setBackground(new java.awt.Color(204, 204, 204));
        btnOk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lixeira-16.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        tabelaAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Autor(a)"
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
        tabelaAutor.setShowGrid(true);
        jScrollPane1.setViewportView(tabelaAutor);
        if (tabelaAutor.getColumnModel().getColumnCount() > 0) {
            tabelaAutor.getColumnModel().getColumn(0).setResizable(false);
            tabelaAutor.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabelaAutor.getColumnModel().getColumn(1).setResizable(false);
            tabelaAutor.getColumnModel().getColumn(1).setPreferredWidth(500);
        }

        jLabel1.setText("Autor(a)");

        jLabel2.setText("Cod");

        codigoAutor.setEditable(false);
        codigoAutor.setBackground(new java.awt.Color(204, 204, 204));
        codigoAutor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnSalvar.setBackground(new java.awt.Color(0, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel3.setText("Buscar:");

        btnAlterar.setBackground(new java.awt.Color(51, 153, 255));
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-editar-16.png"))); // NOI18N
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarKeyPressed(evt);
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
                                    .addComponent(codigoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(autor, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))))
                        .addGap(0, 48, Short.MAX_VALUE))
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
                    .addComponent(autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        cadastrarAlterarAutor();
        dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarAutor();
            atualizarTabela();
        }
    }//GEN-LAST:event_buscarKeyPressed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        consultarAutor();
        atualizarTabela();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterarAutor();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirAutor();
        consultarAutor();
        atualizarTabela();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void consultarAutor(){        
        String textoBusca = this.buscar.getText(); // Texto digitado na busca       
        this.listaAutor = this.autorDao.consultarAutor(textoBusca); //Lista recebe a busca retornada do banco
    }
    
    private void atualizarTabela(){
        //Adicionando os dados encontrados, dentro da tabela
        DefaultTableModel tabela = (DefaultTableModel) this.tabelaAutor.getModel();
        tabela.setNumRows(0);

        for(Autor aut : this.listaAutor){
            tabela.addRow(new Object[]{aut.getCodigo(), aut.getNome()});
        } 
    }
    
    private void cadastrarAlterarAutor(){
        String nomeAutor = this.autor.getText();
               
        if(this.autorSelec == null){
            if(nomeAutor.isEmpty()){
                JOptionPane.showMessageDialog(null, "Para cadastrar um autor, informe o nome do mesmo", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            Autor autor = new Autor();
            autor.setNome(nomeAutor);
           
            this.autorDao.cadastrarAutor(autor);  
            limparFormulario();
        }else{  
            Integer codAutor = Integer.valueOf(this.codigoAutor.getText()); //Código da conta caixa
            
            Autor autor = new Autor();
            autor.setCodigo(codAutor);
            autor.setNome(nomeAutor);
           
            autorDao.alterarAutor(autor); //Chamando o método que altera os dados da conta caixa
            limparFormulario();
        }
        
        this.autorSelec = null; //Variável de controle setada como nula, para saber se é um novo cadastro ou uma alteração
        limparTabela();
    }
    
    private void alterarAutor(){
        //Variável recebe o número da linha selecionado.
        int numLinhaSelec = this.tabelaAutor.getSelectedRow();
        
        //Verificando se foi selecionado alguma conta caixa
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null, "Selecione um autor", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //Objeto ContaCaixa recebe os dados que estavam na lista, ou seja, que foram selecionados
        this.autorSelec = this.listaAutor.get(numLinhaSelec);
        
        this.codigoAutor.setText(Integer.toString(this.autorSelec.getCodigo()));
        this.autor.setText(this.autorSelec.getNome());
        
        this.autorSelec = null;
    }
    
    private void excluirAutor(){
        int numLinhaSelec = this.tabelaAutor.getSelectedRow();
        
        //Verifica se foi selecionado algum cliente da lista
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null, "Selecione um autor a ser excluída", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //Recebe o a linha que foi selecionada na tabela, ou seja, a conta caixa
        this.autorSelec = this.listaAutor.get(numLinhaSelec);
        
        int confirm = JOptionPane.showConfirmDialog(null,"Excluir o autor "+this.autorSelec.getNome()+" ?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            autorDao.removerAutor(this.autorSelec);
        }else if(confirm == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }
    }
    
    private void limparFormulario(){
        this.autor.setText("");
        this.codigoAutor.setText("");
    }
    
    private void limparTabela(){
        if(tabelaAutor.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) tabelaAutor.getModel();
            model.setRowCount(0);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField autor;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField buscar;
    private javax.swing.JTextField codigoAutor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAutor;
    // End of variables declaration//GEN-END:variables
}
