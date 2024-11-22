
package view.biblioteca;

import dao.AutorDao;
import interfaces.ConsultaAutores;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Autor;
import view.carregamentoConsultas.TelaConsultasAutores;

public class AutorForm extends javax.swing.JDialog implements ConsultaAutores {
    
    Autor autorSelec = null;
    private final AutorDao autorDao = new AutorDao();
    private List<Autor> listaAutor;


    public AutorForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.autor.requestFocusInWindow();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        autor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codigoAutor = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autor");

        btnBuscar.setBackground(new java.awt.Color(51, 153, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lixeira-16.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        autor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                autorKeyPressed(evt);
            }
        });

        jLabel1.setText("Autor(a)");

        jLabel2.setText("Cod");

        codigoAutor.setEditable(false);
        codigoAutor.setBackground(new java.awt.Color(204, 204, 204));
        codigoAutor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        codigoAutor.setFocusable(false);

        btnSalvar.setBackground(new java.awt.Color(0, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel3.setText("Buscar:");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(autor))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        cadastrarAlterarAutor();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarAutor();
            carregarResultadoConsultaAutores();
        }
    }//GEN-LAST:event_buscarKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarAutor();
        carregarResultadoConsultaAutores();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirAutor();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void autorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_autorKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            cadastrarAlterarAutor();
        }
    }//GEN-LAST:event_autorKeyPressed

    private void consultarAutor(){        
        String textoBusca = this.buscar.getText(); // Texto digitado na busca       
        this.listaAutor = this.autorDao.consultarAutor(textoBusca); //Lista recebe a busca retornada do banco
    }
    
    private void carregarResultadoConsultaAutores(){
        TelaConsultasAutores resultConsultaAutores = new TelaConsultasAutores((Frame) SwingUtilities.getWindowAncestor(this), this.listaAutor);
        resultConsultaAutores.setAutorSelecionado(this);
        resultConsultaAutores.setLocationRelativeTo(this);
        resultConsultaAutores.setVisible(true);
    }
    
    private void carregarAutorEscolhido(Autor autor){
        this.codigoAutor.setText(String.valueOf(autor.getCodigo()));
        this.autor.setText(autor.getNome());    
        this.autorSelec = autor;
    }
    
    private void cadastrarAlterarAutor(){
        String nomeAutor = this.autor.getText();
               
        if(this.autorSelec == null){
            if(nomeAutor.isEmpty()){
                JOptionPane.showMessageDialog(null, "Para cadastrar um autor, informe o nome do mesmo", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                Autor autor = new Autor();
                autor.setNome(nomeAutor);

                this.autorDao.cadastrarAutor(autor);  
                limparFormulario();
            }
        }else{  
            Integer codAutor = Integer.valueOf(this.codigoAutor.getText()); //Código da conta caixa
            
            Autor autor = new Autor();
            autor.setCodigo(codAutor);
            autor.setNome(nomeAutor);
           
            autorDao.alterarAutor(autor); //Chamando o método que altera os dados da conta caixa
            limparFormulario();
        }       
        this.autorSelec = null; //Variável de controle setada como nula, para saber se é um novo cadastro ou uma alteração
    }
    
    private void excluirAutor(){    
        //Verifica se foi selecionado algum autor da lista
        if(this.codigoAutor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione um autor a ser excluído", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            int confirm = JOptionPane.showConfirmDialog(null,"Excluir o autor "+this.autorSelec.getNome()+" ?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                autorDao.removerAutor(this.autorSelec);
            }else if(confirm == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            }
        }
    }
    
    private void limparFormulario(){
        this.autor.setText("");
        this.codigoAutor.setText("");
    }

    @Override
    public void autorSelecionado(Autor autorSelecionado) {
        carregarAutorEscolhido(autorSelecionado);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField autor;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField buscar;
    private javax.swing.JTextField codigoAutor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables


}
