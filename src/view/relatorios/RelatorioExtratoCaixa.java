
package view.relatorios;

import Ferramentas.UtilitariosRelatorios;
import Ferramentas.Utilitarios;
import dao.ContaCaixaDao;
import dao.IgrejaDao;
import dao.MovimentoCaixaDao;
import dao.UsuarioDao;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.ContaCaixa;
import model.Igreja;
import model.MovimentoCaixa;
import model.Usuario;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class RelatorioExtratoCaixa extends javax.swing.JInternalFrame {
    
    private final Utilitarios conversor = new Utilitarios();
    private final UtilitariosRelatorios funcoesRelatorio = new UtilitariosRelatorios();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final ContaCaixaDao contaCaixaDao = new ContaCaixaDao();
    private final MovimentoCaixaDao movimentoCaixaDao = new MovimentoCaixaDao();
    private final UsuarioDao usuarioDao = new UsuarioDao();
    private String filtroIgreja = "";


    public RelatorioExtratoCaixa(Usuario usuarioLogado) {
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

        rbGrupoTipoMovimento = new javax.swing.ButtonGroup();
        rbGrupoLayout = new javax.swing.ButtonGroup();
        contaCaixa = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txData = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        igreja = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rbDataMovimento = new javax.swing.JRadioButton();
        rbIgreja = new javax.swing.JRadioButton();
        rbPadrao = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        rbEntradaSaida = new javax.swing.JRadioButton();
        rbEntrada = new javax.swing.JRadioButton();
        rbSaida = new javax.swing.JRadioButton();
        btnGerar = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Extrato Caixa");
        setPreferredSize(new java.awt.Dimension(420, 267));

        jLabel1.setText("Conta Caixa");

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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Layout", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        rbGrupoLayout.add(rbDataMovimento);
        rbDataMovimento.setText("Data Movimento");

        rbGrupoLayout.add(rbIgreja);
        rbIgreja.setText("Igreja");

        rbGrupoLayout.add(rbPadrao);
        rbPadrao.setText("Padrão");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbIgreja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbDataMovimento, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(rbPadrao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(rbPadrao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDataMovimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbIgreja)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tipo Movimento", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        rbGrupoTipoMovimento.add(rbEntradaSaida);
        rbEntradaSaida.setText("Entrada/Saída");

        rbGrupoTipoMovimento.add(rbEntrada);
        rbEntrada.setText("Entrada");

        rbGrupoTipoMovimento.add(rbSaida);
        rbSaida.setSelected(true);
        rbSaida.setText("Saída");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rbEntradaSaida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbEntrada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbSaida)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbEntradaSaida)
                    .addComponent(rbEntrada)
                    .addComponent(rbSaida))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGerar.setBackground(new java.awt.Color(0, 153, 255));
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(igreja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(142, 142, 142)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGerar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataInicial)
                            .addComponent(dataFinal)
                            .addComponent(jLabel4)
                            .addComponent(txData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGerar))))
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

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        gerarRelatorio();
    }//GEN-LAST:event_btnGerarActionPerformed

    private List<MovimentoCaixa> consultarMovimentoCaixa(String ordemConsulta){
        
        ContaCaixa contaCaixa = (ContaCaixa) this.contaCaixa.getSelectedItem();
        Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        Integer tpMovimento =  null;
        Date dataInicial = this.conversor.convertendoStringDateSql(this.dataInicial.getText());
        Date dataFinal = this.conversor.convertendoStringDateSql(this.dataFinal.getText());
  
        //Verifica qual o status foi escolhido
        if(this.rbEntrada.isSelected()){
            tpMovimento = 1;
        }else if(this.rbSaida.isSelected()){
            tpMovimento = 2;
        } 
        
        List<MovimentoCaixa> listaMovimento = this.movimentoCaixaDao.consultarMovimentacaoRelatorio(igreja, contaCaixa, dataInicial, dataFinal, ordemConsulta, tpMovimento, this.filtroIgreja);
        
        return listaMovimento;
    }
    
    private void gerarRelatorio(){
        
        List<MovimentoCaixa> listaMovimentoCaixa = null;
        
        if(this.rbPadrao.isSelected()){
            listaMovimentoCaixa = consultarMovimentoCaixa("Codigo");
            layoutPadrao(listaMovimentoCaixa);
        }else if(this.rbDataMovimento.isSelected()){
            listaMovimentoCaixa = consultarMovimentoCaixa("DataMovimento");
            layoutDataMovimento(listaMovimentoCaixa);
        }else if(this.rbIgreja.isSelected()){
            listaMovimentoCaixa = consultarMovimentoCaixa("Igreja");
            layoutIgreja(listaMovimentoCaixa);
        }
        
    }
    
    private void layoutPadrao(List<MovimentoCaixa> listaMovimentoCaixa){
        
        // Criar um novo documento PDF
        final PDDocument documentoPDF = new PDDocument();
        PDPageContentStream fluxoConteudo = null;

        // Adicionar uma nova página ao documento
        final PDPage paginaPDF = new PDPage(PDRectangle.A4);//Tamanho da página
        documentoPDF.addPage(paginaPDF);
        
        //Definição das variáveis
        String dataInicial = this.dataInicial.getText();
        String dataFinal = this.dataFinal.getText();
        ContaCaixa contaCaixaSelec = (ContaCaixa) this.contaCaixa.getSelectedItem();
        Igreja igrejaSelec = (Igreja) this.igreja.getSelectedItem();
        String nomeIgreja = null;
        String nomeCx = contaCaixaSelec.getNome();
        final String titulo = "Extrato de Caixa";   
        if(igrejaSelec == null){
            nomeIgreja = "Todas Igrejas";
        }else{
            nomeIgreja = igrejaSelec.getNome();
        }
        final String subTitulo = "Período de "+dataInicial+" até "+dataFinal+" - CONTA: "+nomeCx+" - "+nomeIgreja; 
        double totalEntrada = 0;
        double totalSaida = 0;
        double saldo = 0;
        
        float yPosition = 700; // Posição vertical inicial para os títulos
        float xPosition = 40; // Posição horizontal inicial para os títulos
        int layout = 1;
        float tamanhaFonte = 10;
        float tamanhoFonteTitulo = 18;
        int limiteCaracteres = 35; // Limite de caracteres (ajuste conforme necessário)    
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        
        try {         
            // Criar o conteúdo para a página      
            fluxoConteudo = new PDPageContentStream(documentoPDF, paginaPDF);             
            //Gerando o título do relatório
            this.funcoesRelatorio.primeiroTituloRelatorio(tamanhoFonteTitulo, titulo, fluxoConteudo, paginaPDF);             
            //Gerando o sub título do relatório
            this.funcoesRelatorio.subTituloRelatorio(subTitulo, fluxoConteudo, paginaPDF);   
            
            // Definir os títulos das colunas
            String[] titulosTabela = {"Data", "Descrição", "Entrada", "Saída", "Tipo", "Igreja"};
            this.funcoesRelatorio.tituloColunaRelatorioContaCaixa(layout ,yPosition, xPosition, titulosTabela, fluxoConteudo);           
            yPosition -= 20; // Pular para a linha abaixo após o título

            for(MovimentoCaixa mv:listaMovimentoCaixa) {              
                if (yPosition < 50) { // Se a posição Y estiver abaixo do limite da página, criar uma nova página
                    fluxoConteudo.close();
                    PDPage novaPagina = new PDPage(PDRectangle.A4); // Tamanho da página
                    documentoPDF.addPage(novaPagina);
                    fluxoConteudo = new PDPageContentStream(documentoPDF, novaPagina);
                    yPosition = 750; // Resetar a posição Y para o topo da nova página
                }                
                xPosition = 40; // Resetar a posição horizontal a cada nova linha

                // Obter os dados da lista (exemplo de como acessar a lista e pegar os dados)
                String data = conversor.convertendoDataStringSql((java.sql.Date) mv.getDataMovimento());
                String descricao = mv.getComplemento();
                if (descricao.length() > limiteCaracteres) {
                    descricao = descricao.substring(0, limiteCaracteres); // Truncar e adicionar "..."
                }
                String entrada = this.conversor.formatarDoubleString(mv.getValorEntrada()).replace(".", ",");
                String saida = this.conversor.formatarDoubleString(mv.getValorSaida()).replace(".", ",");
                String igreja = mv.getIgreja().getNome();
                String tipo = null;
                if(mv.getCrCampanha().getCodigo() != 0){
                    tipo = "Campanha";
                }else if(mv.getContaPagar().getCodigo() != 0){
                    tipo = "Conta Pagar";
                }else if(mv.getRgOferta().getCodigo() != 0){
                    tipo = "Oferta/Dízimo";
                }else{
                    tipo = "Op Bancária";
                }

                fluxoConteudo.beginText();
                fluxoConteudo.setFont(times, tamanhaFonte);

                fluxoConteudo.newLineAtOffset(xPosition, yPosition);
                fluxoConteudo.showText(data);
                xPosition += 17; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(descricao);
                xPosition += 160; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(entrada);
                xPosition -= 165; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(saida);
                xPosition += 6; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(tipo);
                xPosition += 11; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(igreja);
                xPosition += 11; // Ajusta a posição da próxima coluna

                fluxoConteudo.endText();

                // Descer para a próxima linha
                yPosition -= 20; // Ajuste o espaçamento vertical conforme necessário  
                totalEntrada += mv.getValorEntrada();
                totalSaida += mv.getValorSaida();
            }
            
            yPosition -= 50;
            xPosition += 330;
            saldo = totalEntrada - totalSaida;
            funcoesRelatorio.valoresTresTotalizadores("Total Entrada: ", "Total Saída:      ", "Saldo Atual:      ", totalEntrada,totalSaida,saldo,yPosition,fluxoConteudo);
            
            fluxoConteudo.close();
            this.funcoesRelatorio.salvarRelatorioPDF("ExtratoCaixa",documentoPDF);
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
    
    private void layoutDataMovimento(List<MovimentoCaixa> listaMovimentoCaixa){
        
        // Criar um novo documento PDF
        final PDDocument documentoPDF = new PDDocument();
        PDPageContentStream fluxoConteudo = null;

        // Adicionar uma nova página ao documento
        final PDPage paginaPDF = new PDPage(PDRectangle.A4);//Tamanho da página
        documentoPDF.addPage(paginaPDF);
        
        String dataInicial = this.dataInicial.getText();
        String dataFinal = this.dataFinal.getText();
        ContaCaixa contaCaixaSelec = (ContaCaixa) this.contaCaixa.getSelectedItem();
        Date dataMovimento = null;
        String nomeCx = contaCaixaSelec.getNome();
        final String titulo = "Extrato de Caixa(Data Movimento)";   
        final String subTitulo = "Período de "+dataInicial+" até "+dataFinal+" - CONTA: "+nomeCx; 
        double entrada = 0;
        double saida = 0;
        double totalEntrada = 0;
        double totalSaida = 0;
        double saldo = 0;
        
        float yPosition = 700; // Posição vertical inicial para os títulos
        float xPosition = 40; // Posição horizontal inicial para os títulos
        int layout = 2;
        float tamanhaFonteDados = 12;
        float tamanhoFonteTitulo = 18;
        int limiteCaracteres = 45; // Limite de caracteres (ajuste conforme necessário)
        
        PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        
        try {         
            // Criar o conteúdo para a página      
            fluxoConteudo = new PDPageContentStream(documentoPDF, paginaPDF);              
            //Gerando o título do relatório
            this.funcoesRelatorio.primeiroTituloRelatorio(tamanhoFonteTitulo, titulo, fluxoConteudo, paginaPDF);               
            //Gerando o sub título do relatório
            this.funcoesRelatorio.subTituloRelatorio(subTitulo, fluxoConteudo, paginaPDF);   
                
            // Iterar sobre as contas a pagar
            for (MovimentoCaixa mv : listaMovimentoCaixa) {      
                //Divisão pelo layout
                if(dataMovimento == null || dataMovimento.compareTo(mv.getDataMovimento()) != 0){               
                    if(dataMovimento == null){
                        yPosition -= 15; // Pular para a linha abaixo após o título, na primeira listagem
                    }else{   
                        //Define o posicinamento vertical e orizontal do próximo conteúdo
                        xPosition += 360;
                        yPosition -= 10;
                        //funcoesRelatorio.descricaoDoisTotalizadores("Entrada", "Saída", yPosition,xPosition,fluxoConteudo);
                        funcoesRelatorio.valoresDoisTotalizadores("Entrada: ", "Saída:      ", entrada,saida,yPosition,fluxoConteudo);
                        xPosition = 40;
                        yPosition -= 40; // Pular para a linha abaixo após o título, nas demais listagem
                    }

                    //Definir titulos dos agrupameto do layout
                    String data = this.conversor.convertendoDataStringSql((java.sql.Date) mv.getDataMovimento());
                    String tituloLayout = "Data Movimento: "+data;
                    this.funcoesRelatorio.tituloLayoutEsquerda(tituloLayout, yPosition, xPosition, fluxoConteudo);
                    
                    dataMovimento = mv.getDataMovimento();  
                    yPosition -= 20;
                                         
                    // Definir os títulos das colunas
                    String[] titulosTabela = {"Descrição", "Entrada", "Saída", "Tipo", "Igreja"};
                    this.funcoesRelatorio.tituloColunaRelatorioContaCaixa(layout ,yPosition, xPosition, titulosTabela, fluxoConteudo);           
                    yPosition -= 20; // Pular para a linha abaixo após o título
                    
                    //Zerando os valores dos totais por data, para calcular o próximo total do próximo grupo de data
                    entrada = 0;
                    saida = 0;
                }           

                xPosition = 40; // Resetar a posição horizontal a cada nova linha
                
                if (yPosition < 50) { // Se a posição Y estiver abaixo do limite da página, criar uma nova página
                    fluxoConteudo.close();
                    PDPage novaPagina = new PDPage(PDRectangle.A4); // Tamanho da página
                    documentoPDF.addPage(novaPagina);
                    fluxoConteudo = new PDPageContentStream(documentoPDF, novaPagina);
                    yPosition = 750; // Resetar a posição Y para o topo da nova página
                }

                // Obter os dados da lista (exemplo de como acessar a lista e pegar os dados)
                String descricao = mv.getComplemento();
                if (descricao.length() > limiteCaracteres) {
                    descricao = descricao.substring(0, limiteCaracteres); // Truncar e adicionar "..."
                }
                String valorEntrada = this.conversor.formatarDoubleString(mv.getValorEntrada()).replace(".", ",");
                String valorSaida = this.conversor.formatarDoubleString(mv.getValorSaida()).replace(".", ",");
                String igreja = mv.getIgreja().getNome();
                String tipo = null;
                //Definindo o tipo de movimentação que será mostrado no relatório
                if(mv.getCrCampanha().getCodigo() != 0){
                    tipo = "Campanha";
                }else if(mv.getContaPagar().getCodigo() != 0){
                    tipo = "Conta Pagar";
                }else if(mv.getRgOferta().getCodigo() != 0){
                    tipo = "Oferta/Dízimo";
                }else{
                    tipo = "Op Bancária";
                }

                fluxoConteudo.beginText();
                fluxoConteudo.setFont(times, tamanhaFonteDados);
                
                fluxoConteudo.newLineAtOffset(xPosition, yPosition);
                fluxoConteudo.showText(descricao);
                xPosition += 210; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valorEntrada);
                xPosition -= 185; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valorSaida);
                xPosition -= 5; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(tipo);
                xPosition += 20; // Ajusta a posição da próxima coluna
                
                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(igreja);

                fluxoConteudo.endText();

                // Descer para a próxima linha
                yPosition -= 20; // Ajuste o espaçamento vertical conforme necessário     
                entrada += mv.getValorEntrada();
                saida += mv.getValorSaida();
                totalEntrada += mv.getValorEntrada();
                totalSaida += mv.getValorSaida();
            }
            saldo = totalEntrada - totalSaida;
            xPosition += 360;
            yPosition -= 10;
            funcoesRelatorio.valoresDoisTotalizadores("Entrada: ", "Saída:      ",entrada,saida, yPosition, fluxoConteudo);
            xPosition -= 30;
            yPosition -= 50;
            funcoesRelatorio.valoresTresTotalizadores("Total Entrada: ", "Total Saída:      ", "Saldo Atual:      ", totalEntrada,totalSaida,saldo, yPosition,fluxoConteudo);

            fluxoConteudo.close();
            this.funcoesRelatorio.salvarRelatorioPDF("ExtratoCaixa(DataMovimento)",documentoPDF);
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
    
    private void layoutIgreja(List<MovimentoCaixa> listaMovimentoCaixa){
        
        // Criar um novo documento PDF
        final PDDocument documentoPDF = new PDDocument();
        PDPageContentStream fluxoConteudo = null;

        // Adicionar uma nova página ao documento
        final PDPage paginaPDF = new PDPage(PDRectangle.A4);//Tamanho da página
        documentoPDF.addPage(paginaPDF);
        
        String dataInicial = this.dataInicial.getText();
        String dataFinal = this.dataFinal.getText();
        ContaCaixa contaCaixaSelec = (ContaCaixa) this.contaCaixa.getSelectedItem();
        Igreja igreja = null;
        String nomeCx = contaCaixaSelec.getNome();
        final String titulo = "Extrato de Caixa(Igreja)";   
        final String subTitulo = "Período de "+dataInicial+" até "+dataFinal+" - CONTA: "+nomeCx; 
        double entrada = 0;
        double saida = 0;
        double totalEntrada = 0;
        double totalSaida = 0;
        double saldo = 0;
        
        float yPosition = 700; // Posição vertical inicial para os títulos
        float xPosition = 40; // Posição horizontal inicial para os títulos
        int layout = 3;
        float tamanhoFonteTitulo = 18;
        float tamanhaFonteDados = 10;
        int limiteCaracteres = 35; // Limite de caracteres (ajuste conforme necessário)
        
        PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        
        try {         
            // Criar o conteúdo para a página      
            fluxoConteudo = new PDPageContentStream(documentoPDF, paginaPDF);  
            
            //Gerando o título do relatório
            this.funcoesRelatorio.primeiroTituloRelatorio(tamanhoFonteTitulo, titulo, fluxoConteudo, paginaPDF);    
            
            //Gerando o sub título do relatório
            this.funcoesRelatorio.subTituloRelatorio(subTitulo, fluxoConteudo, paginaPDF);   
                
            // Iterar sobre as contas a pagar
            for (MovimentoCaixa mv : listaMovimentoCaixa) {      
                //Divisão pelo layout
                if(igreja == null || igreja.getCodigo() != mv.getIgreja().getCodigo()){ 
                    if(igreja == null){
                        yPosition -= 15; // Pular para a linha abaixo após o título, na primeira listagem
                    }else{          
                        //Define o posicinamento vertical e horizontal do próximo conteúdo com nase na posição anterior
                        xPosition += 360;
                        yPosition -= 10;
                        
                        funcoesRelatorio.valoresDoisTotalizadores("Entrada: ", "Saída:      ",entrada,saida,yPosition,fluxoConteudo);
                        xPosition = 40;
                        yPosition -= 40; // Pular para a linha abaixo após o título, nas demais listagem
                    }
                    
                    //Titulo das divisões do layout
                    String tituloLayout = mv.getIgreja().getNome();
                    this.funcoesRelatorio.tituloLayoutEsquerda(tituloLayout, yPosition, xPosition, fluxoConteudo);
                    
                    igreja = mv.getIgreja();  
                    yPosition -= 20;
                                         
                    // Definir os títulos das colunas
                    String[] titulosTabela = {"Pessoa","Data", "Descrição", "Entrada", "Saída", "Tipo"};
                    this.funcoesRelatorio.tituloColunaRelatorioContaCaixa(layout ,yPosition, xPosition, titulosTabela, fluxoConteudo);           
                    yPosition -= 20; // Pular para a linha abaixo após o título
                    
                    //Zerando os valores dos totais por data, para calcular o próximo total do próximo grupo de data
                    entrada = 0;
                    saida = 0;
                }           

                xPosition = 40; // Resetar a posição horizontal a cada nova linha
                
                if (yPosition < 50) { // Se a posição Y estiver abaixo do limite da página, criar uma nova página
                    fluxoConteudo.close();
                    PDPage novaPagina = new PDPage(PDRectangle.A4); // Tamanho da página
                    documentoPDF.addPage(novaPagina);
                    fluxoConteudo = new PDPageContentStream(documentoPDF, novaPagina);
                    yPosition = 750; // Resetar a posição Y para o topo da nova página
                }

                // Obter os dados da lista (exemplo de como acessar a lista e pegar os dados)
                String pessoa = String.valueOf(mv.getPessoa().getCodigo());
                String data = conversor.convertendoDataStringSql((java.sql.Date) mv.getDataMovimento());
                String descricao = mv.getComplemento();
                if (descricao.length() > limiteCaracteres) {
                    descricao = descricao.substring(0, limiteCaracteres); // Truncar e adicionar "..."
                }
                String valorEntrada = this.conversor.formatarDoubleString(mv.getValorEntrada()).replace(".", ",");
                String valorSaida = this.conversor.formatarDoubleString(mv.getValorSaida()).replace(".", ",");
                String tipo = null;
                if(mv.getCrCampanha().getCodigo() != 0){
                    tipo = "Campanha";
                }else if(mv.getContaPagar().getCodigo() != 0){
                    tipo = "Conta Pagar";
                }else if(mv.getRgOferta().getCodigo() != 0){
                    tipo = "Oferta/Dízimo";
                }else{
                    tipo = "Op Bancária";
                }

                // Desenhar os dados da linha na tabela
                fluxoConteudo.beginText();
                fluxoConteudo.setFont(times, tamanhaFonteDados);
                
                fluxoConteudo.newLineAtOffset(xPosition, yPosition);
                fluxoConteudo.showText(pessoa);
                xPosition += 5; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(data);
                xPosition += 10; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(descricao);
                xPosition += 160; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valorEntrada);
                xPosition -= 160; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(valorSaida);
                xPosition += 3; // Ajusta a posição da próxima coluna

                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText(tipo);

                fluxoConteudo.endText();

                // Descer para a próxima linha
                yPosition -= 20;//Defini a posição vertical da próxima informação, com base na posição da informação anterior   
                entrada += mv.getValorEntrada();
                saida += mv.getValorSaida();
                totalEntrada += mv.getValorEntrada();
                totalSaida += mv.getValorSaida();
            }
            saldo = totalEntrada - totalSaida;
            //Defini a posição vertical e horizonta da próxima informação, com base na posição da informação anterior
            xPosition += 360;
            yPosition -= 10;
            
            funcoesRelatorio.valoresDoisTotalizadores("Entrada: ", "Saída:      ",entrada,saida,yPosition,fluxoConteudo);            //funcoesRelatorio.descricaoTresTotalizadores(textoTotalEntrada, textoTotalSaida, textoSaldoAtual, yPosition,xPosition,fluxoConteudo);
            //Defini a posição vertical e horizonta da próxima informação, com base na posição da informação anterior
            xPosition -= 30;
            yPosition -= 50;
            
            funcoesRelatorio.valoresTresTotalizadores("Total Entrada: ", "Total Saída:      ", "Saldo Atual:      ", totalEntrada,totalSaida,saldo,yPosition,fluxoConteudo);

            fluxoConteudo.close();
            this.funcoesRelatorio.salvarRelatorioPDF("ExtratoCaixa(Igreja)",documentoPDF);        
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o relatório, layout por igreja", "Atenção", JOptionPane.WARNING_MESSAGE);
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
    
    private void carregarIgreja(){
        List<Igreja> listaIgrejas = this.igrejaDao.consultarTodasIgrejas(this.filtroIgreja);
        DefaultComboBoxModel igreja = (DefaultComboBoxModel)this.igreja.getModel();
        igreja.removeAllElements();
        for(Igreja igre : listaIgrejas){
            igreja.addElement(igre);
        }
    }
    
    private void carregarContaCaixa(){
        List<ContaCaixa> listaContaCaixa = this.contaCaixaDao.consultarContaCaixa(this.filtroIgreja);
        DefaultComboBoxModel contaCaixa = (DefaultComboBoxModel)this.contaCaixa.getModel();
        contaCaixa.removeAllElements();
        for(ContaCaixa cx : listaContaCaixa){
            contaCaixa.addElement(cx);
        }
    }
    
    private void formInicial(){
        this.igreja.setSelectedItem("");
        this.rbEntradaSaida.setSelected(true);
        this.rbPadrao.setSelected(true);
        this.dataInicial.setText(this.conversor.dataAtualString());
        this.dataFinal.setText(this.conversor.dataAtualString());
        carregarContaCaixa();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.JComboBox<String> contaCaixa;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton rbDataMovimento;
    private javax.swing.JRadioButton rbEntrada;
    private javax.swing.JRadioButton rbEntradaSaida;
    private javax.swing.ButtonGroup rbGrupoLayout;
    private javax.swing.ButtonGroup rbGrupoTipoMovimento;
    private javax.swing.JRadioButton rbIgreja;
    private javax.swing.JRadioButton rbPadrao;
    private javax.swing.JRadioButton rbSaida;
    private javax.swing.JLabel txData;
    // End of variables declaration//GEN-END:variables
}
