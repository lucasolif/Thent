
package view.biblioteca;

import dao.BibliotecaDao;
import dao.EmprestimoLivroDao;
import dao.LivroDao;
import dao.PessoaDao;
import dao.RegistroBibliotecaDao;
import Services.Utilitarios;
import interfaces.ConsultaPessoas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Biblioteca;
import model.EmprestimoLivro;
import model.Livro;
import model.Pessoa;
import view.carregamentoConsultas.TelaConsultasPessoas;



public class EmprestimoLivroForm extends javax.swing.JInternalFrame implements ConsultaPessoas {

    private final EmprestimoLivroDao emprestimoDao = new EmprestimoLivroDao();
    private final RegistroBibliotecaDao rgBibliotecaDao = new RegistroBibliotecaDao();
    private final PessoaDao pessoaDao = new PessoaDao();
    private final Biblioteca biblioteca = new Biblioteca();
    private final LivroDao livroDao = new LivroDao();
    private final Utilitarios conversor = new Utilitarios(); 
    private final BibliotecaDao bibliotecaDao = new BibliotecaDao();
    List<Pessoa> listaPessoa;

    public EmprestimoLivroForm() {
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

        codPessoa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nomePessoa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        livro = new javax.swing.JComboBox<>();
        bibliotecaJComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        dataEmprestimo = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLivros = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Empréstimo de Livros");

        codPessoa.setEditable(false);
        codPessoa.setBackground(new java.awt.Color(204, 204, 204));
        codPessoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        codPessoa.setFocusable(false);

        jLabel1.setText("Pessoa");

        nomePessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomePessoaKeyPressed(evt);
            }
        });

        jLabel2.setText("Livro");

        bibliotecaJComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bibliotecaJComboBoxItemStateChanged(evt);
            }
        });

        jLabel6.setText("Biblioteca");

        try {
            dataEmprestimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("Data Empréstimo");

        btnOk.setBackground(new java.awt.Color(0, 153, 255));
        btnOk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOk.setText("Adicionar");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Livros Adicionados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Livro", "Autor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            tabelaLivros.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabelaLivros.getColumnModel().getColumn(1).setResizable(false);
            tabelaLivros.getColumnModel().getColumn(1).setPreferredWidth(250);
            tabelaLivros.getColumnModel().getColumn(2).setResizable(false);
            tabelaLivros.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        btnSalvar.setBackground(new java.awt.Color(0, 204, 51));
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

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
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
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(livro, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnOk))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(codPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bibliotecaJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bibliotecaJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataEmprestimo)
                            .addComponent(btnOk)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(livro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomePessoaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomePessoaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarPessoas();
            abrirTelaEscolhaPessoa();
        } 
    }//GEN-LAST:event_nomePessoaKeyPressed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        this.nomePessoa.setEditable(false);
        this.dataEmprestimo.setEditable(false);
        this.bibliotecaJComboBox.setEnabled(false);
        adicionarLivroListaEmprestimo(); 
        carregarLivros();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        emprestarLivros();
        limparTabela();
        formInicial();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        formInicial();
        limparTabela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirLivroAdicionado();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void bibliotecaJComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bibliotecaJComboBoxItemStateChanged
        carregarLivros();
    }//GEN-LAST:event_bibliotecaJComboBoxItemStateChanged

    private void formInicial(){
        this.nomePessoa.setEditable(true);
        this.nomePessoa.requestFocusInWindow();
        this.dataEmprestimo.setEditable(true);
        this.dataEmprestimo.setEditable(true);
        this.bibliotecaJComboBox.setEnabled(true); 
        this.dataEmprestimo.setText(conversor.dataAtualString());
        this.codPessoa.setText("");
        this.nomePessoa.setText("");
        carregarBibliotecas();
        
        if(this.bibliotecaJComboBox.getItemCount() > 0){
            carregarLivros();
        }
        
    }
    
    private void carregarBibliotecas(){  
        List<Biblioteca> listaBiblioteca = this.bibliotecaDao.consultarBibliotecaJComboBox();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.bibliotecaJComboBox.getModel();
        for(Biblioteca bibli : listaBiblioteca){
            modelo.addElement(bibli);
        }
    }
    
    private void carregarLivros(){  
        Biblioteca biblioteca = (Biblioteca) this.bibliotecaJComboBox.getSelectedItem();
        List<Livro> listaLivro = this.rgBibliotecaDao.verificarDisponibilidadeEmprestimo(biblioteca);
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.livro.getModel();
        modelo.removeAllElements();
        for(Livro livro : listaLivro){
            modelo.addElement(livro);
        }
    }
    
    private void consultarPessoas(){
        String textoBusca = this.nomePessoa.getText(); // Texto digitado na busca        
        this.listaPessoa = this.pessoaDao.consultarCadastroAtivoPessoa(textoBusca); //Lista recebe a busca retornada do banco

    } 
    
    private void abrirTelaEscolhaPessoa(){
        TelaConsultasPessoas resultConsultParticipante = new TelaConsultasPessoas((Frame) SwingUtilities.getWindowAncestor(this), this.listaPessoa);
        resultConsultParticipante.setPessoaSelecionada(this);
        resultConsultParticipante.setLocationRelativeTo(this);
        resultConsultParticipante.setVisible(true);
    }
    
    public void pessoaEscolhida(Pessoa pessoa){
        this.codPessoa.setText(String.valueOf(pessoa.getCodigo()));
        this.nomePessoa.setText(String.valueOf(pessoa));
    }
    
    private void adicionarLivroListaEmprestimo(){
        int cont = 0;
        final Livro livro = (Livro) this.livro.getSelectedItem();
        final Integer codPessoa = Integer.valueOf(this.codPessoa.getText()); 
        final int qtdLinhas = this.tabelaLivros.getRowCount();
        boolean livroJaAdicionado = false;
        
        if(emprestimoDao.validarEmprestimoPessoa(livro,codPessoa) == false){          
            //Verificar se o livro já foi adicionado na lista/tabela de empréstimo
            while(cont < qtdLinhas){
                Integer codLivro = (Integer) this.tabelaLivros.getModel().getValueAt(cont, 0);

                // Se encontrar o código do livro, significa que já foi adicionado na lista
                if (codLivro.equals(livro.getCodLivro())) {
                     livroJaAdicionado = true;
                     break;
                }
                cont++;
            }           
            if(livroJaAdicionado){
                JOptionPane.showMessageDialog(null, "O livro já foi adicionado na lista de empréstimos", "Atenção", JOptionPane.WARNING_MESSAGE);
            }else{           
                DefaultTableModel model = (DefaultTableModel) this.tabelaLivros.getModel();
                model.addRow(new Object[]{livro.getCodLivro(),livro, livro.getAutor()});
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "O livro "+livro.getNomeLivro().toUpperCase()+" já está emprestado à "+this.nomePessoa.getText().toUpperCase(), "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }   
    
    private void excluirLivroAdicionado(){       
        Integer livroSelec = this.tabelaLivros.getSelectedRow();
        
        if(livroSelec > -1){
            DefaultTableModel model = (DefaultTableModel) this.tabelaLivros.getModel();
            model.removeRow(livroSelec);
            
            JOptionPane.showMessageDialog(null, "O livro foi removido da lista", "Concluído", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione o livro que será removido da lista", "Atenção", JOptionPane.WARNING_MESSAGE);
        }     
    }
    
    private void limparTabela(){
        if(this.tabelaLivros.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) this.tabelaLivros.getModel();
            model.setRowCount(0);
        }
    }
    
    private void emprestarLivros(){
        Pessoa pessoa = new Pessoa();
        List<Livro> livrosEmprestado = new ArrayList<>();
        EmprestimoLivro emprestimoLivro  = new EmprestimoLivro();  
        int qtdLivroSelec = this.tabelaLivros.getRowCount();
        Integer codPessoa = Integer.valueOf(this.codPessoa.getText());
        String nomePessoa = this.nomePessoa.getText();
        Date dataEmprestimo = this.conversor.convertendoStringDateSql(this.dataEmprestimo.getText());
        Biblioteca biblioteca  = (Biblioteca) this.bibliotecaJComboBox.getSelectedItem();

        if(qtdLivroSelec > 0){                            
            for(int i = 0; i < qtdLivroSelec; i++){                              
                Livro livro  = (Livro)this.tabelaLivros.getModel().getValueAt(i, 1);
                livrosEmprestado.add(livro);
            }
            
            pessoa.setCodigo(codPessoa);
            pessoa.setNome(nomePessoa);
            emprestimoLivro.setPessoa(pessoa);
            emprestimoLivro.setDataEmprestimo(dataEmprestimo);
            emprestimoLivro.setListaLivro(livrosEmprestado);
            emprestimoLivro.setStatusEmprestimo("E");
            emprestimoLivro.setDescricaoStatus("Emprestado");
            emprestimoLivro.setBiblioteca(biblioteca);

            this.emprestimoDao.emprestarLivros(emprestimoLivro);
        }else{
            JOptionPane.showMessageDialog(null, "Para efetuar o empréstimo, é necessário informar o(s) livro(s)", "Atenção", JOptionPane.WARNING_MESSAGE);
        }

    }
    
    @Override
    public void pessoaSelecionada(Pessoa pessoaSelecionada) {
        pessoaEscolhida(pessoaSelecionada);
    }
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bibliotecaJComboBox;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField codPessoa;
    private javax.swing.JFormattedTextField dataEmprestimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> livro;
    private javax.swing.JTextField nomePessoa;
    private javax.swing.JTable tabelaLivros;
    // End of variables declaration//GEN-END:variables


}
