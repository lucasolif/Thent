
package view.biblioteca;

import dao.EmprestimoLivroDao;
import dao.IgrejaDao;
import dao.LivroDao;
import dao.PessoaDao;
import ferramentas.Conversores;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.EmprestimoLivro;
import model.Igreja;
import model.Livro;
import model.Pessoa;


public class ConsultaEmprestimoForm extends javax.swing.JInternalFrame {
    
    private final LivroDao livroDao = new LivroDao();
    private final PessoaDao pessoaDao = new PessoaDao();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final EmprestimoLivroDao empLivroDao = new EmprestimoLivroDao();
    private final Conversores conversor = new Conversores();
    private List<EmprestimoLivro> listaEmpLivros = new ArrayList<>();
    private Pessoa pessoa = new Pessoa();
    private EmprestimoLivro emprestimoLivro = new EmprestimoLivro();

    public ConsultaEmprestimoForm() {
        initComponents();
        formInicial();
        consultarTodosEmprestimos();
        atualizarTabela();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbGrupoData = new javax.swing.ButtonGroup();
        rbGrupoStatus = new javax.swing.ButtonGroup();
        codPessoa = new javax.swing.JTextField();
        nomePessoa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        livros = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbDataEmprestimo = new javax.swing.JRadioButton();
        rbDataDevolucao = new javax.swing.JRadioButton();
        txData = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rbEmprestado = new javax.swing.JRadioButton();
        rbDevolvido = new javax.swing.JRadioButton();
        rbAmbos = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEmprestimos = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JButton();
        btnDevolver = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        igreja = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dataDevolucao = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Gerenciar Empréstimos de Livros");

        codPessoa.setEditable(false);
        codPessoa.setBackground(new java.awt.Color(204, 204, 204));
        codPessoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        nomePessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomePessoaKeyPressed(evt);
            }
        });

        jLabel1.setText("Pessoa");

        livros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                livrosMousePressed(evt);
            }
        });
        livros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                livrosKeyPressed(evt);
            }
        });

        jLabel2.setText("Livros");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtros Por Data De:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        rbGrupoData.add(rbDataEmprestimo);
        rbDataEmprestimo.setText("Empréstimo");
        rbDataEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataEmprestimoActionPerformed(evt);
            }
        });

        rbGrupoData.add(rbDataDevolucao);
        rbDataDevolucao.setText("Devolução");
        rbDataDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataDevolucaoActionPerformed(evt);
            }
        });

        txData.setText("Empréstimo");

        try {
            dataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            dataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("até");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbDataEmprestimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDataDevolucao)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDataEmprestimo)
                    .addComponent(rbDataDevolucao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataInicial)
                    .addComponent(dataFinal)
                    .addComponent(jLabel4)
                    .addComponent(txData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Status Empréstimo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        rbGrupoStatus.add(rbEmprestado);
        rbEmprestado.setText("Emprestados");

        rbGrupoStatus.add(rbDevolvido);
        rbDevolvido.setText("Devolvidos");
        rbDevolvido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDevolvidoActionPerformed(evt);
            }
        });

        rbGrupoStatus.add(rbAmbos);
        rbAmbos.setText("Ambos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbEmprestado)
                    .addComponent(rbDevolvido)
                    .addComponent(rbAmbos))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rbEmprestado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDevolvido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbAmbos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cod Livro", "Livro", "Pessoa", "Empréstimo", "Devolução"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tabelaEmprestimos);
        if (tabelaEmprestimos.getColumnModel().getColumnCount() > 0) {
            tabelaEmprestimos.getColumnModel().getColumn(0).setResizable(false);
            tabelaEmprestimos.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabelaEmprestimos.getColumnModel().getColumn(1).setResizable(false);
            tabelaEmprestimos.getColumnModel().getColumn(1).setPreferredWidth(40);
            tabelaEmprestimos.getColumnModel().getColumn(2).setResizable(false);
            tabelaEmprestimos.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabelaEmprestimos.getColumnModel().getColumn(3).setResizable(false);
            tabelaEmprestimos.getColumnModel().getColumn(3).setPreferredWidth(200);
            tabelaEmprestimos.getColumnModel().getColumn(4).setResizable(false);
            tabelaEmprestimos.getColumnModel().getColumn(4).setPreferredWidth(60);
            tabelaEmprestimos.getColumnModel().getColumn(5).setResizable(false);
            tabelaEmprestimos.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        btnFiltrar.setBackground(new java.awt.Color(51, 153, 255));
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnDevolver.setBackground(new java.awt.Color(255, 153, 0));
        btnDevolver.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDevolver.setText("Devolver");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

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

        jLabel3.setText("Dt Devolução");

        try {
            dataDevolucao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Igreja");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(codPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(livros, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(igreja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel3))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnFiltrar)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDevolver)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(livros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFiltrar)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDevolver)
                    .addComponent(btnLimpar))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbDataEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataEmprestimoActionPerformed
        this.txData.setText("Empréstimo:");
    }//GEN-LAST:event_rbDataEmprestimoActionPerformed

    private void rbDataDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataDevolucaoActionPerformed
        this.txData.setText("Devolução:");
    }//GEN-LAST:event_rbDataDevolucaoActionPerformed

    private void rbDevolvidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDevolvidoActionPerformed
        this.btnDevolver.setEnabled(false);
    }//GEN-LAST:event_rbDevolvidoActionPerformed

    private void nomePessoaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomePessoaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscarPessoa();
        } 
    }//GEN-LAST:event_nomePessoaKeyPressed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        consultarEmprestimos();
        atualizarTabela();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        devolverEmprestimo();
        formInicial();
        consultarTodosEmprestimos();
        atualizarTabela();
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        formInicial();
        limparTabela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void livrosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_livrosKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.livros.removeAllItems();
        } 
    }//GEN-LAST:event_livrosKeyPressed

    private void livrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_livrosMousePressed
        carregarLivros();
    }//GEN-LAST:event_livrosMousePressed

    private void igrejaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_igrejaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.igreja.removeAllItems();
        } 
    }//GEN-LAST:event_igrejaKeyPressed

    private void igrejaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_igrejaMousePressed
        carregarIgrejas();
    }//GEN-LAST:event_igrejaMousePressed

    private void carregarLivros(){  
        List<Livro> listaLivro = this.livroDao.consultarLivros();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.livros.getModel();
        modelo.removeAllElements();
        for(Livro livro : listaLivro){
            modelo.addElement(livro);
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
    
    private void buscarPessoa(){
        String textoBusca = this.nomePessoa.getText(); // Texto digitado na busca        
        List<Pessoa> listaPessoa = this.pessoaDao.consultar(textoBusca); //Lista recebe a busca retornada do banco
        
        //Adicionando os dados encontrados, no formulário
        for(Pessoa pessoa : listaPessoa){
            this.codPessoa.setText(Integer.toString(pessoa.getCodigo()));
            this.nomePessoa.setText(pessoa.getNome());
        } 
    } 
    
    private void formInicial(){
        this.rbDataEmprestimo.setSelected(true);
        this.rbEmprestado.setSelected(true);
        this.btnDevolver.setEnabled(true);
        this.dataInicial.setText(conversor.dataAtualString());
        this.dataFinal.setText(conversor.dataAtualString());
        this.dataDevolucao.setText(conversor.dataAtualString());
        this.codPessoa.setText("");
        this.nomePessoa.setText("");
        this.livros.setSelectedItem("");
        this.txData.setText("Empréstimo:");
    }
    
    private void consultarEmprestimos(){
        Date dataEmprestimoInicial = null;
        Date dataEmprestimoFinal = null;
        Date dataDevolucaoInicial = null;
        Date dataDevolucaoFinal = null;
        Integer codPessoa = null;
        Integer statusEmprestimo = null;
        String nomePessoa = this.nomePessoa.getText();
        Livro livro = (Livro) this.livros.getSelectedItem();
        
        //Tratando o código da pessoa    
        try {
            codPessoa = Integer.valueOf(this.codPessoa.getText());
            this.pessoa.setCodigo(codPessoa);
            this.pessoa.setNome(nomePessoa);
        } catch (NumberFormatException e){

        }
        
        //Verificando quais radios button dos status foram selecionados
        if(this.rbEmprestado.isSelected()){
            statusEmprestimo = 1;
        }else if(this.rbDevolvido.isSelected()){
            statusEmprestimo = 0;
        }else if(this.rbAmbos.isSelected()){
            statusEmprestimo = null;
        }
        
        //Validando qual data foi selecionado, e convertendo a String para tipo data
        if(this.rbDataEmprestimo.isSelected()){
            dataEmprestimoInicial = this.conversor.convertendoStringDateSql(this.dataInicial.getText()); 
            dataEmprestimoFinal = this.conversor.convertendoStringDateSql(this.dataFinal.getText());

        }else if(this.rbDataDevolucao.isSelected()){
            dataDevolucaoInicial = conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataDevolucaoFinal = conversor.convertendoStringDateSql(this.dataFinal.getText());
        }
        
        this.emprestimoLivro.setLivro(livro);
        this.emprestimoLivro.setPessoa(this.pessoa);
        this.emprestimoLivro.setStatus(statusEmprestimo);
        
        this.listaEmpLivros = empLivroDao.consultarEmprestimosLivro(this.emprestimoLivro, dataEmprestimoInicial, dataEmprestimoFinal, dataDevolucaoInicial, dataDevolucaoFinal);
        
    }
    
    private void atualizarTabela(){
        DefaultTableModel model = (DefaultTableModel) this.tabelaEmprestimos.getModel();
        model.setNumRows(0);

        for(EmprestimoLivro empLivro : this.listaEmpLivros){    
            String dataEmprestimo = this.conversor.convertendoDataStringSql((java.sql.Date) empLivro.getDataEmprestimo());
            String dataDevolucao = this.conversor.convertendoDataStringSql((java.sql.Date) empLivro.getDataDevolucao());
            
            model.addRow(new Object[]{empLivro.getCodInterno(),empLivro.getLivro().getCodLivro(),empLivro.getLivro(), empLivro.getPessoa(), dataEmprestimo, dataDevolucao});
        }
    }
    
    private void limparTabela(){
        //Primeiro a condição testa se a quantidade de colunas é maior que 0, depois, limpa os dados
        if(this.tabelaEmprestimos.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) this.tabelaEmprestimos.getModel();
            model.setRowCount(0);
        }
    }
    
    private void devolverEmprestimo(){
     
        int empSelec[] = this.tabelaEmprestimos.getSelectedRows();
        List<EmprestimoLivro> listaEmpDevolvido = new ArrayList<>();
        
        //Verifica se foi selecionado algum registro da lista
        if(empSelec.length < 0){
            JOptionPane.showMessageDialog(null, "Selecione um empréstimo para ser devolvido", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }else{
            for(int index : empSelec){
                EmprestimoLivro emprestimoLivro = new EmprestimoLivro();           
                Pessoa pessoa = this.listaEmpLivros.get(index).getPessoa();
                Livro livro = this.listaEmpLivros.get(index).getLivro();
                Integer codInterno = this.listaEmpLivros.get(index).getCodInterno();
                Igreja igreja = (Igreja) this.igreja.getSelectedItem();
                Date dataDevolucao = conversor.convertendoStringDateSql(this.dataDevolucao.getText());
                Integer status = 0;                   
                
                emprestimoLivro.setPessoa(pessoa);
                emprestimoLivro.setLivro(livro);
                emprestimoLivro.setIgreja(igreja);
                emprestimoLivro.setDataDevolucao(dataDevolucao);
                emprestimoLivro.setStatus(status);
                emprestimoLivro.setCodInterno(codInterno);

                //Lista de exclusão receber o dado da lista de contas a pagar no indice selecionado, uma vez que o indíce da tabela é o mesmo da lista
                listaEmpDevolvido.add(emprestimoLivro);   
            }
                       
            int confirm = JOptionPane.showConfirmDialog(null,"Confirmar devolução?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                this.empLivroDao.devolverLivro(listaEmpDevolvido);
                this.listaEmpLivros.clear();
            }else if(confirm == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            }
        }

    }
    
    private void consultarTodosEmprestimos(){
        this.listaEmpLivros = this.empLivroDao.consultarEmprestimosStatusEmprestado();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JTextField codPessoa;
    private javax.swing.JFormattedTextField dataDevolucao;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> livros;
    private javax.swing.JTextField nomePessoa;
    private javax.swing.JRadioButton rbAmbos;
    private javax.swing.JRadioButton rbDataDevolucao;
    private javax.swing.JRadioButton rbDataEmprestimo;
    private javax.swing.JRadioButton rbDevolvido;
    private javax.swing.JRadioButton rbEmprestado;
    private javax.swing.ButtonGroup rbGrupoData;
    private javax.swing.ButtonGroup rbGrupoStatus;
    private javax.swing.JTable tabelaEmprestimos;
    private javax.swing.JLabel txData;
    // End of variables declaration//GEN-END:variables
}
