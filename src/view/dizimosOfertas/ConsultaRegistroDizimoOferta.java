
package view.dizimosOfertas;

import Ferramentas.PersonalizaTabela;
import dao.ContaCaixaDao;
import dao.FormaPagtoDao;
import dao.IgrejaDao;
import dao.PessoaDao;
import dao.RegistroOfertaDao;
import dao.SubContaResultadoDao;
import dao.TipoOfertaDao;
import Ferramentas.Utilitarios;
import dao.UsuarioDao;
import interfaces.ConsultaPessoas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.ContaCaixa;
import model.FormaPagto;
import model.Igreja;
import model.Pessoa;
import model.RegistroDizimoOferta;
import model.TipoOferta;
import model.Usuario;



public class ConsultaRegistroDizimoOferta extends javax.swing.JInternalFrame{

    private final PersonalizaTabela personalizaTabela = new PersonalizaTabela();
    private final TipoOfertaDao tipoOfertaDao = new TipoOfertaDao();
    private final FormaPagtoDao formaPagtoDao = new FormaPagtoDao();
    private final ContaCaixaDao contaCaixaDao = new ContaCaixaDao();
    private final PessoaDao pessoaDao = new PessoaDao();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final RegistroOfertaDao rgOfertaDao = new RegistroOfertaDao();
    private final Utilitarios conversor = new Utilitarios();
    private Pessoa ofertante = new Pessoa();   
    private RegistroDizimoOferta rgDizimoOfertas = new RegistroDizimoOferta();
    private List<RegistroDizimoOferta> listaRgDizimoOfertas = new ArrayList<>();
    private Pessoa ofertanteSelec;
    private List<Pessoa> listaOfertante = null;
    private final UsuarioDao usuarioDao = new UsuarioDao();
    private String filtroIgreja = "";
    
    public ConsultaRegistroDizimoOferta(Usuario usuarioLogado) {
        initComponents();
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

        jPanel3 = new javax.swing.JPanel();
        grupoData = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRegistros = new javax.swing.JTable();
        iconExcluir = new javax.swing.JButton();
        iconLimpar = new javax.swing.JButton();
        btnFiltrar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        rbDataLancamento = new javax.swing.JRadioButton();
        rbDataOferta = new javax.swing.JRadioButton();
        txData = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        igreja = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        tipoOferta = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        contaCaixa = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        formaPagto = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        totalDizimo = new javax.swing.JLabel();
        totalOfertaEscolaSab = new javax.swing.JLabel();
        totalOfertaPrimicias = new javax.swing.JLabel();
        totalOfertaCultos = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        totalOfertaMissionaria = new javax.swing.JLabel();
        totalOfertaPobres = new javax.swing.JLabel();
        totalOfertaGratidao = new javax.swing.JLabel();
        totalOfertaLiteratura = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("Consulta de Dizimos/Ofertas");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tabela de Dizimos/Ofertas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo Oferta", "Valor (R$)", "Operação", "Descrição", "ContaCx", "Igreja", "Dt Lançamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaRegistros.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(tabelaRegistros);
        if (tabelaRegistros.getColumnModel().getColumnCount() > 0) {
            tabelaRegistros.getColumnModel().getColumn(0).setResizable(false);
            tabelaRegistros.getColumnModel().getColumn(0).setPreferredWidth(150);
            tabelaRegistros.getColumnModel().getColumn(1).setResizable(false);
            tabelaRegistros.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabelaRegistros.getColumnModel().getColumn(2).setResizable(false);
            tabelaRegistros.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabelaRegistros.getColumnModel().getColumn(3).setResizable(false);
            tabelaRegistros.getColumnModel().getColumn(3).setPreferredWidth(250);
            tabelaRegistros.getColumnModel().getColumn(4).setResizable(false);
            tabelaRegistros.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabelaRegistros.getColumnModel().getColumn(5).setResizable(false);
            tabelaRegistros.getColumnModel().getColumn(5).setPreferredWidth(150);
            tabelaRegistros.getColumnModel().getColumn(6).setResizable(false);
            tabelaRegistros.getColumnModel().getColumn(6).setPreferredWidth(60);
        }

        iconExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        iconExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lixeira-16.png"))); // NOI18N
        iconExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconExcluirActionPerformed(evt);
            }
        });

        iconLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        iconLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        iconLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconLimparActionPerformed(evt);
            }
        });

        btnFiltrar.setBackground(new java.awt.Color(255, 102, 0));
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtros Por Data De:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        grupoData.add(rbDataLancamento);
        rbDataLancamento.setText("Lançamento");

        grupoData.add(rbDataOferta);
        rbDataOferta.setText("Oferta/Dizimo");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(rbDataLancamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDataOferta))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(txData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDataLancamento)
                    .addComponent(rbDataOferta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataInicial)
                    .addComponent(dataFinal)
                    .addComponent(jLabel4)
                    .addComponent(txData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        jLabel5.setText("Campo/igreja");

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

        jLabel12.setText("Tipo Oferta");

        tipoOferta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tipoOfertaMousePressed(evt);
            }
        });
        tipoOferta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tipoOfertaKeyPressed(evt);
            }
        });

        jLabel11.setText("Conta Caixa");

        contaCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                contaCaixaMousePressed(evt);
            }
        });
        contaCaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contaCaixaKeyPressed(evt);
            }
        });

        jLabel10.setText("Forma Pagto");

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Saldo Atual", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Dízimo:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Oferta Cultos:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Oferta Primícias:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Oferta Esc Sabati:");

        totalDizimo.setText("R$ 0.00");

        totalOfertaEscolaSab.setText("R$ 0.00");

        totalOfertaPrimicias.setText("R$ 0.00");

        totalOfertaCultos.setText("R$ 0.00");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Oferta Missio:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Oferta Pobres:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Oferta Gratidão:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Oferta Literatura:");

        totalOfertaMissionaria.setText("R$ 0.00");

        totalOfertaPobres.setText("R$ 0.00");

        totalOfertaGratidao.setText("R$ 0.00");

        totalOfertaLiteratura.setText("R$ 0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalDizimo, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(totalOfertaCultos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaPrimicias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaEscolaSab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalOfertaMissionaria, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(totalOfertaPobres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaGratidao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaLiteratura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalDizimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaMissionaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaCultos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaPobres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaPrimicias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaGratidao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalOfertaLiteratura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalOfertaEscolaSab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel16)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(iconLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tipoOferta, javax.swing.GroupLayout.Alignment.LEADING, 0, 227, Short.MAX_VALUE)
                            .addComponent(igreja, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(contaCaixa, 0, 188, Short.MAX_VALUE)
                                .addComponent(formaPagto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(contaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tipoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(formaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconLimpar)
                    .addComponent(iconExcluir)
                    .addComponent(btnFiltrar))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formaPagtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formaPagtoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            formaPagto.removeAllItems();
        }
    }//GEN-LAST:event_formaPagtoKeyPressed

    private void formaPagtoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formaPagtoMousePressed
        carregarFormaPagto();
    }//GEN-LAST:event_formaPagtoMousePressed

    private void contaCaixaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contaCaixaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            contaCaixa.removeAllItems();
        }
    }//GEN-LAST:event_contaCaixaKeyPressed

    private void contaCaixaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contaCaixaMousePressed
        carregarContaCaixa();
    }//GEN-LAST:event_contaCaixaMousePressed

    private void tipoOfertaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipoOfertaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            tipoOferta.removeAllItems();
        }
    }//GEN-LAST:event_tipoOfertaKeyPressed

    private void tipoOfertaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tipoOfertaMousePressed
        carregarTipoOferta();
    }//GEN-LAST:event_tipoOfertaMousePressed

    private void igrejaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_igrejaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            igreja.removeAllItems();
        }
    }//GEN-LAST:event_igrejaKeyPressed

    private void igrejaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_igrejaMousePressed
        carregarIgrejas();
    }//GEN-LAST:event_igrejaMousePressed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        consultarRgDizimoOferta();
        atualizarTabela();
        consultarCarregarTotais();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void iconLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconLimparActionPerformed
        limparFormulario();
        limparTabela();
    }//GEN-LAST:event_iconLimparActionPerformed

    private void iconExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconExcluirActionPerformed
        deletarRegistroMovimento();
    }//GEN-LAST:event_iconExcluirActionPerformed

    private void consultarRgDizimoOferta(){
         
        //Coletando os dados inseridos no formulário, ou seja, os filtros
        Date dataLancInicial = null;
        Date dataLancFinal = null;
        Date dataOfertaInicial = null;
        Date dataOfertaFinal = null;
        Igreja igre = (Igreja) this.igreja.getSelectedItem();
        FormaPagto formPagto = (FormaPagto) this.formaPagto.getSelectedItem();
        ContaCaixa contaCx = (ContaCaixa) this.contaCaixa.getSelectedItem();
        TipoOferta tpOferta = (TipoOferta) this.tipoOferta.getSelectedItem();
              
        if(rbDataLancamento.isSelected()){
            dataLancInicial = conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataLancFinal = conversor.convertendoStringDateSql(this.dataFinal.getText());
        }else if(rbDataOferta.isSelected()){
            dataOfertaInicial = conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataOfertaFinal = conversor.convertendoStringDateSql(this.dataFinal.getText());
        }
        
        //setando os valores para os objetos
        rgDizimoOfertas.setOfertante(ofertante);
        rgDizimoOfertas.setFormaPagto(formPagto);
        rgDizimoOfertas.setIgreja(igre);
        rgDizimoOfertas.setTpOferta(tpOferta);
        rgDizimoOfertas.setContaCaixa(contaCx);
        
        //Passando os filtros como parametris, e a variável recebe os dados obtidos na consulta.
        listaRgDizimoOfertas.clear();
        listaRgDizimoOfertas = rgOfertaDao.consultarRegistrosOfertas(rgDizimoOfertas, dataLancInicial, dataLancFinal, dataOfertaInicial, dataOfertaFinal,this.filtroIgreja);
    }
     
    private void limparFormulario(){
        dataInicial.setText(conversor.dataAtualString());
        dataFinal.setText(conversor.dataAtualString());
        igreja.setSelectedItem("");
        contaCaixa.setSelectedItem("");
        formaPagto.setSelectedItem("");
        tipoOferta.setSelectedItem("");
        
    }

    private void limparTabela(){
        //Primeiro a condição testa se a quantidade de colunas é maior que 0, depois, limpa os dados
        if(tabelaRegistros.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) tabelaRegistros.getModel();
            model.setRowCount(0);
        }
    }

    private void carregarIgrejas(){
        List<Igreja> listaIgrejas = igrejaDao.consultarTodasIgrejas(this.filtroIgreja);
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)igreja.getModel();
        modelo.removeAllElements();
        for(Igreja igreja : listaIgrejas){
            modelo.addElement(igreja);
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
        List<ContaCaixa> listaContaCaixa = contaCaixaDao.consultarContaCaixa( this.filtroIgreja);
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)contaCaixa.getModel();
        modelo.removeAllElements();
        for(ContaCaixa cx : listaContaCaixa){
            modelo.addElement(cx);
        }
        
    }
   
    private void atualizarTabela(){
        List<RegistroDizimoOferta> listaRegistro = listaRgDizimoOfertas;
        DefaultTableModel model = (DefaultTableModel) tabelaRegistros.getModel();
        model.setNumRows(0);
        String operacao = "";
        double valor = 0;

        for(RegistroDizimoOferta rg : listaRegistro){     
            if(rg.getValorOfertaEntrada() > 0){
                valor = rg.getValorOfertaEntrada();
                operacao = "Entrada";
            }else{
                valor = rg.getValorOfertaSaida();
                operacao = "Saída";
            }
            String dataCadastro = conversor.convertendoDataStringSql((java.sql.Date) rg.getDataMovimento());
            model.addRow(new Object[]{rg.getTpOferta(),valor, operacao, rg.getComplemento(), rg.getContaCaixa(),rg.getIgreja(), dataCadastro});
        }
    }
    
    private void deletarRegistroMovimento(){
        int[] numLinhaSelec = tabelaRegistros.getSelectedRows();
        List<RegistroDizimoOferta> listaRgExcluida = new ArrayList<>();
        
        //Verifica se foi selecionado algum registro da lista
        if(numLinhaSelec.length < 0){
            JOptionPane.showMessageDialog(null, "Selecione o(s) registro(s) a ser excluído(s)", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //Selecinando os registros que foram excluídas
        for(int i=0; i < numLinhaSelec.length; i++){
            
            int index = numLinhaSelec[i];
            RegistroDizimoOferta rgExcluido = listaRgDizimoOfertas.get(index);
            
            //Lista de exclusão receber o dado da lista de contas a pagar no indice selecionado, uma vez que o indíce da tabela é o mesmo da lista
            listaRgExcluida.add(rgExcluido);    
            listaRgDizimoOfertas.remove(index);
            System.out.println("Linha Selecionada: "+index);
            System.out.println("Tamanho da Lista: "+listaRgDizimoOfertas.size());
            index = 0;
            
        }
        

        int confirm = JOptionPane.showConfirmDialog(null,"Excluir os registro(s) selecionado(s) selecionado(s)? O movimento financeiro também será excluído", "Confirmar", JOptionPane.YES_NO_OPTION);
        //Verifica qual a opção escolhida
        if(confirm == JOptionPane.YES_OPTION){
            rgOfertaDao.deletarRegistros(listaRgExcluida);
        }else if(confirm == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }   
        
        //Atualiza tabela
        atualizarTabela();
        listaRgExcluida.clear();     
    }
    
    private void consultarCarregarTotais(){
        
        Date dataLancInicial = null;
        Date dataLancFinal = null;
        Date dataOfertaInicial = null;
        Date dataOfertaFinal = null;
        ContaCaixa contaCaixa = (ContaCaixa) this.contaCaixa.getSelectedItem();
        Igreja igreja = (Igreja) this.igreja.getSelectedItem();

        if(rbDataLancamento.isSelected()){
            dataLancInicial = conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataLancFinal = conversor.convertendoStringDateSql(this.dataFinal.getText());
        }else if(rbDataOferta.isSelected()){
            dataOfertaInicial = conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataOfertaFinal = conversor.convertendoStringDateSql(this.dataFinal.getText());
        }
        
        List<RegistroDizimoOferta> listaTotaisDizimoOfertas = rgOfertaDao.consultarTotaisTipoOferta(igreja, contaCaixa, this.filtroIgreja, dataOfertaInicial, dataOfertaFinal, dataLancInicial, dataLancFinal);     
        
        //Carregar os valores
        for(RegistroDizimoOferta rg : listaTotaisDizimoOfertas){
            if(null != rg.getTpOferta().getCodigo())switch (rg.getTpOferta().getCodigo()) {
                case 1:{
                        String valor = String.valueOf("R$ "+rg.getValorTotal()).replace(".", ",");
                        this.totalDizimo.setText(valor);

                        //Definindo as cores com base no valor
                        if(rg.getValorTotal() < 0){
                            this.totalDizimo.setForeground(Color.red);
                        }else if(rg.getValorTotal() > 0){
                            this.totalDizimo.setForeground(Color.blue);
                        }
                        break;
                    }
                case 2:{
                        String valor = String.valueOf("R$ "+rg.getValorTotal()).replace(".", ",");
                        this.totalOfertaEscolaSab.setText(valor);

                        //Definindo as cores com base no valor
                        if(rg.getValorTotal() < 0){
                            this.totalOfertaEscolaSab.setForeground(Color.red);
                        }else if(rg.getValorTotal() > 0){
                            this.totalOfertaEscolaSab.setForeground(Color.blue);
                        }
                        break;
                    }
                case 3:{
                        String valor = String.valueOf("R$ "+rg.getValorTotal()).replace(".", ",");
                        this.totalOfertaCultos.setText(valor);

                        //Definindo as cores com base no valor
                        if(rg.getValorTotal() < 0){
                            this.totalOfertaCultos.setForeground(Color.red);
                        }else if(rg.getValorTotal() > 0){
                            this.totalOfertaCultos.setForeground(Color.blue);
                        }                    
                        break;
                    }
                case 4:{
                        String valor = String.valueOf("R$ "+rg.getValorTotal()).replace(".", ",");
                        this.totalOfertaMissionaria.setText(valor);
                        
                        //Definindo as cores com base no valor
                        if(rg.getValorTotal() < 0){
                            this.totalOfertaMissionaria.setForeground(Color.red);
                        }else if(rg.getValorTotal() > 0){
                            this.totalOfertaMissionaria.setForeground(Color.blue);
                        }                                   
                        break;
                    }
                case 5:{
                        String valor = String.valueOf("R$ "+rg.getValorTotal()).replace(".", ",");
                        this.totalOfertaPobres.setText(valor);
                        
                        //Definindo as cores com base no valor
                        if(rg.getValorTotal() < 0){
                            this.totalOfertaPobres.setForeground(Color.red);
                        }else if(rg.getValorTotal() > 0){
                            this.totalOfertaPobres.setForeground(Color.blue);
                        }           
                        break;
                    }
                case 6:{
                        String valor = String.valueOf("R$ "+rg.getValorTotal()).replace(".", ",");
                        this.totalOfertaLiteratura.setText(valor);
                        
                        //Definindo as cores com base no valor
                        if(rg.getValorTotal() < 0){
                            this.totalOfertaLiteratura.setForeground(Color.red);
                        }else if(rg.getValorTotal() > 0){
                            this.totalOfertaLiteratura.setForeground(Color.blue);
                        }           
                        break;
                    }
                case 7:{
                        String valor = String.valueOf("R$ "+rg.getValorTotal()).replace(".", ",");
                        this.totalOfertaGratidao.setText(valor);
                        
                        //Definindo as cores com base no valor
                        if(rg.getValorTotal() < 0){
                            this.totalOfertaGratidao.setForeground(Color.red);
                        }else if(rg.getValorTotal() > 0){
                            this.totalOfertaGratidao.setForeground(Color.blue);
                        }           
                        break;
                    }
                default:
                    break;
            }
        }

    }
    
    private void alinharConteudoTabela(){
        
        // Alinhamento do Ofertante (à esquerda)
        DefaultTableCellRenderer primeiraColuna = new DefaultTableCellRenderer();
        primeiraColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaRegistros.getColumnModel().getColumn(0).setCellRenderer(primeiraColuna);

        // Alinhamento do Valor (centro)
        DefaultTableCellRenderer segundaColuna = new DefaultTableCellRenderer();
        segundaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaRegistros.getColumnModel().getColumn(1).setCellRenderer(segundaColuna);

        //Alinhamento do tipo de oferta
        DefaultTableCellRenderer terceiraColuna = new DefaultTableCellRenderer();
        terceiraColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaRegistros.getColumnModel().getColumn(2).setCellRenderer(terceiraColuna);
        
        //Alinhamento da igreja
        DefaultTableCellRenderer quartaColuna = new DefaultTableCellRenderer();
        quartaColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaRegistros.getColumnModel().getColumn(3).setCellRenderer(quartaColuna);
        
        //Alinhamento da data de oferta
        DefaultTableCellRenderer quintaColuna = new DefaultTableCellRenderer();
        quintaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaRegistros.getColumnModel().getColumn(4).setCellRenderer(quintaColuna);
        
        //Alinhamento da data de lançamento
        DefaultTableCellRenderer sextaColuna = new DefaultTableCellRenderer();
        sextaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaRegistros.getColumnModel().getColumn(5).setCellRenderer(sextaColuna);
        
        //Alinhamento da data de lançamento
        DefaultTableCellRenderer setimaColuna = new DefaultTableCellRenderer();
        setimaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaRegistros.getColumnModel().getColumn(6).setCellRenderer(setimaColuna);
    }

    private void formInicial(){      
        tipoOferta.removeAllItems();
        igreja.removeAllItems();
        formaPagto.removeAllItems();
        contaCaixa.removeAllItems();
        rbDataLancamento.setSelected(true);
        dataInicial.setText(conversor.dataAtualString());
        dataFinal.setText(conversor.dataAtualString());
        alinharConteudoTabela();
        personalizaTabela.definirNegritoTituloColuna(tabelaRegistros);
        consultarCarregarTotais();
    }
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox<String> contaCaixa;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JComboBox<String> formaPagto;
    private javax.swing.ButtonGroup grupoData;
    private javax.swing.JButton iconExcluir;
    private javax.swing.JButton iconLimpar;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbDataLancamento;
    private javax.swing.JRadioButton rbDataOferta;
    private javax.swing.JTable tabelaRegistros;
    private javax.swing.JComboBox<String> tipoOferta;
    private javax.swing.JLabel totalDizimo;
    private javax.swing.JLabel totalOfertaCultos;
    private javax.swing.JLabel totalOfertaEscolaSab;
    private javax.swing.JLabel totalOfertaGratidao;
    private javax.swing.JLabel totalOfertaLiteratura;
    private javax.swing.JLabel totalOfertaMissionaria;
    private javax.swing.JLabel totalOfertaPobres;
    private javax.swing.JLabel totalOfertaPrimicias;
    private javax.swing.JLabel txData;
    // End of variables declaration//GEN-END:variables
}
