
package view.relatorios;

import dao.ContasPagarDao;
import dao.FormaPagtoDao;
import dao.IgrejaDao;
import dao.PessoaDao;
import ferramentas.Utilitarios;
import interfaces.ConsultaPessoas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;
import model.ContasPagar;
import model.FormaPagto;
import model.Igreja;
import model.Pessoa;
import view.carregamentoConsultas.TelaConsultasPessoas;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import static org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName.HELVETICA;

public class RelatorioContasPagarForm extends javax.swing.JInternalFrame implements ConsultaPessoas{
    
    private final Utilitarios conversor = new Utilitarios();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final FormaPagtoDao formaPagtoDao = new FormaPagtoDao();
    private final PessoaDao pessoaDao = new PessoaDao();
    private final ContasPagarDao contasPagarDao = new ContasPagarDao();
    private List<Pessoa> listaPessoa = null;
    private Pessoa pessoaSelec = null;

    public RelatorioContasPagarForm() {
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

        filtrosData = new javax.swing.ButtonGroup();
        statusPagamento = new javax.swing.ButtonGroup();
        layoutRelatorio = new javax.swing.ButtonGroup();
        codFornecedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nomeFornecedor = new javax.swing.JTextField();
        igreja = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbDataVencimento = new javax.swing.JRadioButton();
        rbDataPagamento = new javax.swing.JRadioButton();
        txData = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        rbDataCadastro = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        rbAberto = new javax.swing.JRadioButton();
        rbPago = new javax.swing.JRadioButton();
        rbAmbos = new javax.swing.JRadioButton();
        formaPagto = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        rbFornecedor = new javax.swing.JRadioButton();
        rbContaResultado = new javax.swing.JRadioButton();
        rbFormaPagto = new javax.swing.JRadioButton();
        rbStatusPagamento = new javax.swing.JRadioButton();
        rbIgreja = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        btnGerar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Relatório de Contas a Pagar");

        codFornecedor.setEditable(false);
        codFornecedor.setBackground(new java.awt.Color(204, 204, 204));
        codFornecedor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        codFornecedor.setFocusable(false);

        jLabel1.setText("Fornecedor");

        nomeFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeFornecedorKeyPressed(evt);
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

        jLabel2.setText("Igreja");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtros Por Data De:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        filtrosData.add(rbDataVencimento);
        rbDataVencimento.setText("Vencimento");

        filtrosData.add(rbDataPagamento);
        rbDataPagamento.setText("Pagamento");

        txData.setText("De");

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

        filtrosData.add(rbDataCadastro);
        rbDataCadastro.setText("Cadastro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbDataVencimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDataPagamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDataCadastro))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDataVencimento)
                    .addComponent(rbDataPagamento)
                    .addComponent(rbDataCadastro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataInicial)
                    .addComponent(dataFinal)
                    .addComponent(jLabel4)
                    .addComponent(txData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Status", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        statusPagamento.add(rbAberto);
        rbAberto.setText("Aberto");

        statusPagamento.add(rbPago);
        rbPago.setText("Pago");

        statusPagamento.add(rbAmbos);
        rbAmbos.setText("Ambos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbAberto)
                    .addComponent(rbPago)
                    .addComponent(rbAmbos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rbAberto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbPago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbAmbos))
        );

        formaPagto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formaPagtoMousePressed(evt);
            }
        });
        formaPagto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formaPagtoKeyPressed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Layout", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        layoutRelatorio.add(rbFornecedor);
        rbFornecedor.setText("Fornecedor");

        layoutRelatorio.add(rbContaResultado);
        rbContaResultado.setText("Conta de Resultado");

        layoutRelatorio.add(rbFormaPagto);
        rbFormaPagto.setText("Forma de Pagto");

        layoutRelatorio.add(rbStatusPagamento);
        rbStatusPagamento.setText("Satus Pagamento");

        layoutRelatorio.add(rbIgreja);
        rbIgreja.setText("Igreja");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rbIgreja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbStatusPagamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbFormaPagto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbContaResultado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbFornecedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(127, 127, 127))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(rbFornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbContaResultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbFormaPagto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbStatusPagamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbIgreja))
        );

        jLabel3.setText("Forma Pagto");

        btnGerar.setBackground(new java.awt.Color(51, 153, 255));
        btnGerar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGerar.setText("Gerar");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(codFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(igreja, 0, 175, Short.MAX_VALUE)
                                    .addComponent(formaPagto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGerar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(4, 4, 4)
                                .addComponent(formaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnGerar)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formaPagtoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formaPagtoMousePressed
        carregarFormaPagto();
    }//GEN-LAST:event_formaPagtoMousePressed

    private void formaPagtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formaPagtoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            DefaultComboBoxModel campanha = (DefaultComboBoxModel)this.formaPagto.getModel();
            campanha.removeAllElements();
        }
    }//GEN-LAST:event_formaPagtoKeyPressed

    private void igrejaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_igrejaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            DefaultComboBoxModel campanha = (DefaultComboBoxModel)this.igreja.getModel();
            campanha.removeAllElements();
        }
    }//GEN-LAST:event_igrejaKeyPressed

    private void igrejaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_igrejaMousePressed
        carregarIgreja();
    }//GEN-LAST:event_igrejaMousePressed

    private void nomeFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeFornecedorKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarPessoas();
            abrirTelaEscolhaPessoa();
        }else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.codFornecedor.setText("");
            this.nomeFornecedor.setText("");
        }
    }//GEN-LAST:event_nomeFornecedorKeyPressed

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        try {
            gerarRelatorio();
        } catch (IOException ex) {
            
        }
    }//GEN-LAST:event_btnGerarActionPerformed

    private void formInicial(){
        this.codFornecedor.setText("");
        this.nomeFornecedor.setText("");
        this.rbDataVencimento.setSelected(true);
        this.dataInicial.setText(this.conversor.dataAtualString());
        this.dataFinal.setText(this.conversor.dataAtualString());
        this.rbAberto.setSelected(true);
        this.rbFornecedor.setSelected(true);
        this.formaPagto.setSelectedItem("");
        this.igreja.setSelectedItem("");
    }
    
    private void carregarFormaPagto(){
        List<FormaPagto> listaFormaPagto = this.formaPagtoDao.consultarFormaPagto();
        DefaultComboBoxModel formaPagto = (DefaultComboBoxModel)this.formaPagto.getModel();
        formaPagto.removeAllElements();
        for(FormaPagto pagto : listaFormaPagto){
            formaPagto.addElement(pagto);
        }
    }
    
    private void carregarIgreja(){
        List<Igreja> listaIgrejas = this.igrejaDao.consultarTodasIgrejas();
        DefaultComboBoxModel igreja = (DefaultComboBoxModel)this.igreja.getModel();
        igreja.removeAllElements();
        for(Igreja igre : listaIgrejas){
            igreja.addElement(igre);
        }
    }
    
    private void consultarPessoas(){
        String textoBusca = this.nomeFornecedor.getText();
        this.listaPessoa = this.pessoaDao.consultarPessoa(textoBusca);          
    }
    
    private void abrirTelaEscolhaPessoa(){
        TelaConsultasPessoas resultConsultParticipante = new TelaConsultasPessoas((Frame) SwingUtilities.getWindowAncestor(this), this.listaPessoa);
        resultConsultParticipante.setPessoaSelecionada(this);
        resultConsultParticipante.setLocationRelativeTo(this);
        resultConsultParticipante.setVisible(true);
    }
    
    public void pessoaEscolhida(Pessoa pessoa){        
        this.codFornecedor.setText(Integer.toString(pessoa.getCodigo()));
        this.nomeFornecedor.setText(pessoa.getNome());
        this.pessoaSelec = pessoa;
    }
    
    private List<ContasPagar> consultarContasPagar(){         
        List<ContasPagar> listaContasPagar = null;
        ContasPagar contasPagar = new ContasPagar();
        Date dataVencimentoInicial = null;
        Date dataVencimentoFinal = null;
        Date dataPagtoInicial = null;
        Date dataPagtoFinal = null;
        Date dataCadastroInicial = null;
        Date dataCadastroFinal = null;
        Integer status = null;
        Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        FormaPagto formaPagto = (FormaPagto) this.formaPagto.getSelectedItem();
        Pessoa pessoa = this.pessoaSelec;
        
        //Verifica qual data foi excluída, e atribui o valor da data inserida
        if(this.rbDataVencimento.isSelected()){
            dataVencimentoInicial = this.conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataVencimentoFinal = this.conversor.convertendoStringDateSql(this.dataInicial.getText());
        }else if(this.rbDataPagamento.isSelected()){
            dataPagtoInicial = this.conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataPagtoFinal = this.conversor.convertendoStringDateSql(this.dataInicial.getText());
        }else if(this.rbDataCadastro.isSelected()){
            dataCadastroInicial = this.conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataCadastroFinal = this.conversor.convertendoStringDateSql(this.dataInicial.getText());
        }
        
        //Verifica qual o status foi escolhido
        if(rbAberto.isSelected()){
            status = 0;
        }else if(rbPago.isSelected()){
            status = 1;
        } 
        
        contasPagar.setFormaPagto(formaPagto);
        contasPagar.setFornecedor(pessoa);
        contasPagar.setIgreja(igreja);
        contasPagar.getStatus();
        
        listaContasPagar = this.contasPagarDao.consultarContasPagar(contasPagar, dataVencimentoInicial, dataVencimentoFinal, dataCadastroInicial, dataCadastroFinal, dataPagtoInicial, dataPagtoFinal);    
    
        return listaContasPagar;
    }
    
    private void gerarRelatorio() throws IOException{
        // List<ContasPagar> listaContasPagar = consultarContasPagar();  
       
        // Criar um novo documento PDF
        final PDDocument documentoPDF = new PDDocument();
        PDPageContentStream fluxoConteudo = null;

        // Adicionar uma nova página ao documento
        final PDPage paginaPDF = new PDPage(PDRectangle.A4);//Tamanho da página
        documentoPDF.addPage(paginaPDF);
        
        final String dataRelatorio = conversor.dataAtualString();
        final String titulo = "Relatório de Contas a Pagar";
        
        float larguraPagina = paginaPDF.getMediaBox().getWidth(); // Largura da Pagina
        float alturaPagina = paginaPDF.getMediaBox().getHeight(); // Altura da Página
        float margemEsquerda;
        float margemSuperior;
        
        PDFont hevelticaBold =  new PDType1Font(FontName.HELVETICA_BOLD); //Definindo a fonte
        PDFont heveltica =  new PDType1Font(FontName.HELVETICA); //Definindo a fonte
        
        try {         
            // Criar o conteúdo para a página      
            fluxoConteudo = new PDPageContentStream(documentoPDF, paginaPDF);            
            
            //Data da emissão do relatório
            margemEsquerda = larguraPagina - 130; // 100 pixels da borda direita
            margemSuperior = alturaPagina - 20; // 20 pixels da borda superior
            fluxoConteudo.beginText(); //Inicinado o texto
            fluxoConteudo.setFont(hevelticaBold, 8); //Fonte e tamanho
            fluxoConteudo.newLineAtOffset(margemEsquerda, margemSuperior); // Posição do texto
            fluxoConteudo.showText("Data Emissão: "); //Texto
            fluxoConteudo.setFont(heveltica, 8); //Fonte e tamanho
            fluxoConteudo.showText(dataRelatorio); //Texto
            fluxoConteudo.endText(); //Finaliza o texto
            
            //Título relatório
            float larguraTitulo = hevelticaBold.getStringWidth(titulo)/1000 * 14; // Ajuste o tamanho da fonte         
            margemEsquerda = (larguraPagina - larguraTitulo) / 2;// Centraliza o texto
            margemSuperior = 760;
            fluxoConteudo.beginText(); //Iniciando a escrita
            fluxoConteudo.setFont(hevelticaBold, 14); //Definindo a fonte
            fluxoConteudo.newLineAtOffset(margemEsquerda, margemSuperior);  // Posição do texto
            fluxoConteudo.showText(titulo);
            fluxoConteudo.endText();
            
            
            // Definir a posição dos títulos das colunas
            float yPosition = 720; // Posição vertical inicial para os títulos
            float marginLeft = 50;  // Margem à esquerda
            float columnWidth = 50; // Largura de cada coluna
            float spacing = 10;  // Espaçamento entre as colunas
            float xPosition = 50;

            // Definir os títulos das colunas
            String[] columnTitles = {"Cód", "Fornecedor", "Nota", "Parcela", "Valor", "Valor Pago", "Dt Vencimento", "Dt Pagto"};

            // Desenhar os títulos das colunas na página
            for (int i = 0; i < columnTitles.length; i++) {
                if(i != 0){
                    xPosition += (hevelticaBold.getStringWidth(columnTitles[i-1])/1000 * 11) + 10; // Calcula a posição horizontal para cada título
                }
                fluxoConteudo.beginText();
                fluxoConteudo.setFont(hevelticaBold, 11);
                fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posição do título
                fluxoConteudo.showText(columnTitles[i]); // Texto do título
                fluxoConteudo.endText();
            }

            // Adicionar bordas ou linhas (opcional)
            /*fluxoConteudo.setLineWidth(1);
            fluxoConteudo.moveTo(marginLeft, yPosition - 2);  // Linha logo abaixo dos títulos
            fluxoConteudo.lineTo(marginLeft + (columnTitles.length * (columnWidth + spacing) - spacing), yPosition - 2);
            fluxoConteudo.stroke();*/
            
           /* //Titulos colunas
            fluxoConteudo.beginText(); //Inicinado o texto
            fluxoConteudo.setFont(hevelticaBold, 11); //Fonte e tamanho
            fluxoConteudo.newLineAtOffset(50, 720); // Posição do texto
            fluxoConteudo.showText("Cod"); //Texto
            fluxoConteudo.newLineAtOffset(40, 0); // Posição do texto referente ao outro texto
            fluxoConteudo.showText("Fornecedor"); //Texto
            fluxoConteudo.newLineAtOffset(200, 0); // Posição do texto referente ao outro texto
            fluxoConteudo.showText("Nota"); //Texto
            fluxoConteudo.newLineAtOffset(40, 0); // Posição do texto referente ao outro texto
            fluxoConteudo.showText("Parcela"); //Texto
            fluxoConteudo.newLineAtOffset(60, 0); // Posição do texto referente ao outro texto
            fluxoConteudo.showText("Valor"); //Texto
            fluxoConteudo.newLineAtOffset(60, 0); // Posição do texto referente ao outro texto
            fluxoConteudo.showText("Valor"); //Texto
            fluxoConteudo.newLineAtOffset(60, 0); // Posição do texto referente ao outro texto
            fluxoConteudo.showText("Valor"); //Texto
            fluxoConteudo.newLineAtOffset(60, 0); // Posição do texto referente ao outro texto
            fluxoConteudo.showText("Valor"); //Texto
            fluxoConteudo.newLineAtOffset(60, 0); // Posição do texto referente ao outro texto
            fluxoConteudo.showText("Valor"); //Texto
            fluxoConteudo.endText(); //Finaliza o texto*/
            
            // Adicionar mais texto
            /*fluxoConteudo.beginText();
            fluxoConteudo.setFont(hevelticaBold, 12);
            fluxoConteudo.newLineAtOffset(100, 720);  // Posição do texto
            fluxoConteudo.showText("Nome: João Silva");
            fluxoConteudo.newLineAtOffset(0, -15);
            fluxoConteudo.showText("Salário: R$ 3.500,00");
            fluxoConteudo.endText();*/

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o arquivo PDF", "Atenção", JOptionPane.WARNING_MESSAGE);
        } finally {
            // Fechar corretamente os fluxos
            try {
                if (fluxoConteudo != null) {
                    fluxoConteudo.close();
                }
                if (documentoPDF != null) {
                    // Salvar o documento em um arquivo
                    documentoPDF.save("ContasPagar.pdf");
                    documentoPDF.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar salvar o arquivo PDF", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    private void layoutFornecedor(){
        
    }
    
    @Override
    public void pessoaSelecionada(Pessoa pessoaSelecionada) {
        pessoaEscolhida(pessoaSelecionada);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.JTextField codFornecedor;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.ButtonGroup filtrosData;
    private javax.swing.JComboBox<String> formaPagto;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.ButtonGroup layoutRelatorio;
    private javax.swing.JTextField nomeFornecedor;
    private javax.swing.JRadioButton rbAberto;
    private javax.swing.JRadioButton rbAmbos;
    private javax.swing.JRadioButton rbContaResultado;
    private javax.swing.JRadioButton rbDataCadastro;
    private javax.swing.JRadioButton rbDataPagamento;
    private javax.swing.JRadioButton rbDataVencimento;
    private javax.swing.JRadioButton rbFormaPagto;
    private javax.swing.JRadioButton rbFornecedor;
    private javax.swing.JRadioButton rbIgreja;
    private javax.swing.JRadioButton rbPago;
    private javax.swing.JRadioButton rbStatusPagamento;
    private javax.swing.ButtonGroup statusPagamento;
    private javax.swing.JLabel txData;
    // End of variables declaration//GEN-END:variables
}
