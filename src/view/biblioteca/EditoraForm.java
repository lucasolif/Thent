
package view.biblioteca;

import dao.EditoraDao;
import interfaces.ConsultaEditoras;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Editora;
import view.carregamentoConsultas.TelaConsultaEditoras;



public class EditoraForm extends javax.swing.JDialog implements ConsultaEditoras{

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
        btnBuscar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
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
        codigoEditora.setFocusable(false);

        jLabel3.setText("Buscar:");

        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarKeyPressed(evt);
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

        btnSalvar.setBackground(new java.awt.Color(0, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(codigoEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(172, 172, 172))
                                .addComponent(editora)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnBuscar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarEditora();
            carregarResultadoConsultaAutores();
        }
    }//GEN-LAST:event_buscarKeyPressed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        cadastrarAlterarEditora();
        formInicial();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirEditora();
        formInicial();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void editoraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editoraKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        cadastrarAlterarEditora();
        }
    }//GEN-LAST:event_editoraKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarEditora();
        carregarResultadoConsultaAutores();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void consultarEditora(){        
        String textoBusca = this.buscar.getText(); // Texto digitado na busca       
        this.listaEditora = this.editoraDao.consultarEditora(textoBusca); //Lista recebe a busca retornada do banco
    }
    
    private void carregarResultadoConsultaAutores(){
        TelaConsultaEditoras resultConsultaEditoras = new TelaConsultaEditoras((Frame) SwingUtilities.getWindowAncestor(this), this.listaEditora);
        resultConsultaEditoras.setEditoraSelecionada(this);
        resultConsultaEditoras.setLocationRelativeTo(this);
        resultConsultaEditoras.setVisible(true);
    }
    
    private void carregarAutorEscolhido(Editora editora){
        this.codigoEditora.setText(String.valueOf(editora.getCodigo()));
        this.editora.setText(editora.getNome());    
        this.editoraSelec = editora;
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
                formInicial();
            }
        }else{  
            Integer codEditora = Integer.valueOf(this.codigoEditora.getText()); //Código da editora
            
            Editora editora = new Editora();
            editora.setCodigo(codEditora);
            editora.setNome(nomeEditora);
           
            editoraDao.alterarEditora(editora); //Chamando o método que altera os dados da editora
            formInicial();
        }       
        this.editoraSelec = null; //Variável de controle setada como nula, para saber se é um novo cadastro ou uma alteração
    }
    
    private void excluirEditora(){

        
        //Verifica se foi selecionado algum cliente da lista
        if(this.codigoEditora.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione uma editora a ser excluída", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            int confirm = JOptionPane.showConfirmDialog(null,"Excluir a editora "+this.editoraSelec.getNome()+" ?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                editoraDao.removerEditora(this.editoraSelec);
            }else if(confirm == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            }
        }
    }
    
    private void formInicial(){
        this.editora.setText("");
        this.codigoEditora.setText("");
        this.editora.requestFocusInWindow();
    }

    @Override
    public void editoraSelecionada(Editora editoraSelecionada) {
        carregarAutorEscolhido(editoraSelecionada);  
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField buscar;
    private javax.swing.JTextField codigoEditora;
    private javax.swing.JTextField editora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

}
