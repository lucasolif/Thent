
package view.biblioteca;

import Ferramentas.PersonalizaTabela;
import dao.AutorDao;
import dao.BibliotecaDao;
import dao.EditoraDao;
import dao.IgrejaDao;
import dao.LivroDao;
import dao.RegistroBibliotecaDao;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Autor;
import model.Biblioteca;
import model.Editora;
import model.Livro;
import model.RegistroBiblioteca;
import model.Usuario;


public class AcervoBibliotecaForm extends javax.swing.JInternalFrame {

    private final PersonalizaTabela personalizaTabela = new PersonalizaTabela();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final LivroDao livroDao = new LivroDao();
    private final AutorDao autorDao = new AutorDao();
    private final EditoraDao editoraDao = new EditoraDao();
    private final BibliotecaDao bibliotecaDao = new BibliotecaDao();
    private final RegistroBibliotecaDao rgBibliotecaDao = new RegistroBibliotecaDao();
    private List<RegistroBiblioteca> listaRgBilioteca = new ArrayList();
    private Usuario usuarioLogado;

    public AcervoBibliotecaForm(Usuario usuarioLogado) {
        initComponents();
        formInicial();
        this.usuarioLogado = usuarioLogado;
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
        bibliotecaIgreja = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        volume = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLivros = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        adicionarLivro = new javax.swing.JButton();

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Status Livro", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

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

        bibliotecaIgreja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bibliotecaIgrejaMousePressed(evt);
            }
        });
        bibliotecaIgreja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bibliotecaIgrejaKeyPressed(evt);
            }
        });

        jLabel6.setText("Blbioteca");

        btnFiltrar.setBackground(new java.awt.Color(0, 153, 255));
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

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
                            .addComponent(bibliotecaIgreja, 0, 205, Short.MAX_VALUE)
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
                    .addComponent(bibliotecaIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Registro de Livros da Biblioteca", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod Livro", "Livro", "Vol.", "Autor(a)", "Qtd.", "Biblioteca"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
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
            tabelaLivros.getColumnModel().getColumn(1).setPreferredWidth(230);
            tabelaLivros.getColumnModel().getColumn(2).setResizable(false);
            tabelaLivros.getColumnModel().getColumn(2).setPreferredWidth(20);
            tabelaLivros.getColumnModel().getColumn(3).setResizable(false);
            tabelaLivros.getColumnModel().getColumn(3).setPreferredWidth(180);
            tabelaLivros.getColumnModel().getColumn(4).setResizable(false);
            tabelaLivros.getColumnModel().getColumn(4).setPreferredWidth(30);
            tabelaLivros.getColumnModel().getColumn(5).setResizable(false);
            tabelaLivros.getColumnModel().getColumn(5).setPreferredWidth(150);
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adicionarLivro)))
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
                    .addComponent(adicionarLivro)
                    .addComponent(btnLimpar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        consultarRegistroBiblioteca();
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

    private void bibliotecaIgrejaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bibliotecaIgrejaMousePressed
        carregarBibliotecas();
    }//GEN-LAST:event_bibliotecaIgrejaMousePressed

    private void editoraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editoraMousePressed
        carregarEditora();
    }//GEN-LAST:event_editoraMousePressed

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

    private void bibliotecaIgrejaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bibliotecaIgrejaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.bibliotecaIgreja.removeAllItems();
        } 
    }//GEN-LAST:event_bibliotecaIgrejaKeyPressed

    private void editoraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editoraKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.editora.removeAllItems();
        } 
    }//GEN-LAST:event_editoraKeyPressed

    private void consultarRegistroBiblioteca(){      
        String textoBusca = this.textoBusca.getText();
        Autor autor = (Autor) this.autor.getSelectedItem();
        Livro livro = (Livro) this.livro.getSelectedItem();
        Editora editora = (Editora) this.editora.getSelectedItem();
        Biblioteca biblioteca = (Biblioteca) this.bibliotecaIgreja.getSelectedItem();
        Integer volumeLivro = null;
        Integer status = null;
        
        if((Integer)this.volume.getValue() != 0){
            volumeLivro = (Integer) this.volume.getValue();
        }
        
        if(this.rbAtivo.isSelected()){
            status = 1;
        }else if(this.rbInativo.isSelected()){
            status = 0;
        }
       
        this.listaRgBilioteca = this.rgBibliotecaDao.consultarRegistroBiblioteca(autor, livro, editora, biblioteca,status,volumeLivro);   
    }
    
    private void atualizarTabela(){  
        DefaultTableModel model = (DefaultTableModel) this.tabelaLivros.getModel();
        model.setNumRows(0);

        for(RegistroBiblioteca rgBibli:  this.listaRgBilioteca){      
            model.addRow(new Object[]{rgBibli.getLivro().getCodLivro(),rgBibli.getLivro(), rgBibli.getLivro().getVolume(), rgBibli.getLivro().getAutor(), rgBibli.getQtdLivro(), rgBibli.getBiblioteca()});
        }
    }
    
    private void carregarBibliotecas(){  
        List<Biblioteca> listaBiblioteca = this.bibliotecaDao.consultarBibliotecaJComboBox();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.bibliotecaIgreja.getModel();
        modelo.removeAllElements();
        for(Biblioteca bibli : listaBiblioteca){
            modelo.addElement(bibli);
        }
    }
    
    private void carregarLivros(){  
        List<Livro> listaLivro = this.rgBibliotecaDao.consultarLivrosTodasBibliotecas();
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
        this.bibliotecaIgreja.setSelectedItem("");
        this.volume.setValue(0);
        this.rbAtivo.setSelected(true);
        
    }
    
    private void limparTabela(){
        if(this.tabelaLivros.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) this.tabelaLivros.getModel();
            model.setRowCount(0);
        }
    }
    
    private void formAdicionarLivroBiblioteca(){
        AdicionarLivroForm addLivroBiblioteca = new AdicionarLivroForm((Frame) SwingUtilities.getWindowAncestor(this), true, usuarioLogado);
        addLivroBiblioteca.setLocationRelativeTo(this);
        addLivroBiblioteca.setVisible(true);
    }
    
    private void formInicial(){
        alinharConteudoTabela();
        personalizaTabela.definirNegritoTituloColuna(tabelaLivros);
    }
    
    private void alinharConteudoTabela(){
        
        // Alinhamento do Ofertante (à esquerda)
        DefaultTableCellRenderer primeiraColuna = new DefaultTableCellRenderer();
        primeiraColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaLivros.getColumnModel().getColumn(0).setCellRenderer(primeiraColuna);

        // Alinhamento do Valor (centro)
        DefaultTableCellRenderer segundaColuna = new DefaultTableCellRenderer();
        segundaColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaLivros.getColumnModel().getColumn(1).setCellRenderer(segundaColuna);

        //Alinhamento do tipo de oferta
        DefaultTableCellRenderer terceiraColuna = new DefaultTableCellRenderer();
        terceiraColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaLivros.getColumnModel().getColumn(2).setCellRenderer(terceiraColuna);
    
        //Alinhamento da igreja
        DefaultTableCellRenderer quartaColuna = new DefaultTableCellRenderer();
        quartaColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaLivros.getColumnModel().getColumn(3).setCellRenderer(quartaColuna);
        
        //Alinhamento da data de oferta
        DefaultTableCellRenderer quintaColuna = new DefaultTableCellRenderer();
        quintaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaLivros.getColumnModel().getColumn(4).setCellRenderer(quintaColuna);
        
        //Alinhamento da data de lançamento
        DefaultTableCellRenderer sextaColuna = new DefaultTableCellRenderer();
        sextaColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaLivros.getColumnModel().getColumn(5).setCellRenderer(sextaColuna);

    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarLivro;
    private javax.swing.JComboBox<String> autor;
    private javax.swing.JComboBox<String> bibliotecaIgreja;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> editora;
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
