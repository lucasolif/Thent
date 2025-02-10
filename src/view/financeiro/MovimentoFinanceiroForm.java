
package view.financeiro;

import dao.ContaCaixaDao;
import dao.FormaPagtoDao;
import dao.IgrejaDao;
import dao.MovimentoCaixaDao;
import dao.PessoaDao;
import dao.RegistroOfertaDao;
import dao.TipoOfertaDao;
import dao.TransferenciaDepositoDao;
import Services.Utilitarios;
import Services.PaletaCores;
import interfaces.ConsultaPessoas;
import java.awt.Color;
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
import model.FormaPagto;
import model.Igreja;
import model.MovimentoCaixa;
import model.Pessoa;
import model.RegistroDizimoOferta;
import model.TipoOferta;
import model.UsuarioLogado;
import view.carregamentoConsultas.TelaConsultasPessoas;

public class MovimentoFinanceiroForm extends javax.swing.JInternalFrame implements ConsultaPessoas{

    private final PessoaDao pessoaDao = new PessoaDao();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final ContaCaixaDao contaCaixaDao = new ContaCaixaDao();
    private final FormaPagtoDao formaPagtoDao = new FormaPagtoDao();
    private final TipoOfertaDao tipoOfertaDao = new TipoOfertaDao();
    private final RegistroOfertaDao rgOfertaDao = new RegistroOfertaDao();
    private final MovimentoCaixaDao movimentoCaixaDao = new MovimentoCaixaDao();
    private final TransferenciaDepositoDao transfDeposiDao = new TransferenciaDepositoDao();
    private RegistroDizimoOferta rgDizimoOferta = new RegistroDizimoOferta();
    private final PaletaCores cores = new PaletaCores();
    private Pessoa pessoa = new Pessoa();
    private final Utilitarios conversor = new Utilitarios();
    private MovimentoCaixa movimentoCaixa = new MovimentoCaixa();
    private List<MovimentoCaixa> listaMovimentacao = new ArrayList<>();
    private List<Pessoa> listaOfertante = null;
    private UsuarioLogado usuarioLogado;

    public MovimentoFinanceiroForm(UsuarioLogado usuarioLogado) {
        initComponents();
        configInicial();
        carregarContaCaixaSaldo();
        atualizarSaldoBancos();
        this.usuarioLogado = usuarioLogado;
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoData = new javax.swing.ButtonGroup();
        grupoTpMovi = new javax.swing.ButtonGroup();
        codFornecedorOfertante = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nomeFornecedorOfertante = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rbDataPagtoRecebimento = new javax.swing.JRadioButton();
        rbDataMovimentacao = new javax.swing.JRadioButton();
        txData = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        descricaoMovimento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        contaCaixa = new javax.swing.JComboBox<>();
        tipoOferta = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        formaPagto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMovimentacoes = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        igreja = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totalEntrada = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        totalSaida = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        totalDizimo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        totalOfertas = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        contaCaixaSaldoBanco = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        valorEntrada = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        valorSaida = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        saldo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        rbSaida = new javax.swing.JRadioButton();
        rbEntrada = new javax.swing.JRadioButton();
        rbEntradaSaida = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Movimento Financeiro");

        codFornecedorOfertante.setEditable(false);
        codFornecedorOfertante.setBackground(new java.awt.Color(204, 204, 204));
        codFornecedorOfertante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        codFornecedorOfertante.setFocusable(false);

        jLabel1.setText("Fornecedor/Ofertante");

        nomeFornecedorOfertante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeFornecedorOfertanteKeyPressed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(0, 153, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setPreferredSize(new java.awt.Dimension(46, 23));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtros Por Data De:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        grupoData.add(rbDataPagtoRecebimento);
        rbDataPagtoRecebimento.setText("Pagamento/Recebimento");
        rbDataPagtoRecebimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataPagtoRecebimentoActionPerformed(evt);
            }
        });

        grupoData.add(rbDataMovimentacao);
        rbDataMovimentacao.setText("Movimentação");
        rbDataMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataMovimentacaoActionPerformed(evt);
            }
        });

        txData.setText("Movimentação:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbDataMovimentacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDataPagtoRecebimento))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txData, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDataPagtoRecebimento)
                    .addComponent(rbDataMovimentacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataInicial)
                    .addComponent(dataFinal)
                    .addComponent(jLabel4)
                    .addComponent(txData))
                .addContainerGap())
        );

        jLabel2.setText("Descrição da Movimentação");

        jLabel3.setText("Conta Caixa");

        contaCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contaCaixaMouseClicked(evt);
            }
        });
        contaCaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contaCaixaKeyPressed(evt);
            }
        });

        tipoOferta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tipoOfertaMouseClicked(evt);
            }
        });
        tipoOferta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tipoOfertaKeyPressed(evt);
            }
        });

        jLabel5.setText("Tipo de Oferta");

        formaPagto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formaPagtoMouseClicked(evt);
            }
        });
        formaPagto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formaPagtoKeyPressed(evt);
            }
        });

        jLabel6.setText("Forma Pagto");

        btnFiltrar.setBackground(new java.awt.Color(255, 102, 0));
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Movimentações Financeiras", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaMovimentacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pessoa", "Operação", "Entrada", "Saída", "Data Movim", "Data PagtoRec", "Conta Caixa", "Forma Pagto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
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
        jScrollPane1.setViewportView(tabelaMovimentacoes);
        if (tabelaMovimentacoes.getColumnModel().getColumnCount() > 0) {
            tabelaMovimentacoes.getColumnModel().getColumn(0).setResizable(false);
            tabelaMovimentacoes.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabelaMovimentacoes.getColumnModel().getColumn(1).setResizable(false);
            tabelaMovimentacoes.getColumnModel().getColumn(1).setPreferredWidth(350);
            tabelaMovimentacoes.getColumnModel().getColumn(2).setResizable(false);
            tabelaMovimentacoes.getColumnModel().getColumn(2).setPreferredWidth(20);
            tabelaMovimentacoes.getColumnModel().getColumn(3).setResizable(false);
            tabelaMovimentacoes.getColumnModel().getColumn(3).setPreferredWidth(20);
            tabelaMovimentacoes.getColumnModel().getColumn(4).setResizable(false);
            tabelaMovimentacoes.getColumnModel().getColumn(4).setPreferredWidth(30);
            tabelaMovimentacoes.getColumnModel().getColumn(5).setResizable(false);
            tabelaMovimentacoes.getColumnModel().getColumn(5).setPreferredWidth(30);
            tabelaMovimentacoes.getColumnModel().getColumn(6).setResizable(false);
            tabelaMovimentacoes.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabelaMovimentacoes.getColumnModel().getColumn(7).setResizable(false);
            tabelaMovimentacoes.getColumnModel().getColumn(7).setPreferredWidth(30);
        }

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        igreja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                igrejaMouseClicked(evt);
            }
        });
        igreja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                igrejaKeyPressed(evt);
            }
        });

        jLabel7.setText("Igreja/Campo");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Total Entradas (RS):");

        totalEntrada.setEditable(false);
        totalEntrada.setBackground(new java.awt.Color(204, 204, 204));
        totalEntrada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totalEntrada.setForeground(new java.awt.Color(0, 0, 244));
        totalEntrada.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Total Saída (R$):");

        totalSaida.setEditable(false);
        totalSaida.setBackground(new java.awt.Color(204, 204, 204));
        totalSaida.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totalSaida.setForeground(new java.awt.Color(0, 0, 244));
        totalSaida.setFocusable(false);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Total Dízimo (RS):");

        totalDizimo.setEditable(false);
        totalDizimo.setBackground(new java.awt.Color(204, 204, 204));
        totalDizimo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totalDizimo.setForeground(new java.awt.Color(0, 0, 244));
        totalDizimo.setFocusable(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Total Ofertas (R$):");

        totalOfertas.setEditable(false);
        totalOfertas.setBackground(new java.awt.Color(204, 204, 204));
        totalOfertas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totalOfertas.setForeground(new java.awt.Color(0, 0, 244));
        totalOfertas.setFocusable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Saldo Bancos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        contaCaixaSaldoBanco.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                contaCaixaSaldoBancoItemStateChanged(evt);
            }
        });

        jLabel12.setText("Entrada (R$): ");

        valorEntrada.setEditable(false);
        valorEntrada.setBackground(new java.awt.Color(204, 204, 204));
        valorEntrada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        valorEntrada.setFocusable(false);

        jLabel13.setText("Saída (R$):");

        valorSaida.setEditable(false);
        valorSaida.setBackground(new java.awt.Color(204, 204, 204));
        valorSaida.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        valorSaida.setFocusable(false);

        jLabel14.setText("Saldo (R$):");

        saldo.setEditable(false);
        saldo.setBackground(new java.awt.Color(204, 204, 204));
        saldo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saldo.setForeground(new java.awt.Color(0, 0, 244));
        saldo.setFocusable(false);

        jLabel15.setText("Caixa/Banco:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contaCaixaSaldoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(saldo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addComponent(valorSaida, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(valorEntrada, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contaCaixaSaldoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(valorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(saldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnExcluir.setBackground(new java.awt.Color(255, 0, 0));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        grupoTpMovi.add(rbSaida);
        rbSaida.setText("Somenta Saída");
        rbSaida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbSaidaItemStateChanged(evt);
            }
        });

        grupoTpMovi.add(rbEntrada);
        rbEntrada.setText("Somente Entrada");
        rbEntrada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbEntradaItemStateChanged(evt);
            }
        });

        grupoTpMovi.add(rbEntradaSaida);
        rbEntradaSaida.setText("Entrada e Saída");
        rbEntradaSaida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbEntradaSaidaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalDizimo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalOfertas, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codFornecedorOfertante, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeFornecedorOfertante, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(descricaoMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbEntradaSaida)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbEntrada)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbSaida)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(formaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(tipoOferta, 0, 143, Short.MAX_VALUE)
                                    .addComponent(contaCaixa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codFornecedorOfertante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeFornecedorOfertante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbEntradaSaida)
                                .addComponent(rbEntrada)
                                .addComponent(rbSaida))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(formaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(contaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descricaoMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(totalEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(totalSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(totalDizimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(totalOfertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLimpar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExcluir)
                        .addComponent(btnFiltrar)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbDataPagtoRecebimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataPagtoRecebimentoActionPerformed
        txData.setText("Pagamento:");
    }//GEN-LAST:event_rbDataPagtoRecebimentoActionPerformed

    private void rbDataMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataMovimentacaoActionPerformed
        txData.setText("Movimentação:");
    }//GEN-LAST:event_rbDataMovimentacaoActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparFormulário();
        limparTabela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarFornecedor();
        carregarResultadoConsultaFornecedor();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void contaCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contaCaixaMouseClicked
        carregarContaCaixa();
    }//GEN-LAST:event_contaCaixaMouseClicked

    private void tipoOfertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tipoOfertaMouseClicked
        carregarTipoOferta();
    }//GEN-LAST:event_tipoOfertaMouseClicked

    private void formaPagtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formaPagtoMouseClicked
        carregarFormaPagto();
    }//GEN-LAST:event_formaPagtoMouseClicked

    private void igrejaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_igrejaMouseClicked
        carregarIgrejas();
    }//GEN-LAST:event_igrejaMouseClicked

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        limparTabela();
        consultarMovimentacao();
        atualizarTabela();
        mostrarTotalDizimoOfertas();
        mostrarTotalSaidaEntrada();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void igrejaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_igrejaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            igreja.removeAllItems();
        } 
    }//GEN-LAST:event_igrejaKeyPressed

    private void contaCaixaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contaCaixaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            contaCaixa.removeAllItems();
        } 
    }//GEN-LAST:event_contaCaixaKeyPressed

    private void tipoOfertaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipoOfertaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            tipoOferta.removeAllItems();
        } 
    }//GEN-LAST:event_tipoOfertaKeyPressed

    private void formaPagtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formaPagtoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            formaPagto.removeAllItems();
        } 
    }//GEN-LAST:event_formaPagtoKeyPressed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirMovimentacao();
        configInicial();
        consultarMovimentacao();
        atualizarTabela();
        mostrarTotalDizimoOfertas();
        mostrarTotalSaidaEntrada();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void nomeFornecedorOfertanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeFornecedorOfertanteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscarFornecedor();
            carregarResultadoConsultaFornecedor();
        } 
    }//GEN-LAST:event_nomeFornecedorOfertanteKeyPressed

    private void contaCaixaSaldoBancoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_contaCaixaSaldoBancoItemStateChanged
        atualizarSaldoBancos();
    }//GEN-LAST:event_contaCaixaSaldoBancoItemStateChanged

    private void rbEntradaSaidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbEntradaSaidaItemStateChanged
        limparTabela();
        consultarMovimentacao();
        atualizarTabela();
        mostrarTotalDizimoOfertas();
        mostrarTotalSaidaEntrada();
    }//GEN-LAST:event_rbEntradaSaidaItemStateChanged

    private void rbEntradaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbEntradaItemStateChanged
        limparTabela();
        consultarMovimentacao();
        atualizarTabela();
        mostrarTotalDizimoOfertas();
        mostrarTotalSaidaEntrada();
    }//GEN-LAST:event_rbEntradaItemStateChanged

    private void rbSaidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbSaidaItemStateChanged
        limparTabela();
        consultarMovimentacao();
        atualizarTabela();
        mostrarTotalDizimoOfertas();
        mostrarTotalSaidaEntrada();
    }//GEN-LAST:event_rbSaidaItemStateChanged

    private void buscarFornecedor(){
        String textoBusca = nomeFornecedorOfertante.getText(); // Texto digitado na busca        
        this.listaOfertante = pessoaDao.consultarPessoa(textoBusca); //Lista recebe a busca retornada do banco

    } 
        
    private void carregarResultadoConsultaFornecedor(){
        TelaConsultasPessoas resultConsultParticipante = new TelaConsultasPessoas((Frame) SwingUtilities.getWindowAncestor(this), this.listaOfertante);
        resultConsultParticipante.setPessoaSelecionada(this);
        resultConsultParticipante.setLocationRelativeTo(this);
        resultConsultParticipante.setVisible(true);
    }
    
    private void carregarFornecedorEscolhido(Pessoa pessoa){
        this.codFornecedorOfertante.setText(Integer.toString(pessoa.getCodigo()));
        this.nomeFornecedorOfertante.setText(pessoa.getNome());
    }
    
    private void carregarIgrejas(){
        List<Igreja> listaIgrejas = igrejaDao.consultarTodasIgrejas();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)igreja.getModel();
        modelo.removeAllElements();
        for(Igreja igr : listaIgrejas){
            modelo.addElement(igr);
        }
    }
    
    private void carregarFormaPagto(){
        List<FormaPagto> listaFormaPagto = formaPagtoDao.consultarFormaPagto();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)formaPagto.getModel();
        modelo.removeAllElements();
        for(FormaPagto pagto : listaFormaPagto){
            modelo.addElement(pagto);
        }
    }
    
    private void carregarTipoOferta(){
        List<TipoOferta> listaTpOferta = tipoOfertaDao.consultarTipoOferta();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)tipoOferta.getModel();
        modelo.removeAllElements();
        for(TipoOferta tpOferta : listaTpOferta){
            modelo.addElement(tpOferta);
        }
    }
    
    private void carregarContaCaixa(){
        List<ContaCaixa> listaContaCaixa = contaCaixaDao.consultarContaCaixa();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)contaCaixa.getModel();
        modelo.removeAllElements();
        for(ContaCaixa cx : listaContaCaixa){
            modelo.addElement(cx);

        }
        
    }
    
    private void carregarContaCaixaSaldo(){
        List<ContaCaixa> listaContaCaixa = contaCaixaDao.consultarContaCaixa();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)contaCaixaSaldoBanco.getModel();
        modelo.removeAllElements();
        for(ContaCaixa cx : listaContaCaixa){
            modelo.addElement(cx);
        }    
    }
    
    private void consultarMovimentacao(){
        
        Date dataMovimentoInicial = null;
        Date dataMovimentoFinal = null;
        Date dataPagamentoInicial = null;
        Date dataPagamentoFinal = null;
        Integer codPessoa = null;
        Integer tpMovimentacao = null;
        String descricao = descricaoMovimento.getText();
        ContaCaixa contaCx = (ContaCaixa) contaCaixa.getSelectedItem();
        TipoOferta tpOferta = (TipoOferta) tipoOferta.getSelectedItem();
        FormaPagto formaPagto = (FormaPagto) this.formaPagto.getSelectedItem();
        Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        
        //Tratando o código de pessoa
        if (!this.codFornecedorOfertante.getText().isEmpty()) {
            codPessoa = Integer.valueOf(codFornecedorOfertante.getText());
            this.pessoa.setCodigo(codPessoa);
        }
        
        //Valida qual a data foi escolhida para o filtro
        if(rbDataMovimentacao.isSelected()){
            dataMovimentoInicial = conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataMovimentoFinal = conversor.convertendoStringDateSql(this.dataFinal.getText());
            dataPagamentoInicial = null;
            dataPagamentoFinal = null;
        }else if(rbDataPagtoRecebimento.isSelected()){
            dataPagamentoInicial = conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataPagamentoFinal = conversor.convertendoStringDateSql(this.dataFinal.getText());
            dataMovimentoInicial = null;
            dataMovimentoFinal = null;
        }
        
        if(rbEntrada.isSelected()){
            tpMovimentacao = 1;
        }else if(rbSaida.isSelected()){
            tpMovimentacao = 2;
        }else if(rbEntradaSaida.isSelected()){
            tpMovimentacao = null;
        }
        
        rgDizimoOferta.setTpOferta(tpOferta);
        movimentoCaixa.setPessoa(pessoa);
        movimentoCaixa.setComplemento(descricao);
        movimentoCaixa.setFormaPagto(formaPagto);
        movimentoCaixa.setIgreja(igreja);
        movimentoCaixa.setRgOferta(rgDizimoOferta);
        movimentoCaixa.setContaCaixa(contaCx);
               
        listaMovimentacao = movimentoCaixaDao.consultarMovimentacao(movimentoCaixa, dataPagamentoInicial, dataPagamentoFinal, dataMovimentoInicial, dataMovimentoFinal, tpMovimentacao);
        
    }
    
    private void atualizarTabela(){
        DefaultTableModel model = (DefaultTableModel) tabelaMovimentacoes.getModel();
        model.setNumRows(0);
   
        for(MovimentoCaixa mv : listaMovimentacao){      
            model.addRow(new Object[]{mv.getPessoa().getNome(),mv.getComplemento(),mv.getValorEntrada(), mv.getValorSaida(), mv.getDataMovimento(), mv.getDataPagamentoRecebimento(), mv.getContaCaixa(), mv.getFormaPagto()});
        }
    }
    
    private void mostrarTotalDizimoOfertas(){
        double valorDizimo = 0;
        double valorOferta = 0;
        int qtdLinhasTabela = listaMovimentacao.size();
        
        for(int i = 0; i < qtdLinhasTabela; i++){             
            int tpOferta = listaMovimentacao.get(i).getRgOferta().getTpOferta().getCodigo();
            
            if(tpOferta == 1){
                valorDizimo += listaMovimentacao.get(i).getValorEntrada();
            }else if(tpOferta > 1){
                valorOferta += listaMovimentacao.get(i).getValorEntrada();
            }
        }
        
        totalDizimo.setText(Double.toString(valorDizimo));
        totalOfertas.setText(Double.toString(valorOferta));
    }
    
    private void mostrarTotalSaidaEntrada(){
        double totalEntrada = 0;
        double totalSaida = 0;
        int qtdLinhasTabela = tabelaMovimentacoes.getRowCount();
        
        for(int i = 0; i < qtdLinhasTabela; i++){             
            double valEntrada = (Double) tabelaMovimentacoes.getModel().getValueAt(i, 2);
            double valSaida = (Double) tabelaMovimentacoes.getModel().getValueAt(i, 3);
            
            totalEntrada += valEntrada;
            totalSaida += valSaida;
       
        }  
        
        this.totalEntrada.setText(Double.toString(totalEntrada));
        this.totalSaida.setText(Double.toString(totalSaida));
    }
    
    private void limparTabela(){
        //Primeiro a condição testa se a quantidade de colunas é maior que 0, depois, limpa os dados
        if(tabelaMovimentacoes.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) tabelaMovimentacoes.getModel();
            model.setRowCount(0);
        }
    }
    
    private void limparFormulário(){
        codFornecedorOfertante.setText("");
        nomeFornecedorOfertante.setText("");
        rbEntradaSaida.setSelected(true);
        rbDataMovimentacao.setSelected(true);
        dataInicial.setText(conversor.dataAtualString());
        dataFinal.setText(conversor.dataAtualString());
        descricaoMovimento.setText("");
        contaCaixa.removeAllItems();
        tipoOferta.removeAllItems();
        igreja.removeAllItems();
        formaPagto.removeAllItems();
    }
    
    private void configInicial(){
        rbEntradaSaida.setSelected(true);
        rbDataMovimentacao.setSelected(true);
        dataInicial.setText(conversor.dataAtualString());
        dataFinal.setText(conversor.dataAtualString());
        consultarMovimentacao();
        atualizarTabela();
        mostrarTotalDizimoOfertas();
        mostrarTotalSaidaEntrada();
   }
    
    private void atualizarSaldoBancos(){
        MovimentoCaixa mvCaixa = new MovimentoCaixa();
        
        ContaCaixa contaCx = (ContaCaixa) contaCaixaSaldoBanco.getSelectedItem();
        mvCaixa.setContaCaixa(contaCx);
        
        mvCaixa = movimentoCaixaDao.consultarSaldo(mvCaixa);
        Double valEntrada = mvCaixa.getValorEntrada();
        Double valSaida = mvCaixa.getValorSaida();
        Double valSaldo = valEntrada - valSaida;
        
        this.valorEntrada.setText(Double.toString(valEntrada));
        this.valorSaida.setText(Double.toString(valSaida));
        this.saldo.setText(Double.toString(valSaldo));
        
        //Deiinindo a cor do campo de acordo com o saldo
        if(valSaldo < 0){
            this.saldo.setForeground(Color.red);
        }else{
            this.saldo.setForeground(cores.azul());
        }
    }
    
    private void excluirMovimentacao(){
        int[] numLinhaSelec = tabelaMovimentacoes.getSelectedRows();
        List<MovimentoCaixa> listaMvExcluida = new ArrayList<>();
        
        //Verifica se foi selecionado algum cliente da lista
        if(numLinhaSelec.length < 0){
            JOptionPane.showMessageDialog(null, "Selecione a(s) a movimentação referente ao contas a pagar, a ser excluída", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //Selecinando as contas que foram excluídas
        for(int index : numLinhaSelec){
            //Lista de exclusão receber o dado da lista de contas a pagar no indice selecionado, uma vez que o indíce da tabela é o mesmo da lista
            listaMvExcluida.add(listaMovimentacao.get(index));    
            
            //Excluí a conta da lista de contas a pagar
            //listaMovimentacao.remove(index);
            
        }

        int confirm = JOptionPane.showConfirmDialog(null,"Excluir as contas selecionadas ?", "Confirmar", JOptionPane.YES_NO_OPTION);
        //Verifica qual a opção escolhida
        if(confirm == JOptionPane.YES_OPTION){
            
            //Percorre o vetor para verificar se a movimentacao é referente a transrefencia bancária, deposito ou saque
            for(MovimentoCaixa mvEx: listaMvExcluida){
                if(mvEx.getTransferecia().getCodigo() != null){
                    transfDeposiDao.excluirOperacaoBancaria(mvEx.getTransferecia());
                }if(mvEx.getRgOferta().getCodRegistro() != null){
                    rgOfertaDao.deletarRegistrosMovimento(mvEx.getRgOferta());
                }if(mvEx.getContaPagar().getCodigo() != null){
                    movimentoCaixaDao.excluirMovimentacao(listaMvExcluida);
                }
            }

        }else if(confirm == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        } 
    }
    
    @Override
    public void pessoaSelecionada(Pessoa pessoaSelecionada) {
        carregarFornecedorEscolhido(pessoaSelecionada);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JTextField codFornecedorOfertante;
    private javax.swing.JComboBox<String> contaCaixa;
    private javax.swing.JComboBox<String> contaCaixaSaldoBanco;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JTextField descricaoMovimento;
    private javax.swing.JComboBox<String> formaPagto;
    private javax.swing.ButtonGroup grupoData;
    private javax.swing.ButtonGroup grupoTpMovi;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeFornecedorOfertante;
    private javax.swing.JRadioButton rbDataMovimentacao;
    private javax.swing.JRadioButton rbDataPagtoRecebimento;
    private javax.swing.JRadioButton rbEntrada;
    private javax.swing.JRadioButton rbEntradaSaida;
    private javax.swing.JRadioButton rbSaida;
    private javax.swing.JTextField saldo;
    private javax.swing.JTable tabelaMovimentacoes;
    private javax.swing.JComboBox<String> tipoOferta;
    private javax.swing.JTextField totalDizimo;
    private javax.swing.JTextField totalEntrada;
    private javax.swing.JTextField totalOfertas;
    private javax.swing.JTextField totalSaida;
    private javax.swing.JLabel txData;
    private javax.swing.JTextField valorEntrada;
    private javax.swing.JTextField valorSaida;
    // End of variables declaration//GEN-END:variables
}
