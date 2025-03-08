
package view.relatorios;

import ferramentas.UtilitariosRelatorios;
import ferramentas.Utilitarios;
import dao.AplicacaoDao;
import dao.ContaCaixaDao;
import dao.IgrejaDao;
import dao.MovimentoCaixaDao;
import dao.RegistroOfertaDao;
import dao.TransferenciaDepositoDao;
import dao.UsuarioDao;
import interfaces.ConsultaContaCaixa;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
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

public class RelatorioPrestacaoContaMensalLocal extends javax.swing.JInternalFrame implements ConsultaContaCaixa {
    
    //Estanciamento de classes que serão utilizadas
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final AplicacaoDao aplicacaoDao = new AplicacaoDao();
    private final RegistroOfertaDao rgOfertaDao = new RegistroOfertaDao();
    private final TransferenciaDepositoDao transfDepositoDao = new TransferenciaDepositoDao();
    private final ContaCaixaDao contaCaixaDao = new ContaCaixaDao();
    private final Utilitarios conversor = new Utilitarios();
    private final MovimentoCaixaDao mvCaixaDao = new MovimentoCaixaDao();
    private final UtilitariosRelatorios funcoesRelatorio = new UtilitariosRelatorios();
    private final UsuarioDao usuarioDao = new UsuarioDao();
    private List<ContaCaixa> listaContaCaixa = null;
    private Usuario usuarioLogado;
    private String filtroIgreja = "";
    
    public RelatorioPrestacaoContaMensalLocal(Usuario usuarioLogado) {
        initComponents();
        this.usuarioLogado = usuarioLogado;
        this.filtroIgreja = usuarioDao.gerarFiltroIgreja(usuarioLogado);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        listagemContaCaixa = new javax.swing.JList<>();
        codContaCaixa = new javax.swing.JTextField();
        nomeContaCaixa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

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

        jScrollPane2.setViewportView(listagemContaCaixa);

        codContaCaixa.setEditable(false);
        codContaCaixa.setBackground(new java.awt.Color(204, 204, 204));
        codContaCaixa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        nomeContaCaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeContaCaixaKeyPressed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGerar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(mesPrestacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(anoPrestacao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codContaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeContaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdicionar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anoPrestacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mesPrestacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGerar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void igrejaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_igrejaMousePressed
        carregarIgreja();
    }//GEN-LAST:event_igrejaMousePressed

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        gerarRelatorio();
    }//GEN-LAST:event_btnGerarActionPerformed

    private void nomeContaCaixaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeContaCaixaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarContaCaixa();
            carregarResultadoConsultaContaCaixa();
        }else if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.nomeContaCaixa.setText("");
            this.codContaCaixa.setText("");
        }
    }//GEN-LAST:event_nomeContaCaixaKeyPressed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        adicionarFiltrosContaCaixa();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirContaCaixaFiltro();
    }//GEN-LAST:event_btnExcluirActionPerformed
 
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
        this.listaContaCaixa = this.contaCaixaDao.consultarCx(textoBusca,this.filtroIgreja); //Lista recebe a busca retornada do banco
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
    
    private void adicionarFiltrosContaCaixa(){
        
        if(!verificarFiltroCaixaAdicionado(this.codContaCaixa.getText())){
            if (!this.codContaCaixa.getText().isEmpty()) {
                // Verifica se o modelo já é do tipo DefaultListModel
                DefaultListModel<String> filtroContaCaixa;

                // Verifica se o modelo é uma instância de DefaultListModel
                if (this.listagemContaCaixa.getModel() instanceof DefaultListModel) {
                    filtroContaCaixa = (DefaultListModel<String>) this.listagemContaCaixa.getModel();
                } else {
                    // Se o modelo não for um DefaultListModel ou for null, cria um novo modelo
                    filtroContaCaixa = new DefaultListModel<>();
                    this.listagemContaCaixa.setModel(filtroContaCaixa);  // Atribui o novo modelo ao JList
                }

                // Adiciona a conta no modelo
                String codConta = this.codContaCaixa.getText();
                String nomeConta = this.nomeContaCaixa.getText();
                String conta = codConta + "-" + nomeConta;
                filtroContaCaixa.addElement(conta);  // Adiciona ao modelo do JList

                // Limpa os campos de texto
                this.codContaCaixa.setText("");
                this.nomeContaCaixa.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Informe a conta caixa que será adicionada no filtro", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Essa conta caixa já foi adicionada na listagem de filtro", "Erro", JOptionPane.WARNING_MESSAGE);
        }
   
    }
    
    private String obterFiltroCaixa(){
        ListModel<String> modelo = listagemContaCaixa.getModel();// Acesse o modelo do JList
        
        int cont = 0;
        int tamanhoListagem = modelo.getSize();
        int ultimo = tamanhoListagem - 1;
        String filtroContaCaixa = "";
        
        for (int i = 0; i < modelo.getSize(); i++) {       
            
            //Pegando o código da igreja que está em uma string junto com o nome da igreja
            String contaCaixaSelec = modelo.getElementAt(i);
            int posicaoCod = contaCaixaSelec.indexOf("-"); //Pega a posição do traço, pois ele divide o código da igreja e nome       
            String codContaCaixa = contaCaixaSelec.substring(0,posicaoCod);                        
 
            if(tamanhoListagem == 1){
                filtroContaCaixa = codContaCaixa;
            }else{
                if(tamanhoListagem > 1 && cont == ultimo){
                   filtroContaCaixa += codContaCaixa;
                }else{
                   filtroContaCaixa += codContaCaixa+","; 
                }
            }
            cont ++;  
            
        }
        
        return filtroContaCaixa;
        
    }
    
    private boolean verificarFiltroCaixaAdicionado(String codigo){
        ListModel<String> modelo = listagemContaCaixa.getModel();// Acesse o modelo do JList
        boolean existe = false;  
        
        for (int i = 0; i < modelo.getSize(); i++) {       
            
            //Pegando o código da igreja que está em uma string junto com o nome da igreja
            String contaCaixaSelec = modelo.getElementAt(i);
            int posicaoCod = contaCaixaSelec.indexOf("-"); //Pega a posição do traço, pois ele divide o código da igreja e nome       
            String codContaCaixa = contaCaixaSelec.substring(0,posicaoCod); 
            
            if(codigo.equalsIgnoreCase(codContaCaixa)){
                existe = true;
            }
        }
        
        return existe;
        
    }
    
    private List<RegistroDizimoOferta> consultarEntradas(){
        
        //Variaveis que serão utiizadas em todas as consultas. Elas não serão alteradas futuramente.
        final String nomeMes = (String) this.mesPrestacao.getSelectedItem();
        final Integer ano = Integer.valueOf(this.anoPrestacao.getText());
        final Integer numMes = conversor.obterNumMes(nomeMes);  
        final String filtroContaCaixa = obterFiltroCaixa();

        Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        List<RegistroDizimoOferta> listaRgDizimoOferta = rgOfertaDao.consultaEntradaDizimoOfertaRelatorio(igreja, numMes, ano, filtroContaCaixa);
    
        return listaRgDizimoOferta;
    }
    
    private List<MovimentoCaixa> consultarSaidas(){
        
        //Variaveis que serão utiizadas em todas as consultas. Elas não serão alteradas futuramente.
        final String nomeMes = (String) this.mesPrestacao.getSelectedItem();
        final Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        final Integer ano = Integer.valueOf(this.anoPrestacao.getText());
        final Integer numMes = conversor.obterNumMes(nomeMes);  
        final String filtroContaCaixa = obterFiltroCaixa();

        List<MovimentoCaixa> listaMvCaixa = mvCaixaDao.consultarMovimentacaoContasPagarIgrejaLocal(numMes, ano, igreja, filtroContaCaixa);
        return listaMvCaixa;
    }

    private double consultarSaldoAnterior(){   
        
        //Variaveis que serão utiizadas em todas as consultas. Elas não serão alteradas futuramente.
        final String nomeMes = (String) this.mesPrestacao.getSelectedItem();
        final Integer ano = Integer.valueOf(this.anoPrestacao.getText());
        final Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        final Integer numMes = conversor.obterNumMes(nomeMes);
        final String filtroContaCaixa = obterFiltroCaixa();
        
        double saldoAnterior = mvCaixaDao.consultarSaldoAnteriorMesInformado(numMes, ano, igreja, filtroContaCaixa); 
        return saldoAnterior;
        
    }
    
    private double consultarSaldoAtual(){   
        
        //Variaveis que serão utiizadas em todas as consultas. Elas não serão alteradas futuramente.
        final String nomeMes = (String) this.mesPrestacao.getSelectedItem();
        final Integer ano = Integer.valueOf(this.anoPrestacao.getText());
        final Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        final Integer numMes = conversor.obterNumMes(nomeMes);  
        final String filtroContaCaixa = obterFiltroCaixa();
        
        double saldoAntual = mvCaixaDao.consultarSaldoAtualMesInformado(numMes, ano, igreja, filtroContaCaixa); 
        return saldoAntual;
        
    }
       
    private List<MovimentoCaixa> consultarDepositoTesourariaGeral(){
  
        //Variaveis que serão utiizadas em todas as consultas. Elas não serão alteradas futuramente.
        final String nomeMes = (String) this.mesPrestacao.getSelectedItem();
        final Integer ano = Integer.valueOf(this.anoPrestacao.getText());
        final Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        final Integer numMes = conversor.obterNumMes(nomeMes);  
        final String filtroContaCaixa = obterFiltroCaixa();
        
        List<MovimentoCaixa> listaMvCaixa = transfDepositoDao.consultarDepositoTerourariaGeral(numMes, ano, igreja, filtroContaCaixa);       
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
        final double saldoCaixaAtual = consultarSaldoAtual();
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
            this.funcoesRelatorio.primeiroTituloRelatorio(tamanhoFonteTitulo,titulo, fluxoConteudo, paginaPDF); 

            //Gerando o titulo do layout
            this.funcoesRelatorio.tituloLayoutCentralizado("ENTRADAS",yPosition, fluxoConteudo, paginaPDF);   
            yPosition -= 20; // Pular para a linha abaixo após o título       
            //Gerar os títulos das colunas
            this.funcoesRelatorio.tituloColunaRelatorioTesourariaLocal(yPosition, xPosition, titulosTabela, fluxoConteudo);           
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
            this.funcoesRelatorio.tituloColunaRelatorioTesourariaLocal(yPosition, xPosition, titulosTabela, fluxoConteudo);           
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
            double saldoAtual = saldoCaixaAtual;
            double valorRendimento = rendimentoAplicacao;
            
            yPosition -= 50;
            xPosition -= 40;
            
            //Pega os dados referente aos últimos totalizadores
            this.funcoesRelatorio.valoresCincoTotalizadoresRelatorioMensal("Total Entrada:    ", "Total Saída:         ", "Saldo Anterior:   ", "Saldo Atual:         ", "Valor Aplicação: ", totalEntradas, totalSaidas, saldoAnterior, saldoAtual, valorRendimento, yPosition, xPosition, fluxoConteudo);
            
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
