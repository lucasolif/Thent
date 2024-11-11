
package view.cadastros;

import dao.ContaCaixaDao;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import model.ContaCaixa;


public class ContaCaixaForm extends javax.swing.JInternalFrame {

    private final ContaCaixaDao contaCaixaDao = new ContaCaixaDao();
    private ContaCaixa contaCaixaSelecionada;
    private List<ContaCaixa> listaContaCaixa;

    public ContaCaixaForm() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        campoBusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaContaCaixa = new javax.swing.JTable();
        iconExcluir = new javax.swing.JButton();
        iconAlterar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        dados = new javax.swing.JPanel();
        codContaCaixa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        descricaoContaCaixa = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Contas Caixa");

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnSalvar.setBackground(new java.awt.Color(51, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        campoBusca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        campoBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoBuscaKeyPressed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Contas Caixa", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaContaCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descrição"
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
        jScrollPane1.setViewportView(tabelaContaCaixa);
        if (tabelaContaCaixa.getColumnModel().getColumnCount() > 0) {
            tabelaContaCaixa.getColumnModel().getColumn(0).setResizable(false);
            tabelaContaCaixa.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabelaContaCaixa.getColumnModel().getColumn(1).setResizable(false);
            tabelaContaCaixa.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        iconExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lixeira-16.png"))); // NOI18N
        iconExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconExcluirActionPerformed(evt);
            }
        });

        iconAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-editar-16.png"))); // NOI18N
        iconAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconAlterarActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar");

        dados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        codContaCaixa.setEditable(false);
        codContaCaixa.setBackground(new java.awt.Color(204, 204, 204));
        codContaCaixa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel5.setText("Código");

        jLabel1.setText("Descrição*");

        javax.swing.GroupLayout dadosLayout = new javax.swing.GroupLayout(dados);
        dados.setLayout(dadosLayout);
        dadosLayout.setHorizontalGroup(
            dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(codContaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(descricaoContaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dadosLayout.setVerticalGroup(
            dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosLayout.createSequentialGroup()
                .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descricaoContaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codContaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addComponent(dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar)
                    .addComponent(iconAlterar)
                    .addComponent(iconExcluir))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    
    private void iconExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconExcluirActionPerformed
        excluirContaCaixa();
        consultarContaCaixa();
        atualizarTabela();
    }//GEN-LAST:event_iconExcluirActionPerformed

    private void iconAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconAlterarActionPerformed
        alteraContaCaixa();
    }//GEN-LAST:event_iconAlterarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvarAlteracaoCadastroContaCaixa();  
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarContaCaixa();
        atualizarTabela();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void campoBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarContaCaixa();
            atualizarTabela();
        }
    }//GEN-LAST:event_campoBuscaKeyPressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        contaCaixaSelecionada = null;
        limparFormulario();
        limparTabela();
    }//GEN-LAST:event_btnLimparActionPerformed
    
    private void limparFormulario(){
        this.campoBusca.setText("");
        this.descricaoContaCaixa.setText("");
        this.codContaCaixa.setText("");
    }
    
    private void consultarContaCaixa(){        
        String textoBusca = this.campoBusca.getText(); // Texto digitado na busca       
        this.listaContaCaixa = this.contaCaixaDao.consultar(textoBusca); //Lista recebe a busca retornada do banco
    }
    
    private void atualizarTabela(){
        
        //Adicionando os dados encontrados, dentro da tabela
        DefaultTableModel tabela = (DefaultTableModel) this.tabelaContaCaixa.getModel();
        tabela.setNumRows(0);

        for(ContaCaixa caixa : this.listaContaCaixa){
            tabela.addRow(new Object[]{caixa.getCodigo(), caixa.getNome()});
        } 
    }
    
    private void limparTabela(){
        if(tabelaContaCaixa.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) tabelaContaCaixa.getModel();
            model.setRowCount(0);
        }
    }
    
    private void salvarAlteracaoCadastroContaCaixa(){
        String descricao = this.descricaoContaCaixa.getText();
               
        if(contaCaixaSelecionada == null){
            if(descricao.isEmpty()){
                JOptionPane.showMessageDialog(null, "Para cadastrar uma conta caixa, informe a descrição", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            ContaCaixa contaCaixa = new ContaCaixa();
            contaCaixa.setNome(descricao);

            
            contaCaixaDao.adicionar(contaCaixa);  
            limparFormulario();
        }else{  
            int codConta = Integer.parseInt(this.codContaCaixa.getText()); //Código da conta caixa
            ContaCaixa contaCaixaSelecionada = new ContaCaixa(descricao, codConta);
           
            contaCaixaDao.alterar(contaCaixaSelecionada); //Chamando o método que altera os dados da conta caixa
            limparFormulario();
        }
        
        contaCaixaSelecionada = null; //Variável de controle setada como nula, para saber se é um novo cadastro ou uma alteração
        limparTabela();
    }
    
    private void alteraContaCaixa(){
        //Variável recebe o número da linha selecionado.
        int numLinhaSelec = tabelaContaCaixa.getSelectedRow();
        
        //Verificando se foi selecionado alguma conta caixa
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null, "Selecione uma conta caixa", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //Objeto ContaCaixa recebe os dados que estavam na lista, ou seja, que foram selecionados
        contaCaixaSelecionada = listaContaCaixa.get(numLinhaSelec);
        
        codContaCaixa.setText(Integer.toString(contaCaixaSelecionada.getCodigo()));
        descricaoContaCaixa.setText(contaCaixaSelecionada.getNome());
    }
    
    private void excluirContaCaixa(){
        int numLinhaSelec = tabelaContaCaixa.getSelectedRow();
        
        //Verifica se foi selecionado algum cliente da lista
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null, "Selecione uma conta caixa a ser excluída", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //Recebe o a linha que foi selecionada na tabela, ou seja, a conta caixa
        contaCaixaSelecionada = listaContaCaixa.get(numLinhaSelec);
        
        int confirm = JOptionPane.showConfirmDialog(null,"Excluir a conta caixa "+contaCaixaSelecionada.getNome()+" ?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            contaCaixaDao.remover(contaCaixaSelecionada);
        }else if(confirm == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField campoBusca;
    private javax.swing.JTextField codContaCaixa;
    private javax.swing.JPanel dados;
    private javax.swing.JTextField descricaoContaCaixa;
    private javax.swing.JButton iconAlterar;
    private javax.swing.JButton iconExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaContaCaixa;
    // End of variables declaration//GEN-END:variables
}
