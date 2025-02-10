
package view.relatorios;

import Services.Relatorios;
import Services.Utilitarios;
import dao.ContaCaixaDao;
import dao.IgrejaDao;
import dao.MovimentoCaixaDao;
import dao.RegistroOfertaDao;
import dao.TransferenciaDepositoDao;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.ContaCaixa;
import model.Igreja;
import model.MovimentoCaixa;
import model.RegistroDizimoOferta;
import model.UsuarioLogado;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class RelatorioPrestacaoContaMensal extends javax.swing.JInternalFrame {
    
    //Estanciamento de classes que serão utilizadas
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final RegistroOfertaDao rgOfertaDao = new RegistroOfertaDao();
    private final TransferenciaDepositoDao transfDepositoDao = new TransferenciaDepositoDao();
    private final ContaCaixaDao contaCaixaDao = new ContaCaixaDao();
    private final Utilitarios conversor = new Utilitarios();
    private final MovimentoCaixaDao mvCaixaDao = new MovimentoCaixaDao();
    private final Relatorios funcoesRelatorio = new Relatorios();
    
    public RelatorioPrestacaoContaMensal(UsuarioLogado usuarioLogado) {
        initComponents();
        formaInicial();
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        igreja = new javax.swing.JComboBox<>();
        mesPrestacao = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        anoPrestacao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnGerar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        contaCaixa = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Prestação de Contas Mensal");

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

        mesPrestacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        jLabel2.setText("Mês");

        jLabel3.setText("Ano");

        btnGerar.setBackground(new java.awt.Color(0, 153, 255));
        btnGerar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGerar.setText("Gerar");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        jLabel4.setText("Conta Caixa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGerar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(mesPrestacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(anoPrestacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(contaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mesPrestacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anoPrestacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(contaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGerar))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void igrejaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_igrejaMousePressed
        carregarIgreja();
    }//GEN-LAST:event_igrejaMousePressed

    private void igrejaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_igrejaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            DefaultComboBoxModel igreja = (DefaultComboBoxModel)this.igreja.getModel();
            igreja.removeAllElements();
        }
    }//GEN-LAST:event_igrejaKeyPressed

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        gerarRelatorio();
    }//GEN-LAST:event_btnGerarActionPerformed
 
    private void carregarIgreja(){
        List<Igreja> listaIgrejas = this.igrejaDao.consultarTodasIgrejas();
        DefaultComboBoxModel igreja = (DefaultComboBoxModel)this.igreja.getModel();
        igreja.removeAllElements();
        for(Igreja igre : listaIgrejas){
            igreja.addElement(igre);
        }
    }
    
    private void carregarContaCaixa(){
        List<ContaCaixa> listaContaCaixa = this.contaCaixaDao.consultarContaCaixa();
        DefaultComboBoxModel contaCaixa = (DefaultComboBoxModel)this.contaCaixa.getModel();
        contaCaixa.removeAllElements();
        for(ContaCaixa cx : listaContaCaixa){
            contaCaixa.addElement(cx);
        }
    }
    
    private List<RegistroDizimoOferta> consultarEntradas(){
        
        //Variaveis que serão utiizadas em todas as consultas. Elas não serão alteradas futuramente.
        final String nomeMes = (String) this.mesPrestacao.getSelectedItem();
        final Integer ano = Integer.valueOf(this.anoPrestacao.getText());
        final ContaCaixa contaCaixaSelec = (ContaCaixa) this.contaCaixa.getSelectedItem();
        final Integer numMes = conversor.obterNumMes(nomeMes);  

        Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        List<RegistroDizimoOferta> listaRgDizimoOferta = rgOfertaDao.consultaRelatorioPrestacaoContaMensal(igreja, numMes, ano);
    
        return listaRgDizimoOferta;
    }
    
    private List<MovimentoCaixa> consultarSaidas(){
        
        //Variaveis que serão utiizadas em todas as consultas. Elas não serão alteradas futuramente.
        final String nomeMes = (String) this.mesPrestacao.getSelectedItem();
        final Integer ano = Integer.valueOf(this.anoPrestacao.getText());
        final ContaCaixa contaCaixaSelec = (ContaCaixa) this.contaCaixa.getSelectedItem();
        final Integer numMes = conversor.obterNumMes(nomeMes);  

        List<MovimentoCaixa> listaMvCaixa = mvCaixaDao.consultarMovimentacaoContasPagar(numMes, ano, contaCaixaSelec);
        return listaMvCaixa;
    }

    private double consultarSaldoAnterior(){   
        
        //Variaveis que serão utiizadas em todas as consultas. Elas não serão alteradas futuramente.
        final String nomeMes = (String) this.mesPrestacao.getSelectedItem();
        final Integer ano = Integer.valueOf(this.anoPrestacao.getText());
        final ContaCaixa contaCaixaSelec = (ContaCaixa) this.contaCaixa.getSelectedItem();
        final Integer numMes = conversor.obterNumMes(nomeMes);  
        
        double saldoAnterior = mvCaixaDao.consultarSaldoMesInformado(numMes, ano, contaCaixaSelec); 
        return saldoAnterior;
        
    }
    
    private List<MovimentoCaixa> consultarDepositoTesourariaGeral(){
  
        //Variaveis que serão utiizadas em todas as consultas. Elas não serão alteradas futuramente.
        final String nomeMes = (String) this.mesPrestacao.getSelectedItem();
        final Integer ano = Integer.valueOf(this.anoPrestacao.getText());
        final ContaCaixa contaCaixaSelec = (ContaCaixa) this.contaCaixa.getSelectedItem();
        final Integer numMes = conversor.obterNumMes(nomeMes);  
        
        List<MovimentoCaixa> listaMvCaixa = transfDepositoDao.consultarDepositoTerourariaGeral(numMes, ano, contaCaixaSelec);       
        return listaMvCaixa;
       
    }
    
    private void formaInicial(){
        carregarContaCaixa();
        carregarIgreja();
        this.anoPrestacao.setText(conversor.anoAtual());
        this.mesPrestacao.setSelectedItem(conversor.mesAnterior());
    }
    
    private void gerarRelatorio(){
        
        //Buscando os dados que serão usados, no banco de dados.
        final List<RegistroDizimoOferta> listaEntrada = consultarEntradas();
        final List<MovimentoCaixa> listaSaidas = consultarSaidas();
        final double saldoCaixaAnterior = consultarSaldoAnterior();
        final List<MovimentoCaixa> listaDpTesouraria = consultarDepositoTesourariaGeral();
        
        //Definição das variáveis
        String mesRelatorio = (String) this.mesPrestacao.getSelectedItem();
        String anoRelatorio = String.valueOf(this.anoPrestacao.getText());
        final String titulo = "Prestação de Conta Referente ao mês de "+ mesRelatorio+" de "+ anoRelatorio;
        final String[] titulosTabela = {"Descrição", "Valores"};
        
        //Variaveis referente aos totalizados
        double saldoAnterior = 0;
        double saldoAtual = 0;
        double saidas = 0;
        double entradas = 0;
        double totalEntradas = 0;
        double totalSaidas = 0;
        
        //Variáveis referente ao layout do relatório
        float yPosition = 700; // Posição vertical inicial para os títulos
        float xPosition = 80; // Posição horizontal inicial para os títulos
        final float tamanhaFonte = 12;
        final float tamanhoFonteTitulo = 18;
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
            this.funcoesRelatorio.tituloRelatorio(tamanhoFonteTitulo,titulo, fluxoConteudo, paginaPDF); 

            //Gerando o titulo do layout
            this.funcoesRelatorio.tituloLayoutCentralizado("ENTRADAS",yPosition, fluxoConteudo, paginaPDF);   
            yPosition -= 20; // Pular para a linha abaixo após o título       
            //Gerar os títulos das colunas
            this.funcoesRelatorio.tituloColunaRelatorioPrestacaoContaMensal(yPosition, xPosition, titulosTabela, fluxoConteudo);           
            yPosition -= 20; // Pular para a linha abaixo após o título              
            //Pega o total das ofertas (Entradas)
            for(RegistroDizimoOferta entrada : listaEntrada) {                
                if (yPosition < 50) { // Se a posição Y estiver abaixo do limite da página, criar uma nova página
                    fluxoConteudo.close(); //Encerra o fluxo de conteudo
                    PDPage novaPagina = new PDPage(PDRectangle.A4); // Tamanho da página
                    documentoPDF.addPage(novaPagina);
                    fluxoConteudo = new PDPageContentStream(documentoPDF, novaPagina);
                    yPosition = 750; // Resetar a posição Y para o topo da nova página
                }        

                xPosition = 80; // Resetar a posição horizontal a cada nova linha

                // Obter os dados da lista        
                String descricao = entrada.getTpOferta().getNome();
                String valores = this.conversor.formatarDoubleString(entrada.getValorOferta()).replace(".", ",");

                fluxoConteudo.beginText();
                fluxoConteudo.setFont(times, tamanhaFonte);

                fluxoConteudo.newLineAtOffset(xPosition, yPosition);
                fluxoConteudo.showText(descricao);
                xPosition += 310; // Ajusta a posição da próxima coluna
                
                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText("R$ "+valores);

                fluxoConteudo.endText();         
                yPosition -= 20;// Descer para a próxima linha 
                
                entradas += entrada.getValorOferta();

            }
            yPosition -= 10;
            xPosition += 40;
            this.funcoesRelatorio.umTotalizador("Total: ", entradas, yPosition, xPosition, fluxoConteudo);            
            yPosition -= 40; // Pular para a linha abaixo
            xPosition = 80; //Resetando o posicionamento vertical
            
            //Gerando o titulo do layout
            this.funcoesRelatorio.tituloLayoutCentralizado("SAÌDAS", yPosition, fluxoConteudo, paginaPDF);   
            yPosition -= 20; // Pular para a linha abaixo       
            //Gerar os títulos das colunas
            this.funcoesRelatorio.tituloColunaRelatorioPrestacaoContaMensal(yPosition, xPosition, titulosTabela, fluxoConteudo);           
            yPosition -= 20; // Pular para a linha abaixo           
            //Pega o total das Saídas
            for(MovimentoCaixa saida : listaSaidas) {                
                if (yPosition < 50) { // Se a posição Y estiver abaixo do limite da página, criar uma nova página
                    fluxoConteudo.close(); //Encerra o fluxo de conteudo
                    PDPage novaPagina = new PDPage(PDRectangle.A4); // Tamanho da página
                    documentoPDF.addPage(novaPagina);
                    fluxoConteudo = new PDPageContentStream(documentoPDF, novaPagina);
                    yPosition = 750; // Resetar a posição Y para o topo da nova página
                }        

                xPosition = 80; // Resetar a posição horizontal a cada nova linha

                // Obter os dados da lista        
                String descricao = saida.getContaPagar().getDescricaoConta();
                String valores = this.conversor.formatarDoubleString(saida.getValorSaida()).replace(".", ",");

                fluxoConteudo.beginText();
                fluxoConteudo.setFont(times, tamanhaFonte);

                fluxoConteudo.newLineAtOffset(xPosition, yPosition);
                fluxoConteudo.showText(descricao);
                xPosition += 310; // Ajusta a posição da próxima coluna
                
                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText("R$ "+valores);

                fluxoConteudo.endText();         
                yPosition -= 20;// Descer para a próxima linha 
                
                saidas += saida.getValorSaida();

            }

            //Pega os depositos efetuado para a tesouraria geral
            for(MovimentoCaixa dpTesouraria : listaDpTesouraria) {                
                if (yPosition < 50) { // Se a posição Y estiver abaixo do limite da página, criar uma nova página
                    fluxoConteudo.close(); //Encerra o fluxo de conteudo
                    PDPage novaPagina = new PDPage(PDRectangle.A4); // Tamanho da página
                    documentoPDF.addPage(novaPagina);
                    fluxoConteudo = new PDPageContentStream(documentoPDF, novaPagina);
                    yPosition = 750; // Resetar a posição Y para o topo da nova página
                }        

                xPosition = 80; // Resetar a posição horizontal a cada nova linha

                // Obter os dados da lista        
                String descricao = dpTesouraria.getComplemento();
                String valores = this.conversor.formatarDoubleString(dpTesouraria.getValorSaida()).replace(".", ",");

                fluxoConteudo.beginText();
                fluxoConteudo.setFont(times, tamanhaFonte);

                fluxoConteudo.newLineAtOffset(xPosition, yPosition);
                fluxoConteudo.showText(descricao);
                xPosition += 310; // Ajusta a posição da próxima coluna
                
                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText("R$ "+valores);

                fluxoConteudo.endText();         
                yPosition -= 20;// Descer para a próxima linha 
                
                saidas += dpTesouraria.getValorSaida();

            }
            yPosition -= 10;
            xPosition += 40;
            this.funcoesRelatorio.umTotalizador("Total: ", entradas, yPosition, xPosition, fluxoConteudo); 
                 
            fluxoConteudo.close();
            
            //Chama a função apra salvar o relatório
            this.funcoesRelatorio.salvarRelatorioPDF("Prestação De Contas",documentoPDF);
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
    private javax.swing.JTextField anoPrestacao;
    private javax.swing.JButton btnGerar;
    private javax.swing.JComboBox<String> contaCaixa;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> mesPrestacao;
    // End of variables declaration//GEN-END:variables
}
