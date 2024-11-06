
package view.biblioteca;

import dao.AutorDao;
import dao.BibliotecaDao;
import dao.EditoraDao;
import dao.IgrejaDao;
import dao.LivroDao;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Autor;
import model.Biblioteca;
import model.Editora;
import model.Igreja;
import model.Livro;


public class BibliotecaForm extends javax.swing.JInternalFrame {

    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final LivroDao livroDao = new LivroDao();
    private final AutorDao autorDao = new AutorDao();
    private final EditoraDao editoraDao = new EditoraDao();
    private final BibliotecaDao bibliotecaDao = new BibliotecaDao();
    private List<Biblioteca> listaBiblioteca = new ArrayList();
    private Livro livroSelec = new Livro();
    private Biblioteca biblioteca = new Biblioteca();
    private Biblioteca bibliotecaSelec;
    

    public BibliotecaForm() {
        initComponents();
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbGrupoStatus = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textoBusca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        livro = new javax.swing.JComboBox<>();
        autor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        editora = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        rbAtivo = new javax.swing.JRadioButton();
        rbInativo = new javax.swing.JRadioButton();
        rbAtivoInativo = new javax.swing.JRadioButton();
        igreja = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        volume = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLivros = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        adicionarLivro = new javax.swing.JButton();
        emprestar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Biblioteca");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtros", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setText("Busca Livre:");

        textoBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoBuscaKeyPressed(evt);
            }
        });

        jLabel2.setText("Livro");

        livro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                livroMousePressed(evt);
            }
        });
        livro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                livroKeyPressed(evt);
            }
        });

        autor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                autorMousePressed(evt);
            }
        });
        autor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                autorKeyPressed(evt);
            }
        });

        jLabel3.setText("Autor(a)");

        jLabel4.setText("Volume");

        jLabel5.setText("Editora/Publicadora");

        editora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editoraMousePressed(evt);
            }
        });
        editora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editoraKeyPressed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Status", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        rbGrupoStatus.add(rbAtivo);
        rbAtivo.setSelected(true);
        rbAtivo.setText("Ativo");

        rbGrupoStatus.add(rbInativo);
        rbInativo.setText("Inativo");

        rbGrupoStatus.add(rbAtivoInativo);
        rbAtivoInativo.setText("Ativo e Inativo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rbAtivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbInativo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbAtivoInativo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAtivo)
                    .addComponent(rbInativo)
                    .addComponent(rbAtivoInativo))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        igreja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                igrejaMousePressed(evt);
            }
        });
        igreja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                igrejaKeyPressed(evt);
            }
        });

        jLabel6.setText("Blbioteca Igreja");

        btnFiltrar.setBackground(new java.awt.Color(51, 102, 255));
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        volume.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(editora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(livro, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(autor, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(45, 45, 45))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(volume)
                                        .addGap(6, 6, 6))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(igreja, 0, 205, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnFiltrar)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(livro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(volume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnFiltrar))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Livros Biblioteca", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod Livro", "Livro", "Vol.", "Autor(a)", "Qtd.", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaLivros);
        if (tabelaLivros.getColumnModel().getColumnCount() > 0) {
            tabelaLivros.getColumnModel().getColumn(0).setResizable(false);
            tabelaLivros.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaLivros.getColumnModel().getColumn(1).setResizable(false);
            tabelaLivros.getColumnModel().getColumn(1).setPreferredWidth(250);
            tabelaLivros.getColumnModel().getColumn(2).setResizable(false);
            tabelaLivros.getColumnModel().getColumn(2).setPreferredWidth(20);
            tabelaLivros.getColumnModel().getColumn(3).setResizable(false);
            tabelaLivros.getColumnModel().getColumn(3).setPreferredWidth(250);
            tabelaLivros.getColumnModel().getColumn(4).setResizable(false);
            tabelaLivros.getColumnModel().getColumn(4).setPreferredWidth(20);
            tabelaLivros.getColumnModel().getColumn(5).setResizable(false);
            tabelaLivros.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        adicionarLivro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        adicionarLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adicionar.png"))); // NOI18N
        adicionarLivro.setText("Livro");
        adicionarLivro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        adicionarLivro.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        adicionarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarLivroActionPerformed(evt);
            }
        });

        emprestar.setBackground(new java.awt.Color(255, 204, 51));
        emprestar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emprestar.setText("Emprestar");
        emprestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emprestarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adicionarLivro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emprestar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(adicionarLivro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emprestar))
                    .addComponent(btnLimpar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        consultarBilioteca();
        atualizarTabela();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void adicionarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarLivroActionPerformed
        formAdicionarLivroBiblioteca();
    }//GEN-LAST:event_adicionarLivroActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparFormulario();
        limparTabela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void textoBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoBuscaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoBuscaKeyPressed

    private void livroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_livroMousePressed
        carregarLivros();
    }//GEN-LAST:event_livroMousePressed

    private void autorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_autorMousePressed
        carregarAutor();
    }//GEN-LAST:event_autorMousePressed

    private void igrejaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_igrejaMousePressed
        carregarIgrejas();
    }//GEN-LAST:event_igrejaMousePressed

    private void editoraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editoraMousePressed
        carregarEditora();
    }//GEN-LAST:event_editoraMousePressed

    private void emprestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emprestarActionPerformed
        
    }//GEN-LAST:event_emprestarActionPerformed

    private void livroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_livroKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.livro.removeAllItems();
        } 
    }//GEN-LAST:event_livroKeyPressed

    private void autorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_autorKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.autor.removeAllItems();
        } 
    }//GEN-LAST:event_autorKeyPressed

    private void igrejaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_igrejaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.igreja.removeAllItems();
        } 
    }//GEN-LAST:event_igrejaKeyPressed

    private void editoraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editoraKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.editora.removeAllItems();
        } 
    }//GEN-LAST:event_editoraKeyPressed

    private void consultarBilioteca(){
        
        Integer status = 1;
        String textoBusca = this.textoBusca.getText();
        Livro livroSelec = (Livro) this.livro.getSelectedItem();
        Autor autor = (Autor) this.autor.getSelectedItem();
        Editora editora = (Editora) this.editora.getSelectedItem();
        Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        
        if(rbInativo.isSelected()){
            status = 0;
        }else if(rbAtivoInativo.isSelected()){
            status = null;
        }
        
        try{
            this.livroSelec.setNomeLivro(livroSelec.getNomeLivro());
            this.livroSelec.setCodLivro(livroSelec.getCodLivro());
            this.livroSelec.setCodInterno(livroSelec.getCodInterno());
        }catch(NullPointerException e){
            
        }

        this.livroSelec.setAutor(autor);
        this.livroSelec.setEditora(editora);
        this.livroSelec.setStatus(status);
        this.biblioteca.setLivro(this.livroSelec);
        this.biblioteca.setIgreja(igreja);
       
        this.listaBiblioteca = bibliotecaDao.consultarBiblioteca(biblioteca, textoBusca);       
    }
    
    private void atualizarTabela(){  
        String status = null;
        DefaultTableModel model = (DefaultTableModel) this.tabelaLivros.getModel();
        model.setNumRows(0);

        for(Biblioteca bibliotec:  this.listaBiblioteca){      
            if(bibliotec.getLivro().getStatus() == 0){
                status = "Inativo";
            }
            else{
                status = "Ativo";
            }
            model.addRow(new Object[]{bibliotec.getLivro().getCodLivro(),bibliotec.getLivro(), bibliotec.getLivro().getVolume(), bibliotec.getLivro().getAutor(), bibliotec.getQuantidade(), status});
        }
    }
    
    private void carregarIgrejas(){  
        List<Igreja> listaIgrejas = this.igrejaDao.consultarTodasIgrejas();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.igreja.getModel();
        modelo.removeAllElements();
        for(Igreja igreja : listaIgrejas){
            modelo.addElement(igreja);
        }
    }
    
    private void carregarLivros(){  
        List<Livro> listaLivro = this.livroDao.consultarLivros();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.livro.getModel();
        modelo.removeAllElements();
        for(Livro livro : listaLivro){
            modelo.addElement(livro);
        }
    }
        
    private void carregarAutor(){  
        List<Autor> listaAutor = autorDao.consultarAutores();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)autor.getModel();
        modelo.removeAllElements();
        for(Autor autor : listaAutor){
            modelo.addElement(autor);
        }
    }
            
    private void carregarEditora(){  
        List<Editora> listaEditora = editoraDao.consultarEditoras();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)editora.getModel();
        modelo.removeAllElements();
        for(Editora editora : listaEditora){
            modelo.addElement(editora);
        }
    }
    
    private void limparFormulario(){
        this.livro.setSelectedItem("");
        this.editora.setSelectedItem("");
        this.autor.setSelectedItem("");
        this.igreja.setSelectedItem("");
        this.volume.setValue(1);
        this.rbAtivo.setSelected(true);
        
    }
    
    private void limparTabela(){
        if(this.tabelaLivros.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) this.tabelaLivros.getModel();
            model.setRowCount(0);
        }
    }
    
    private void formAdicionarLivroBiblioteca(){
        AdicionarLivroForm addLivroBiblioteca = new AdicionarLivroForm((Frame) SwingUtilities.getWindowAncestor(this), true);
        addLivroBiblioteca.setLocationRelativeTo(this);
        addLivroBiblioteca.setVisible(true);
    }
    
   /* private void formEmprestarLivro(){
        int[] livrosSelec = this.tabelaLivros.getSelectedRows();
        List<Livro> listaLivros = new ArrayList<>();
        
        //Verifica se foi selecionado algum livro da tabela
        if(livrosSelec.length < 0){
            JOptionPane.showMessageDialog(null, "Selecione o livro que será emprestado", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }else{
            EmprestarLivroForm emprestarLivro = new EmprestarLivroForm((Frame) SwingUtilities.getWindowAncestor(this), true);
            emprestarLivro.setLocationRelativeTo(this);
            emprestarLivro.setVisible(true);
            
            
        }
        
        //Selecinando as contas que serão efetivadas
        for(int index : livrosSelec){
            
            //Setando a data de pagamento e a forma de pagamento
            String dataPagamento = this.dataPagamento.getText();
            FormaPagto formaPgto = (FormaPagto) formaPagto.getSelectedItem();
            ContaCaixa contaCaixa = (ContaCaixa) this.contaCaixa.getSelectedItem();
            Integer numNota = listaContasPagar.get(index).getNumNota();
            Integer parcela = listaContasPagar.get(index).getParcela();
            String descricao = listaContasPagar.get(index).getDescricaoConta();
            
            MovimentoCaixa mvCaixa = new MovimentoCaixa();
            mvCaixa.setContaPagar(listaContasPagar.get(index));
            mvCaixa.setDataPagamentoRecebimento(dataPagamento);
            mvCaixa.setFormaPagto(formaPgto);
            mvCaixa.setContaCaixa(contaCaixa);
            mvCaixa.setComplemento("CP "+numNota+"-"+parcela+" | "+descricao);
            
            //Lista de exclusão receber o dado da lista de contas a pagar no indice selecionado, uma vez que o indíce da tabela é o mesmo da lista
            listaLivros.add(mvCaixa);  

            //Excluí a conta da lista de contas a pagar para a tabela ser atualizada
            listaContasPagar.remove(index);          
        }

        int confirm = JOptionPane.showConfirmDialog(null,"Efetivar as contas selecionadas?", "Confirmar", JOptionPane.YES_NO_OPTION);     
        //Verifica qual a opção escolhida
        if(confirm == JOptionPane.YES_OPTION){
            movimentoCaixaDao.movimentarContasPagar(listaLivros);
        }else if(confirm == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        } 
    }
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarLivro;
    private javax.swing.JComboBox<String> autor;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> editora;
    private javax.swing.JButton emprestar;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> livro;
    private javax.swing.JRadioButton rbAtivo;
    private javax.swing.JRadioButton rbAtivoInativo;
    private javax.swing.ButtonGroup rbGrupoStatus;
    private javax.swing.JRadioButton rbInativo;
    private javax.swing.JTable tabelaLivros;
    private javax.swing.JTextField textoBusca;
    private javax.swing.JSpinner volume;
    // End of variables declaration//GEN-END:variables
}
