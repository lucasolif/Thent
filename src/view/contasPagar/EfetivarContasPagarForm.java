
package view.contasPagar;

import dao.ContaCaixaDao;
import dao.ContasPagarDao;
import dao.FormaPagtoDao;
import dao.MovimentoCaixaDao;
import dao.PessoaDao;
import dao.SubContaResultadoDao;
import ferramentas.Utilitarios;
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
import model.ContaCaixa;
import model.ContasPagar;
import model.FormaPagto;
import model.MovimentoCaixa;
import model.Pessoa;
import model.SubContaResultado;
import view.carregamentoConsultas.TelaConsultasPessoas;

public class EfetivarContasPagarForm extends javax.swing.JInternalFrame implements ConsultaPessoas{
    
    private final PessoaDao pessoaDao = new PessoaDao();
    private final ContaCaixaDao contaCaixaDao = new ContaCaixaDao();
    private final FormaPagtoDao formaPagtoDao = new FormaPagtoDao();
    private final ContasPagarDao contasPagarDao = new ContasPagarDao();
    private final MovimentoCaixaDao movimentoCaixaDao = new MovimentoCaixaDao();
    private final SubContaResultadoDao subContResultDao = new SubContaResultadoDao();
    private final Utilitarios conversor = new Utilitarios(); 
    private ContasPagar contasPagar = new ContasPagar();
    private Pessoa fornecedor = new Pessoa();  
    private List<ContasPagar> listaContasPagar = new ArrayList<>();
    private List<Pessoa> listaFornecedor = null;

    public EfetivarContasPagarForm() {
        initComponents();
        formInicial();
        this.listaContasPagar.clear(); //Limpando a lista, antes de receber novos dados.
        consultarContas();
        atualizarTabela();
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
        btnBuscar = new javax.swing.JButton();
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
        rbConsultar = new javax.swing.JRadioButton();
        rbEfetivar = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();

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

        btnBuscar.setBackground(new java.awt.Color(0, 153, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbSomentePagas)
                    .addComponent(rbSomenteAbertas)
                    .addComponent(rbTodasParcelas))
                .addContainerGap(21, Short.MAX_VALUE))
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
                "Nota", "Parcela", "Valor (R$)", "Descrição", "Fornecedor", "Data Pag", "Data Venc", "Data Lanc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaParcelas.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tabelaParcelas.setShowGrid(true);
        jScrollPane1.setViewportView(tabelaParcelas);
        if (tabelaParcelas.getColumnModel().getColumnCount() > 0) {
            tabelaParcelas.getColumnModel().getColumn(0).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(0).setPreferredWidth(5);
            tabelaParcelas.getColumnModel().getColumn(1).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(1).setPreferredWidth(10);
            tabelaParcelas.getColumnModel().getColumn(2).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabelaParcelas.getColumnModel().getColumn(3).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(3).setPreferredWidth(200);
            tabelaParcelas.getColumnModel().getColumn(4).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(4).setPreferredWidth(200);
            tabelaParcelas.getColumnModel().getColumn(5).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(6).setResizable(false);
            tabelaParcelas.getColumnModel().getColumn(7).setResizable(false);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(dataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contaCaixa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel8))
                            .addComponent(jLabel7)
                            .addComponent(formaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(descricaoContas, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(numNota, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(subContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbConsultar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbEfetivar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(codFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar)))
                                .addGap(118, 118, 118)))
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(iconLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEfetivar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
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
                                .addComponent(nomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscar)))
                        .addGap(7, 7, 7)
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
                                        .addComponent(numNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEfetivar)
                        .addComponent(btnFiltrar))
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarFornecedor();
    }//GEN-LAST:event_btnBuscarActionPerformed

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
        limparFormulario();
        formInicial();
        limparTabela();
    }//GEN-LAST:event_iconLimparActionPerformed

    private void btnEfetivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfetivarActionPerformed
        efetivarCp();
        atualizarTabela();
    }//GEN-LAST:event_btnEfetivarActionPerformed

    private void rbEfetivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEfetivarActionPerformed
        this.dataPagamento.setEnabled(true);
        this.formaPagto.setEnabled(true);
        this.btnEfetivar.setEnabled(true);
        this.contaCaixa.setEnabled(true);
        this.rbSomenteAbertas.setSelected(true);
        this.rbSomentePagas.setSelected(false);
        this.rbTodasParcelas.setSelected(false);
        this.listaContasPagar.clear();
        consultarContas();
    }//GEN-LAST:event_rbEfetivarActionPerformed

    private void rbConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbConsultarActionPerformed
        this.dataPagamento.setEnabled(false);
        this.formaPagto.setEnabled(false);
        this.btnEfetivar.setEnabled(false);
        this.contaCaixa.setEnabled(false);
        this.rbSomentePagas.setEnabled(true);
        this.rbTodasParcelas.setEnabled(true);
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
        } 
    }//GEN-LAST:event_nomeFornecedorKeyPressed

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
        Integer baixada = null;
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
            baixada = 0;
        }else if(this.rbSomentePagas.isSelected()){
            baixada = 1;
        }else if(this.rbTodasParcelas.isSelected()){
            baixada = null;
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
        this.contasPagar.setStatus(baixada);
        
        this.listaContasPagar = this.contasPagarDao.consultarContasPagar(this.contasPagar, dataVencimentoInicial, dataVencimentoFinal, dataLancamentoInicial, dataLancamentoFinal, dataPagamentoInicial, dataPagamentoFinal);  
    }
    
    private void atualizarTabela(){
        DefaultTableModel model = (DefaultTableModel) this.tabelaParcelas.getModel();
        model.setNumRows(0);

        for(ContasPagar cp : this.listaContasPagar){      
            model.addRow(new Object[]{cp.getNumNota(),cp.getParcela(),cp.getValor(), cp.getDescricaoConta(), cp.getFornecedor().getNome(), cp.getDataPagamento(), cp.getDataVencimento(), cp.getDataCadastro()});
        }
    }
    
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
        List<ContaCaixa> listaContaCaixa = this.contaCaixaDao.consultarCaixa();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.contaCaixa.getModel();
        modelo.removeAllElements();
        for(ContaCaixa cx : listaContaCaixa){
            modelo.addElement(cx);
        }
        
    }
    
    private void limparFormulario(){
        this.codFornecedor.setText("");
        this.nomeFornecedor.setText("");
        this.rbSomenteAbertas.setSelected(true);
        this.rbDataVencimento.setSelected(true);
        this.dataInicial.setText(this.conversor.dataAtualString());
        this.dataFinal.setText(this.conversor.dataAtualString());
        this.dataPagamento.setText(this.conversor.dataAtualString());
        this.descricaoContas.setText("");
        this.numNota.setText("");
        this.subContaResultado.removeAllItems();
    }
    
    private void limparTabela(){
        if(this.tabelaParcelas.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) this.tabelaParcelas.getModel();
            model.setRowCount(0);
        }
    }
    
    private void efetivarCp(){
        
        int[] numLinhaSelec = tabelaParcelas.getSelectedRows();
        List<MovimentoCaixa> listaCpEfetivada = new ArrayList<>();
        
        //Verifica se foi selecionado algum cliente da lista
        if(numLinhaSelec.length < 0){
            JOptionPane.showMessageDialog(null, "Selecione a(s) conta(s) a pagar a ser excluída", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //Selecinando as contas que serão efetivadas
        for(int index : numLinhaSelec){
            
            //Setando a data de pagamento e a forma de pagamento
            String dataPagamento = this.dataPagamento.getText();
            FormaPagto formaPgto = (FormaPagto) this.formaPagto.getSelectedItem();
            ContaCaixa contaCaixa = (ContaCaixa) this.contaCaixa.getSelectedItem();
            Integer numNota = this.listaContasPagar.get(index).getNumNota();
            Integer parcela = this.listaContasPagar.get(index).getParcela();
            String descricao = this.listaContasPagar.get(index).getDescricaoConta();
            
            MovimentoCaixa mvCaixa = new MovimentoCaixa();
            mvCaixa.setContaPagar(this.listaContasPagar.get(index));
            mvCaixa.setDataPagamentoRecebimento(dataPagamento);
            mvCaixa.setFormaPagto(formaPgto);
            mvCaixa.setContaCaixa(contaCaixa);
            mvCaixa.setComplemento("CP "+numNota+"-"+parcela+" | "+descricao);
            
            //Lista de exclusão receber o dado da lista de contas a pagar no indice selecionado, uma vez que o indíce da tabela é o mesmo da lista
            listaCpEfetivada.add(mvCaixa);  

            //Excluí a conta da lista de contas a pagar para a tabela ser atualizada
            this.listaContasPagar.remove(index);          
        }

        int confirm = JOptionPane.showConfirmDialog(null,"Efetivar as contas selecionadas?", "Confirmar", JOptionPane.YES_NO_OPTION);     
        //Verifica qual a opção escolhida
        if(confirm == JOptionPane.YES_OPTION){
            movimentoCaixaDao.movimentarContasPagar(listaCpEfetivada);
        }else if(confirm == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }      
    }
    
    private void formInicial(){
        this.rbDataVencimento.setSelected(true);
        carregarFormaPagto();
        carregarContaCaixa();
        this.rbSomenteAbertas.setSelected(true);
        this.rbConsultar.setSelected(true);
        this.rbSomentePagas.setEnabled(true);
        this.rbTodasParcelas.setEnabled(true);
        this.dataInicial.setText(conversor.dataAtualString());
        this.dataFinal.setText(conversor.dataAtualString());
        this.dataPagamento.setText(conversor.dataAtualString());
        this.formaPagto.setEnabled(false);
        this.contaCaixa.setEnabled(false);
        this.dataPagamento.setEnabled(false);
        this.btnEfetivar.setEnabled(false);
        consultarContas();
        atualizarTabela(); 
    }
    
    @Override
    public void pessoaSelecionada(Pessoa pessoaSelecionada) {
        carregarFornecedorEscolhido(pessoaSelecionada);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
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
    private javax.swing.JRadioButton rbConsultar;
    private javax.swing.JRadioButton rbDataLancamento;
    private javax.swing.JRadioButton rbDataPagamento;
    private javax.swing.JRadioButton rbDataVencimento;
    private javax.swing.JRadioButton rbEfetivar;
    private javax.swing.JRadioButton rbSomenteAbertas;
    private javax.swing.JRadioButton rbSomentePagas;
    private javax.swing.JRadioButton rbTodasParcelas;
    private javax.swing.JComboBox<String> subContaResultado;
    private javax.swing.JTable tabelaParcelas;
    private javax.swing.JLabel txData;
    // End of variables declaration//GEN-END:variables
}
