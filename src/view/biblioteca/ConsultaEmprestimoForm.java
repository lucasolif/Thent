
package view.biblioteca;

import dao.EmprestimoLivroDao;
import dao.LivroDao;
import dao.PessoaDao;
import ferramentas.Conversores;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.EmprestimoLivro;
import model.Livro;
import model.Pessoa;


public class ConsultaEmprestimoForm extends javax.swing.JInternalFrame {
    
    private final LivroDao livroDao = new LivroDao();
    private final PessoaDao pessoaDao = new PessoaDao();
    private final EmprestimoLivroDao empLivroDao = new EmprestimoLivroDao();
    private final Conversores conversor = new Conversores();
    private List<EmprestimoLivro> listaEmpLivros = new ArrayList<>();
    private EmprestimoLivro emprestimoSelec = null;
    private Pessoa pessoa = new Pessoa();
    private EmprestimoLivro emprestimoLivro = new EmprestimoLivro();

    public ConsultaEmprestimoForm() {
        initComponents();
        formInicial();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEmprestimos = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JButton();
        btnDevolver = new javax.swing.JButton();

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
                        .addComponent(rbDataDevolucao))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        rbEmprestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEmprestadoActionPerformed(evt);
            }
        });

        rbGrupoStatus.add(rbDevolvido);
        rbDevolvido.setText("Devolvidos");
        rbDevolvido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDevolvidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbEmprestado)
                    .addComponent(rbDevolvido))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbEmprestado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDevolvido)
                .addContainerGap())
        );

        tabelaEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cod Livro", "Livro", "Pessoa", "Dt. Empréstimo", "Dt Devolução"
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
            tabelaEmprestimos.getColumnModel().getColumn(1).setPreferredWidth(30);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(livros, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(173, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFiltrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDevolver)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(livros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDevolver)
                    .addComponent(btnFiltrar))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbDataEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataEmprestimoActionPerformed
        txData.setText("Empréstimo:");
    }//GEN-LAST:event_rbDataEmprestimoActionPerformed

    private void rbDataDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataDevolucaoActionPerformed
        txData.setText("Devolução:");
    }//GEN-LAST:event_rbDataDevolucaoActionPerformed

    private void rbEmprestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEmprestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbEmprestadoActionPerformed

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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void carregarLivros(){  
        List<Livro> listaLivro = this.livroDao.consultarLivros();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.livros.getModel();
        modelo.removeAllElements();
        for(Livro livro : listaLivro){
            modelo.addElement(livro);
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
        carregarLivros();
        this.rbDataEmprestimo.setSelected(true);
        this.rbEmprestado.setSelected(true);
        this.btnDevolver.setEnabled(true);
        this.dataInicial.setText(conversor.dataAtualString());
        this.dataFinal.setText(conversor.dataAtualString());
        this.codPessoa.setText("");
        this.nomePessoa.setText("");
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
            
            model.addRow(new Object[]{empLivro.getCodigo(),empLivro.getLivro().getCodLivro(),empLivro.getLivro(), empLivro.getPessoa(), dataEmprestimo, dataDevolucao});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JTextField codPessoa;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> livros;
    private javax.swing.JTextField nomePessoa;
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
