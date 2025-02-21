
package view.contasPagar;

import Ferramentas.PersonalizaTabela;
import dao.ContasPagarDao;
import dao.PessoaDao;
import Ferramentas.Utilitarios;
import interfaces.ConsultaPessoas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.ContasPagar;
import model.Pessoa;
import model.Usuario;
import view.carregamentoConsultas.TelaConsultasPessoas;

public class CancelarContasPagarForm extends javax.swing.JInternalFrame implements ConsultaPessoas {
    
    private final PersonalizaTabela personalizaTabela = new PersonalizaTabela();
    private final PessoaDao pessoaDao = new PessoaDao();
    private final Utilitarios conversor = new Utilitarios();
    private final ContasPagarDao contasPagarDao = new ContasPagarDao();
    private ContasPagar contasPagar = new ContasPagar();
    private Pessoa fornecedor = new Pessoa();
    private List<ContasPagar> listaContasPagar = new ArrayList<>();
    private List<Pessoa> listaFornecedor = null;
    
    public CancelarContasPagarForm(Usuario usuarioLogado) {
        initComponents();
        formInicial();
    }
    
    //Centralizar a tela no meio
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoData = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rbDataVencimento = new javax.swing.JRadioButton();
        rbDataPagamento = new javax.swing.JRadioButton();
        rbDataLancamento = new javax.swing.JRadioButton();
        txData = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        codFornecedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nomeFornecedor = new javax.swing.JTextField();
        numNota = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        descricaoContas = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaContasPagar = new javax.swing.JTable();
        iconLimpar = new javax.swing.JButton();
        iconExcluir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cancelar Contas Pagar");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtros Por Data De:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        grupoData.add(rbDataVencimento);
        rbDataVencimento.setText("Vencimento");
        rbDataVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataVencimentoActionPerformed(evt);
            }
        });

        grupoData.add(rbDataPagamento);
        rbDataPagamento.setText("Pagamento");
        rbDataPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataPagamentoActionPerformed(evt);
            }
        });

        grupoData.add(rbDataLancamento);
        rbDataLancamento.setText("Lançamento");
        rbDataLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataLancamentoActionPerformed(evt);
            }
        });

        txData.setText("Vencimento:");

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
                .addComponent(rbDataVencimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDataPagamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDataLancamento))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDataVencimento)
                    .addComponent(rbDataPagamento)
                    .addComponent(rbDataLancamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dataInicial)
                        .addComponent(dataFinal)
                        .addComponent(jLabel4))
                    .addComponent(txData))
                .addGap(14, 14, 14))
        );

        codFornecedor.setEditable(false);
        codFornecedor.setBackground(new java.awt.Color(204, 204, 204));
        codFornecedor.setFocusable(false);

        jLabel1.setText("Fornecedor*");

        nomeFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeFornecedorKeyPressed(evt);
            }
        });

        jLabel3.setText("N° Nota");

        jLabel5.setText("Descrição");

        btnFiltrar.setBackground(new java.awt.Color(255, 153, 0));
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Parcelas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaContasPagar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nota", "Parcela", "Valor (R$)", "Descrição", "Fornecedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaContasPagar.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tabelaContasPagar.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tabelaContasPagar.setShowGrid(true);
        jScrollPane1.setViewportView(tabelaContasPagar);
        if (tabelaContasPagar.getColumnModel().getColumnCount() > 0) {
            tabelaContasPagar.getColumnModel().getColumn(0).setResizable(false);
            tabelaContasPagar.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabelaContasPagar.getColumnModel().getColumn(1).setResizable(false);
            tabelaContasPagar.getColumnModel().getColumn(1).setPreferredWidth(40);
            tabelaContasPagar.getColumnModel().getColumn(2).setResizable(false);
            tabelaContasPagar.getColumnModel().getColumn(2).setPreferredWidth(60);
            tabelaContasPagar.getColumnModel().getColumn(3).setResizable(false);
            tabelaContasPagar.getColumnModel().getColumn(3).setPreferredWidth(230);
            tabelaContasPagar.getColumnModel().getColumn(4).setResizable(false);
            tabelaContasPagar.getColumnModel().getColumn(4).setPreferredWidth(250);
        }

        iconLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        iconLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        iconLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconLimparActionPerformed(evt);
            }
        });

        iconExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        iconExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lixeira-16.png"))); // NOI18N
        iconExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconExcluirActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(iconLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(descricaoContas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numNota, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(btnFiltrar))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descricaoContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnFiltrar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iconExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbDataVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataVencimentoActionPerformed
        txData.setText("Vencimento:");
    }//GEN-LAST:event_rbDataVencimentoActionPerformed

    private void rbDataPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataPagamentoActionPerformed
        txData.setText("Pagamento:");
    }//GEN-LAST:event_rbDataPagamentoActionPerformed

    private void rbDataLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataLancamentoActionPerformed
        txData.setText("Lançamento:");
    }//GEN-LAST:event_rbDataLancamentoActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        consultarContasPagar();
        atualizarTabela();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void iconLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconLimparActionPerformed
        limparFormulario();
        limparTabela();
    }//GEN-LAST:event_iconLimparActionPerformed

    private void iconExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconExcluirActionPerformed
        excluirContaPagar();
        consultarContasPagar();
        atualizarTabela();
    }//GEN-LAST:event_iconExcluirActionPerformed

    private void nomeFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeFornecedorKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscarFornecedor();
            carregarResultadoConsultaFornecedor();
        }
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.codFornecedor.setText("");
        } 
    }//GEN-LAST:event_nomeFornecedorKeyPressed

    private void buscarFornecedor(){
        String textoBusca = nomeFornecedor.getText(); // Texto digitado na busca        
        this.listaFornecedor = pessoaDao.consultarPessoa(textoBusca); //Lista recebe a busca retornada do banco
    } 
         
    private void carregarResultadoConsultaFornecedor(){
        TelaConsultasPessoas resultConsultParticipante = new TelaConsultasPessoas((Frame) SwingUtilities.getWindowAncestor(this), this.listaFornecedor);
        resultConsultParticipante.setPessoaSelecionada(this);
        resultConsultParticipante.setLocationRelativeTo(this);
        resultConsultParticipante.setVisible(true);
    }
    
    private void carregarFornecedorEscolhido(Pessoa pessoa){
        this.codFornecedor.setText(Integer.toString(pessoa.getCodigo()));
        this.nomeFornecedor.setText(pessoa.getNome());
    }
    
    private void limparFormulario(){
        codFornecedor.setText("");
        nomeFornecedor.setText("");
        rbDataVencimento.setSelected(true);
        dataInicial.setText(conversor.dataAtualString());
        dataFinal.setText(conversor.dataAtualString());
        descricaoContas.setText("");
        numNota.setText("");
    }
    
    private void consultarContasPagar(){
        
        Date dataLancamentoInicial = null;
        Date dataLancamentoFinal = null;
        Date dataPagamentoInicial = null;
        Date dataPagamentoFinal = null;
        Date dataVencimentoInicial = null;
        Date dataVencimentoFinal = null;
        Integer codForn = null;
        Integer numeroNota = null;
        String descricao = this.descricaoContas.getText();
        
        //Tratando o código do cliente
        if (!this.codFornecedor.getText().isEmpty()) {
            try {
                codForn = Integer.valueOf(this.codFornecedor.getText());
                fornecedor.setCodigo(codForn);
            } catch (NumberFormatException e) {
            }
        }
        //Tratando o número da nota
        if (!this.numNota.getText().isEmpty()) {
            try {
                numeroNota = Integer.valueOf(this.numNota.getText());
            } catch (NumberFormatException e) {

            }
        }
        
        //Validando qual data foi selecionado, e convertendo a String para tipo data
        if(this.rbDataLancamento.isSelected()){
            dataLancamentoInicial = conversor.convertendoStringDateSql(this.dataInicial.getText()); 
            dataLancamentoFinal = conversor.convertendoStringDateSql(this.dataFinal.getText());

        }else if(this.rbDataPagamento.isSelected()){
            dataPagamentoInicial = conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataPagamentoFinal = conversor.convertendoStringDateSql(this.dataFinal.getText());

        }else if(this.rbDataVencimento.isSelected()){
            dataVencimentoInicial = conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataVencimentoFinal = conversor.convertendoStringDateSql(this.dataFinal.getText());

        }

        if(this.codFornecedor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Para cancelar a nota, é necessário informar o fornecedor", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            this.contasPagar.setFornecedor(this.fornecedor);
            this.contasPagar.setNumNota(numeroNota);
            this.contasPagar.setDescricaoConta(descricao);

            //Adiciona o resultado da consulta dentro de uma lista
            this.listaContasPagar = this.contasPagarDao.consultarContasPagar(this.contasPagar, dataVencimentoInicial, dataVencimentoFinal, dataLancamentoInicial, dataLancamentoFinal, dataPagamentoInicial, dataPagamentoFinal);  
        }
 
    }
    
    private void atualizarTabela(){
        DefaultTableModel model = (DefaultTableModel) this.tabelaContasPagar.getModel();
        model.setNumRows(0);

        for(ContasPagar cp : this.listaContasPagar){      
            model.addRow(new Object[]{cp.getNumNota(),cp.getParcela(),cp.getValor(), cp.getDescricaoConta(), cp.getFornecedor().getNome()});
        }
    }
    
    private void excluirContaPagar(){
        int[] numLinhaSelec = tabelaContasPagar.getSelectedRows();
        List<ContasPagar> listaCpExcluida = new ArrayList<>();
        boolean contaPaga = false;
        int confirm = 0;
        
        //Verifica se foi selecionado alguma conta a pagar da lista
        if(numLinhaSelec.length < 0){
            JOptionPane.showMessageDialog(null, "Selecione a(s) conta(s) a pagar a ser excluída", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //Selecinando as contas que foram excluídas
        for(int index : numLinhaSelec){
            //Lista de exclusão receber o dado da lista de contas a pagar no indice selecionado, uma vez que o indíce da tabela é o mesmo da lista
            listaCpExcluida.add(listaContasPagar.get(index));    
            this.listaContasPagar.remove(index);    
        }
        
        //Verificando se alguma contas a pagar já foi baixada
        for(ContasPagar cp : listaCpExcluida){
            if(cp.getDataPagamento() != null){
                contaPaga = true;
            }
        }

        //Se houver contas a pagar liquidada, ele informa e pergunta ser quer realmente excluir
        if(contaPaga){
            JOptionPane.showMessageDialog(null, "A conta está baixada no caixa, não é possível excluir", "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
            confirm = JOptionPane.showConfirmDialog(null,"Excluir as contas selecionadas ?", "Confirmar", JOptionPane.YES_NO_OPTION);
        }

        //Verifica qual a opção escolhida
        if(confirm == JOptionPane.YES_OPTION){
            contasPagarDao.ExcluirContasPagar(listaCpExcluida);
        }else if(confirm == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }       
    }
    
    private void limparTabela(){
        if(tabelaContasPagar.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) tabelaContasPagar.getModel();
            model.setRowCount(0);
        }
    }
    
    private void alinharConteudoTabela(){
        
        DefaultTableCellRenderer primeiraColuna = new DefaultTableCellRenderer();
        primeiraColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaContasPagar.getColumnModel().getColumn(0).setCellRenderer(primeiraColuna);

        DefaultTableCellRenderer segundaColuna = new DefaultTableCellRenderer();
        segundaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaContasPagar.getColumnModel().getColumn(1).setCellRenderer(segundaColuna);

        DefaultTableCellRenderer terceiraColuna = new DefaultTableCellRenderer();
        terceiraColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaContasPagar.getColumnModel().getColumn(2).setCellRenderer(terceiraColuna);
        
        DefaultTableCellRenderer quartaColuna = new DefaultTableCellRenderer();
        quartaColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaContasPagar.getColumnModel().getColumn(3).setCellRenderer(quartaColuna);
        
        DefaultTableCellRenderer quintaColuna = new DefaultTableCellRenderer();
        quintaColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaContasPagar.getColumnModel().getColumn(4).setCellRenderer(quintaColuna);
        
    }
    
    private void formInicial(){
        alinharConteudoTabela();
        this.personalizaTabela.definirNegritoTituloColuna(tabelaContasPagar);
        rbDataVencimento.setSelected(true);
        dataInicial.setText(conversor.dataAtualString());
        dataFinal.setText(conversor.dataAtualString());
    }
    
    @Override
    public void pessoaSelecionada(Pessoa pessoaSelecionada) {
        carregarFornecedorEscolhido(pessoaSelecionada);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JTextField codFornecedor;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JTextField descricaoContas;
    private javax.swing.ButtonGroup grupoData;
    private javax.swing.JButton iconExcluir;
    private javax.swing.JButton iconLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeFornecedor;
    private javax.swing.JTextField numNota;
    private javax.swing.JRadioButton rbDataLancamento;
    private javax.swing.JRadioButton rbDataPagamento;
    private javax.swing.JRadioButton rbDataVencimento;
    private javax.swing.JTable tabelaContasPagar;
    private javax.swing.JLabel txData;
    // End of variables declaration//GEN-END:variables
}
