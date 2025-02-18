
package view.dizimosOfertas;

import dao.ContaCaixaDao;
import dao.FormaPagtoDao;
import dao.IgrejaDao;
import dao.PessoaDao;
import dao.RegistroOfertaDao;
import dao.SubContaResultadoDao;
import dao.TipoOfertaDao;
import Ferramentas.Utilitarios;
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
import model.FormaPagto;
import model.Igreja;
import model.Pessoa;
import model.RegistroDizimoOferta;
import model.SubContaResultado;
import model.TipoOferta;
import model.UsuarioLogado;
import view.carregamentoConsultas.TelaConsultasPessoas;


public class ConsultaRegistroDizimoOferta extends javax.swing.JInternalFrame implements ConsultaPessoas{

    private final TipoOfertaDao tipoOfertaDao = new TipoOfertaDao();
    private final FormaPagtoDao formaPagtoDao = new FormaPagtoDao();
    private final ContaCaixaDao contaCaixaDao = new ContaCaixaDao();
    private final PessoaDao pessoaDao = new PessoaDao();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final RegistroOfertaDao rgOfertaDao = new RegistroOfertaDao();
    private final SubContaResultadoDao subContResultDao = new SubContaResultadoDao();
    private final Utilitarios conversor = new Utilitarios();
    private Pessoa ofertante = new Pessoa();   
    private RegistroDizimoOferta rgDizimoOfertas = new RegistroDizimoOferta();
    private List<RegistroDizimoOferta> listaRgDizimoOfertas = new ArrayList<>();
    private Pessoa ofertanteSelec;
    private List<Pessoa> listaOfertante = null;
    
    public ConsultaRegistroDizimoOferta(UsuarioLogado usuarioLogado) {
        initComponents();
        rbDataLancamento.setSelected(true);
        dataInicial.setText(conversor.dataAtualString());
        dataFinal.setText(conversor.dataAtualString());
        totalDizimo.setText("0.00");
        totalOferta.setText("0.00");
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
        jLabel8 = new javax.swing.JLabel();
        totalOferta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        totalDizimo = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        codOfertante = new javax.swing.JTextField();
        nomeOfertante = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
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
        subContaResultado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

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
                "Ofertante", "Valor (R$)", "Tipo Oferta", "Igreja", "Data Oferta", "Data Lançamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
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
        tabelaRegistros.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(tabelaRegistros);
        if (tabelaRegistros.getColumnModel().getColumnCount() > 0) {
            tabelaRegistros.getColumnModel().getColumn(0).setResizable(false);
            tabelaRegistros.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabelaRegistros.getColumnModel().getColumn(1).setResizable(false);
            tabelaRegistros.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabelaRegistros.getColumnModel().getColumn(2).setResizable(false);
            tabelaRegistros.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabelaRegistros.getColumnModel().getColumn(3).setResizable(false);
            tabelaRegistros.getColumnModel().getColumn(3).setPreferredWidth(200);
            tabelaRegistros.getColumnModel().getColumn(4).setResizable(false);
            tabelaRegistros.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabelaRegistros.getColumnModel().getColumn(5).setResizable(false);
            tabelaRegistros.getColumnModel().getColumn(5).setPreferredWidth(100);
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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Total de Ofertas (R$):");

        totalOferta.setEditable(false);
        totalOferta.setBackground(new java.awt.Color(204, 204, 204));
        totalOferta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totalOferta.setForeground(new java.awt.Color(0, 0, 255));
        totalOferta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalOferta.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Total de Dízimo (R$)");

        totalDizimo.setEditable(false);
        totalDizimo.setBackground(new java.awt.Color(204, 204, 204));
        totalDizimo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totalDizimo.setForeground(new java.awt.Color(0, 0, 255));
        totalDizimo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalDizimo.setFocusable(false);

        btnFiltrar.setBackground(new java.awt.Color(255, 102, 0));
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Ofertante");

        codOfertante.setEditable(false);
        codOfertante.setBackground(new java.awt.Color(204, 204, 204));
        codOfertante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        codOfertante.setFocusable(false);

        nomeOfertante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeOfertanteKeyPressed(evt);
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtros Por Data De:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        grupoData.add(rbDataLancamento);
        rbDataLancamento.setText("Lançamento");
        rbDataLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataLancamentoActionPerformed(evt);
            }
        });

        grupoData.add(rbDataOferta);
        rbDataOferta.setText("Oferta/Dizimo");
        rbDataOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataOfertaActionPerformed(evt);
            }
        });

        txData.setText("Lançamento");

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

        jLabel2.setText("SubConta Resultado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalDizimo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(codOfertante, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeOfertante, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(313, 313, 313)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(tipoOferta, javax.swing.GroupLayout.Alignment.LEADING, 0, 227, Short.MAX_VALUE)
                                            .addComponent(igreja, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(contaCaixa, 0, 188, Short.MAX_VALUE)
                                    .addComponent(formaPagto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(subContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nomeOfertante)
                    .addComponent(codOfertante))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subContaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tipoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(formaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconLimpar)
                    .addComponent(iconExcluir)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(totalOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(totalDizimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFiltrar)))
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
    //Botão "OK" para consultarRegistrosOfertas o ofertante
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarOfertante();
        carregarResultadoConsultaFornecedor();
    }//GEN-LAST:event_btnBuscarActionPerformed
    
    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        consultarRgDizimoOferta();
        atualizarTabela();
        mostrarTotalDizimo();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void iconLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconLimparActionPerformed
        limparFormulario();
        limparTabela();
    }//GEN-LAST:event_iconLimparActionPerformed

    private void igrejaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_igrejaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            igreja.removeAllItems();
        } 
    }//GEN-LAST:event_igrejaKeyPressed

    private void tipoOfertaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipoOfertaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            tipoOferta.removeAllItems();
        } 
    }//GEN-LAST:event_tipoOfertaKeyPressed

    private void contaCaixaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contaCaixaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            contaCaixa.removeAllItems();
        } 
    }//GEN-LAST:event_contaCaixaKeyPressed

    private void formaPagtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formaPagtoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            formaPagto.removeAllItems();
        } 
    }//GEN-LAST:event_formaPagtoKeyPressed

    private void iconExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconExcluirActionPerformed
        deletarRegistroMovimento();
    }//GEN-LAST:event_iconExcluirActionPerformed

    private void rbDataLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataLancamentoActionPerformed
        txData.setText("Lançamento:");
    }//GEN-LAST:event_rbDataLancamentoActionPerformed

    private void rbDataOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataOfertaActionPerformed
        txData.setText("Oferta:");
    }//GEN-LAST:event_rbDataOfertaActionPerformed

    private void subContaResultadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subContaResultadoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            subContaResultado.removeAllItems();
        } 
    }//GEN-LAST:event_subContaResultadoKeyPressed

    private void igrejaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_igrejaMousePressed
        carregarIgrejas();
    }//GEN-LAST:event_igrejaMousePressed

    private void contaCaixaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contaCaixaMousePressed
        carregarContaCaixa();
    }//GEN-LAST:event_contaCaixaMousePressed

    private void subContaResultadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subContaResultadoMousePressed
        carregarSubContaResultado();
    }//GEN-LAST:event_subContaResultadoMousePressed

    private void tipoOfertaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tipoOfertaMousePressed
        carregarTipoOferta();
    }//GEN-LAST:event_tipoOfertaMousePressed

    private void formaPagtoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formaPagtoMousePressed
        carregarFormaPagto();
    }//GEN-LAST:event_formaPagtoMousePressed

    private void nomeOfertanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeOfertanteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscarOfertante();
            carregarResultadoConsultaFornecedor();
        } 
    }//GEN-LAST:event_nomeOfertanteKeyPressed

    private void consultarRgDizimoOferta(){
         
        //Coletando os dados inseridos no formulário, ou seja, os filtros
        Date dataLancInicial = null;
        Date dataLancFinal = null;
        Date dataOfertaInicial = null;
        Date dataOfertaFinal = null;
        Integer codOfert = null;
        Igreja igre = (Igreja) this.igreja.getSelectedItem();
        FormaPagto formPagto = (FormaPagto) this.formaPagto.getSelectedItem();
        ContaCaixa contaCx = (ContaCaixa) this.contaCaixa.getSelectedItem();
        TipoOferta tpOferta = (TipoOferta) this.tipoOferta.getSelectedItem();
        
        //Valida se foi informando alguma ofertante/fornecedor
        if(!this.codOfertante.getText().isEmpty()){
            codOfert = Integer.valueOf(this.codOfertante.getText());
            ofertante.setCodigo(codOfert);
        }
        
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
        listaRgDizimoOfertas = rgOfertaDao.consultarRegistrosOfertas(rgDizimoOfertas, dataLancInicial, dataLancFinal, dataOfertaInicial, dataOfertaFinal);
    }
     
    private void limparFormulario(){
        codOfertante.setText("");
        nomeOfertante.setText("");
        dataInicial.setText(conversor.dataAtualString());
        dataFinal.setText(conversor.dataAtualString());
        igreja.setSelectedItem("");
        contaCaixa.setSelectedItem("");
        formaPagto.setSelectedItem("");
        tipoOferta.setSelectedItem("");
        totalDizimo.setText("0.00");
        totalOferta.setText("0.00");
        
    }

    private void limparTabela(){
        //Primeiro a condição testa se a quantidade de colunas é maior que 0, depois, limpa os dados
        if(tabelaRegistros.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) tabelaRegistros.getModel();
            model.setRowCount(0);
        }
    }

    private void carregarIgrejas(){
        List<Igreja> listaIgrejas = igrejaDao.consultarTodasIgrejas();
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
        List<ContaCaixa> listaContaCaixa = contaCaixaDao.consultarContaCaixa();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)contaCaixa.getModel();
        modelo.removeAllElements();
        for(ContaCaixa cx : listaContaCaixa){
            modelo.addElement(cx);
        }
        
    }
    
    private void carregarSubContaResultado(){
        List<SubContaResultado> listaSubContResult = subContResultDao.consultarSubContaResultado();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)subContaResultado.getModel();
        modelo.removeAllElements();
        for(SubContaResultado subCont : listaSubContResult){
            modelo.addElement(subCont);
        }
    }
    
    private void buscarOfertante(){
        String textoBusca = this.nomeOfertante.getText(); // Texto digitado na busca     
        this.listaOfertante = this.pessoaDao.consultarCadastroAtivoPessoa(textoBusca); //Lista recebe a busca retornada do banco
    }
    
    private void carregarResultadoConsultaFornecedor(){
        TelaConsultasPessoas resultConsultParticipante = new TelaConsultasPessoas((Frame) SwingUtilities.getWindowAncestor(this), this.listaOfertante);
        resultConsultParticipante.setPessoaSelecionada(this);
        resultConsultParticipante.setLocationRelativeTo(this);
        resultConsultParticipante.setVisible(true);
    }
    
    private void carregarFornecedorEscolhido(Pessoa pessoa){
        this.codOfertante.setText(Integer.toString(pessoa.getCodigo()));
        this.nomeOfertante.setText(pessoa.getNome());
    }
    
    private void atualizarTabela(){
        List<RegistroDizimoOferta> listaRegistro = listaRgDizimoOfertas;
        DefaultTableModel model = (DefaultTableModel) tabelaRegistros.getModel();
        model.setNumRows(0);

        for(RegistroDizimoOferta rg : listaRegistro){     
            String dataOferta = conversor.convertendoDataStringSql((java.sql.Date) rg.getDataOferta());
            String dataCadastro = conversor.convertendoDataStringSql((java.sql.Date) rg.getDataCadastro());
            model.addRow(new Object[]{rg.getOfertante().getNome(),rg.getValorOferta(), rg.getTpOferta(), rg.getIgreja().getNome(), dataOferta, dataCadastro});
        }
    }
    
    private void mostrarTotalDizimo(){
        double totalValorDizimo = 0;
        double totalValorOferta = 0;
        int qtdLinhasTabela = tabelaRegistros.getRowCount();
        
        for(int i = 0; i < qtdLinhasTabela; i++){  
            
            TipoOferta tpOferta = (TipoOferta) tabelaRegistros.getModel().getValueAt(i, 2);
            double valor = (Double) tabelaRegistros.getModel().getValueAt(i, 1);
            
            if(tpOferta.getCodigo() == 1){
                totalValorDizimo += valor;
            }else{
                totalValorOferta += valor;
            }
            
        }  
        
        totalValorDizimo = conversor.arrendodarValores(totalValorDizimo);
        totalValorOferta = conversor.arrendodarValores(totalValorOferta);
        
        totalDizimo.setText(Double.toString(totalValorDizimo));
        totalOferta.setText(Double.toString(totalValorOferta));
    
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
            RegistroDizimoOferta rgExcluído = listaRgDizimoOfertas.get(index);
            
            //Lista de exclusão receber o dado da lista de contas a pagar no indice selecionado, uma vez que o indíce da tabela é o mesmo da lista
            listaRgExcluida.add(rgExcluído);    
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
    
    @Override
    public void pessoaSelecionada(Pessoa pessoaSelecionada) {
        carregarFornecedorEscolhido(pessoaSelecionada);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JTextField codOfertante;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeOfertante;
    private javax.swing.JRadioButton rbDataLancamento;
    private javax.swing.JRadioButton rbDataOferta;
    private javax.swing.JComboBox<String> subContaResultado;
    private javax.swing.JTable tabelaRegistros;
    private javax.swing.JComboBox<String> tipoOferta;
    private javax.swing.JTextField totalDizimo;
    private javax.swing.JTextField totalOferta;
    private javax.swing.JLabel txData;
    // End of variables declaration//GEN-END:variables
}
