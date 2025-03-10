
package view.biblioteca;

import dao.AutorDao;
import dao.EditoraDao;
import dao.LivroDao;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Autor;
import model.Editora;
import model.Livro;
import view.carregamentoConsultas.TelaConsultasLivros;
import interfaces.ConsultaLivros;
import model.Usuario;


public class CadastroLivrosForm extends javax.swing.JInternalFrame implements ConsultaLivros {

    private Livro livroSelec;
    private List<Livro> listaLivro = null;
    private final LivroDao livroDao = new LivroDao();
    private final EditoraDao publicadoraDao = new EditoraDao();
    private final AutorDao autorDao = new AutorDao();

    public CadastroLivrosForm(Usuario usuarioLogado) {
        initComponents();
        carregarAutores();
        carregarPublicadoras();
        this.cbAtivo.setSelected(true);
        this.cbAtivo.setEnabled(false);
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        codLivro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nomeLivro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        anoPublicacao = new javax.swing.JTextField();
        autorLivro = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        caracteristicaLivro = new javax.swing.JTextField();
        publicadoraLivro = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        cbAtivo = new javax.swing.JCheckBox();
        btnBuscar = new javax.swing.JButton();
        adicionarEditora = new javax.swing.JButton();
        adicionarAutor = new javax.swing.JButton();
        volume = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Livro");

        jLabel1.setText("Cod Livro*");

        jLabel2.setText("Nome Livro*");

        jLabel3.setText("Volume");

        jLabel4.setText("Ano Publi*");

        autorLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                autorLivroMouseClicked(evt);
            }
        });

        jLabel5.setText("Autor*");

        jLabel6.setText("Caracteristica");

        publicadoraLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                publicadoraLivroMouseClicked(evt);
            }
        });

        jLabel7.setText("Publicadora/Editora*");

        btnSalvar.setBackground(new java.awt.Color(51, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarMouseClicked(evt);
            }
        });

        cbAtivo.setText("Ativo");

        btnBuscar.setBackground(new java.awt.Color(0, 153, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        adicionarEditora.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        adicionarEditora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adicionar.png"))); // NOI18N
        adicionarEditora.setText("Editora");
        adicionarEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarEditoraActionPerformed(evt);
            }
        });

        adicionarAutor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        adicionarAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adicionar.png"))); // NOI18N
        adicionarAutor.setText("Autor(a)");
        adicionarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarAutorActionPerformed(evt);
            }
        });

        volume.setModel(new javax.swing.SpinnerNumberModel(0, null, 20, 1));

        jLabel8.setText("Buscar");

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(adicionarEditora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adicionarAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(caracteristicaLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(publicadoraLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(codLivro)
                                                .addGap(5, 5, 5)))
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel3))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(volume, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(anoPublicacao, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(autorLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(76, 76, 76)
                                            .addComponent(nomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbAtivo))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(volume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anoPublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autorLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAtivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caracteristicaLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(publicadoraLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(adicionarEditora)
                    .addComponent(adicionarAutor))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked
        cadastrarAlterarLivro();
        formInicial();
        carregarPublicadoras();
        carregarAutores();
    }//GEN-LAST:event_btnSalvarMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarLivro();
        carregarResultadoConsultaLivros();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void adicionarEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarEditoraActionPerformed
        adicionarEditora();
    }//GEN-LAST:event_adicionarEditoraActionPerformed

    private void adicionarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarAutorActionPerformed
        adicionatAutor();
    }//GEN-LAST:event_adicionarAutorActionPerformed

    private void autorLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_autorLivroMouseClicked
        carregarAutores();
    }//GEN-LAST:event_autorLivroMouseClicked

    private void publicadoraLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_publicadoraLivroMouseClicked
        carregarPublicadoras();
    }//GEN-LAST:event_publicadoraLivroMouseClicked

    private void buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarLivro();
            carregarResultadoConsultaLivros();
        }
    }//GEN-LAST:event_buscarKeyPressed

    private void cadastrarAlterarLivro(){
        
        Integer codLivro = null;
        Integer volLivro = (Integer) this.volume.getValue();
        Integer anoPubli = Integer.valueOf(this.anoPublicacao.getText());
        String nome = this.nomeLivro.getText();
        Autor autor = (Autor) this.autorLivro.getSelectedItem();
        String caract = this.caracteristicaLivro.getText();
        Editora editora = (Editora) this.publicadoraLivro.getSelectedItem();
        Integer status = 0;
        
        if(cbAtivo.isSelected()){
            status = 1;
        }
        
        try {
            codLivro = Integer.valueOf(this.codLivro.getText());
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Para cadastrar uma livro � necess�rio informar o c�digo do livro", "Aten��o", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //Validando se um cadastro ou altera��o
        if(this.livroSelec == null){
            
            //Validando se os campos foram preenchidos corretamente.
            if(this.codLivro.getText().isEmpty() || this.anoPublicacao.getText().isEmpty() || this.nomeLivro.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Para cadastrar uma livro � necess�rio informar os campos obrigat�rios", "Aten��o", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            Livro livro = new Livro();
            livro.setAnoPublicacao(anoPubli);
            livro.setAutor(autor);
            livro.setCaracteristica(caract);
            livro.setCodLivro(codLivro);
            livro.setNomeLivro(nome);
            livro.setEditora(editora);
            livro.setVolume(volLivro);
            livro.setStatus(status);
            
            this.livroDao.cadastrarLivro(livro);               
        }else{
            this.livroSelec.setAnoPublicacao(anoPubli);
            this.livroSelec.setAutor(autor);
            this.livroSelec.setCaracteristica(caract);
            this.livroSelec.setCodLivro(codLivro);
            this.livroSelec.setNomeLivro(nome);
            this.livroSelec.setEditora(editora);
            this.livroSelec.setVolume(volLivro);
            this.livroSelec.setStatus(status);
            
            this.livroDao.alterarLivro(this.livroSelec);

            this.livroSelec = null;
        }     
    }
    
    private void formInicial(){
        this.codLivro.setText("");
        this.codLivro.setEditable(true);
        this.nomeLivro.setText("");
        this.anoPublicacao.setText("");
        this.caracteristicaLivro.setText("");
        this.cbAtivo.setEnabled(false);
        carregarAutores();
        carregarPublicadoras();
    }
    
    private void carregarAutores(){
        List<Autor> listaAutores = this.autorDao.consultarAutores();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.autorLivro.getModel();
        modelo.removeAllElements();
        for(Autor aut : listaAutores){
            modelo.addElement(aut);
        }   
    }
    
    private void carregarPublicadoras(){
        List<Editora> listaPublicadora = this.publicadoraDao.consultarEditoras();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.publicadoraLivro.getModel();
        modelo.removeAllElements();
        for(Editora editora : listaPublicadora){
            modelo.addElement(editora);
        }   
    }
    
    private void consultarLivro(){
        String consulta = this.buscar.getText();
        this.listaLivro = this.livroDao.consultarLivro(consulta);
    }
    
    private void carregarResultadoConsultaLivros(){
        TelaConsultasLivros resultConsultaLivros = new TelaConsultasLivros((Frame) SwingUtilities.getWindowAncestor(this), this.listaLivro);
        resultConsultaLivros.setLivroSelecionada(this);
        resultConsultaLivros.setLocationRelativeTo(this);
        resultConsultaLivros.setVisible(true);
    }
    
    public void carregarLivroEscolhido(Livro livro){
        this.codLivro.setText(String.valueOf(livro.getCodLivro()));
        this.nomeLivro.setText(livro.getNomeLivro());
        this.anoPublicacao.setText(String.valueOf(livro.getAnoPublicacao()));
        this.autorLivro.setSelectedItem(livro.getAutor());
        this.caracteristicaLivro.setText(livro.getCaracteristica());
        this.publicadoraLivro.setSelectedItem(livro.getEditora());
        this.cbAtivo.setEnabled(true);
        
        if(livro.getStatus() == 1){
            this.cbAtivo.setSelected(true);
        }else{
            this.cbAtivo.setSelected(false);
        }    
        
        this.livroSelec = livro;
        this.codLivro.setEditable(false);
    }
    
    private void adicionarEditora(){
        CadastroEditoraForm dialogEditora = new CadastroEditoraForm((Frame) SwingUtilities.getWindowAncestor(this), true);
        dialogEditora.setLocationRelativeTo(this);
        dialogEditora.setVisible(true);
    }
    
    private void adicionatAutor(){
        AutorForm dialogAutor = new AutorForm((Frame) SwingUtilities.getWindowAncestor(this), true);
        dialogAutor.setLocationRelativeTo(this);
        dialogAutor.setVisible(true);
    }

    @Override
    public void livroSelecionado(Livro livroSelecionado) {
        carregarLivroEscolhido(livroSelecionado);    
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarAutor;
    private javax.swing.JButton adicionarEditora;
    private javax.swing.JTextField anoPublicacao;
    private javax.swing.JComboBox<String> autorLivro;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField buscar;
    private javax.swing.JTextField caracteristicaLivro;
    private javax.swing.JCheckBox cbAtivo;
    private javax.swing.JTextField codLivro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField nomeLivro;
    private javax.swing.JComboBox<String> publicadoraLivro;
    private javax.swing.JSpinner volume;
    // End of variables declaration//GEN-END:variables


}
