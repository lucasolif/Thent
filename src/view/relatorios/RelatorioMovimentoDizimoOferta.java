
package view.relatorios;

import Ferramentas.Relatorios;
import Ferramentas.Utilitarios;
import dao.IgrejaDao;
import dao.RegistroOfertaDao;
import dao.TipoOfertaDao;
import dao.UsuarioDao;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Igreja;
import model.RegistroDizimoOferta;
import model.TipoOferta;
import model.Usuario;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;


public class RelatorioMovimentoDizimoOferta extends javax.swing.JInternalFrame {
    
    private final Relatorios funcoesRelatorio = new Relatorios();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final TipoOfertaDao tipoOfertaDao = new TipoOfertaDao();
    private final Utilitarios conversor = new Utilitarios();
    private final RegistroOfertaDao rgOfertaDao = new RegistroOfertaDao();
    private final UsuarioDao usuarioDao = new UsuarioDao();
    private String filtroIgreja = "";
    private Usuario usuarioLogado;
    private final String textoSubTotalDizimo = "SUBTOTAL DE DÍZIMOS:";
    private final String textoSubTotalOfertas = "SUBTOTAL DE OFERTAS:";
    private final String textoSubTotalDizimoOfertas = "SOMA SUBTOTAL:";
    private final String textoTotalDizimo = "TOTAL DE DÍZIMOS:";
    private final String textoTotalOfertas = "TOTAL DE OFERTAS:";
    private final String textoTotalDizimoOfertas = "SOMA TOTAL:";

    public RelatorioMovimentoDizimoOferta(Usuario usuarioLogado) {
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

        grupoDataOferta = new javax.swing.ButtonGroup();
        grupoLayout = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        igreja = new javax.swing.JComboBox<>();
        tipoOferta = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbDataOferta = new javax.swing.JRadioButton();
        rbDataLancamento = new javax.swing.JRadioButton();
        txData = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rbTipoOferta = new javax.swing.JRadioButton();
        rbPadrao = new javax.swing.JRadioButton();
        rbIgreja = new javax.swing.JRadioButton();
        btnGerarRe = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Relatório Dízimo/Ofertas");

        jLabel1.setText("Igreja");

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

        jLabel2.setText("Tipo Oferta");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtros Por Data De:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        grupoDataOferta.add(rbDataOferta);
        rbDataOferta.setText("Oferta");

        grupoDataOferta.add(rbDataLancamento);
        rbDataLancamento.setText("Lançamento");

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
                        .addComponent(rbDataOferta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDataLancamento)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDataOferta)
                    .addComponent(rbDataLancamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataInicial)
                    .addComponent(dataFinal)
                    .addComponent(jLabel4)
                    .addComponent(txData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Layout", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        grupoLayout.add(rbTipoOferta);
        rbTipoOferta.setText("Tipo Oferta");

        grupoLayout.add(rbPadrao);
        rbPadrao.setText("Padrão");

        grupoLayout.add(rbIgreja);
        rbIgreja.setText("Igreja");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rbTipoOferta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(rbPadrao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbIgreja, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(rbPadrao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTipoOferta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbIgreja)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGerarRe.setBackground(new java.awt.Color(0, 153, 255));
        btnGerarRe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGerarRe.setText("Gerar");
        btnGerarRe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarReActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(igreja, javax.swing.GroupLayout.Alignment.LEADING, 0, 201, Short.MAX_VALUE)
                        .addComponent(tipoOferta, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGerarRe)))
                .addGap(9, 9, 9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tipoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGerarRe)
                        .addGap(35, 35, 35))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void igrejaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_igrejaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            DefaultComboBoxModel igreja = (DefaultComboBoxModel)this.igreja.getModel();
            igreja.removeAllElements();
        }
    }//GEN-LAST:event_igrejaKeyPressed

    private void igrejaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_igrejaMousePressed
        carregarIgreja();
    }//GEN-LAST:event_igrejaMousePressed

    private void tipoOfertaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipoOfertaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            DefaultComboBoxModel tpOferta = (DefaultComboBoxModel)this.tipoOferta.getModel();
            tpOferta.removeAllElements();
        }
    }//GEN-LAST:event_tipoOfertaKeyPressed

    private void tipoOfertaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tipoOfertaMousePressed
        carregarTipoOferta();
    }//GEN-LAST:event_tipoOfertaMousePressed

    private void btnGerarReActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarReActionPerformed
        gerarRelatorio();
    }//GEN-LAST:event_btnGerarReActionPerformed

    private void formInicial(){
        DefaultComboBoxModel igreja = (DefaultComboBoxModel)this.igreja.getModel();
        DefaultComboBoxModel tipoOferta = (DefaultComboBoxModel)this.tipoOferta.getModel();
        igreja.removeAllElements();
        tipoOferta.removeAllElements();
        this.rbPadrao.setSelected(true);
        this.rbDataOferta.setSelected(true);
        this.dataInicial.setText(this.conversor.dataAtualString());
        this.dataFinal.setText(this.conversor.dataAtualString());
    }
    
    private void carregarIgreja(){
        List<Igreja> listaIgrejas = this.igrejaDao.consultarTodasIgrejas(this.filtroIgreja);
        DefaultComboBoxModel igreja = (DefaultComboBoxModel)this.igreja.getModel();
        igreja.removeAllElements();
        for(Igreja igre : listaIgrejas){
            igreja.addElement(igre);
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
    
    private void gerarRelatorio(){
        
        List<RegistroDizimoOferta> listaRgDizimoOferta = null;
        
        if(this.rbPadrao.isSelected()){
            listaRgDizimoOferta = consultarRgDizimoOferta("Ofertante");
            layoutPadrao(listaRgDizimoOferta);
        }else if(this.rbTipoOferta.isSelected()){
            listaRgDizimoOferta = consultarRgDizimoOferta("TipoOferta");
            layoutTipoOferta(listaRgDizimoOferta);
        }else if(this.rbIgreja.isSelected()){
            listaRgDizimoOferta = consultarRgDizimoOferta("Igreja");
            layoutIgreja(listaRgDizimoOferta);
        } 
    }
    
    private List<RegistroDizimoOferta> consultarRgDizimoOferta(String ordemConsulta){
        
        RegistroDizimoOferta rgDizimoOferta = new RegistroDizimoOferta();
        TipoOferta tipoOferta = (TipoOferta) this.tipoOferta.getSelectedItem();
        Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        Date dataOfertaInicial = null;
        Date dataOfertaFinal = null;
        Date dataLancamentoInicial = null;
        Date dataLancamentoFinal = null;
        rgDizimoOferta.setIgreja(igreja);
        rgDizimoOferta.setTpOferta(tipoOferta);
        
        //Verifica qual data foi escolhida, e atribui o valor da data inserida
        if(this.rbDataOferta.isSelected()){
            dataOfertaInicial = this.conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataOfertaFinal = this.conversor.convertendoStringDateSql(this.dataFinal.getText());
        }else if(this.rbDataLancamento.isSelected()){
            dataLancamentoInicial = this.conversor.convertendoStringDateSql(this.dataInicial.getText());
            dataLancamentoFinal = this.conversor.convertendoStringDateSql(this.dataFinal.getText());
        }
        
        List<RegistroDizimoOferta> listaRgDizimoOferta = this.rgOfertaDao.consultaRegistroDizimoOfertaRelatorio(rgDizimoOferta, ordemConsulta, dataLancamentoInicial, dataLancamentoFinal, dataOfertaInicial, dataOfertaFinal, this.filtroIgreja);
        
        return listaRgDizimoOferta;
    }
    
    private void layoutPadrao(List<RegistroDizimoOferta> listaRgDizimoOfertas){
        

        
        //Definição das variáveis
        final String dataInicial = this.dataInicial.getText();
        final String dataFinal = this.dataFinal.getText();
        final TipoOferta tpOfertaSelec = (TipoOferta) this.tipoOferta.getSelectedItem();
        final Igreja igrejaSelec = (Igreja) this.igreja.getSelectedItem();
        String nomeIgreja = null;
        String tpOferta = null;
        final String titulo = "Registros de Dizimo e Ofertas";  
        double totalDizimo = 0;
        double totalOfertas = 0;
        double totalDizimoOfertas = 0;
        
        //Verifica se foi foi filtrado por igreja, ou se vai mostrar todas as igrejas
        if(igrejaSelec == null){
            nomeIgreja = "Todas Igrejas";
        }else{
            nomeIgreja = igrejaSelec.getNome();
        }
        
        //Verifica se foi selecionado alguma tipo de oferta específico
        if(tpOfertaSelec == null){
            tpOferta = "Todas Ofertas/Dizimo";
        }else{
            tpOferta = tpOfertaSelec.getNome();
        }  
        
        final String subTitulo = "Período de "+dataInicial+" até "+dataFinal+" - "+nomeIgreja+" - "+tpOferta; 
               
        //Variáveis referente ao layout da página
        float yPosition = 700; // Posição vertical inicial para os títulos
        float xPosition = 40; // Posição horizontal inicial para os títulos
        final int layout = 1;
        final float tamanhoFonteTitulo = 18; 
        final float tamanhaFonte = 11;
        final int limiteCaracteres = 35; // Limite de caracteres (ajuste conforme necessário)    
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        
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
            this.funcoesRelatorio.tituloRelatorio(tamanhoFonteTitulo, titulo, fluxoConteudo, paginaPDF);             
            //Gerando o sub título do relatório
            this.funcoesRelatorio.subTituloRelatorio(subTitulo, fluxoConteudo, paginaPDF);   
            
            // Definir os títulos das colunas
            String[] titulosTabela = {"Tp Oferta", "Val. Oferta", "Operação", "Igreja", "Conta Caixa", "Data Oferta"};
            this.funcoesRelatorio.tituloColunaRelatorioRgDizimoOferta(layout ,yPosition, xPosition, titulosTabela, fluxoConteudo);           
            yPosition -= 20; // Pular para a linha abaixo após o título

            for(RegistroDizimoOferta rg : listaRgDizimoOfertas) {          
                // Se a posição Y estiver abaixo do limite da página, criar uma nova página
                if (yPosition < 90) { 
                    fluxoConteudo.close();
                    PDPage novaPagina = new PDPage(PDRectangle.A4); // Tamanho da página
                    documentoPDF.addPage(novaPagina);
                    fluxoConteudo = new PDPageContentStream(documentoPDF, novaPagina);
                    yPosition = 750; // Resetar a posição Y para o topo da nova página
                }        
                // Resetar a posição horizontal a cada nova linha
                xPosition = 40; 

                // Obter os dados da lista
                String dataOferta = conversor.convertendoDataStringSql((java.sql.Date) rg.getDataOferta());
                String tipoOfertaDizimo = rg.getTpOferta().getNome();
                String igreja = rg.getIgreja().getNome();
                String tpOperacao = "";
                String valor = "0";
                String contaCaixa = rg.getContaCaixa().getNome();
                
                //Verifica o tamanho da descrição, para que não passe do tamanha de caraceteres
                if (tipoOfertaDizimo.length() > limiteCaracteres) {
                    tipoOfertaDizimo = tipoOfertaDizimo.substring(0, limiteCaracteres); // Truncar e adicionar "..."
                }
                
                //Verifica se é uma operação de entrada ou saída
                if(rg.getValorOfertaEntrada() > 0){
                    tpOperacao = "Entrada";
                    valor = this.conversor.formatarDoubleString(rg.getValorOfertaEntrada()).replace(".", ",");
                }else{
                    tpOperacao = "Saída";
                    valor = this.conversor.formatarDoubleString(rg.getValorOfertaSaida()).replace(".", ",");
                }

                //Inicia o processo de escrever os dados
                fluxoConteudo.beginText();
                fluxoConteudo.setFont(times, tamanhaFonte);

                fluxoConteudo.newLineAtOffset(xPosition, yPosition);
                fluxoConteudo.showText(tipoOfertaDizimo);
                xPosition += 80; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valor);
                xPosition -= 55; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(tpOperacao);
                xPosition += 0; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(igreja);
                xPosition += 60; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(contaCaixa);
                xPosition -= 40; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(dataOferta);

                fluxoConteudo.endText();

                // Descer para a próxima linha
                yPosition -= 20; // Ajuste o espaçamento vertical conforme necessário  
                
                //Verificando quem é dízimo e quem é oferta
                if(rg.getTpOferta().getCodigo() == 1){
                    totalDizimo += rg.getValorOfertaEntrada();
                }else{
                    totalOfertas += rg.getValorOfertaEntrada();
                }           
                totalDizimoOfertas += rg.getValorOfertaEntrada();
            }
            yPosition -= 30;
            
            //Funções para definir os totalizadores           
            funcoesRelatorio.valoresTresTotalizadores("Total Dízimo: ", "Total Oferta: ", "Soma Total: ", totalDizimo,totalOfertas,totalDizimoOfertas,yPosition,fluxoConteudo);
            
            fluxoConteudo.close();
            this.funcoesRelatorio.salvarRelatorioPDF("Registro de Dizimo e Ofertas",documentoPDF);
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
    
    private void layoutTipoOferta(List<RegistroDizimoOferta> listaRgDizimoOfertas){
        
        //Definição das variáveis
        final String dataInicial = this.dataInicial.getText();
        final String dataFinal = this.dataFinal.getText();
        final Igreja igrejaSelec = (Igreja) this.igreja.getSelectedItem();
        String nomeIgreja = null;
        Integer codTpOferta=  null;
        String nomeTpOferta = "";
        final String titulo = "Registros de Dizimo e Ofertas";  
        double subTotalEntradaDizimo = 0;
        double subTotalEntradaOfertas = 0;
        double subTotalSaidaDizimo = 0;
        double subTotalSaidaOfertas = 0;
        double totalEntradaDizimoOfertas = 0;
        double totalSaidaDizimoOfertas = 0;
        
        //Verifica se foi foi filtrado por igreja, ou se vai mostrar todas as igrejas
        if(igrejaSelec == null){
            nomeIgreja = "Todas Igrejas";
        }else{
            nomeIgreja = igrejaSelec.getNome();
        }
        
        final String subTitulo = "Período de "+dataInicial+" até "+dataFinal+" - "+nomeIgreja; 
        
        //Variáveis referente ao layout da página
        float yPosition = 700; // Posição vertical inicial para os títulos
        float xPosition = 40; // Posição horizontal inicial para os títulos
        final int layout = 2;
        final float tamanhoFonteTitulo = 18; 
        final float tamanhaFonte = 10;
        final int limiteCaracteres = 35; // Limite de caracteres 
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
                    
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
            this.funcoesRelatorio.tituloRelatorio(tamanhoFonteTitulo, titulo, fluxoConteudo, paginaPDF);               
            //Gerando o sub título do relatório
            this.funcoesRelatorio.subTituloRelatorio(subTitulo, fluxoConteudo, paginaPDF);   
                
            // Iterar sobre os registro de dízimos e ofertas
            for (RegistroDizimoOferta rg : listaRgDizimoOfertas) {      
                          
                if (yPosition < 90) { // Se a posição Y estiver abaixo do limite da página, criar uma nova página
                    fluxoConteudo.close();
                    PDPage novaPagina = new PDPage(PDRectangle.A4); // Tamanho da página
                    documentoPDF.addPage(novaPagina);
                    fluxoConteudo = new PDPageContentStream(documentoPDF, novaPagina);
                    yPosition = 750; // Resetar a posição Y para o topo da nova página
                }
                
                //Divisão pelo layout
                if(codTpOferta == null || codTpOferta.compareTo(rg.getTpOferta().getCodigo()) != 0){               
                    if(codTpOferta == null){
                        yPosition -= 15; // Pular para a linha abaixo após o título, na primeira listagem
                    }else{    
                        //Define o posicionamento vertical e horizontal da próxima informação, com base no posicionamento da informação anterior
                        xPosition += 350;
                        
                        if(codTpOferta == 1){
                            funcoesRelatorio.valoresDoisTotalizadores("Entrada Dizimos: ","Saída Dizimos: ", subTotalEntradaDizimo, subTotalSaidaDizimo,yPosition,fluxoConteudo);
                        }else{
                            funcoesRelatorio.valoresDoisTotalizadores("Entrada "+nomeTpOferta+" : ", "Saída "+nomeTpOferta+" : ", subTotalEntradaOfertas,subTotalSaidaOfertas,yPosition,fluxoConteudo);
                        }
                        //Totalizados no final e cada data
                        //Define o posicionamento vertical e horizontal da próxima informação, com base no posicionamento da informação anterior
                        xPosition = 40;
                        yPosition -= 50; 
                    }
                    
                    if (yPosition < 90) { // Se a posição Y estiver abaixo do limite da página, criar uma nova página
                        fluxoConteudo.close();
                        PDPage novaPagina = new PDPage(PDRectangle.A4); // Tamanho da página
                        documentoPDF.addPage(novaPagina);
                        fluxoConteudo = new PDPageContentStream(documentoPDF, novaPagina);
                        yPosition = 750; // Resetar a posição Y para o topo da nova página
                    }

                    //Definir titulos dos agrupameto do layout
                    String tituloLayout = rg.getTpOferta().getNome();
                    this.funcoesRelatorio.tituloLayoutEsquerda(tituloLayout, yPosition, xPosition, fluxoConteudo);
                    
                    //Variável de controle, para validar quando for outro tipo de oferta
                    codTpOferta = rg.getTpOferta().getCodigo(); 
                    nomeTpOferta = rg.getTpOferta().getNome();
                    yPosition -= 20;
                                         
                    // Definir os títulos das colunas
                    String[] titulosTabela = {"Tp Oferta", "Val. Oferta", "Operação", "Igreja", "Conta Caixa", "Data Oferta"};
                    this.funcoesRelatorio.tituloColunaRelatorioRgDizimoOferta(layout ,yPosition, xPosition, titulosTabela, fluxoConteudo);           
                    yPosition -= 20; // Pular para a linha abaixo após o título

                    subTotalEntradaDizimo = 0;
                    subTotalEntradaOfertas = 0;
                    subTotalSaidaDizimo = 0;
                    subTotalSaidaOfertas = 0;
                }           
                
                // Resetar a posição horizontal a cada nova linha
                xPosition = 40; 

                // Obter os dados da lista
                String dataOferta = conversor.convertendoDataStringSql((java.sql.Date) rg.getDataOferta());
                String tpOperacao = "";
                String tipoOfertaDizimo = rg.getTpOferta().getNome();
                String valor = "0";
                String igreja = rg.getIgreja().getNome();
                String contaCaixa = rg.getContaCaixa().getNome();
                
                //Verifica o tamanho da descrição, para que não passe do tamanha de caraceteres
                if (tipoOfertaDizimo.length() > limiteCaracteres) {
                    tipoOfertaDizimo = tipoOfertaDizimo.substring(0, limiteCaracteres); // Truncar e adicionar "..."
                }
                
                //Verifica se é uma operação de entrada ou saída
                if(rg.getValorOfertaEntrada() > 0){
                    tpOperacao = "Entrada";
                    valor = this.conversor.formatarDoubleString(rg.getValorOfertaEntrada()).replace(".", ",");
                }else{
                    tpOperacao = "Saída";
                    valor = this.conversor.formatarDoubleString(rg.getValorOfertaSaida()).replace(".", ",");
                }

               //Inicia o processo de escrever os dados
                fluxoConteudo.beginText();
                fluxoConteudo.setFont(times, tamanhaFonte);

                fluxoConteudo.newLineAtOffset(xPosition, yPosition);
                fluxoConteudo.showText(tipoOfertaDizimo);
                xPosition += 80; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valor);
                xPosition -= 50; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(tpOperacao);
                xPosition -= 10; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(igreja);
                xPosition += 70; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(contaCaixa);
                xPosition -= 50; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(dataOferta);

                fluxoConteudo.endText();

                // Descer para a próxima linha
                yPosition -= 20; 
                
                //Verificando quem é dízimo e quem é oferta
                if(rg.getTpOferta().getCodigo() == 1){
                    subTotalEntradaDizimo += rg.getValorOfertaEntrada();
                    subTotalSaidaDizimo += rg.getValorOfertaSaida();
                }else{
                    subTotalEntradaOfertas += rg.getValorOfertaEntrada();
                    subTotalSaidaOfertas += rg.getValorOfertaSaida();
                }
                
                totalEntradaDizimoOfertas += rg.getValorOfertaEntrada();
                totalSaidaDizimoOfertas += rg.getValorOfertaSaida();
            }
            //Define o posicionamento vertical e horizontal da próxima informação, com base no posicionamento da informação anterior
            xPosition += 350;  
            
            //Ultimo subtotal da listagem       
            if(tipoOferta.getSelectedItem() == null){              
                funcoesRelatorio.valoresDoisTotalizadores("Entrada "+nomeTpOferta+" : ", "Saída "+nomeTpOferta+" : ", subTotalEntradaDizimo,subTotalEntradaOfertas,yPosition,fluxoConteudo);
            }       
            //Define o posicionamento vertical e horizontal da próxima informação, com base no posicionamento da informação anterior
            yPosition -= 60;
            
            //Funções para definir os totalizadotes
            funcoesRelatorio.valoresDoisTotalizadores("Total Entrada Dízimos e Ofertas: ","Total Saída Dizimo e Ofertas:    ", totalEntradaDizimoOfertas,totalSaidaDizimoOfertas, yPosition, fluxoConteudo);

            fluxoConteudo.close();
            this.funcoesRelatorio.salvarRelatorioPDF("RegistroDizimoOferta(TipoOferta)",documentoPDF);
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
    
    private void layoutIgreja(List<RegistroDizimoOferta> listaRgDizimoOfertas){
        
        //Definição das variáveis
        final String dataInicial = this.dataInicial.getText();
        final String dataFinal = this.dataFinal.getText();
        final TipoOferta tpOfertaSelec = (TipoOferta) this.tipoOferta.getSelectedItem();
        String tpOferta = null;
        Integer codIgreja = null;
        final String titulo = "Registros de Dizimo e Ofertas";    
        double subTotalDizimo = 0;
        double subTotalOfertas = 0;
        double totalDizimo = 0;
        double totalOfertas = 0;
        double totalDizimoOfertas = 0;
        
        //Verifica se foi foi filtrado por igreja, ou se vai mostrar todas as igrejas
        if(tpOfertaSelec == null){
            tpOferta = "Todas Ofertas";
        }else{
            tpOferta = tpOfertaSelec.getNome();
        }
           
        final String subTitulo = "Período de "+dataInicial+" até "+dataFinal+" - "+tpOferta; 
        
        //Variáveis referente ao layout da página
        float yPosition = 700; // Posição vertical inicial para os títulos
        float xPosition = 40; // Posição horizontal inicial para os títulos
        final int layout = 3;
        final float tamanhoFonteTitulo = 18; 
        final float tamanhaFonte = 10;
        final int limiteCaracteres = 35; // Limite de caracteres 
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        
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
            this.funcoesRelatorio.tituloRelatorio(tamanhoFonteTitulo, titulo, fluxoConteudo, paginaPDF);               
            //Gerando o sub título do relatório
            this.funcoesRelatorio.subTituloRelatorio(subTitulo, fluxoConteudo, paginaPDF);   
                
            // Iterar sobre os registro de dízimos e ofertas
            for (RegistroDizimoOferta rg : listaRgDizimoOfertas) { 
                
                // Verifica o espaço final para gerar outra página
                if (yPosition < 90) { // Se a posição Y estiver abaixo do limite da página, criar uma nova página
                    fluxoConteudo.close();
                    PDPage novaPagina = new PDPage(PDRectangle.A4); // Tamanho da página
                    documentoPDF.addPage(novaPagina);
                    fluxoConteudo = new PDPageContentStream(documentoPDF, novaPagina);
                    yPosition = 750; // Resetar a posição Y para o topo da nova página
                }
        
                //Divisão pelo layout
                if(codIgreja == null || codIgreja.compareTo(rg.getIgreja().getCodigo()) != 0){               
                    if(codIgreja == null){
                        yPosition -= 15; // Pular para a linha abaixo após o título, na primeira listagem
                    }else{   
                        //Define o posicionamento vertical e horizontal da próxima informação, com base no posicionamento da informação anterior
                        xPosition += 330;
                        yPosition -= 30;

                        //Totalizados no final e cada data
                        funcoesRelatorio.valoresDoisTotalizadores("Subtotal Dízimo: ", "Subtotal Oferta:  ", subTotalDizimo,subTotalOfertas,yPosition,fluxoConteudo);
                        xPosition = 40;
                        yPosition -= 40; // Pular para a linha abaixo após o título, nas demais listagem
                    }

                    if (yPosition < 90) { // Se a posição Y estiver abaixo do limite da página, criar uma nova página
                        fluxoConteudo.close();
                        PDPage novaPagina = new PDPage(PDRectangle.A4); // Tamanho da página
                        documentoPDF.addPage(novaPagina);
                        fluxoConteudo = new PDPageContentStream(documentoPDF, novaPagina);
                        yPosition = 750; // Resetar a posição Y para o topo da nova página
                    }


                    //Definir titulos dos agrupameto do layout
                    String tituloLayout = rg.getIgreja().getNome();
                    this.funcoesRelatorio.tituloLayoutEsquerda(tituloLayout, yPosition, xPosition, fluxoConteudo);
                    
                    //Variável de controle, para validar quando for outro tipo de oferta
                    codIgreja = rg.getIgreja().getCodigo();  
                    yPosition -= 20;
                                         
                    // Definir os títulos das colunas
                    String[] titulosTabela = {"Tp Oferta", "Val. Oferta", "Operação", "Igreja", "Conta Caixa", "Data Oferta"};
                    this.funcoesRelatorio.tituloColunaRelatorioRgDizimoOferta(layout ,yPosition, xPosition, titulosTabela, fluxoConteudo);           
                    yPosition -= 20; // Pular para a linha abaixo após o título

                    subTotalDizimo = 0;
                    subTotalOfertas = 0;
                }           

                // Resetar a posição horizontal a cada nova linha
                xPosition = 40; 

                // Obter os dados da lista
                String dataOferta = conversor.convertendoDataStringSql((java.sql.Date) rg.getDataOferta());
                String tipoOfertaDizimo = rg.getTpOferta().getNome();
                String igreja = rg.getIgreja().getNome();
                String contaCaixa = rg.getContaCaixa().getNome();
                String tpOperacao = "";
                String valor = "0";
                
                //Verifica o tamanho da descrição, para que não passe do tamanha de caraceteres
                if (tipoOfertaDizimo.length() > limiteCaracteres) {
                    tipoOfertaDizimo = tipoOfertaDizimo.substring(0, limiteCaracteres); // Truncar e adicionar "..."
                }
                
                //Verifica se é uma operação de entrada ou saí­da
                if(rg.getValorOfertaEntrada() > 0){
                    tpOperacao = "Entrada";
                    valor = this.conversor.formatarDoubleString(rg.getValorOfertaEntrada()).replace(".", ",");
                }else{
                    tpOperacao = "Sai­da";
                    valor = this.conversor.formatarDoubleString(rg.getValorOfertaSaida()).replace(".", ",");
                }

               //Inicia o processo de escrever os dados
                fluxoConteudo.beginText();
                fluxoConteudo.setFont(times, tamanhaFonte);

                fluxoConteudo.newLineAtOffset(xPosition, yPosition);
                fluxoConteudo.showText(tipoOfertaDizimo);
                xPosition += 80; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valor);
                xPosition -= 55; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(tpOperacao);
                xPosition += 0; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(igreja);
                xPosition += 60; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(contaCaixa);
                xPosition -= 40; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(dataOferta);

                fluxoConteudo.endText();

                // Descer para a próxima linha
                yPosition -= 20; 
                
                //Verificando quem é dízimo e quem é oferta
                if(rg.getTpOferta().getCodigo() == 1){
                    subTotalDizimo += rg.getValorOfertaEntrada();
                    totalDizimo += rg.getValorOfertaEntrada();
                }else{
                    subTotalOfertas += rg.getValorOfertaEntrada();
                    totalOfertas += rg.getValorOfertaEntrada();
                }
                
                totalDizimoOfertas += rg.getValorOfertaEntrada();
            }
            //Define o posicionamento vertical da próxima informação, com base no posicionamento da informação anterior
            yPosition -= 30;       
            
            //Verifica se foi selecionado algum filtro. Caso tenha sido, não mostra o subtotal, e mostra apenas o total.          
            if(igreja.getSelectedItem() == null){              
                funcoesRelatorio.valoresDoisTotalizadores("Subtotal Dízimo: ", "Subtotal Oferta:  ", subTotalDizimo,subTotalOfertas,yPosition,fluxoConteudo);
            }       
            //Define o posicionamento vertical e horizontal da próxima informação, com base no posicionamento da informação anterior
            yPosition -= 50;
            
            //Funções para definir os totalizadotes
            funcoesRelatorio.valoresTresTotalizadores("Total De Dízimos: ","Total de Oferta:    ", "Soma Total:           ", totalDizimo,totalOfertas,totalDizimoOfertas,yPosition,fluxoConteudo);

            fluxoConteudo.close();
            this.funcoesRelatorio.salvarRelatorioPDF("Registro de Dizimo e Oferta(Igreja)",documentoPDF);
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
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarRe;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.ButtonGroup grupoDataOferta;
    private javax.swing.ButtonGroup grupoLayout;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton rbDataLancamento;
    private javax.swing.JRadioButton rbDataOferta;
    private javax.swing.JRadioButton rbIgreja;
    private javax.swing.JRadioButton rbPadrao;
    private javax.swing.JRadioButton rbTipoOferta;
    private javax.swing.JComboBox<String> tipoOferta;
    private javax.swing.JLabel txData;
    // End of variables declaration//GEN-END:variables
}
