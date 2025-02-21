
package view.dizimosOfertas;

import Ferramentas.PersonalizaTabela;
import Ferramentas.Utilitarios;
import dao.ContaCaixaDao;
import dao.MovimentoOfertaDizimoDao;
import dao.TipoOfertaDao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.ContaCaixa;
import model.RegistroDizimoOferta;
import model.TipoOferta;
import model.Usuario;


public class ConsultaSaldoTipoOfertaForm extends javax.swing.JInternalFrame {
    
    private final PersonalizaTabela personalizaTabela = new PersonalizaTabela();
    private final MovimentoOfertaDizimoDao mvOfertaDizimoDao = new MovimentoOfertaDizimoDao();
    private final TipoOfertaDao tipoOfertaDao = new TipoOfertaDao();
    private final ContaCaixaDao contaCaixaDao = new ContaCaixaDao();
    private final Utilitarios conversor = new Utilitarios();
    private Usuario usuarioLogado = null;

    public ConsultaSaldoTipoOfertaForm(Usuario usuarioLogado) {
        initComponents();
        formInicial();
        this.usuarioLogado = usuarioLogado;
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        txData = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaOfertas = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        totalDizimo = new javax.swing.JLabel();
        totalOfertaEscolaSab = new javax.swing.JLabel();
        totalOfertaPrimicias = new javax.swing.JLabel();
        totalOfertaCultos = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        totalOfertaMissionaria = new javax.swing.JLabel();
        totalOfertaPobres = new javax.swing.JLabel();
        totalOfertaGratidao = new javax.swing.JLabel();
        totalOfertaLiteratura = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tipoOferta = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        contaCaixa = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consulta Saldo Por Tipo de Oferta");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtros Por Data De:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(232, 75));

        txData.setText("De");

        try {
            dataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataInicial.setText("01/01/2000");

        try {
            dataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("até");

        jLabel2.setText("Data Movimentação");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataInicial)
                    .addComponent(dataFinal)
                    .addComponent(jLabel4)
                    .addComponent(txData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tabela de Dizimos/Ofertas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tabelaOfertas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo Oferta", "Valor (R$)", "Operação", "Descrição", "Data Movimento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tabelaOfertas);
        if (tabelaOfertas.getColumnModel().getColumnCount() > 0) {
            tabelaOfertas.getColumnModel().getColumn(0).setResizable(false);
            tabelaOfertas.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabelaOfertas.getColumnModel().getColumn(1).setResizable(false);
            tabelaOfertas.getColumnModel().getColumn(1).setPreferredWidth(90);
            tabelaOfertas.getColumnModel().getColumn(2).setResizable(false);
            tabelaOfertas.getColumnModel().getColumn(2).setPreferredWidth(70);
            tabelaOfertas.getColumnModel().getColumn(3).setResizable(false);
            tabelaOfertas.getColumnModel().getColumn(3).setPreferredWidth(300);
            tabelaOfertas.getColumnModel().getColumn(4).setResizable(false);
            tabelaOfertas.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        btnFiltrar.setBackground(new java.awt.Color(0, 153, 255));
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Saldo Atual", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Dízimo:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Oferta Cultos:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Oferta Primícias:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Oferta Esc Sabati:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Oferta Missio:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Oferta Pobres:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Oferta Gratidão:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Oferta Literatura:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalDizimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaCultos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaPrimicias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaEscolaSab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalOfertaMissionaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaPobres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaGratidao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaLiteratura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalDizimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaMissionaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaCultos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaPobres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaPrimicias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfertaGratidao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalOfertaLiteratura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(totalOfertaEscolaSab)
                        .addComponent(jLabel10)))
                .addContainerGap())
        );

        jLabel19.setText("Tipo Oferta");

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

        jLabel20.setText("Conta Caixa");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel19)
                                            .addGap(148, 148, 148))
                                        .addComponent(tipoOferta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel20)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFiltrar))
                        .addGap(6, 6, 6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFiltrar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipoOfertaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tipoOfertaMousePressed
        carregarTipoOferta();
    }//GEN-LAST:event_tipoOfertaMousePressed

    private void tipoOfertaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipoOfertaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            tipoOferta.removeAllItems();
        }
    }//GEN-LAST:event_tipoOfertaKeyPressed

    private void contaCaixaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contaCaixaMousePressed
        carregarContaCaixa();
    }//GEN-LAST:event_contaCaixaMousePressed

    private void contaCaixaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contaCaixaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            contaCaixa.removeAllItems();
        }
    }//GEN-LAST:event_contaCaixaKeyPressed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        consultarCarregarTotais();
        consultarCarregarListagem();
    }//GEN-LAST:event_btnFiltrarActionPerformed

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
    
    private void consultarCarregarListagem(){
        
        TipoOferta tipoOferta = (TipoOferta) this.tipoOferta.getSelectedItem();
        ContaCaixa contaCaixa = (ContaCaixa) this.contaCaixa.getSelectedItem();
        Date dataInicial = this.conversor.convertendoStringDateSql(this.dataInicial.getText());
        Date dataFinal = this.conversor.convertendoStringDateSql(this.dataFinal.getText());
        String valor = null;
        String operacao = null;
        
        //Resultado da consulta
        List<RegistroDizimoOferta> listaMvOfertaDizimo = mvOfertaDizimoDao.consultarMovimentoDizimoOferta(tipoOferta, contaCaixa, dataInicial, dataFinal);
    
        DefaultTableModel model = (DefaultTableModel) tabelaOfertas.getModel();
        model.setNumRows(0);
        for(RegistroDizimoOferta rg : listaMvOfertaDizimo){     
            String dataMovimento = conversor.convertendoDataStringSql((java.sql.Date) rg.getDataCadastro());
            
            if(rg.getValorOfertaEntrada() != 0){
                valor = String.valueOf(rg.getValorOfertaEntrada());
                operacao = "Entrada";
            }else{
                valor = String.valueOf(rg.getValorOfertaSaida());
                operacao = "Saída";
            }
            
            model.addRow(new Object[]{rg.getTpOferta().getNome(),valor.replace(".", ","), operacao, rg.getComplemento(), dataMovimento});
        }
    }
    
    private void consultarCarregarTotais(){
        
        TipoOferta tipoOferta = (TipoOferta) this.tipoOferta.getSelectedItem();
        ContaCaixa contaCaixa = (ContaCaixa) this.contaCaixa.getSelectedItem();
        Date dataInicial = this.conversor.convertendoStringDateSql(this.dataInicial.getText());
        Date dataFinal = this.conversor.convertendoStringDateSql(this.dataFinal.getText());
        
        //Resultado da consulta
        List<RegistroDizimoOferta> listaMvOfertaDizimo = mvOfertaDizimoDao.consultarTotaisDizimoOferta(tipoOferta, contaCaixa, dataInicial, dataFinal);
        
        //Carregar os valores
        for(RegistroDizimoOferta rg : listaMvOfertaDizimo){
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
        
        DefaultTableCellRenderer primeiraColuna = new DefaultTableCellRenderer();
        primeiraColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaOfertas.getColumnModel().getColumn(0).setCellRenderer(primeiraColuna);

        DefaultTableCellRenderer segundaColuna = new DefaultTableCellRenderer();
        segundaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaOfertas.getColumnModel().getColumn(1).setCellRenderer(segundaColuna);

        DefaultTableCellRenderer terceiraColuna = new DefaultTableCellRenderer();
        terceiraColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaOfertas.getColumnModel().getColumn(2).setCellRenderer(terceiraColuna);
        
        DefaultTableCellRenderer quartaColuna = new DefaultTableCellRenderer();
        quartaColuna.setHorizontalAlignment(SwingConstants.LEFT);
        this.tabelaOfertas.getColumnModel().getColumn(3).setCellRenderer(quartaColuna);
        
        DefaultTableCellRenderer quintaColuna = new DefaultTableCellRenderer();
        quintaColuna.setHorizontalAlignment(SwingConstants.CENTER);
        this.tabelaOfertas.getColumnModel().getColumn(4).setCellRenderer(quintaColuna);

    }
    
    private void formInicial(){
        this.dataInicial.setText("01/01/2000");
        this.dataFinal.setText(conversor.dataAtualString());
        this.personalizaTabela.definirNegritoTituloColuna(tabelaOfertas);   
        this.totalDizimo.setText("0.00");
        this.totalOfertaCultos.setText("0.00");
        this.totalOfertaEscolaSab.setText("0.00");
        this.totalOfertaGratidao.setText("0.00");
        this.totalOfertaMissionaria.setText("0.00");
        this.totalOfertaPobres.setText("0.00");
        this.totalOfertaLiteratura.setText("0.00");
        this.totalOfertaPrimicias.setText("0.00");
        alinharConteudoTabela();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox<String> contaCaixa;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaOfertas;
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
