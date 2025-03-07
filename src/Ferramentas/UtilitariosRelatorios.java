
package Ferramentas;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;


public class UtilitariosRelatorios {
    
    private final Utilitarios conversor = new Utilitarios();
    
    //Função para gerar o título do relatório
    public void primeiroTituloRelatorio(float tmnFonte, String titulo, PDPageContentStream fluxoConteudo, PDPage paginaPDF){  
        
        float larguraPagina = paginaPDF.getMediaBox().getWidth(); // Largura da Pagina
        float alturaPagina = paginaPDF.getMediaBox().getHeight(); // Altura da Página
        float xPosition;
        float yPosition;
        float tamanhoFonteData = 11;
        final String dataRelatorio = conversor.dataAtualString();    
        final PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        
        try {                     
            //Data da emissão do relatório
            xPosition = larguraPagina - 150; // 100 pixels da borda direita
            yPosition = alturaPagina - 20; // 20 pixels da borda superior
            fluxoConteudo.beginText(); //Inicinado o texto
            fluxoConteudo.setFont(timesBold, tamanhoFonteData); //Fonte e tamanho
            fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posição do texto
            fluxoConteudo.showText("Data Emissão: "); //Texto
            fluxoConteudo.setFont(times, tamanhoFonteData); //Fonte e tamanho
            fluxoConteudo.showText(dataRelatorio); //Texto
            fluxoConteudo.endText(); //Finaliza o texto
            
            //Título relatório
            float larguraTitulo = timesBold.getStringWidth(titulo)/1000 * tmnFonte; // Ajuste o tamanho da fonte         
            xPosition = (larguraPagina - larguraTitulo) / 2;// Centraliza o texto
            yPosition = 760;
            fluxoConteudo.beginText(); //Iniciando a escrita
            fluxoConteudo.setFont(timesBold, tmnFonte); //Definindo a fonte
            fluxoConteudo.newLineAtOffset(xPosition, yPosition);  // Posição do texto
            fluxoConteudo.showText(titulo);
            fluxoConteudo.endText();                 

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar título", "Atenção", JOptionPane.WARNING_MESSAGE);
        } 
    }
    
        //Função para gerar o título do relatório
    public void segundoTituloRelatorio(float tmnFonte, String titulo, PDPageContentStream fluxoConteudo, PDPage paginaPDF){  
        
        float larguraPagina = paginaPDF.getMediaBox().getWidth(); // Largura da Pagina
        float alturaPagina = paginaPDF.getMediaBox().getHeight(); // Altura da Página
        float xPosition;
        float yPosition;
        float tamanhoFonteData = 11;
        final String dataRelatorio = conversor.dataAtualString();    
        final PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        
        try {                     
            //Data da emissão do relatório
            xPosition = larguraPagina - 150; // 100 pixels da borda direita
            yPosition = alturaPagina - 20; // 20 pixels da borda superior
            fluxoConteudo.beginText(); //Inicinado o texto
            fluxoConteudo.setFont(timesBold, tamanhoFonteData); //Fonte e tamanho
            fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posição do texto
            fluxoConteudo.showText("Data Emissão: "); //Texto
            fluxoConteudo.setFont(times, tamanhoFonteData); //Fonte e tamanho
            fluxoConteudo.showText(dataRelatorio); //Texto
            fluxoConteudo.endText(); //Finaliza o texto
            
            //Título relatório
            float larguraTitulo = timesBold.getStringWidth(titulo)/1000 * tmnFonte; // Ajuste o tamanho da fonte         
            xPosition = (larguraPagina - larguraTitulo) / 2;// Centraliza o texto
            yPosition = 740;
            fluxoConteudo.beginText(); //Iniciando a escrita
            fluxoConteudo.setFont(timesBold, tmnFonte); //Definindo a fonte
            fluxoConteudo.newLineAtOffset(xPosition, yPosition);  // Posição do texto
            fluxoConteudo.showText(titulo);
            fluxoConteudo.endText();                 

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar título", "Atenção", JOptionPane.WARNING_MESSAGE);
        } 
    }
    
    //Função para gerar o subtitulo do relatório
    public void subTituloRelatorio(String SubTitulo, PDPageContentStream fluxoConteudo, PDPage paginaPDF){  
        
        float larguraPagina = paginaPDF.getMediaBox().getWidth(); // Largura da Pagina
        float alturaPagina = paginaPDF.getMediaBox().getHeight(); // Altura da Página
        float xPosition;
        float yPosition;
        float tamanhoFonte = 11;
        final PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont hevelticaBold =  new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD); //Definindo a fonte
        final PDFont heveltica =  new PDType1Font(Standard14Fonts.FontName.HELVETICA); //Definindo a fonte
        
        try {                                 
            //Título relatório
            float larguraSubTitulo = timesBold.getStringWidth(SubTitulo)/1000 * tamanhoFonte; // Ajuste o tamanho da fonte         
            xPosition = (larguraPagina - larguraSubTitulo) / 2;// Centraliza o texto
            yPosition = 740;
            fluxoConteudo.beginText(); //Iniciando a escrita
            fluxoConteudo.setFont(timesBold, tamanhoFonte); //Definindo a fonte
            fluxoConteudo.newLineAtOffset(xPosition, yPosition);  // Posição do texto
            fluxoConteudo.showText(SubTitulo);
            fluxoConteudo.endText();                 

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o Sub Título", "Atenção", JOptionPane.WARNING_MESSAGE);
        } 
    }
    
    //Função para abrir a tela do local de salvamento do relatório
    public void salvarRelatorioPDF(String nome, PDDocument documentoPDF){

        // Configuração do conteúdo
        try {
            // Aqui é onde você pedirá ao usuário o local para salvar o PDF
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Salvar Relatório PDF");
            
            String dataAtual = this.conversor.dataAtualString().replace("/", "-");
            String nomeArquivo = nome+" "+dataAtual+".pdf";
            fileChooser.setSelectedFile(new File(nomeArquivo)); // Nome padrão do arquivo

            // Abre a caixa de diálogo para salvar
            int userSelection = fileChooser.showSaveDialog(null);

            // Se o usuário pressionar "Salvar"
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File arquivoParaSalvar = fileChooser.getSelectedFile();
                String caminhoArquivo = arquivoParaSalvar.getAbsolutePath();

                // Verifica se o arquivo não tem a extensão ".pdf" e adiciona, caso necessário
                if (!caminhoArquivo.toLowerCase().endsWith(".pdf")) {
                    caminhoArquivo += ".pdf";
                }
                
                // Verificar se o arquivo já existe
                File arquivoExistente = new File(caminhoArquivo);
                if (arquivoExistente.exists()) {
                    // Exibe uma mensagem perguntando se o usuário deseja substituir o arquivo
                    int resposta = JOptionPane.showConfirmDialog(null, "O arquivo já existe. Deseja substituir?", "Arquivo já existe", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (resposta == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "Arquivo não salvo Operação finalizada.", "Atenção", JOptionPane.WARNING_MESSAGE);
                    }else{
                        // Salvar o documento no local escolhido
                        documentoPDF.save(caminhoArquivo);
                        JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    // Salvar o documento no local escolhido
                    documentoPDF.save(caminhoArquivo);
                    JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Caminho não selecionado.", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o arquivo PDF", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    
    }
    
    public void tituloColunaRelatorioContasPagarReceber(int layout, float yPosition, float xPosition, String[] titulosTabela, PDPageContentStream fluxoConteudo){       
        PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        
        try{
            if(layout == 1 || layout == 3 ||layout == 4 || layout == 5 || layout == 6){
                // Definir os títulos das colunas na página
                for (int i = 0; i < titulosTabela.length; i++) {
                    if(i != 0){
                        switch (i) {
                            case 2 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 125; // Calcula a posição horizontal para cada título
                            case 5 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 25; // Calcula a posição horizontal para cada título
                            case 6 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 20; // Calcula a posição horizontal para cada título
                            default -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 13; // Calcula a posição horizontal para cada título
                        }
                    }
                    fluxoConteudo.beginText();
                    fluxoConteudo.setFont(timesBold, 11);
                    fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posição do título
                    fluxoConteudo.showText(titulosTabela[i]); // Texto do título
                    fluxoConteudo.endText();
                } 
            }else if(layout == 2){
                // Desenhar os títulos das colunas na página
                for (int i = 0; i < titulosTabela.length; i++) {
                    if(i != 0){
                        switch (i) {
                            case 3 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 125; // Calcula a posição horizontal para cada título
                            case 5 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 25; // Calcula a posição horizontal para cada título
                            case 6 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 20; // Calcula a posição horizontal para cada título
                            default -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 13; // Calcula a posição horizontal para cada título
                        }
                    }
                    fluxoConteudo.beginText();
                    fluxoConteudo.setFont(timesBold, 11);
                    fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posição do título
                    fluxoConteudo.showText(titulosTabela[i]); // Texto do título
                    fluxoConteudo.endText();
                }  
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar os títulos da coluna", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void tituloColunaRelatorioContaCaixa (int layout, float yPosition, float xPosition, String[] titulosTabela, PDPageContentStream fluxoConteudo){       
        PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        final float tamanhoFonte = 12;
        
        try{
            if(layout == 1){
                // Definir os títulos das colunas na página
                for (int i = 0; i < titulosTabela.length; i++) {
                    if(i != 0){
                        switch (i) {
                            case 1 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 35; // Calcula a posição horizontal para cada título
                            case 2 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 170; // Calcula a posição horizontal para cada título
                            case 4 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 30; // Calcula a posição horizontal para cada título
                            case 5 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 50; // Calcula a posição horizontal para cada título
                            default -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 13; // Calcula a posição horizontal para cada título
                        }
                    }
                    fluxoConteudo.beginText();
                    fluxoConteudo.setFont(timesBold, tamanhoFonte);
                    fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posição do título
                    fluxoConteudo.showText(titulosTabela[i]); // Texto do título
                    fluxoConteudo.endText();
                } 
            }else if(layout == 2){
                // Definir os títulos das colunas na página
                for (int i = 0; i < titulosTabela.length; i++) {
                    if(i != 0){
                        switch (i) {
                            case 1 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 200; // Calcula a posição horizontal para cada título
                            case 2 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 30; // Calcula a posição horizontal para cada título
                            case 3 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 30; // Calcula a posição horizontal para cada título                         
                            case 4 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 60; // Calcula a posição horizontal para cada título
                        }
                    }
                    fluxoConteudo.beginText();
                    fluxoConteudo.setFont(timesBold, tamanhoFonte);
                    fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posição do título
                    fluxoConteudo.showText(titulosTabela[i]); // Texto do título
                    fluxoConteudo.endText();
                } 
            }else if(layout == 3){
                // Definir os títulos das colunas na página
                for (int i = 0; i < titulosTabela.length; i++) {
                    if(i != 0){
                        switch (i) {
                            case 1 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 13; // Calcula a posição horizontal para cada título
                            case 2 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 35; // Calcula a posição horizontal para cada título
                            case 3 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 165; // Calcula a posição horizontal para cada título
                            case 4 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 20; // Calcula a posição horizontal para cada título
                            case 5 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 30; // Calcula a posição horizontal para cada título
                        }
                    }
                    fluxoConteudo.beginText();
                    fluxoConteudo.setFont(timesBold, tamanhoFonte);
                    fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posição do título
                    fluxoConteudo.showText(titulosTabela[i]); // Texto do título
                    fluxoConteudo.endText();
                } 
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar os títulos da coluna", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void tituloColunaRelatorioRgDizimoOferta (int layout, float yPosition, float xPosition, String[] titulosTabela, PDPageContentStream fluxoConteudo){       
        final PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        final float tamanhoFonte = 11;
        
        try{
            if(layout == 1 || layout == 2 || layout == 3){
                // Definir os títulos das colunas na página
                for (int i = 0; i < titulosTabela.length; i++) {
                    if(i != 0){
                        switch (i) {
                            case 1 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 70; // Calcula a posição horizontal para cada título
                            case 2 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 15; // Calcula a posição horizontal para cada título
                            case 3 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 15; // Calcula a posição horizontal para cada título
                            case 4 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 100; // Calcula a posição horizontal para cada título
                            case 5 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 25; // Calcula a posição horizontal para cada título
                            default -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 13; // Calcula a posição horizontal para cada título
                        }
                    }
                    fluxoConteudo.beginText();
                    fluxoConteudo.setFont(timesBold, tamanhoFonte);
                    fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posição do título
                    fluxoConteudo.showText(titulosTabela[i]); // Texto do título
                    fluxoConteudo.endText();
                } 
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar os títulos da coluna", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void tituloColunaRelatorioTesourariaLocal (float yPosition, float xPosition, String[] titulosTabela, PDPageContentStream fluxoConteudo){       
        PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
         
        try{
            // Definir os títulos das colunas na página
            for (int i = 0; i < titulosTabela.length; i++) {
                if(i != 0){
                    xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 340; // Calcula a posição horizontal para cada título
                }
                
                fluxoConteudo.beginText();
                fluxoConteudo.setFont(timesBold, 12);
                fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posição do título
                fluxoConteudo.showText(titulosTabela[i]); // Texto do título
                fluxoConteudo.endText();
            }
             
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar os títulos da coluna", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void tituloColunaRelatorioTesourariaGeral (float yPosition, float xPosition, String[] titulosTabela, int layout, PDPageContentStream fluxoConteudo){       
        PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        
        try{
            if(layout == 1){
                // Definir os títulos das colunas na página
                for (int i = 0; i < titulosTabela.length; i++) {
                    if(i != 0){
                        xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 377; // Calcula a posição horizontal para cada título
                    }

                    fluxoConteudo.beginText();
                    fluxoConteudo.setFont(timesBold, 12);
                    fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posição do título
                    fluxoConteudo.showText(titulosTabela[i]); // Texto do título
                    fluxoConteudo.endText();
                }
            }else if(layout == 2){
                for (int i = 0; i < titulosTabela.length; i++) {
                    if(i != 0){
                        switch (i) {
                            case 1 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 90; // Calcula a posição horizontal para cada título
                            case 2 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 195; // Calcula a posição horizontal para cada título
                            case 4 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 10; // Calcula a posição horizontal para cada título                         
                            default -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 30; // Calcula a posição horizontal para cada título
                        }
                    }
                    fluxoConteudo.beginText();
                    fluxoConteudo.setFont(timesBold, 12);
                    fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posição do título
                    fluxoConteudo.showText(titulosTabela[i]); // Texto do título
                    fluxoConteudo.endText();
                } 
            }

             
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar os títulos da coluna", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }
       
    //Titulo layout centralizado
    public void tituloLayoutCentralizado(String SubTitulo, float yPosition, PDPageContentStream fluxoConteudo, PDPage paginaPDF){  
        
        float larguraPagina = paginaPDF.getMediaBox().getWidth(); // Largura da Pagina
        float alturaPagina = paginaPDF.getMediaBox().getHeight(); // Altura da Página
        float margemEsquerda;
        float margemSuperior = yPosition;
        float tamanhoFonte = 12;
        final PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont hevelticaBold =  new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD); //Definindo a fonte
        final PDFont heveltica =  new PDType1Font(Standard14Fonts.FontName.HELVETICA); //Definindo a fonte
        
        try {                                 
            //Título relatório
            float larguraSubTitulo = timesBold.getStringWidth(SubTitulo)/1000 * tamanhoFonte; // Ajuste o tamanho da fonte         
            margemEsquerda = (larguraPagina - larguraSubTitulo) / 2;// Centraliza o texto
            //margemSuperior = 700;
            fluxoConteudo.beginText(); //Iniciando a escrita
            fluxoConteudo.setFont(timesBold, tamanhoFonte); //Definindo a fonte
            fluxoConteudo.newLineAtOffset(margemEsquerda, margemSuperior);  // Posição do texto
            fluxoConteudo.showText(SubTitulo);
            fluxoConteudo.endText();                 

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o Sub Título", "Atenção", JOptionPane.WARNING_MESSAGE);
        } 
    }
    
    //Titulos das separações das informações do relatório
    public void tituloLayoutEsquerda(String titulo, float yPosition, float xPosition, PDPageContentStream fluxoConteudo) throws IOException{
        
        PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        
        fluxoConteudo.beginText();
        fluxoConteudo.setFont(timesBold, 12);
        fluxoConteudo.newLineAtOffset(xPosition, yPosition);
        fluxoConteudo.showText(titulo);
        fluxoConteudo.endText();    
    }
    
    //Função para gerar apenas um totalizador
    public void valoresUmTotalizador(String descricao, double total, float yPosition, float xPosition, PDPageContentStream fluxoConteudo) throws IOException{
        
        // Definindo a fonte normal e negrito
        final PDFont times = new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); // Fonte normal
        final PDFont timesBold = new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); // Fonte em negrito
        final float tamanhoFonte = 12;

        fluxoConteudo.beginText();
        fluxoConteudo.setFont(times, tamanhoFonte);

        // Total de entrada com a descrição em negrito
        fluxoConteudo.newLineAtOffset(xPosition, yPosition);
        
        // Aplicando a fonte negrito para a descrição
        fluxoConteudo.setFont(timesBold, tamanhoFonte);
        fluxoConteudo.showText(descricao); 

        // Voltando para a fonte normal para o restante do texto
        fluxoConteudo.setFont(times, tamanhoFonte);
        fluxoConteudo.showText(" R$ " + this.conversor.formatarDoubleString(total).replace(".", ","));

        fluxoConteudo.endText();
        
    }
    
    //Função para gerar dois totalizados para o relatório 
    public void valoresDoisTotalizadores(String descricao1, String descricao2, double totalizador1, double totalizador2, float yPosition, PDPageContentStream fluxoConteudo) throws IOException{
        
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        final PDFont timesBold = new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); // Fonte em negrito
        float tamanhoFonte = 11;
        float xPosition = 40;

        fluxoConteudo.beginText();
        //fluxoConteudo.setFont(times, tamanhoFonte);

        //Total de entrada
        fluxoConteudo.newLineAtOffset(xPosition, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao1); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText(" R$ "+this.conversor.formatarDoubleString(totalizador1).replace(".", ","));
        yPosition =-12;

        //Total de Saída
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao2); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText(" R$ "+this.conversor.formatarDoubleString(totalizador2).replace(".", ","));

        fluxoConteudo.endText();
        
    }
    
    //Função para gerar três totalizados para o relatório
    public void valoresTresTotalizadores(String descricao1, String descricao2, String descricao3, double totalizador1, double totalizador2, double totalizador3, float yPosition, PDPageContentStream fluxoConteudo) throws IOException{
        
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        final PDFont timesBold = new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); // Fonte em negrito
        float tamanhoFonte = 11;
        float xPosition = 40;

        fluxoConteudo.beginText();
        //fluxoConteudo.setFont(times, tamanhoFonte);

        //Total de entrada
        fluxoConteudo.newLineAtOffset(xPosition, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao1); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador1).replace(".", ","));
        yPosition =-12; // Ajusta a posição da próxima linha

        //Total de Saída
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao2); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador2).replace(".", ","));

        //Saldo da conta caixa
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao3); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador3).replace(".", ","));

        fluxoConteudo.endText();
        
    }
    
    //Função para gerar três totalizados para o relatório
    public void valoresQuatroTotalizadores(String descricao1, String descricao2, String descricao3, String descricao4, double totalizador1, double totalizador2, double totalizador3, double totalizador4, float yPosition, PDPageContentStream fluxoConteudo) throws IOException{
        
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        final PDFont timesBold = new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); // Fonte em negrito
        float tamanhoFonte = 12;
        float xPosition = 40;

        fluxoConteudo.beginText();
        //fluxoConteudo.setFont(times, tamanhoFonte);

        //Total de entrada
        fluxoConteudo.newLineAtOffset(xPosition, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao1); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador1).replace(".", ","));
        yPosition =-12; // Ajusta a posição da próxima linha

        //Total de Saída
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao2); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador2).replace(".", ","));

        //Saldo da conta caixa
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao3); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador3).replace(".", ","));
        
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao4); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador4).replace(".", ","));

        fluxoConteudo.endText();
        
    }
    
    //Função para gerar quatro totalizados para o relatório
    public void valoresQuatroTotalizadoresRelatorioMensal(String descricao1, String descricao2, String descricao3, String descricao4, double totalizador1, double totalizador2, double totalizador3, double totalizador4, float yPosition, float xPosition, PDPageContentStream fluxoConteudo) throws IOException{
        
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        final PDFont timesBold = new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); // Fonte em negrito
        float tamanhoFonte = 12;

        fluxoConteudo.beginText();

        //Totalizador 1
        fluxoConteudo.newLineAtOffset(xPosition, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao1); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador1).replace(".", ","));
        yPosition =-12; // Ajusta a posição da próxima linha

        //Totalizador 2
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao2); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador2).replace(".", ","));

        //Totalizador 3
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao3); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador3).replace(".", ","));

        //Totalizafor 4
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao4); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador4).replace(".", ","));

        
        fluxoConteudo.endText();
        
    }
    
    //Função para gerar quatro totalizados para o relatório
    public void valoresCincoTotalizadoresRelatorioMensal(String descricao1, String descricao2, String descricao3, String descricao4, String descricao5, double totalizador1, double totalizador2, double totalizador3, double totalizador4, double totalizador5, float yPosition, float xPosition, PDPageContentStream fluxoConteudo) throws IOException{
        
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        final PDFont timesBold = new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); // Fonte em negrito
        float tamanhoFonte = 12;

        fluxoConteudo.beginText();

        //Totalizador 1
        fluxoConteudo.newLineAtOffset(xPosition, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao1); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador1).replace(".", ","));
        yPosition =-12; // Ajusta a posição da próxima linha

        //Totalizador 2
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao2); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador2).replace(".", ","));

        //Totalizador 3
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao3); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador3).replace(".", ","));

        //Totalizafor 4
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao4); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador4).replace(".", ","));

        //Totalizafor 5
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descrição
        fluxoConteudo.showText(descricao5); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador5).replace(".", ","));

        
        fluxoConteudo.endText();
        
    }
    
   
}
