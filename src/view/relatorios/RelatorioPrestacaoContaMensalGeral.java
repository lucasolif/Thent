
package view.relatorios;

import Ferramentas.Relatorios;
import Ferramentas.Utilitarios;
import dao.AplicacaoDao;
import dao.ContaCaixaDao;
import dao.IgrejaDao;
import dao.MovimentoCaixaDao;
import dao.RegistroOfertaDao;
import dao.TransferenciaDepositoDao;
import dao.UsuarioDao;
import interfaces.ConsultaContaCaixa;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.ContaCaixa;
import model.Igreja;
import model.MovimentoCaixa;
import model.RegistroDizimoOferta;
import model.Usuario;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import view.carregamentoConsultas.TelaConsultaContaCaixa;
import view.carregamentoConsultas.TelaConsultaIgreja;


public class RelatorioPrestacaoContaMensalGeral extends javax.swing.JInternalFrame implements ConsultaContaCaixa {

        //Estanciamento de classes que serão utilizadas
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final AplicacaoDao aplicacaoDao = new AplicacaoDao();
    private final RegistroOfertaDao rgOfertaDao = new RegistroOfertaDao();
    private final TransferenciaDepositoDao transfDepositoDao = new TransferenciaDepositoDao();
    private final ContaCaixaDao contaCaixaDao = new ContaCaixaDao();
    private final Utilitarios conversor = new Utilitarios();
    private final MovimentoCaixaDao mvCaixaDao = new MovimentoCaixaDao();
    private final Relatorios funcoesRelatorio = new Relatorios();
    private final UsuarioDao usuarioDao = new UsuarioDao();
    private List<ContaCaixa> listaContaCaixa = null;
    private Usuario usuarioLogado;
    private String filtroIgreja = "";

    public RelatorioPrestacaoContaMensalGeral() {
        initComponents();
        this.usuarioLogado = usuarioLogado;
        this.filtroIgreja = usuarioDao.gerarFiltroIgreja(usuarioLogado);
        formaInicial();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGerar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        anoPrestacao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mesPrestacao = new javax.swing.JComboBox<>();
        igreja = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listagemContaCaixa = new javax.swing.JList<>();
        codContaCaixa = new javax.swing.JTextField();
        nomeContaCaixa = new javax.swing.JTextField();

        setClosable(true);
        setResizable(true);
        setTitle("Prestação Contas Mensal (Geral)");

        btnGerar.setBackground(new java.awt.Color(0, 153, 255));
        btnGerar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGerar.setText("Gerar");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        jLabel3.setText("Ano");

        jLabel2.setText("Mês");

        mesPrestacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        igreja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                igrejaMousePressed(evt);
            }
        });

        jLabel1.setText("Igreja");

        jLabel4.setText("Contas Caixa");

        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adicionar.png"))); // NOI18N
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lixeira-16.png"))); // NOI18N
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listagemContaCaixa);

        codContaCaixa.setEditable(false);
        codContaCaixa.setBackground(new java.awt.Color(204, 204, 204));
        codContaCaixa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        nomeContaCaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeContaCaixaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(codContaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeContaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnGerar)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(mesPrestacao, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnExcluir))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(anoPrestacao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mesPrestacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anoPrestacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codContaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeContaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdicionar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGerar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        gerarRelatorio();
    }//GEN-LAST:event_btnGerarActionPerformed

    private void igrejaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_igrejaMousePressed
        carregarIgreja();
    }//GEN-LAST:event_igrejaMousePressed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        listarFiltrosContaCaixa();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirContaCaixaFiltro();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void nomeContaCaixaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeContaCaixaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarContaCaixa();
            carregarResultadoConsultaContaCaixa();
        }else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.nomeContaCaixa.setText("");
            this.codContaCaixa.setText("");
        }
    }//GEN-LAST:event_nomeContaCaixaKeyPressed

    private void carregarIgreja(){
        List<Igreja> listaIgrejas = this.igrejaDao.consultarTodasIgrejas(this.filtroIgreja);
        DefaultComboBoxModel igreja = (DefaultComboBoxModel)this.igreja.getModel();
        igreja.removeAllElements();
        for(Igreja igre : listaIgrejas){
            igreja.addElement(igre);
        }
    }
    
    private void consultarContaCaixa(){        
        String textoBusca = this.nomeContaCaixa.getText(); // Texto digitado na busca       
        this.listaContaCaixa = this.contaCaixaDao.consultarTodasContaCaixa(textoBusca); //Lista recebe a busca retornada do banco
    }
    
    private void carregarResultadoConsultaContaCaixa(){
        TelaConsultaContaCaixa resultConsultaContaCaixa = new TelaConsultaContaCaixa((Frame) SwingUtilities.getWindowAncestor(this), this.listaContaCaixa);
        resultConsultaContaCaixa.setContaCaixaSelecionada(this);
        resultConsultaContaCaixa.setLocationRelativeTo(this);
        resultConsultaContaCaixa.setVisible(true);
    }
    
    private void carregarContaCaixaEscolhida(ContaCaixa contaCaixa){
        this.codContaCaixa.setText(String.valueOf(contaCaixa.getCodigo()));
        this.nomeContaCaixa.setText(contaCaixa.getNome());    
    }
    
    private void excluirContaCaixaFiltro(){
        
        // Verifica se algum item foi selecionado
        int indiceSelecionado = listagemContaCaixa.getSelectedIndex(); // Obtém o índice do item selecionado

        if (indiceSelecionado >= 0) { // Se um item foi selecionado
            // Remove o item do DefaultListModel
            DefaultListModel<String> modelo = (DefaultListModel<String>) listagemContaCaixa.getModel();
            modelo.remove(indiceSelecionado); // Remove o item na posição do índice selecionado
        } else {
            // Caso não haja nenhum item selecionado
            JOptionPane.showMessageDialog(null, "Selecione uma conta para ser removida do filtro", "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void listarFiltrosContaCaixa(){
        
        if (!this.codContaCaixa.getText().isEmpty()) {
            // Verifica se o modelo já está definido no JList, se não, cria um novo.
            DefaultListModel<String> filtroContaCaixa = (DefaultListModel<String>) this.listagemContaCaixa.getModel();

            // Se o modelo for null (caso inicial), cria um novo modelo
            if (filtroContaCaixa == null) {
                filtroContaCaixa = new DefaultListModel<>();
                this.listagemContaCaixa.setModel(filtroContaCaixa);  // Atribui o modelo ao JList
            }

            // Adiciona a igreja no modelo
            String codIgreja = this.codContaCaixa.getText();
            String nomeIgreja = this.nomeContaCaixa.getText();
            String igreja = codIgreja + "-" + nomeIgreja; 
            filtroContaCaixa.addElement(igreja);  // Adiciona ao modelo do JList

            // Limpa os campos de texto
            this.codContaCaixa.setText("");
            this.nomeContaCaixa.setText("");
        }else {
            JOptionPane.showMessageDialog(null, "Informe a conta caixa que será adicionada no filtro", "Erro", JOptionPane.WARNING_MESSAGE);
        }

    }
    
    private List<RegistroDizimoOferta> consultarEntradas(){
        
        //Variaveis que serão utiizadas em todas as consultas. Elas não serão alteradas futuramente.
        final String nomeMes = (String) this.mesPrestacao.getSelectedItem();
        final Integer ano = Integer.valueOf(this.anoPrestacao.getText());
        final Integer numMes = conversor.obterNumMes(nomeMes);  

        Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        List<RegistroDizimoOferta> listaRgDizimoOferta = rgOfertaDao.consultaRelatorioPrestacaoContaMensalIgrejaLocal(igreja, numMes, ano);
    
        return listaRgDizimoOferta;
    }
    
    private List<MovimentoCaixa> consultarSaidas(){
        
        //Variaveis que serão utiizadas em todas as consultas. Elas não serão alteradas futuramente.
        final String nomeMes = (String) this.mesPrestacao.getSelectedItem();
        final Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        final Integer ano = Integer.valueOf(this.anoPrestacao.getText());
        final Integer numMes = conversor.obterNumMes(nomeMes);  

        List<MovimentoCaixa> listaMvCaixa = mvCaixaDao.consultarMovimentacaoContasPagar(numMes, ano, igreja);
        return listaMvCaixa;
    }

    private double consultarSaldoAnterior(){   
        
        //Variaveis que serão utiizadas em todas as consultas. Elas não serão alteradas futuramente.
        final String nomeMes = (String) this.mesPrestacao.getSelectedItem();
        final Integer ano = Integer.valueOf(this.anoPrestacao.getText());
        final Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        final Integer numMes = conversor.obterNumMes(nomeMes);  
        
        double saldoAnterior = mvCaixaDao.consultarSaldoMesInformado(numMes, ano, igreja); 
        return saldoAnterior;
        
    }
       
    private List<MovimentoCaixa> consultarDepositoTesourariaGeral(){
  
        //Variaveis que serão utiizadas em todas as consultas. Elas não serão alteradas futuramente.
        final String nomeMes = (String) this.mesPrestacao.getSelectedItem();
        final Integer ano = Integer.valueOf(this.anoPrestacao.getText());
        final Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        final Integer numMes = conversor.obterNumMes(nomeMes);  
        
        List<MovimentoCaixa> listaMvCaixa = transfDepositoDao.consultarDepositoTerourariaGeral(numMes, ano, igreja);       
        return listaMvCaixa;
       
    }
    
    private double consultarRendimentoAplicacao(){
        final Igreja igreja = (Igreja) this.igreja.getSelectedItem();   
        double rendimento = this.aplicacaoDao.consultarRendimentoAplicacao(igreja);
        
        return rendimento;
    }
    
    private void formaInicial(){
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
        final double rendimentoAplicacao = consultarRendimentoAplicacao();
        
        //Definição das variáveis
        String mesRelatorio = (String) this.mesPrestacao.getSelectedItem();
        String anoRelatorio = String.valueOf(this.anoPrestacao.getText());
        final String titulo = "Prestação de Conta Referente ao mês de "+ mesRelatorio+" de "+ anoRelatorio;
        final String[] titulosTabela = {"Descrição", "Valores"};
        
        //Variaveis referente aos totalizados
        double saidas = 0;
        double entradas = 0;
        
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
                String valores = this.conversor.formatarDoubleString(entrada.getValorOfertaEntrada()).replace(".", ",");

                fluxoConteudo.beginText();
                fluxoConteudo.setFont(times, tamanhaFonte);

                fluxoConteudo.newLineAtOffset(xPosition, yPosition);
                fluxoConteudo.showText(descricao);
                xPosition += 310; // Ajusta a posição da próxima coluna
                
                fluxoConteudo.newLineAtOffset(xPosition, 0);
                fluxoConteudo.showText("R$ "+valores);

                fluxoConteudo.endText();         
                yPosition -= 20;// Descer para a próxima linha 
                
                entradas += entrada.getValorOfertaEntrada();

            }
            yPosition -= 10;
            xPosition += 40;
            this.funcoesRelatorio.valoresUmTotalizador("Total: ", entradas, yPosition, xPosition, fluxoConteudo);            
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
            
            this.funcoesRelatorio.valoresUmTotalizador("Total: ", saidas, yPosition, xPosition, fluxoConteudo); 
                 
            double totalEntradas = entradas;
            double totalSaidas = saidas;
            double saldoAnterior = saldoCaixaAnterior;
            double saldoAtual = totalEntradas - totalSaidas;
            double valorRendimento = rendimentoAplicacao;
            
            yPosition -= 50;
            xPosition -= 40;
            
            //Pega os dados referente aos últimos totalizadores
            this.funcoesRelatorio.valoresCincoTotalizadores("Total Entrada:    ", "Total Saída:         ", "Saldo Anterior:   ", "Saldo Atual:         ", "Valor Aplicação: ", totalEntradas, totalSaidas, saldoAnterior, saldoAtual, valorRendimento, yPosition, xPosition, fluxoConteudo);
            
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
    
    @Override
    public void contaCaixaSelecionada(ContaCaixa contaCaixaSelecionada) {
        carregarContaCaixaEscolhida(contaCaixaSelecionada);    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anoPrestacao;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGerar;
    private javax.swing.JTextField codContaCaixa;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listagemContaCaixa;
    private javax.swing.JComboBox<String> mesPrestacao;
    private javax.swing.JTextField nomeContaCaixa;
    // End of variables declaration//GEN-END:variables
}
