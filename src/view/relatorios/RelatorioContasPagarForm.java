
package view.relatorios;

import Ferramentas.UtilitariosRelatorios;
import dao.ContasPagarDao;
import dao.FormaPagtoDao;
import dao.IgrejaDao;
import dao.PessoaDao;
import dao.SubContaResultadoDao;
import Ferramentas.Utilitarios;
import dao.UsuarioDao;
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
import javax.swing.JOptionPane;
import model.SubContaResultado;
import model.Usuario;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;

public class RelatorioContasPagarForm extends javax.swing.JInternalFrame implements ConsultaPessoas{
    
    private final Utilitarios conversor = new Utilitarios();
    private final UtilitariosRelatorios funcoesRelatorio = new UtilitariosRelatorios();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final FormaPagtoDao formaPagtoDao = new FormaPagtoDao();
    private final SubContaResultadoDao subContResultDao = new SubContaResultadoDao();
    private final PessoaDao pessoaDao = new PessoaDao();
    private final ContasPagarDao contasPagarDao = new ContasPagarDao();
    private List<Pessoa> listaPessoa = null;
    private Pessoa pessoaSelec = null;
    private Usuario usuarioLogado;
    private final UsuarioDao usuarioDao = new UsuarioDao();
    private String filtroIgreja = "";

    public RelatorioContasPagarForm(Usuario usuarioLogado) {
        initComponents();
        this.usuarioLogado = usuarioLogado;
        this.filtroIgreja = usuarioDao.gerarFiltroIgreja(usuarioLogado);
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
        rbPadrao = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        btnGerar = new javax.swing.JButton();
        contaResultado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

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

        layoutRelatorio.add(rbPadrao);
        rbPadrao.setText("Padrão");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbIgreja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbStatusPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbFormaPagto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbContaResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbPadrao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(rbPadrao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbFornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbContaResultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbFormaPagto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbStatusPagamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbIgreja)
                .addContainerGap())
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

        contaResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                contaResultadoMousePressed(evt);
            }
        });
        contaResultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contaResultadoKeyPressed(evt);
            }
        });

        jLabel5.setText("Conta Resultado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3)
                                                .addComponent(igreja, 0, 175, Short.MAX_VALUE)
                                                .addComponent(formaPagto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGerar)))
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
                                .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGerar)
                    .addComponent(contaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formaPagtoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formaPagtoMousePressed
        carregarFormaPagto();
    }//GEN-LAST:event_formaPagtoMousePressed

    private void formaPagtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formaPagtoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            DefaultComboBoxModel formaPagto = (DefaultComboBoxModel)this.formaPagto.getModel();
            formaPagto.removeAllElements();
        }
    }//GEN-LAST:event_formaPagtoKeyPressed

    private void igrejaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_igrejaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            DefaultComboBoxModel igreja = (DefaultComboBoxModel)this.igreja.getModel();
            igreja.removeAllElements();
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
        gerarRelatorio();
    }//GEN-LAST:event_btnGerarActionPerformed

    private void contaResultadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contaResultadoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            DefaultComboBoxModel subContaResultado = (DefaultComboBoxModel)this.contaResultado.getModel();
            subContaResultado.removeAllElements();
        }
    }//GEN-LAST:event_contaResultadoKeyPressed

    private void contaResultadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contaResultadoMousePressed
        carregarSubContaResultado();
    }//GEN-LAST:event_contaResultadoMousePressed

    private void formInicial(){
        this.codFornecedor.setText("");
        this.nomeFornecedor.setText("");
        this.rbDataVencimento.setSelected(true);
        this.dataInicial.setText(this.conversor.dataAtualString());
        this.dataFinal.setText(this.conversor.dataAtualString());
        this.rbAberto.setSelected(true);
        this.rbPadrao.setSelected(true);
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
        List<Igreja> listaIgrejas = this.igrejaDao.consultarTodasIgrejas(this.filtroIgreja);
        DefaultComboBoxModel igreja = (DefaultComboBoxModel)this.igreja.getModel();
        igreja.removeAllElements();
        for(Igreja igre : listaIgrejas){
            igreja.addElement(igre);
        }
    }
    
    private void carregarSubContaResultado(){
        List<SubContaResultado> listaSubContResult = this.subContResultDao.consultarSubContaResultado();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.contaResultado.getModel();
        modelo.removeAllElements();
        for(SubContaResultado subCont : listaSubContResult){
            modelo.addElement(subCont);
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
    
    private void gerarRelatorio(){
        
        List<ContasPagar> listaContasPagar = null;
        
        if(this.rbPadrao.isSelected()){
            listaContasPagar = consultarContasPagar("Fornecedor");
            layoutPadrao(listaContasPagar);
        }else if(this.rbFornecedor.isSelected()){
            listaContasPagar = consultarContasPagar("Fornecedor");
            layoutFornecedor(listaContasPagar);
        }else if(this.rbContaResultado.isSelected()){
            listaContasPagar = consultarContasPagar("SubContaResultado");
            layoutContaResultado(listaContasPagar);
        }else if(this.rbFormaPagto.isSelected()){
            listaContasPagar = consultarContasPagar("FormaPagto");
            layoutFormaPagto(listaContasPagar);
        }else if(this.rbStatusPagamento.isSelected()){
            listaContasPagar = consultarContasPagar("DescricaoStatus");
            layoutStatusPagamento(listaContasPagar);
        }else if(this.rbIgreja.isSelected()){
            listaContasPagar = consultarContasPagar("Igreja");
            layoutIgreja(listaContasPagar);
        }
        
    }
    
    private List<ContasPagar> consultarContasPagar(String ordemDados){         
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
        SubContaResultado subContaResultado = (SubContaResultado) this.contaResultado.getSelectedItem();
        Pessoa pessoa = this.pessoaSelec;
        
        //Verifica qual data foi escolhida, e atribui o valor da data inserida
        if(this.rbDataVencimento.isSelected()){
            dataVencimentoInicial = this.conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataVencimentoFinal = this.conversor.convertendoStringDateSql(this.dataFinal.getText());
        }else if(this.rbDataPagamento.isSelected()){
            dataPagtoInicial = this.conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataPagtoFinal = this.conversor.convertendoStringDateSql(this.dataFinal.getText());
        }else if(this.rbDataCadastro.isSelected()){
            dataCadastroInicial = this.conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataCadastroFinal = this.conversor.convertendoStringDateSql(this.dataFinal.getText());
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
        contasPagar.setStatus(status);
        
        listaContasPagar = this.contasPagarDao.consultarContasPagarRelatorio(formaPagto, pessoa, igreja, status, subContaResultado, ordemDados, dataVencimentoInicial, dataVencimentoFinal, dataCadastroInicial, dataCadastroFinal, dataPagtoInicial, dataPagtoFinal, this.filtroIgreja);    
    
        return listaContasPagar;
    }
    
    private void layoutPadrao(List<ContasPagar> listaContasPagar){
        
        //Variáveis do layout
        float yPosition = 720; // Posição vertical inicial para os títulos
        float xPosition = 50; // Posição horizontal inicial para os títulos
        final  int layout = 1;
        final float tamanhoFonteTitulo = 18;
        final PDFont timesBold =  new PDType1Font(FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont times =  new PDType1Font(FontName.TIMES_ROMAN); //Definindo a fonte
        
        //Variáveis referente aos dados do relatório
        final String dataInicial = this.dataInicial.getText();
        final String dataFinal = this.dataFinal.getText();
        final String titulo = "Relatório de Contas a Pagar";   
        final String subTitulo = "Período de "+dataInicial+" até "+dataFinal;
        final String[] titulosTabela = {"Cód", "Fornecedor", "Nota", "Parc", "Valor", "Val.Pago", "Vencimento", "Pagamento"};
        double totalValorPago = 0;
        double totalValorPendente = 0;
        double totalValorCp = 0;
           
        // Criar um novo documento PDF
        final PDDocument documentoPDF = new PDDocument();
        PDPageContentStream fluxoConteudo = null;

        // Adicionar uma nova página ao documento
        final PDPage paginaPDF = new PDPage(PDRectangle.A4);//Tamanho da página
        documentoPDF.addPage(paginaPDF);
  
        try {         
            // Criar o conteúdo para a página      
            fluxoConteudo = new PDPageContentStream(documentoPDF, paginaPDF);             
            //Gerando o título do relatório
            this.funcoesRelatorio.primeiroTituloRelatorio(tamanhoFonteTitulo, titulo, fluxoConteudo, paginaPDF);     
            //Gerando o sub título do relatório
            this.funcoesRelatorio.subTituloRelatorio(subTitulo, fluxoConteudo, paginaPDF);   
            yPosition -= 30;
     
            // Definir os títulos das colunas 
            this.funcoesRelatorio.tituloColunaRelatorioContasPagarReceber(layout ,yPosition, xPosition, titulosTabela, fluxoConteudo);           
            yPosition -= 20; // Pular para a linha abaixo após o título

            for(int i = 0; i < listaContasPagar.size(); i++) {              
                if (yPosition < 50) { // Se a posição Y estiver abaixo do limite da página, criar uma nova página
                    fluxoConteudo.close();
                    PDPage novaPagina = new PDPage(PDRectangle.A4); // Tamanho da página
                    documentoPDF.addPage(novaPagina);
                    fluxoConteudo = new PDPageContentStream(documentoPDF, novaPagina);
                    yPosition = 750; // Resetar a posição Y para o topo da nova página
                }
                
                xPosition = 50; // Resetar a posição horizontal a cada nova linha

                // Obter os dados da lista (exemplo de como acessar a lista e pegar os dados)
                String codFornecedor = String.valueOf(listaContasPagar.get(i).getFornecedor().getCodigo());
                String nomeFornecedor = this.conversor.limitarCaracteres(listaContasPagar.get(i).getFornecedor().getNome(), 35) ;
                String numNota = String.valueOf(listaContasPagar.get(i).getNumNota());
                String parcela = listaContasPagar.get(i).getTotalParcela();
                String valorDuplicata = this.conversor.formatarDoubleString(listaContasPagar.get(i).getValor()).replace(".", ",");
                String valorPago = this.conversor.formatarDoubleString(listaContasPagar.get(i).getValorPago()).replace(".", ",");
                String dataVencimento = this.conversor.convertendoDataStringSql((java.sql.Date) listaContasPagar.get(i).getDataVencimento());
                String dataPagamento = this.conversor.convertendoDataStringSql((java.sql.Date) listaContasPagar.get(i).getDataPagamento());

                // Desenhar os dados da linha na tabela
                fluxoConteudo.beginText();
                fluxoConteudo.setFont(times, 10);

                fluxoConteudo.newLineAtOffset(xPosition, yPosition);
                fluxoConteudo.showText(codFornecedor);
                xPosition += (timesBold.getStringWidth(titulosTabela[0]) / 1000 * 11) - 35; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(nomeFornecedor);
                xPosition += (timesBold.getStringWidth(titulosTabela[1]) / 1000 * 11) + 90; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(numNota);
                xPosition += (timesBold.getStringWidth(titulosTabela[2]) / 1000 * 11) - 165; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(parcela);
                xPosition += (timesBold.getStringWidth(titulosTabela[3]) / 1000 * 11) - 25; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valorDuplicata);
                xPosition += (timesBold.getStringWidth(titulosTabela[4]) / 1000 * 11) - 5; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valorPago);
                xPosition += (timesBold.getStringWidth(titulosTabela[5]) / 1000 * 11) - 35; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(dataVencimento);
                xPosition += (timesBold.getStringWidth(titulosTabela[6]) / 1000 * 11) - 55; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(dataPagamento);

                fluxoConteudo.endText();

                // Descer para a próxima linha
                yPosition -= 20; // Ajuste o espaçamento vertical conforme necessário 
                totalValorPago += listaContasPagar.get(i).getValorPago();
                totalValorPendente += (listaContasPagar.get(i).getValor() - listaContasPagar.get(i).getValorPago());
                totalValorCp += listaContasPagar.get(i).getValor();
            }
            //Define o posicionamento horizontal e vertical da próxima informação, com base no posicionamento da informação anterior
            yPosition -= 40;
            
            funcoesRelatorio.valoresTresTotalizadores("TotalPago:         ", "Total Pendente: ", "Valor Total CP: ", totalValorPago,totalValorPendente,totalValorCp,yPosition,fluxoConteudo);

            fluxoConteudo.close();
            this.funcoesRelatorio.salvarRelatorioPDF("RelatorioContasPagar",documentoPDF);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o arquivo PDF", "Atenção", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (fluxoConteudo != null) {
                    fluxoConteudo.close();
                }
                if (documentoPDF != null) {
                    documentoPDF.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar salvar o arquivo PDF", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }
        
    }
    
    private void layoutFornecedor(List<ContasPagar> listaContasPagar){
        
        double totalPago = 0;
        double totalPendente = 0;
        double totalValorPago = 0;
        double totalValorPendente = 0;
        double totalValorCp = 0;
        final String dataInicial = this.dataInicial.getText();
        final String dataFinal = this.dataFinal.getText();
        final String titulo = "Relatório de Contas a Pagar (Fornecedor)";
        final String subTitulo = "Período de "+dataInicial+" até "+dataFinal;
        Pessoa fornecedorAtual = null;
        final int layout = 2;
        final String [] titulosTabela = {"Nota", "Parcela","Descrição","Valor", "Val.Pago", "Vencimento", "Pagamento"};
        
        float yPosition = 720; // Posição vertical inicial para os títulos
        float xPosition = 50; // Posição horizontal inicial para os títulos     
        final int limiteCaracteres = 25; // Limite de caracteres (ajuste conforme necessário)
        final float tamanhoFonteTitulo = 18;  
        PDFont timesBold =  new PDType1Font(FontName.TIMES_BOLD); //Definindo a fonte
        PDFont times =  new PDType1Font(FontName.TIMES_ROMAN); //Definindo a fonte      
                
        // Criar um novo documento PDF
        final PDDocument documentoPDF = new PDDocument();
        PDPageContentStream fluxoConteudo = null;

        // Adicionar uma nova página ao documento
        final PDPage paginaPDF = new PDPage(PDRectangle.A4);//Tamanho da página
        documentoPDF.addPage(paginaPDF);       
        
        try {         
            // Criar o conteúdo para a página      
            fluxoConteudo = new PDPageContentStream(documentoPDF, paginaPDF);           
            //Gerando o título do relatório
            this.funcoesRelatorio.primeiroTituloRelatorio(tamanhoFonteTitulo, titulo, fluxoConteudo, paginaPDF);  
            //Gerando o sub título do relatório
            this.funcoesRelatorio.subTituloRelatorio(subTitulo, fluxoConteudo, paginaPDF);   
                
            // Iterar sobre as contas a pagar
            for (ContasPagar cp : listaContasPagar) {              
                if(fornecedorAtual == null || fornecedorAtual.getCodigo() != cp.getFornecedor().getCodigo()){ 
                    if(fornecedorAtual == null){
                        yPosition -= 30; // Pular para a linha abaixo após o título
                    }else{
                        //Define o posicinamento vertical e orizontal do próximo conteúdo
                        xPosition += 320;
                        yPosition -= 10;
                        
                        funcoesRelatorio.valoresDoisTotalizadores("Valor Pago:        ", "Valor Pendente: ", totalPago,totalPendente, yPosition, fluxoConteudo);
                        xPosition = 50;
                        yPosition -= 50; // Pular para a linha abaixo após o título
                    }

                    //Definir titulos dos agrupameto do layout
                    String tituloLayout = cp.getFornecedor().getCodigo()+ " - "+ cp.getFornecedor().getNome();
                    this.funcoesRelatorio.tituloLayoutEsquerda(tituloLayout, yPosition, xPosition, fluxoConteudo);
                    
                    fornecedorAtual = cp.getFornecedor();  
                    yPosition -= 20;
                    
                    // Definir os títulos das colunas                   
                    this.funcoesRelatorio.tituloColunaRelatorioContasPagarReceber(layout, yPosition, xPosition, titulosTabela, fluxoConteudo);                       
                    yPosition -= 20; // Pular para a linha abaixo após o título
                    
                    //Zerando os valores dos totais por data, para calcular o próximo total do próximo grupo de dados
                    totalPago = 0;
                    totalPendente = 0;
                }           

                xPosition = 50; // Resetar a posição horizontal a cada nova linha
                             
                if (yPosition < 70) { // Se a posição Y estiver abaixo do limite da página, criar uma nova página
                    fluxoConteudo.close();
                    PDPage novaPagina = new PDPage(PDRectangle.A4); // Tamanho da página
                    documentoPDF.addPage(novaPagina);
                    fluxoConteudo = new PDPageContentStream(documentoPDF, novaPagina);
                    yPosition = 750; // Resetar a posição Y para o topo da nova página
                }

                String numNota = String.valueOf(cp.getNumNota());
                String parcela = cp.getTotalParcela();
                String descricaoCp = cp.getDescricaoConta();
                if (descricaoCp.length() > limiteCaracteres) {
                    descricaoCp = descricaoCp.substring(0, limiteCaracteres); // Truncar e adicionar "..."
                }
                String valorDuplicata = this.conversor.formatarDoubleString(cp.getValor()).replace(".", ",");
                String valorPago = this.conversor.formatarDoubleString(cp.getValorPago()).replace(".", ",");
                String dataVencimento = conversor.convertendoDataStringSql((java.sql.Date) cp.getDataVencimento());
                String dataPagamento = conversor.convertendoDataStringSql((java.sql.Date) cp.getDataPagamento());

                // Desenhar os dados da linha na tabela
                fluxoConteudo.beginText();
                fluxoConteudo.setFont(times, 10);

                fluxoConteudo.newLineAtOffset(xPosition, yPosition);
                fluxoConteudo.showText(numNota);
                xPosition += (timesBold.getStringWidth(titulosTabela[2]) / 1000 * 11) - 50; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(parcela);
                xPosition += (timesBold.getStringWidth(titulosTabela[3]) / 1000 * 11) - 35; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(descricaoCp);
                xPosition += (timesBold.getStringWidth(titulosTabela[4]) / 1000 * 11) + 90; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valorDuplicata);
                xPosition += (timesBold.getStringWidth(titulosTabela[5]) / 1000 * 11) - 180; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valorPago);
                xPosition += (timesBold.getStringWidth(titulosTabela[6]) / 1000 * 11) - 30; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(dataVencimento);
                xPosition += (timesBold.getStringWidth(titulosTabela[6]) / 1000 * 11) - 50; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(dataPagamento);

                fluxoConteudo.endText();

                // Descer para a próxima linha
                yPosition -= 20; // Ajuste o espaçamento vertical conforme necessário 
                
                totalPago += cp.getValorPago();
                totalPendente += (cp.getValor() - cp.getValorPago());
                totalValorPago += cp.getValorPago();
                totalValorPendente += (cp.getValor() - cp.getValorPago());
                totalValorCp += cp.getValor();            
            }
            //Define o posicinamento vertical e orizontal do próximo conteúdo
            yPosition -= 10;
                              
            funcoesRelatorio.valoresDoisTotalizadores("Valor Pago:        ", "Valor Pendente: ", totalPago,totalPendente,yPosition,fluxoConteudo);
            //Define o posicinamento vertical e orizontal do próximo conteúdo
            yPosition -= 50;
 
            funcoesRelatorio.valoresTresTotalizadores("Total Pago:        ", "Total Pendente: ", "Valor Total CP: ", totalValorPago,totalValorPendente,totalValorCp,yPosition,fluxoConteudo);
            
            fluxoConteudo.close();
            this.funcoesRelatorio.salvarRelatorioPDF("RelatorioContasPagar",documentoPDF);       
            
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o arquivo PDF", "Atenção", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (fluxoConteudo != null) {
                    fluxoConteudo.close();
                }
                if (documentoPDF != null) {
                    documentoPDF.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar salvar o arquivo PDF", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    private void layoutContaResultado(List<ContasPagar> listaContasPagar){
        
        double totalPago = 0;
        double totalPendente = 0;
        double totalValorPago = 0;
        double totalValorPendente = 0;
        double totalValorCp = 0;
        final String dataInicial = this.dataInicial.getText();
        final String dataFinal = this.dataFinal.getText();
        final String subTitulo = "Período de "+dataInicial+" até "+dataFinal;
        final String titulo = "Relatório de Contas a Pagar (Conta Resultado)";  
        SubContaResultado contaResultado = null;
        final String[] titulosTabela = {"Cód", "Fornecedor", "Nota", "Parc", "Valor", "Val.Pago", "Vencimento", "Pagamento"};
        
        float yPosition = 720; // Posição vertical inicial para os títulos
        float xPosition = 50; // Posição horizontal inicial para os títulos
        final float tamanhoFonteTitulo = 18;
        final int layout = 3;
        final PDFont timesBold =  new PDType1Font(FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont times =  new PDType1Font(FontName.TIMES_ROMAN); //Definindo a fonte
        
        // Criar um novo documento PDF
        final PDDocument documentoPDF = new PDDocument();
        PDPageContentStream fluxoConteudo = null;

        // Adicionar uma nova página ao documento
        final PDPage paginaPDF = new PDPage(PDRectangle.A4);//Tamanho da página
        documentoPDF.addPage(paginaPDF);     
        
        try {         
            // Criar o conteúdo para a página      
            fluxoConteudo = new PDPageContentStream(documentoPDF, paginaPDF);             
            //Gerando o título do relatório
            this.funcoesRelatorio.primeiroTituloRelatorio(tamanhoFonteTitulo, titulo, fluxoConteudo, paginaPDF); 
            //Gerando o sub título do relatório
            this.funcoesRelatorio.subTituloRelatorio(subTitulo, fluxoConteudo, paginaPDF);   
                   
            // Iterar sobre as contas a pagar
            for (ContasPagar cp : listaContasPagar) {              
                if(contaResultado == null || contaResultado.getCodigo() != cp.getSubContaResultado().getCodigo()){ 

                    if(contaResultado == null){
                        yPosition -= 30; // Pular para a linha abaixo após o título
                    }else{                 
                        //Define o posicinamento vertical e orizontal do próximo conteúdo
                        yPosition -= 10;
                        
                        funcoesRelatorio.valoresDoisTotalizadores("Valor Pago:        ", "Valor Pendente: ", totalPago,totalPendente, yPosition, fluxoConteudo);
                        xPosition = 50;
                        yPosition -= 60; // Pular para a linha abaixo após o título
                    }
               
                    String tituloLayout = cp.getSubContaResultado().getDescricao();
                    this.funcoesRelatorio.tituloLayoutEsquerda(tituloLayout, yPosition, xPosition, fluxoConteudo); 
                    
                    contaResultado = cp.getSubContaResultado();  
                    yPosition -= 20;
                    
                    // Definir os títulos das colunas
                    this.funcoesRelatorio.tituloColunaRelatorioContasPagarReceber(layout, yPosition, xPosition, titulosTabela, fluxoConteudo); 
                    yPosition -= 20;
                    
                    //Zerando os valores dos totais por data, para calcular o próximo total do próximo grupo de dados
                    totalPago = 0;
                    totalPendente = 0;
                }           

                xPosition = 50; // Resetar a posição horizontal a cada nova linha
                
                if (yPosition < 80) { // Se a posição Y estiver abaixo do limite da página, criar uma nova página
                    fluxoConteudo.close();
                    PDPage novaPagina = new PDPage(PDRectangle.A4); // Tamanho da página
                    documentoPDF.addPage(novaPagina);
                    fluxoConteudo = new PDPageContentStream(documentoPDF, novaPagina);
                    yPosition = 750; // Resetar a posição Y para o topo da nova página
                }

                // Obter os dados da lista (exemplo de como acessar a lista e pegar os dados)
                String codFornecedor = String.valueOf(cp.getFornecedor().getCodigo());
                String nomeFornecedor = this.conversor.limitarCaracteres(cp.getFornecedor().getNome(), 35);
                String numNota = String.valueOf(cp.getNumNota());
                String parcela = cp.getTotalParcela();
                String valorDuplicata = this.conversor.formatarDoubleString(cp.getValor()).replace(".", ",");
                String valorPago = this.conversor.formatarDoubleString(cp.getValorPago()).replace(".", ",");
                String dataVencimento = conversor.convertendoDataStringSql((java.sql.Date) cp.getDataVencimento());
                String dataPagamento = conversor.convertendoDataStringSql((java.sql.Date) cp.getDataPagamento());
                
                // Desenhar os dados da linha na tabela
                fluxoConteudo.beginText();
                fluxoConteudo.setFont(times, 10);

                fluxoConteudo.newLineAtOffset(xPosition, yPosition);
                fluxoConteudo.showText(codFornecedor);
                xPosition += (timesBold.getStringWidth(titulosTabela[0]) / 1000 * 11) - 35; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(nomeFornecedor);
                xPosition += (timesBold.getStringWidth(titulosTabela[1]) / 1000 * 11) + 90; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(numNota);
                xPosition += (timesBold.getStringWidth(titulosTabela[2]) / 1000 * 11) - 165; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(parcela);
                xPosition += (timesBold.getStringWidth(titulosTabela[3]) / 1000 * 11) - 25; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valorDuplicata);
                xPosition += (timesBold.getStringWidth(titulosTabela[4]) / 1000 * 11) - 5; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valorPago);
                xPosition += (timesBold.getStringWidth(titulosTabela[5]) / 1000 * 11) - 35; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(dataVencimento);
                xPosition += (timesBold.getStringWidth(titulosTabela[6]) / 1000 * 11) - 55; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(dataPagamento);

                fluxoConteudo.endText();

                // Descer para a próxima linha
                yPosition -= 20; // Ajuste o espaçamento vertical conforme necessário   
                
                totalPago += cp.getValorPago();
                totalPendente += (cp.getValor() - cp.getValorPago());
                totalValorPago += cp.getValorPago();
                totalValorPendente += (cp.getValor() - cp.getValorPago());
                totalValorCp += cp.getValor();   
            }
            //Define o posicinamento vertical e orizontal do próximo conteúdo
            yPosition -= 10;
                              
            funcoesRelatorio.valoresDoisTotalizadores("Valor Pago:        ", "Valor Pendente: ", totalPago,totalPendente,yPosition,fluxoConteudo);
            //Define o posicinamento vertical e orizontal do próximo conteúdo
            yPosition -= 50;
 
            funcoesRelatorio.valoresTresTotalizadores("Valor Pago:        ", "Valor Pendente: ", "Valor Total CP: ", totalValorPago,totalValorPendente,totalValorCp,yPosition,fluxoConteudo);           

            fluxoConteudo.close();
            this.funcoesRelatorio.salvarRelatorioPDF("RelatorioContasPagar",documentoPDF);       
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o arquivo PDF", "Atenção", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (fluxoConteudo != null) {
                    fluxoConteudo.close();
                }
                if (documentoPDF != null) {
                    documentoPDF.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar salvar o arquivo PDF", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    private void layoutFormaPagto(List<ContasPagar> listaContasPagar){

        //Variáveis referente aos dados do relatório
        double totalPago = 0;
        double totalPendente = 0;
        double totalValorPago = 0;
        double totalValorPendente = 0;
        double totalValorCp = 0;         
        FormaPagto formaPagto = null;
        final String dataInicial = this.dataInicial.getText();
        final String dataFinal = this.dataFinal.getText();
        final String subTitulo = "Período de "+dataInicial+" até "+dataFinal;
        final String titulo = "Relatório de Contas a Pagar (Forma Pagamento)";  
        final String[] titulosTabela = {"Cód", "Fornecedor", "Nota", "Parc", "Valor", "Val.Pago", "Vencimento", "Pagamento"};
        
        //Variáveis referente ao layout do relatório
        float yPosition = 720; // Posição vertical inicial para os títulos
        float xPosition = 50; // Posição horizontal inicial para os títulos
        int limiteCaracteres = 35; // Limite de caracteres 
        final int layout = 4;
        final float tamanhoFonteTitulo = 18;   
        final PDFont timesBold =  new PDType1Font(FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont times =  new PDType1Font(FontName.TIMES_ROMAN); //Definindo a fonte
        
        // Criar um novo documento PDF
        final PDDocument documentoPDF = new PDDocument();
        PDPageContentStream fluxoConteudo = null;

        // Adicionar uma nova página ao documento
        final PDPage paginaPDF = new PDPage(PDRectangle.A4);//Tamanho da página
        documentoPDF.addPage(paginaPDF);
        
        try {         
            // Criar o conteúdo para a página      
            fluxoConteudo = new PDPageContentStream(documentoPDF, paginaPDF);             
            //Gerando o título do relatório
            this.funcoesRelatorio.primeiroTituloRelatorio(tamanhoFonteTitulo, titulo, fluxoConteudo, paginaPDF); 
            //Gerando o sub título do relatório
            this.funcoesRelatorio.subTituloRelatorio(subTitulo, fluxoConteudo, paginaPDF);   
     
            // Iterar sobre as contas a pagar
            for (ContasPagar cp : listaContasPagar) {              
                if(formaPagto == null || formaPagto.getCodigo() != cp.getFormaPagto().getCodigo()){ 

                    if(formaPagto == null){
                        yPosition -= 30; // Pular para a linha abaixo após o título
                    }else{           
                       //Define o posicinamento vertical e orizontal do próximo conteúdo
                        yPosition -= 10;                      
                        funcoesRelatorio.valoresDoisTotalizadores("Valor Pago:        ", "Valor Pendente: ", totalPago,totalPendente, yPosition, fluxoConteudo);
                        xPosition = 50;
                        yPosition -= 50; // Pular para a linha abaixo após o título
                    }

                    String tituloLayout = cp.getFormaPagto().getNome();
                    this.funcoesRelatorio.tituloLayoutEsquerda(tituloLayout, yPosition, xPosition, fluxoConteudo); 
                    
                    formaPagto = cp.getFormaPagto();  
                    yPosition -= 20;
                    
                    // Definir os títulos das colunas
                    this.funcoesRelatorio.tituloColunaRelatorioContasPagarReceber(layout, yPosition, xPosition, titulosTabela, fluxoConteudo); 
                    yPosition -= 20;
                    
                    //Zerando os valores dos totais por data, para calcular o próximo total do próximo grupo de dados
                    totalPago = 0;
                    totalPendente = 0;
                }           

                xPosition = 50; // Resetar a posição horizontal a cada nova linha
                
                if (yPosition < 70) { // Se a posição Y estiver abaixo do limite da página, criar uma nova página
                    fluxoConteudo.close();
                    PDPage novaPagina = new PDPage(PDRectangle.A4); // Tamanho da página
                    documentoPDF.addPage(novaPagina);
                    fluxoConteudo = new PDPageContentStream(documentoPDF, novaPagina);
                    yPosition = 750; // Resetar a posição Y para o topo da nova página
                }

                // Obter os dados da lista (exemplo de como acessar a lista e pegar os dados)
                String codFornecedor = String.valueOf(cp.getFornecedor().getCodigo());
                String nomeFornecedor = cp.getFornecedor().getNome();
                String numNota = String.valueOf(cp.getNumNota());
                String parcela = cp.getTotalParcela();
                String valorDuplicata = this.conversor.formatarDoubleString(cp.getValor()).replace(".", ",");
                String valorPago = this.conversor.formatarDoubleString(cp.getValorPago()).replace(".", ",");
                String dataVencimento = conversor.convertendoDataStringSql((java.sql.Date) cp.getDataVencimento());
                String dataPagamento = conversor.convertendoDataStringSql((java.sql.Date) cp.getDataPagamento());
                
                if (nomeFornecedor.length() > limiteCaracteres) {
                    nomeFornecedor = nomeFornecedor.substring(0, limiteCaracteres); // Truncar e adicionar "..."
                }

                // Desenhar os dados da linha na tabela
                fluxoConteudo.beginText();
                fluxoConteudo.setFont(times, 10);

                fluxoConteudo.newLineAtOffset(xPosition, yPosition);
                fluxoConteudo.showText(codFornecedor);
                xPosition += (timesBold.getStringWidth(titulosTabela[0]) / 1000 * 11) - 35; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(nomeFornecedor);
                xPosition += (timesBold.getStringWidth(titulosTabela[1]) / 1000 * 11) + 90; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(numNota);
                xPosition += (timesBold.getStringWidth(titulosTabela[2]) / 1000 * 11) - 165; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(parcela);
                xPosition += (timesBold.getStringWidth(titulosTabela[3]) / 1000 * 11) - 25; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valorDuplicata);
                xPosition += (timesBold.getStringWidth(titulosTabela[4]) / 1000 * 11) - 5; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valorPago);
                xPosition += (timesBold.getStringWidth(titulosTabela[5]) / 1000 * 11) - 35; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(dataVencimento);
                xPosition += (timesBold.getStringWidth(titulosTabela[6]) / 1000 * 11) - 55; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(dataPagamento);

                fluxoConteudo.endText();

                // Descer para a próxima linha
                yPosition -= 20; // Ajuste o espaçamento vertical conforme necessário   
                
                totalPago += cp.getValorPago();
                totalPendente += (cp.getValor() - cp.getValorPago());
                totalValorPago += cp.getValorPago();
                totalValorPendente += (cp.getValor() - cp.getValorPago());
                totalValorCp += cp.getValor();   
            }
            //Define o posicinamento vertical e orizontal do próximo conteúdo
            yPosition -= 10;
                              
            funcoesRelatorio.valoresDoisTotalizadores("Valor Pago:        ", "Valor Pendente: ", totalPago,totalPendente,yPosition,fluxoConteudo);
            //Define o posicinamento vertical e orizontal do próximo conteúdo
            yPosition -= 50;
 
            funcoesRelatorio.valoresTresTotalizadores("Valor Pago:        ", "Valor Pendente: ", "Valor Total CP: ", totalValorPago,totalValorPendente,totalValorCp,yPosition,fluxoConteudo);
            
            fluxoConteudo.close();
            this.funcoesRelatorio.salvarRelatorioPDF("RelatorioContasPagar",documentoPDF);        
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o relatório, layout por forma de pagamento", "Atenção", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (fluxoConteudo != null) {
                    fluxoConteudo.close();
                }
                if (documentoPDF != null) {
                    documentoPDF.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar salvar o arquivo PDF", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    private void layoutStatusPagamento(List<ContasPagar> listaContasPagar){
        
        //Variável referente aos dados do relatório
        double totalPago = 0;
        double totalPendente = 0;
        double totalValorPago = 0;
        double totalValorPendente = 0;
        double totalValorCp = 0;  
        String statusCp = null;
        final String dataInicial = this.dataInicial.getText();
        final String dataFinal = this.dataFinal.getText();
        final String subTitulo = "Período de "+dataInicial+" até "+dataFinal;
        final String titulo = "Relatório de Contas a Pagar (Forma Pagamento)";  
        final String[] titulosTabela = {"Cód", "Fornecedor", "Nota", "Parc", "Valor", "Val.Pago", "Vencimento", "Pagamento"};
        
        //Variáveis referente ao layout do relatório
        float yPosition = 720; // Posição vertical inicial para os títulos
        float xPosition = 50; // Posição horizontal inicial para os títulos   
        final int layout = 5;
        final float tamanhoFonteTitulo = 18; 
        final int limiteCaracteres = 35; // Limite de caracteres (ajuste conforme necessário)
        final PDFont timesBold =  new PDType1Font(FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont times =  new PDType1Font(FontName.TIMES_ROMAN); //Definindo a fonte
        
        // Criar um novo documento PDF
        final PDDocument documentoPDF = new PDDocument();
        PDPageContentStream fluxoConteudo = null;

        // Adicionar uma nova página ao documento
        final PDPage paginaPDF = new PDPage(PDRectangle.A4);//Tamanho da página
        documentoPDF.addPage(paginaPDF);  
        
        try {         
            // Criar o conteúdo para a página      
            fluxoConteudo = new PDPageContentStream(documentoPDF, paginaPDF);          
            //Gerando o título do relatório
            this.funcoesRelatorio.primeiroTituloRelatorio(tamanhoFonteTitulo, titulo, fluxoConteudo, paginaPDF);            
            //Gerando o sub título do relatório
            this.funcoesRelatorio.subTituloRelatorio(subTitulo, fluxoConteudo, paginaPDF);   
            
            // Iterar sobre as contas a pagar
            for (ContasPagar cp : listaContasPagar) {              
                if(statusCp == null || !statusCp.equalsIgnoreCase(cp.getDescricaoStatus())){ 
                    if(statusCp == null){
                        yPosition -= 30; // Pular para a linha abaixo após o título
                    }else{             
                       //Define o posicinamento vertical e orizontal do próximo conteúdo
                        yPosition -= 10;
                        
                        funcoesRelatorio.valoresDoisTotalizadores("Valor Pago:        ", "Valor Pendente: ", totalPago,totalPendente, yPosition, fluxoConteudo);
                        xPosition = 50;
                        yPosition -= 50; // Pular para a linha abaixo após o título
                    }

                    String tituloLayout = cp.getDescricaoStatus();
                    this.funcoesRelatorio.tituloLayoutEsquerda(tituloLayout, yPosition, xPosition, fluxoConteudo); 
                    
                    statusCp = cp.getDescricaoStatus();  
                    yPosition -= 20;
                    
                    // Definir os títulos das colunas
                    this.funcoesRelatorio.tituloColunaRelatorioContasPagarReceber(layout, yPosition, xPosition, titulosTabela, fluxoConteudo); 
                    yPosition -= 20;
                    
                    //Zerando os valores dos totais por data, para calcular o próximo total do próximo grupo de dados
                    totalPago = 0;
                    totalPendente = 0;
                }           

                xPosition = 50; // Resetar a posição horizontal a cada nova linha
                
                if (yPosition < 70) { // Se a posição Y estiver abaixo do limite da página, criar uma nova página
                    fluxoConteudo.close();
                    PDPage novaPagina = new PDPage(PDRectangle.A4); // Tamanho da página
                    documentoPDF.addPage(novaPagina);
                    fluxoConteudo = new PDPageContentStream(documentoPDF, novaPagina);
                    yPosition = 750; // Resetar a posição Y para o topo da nova página
                }

                // Obter os dados da lista
                String codFornecedor = String.valueOf(cp.getFornecedor().getCodigo());
                String nomeFornecedor = cp.getFornecedor().getNome();
                String numNota = String.valueOf(cp.getNumNota());
                String parcela = cp.getTotalParcela();
                String valorDuplicata = this.conversor.formatarDoubleString(cp.getValor()).replace(".", ",");
                String valorPago = this.conversor.formatarDoubleString(cp.getValorPago()).replace(".", ",");
                String dataVencimento = conversor.convertendoDataStringSql((java.sql.Date) cp.getDataVencimento());
                String dataPagamento = conversor.convertendoDataStringSql((java.sql.Date) cp.getDataPagamento());
                
                //Verifica o tamanho do nome do forncedor, e altera para caber na página.
                if (nomeFornecedor.length() > limiteCaracteres) {
                    nomeFornecedor = nomeFornecedor.substring(0, limiteCaracteres); // Truncar e adicionar "..."
                }

                // Desenhar os dados da linha na tabela
                fluxoConteudo.beginText();
                fluxoConteudo.setFont(times, 10);

                fluxoConteudo.newLineAtOffset(xPosition, yPosition);
                fluxoConteudo.showText(codFornecedor);
                xPosition += (timesBold.getStringWidth(titulosTabela[0]) / 1000 * 11) - 35; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(nomeFornecedor);
                xPosition += (timesBold.getStringWidth(titulosTabela[1]) / 1000 * 11) + 90; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(numNota);
                xPosition += (timesBold.getStringWidth(titulosTabela[2]) / 1000 * 11) - 165; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(parcela);
                xPosition += (timesBold.getStringWidth(titulosTabela[3]) / 1000 * 11) - 25; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valorDuplicata);
                xPosition += (timesBold.getStringWidth(titulosTabela[4]) / 1000 * 11) - 5; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valorPago);
                xPosition += (timesBold.getStringWidth(titulosTabela[5]) / 1000 * 11) - 35; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(dataVencimento);
                xPosition += (timesBold.getStringWidth(titulosTabela[6]) / 1000 * 11) - 55; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(dataPagamento);

                fluxoConteudo.endText();

                // Descer para a próxima linha
                yPosition -= 20; // Ajuste o espaçamento vertical conforme necessário 
                
                totalPago += cp.getValorPago();
                totalPendente += (cp.getValor() - cp.getValorPago());
                totalValorPago += cp.getValorPago();
                totalValorPendente += (cp.getValor() - cp.getValorPago());
                totalValorCp += cp.getValor(); 
                
            }
            //Define o posicinamento vertical e orizontal do próximo conteúdo
            yPosition -= 10;
                              
            funcoesRelatorio.valoresDoisTotalizadores("Valor Pago:        ", "Valor Pendente: ", totalPago,totalPendente,yPosition,fluxoConteudo);
            //Define o posicinamento vertical e orizontal do próximo conteúdo
            yPosition -= 50;
 
            funcoesRelatorio.valoresTresTotalizadores("Valor Pago:        ", "Valor Pendente: ", "Valor Total CP: ", totalValorPago,totalValorPendente,totalValorCp,yPosition,fluxoConteudo);
            
            fluxoConteudo.close();
            this.funcoesRelatorio.salvarRelatorioPDF("RelatorioContasPagar",documentoPDF);       
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o relatório, layout por forma de pagamento", "Atenção", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (fluxoConteudo != null) {
                    fluxoConteudo.close();
                }
                if (documentoPDF != null) {
                    documentoPDF.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar salvar o arquivo PDF", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    private void layoutIgreja(List<ContasPagar> listaContasPagar){
        
        //Variáveis referente aos dados do relatório
        double totalPago = 0;
        double totalPendente = 0;
        double totalValorPago = 0;
        double totalValorPendente = 0;
        double totalValorCp = 0;    
        final String dataInicial = this.dataInicial.getText();
        final String dataFinal = this.dataFinal.getText();
        final String subTitulo = "Período de "+dataInicial+" até "+dataFinal;
        final String titulo = "Relatório de Contas a Pagar (Forma Pagamento)"; 
        final String[] titulosTabela = {"Cód", "Fornecedor", "Nota", "Parc", "Valor", "Val.Pago", "Vencimento", "Pagamento"};
        Igreja igreja = null;
        
        //Variáveis referente ao layout do relatório
        float yPosition = 720; // Posição vertical inicial para os títulos
        float xPosition = 50; // Posição horizontal inicial para os títulos
        final int layout = 6;
        final int limiteCaracteres = 35; // Limite de caracteres
        final float tamanhoFonteTitulo = 18; 
        final PDFont timesBold =  new PDType1Font(FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont times =  new PDType1Font(FontName.TIMES_ROMAN); //Definindo a fonte
        
        // Criar um novo documento PDF
        final PDDocument documentoPDF = new PDDocument();
        PDPageContentStream fluxoConteudo = null;

        // Adicionar uma nova página ao documento
        final PDPage paginaPDF = new PDPage(PDRectangle.A4);//Tamanho da página
        documentoPDF.addPage(paginaPDF);
        
        try {         
            // Criar o conteúdo para a página      
            fluxoConteudo = new PDPageContentStream(documentoPDF, paginaPDF);             
            //Gerando o título do relatório
            this.funcoesRelatorio.primeiroTituloRelatorio(tamanhoFonteTitulo, titulo, fluxoConteudo, paginaPDF);            
            //Gerando o sub título do relatório
            this.funcoesRelatorio.subTituloRelatorio(subTitulo, fluxoConteudo, paginaPDF);   
               
            // Iterar sobre as contas a pagar
            for (ContasPagar cp : listaContasPagar) {      
                //Divisão pelo layout
                if(igreja == null || igreja.getCodigo() != cp.getIgreja().getCodigo()){ 
                    if(igreja == null){
                        yPosition -= 30; // Pular para a linha abaixo após o título
                    }else{             
                       //Define o posicinamento vertical e orizontal do próximo conteúdo
                        yPosition -= 10;
                        
                        funcoesRelatorio.valoresDoisTotalizadores("Valor Pago:        ", "Valor Pendente: ", totalPago,totalPendente, yPosition, fluxoConteudo);
                        xPosition = 50;
                        yPosition -= 50; // Pular para a linha abaixo após o título
                    }
                
                    String tituloLayout = cp.getIgreja().getNome();
                    this.funcoesRelatorio.tituloLayoutEsquerda(tituloLayout, yPosition, xPosition, fluxoConteudo); 
                    
                    igreja = cp.getIgreja();  
                    yPosition -= 20;
                    
                    // Definir os títulos das colunas
                    this.funcoesRelatorio.tituloColunaRelatorioContasPagarReceber(layout, yPosition, xPosition, titulosTabela, fluxoConteudo); 
                    yPosition -= 20;
                    
                    //Zerando os valores dos totais por data, para calcular o próximo total do próximo grupo de dados
                    totalPago = 0;
                    totalPendente = 0;
                }           

                xPosition = 50; // Resetar a posição horizontal a cada nova linha
                
                if (yPosition < 70) { // Se a posição Y estiver abaixo do limite da página, criar uma nova página
                    fluxoConteudo.close();
                    PDPage novaPagina = new PDPage(PDRectangle.A4); // Tamanho da página
                    documentoPDF.addPage(novaPagina);
                    fluxoConteudo = new PDPageContentStream(documentoPDF, novaPagina);
                    yPosition = 750; // Resetar a posição Y para o topo da nova página
                }

                // Obter os dados da lista
                String codFornecedor = String.valueOf(cp.getFornecedor().getCodigo());
                String nomeFornecedor = cp.getFornecedor().getNome();
                String numNota = String.valueOf(cp.getNumNota());
                String parcela = cp.getTotalParcela();
                String valorDuplicata = this.conversor.formatarDoubleString(cp.getValor()).replace(".", ",");
                String valorPago = this.conversor.formatarDoubleString(cp.getValorPago()).replace(".", ",");
                String dataVencimento = conversor.convertendoDataStringSql((java.sql.Date) cp.getDataVencimento());
                String dataPagamento = conversor.convertendoDataStringSql((java.sql.Date) cp.getDataPagamento());
                
                //Verifica o tamanho do nome do forencedor e reduz, caso necessário
                if (nomeFornecedor.length() > limiteCaracteres) {
                    nomeFornecedor = nomeFornecedor.substring(0, limiteCaracteres); // Truncar e adicionar "..."
                }

                // Desenhar os dados da linha na tabela
                fluxoConteudo.beginText();
                fluxoConteudo.setFont(times, 10);

                fluxoConteudo.newLineAtOffset(xPosition, yPosition);
                fluxoConteudo.showText(codFornecedor);
                xPosition += (timesBold.getStringWidth(titulosTabela[0]) / 1000 * 11) - 35; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(nomeFornecedor);
                xPosition += (timesBold.getStringWidth(titulosTabela[1]) / 1000 * 11) + 90; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(numNota);
                xPosition += (timesBold.getStringWidth(titulosTabela[2]) / 1000 * 11) - 165; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(parcela);
                xPosition += (timesBold.getStringWidth(titulosTabela[3]) / 1000 * 11) - 25; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valorDuplicata);
                xPosition += (timesBold.getStringWidth(titulosTabela[4]) / 1000 * 11) - 5; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valorPago);
                xPosition += (timesBold.getStringWidth(titulosTabela[5]) / 1000 * 11) - 35; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(dataVencimento);
                xPosition += (timesBold.getStringWidth(titulosTabela[6]) / 1000 * 11) - 55; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(dataPagamento);

                fluxoConteudo.endText();

                // Descer para a próxima linha
                yPosition -= 20; // Ajuste o espaçamento vertical conforme necessário   
                
                totalPago += cp.getValorPago();
                totalPendente += (cp.getValor() - cp.getValorPago());
                totalValorPago += cp.getValorPago();
                totalValorPendente += (cp.getValor() - cp.getValorPago());
                totalValorCp += cp.getValor();     
            }
            //Define o posicinamento vertical e orizontal do próximo conteúdo
            yPosition -= 10;
                              
            funcoesRelatorio.valoresDoisTotalizadores("Valor Pago:        ", "Valor Pendente: ", totalPago,totalPendente,yPosition,fluxoConteudo);
            //Define o posicinamento vertical e orizontal do próximo conteúdo
            yPosition -= 50;
 
            funcoesRelatorio.valoresTresTotalizadores("Valor Pago:        ", "Valor Pendente: ", "Valor Total CP: ", totalValorPago,totalValorPendente,totalValorCp,yPosition,fluxoConteudo);
            
            fluxoConteudo.close();
            this.funcoesRelatorio.salvarRelatorioPDF("RelatorioContasPagar",documentoPDF);        
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o relatório, layout por forma de pagamento", "Atenção", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (fluxoConteudo != null) {
                    fluxoConteudo.close();
                }
                if (documentoPDF != null) {
                    documentoPDF.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar salvar o arquivo PDF", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }
    } 
     
    @Override
    public void pessoaSelecionada(Pessoa pessoaSelecionada) {
        pessoaEscolhida(pessoaSelecionada);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.JTextField codFornecedor;
    private javax.swing.JComboBox<String> contaResultado;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.ButtonGroup filtrosData;
    private javax.swing.JComboBox<String> formaPagto;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JRadioButton rbPadrao;
    private javax.swing.JRadioButton rbPago;
    private javax.swing.JRadioButton rbStatusPagamento;
    private javax.swing.ButtonGroup statusPagamento;
    private javax.swing.JLabel txData;
    // End of variables declaration//GEN-END:variables
}
