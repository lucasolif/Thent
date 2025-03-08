
package view.campanhas;

import dao.CampanhaDao;
import dao.ContaCaixaDao;
import dao.FormaPagtoDao;
import dao.IgrejaDao;
import dao.MovimentoCaixaDao;
import dao.PessoaDao;
import ferramentas.PaletaCores;
import ferramentas.PersonalizaTabela;
import ferramentas.StatusCoresContaPagarReceber;
import ferramentas.Utilitarios;
import dao.UsuarioDao;
import interfaces.ConsultaPessoas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import model.Campanha;
import model.ContaCaixa;
import model.ContasReceberCampanha;
import model.FormaPagto;
import model.Igreja;
import model.MovimentoCaixa;
import model.ParticipanteCampanha;
import model.Pessoa;
import model.Usuario;
import view.carregamentoConsultas.TelaConsultasPessoas;


public class GerenciarContasReceberForm extends javax.swing.JInternalFrame implements ConsultaPessoas{

    private final PersonalizaTabela personalizaTabela = new PersonalizaTabela();
    private Usuario usuarioLogado = new Usuario();
    private final Utilitarios conversor = new Utilitarios();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final FormaPagtoDao formaPagtoDao = new FormaPagtoDao();
    private final CampanhaDao campanhaDao = new CampanhaDao();
    private final PessoaDao pessoaDao = new PessoaDao();
    private final ContaCaixaDao contaCaixaDao = new ContaCaixaDao();
    private final MovimentoCaixaDao mvCaixaDao = new MovimentoCaixaDao();
    private final PaletaCores paletaCores = new PaletaCores();
    private List<Pessoa> listaParticipantes = null;
    private List<ContasReceberCampanha> listaCrCampanha = null;
    private Pessoa pessoaSelec = null;
    private ParticipanteCampanha participanteSelec = null;
    private final UsuarioDao usuarioDao = new UsuarioDao();
    private String filtroIgreja = "";
    
    public GerenciarContasReceberForm(Usuario usuarioLogado) {
        initComponents();
        this.usuarioLogado = usuarioLogado;
        this.filtroIgreja = usuarioDao.gerarFiltroIgreja(usuarioLogado);
        formInicial();
        tabelaInicial();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusCampanha = new javax.swing.ButtonGroup();
        statusPagamento = new javax.swing.ButtonGroup();
        operacao = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        campanha = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        codParticipante = new javax.swing.JTextField();
        nomeParticipante = new javax.swing.JTextField();
        formaPagto = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        igreja = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCr = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JButton();
        btnBaixar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rbDataVencimento = new javax.swing.JRadioButton();
        rbDataPagamento = new javax.swing.JRadioButton();
        txData = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rbAberto = new javax.swing.JRadioButton();
        rbPago = new javax.swing.JRadioButton();
        rbAmbos = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        rbTodos = new javax.swing.JRadioButton();
        rbEncerrada = new javax.swing.JRadioButton();
        rbAndamento = new javax.swing.JRadioButton();
        rbCancelada = new javax.swing.JRadioButton();
        painelDadosPagamento = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        contaCaixaPagamento = new javax.swing.JComboBox<>();
        dataPagtoPagamento = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        formaPagtoBaixa = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        numContaReceber = new javax.swing.JTextField();
        valorBaixar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        obsPagamento = new javax.swing.JTextField();
        parcelaContaReceber = new javax.swing.JTextField();
        rbConsultar = new javax.swing.JRadioButton();
        rbBaixar = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        statusCores = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gerenciar Contas Receber Campanha");

        jLabel1.setText("Campanha");

        campanha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                campanhaMousePressed(evt);
            }
        });
        campanha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campanhaKeyPressed(evt);
            }
        });

        jLabel2.setText("Participante");

        codParticipante.setEditable(false);
        codParticipante.setBackground(new java.awt.Color(204, 204, 204));
        codParticipante.setFocusable(false);

        nomeParticipante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeParticipanteKeyPressed(evt);
            }
        });

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

        jLabel7.setText("Forma Pagto");

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

        jLabel8.setText("Igreja");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Contas/Parcelas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaCr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Participante", "N° CR", "Parcela", "Val Parcela", "Val Pago", "Dt Venc", "Dt Pagto", "Status", "Campanha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        tabelaCr.setToolTipText("");
        tabelaCr.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaCr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaCrMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCr);
        if (tabelaCr.getColumnModel().getColumnCount() > 0) {
            tabelaCr.getColumnModel().getColumn(0).setResizable(false);
            tabelaCr.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabelaCr.getColumnModel().getColumn(1).setResizable(false);
            tabelaCr.getColumnModel().getColumn(1).setPreferredWidth(250);
            tabelaCr.getColumnModel().getColumn(2).setResizable(false);
            tabelaCr.getColumnModel().getColumn(2).setPreferredWidth(30);
            tabelaCr.getColumnModel().getColumn(3).setResizable(false);
            tabelaCr.getColumnModel().getColumn(3).setPreferredWidth(30);
            tabelaCr.getColumnModel().getColumn(4).setResizable(false);
            tabelaCr.getColumnModel().getColumn(4).setPreferredWidth(40);
            tabelaCr.getColumnModel().getColumn(5).setResizable(false);
            tabelaCr.getColumnModel().getColumn(6).setResizable(false);
            tabelaCr.getColumnModel().getColumn(6).setPreferredWidth(60);
            tabelaCr.getColumnModel().getColumn(7).setResizable(false);
            tabelaCr.getColumnModel().getColumn(7).setPreferredWidth(60);
            tabelaCr.getColumnModel().getColumn(8).setResizable(false);
            tabelaCr.getColumnModel().getColumn(8).setPreferredWidth(40);
            tabelaCr.getColumnModel().getColumn(9).setResizable(false);
            tabelaCr.getColumnModel().getColumn(9).setPreferredWidth(200);
        }

        btnFiltrar.setBackground(new java.awt.Color(51, 153, 255));
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnBaixar.setBackground(new java.awt.Color(255, 102, 0));
        btnBaixar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBaixar.setText("Baixar");
        btnBaixar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaixarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtros Por Data De:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        rbDataVencimento.setText("Vencimento");
        rbDataVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataVencimentoActionPerformed(evt);
            }
        });

        rbDataPagamento.setText("Pagamento");
        rbDataPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataPagamentoActionPerformed(evt);
            }
        });

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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDataVencimento)
                    .addComponent(rbDataPagamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataInicial)
                    .addComponent(dataFinal)
                    .addComponent(jLabel4)
                    .addComponent(txData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Status Pagto", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbAberto)
                    .addComponent(rbPago)
                    .addComponent(rbAmbos))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rbAberto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbAmbos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbPago))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Status Campanha", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        statusCampanha.add(rbTodos);
        rbTodos.setText("Todos");

        statusCampanha.add(rbEncerrada);
        rbEncerrada.setText("Encerrada");

        statusCampanha.add(rbAndamento);
        rbAndamento.setText("Andamento");

        statusCampanha.add(rbCancelada);
        rbCancelada.setText("Cancelada");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rbCancelada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbAndamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbTodos)
                    .addComponent(rbEncerrada)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAndamento)
                    .addComponent(rbEncerrada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbTodos)
                    .addComponent(rbCancelada)))
        );

        painelDadosPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Baixa", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel5.setText("Conta Caixa");

        try {
            dataPagtoPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Dt Pagto");

        jLabel9.setText("Forma Pagto");

        jLabel11.setText("Val Baixar");

        numContaReceber.setEditable(false);
        numContaReceber.setBackground(new java.awt.Color(204, 204, 204));
        numContaReceber.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        numContaReceber.setFocusable(false);

        jLabel10.setText("CR Baixa");

        jLabel12.setText("OBS Pagto:");

        parcelaContaReceber.setEditable(false);
        parcelaContaReceber.setBackground(new java.awt.Color(204, 204, 204));
        parcelaContaReceber.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        parcelaContaReceber.setFocusable(false);

        javax.swing.GroupLayout painelDadosPagamentoLayout = new javax.swing.GroupLayout(painelDadosPagamento);
        painelDadosPagamento.setLayout(painelDadosPagamentoLayout);
        painelDadosPagamentoLayout.setHorizontalGroup(
            painelDadosPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosPagamentoLayout.createSequentialGroup()
                        .addGroup(painelDadosPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(contaCaixaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelDadosPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDadosPagamentoLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(dataPagtoPagamento)))
                    .addGroup(painelDadosPagamentoLayout.createSequentialGroup()
                        .addGroup(painelDadosPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(formaPagtoBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelDadosPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(numContaReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addComponent(parcelaContaReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelDadosPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDadosPagamentoLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(0, 22, Short.MAX_VALUE))
                            .addComponent(valorBaixar)))
                    .addGroup(painelDadosPagamentoLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(obsPagamento)))
                .addContainerGap())
        );
        painelDadosPagamentoLayout.setVerticalGroup(
            painelDadosPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPagamentoLayout.createSequentialGroup()
                .addGroup(painelDadosPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contaCaixaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataPagtoPagamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formaPagtoBaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numContaReceber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorBaixar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(parcelaContaReceber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(painelDadosPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(obsPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelDadosPagamentoLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        operacao.add(rbConsultar);
        rbConsultar.setText("Consultar");
        rbConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbConsultarActionPerformed(evt);
            }
        });

        operacao.add(rbBaixar);
        rbBaixar.setText("Baixar");
        rbBaixar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBaixarActionPerformed(evt);
            }
        });

        jLabel3.setText("Operação");

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
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(statusCores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBaixar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(codParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nomeParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campanha, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbConsultar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbBaixar))
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(igreja, 0, 171, Short.MAX_VALUE)
                                    .addComponent(formaPagto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnFiltrar))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelDadosPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(campanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbConsultar)
                                    .addComponent(rbBaixar)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(codParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomeParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFiltrar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(painelDadosPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBaixar)
                    .addComponent(statusCores))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeParticipanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeParticipanteKeyPressed
        consultarParticipante();
        carregarResultadoConsultaParticipante();
        
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.codParticipante.setText("");
        } 
    }//GEN-LAST:event_nomeParticipanteKeyPressed

    private void campanhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campanhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            DefaultComboBoxModel campanha = (DefaultComboBoxModel)this.campanha.getModel();
            campanha.removeAllElements();
        } 
    }//GEN-LAST:event_campanhaKeyPressed

    private void formaPagtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formaPagtoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            DefaultComboBoxModel campanha = (DefaultComboBoxModel)this.formaPagto.getModel();
            campanha.removeAllElements();
        } 
    }//GEN-LAST:event_formaPagtoKeyPressed

    private void igrejaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_igrejaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            DefaultComboBoxModel igreja = (DefaultComboBoxModel)this.igreja.getModel();
            igreja.removeAllElements();
        } 
    }//GEN-LAST:event_igrejaKeyPressed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        consultarContasReceberCampanha();
        carregarTabelaContasReceber();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void rbDataVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataVencimentoActionPerformed
        this.txData.setText("Vencimento:");
    }//GEN-LAST:event_rbDataVencimentoActionPerformed

    private void rbDataPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataPagamentoActionPerformed
        this.txData.setText("Pagamento:");
    }//GEN-LAST:event_rbDataPagamentoActionPerformed

    private void campanhaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campanhaMousePressed
        carregarCampanha();
    }//GEN-LAST:event_campanhaMousePressed

    private void igrejaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_igrejaMousePressed
        carregarIgreja();
    }//GEN-LAST:event_igrejaMousePressed

    private void formaPagtoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formaPagtoMousePressed
        carregarFormaPagtoFiltro();
    }//GEN-LAST:event_formaPagtoMousePressed

    private void btnBaixarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaixarActionPerformed
        baixarContasReceberCampanha();
        consultarContasReceberCampanha();
        carregarTabelaContasReceber();
    }//GEN-LAST:event_btnBaixarActionPerformed

    private void rbConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbConsultarActionPerformed
        formConsulta();
    }//GEN-LAST:event_rbConsultarActionPerformed

    private void rbBaixarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBaixarActionPerformed
        formBaixa();
    }//GEN-LAST:event_rbBaixarActionPerformed

    private void tabelaCrMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCrMousePressed
        duplicataSelecionada();
    }//GEN-LAST:event_tabelaCrMousePressed

    private void statusCoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusCoresActionPerformed
        StatusCoresContaPagarReceber statusCores = new StatusCoresContaPagarReceber((Frame) SwingUtilities.getWindowAncestor(this), true);
        statusCores.setLocationRelativeTo(this);
        statusCores.setVisible(true);
    }//GEN-LAST:event_statusCoresActionPerformed

    private void formInicial(){
        this.codParticipante.setText("");
        this.nomeParticipante.setText("");
        this.dataInicial.setText(this.conversor.dataAtualString());
        this.dataFinal.setText(this.conversor.dataAtualString());
        this.rbDataVencimento.setSelected(true);
        this.rbAberto.setSelected(true);
        this.rbAndamento.setSelected(true);
        this.campanha.setSelectedItem("");
        this.igreja.setSelectedItem("");
        this.formaPagto.setSelectedItem("");
        this.btnBaixar.setEnabled(false);
        this.rbConsultar.setSelected(true);
        this.valorBaixar.setEditable(false);
        this.valorBaixar.setText("");
        this.obsPagamento.setEditable(false);
        this.obsPagamento.setText("");
        this.btnBaixar.setEnabled(false);
        this.numContaReceber.setText("");
        this.personalizaTabela.definirNegritoTituloColuna(tabelaCr);
        limparTabela();  
        formConsulta();
        alinharConteudoTabela();
    }
    
    private void tabelaInicial(){
        Date dataAtual = conversor.convertendoStringDateSql(conversor.dataAtualString());
        List<ContasReceberCampanha> listaCrCampanha = this.campanhaDao.consultarContasReceberCampanhaMesAtual((java.sql.Date) dataAtual);
        DefaultTableModel tabelaCr = (DefaultTableModel) this.tabelaCr.getModel();
        tabelaCr.setNumRows(0);

        for(ContasReceberCampanha cr : listaCrCampanha){      
            String dataVencimento =  this.conversor.convertendoDataStringSql((java.sql.Date) cr.getDataVencimento());
            String dataPagamento =  this.conversor.convertendoDataStringSql((java.sql.Date) cr.getDataPagamento());
            tabelaCr.addRow(new Object[]{" ", cr.getParticipante(),cr.getNumParcela(),cr.getParcela(), cr.getValorParcela(), cr.getValorPago(), dataVencimento, dataPagamento,cr.getDescricaoStatus(),cr.getCampanha()});
        }
        
        statusVencimento();
    }
    
    private void formBaixa(){
        this.contaCaixaPagamento.setEnabled(true);
        this.formaPagtoBaixa.setEnabled(true);
        this.btnBaixar.setEnabled(true);
        this.dataPagtoPagamento.setEditable(true);
        this.dataPagtoPagamento.setText(this.conversor.dataAtualString());
        this.valorBaixar.setEditable(true);
        this.obsPagamento.setEditable(true);
        carregarContaCaixa();
        carregarFormaPagtoPagamento();
    }
    
    private void formConsulta(){
        this.contaCaixaPagamento.setEnabled(false);
        this.formaPagtoBaixa.setEnabled(false);
        this.dataPagtoPagamento.setEditable(false);
        this.dataPagtoPagamento.setText(this.conversor.dataAtualString());
        this.valorBaixar.setEditable(false);
        this.obsPagamento.setEditable(false);
        this.btnBaixar.setEnabled(false);
        carregarContaCaixa();
        carregarFormaPagtoPagamento();
    }
    
    private void limparTabela(){
        if(this.tabelaCr.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) this.tabelaCr.getModel();
            model.setRowCount(0);
        }
    }
    
    private void carregarCampanha(){
        List<Campanha> listaCampanha = this.campanhaDao.consultarTodasCampanhas(this.filtroIgreja);
        DefaultComboBoxModel campanha = (DefaultComboBoxModel)this.campanha.getModel();
        campanha.removeAllElements();
        for(Campanha camp : listaCampanha){
            campanha.addElement(camp);
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
    
    private void carregarFormaPagtoFiltro(){
        List<FormaPagto> listaFormaPagto = this.formaPagtoDao.consultarFormaPagto();
        DefaultComboBoxModel formaPagto = (DefaultComboBoxModel)this.formaPagto.getModel();
        formaPagto.removeAllElements();
        for(FormaPagto pagto : listaFormaPagto){
            formaPagto.addElement(pagto);
        }
    }
    
    private void carregarFormaPagtoPagamento(){
        List<FormaPagto> listaFormaPagto = this.formaPagtoDao.consultarFormaPagto();
        DefaultComboBoxModel formaPagto = (DefaultComboBoxModel)this.formaPagtoBaixa.getModel();
        formaPagto.removeAllElements();
        for(FormaPagto pagto : listaFormaPagto){
            formaPagto.addElement(pagto);
        }
    }
    
    private void carregarContaCaixa(){
        List<ContaCaixa> listaContaCaixa = this.contaCaixaDao.consultarContaCaixa( this.filtroIgreja);
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.contaCaixaPagamento.getModel();
        modelo.removeAllElements();
        for(ContaCaixa cx : listaContaCaixa){
            modelo.addElement(cx);
        }
        
    }
    
    private void consultarParticipante(){
        String textoBusca = this.nomeParticipante.getText();
        this.listaParticipantes = this.pessoaDao.consultarCadastroAtivoPessoa(textoBusca);  
    }
    
    private void carregarResultadoConsultaParticipante(){
        TelaConsultasPessoas resultConsultParticipante = new TelaConsultasPessoas((Frame) SwingUtilities.getWindowAncestor(this), this.listaParticipantes);
        resultConsultParticipante.setPessoaSelecionada(this);
        resultConsultParticipante.setLocationRelativeTo(this);
        resultConsultParticipante.setVisible(true);
    }
    
    private void carregarParticipanteEscolhido(Pessoa pessoa){
        this.codParticipante.setText(String.valueOf(pessoa.getCodigo()));
        this.nomeParticipante.setText(pessoa.getNome());    
        
        ParticipanteCampanha participante = new ParticipanteCampanha();
        participante.setCodigo(pessoa.getCodigo());
        participante.setNome(pessoa.getNome());
        this.participanteSelec = participante;
    }
    
    private void consultarContasReceberCampanha(){
        
        ContasReceberCampanha crCampanha = new ContasReceberCampanha();
        
        Date dataPagamentoInicial = null;
        Date dataPagamentoFinal = null;
        Date dataVencimentoInicial = null;
        Date dataVencimentoFinal = null;
        FormaPagto formaPagto = (FormaPagto) this.formaPagto.getSelectedItem();
        Campanha campanha = (Campanha) this.campanha.getSelectedItem();
        Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        Integer statusPagto = null;
        String statusCampanha = null;
        
        if(this.rbPago.isSelected()){
            statusPagto = 1;
        }else if(this.rbAberto.isSelected()){
            statusPagto = 0;
        }else if(this.rbAmbos.isSelected()){
            statusPagto = null;
        }
        
        if(this.rbAndamento.isSelected()){
            statusCampanha = "A";
        }else if(this.rbCancelada.isSelected()){
            statusCampanha = "C";
        }else if(this.rbEncerrada.isSelected()){
            statusCampanha = "E";
        }else if(this.rbTodos.isSelected()){
            statusCampanha = null;
        }
        
        if(this.rbDataPagamento.isSelected()){
            dataPagamentoInicial = conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataPagamentoFinal = conversor.convertendoStringDateSql(this.dataFinal.getText());
        }else if(this.rbDataVencimento.isSelected()){
            dataVencimentoInicial = conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataVencimentoFinal = conversor.convertendoStringDateSql(this.dataFinal.getText());
        }
        
        crCampanha.setCampanha(campanha);
        crCampanha.setIgreja(igreja);
        crCampanha.setParticipante(this.participanteSelec);
        crCampanha.setStatusPagamento(statusPagto);
        crCampanha.setFormaPagto(formaPagto);
        
        this.listaCrCampanha = this.campanhaDao.consultarContasReceberCampanha(crCampanha,statusCampanha, dataVencimentoInicial, dataVencimentoFinal, dataPagamentoInicial, dataPagamentoFinal,this.filtroIgreja);    
    }
    
    private void carregarTabelaContasReceber(){
        
        DefaultTableModel tabelaCr = (DefaultTableModel) this.tabelaCr.getModel();
        tabelaCr.setNumRows(0);

        for(ContasReceberCampanha cr : this.listaCrCampanha){      
            String dataVencimento =  conversor.convertendoDataStringSql((java.sql.Date) cr.getDataVencimento());
            String dataPagamento =  conversor.convertendoDataStringSql((java.sql.Date) cr.getDataPagamento());
            tabelaCr.addRow(new Object[]{" ", cr.getParticipante(),cr.getNumParcela(),cr.getParcela(), cr.getValorParcela(), cr.getValorPago(), dataVencimento, dataPagamento,cr.getDescricaoStatus(),cr.getCampanha()});
        }
        
        statusVencimento();   
    }
    
    private void baixarContasReceberCampanha(){
        MovimentoCaixa mvCaixa = new MovimentoCaixa();
        Usuario usuario = new Usuario();
        usuario.setCodigo(1);
        
        ContasReceberCampanha crCampanha = this.listaCrCampanha.get(this.tabelaCr.getSelectedRow());
        
        crCampanha.setDataPagamento(conversor.convertendoStringDateSql(this.dataPagtoPagamento.getText()));
        crCampanha.setValorPago(Double.parseDouble(this.valorBaixar.getText().replace(",", ".")));
        crCampanha.setObservacaoPagamento(this.obsPagamento.getText());
        crCampanha.setFormaPagto((FormaPagto) this.formaPagtoBaixa.getSelectedItem());
        mvCaixa.setComplemento("CR "+crCampanha.getNumParcela()+"-"+crCampanha.getParcela()+" "+crCampanha.getCampanha().getDescricaoCampanha().toUpperCase());
        mvCaixa.setContaCaixa((ContaCaixa)this.contaCaixaPagamento.getSelectedItem());
        mvCaixa.setDataPagamentoRecebimento(this.conversor.convertendoStringDateSql(this.dataPagtoPagamento.getText()));
        mvCaixa.setCrCampanha(crCampanha);
        mvCaixa.setUsuarioCadastro(usuario);
           
        this.mvCaixaDao.movimentarContasRecebidaCampanha(mvCaixa, this.usuarioLogado);
    }
    
    private void duplicataSelecionada(){    
        int linhaSelecionada = tabelaCr.getSelectedRow();
        Integer numContaReceber = (Integer) tabelaCr.getValueAt(linhaSelecionada, 2);
        Integer parcelaContaReceber = (Integer) tabelaCr.getValueAt(linhaSelecionada, 3);
        double valor = (double) tabelaCr.getValueAt(linhaSelecionada, 4);
        
        this.numContaReceber.setText(String.valueOf(numContaReceber));
        this.parcelaContaReceber.setText(String.valueOf(parcelaContaReceber));
        this.valorBaixar.setText(String.valueOf(valor));
    }
    
    private void statusVencimento(){
        // Definindo a cor conforme a data de vencimento
        this.tabelaCr.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                // Criar um JLabel para a célula
                JLabel label = new JLabel(value.toString()) {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g); // Chama o método para garantir a renderização padrão da célula

                        // Definir o tamanho do círculo (ajuste de acordo com o tamanho da célula)
                        int diameter = Math.min(getWidth(), getHeight()) - 4; // Aumente o valor (-5, 0 ou outro valor) para maior bolinha

                        // Obter a data de vencimento da linha correspondente (coluna 8)
                        String vencimento = (String) table.getValueAt(row, 6);
                        String status = (String) table.getValueAt(row, 8);

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
        
        // Alinhamento do Ofertante (à esquerda)
        DefaultTableCellRenderer primeiraColuna = new DefaultTableCellRenderer();
        primeiraColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaCr.getColumnModel().getColumn(1).setCellRenderer(primeiraColuna);

        // Alinhamento do Valor (centro)
        DefaultTableCellRenderer segundaColuna = new DefaultTableCellRenderer();
        segundaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaCr.getColumnModel().getColumn(2).setCellRenderer(segundaColuna);

        //Alinhamento do tipo de oferta
        DefaultTableCellRenderer terceiraColuna = new DefaultTableCellRenderer();
        terceiraColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaCr.getColumnModel().getColumn(3).setCellRenderer(terceiraColuna);
        
        //Alinhamento da igreja
        DefaultTableCellRenderer quartaColuna = new DefaultTableCellRenderer();
        quartaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaCr.getColumnModel().getColumn(4).setCellRenderer(quartaColuna);
        
        //Alinhamento da data de oferta
        DefaultTableCellRenderer quintaColuna = new DefaultTableCellRenderer();
        quintaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaCr.getColumnModel().getColumn(5).setCellRenderer(quintaColuna);
        
        //Alinhamento da data de lançamento
        DefaultTableCellRenderer sextaColuna = new DefaultTableCellRenderer();
        sextaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaCr.getColumnModel().getColumn(6).setCellRenderer(sextaColuna);
        
        //Alinhamento da data de lançamento
        DefaultTableCellRenderer setimaColuna = new DefaultTableCellRenderer();
        setimaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaCr.getColumnModel().getColumn(7).setCellRenderer(setimaColuna);
        
        //Alinhamento da data de lançamento
        DefaultTableCellRenderer oitavaColuna = new DefaultTableCellRenderer();
        oitavaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaCr.getColumnModel().getColumn(8).setCellRenderer(oitavaColuna);
        
        //Alinhamento da data de lançamento
        DefaultTableCellRenderer nonaColuna = new DefaultTableCellRenderer();
        nonaColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaCr.getColumnModel().getColumn(9).setCellRenderer(nonaColuna);
    }
    
    @Override
    public void pessoaSelecionada(Pessoa pessoaSelecionada) {
        carregarParticipanteEscolhido(pessoaSelecionada);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaixar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox<String> campanha;
    private javax.swing.JTextField codParticipante;
    private javax.swing.JComboBox<String> contaCaixaPagamento;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JFormattedTextField dataPagtoPagamento;
    private javax.swing.JComboBox<String> formaPagto;
    private javax.swing.JComboBox<String> formaPagtoBaixa;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField nomeParticipante;
    private javax.swing.JTextField numContaReceber;
    private javax.swing.JTextField obsPagamento;
    private javax.swing.ButtonGroup operacao;
    private javax.swing.JPanel painelDadosPagamento;
    private javax.swing.JTextField parcelaContaReceber;
    private javax.swing.JRadioButton rbAberto;
    private javax.swing.JRadioButton rbAmbos;
    private javax.swing.JRadioButton rbAndamento;
    private javax.swing.JRadioButton rbBaixar;
    private javax.swing.JRadioButton rbCancelada;
    private javax.swing.JRadioButton rbConsultar;
    private javax.swing.JRadioButton rbDataPagamento;
    private javax.swing.JRadioButton rbDataVencimento;
    private javax.swing.JRadioButton rbEncerrada;
    private javax.swing.JRadioButton rbPago;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.ButtonGroup statusCampanha;
    private javax.swing.JButton statusCores;
    private javax.swing.ButtonGroup statusPagamento;
    private javax.swing.JTable tabelaCr;
    private javax.swing.JLabel txData;
    private javax.swing.JTextField valorBaixar;
    // End of variables declaration//GEN-END:variables
}
