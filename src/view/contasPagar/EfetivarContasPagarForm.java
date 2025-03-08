
package view.contasPagar;

import ferramentas.StatusCoresContaPagarReceber;
import dao.ContaCaixaDao;
import dao.ContasPagarDao;
import dao.FormaPagtoDao;
import dao.MovimentoCaixaDao;
import dao.PessoaDao;
import dao.SubContaResultadoDao;
import ferramentas.PaletaCores;
import ferramentas.PersonalizaTabela;
import ferramentas.Utilitarios;
import dao.RegistroOfertaDao;
import dao.TipoOfertaDao;
import dao.UsuarioDao;
import interfaces.ConsultaPessoas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import model.ContaCaixa;
import model.ContasPagar;
import model.FormaPagto;
import model.MovimentoCaixa;
import model.Pessoa;
import model.RegistroDizimoOferta;
import model.SubContaResultado;
import model.TipoOferta;
import model.Usuario;
import view.carregamentoConsultas.TelaConsultasPessoas;

public class EfetivarContasPagarForm extends javax.swing.JInternalFrame implements ConsultaPessoas{
    
    private final PersonalizaTabela personalizaTabela = new PersonalizaTabela();
    private Usuario usuarioLogado = new Usuario();
    private final PessoaDao pessoaDao = new PessoaDao();
    private final TipoOfertaDao tipoOfertaDao = new TipoOfertaDao();
    private final RegistroOfertaDao rgOfertaDao = new RegistroOfertaDao();
    private final ContaCaixaDao contaCaixaDao = new ContaCaixaDao();
    private final FormaPagtoDao formaPagtoDao = new FormaPagtoDao();
    private final ContasPagarDao contasPagarDao = new ContasPagarDao();
    private final MovimentoCaixaDao movimentoCaixaDao = new MovimentoCaixaDao();
    private final SubContaResultadoDao subContResultDao = new SubContaResultadoDao();
    private final PaletaCores paletaCores = new PaletaCores();
    private final Utilitarios conversor = new Utilitarios(); 
    private final ContasPagar contasPagar = new ContasPagar();
    private final Pessoa fornecedor = new Pessoa();  
    private List<ContasPagar> listaContasPagar = null;
    private List<Pessoa> listaFornecedor = null;
    private final UsuarioDao usuarioDao = new UsuarioDao();
    private String filtroIgreja = "";

    public EfetivarContasPagarForm(Usuario usuarioLogado) {
        initComponents();
        this.filtroIgreja = usuarioDao.gerarFiltroIgreja(usuarioLogado);
        this.usuarioLogado = usuarioLogado;
        formInicial();  
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoData = new javax.swing.ButtonGroup();
        grupoParcelas = new javax.swing.ButtonGroup();
        grupoOperacao = new javax.swing.ButtonGroup();
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
        jPanel2 = new javax.swing.JPanel();
        rbSomenteAbertas = new javax.swing.JRadioButton();
        rbSomentePagas = new javax.swing.JRadioButton();
        rbTodasParcelas = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        subContaResultado = new javax.swing.JComboBox<>();
        numNota = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        descricaoContas = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaParcelas = new javax.swing.JTable();
        iconLimpar = new javax.swing.JButton();
        btnEfetivar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        dataPagamento = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        formaPagto = new javax.swing.JComboBox<>();
        contaCaixa = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        numNotaPagar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        numParcelaPagar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        valorPagamento = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        tpOfertaSaida = new javax.swing.JComboBox<>();
        rbConsultar = new javax.swing.JRadioButton();
        rbEfetivar = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        statusCores = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Efetivar/Consultar Contas a Pagar");

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
        codFornecedor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        codFornecedor.setFocusable(false);
        codFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codFornecedorKeyPressed(evt);
            }
        });

        jLabel1.setText("Fornecedor");

        nomeFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeFornecedorKeyPressed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Status Parcela", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        grupoParcelas.add(rbSomenteAbertas);
        rbSomenteAbertas.setText("Somente Abertas");

        grupoParcelas.add(rbSomentePagas);
        rbSomentePagas.setText("Somente Pagas");

        grupoParcelas.add(rbTodasParcelas);
        rbTodasParcelas.setText("Todas as Parcelas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rbSomentePagas)
            .addComponent(rbSomenteAbertas)
            .addComponent(rbTodasParcelas)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rbSomenteAbertas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbSomentePagas, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbTodasParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setText("Conta De Resultado");

        subContaResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                subContaResultadoMousePressed(evt);
            }
        });
        subContaResultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                subContaResultadoKeyPressed(evt);
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

        tabelaParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Descrição", "Fornecedor", "Nota", "Parcela", "Val. Conta", "Val. Pago", "Status", "Data Venc", "Data Pag"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaParcelas.setName(""); // NOI18N
        tabelaParcelas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaParcelas.setShowGrid(false);
        tabelaParcelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaParcelasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaParcelas);
        if (tabelaParcelas.getColumnModel().getColumnCount() > 0) {
            tabelaParcelas.getColumnModel().getColumn(0).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(0).setPreferredWidth(1);
            tabelaParcelas.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabelaParcelas.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabelaParcelas.getColumnModel().getColumn(3).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(3).setPreferredWidth(30);
            tabelaParcelas.getColumnModel().getColumn(4).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(4).setPreferredWidth(25);
            tabelaParcelas.getColumnModel().getColumn(5).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(5).setPreferredWidth(50);
            tabelaParcelas.getColumnModel().getColumn(6).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(6).setPreferredWidth(50);
            tabelaParcelas.getColumnModel().getColumn(7).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(7).setPreferredWidth(50);
            tabelaParcelas.getColumnModel().getColumn(8).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(8).setPreferredWidth(50);
            tabelaParcelas.getColumnModel().getColumn(9).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(9).setPreferredWidth(50);
        }

        iconLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        iconLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        iconLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconLimparActionPerformed(evt);
            }
        });

        btnEfetivar.setBackground(new java.awt.Color(51, 204, 0));
        btnEfetivar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEfetivar.setText("Efetivar");
        btnEfetivar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEfetivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfetivarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados Pagamento", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        try {
            dataPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Data Pagamento");

        jLabel7.setText("Forma de Pagamento");

        jLabel8.setText("Conta Caixa");

        numNotaPagar.setEditable(false);
        numNotaPagar.setBackground(new java.awt.Color(204, 204, 204));
        numNotaPagar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        numNotaPagar.setFocusable(false);

        jLabel10.setText("Nota");

        jLabel11.setText("Parcela");

        numParcelaPagar.setEditable(false);
        numParcelaPagar.setBackground(new java.awt.Color(204, 204, 204));
        numParcelaPagar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        numParcelaPagar.setFocusable(false);

        jLabel12.setText("Valor Pagar");

        valorPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel13.setText("Tp Oferta Saida");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(contaCaixa, 0, 177, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(31, 31, 31))
                            .addComponent(valorPagamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(formaPagto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(numNotaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel11)))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tpOfertaSaida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(numParcelaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpOfertaSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numNotaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(numParcelaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        grupoOperacao.add(rbConsultar);
        rbConsultar.setText("Consultar");
        rbConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbConsultarActionPerformed(evt);
            }
        });

        grupoOperacao.add(rbEfetivar);
        rbEfetivar.setText("Efetivar");
        rbEfetivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEfetivarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Operação");

        statusCores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cardápio-16.png"))); // NOI18N
        statusCores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusCoresActionPerformed(evt);
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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbConsultar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbEfetivar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(codFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(numNota, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(subContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(descricaoContas, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(iconLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusCores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEfetivar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbConsultar)
                                .addComponent(rbEfetivar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(codFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descricaoContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(subContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(statusCores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEfetivar)
                            .addComponent(btnFiltrar)))
                    .addComponent(iconLimpar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codFornecedorKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscarFornecedor();
        } 
    }//GEN-LAST:event_codFornecedorKeyPressed

    private void rbDataVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataVencimentoActionPerformed
        this.txData.setText("Vencimento:");
    }//GEN-LAST:event_rbDataVencimentoActionPerformed

    private void rbDataPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataPagamentoActionPerformed
        this.txData.setText("Pagamento:");
    }//GEN-LAST:event_rbDataPagamentoActionPerformed

    private void rbDataLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataLancamentoActionPerformed
        this.txData.setText("Lançamento:");
    }//GEN-LAST:event_rbDataLancamentoActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        this.listaContasPagar.clear(); //Limpando a lista, antes de receber novos dados.
        consultarContas();
        atualizarTabela();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void iconLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconLimparActionPerformed
        formInicial();
        limparTabela();
    }//GEN-LAST:event_iconLimparActionPerformed

    private void btnEfetivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfetivarActionPerformed
        efetivarCp();
        formEfetivado();
        consultarContas();
        atualizarTabela();
    }//GEN-LAST:event_btnEfetivarActionPerformed

    private void rbEfetivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEfetivarActionPerformed
        formEfetivar();
    }//GEN-LAST:event_rbEfetivarActionPerformed

    private void rbConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbConsultarActionPerformed
        formInicial();
    }//GEN-LAST:event_rbConsultarActionPerformed

    private void subContaResultadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subContaResultadoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.subContaResultado.removeAllItems();
        } 
    }//GEN-LAST:event_subContaResultadoKeyPressed

    private void subContaResultadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subContaResultadoMousePressed
        carregarSubContaResultado();
    }//GEN-LAST:event_subContaResultadoMousePressed

    private void nomeFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeFornecedorKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscarFornecedor();
            carregarResultadoConsultaFornecedor();
        }else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.codFornecedor.setText("");
            this.nomeFornecedor.setText("");
        } 
    }//GEN-LAST:event_nomeFornecedorKeyPressed

    private void tabelaParcelasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaParcelasMousePressed
        dadoContaPagarSelecionada();
    }//GEN-LAST:event_tabelaParcelasMousePressed

    private void statusCoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusCoresActionPerformed
        StatusCoresContaPagarReceber statusCores = new StatusCoresContaPagarReceber((Frame) SwingUtilities.getWindowAncestor(this), true);
        statusCores.setLocationRelativeTo(this);
        statusCores.setVisible(true);
    }//GEN-LAST:event_statusCoresActionPerformed

    private void carregarSubContaResultado(){
        List<SubContaResultado> listaSubContaResult = this.subContResultDao.consultarSubContaResultado();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.subContaResultado.getModel();
        modelo.removeAllElements();
        for(SubContaResultado subCont : listaSubContaResult){
            modelo.addElement(subCont);
        }   
    }
    
    private void carregarFormaPagto(){
        List<FormaPagto> listaFormaPagto = this.formaPagtoDao.consultarFormaPagto();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.formaPagto.getModel();
        modelo.removeAllElements();
        for(FormaPagto pagto : listaFormaPagto){
            modelo.addElement(pagto);
        }
    }
    
    private void carregarContaCaixa(){
        List<ContaCaixa> listaContaCaixa = this.contaCaixaDao.consultarContaCaixa(this.filtroIgreja);
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.contaCaixa.getModel();
        modelo.removeAllElements();
        for(ContaCaixa cx : listaContaCaixa){
            modelo.addElement(cx);
        }
        
    }
    
    private void carregarTipoOferta(){
        List<TipoOferta> listaTpOferta = tipoOfertaDao.consultarTipoOferta();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)tpOfertaSaida.getModel();
        modelo.removeAllElements();
        for(TipoOferta tpOferta : listaTpOferta){
            modelo.addElement(tpOferta);
        }
    }
    
    private void buscarFornecedor(){
        String textoBusca = this.nomeFornecedor.getText(); // Texto digitado na busca        
        this.listaFornecedor = this.pessoaDao.consultarPessoa(textoBusca); //Lista recebe a busca retornada do banco
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
    
    private void consultarContas(){
        
        Date dataLancamentoInicial = null;
        Date dataLancamentoFinal = null;
        Date dataPagamentoInicial = null;
        Date dataPagamentoFinal = null;
        Date dataVencimentoInicial = null;
        Date dataVencimentoFinal = null;
        Integer codForn = null;
        Integer numeroNota = null;
        Integer status = null;
        SubContaResultado subCtResult = (SubContaResultado) this.subContaResultado.getSelectedItem();
        String descricao = this.descricaoContas.getText();
        
        //Tratando o código do fornecedor
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

        
        //Verificando quais radios button das parcelas, foram selecionadas
        if(this.rbSomenteAbertas.isSelected()){
            status = 0;
        }else if(this.rbSomentePagas.isSelected()){
            status = 1;
        }else if(this.rbTodasParcelas.isSelected()){
            status = null;
        }
        
        //Validando qual data foi selecionado, e convertendo a String para tipo data
        if(this.rbDataLancamento.isSelected()){
            dataLancamentoInicial = this.conversor.convertendoStringDateSql(this.dataInicial.getText()); 
            dataLancamentoFinal = this.conversor.convertendoStringDateSql(this.dataFinal.getText());

        }else if(this.rbDataPagamento.isSelected()){
            dataPagamentoInicial = conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataPagamentoFinal = conversor.convertendoStringDateSql(this.dataFinal.getText());

        }else if(this.rbDataVencimento.isSelected()){
            dataVencimentoInicial = conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataVencimentoFinal = conversor.convertendoStringDateSql(this.dataFinal.getText());

        }

        this.contasPagar.setFornecedor(this.fornecedor);
        this.contasPagar.setNumNota(numeroNota);
        this.contasPagar.setSubContaResultado(subCtResult);
        this.contasPagar.setDescricaoConta(descricao);
        this.contasPagar.setStatus(status);
        
        this.listaContasPagar = this.contasPagarDao.consultarContasPagar(this.contasPagar, dataVencimentoInicial, dataVencimentoFinal, dataLancamentoInicial, dataLancamentoFinal, dataPagamentoInicial, dataPagamentoFinal, this.filtroIgreja);  
    }
    
    private void consultarContasAbertasMes(){
        String dataString = conversor.dataAtualString();
        Date dataAtual = conversor.convertendoStringDateSql(dataString);
        
        this.listaContasPagar = this.contasPagarDao.consultarContasPagarMesAtual(dataAtual);
    }
    
    private void atualizarTabela(){
        DefaultTableModel model = (DefaultTableModel) this.tabelaParcelas.getModel();
        model.setNumRows(0);     

        for(ContasPagar cp : this.listaContasPagar){  
            String dataVencimento = this.conversor.convertendoDataStringSql((java.sql.Date) cp.getDataVencimento());
            String dataPagamento = this.conversor.convertendoDataStringSql((java.sql.Date) cp.getDataPagamento());
            model.addRow(new Object[]{" ",cp.getDescricaoConta(), cp.getFornecedor(), cp.getNumNota(), cp.getParcela(), cp.getValor(),  cp.getValorPago(), cp.getDescricaoStatus(), dataVencimento, dataPagamento});
        }
        corBolinhaStatusVencimento();
    }
    
    private void limparTabela(){
        if(this.tabelaParcelas.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) this.tabelaParcelas.getModel();
            model.setRowCount(0);
        }
    }
    
    private void efetivarCp(){
         
        int numLinhaSelec = this.tabelaParcelas.getSelectedRow();
        List<MovimentoCaixa> listaCpEfetivada = new ArrayList<>();
        ContasPagar cpEfetivar = this.listaContasPagar.get(numLinhaSelec);
        
        if(this.rbEfetivar.isSelected() && cpEfetivar.getStatus() == 0){
            //Verifica se foi selecionado algum cliente da lista
            if(this.numNotaPagar.getText().isEmpty() || this.numParcelaPagar.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Selecione a conta a pagar que será efetivada", "Atenção", JOptionPane.WARNING_MESSAGE);
            }else{
                Date dataPagamento = conversor.convertendoStringDateSql(this.dataPagamento.getText());
                final FormaPagto formaPgto = (FormaPagto) this.formaPagto.getSelectedItem();
                final ContaCaixa contaCaixa = (ContaCaixa) this.contaCaixa.getSelectedItem();
                final TipoOferta tpOferta = (TipoOferta) tpOfertaSaida.getSelectedItem();
                Integer numNota = Integer.valueOf(this.numNotaPagar.getText());
                Integer parcela = Integer.valueOf(this.numParcelaPagar.getText());
                double valorParcela = cpEfetivar.getValor();
                double valorPago = Double.parseDouble(this.valorPagamento.getText().replace(",", "."));
                double valorPendente = valorParcela - valorPago;
                String descricao = cpEfetivar.getDescricaoConta();
                cpEfetivar.setValorPago(valorPago);
                cpEfetivar.setValorPendente(valorPendente);
                cpEfetivar.setDataPagamento(dataPagamento);
                
                if(valorPago >= valorParcela){
                    cpEfetivar.setDescricaoStatus("Pago");
                    cpEfetivar.setStatus(1);
                }else if(valorPago < valorParcela){
                    cpEfetivar.setDescricaoStatus("Pendente");
                    cpEfetivar.setStatus(0);
                }

                MovimentoCaixa mvCaixa = new MovimentoCaixa();
                mvCaixa.setContaPagar(cpEfetivar);
                mvCaixa.setDataPagamentoRecebimento(dataPagamento);
                mvCaixa.setFormaPagto(formaPgto);
                mvCaixa.setContaCaixa(contaCaixa);
                mvCaixa.setComplemento("CP "+numNota+"-"+parcela+" | "+descricao);

                listaCpEfetivada.add(mvCaixa);  

                int confirm = JOptionPane.showConfirmDialog(null,"Efetivar as contas selecionadas?", "Confirmar", JOptionPane.YES_NO_OPTION);     
                //Verifica qual a opção escolhida
                if(confirm == JOptionPane.YES_OPTION){
                    RegistroDizimoOferta rgOfertaDizimo = registrarSaidaOfertaDizimo(cpEfetivar,tpOferta,contaCaixa);
                    movimentoCaixaDao.movimentarContasPagas(listaCpEfetivada, this.usuarioLogado, rgOfertaDizimo); 
                    consultarContas();
                    atualizarTabela();
                }else if(confirm == JOptionPane.NO_OPTION){
                    JOptionPane.showMessageDialog(null, "Operação cancelada!");
                }   
            }
        }else{
            JOptionPane.showMessageDialog(null, "Não foi escolhida a opção de efetivação da conta ou a conta escolhida já foi baixada", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private RegistroDizimoOferta registrarSaidaOfertaDizimo(ContasPagar cpEfetivada, TipoOferta tpOferta, ContaCaixa contaCaixa){
        
        String complemento = tpOferta.getNome()+ " | Pagamento CP "+cpEfetivada.getNumNota()+"-"+cpEfetivada.getParcela();

        RegistroDizimoOferta rgDizimoOferta = new RegistroDizimoOferta();    
        rgDizimoOferta.setComplemento(complemento);
        rgDizimoOferta.setTpOferta(tpOferta);
        rgDizimoOferta.setValorOfertaEntrada(0);
        rgDizimoOferta.setValorOfertaSaida(cpEfetivada.getValorPago());
        rgDizimoOferta.setContaCaixa(contaCaixa);
        rgDizimoOferta.setIgreja(cpEfetivada.getIgreja());
        rgDizimoOferta.setUsuario(this.usuarioLogado);
        rgDizimoOferta.setDataOferta(cpEfetivada.getDataPagamento());
        

        return rgDizimoOferta;
    }
    
    private void dadoContaPagarSelecionada(){      
        int linhaSelecionada = this.tabelaParcelas.getSelectedRow();
        Integer nota = (Integer) this.tabelaParcelas.getValueAt(linhaSelecionada, 3);
        Integer parcela = (Integer) this.tabelaParcelas.getValueAt(linhaSelecionada, 4);
        double valorConta = (double) this.tabelaParcelas.getValueAt(linhaSelecionada, 5);
        double valorPago = (double) this.tabelaParcelas.getValueAt(linhaSelecionada, 6);
        
        this.valorPagamento.setText(String.valueOf(valorConta - valorPago));
        this.numNotaPagar.setText(String.valueOf(nota));
        this.numParcelaPagar.setText(String.valueOf(parcela));
    }
    
    private void formInicial(){
        this.rbDataVencimento.setSelected(true);
        this.rbConsultar.setSelected(true);
        this.rbSomenteAbertas.setSelected(true);
        this.dataInicial.setText(conversor.dataAtualString());
        this.dataFinal.setText(conversor.dataAtualString());
        this.dataPagamento.setText(conversor.dataAtualString());
        this.formaPagto.setEnabled(false);
        this.contaCaixa.setEnabled(false);
        this.tpOfertaSaida.setEnabled(false);
        this.dataPagamento.setEnabled(false);
        this.valorPagamento.setEditable(false);
        this.codFornecedor.setText("");
        this.nomeFornecedor.setText("");
        this.descricaoContas.setText("");
        this.numNota.setText("");
        this.numNotaPagar.setText("");
        this.numParcelaPagar.setText("");
        this.subContaResultado.removeAllItems();
        this.personalizaTabela.definirNegritoTituloColuna(tabelaParcelas);
        consultarContasAbertasMes();
        atualizarTabela(); 
        carregarFormaPagto();
        carregarContaCaixa();
        carregarTipoOferta();
        alinharConteudoTabela();
    }
    
    private void formEfetivar(){
        this.dataPagamento.setEnabled(true);
        this.formaPagto.setEnabled(true);
        this.contaCaixa.setEnabled(true);
        this.valorPagamento.setEditable(true);
        this.tpOfertaSaida.setEnabled(true);
    }
    
    private void formEfetivado(){
        this.numParcelaPagar.setText("");
        this.numNotaPagar.setText("");
        this.valorPagamento.setText("");
    }
      
    private void corBolinhaStatusVencimento(){
        // Definindo a cor conforme a data de vencimento
        this.tabelaParcelas.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                // Criar um JLabel para a célula
                JLabel label = new JLabel(value.toString()) {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g); // Chama o método para garantir a renderização padrão da célula

                        // Definir o tamanho do círculo (ajuste de acordo com o tamanho da célula)
                        int diameter = Math.min(getWidth(), getHeight()) - 8; // Aumente o valor (-5, 0 ou outro valor) para maior bolinha

                        // Obter a data de vencimento da linha correspondente (coluna 8)
                        String vencimento = (String) table.getValueAt(row, 8);
                        String status = (String) table.getValueAt(row, 7);

                        // Determinar a cor do círculo com base no vencimento
                        Color corFundo = Color.GRAY; // Cor padrão
                        
                        if(status.equalsIgnoreCase("pago")){
                            corFundo = paletaCores.getAzul(); 
                        }else if(conversor.compararDataComDataAtual(vencimento) == 1 && status.equalsIgnoreCase("aberto")){
                            corFundo = paletaCores.getVermelho(); 
                        }else if(conversor.compararDataComDataAtual(vencimento) == 1 && status.equalsIgnoreCase("pendente")){
                            corFundo = paletaCores.getVermelhoClaro(); 
                        }else if(conversor.compararDataComDataAtual(vencimento) == 2 && status.equalsIgnoreCase("aberto")){
                            corFundo = paletaCores.getAmareloEscuro(); 
                        }else if(conversor.compararDataComDataAtual(vencimento) == 2 && status.equalsIgnoreCase("pendente")){
                            corFundo = paletaCores.getAmareloClaro(); 
                        }else if(conversor.compararDataComDataAtual(vencimento) == 3 && status.equalsIgnoreCase("aberto")){
                            corFundo = paletaCores.getVerdeLimao(); 
                        }else if(conversor.compararDataComDataAtual(vencimento) == 3 && status.equalsIgnoreCase("pendente")){
                            corFundo = paletaCores.getVerdeEscuro(); 
                        }
                        
                        // Definir a cor de preenchimento do círculo
                        g.setColor(corFundo);

                        // Desenhar o círculo (elipse preenchida)
                        g.fillOval((getWidth() - diameter) / 2, (getHeight() - diameter) / 2, diameter, diameter); 
                    }
                };

                // Garantir que o JLabel não tenha borda ou fundo
                label.setOpaque(false); // Deixar o fundo transparente para desenharmos o círculo
                label.setHorizontalAlignment(SwingConstants.CENTER); // Alinhar o texto ao centro (opcional)
                label.setVerticalAlignment(SwingConstants.CENTER); // Alinhar o texto ao centro (opcional)

                return label; // Retorna o JLabel modificado
            }
        });
    }
    
    private void alinharConteudoTabela(){
        
        DefaultTableCellRenderer primeiraColuna = new DefaultTableCellRenderer();
        primeiraColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaParcelas.getColumnModel().getColumn(1).setCellRenderer(primeiraColuna);

        DefaultTableCellRenderer segundaColuna = new DefaultTableCellRenderer();
        segundaColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaParcelas.getColumnModel().getColumn(2).setCellRenderer(segundaColuna);

        DefaultTableCellRenderer terceiraColuna = new DefaultTableCellRenderer();
        terceiraColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaParcelas.getColumnModel().getColumn(3).setCellRenderer(terceiraColuna);
        
        DefaultTableCellRenderer quartaColuna = new DefaultTableCellRenderer();
        quartaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaParcelas.getColumnModel().getColumn(4).setCellRenderer(quartaColuna);
        
        //Alinhamento da data de oferta
        DefaultTableCellRenderer quintaColuna = new DefaultTableCellRenderer();
        quintaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaParcelas.getColumnModel().getColumn(5).setCellRenderer(quintaColuna);
        
        //Alinhamento da data de lançamento
        DefaultTableCellRenderer sextaColuna = new DefaultTableCellRenderer();
        sextaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaParcelas.getColumnModel().getColumn(6).setCellRenderer(sextaColuna);
        
        //Alinhamento da data de lançamento
        DefaultTableCellRenderer setimaColuna = new DefaultTableCellRenderer();
        setimaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaParcelas.getColumnModel().getColumn(7).setCellRenderer(setimaColuna);
        
        //Alinhamento da data de lançamento
        DefaultTableCellRenderer oitavaColuna = new DefaultTableCellRenderer();
        oitavaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaParcelas.getColumnModel().getColumn(9).setCellRenderer(oitavaColuna);
        
        //Alinhamento da data de lançamento
        DefaultTableCellRenderer nonaColuna = new DefaultTableCellRenderer();
        nonaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaParcelas.getColumnModel().getColumn(9).setCellRenderer(nonaColuna);
    }
    
    @Override
    public void pessoaSelecionada(Pessoa pessoaSelecionada) {
        carregarFornecedorEscolhido(pessoaSelecionada);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEfetivar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JTextField codFornecedor;
    private javax.swing.JComboBox<String> contaCaixa;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JFormattedTextField dataPagamento;
    private javax.swing.JTextField descricaoContas;
    private javax.swing.JComboBox<String> formaPagto;
    private javax.swing.ButtonGroup grupoData;
    private javax.swing.ButtonGroup grupoOperacao;
    private javax.swing.ButtonGroup grupoParcelas;
    private javax.swing.JButton iconLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeFornecedor;
    private javax.swing.JTextField numNota;
    private javax.swing.JTextField numNotaPagar;
    private javax.swing.JTextField numParcelaPagar;
    private javax.swing.JRadioButton rbConsultar;
    private javax.swing.JRadioButton rbDataLancamento;
    private javax.swing.JRadioButton rbDataPagamento;
    private javax.swing.JRadioButton rbDataVencimento;
    private javax.swing.JRadioButton rbEfetivar;
    private javax.swing.JRadioButton rbSomenteAbertas;
    private javax.swing.JRadioButton rbSomentePagas;
    private javax.swing.JRadioButton rbTodasParcelas;
    private javax.swing.JButton statusCores;
    private javax.swing.JComboBox<String> subContaResultado;
    private javax.swing.JTable tabelaParcelas;
    private javax.swing.JComboBox<String> tpOfertaSaida;
    private javax.swing.JLabel txData;
    private javax.swing.JFormattedTextField valorPagamento;
    // End of variables declaration//GEN-END:variables
}
