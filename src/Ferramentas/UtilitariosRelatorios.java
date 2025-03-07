
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
    
    //Fun��o para gerar o t�tulo do relat�rio
    public void primeiroTituloRelatorio(float tmnFonte, String titulo, PDPageContentStream fluxoConteudo, PDPage paginaPDF){  
        
        float larguraPagina = paginaPDF.getMediaBox().getWidth(); // Largura da Pagina
        float alturaPagina = paginaPDF.getMediaBox().getHeight(); // Altura da P�gina
        float xPosition;
        float yPosition;
        float tamanhoFonteData = 11;
        final String dataRelatorio = conversor.dataAtualString();    
        final PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        
        try {                     
            //Data da emiss�o do relat�rio
            xPosition = larguraPagina - 150; // 100 pixels da borda direita
            yPosition = alturaPagina - 20; // 20 pixels da borda superior
            fluxoConteudo.beginText(); //Inicinado o texto
            fluxoConteudo.setFont(timesBold, tamanhoFonteData); //Fonte e tamanho
            fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posi��o do texto
            fluxoConteudo.showText("Data Emiss�o: "); //Texto
            fluxoConteudo.setFont(times, tamanhoFonteData); //Fonte e tamanho
            fluxoConteudo.showText(dataRelatorio); //Texto
            fluxoConteudo.endText(); //Finaliza o texto
            
            //T�tulo relat�rio
            float larguraTitulo = timesBold.getStringWidth(titulo)/1000 * tmnFonte; // Ajuste o tamanho da fonte         
            xPosition = (larguraPagina - larguraTitulo) / 2;// Centraliza o texto
            yPosition = 760;
            fluxoConteudo.beginText(); //Iniciando a escrita
            fluxoConteudo.setFont(timesBold, tmnFonte); //Definindo a fonte
            fluxoConteudo.newLineAtOffset(xPosition, yPosition);  // Posi��o do texto
            fluxoConteudo.showText(titulo);
            fluxoConteudo.endText();                 

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar t�tulo", "Aten��o", JOptionPane.WARNING_MESSAGE);
        } 
    }
    
        //Fun��o para gerar o t�tulo do relat�rio
    public void segundoTituloRelatorio(float tmnFonte, String titulo, PDPageContentStream fluxoConteudo, PDPage paginaPDF){  
        
        float larguraPagina = paginaPDF.getMediaBox().getWidth(); // Largura da Pagina
        float alturaPagina = paginaPDF.getMediaBox().getHeight(); // Altura da P�gina
        float xPosition;
        float yPosition;
        float tamanhoFonteData = 11;
        final String dataRelatorio = conversor.dataAtualString();    
        final PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        
        try {                     
            //Data da emiss�o do relat�rio
            xPosition = larguraPagina - 150; // 100 pixels da borda direita
            yPosition = alturaPagina - 20; // 20 pixels da borda superior
            fluxoConteudo.beginText(); //Inicinado o texto
            fluxoConteudo.setFont(timesBold, tamanhoFonteData); //Fonte e tamanho
            fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posi��o do texto
            fluxoConteudo.showText("Data Emiss�o: "); //Texto
            fluxoConteudo.setFont(times, tamanhoFonteData); //Fonte e tamanho
            fluxoConteudo.showText(dataRelatorio); //Texto
            fluxoConteudo.endText(); //Finaliza o texto
            
            //T�tulo relat�rio
            float larguraTitulo = timesBold.getStringWidth(titulo)/1000 * tmnFonte; // Ajuste o tamanho da fonte         
            xPosition = (larguraPagina - larguraTitulo) / 2;// Centraliza o texto
            yPosition = 740;
            fluxoConteudo.beginText(); //Iniciando a escrita
            fluxoConteudo.setFont(timesBold, tmnFonte); //Definindo a fonte
            fluxoConteudo.newLineAtOffset(xPosition, yPosition);  // Posi��o do texto
            fluxoConteudo.showText(titulo);
            fluxoConteudo.endText();                 

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar t�tulo", "Aten��o", JOptionPane.WARNING_MESSAGE);
        } 
    }
    
    //Fun��o para gerar o subtitulo do relat�rio
    public void subTituloRelatorio(String SubTitulo, PDPageContentStream fluxoConteudo, PDPage paginaPDF){  
        
        float larguraPagina = paginaPDF.getMediaBox().getWidth(); // Largura da Pagina
        float alturaPagina = paginaPDF.getMediaBox().getHeight(); // Altura da P�gina
        float xPosition;
        float yPosition;
        float tamanhoFonte = 11;
        final PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont hevelticaBold =  new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD); //Definindo a fonte
        final PDFont heveltica =  new PDType1Font(Standard14Fonts.FontName.HELVETICA); //Definindo a fonte
        
        try {                                 
            //T�tulo relat�rio
            float larguraSubTitulo = timesBold.getStringWidth(SubTitulo)/1000 * tamanhoFonte; // Ajuste o tamanho da fonte         
            xPosition = (larguraPagina - larguraSubTitulo) / 2;// Centraliza o texto
            yPosition = 740;
            fluxoConteudo.beginText(); //Iniciando a escrita
            fluxoConteudo.setFont(timesBold, tamanhoFonte); //Definindo a fonte
            fluxoConteudo.newLineAtOffset(xPosition, yPosition);  // Posi��o do texto
            fluxoConteudo.showText(SubTitulo);
            fluxoConteudo.endText();                 

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o Sub T�tulo", "Aten��o", JOptionPane.WARNING_MESSAGE);
        } 
    }
    
    //Fun��o para abrir a tela do local de salvamento do relat�rio
    public void salvarRelatorioPDF(String nome, PDDocument documentoPDF){

        // Configura��o do conte�do
        try {
            // Aqui � onde voc� pedir� ao usu�rio o local para salvar o PDF
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Salvar Relat�rio PDF");
            
            String dataAtual = this.conversor.dataAtualString().replace("/", "-");
            String nomeArquivo = nome+" "+dataAtual+".pdf";
            fileChooser.setSelectedFile(new File(nomeArquivo)); // Nome padr�o do arquivo

            // Abre a caixa de di�logo para salvar
            int userSelection = fileChooser.showSaveDialog(null);

            // Se o usu�rio pressionar "Salvar"
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File arquivoParaSalvar = fileChooser.getSelectedFile();
                String caminhoArquivo = arquivoParaSalvar.getAbsolutePath();

                // Verifica se o arquivo n�o tem a extens�o ".pdf" e adiciona, caso necess�rio
                if (!caminhoArquivo.toLowerCase().endsWith(".pdf")) {
                    caminhoArquivo += ".pdf";
                }
                
                // Verificar se o arquivo j� existe
                File arquivoExistente = new File(caminhoArquivo);
                if (arquivoExistente.exists()) {
                    // Exibe uma mensagem perguntando se o usu�rio deseja substituir o arquivo
                    int resposta = JOptionPane.showConfirmDialog(null, "O arquivo j� existe. Deseja substituir?", "Arquivo j� existe", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (resposta == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "Arquivo n�o salvo Opera��o finalizada.", "Aten��o", JOptionPane.WARNING_MESSAGE);
                    }else{
                        // Salvar o documento no local escolhido
                        documentoPDF.save(caminhoArquivo);
                        JOptionPane.showMessageDialog(null, "Relat�rio gerado com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    // Salvar o documento no local escolhido
                    documentoPDF.save(caminhoArquivo);
                    JOptionPane.showMessageDialog(null, "Relat�rio gerado com sucesso", "Conclu�do", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Caminho n�o selecionado.", "Aten��o", JOptionPane.WARNING_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o arquivo PDF", "Aten��o", JOptionPane.WARNING_MESSAGE);
        }
    
    }
    
    public void tituloColunaRelatorioContasPagarReceber(int layout, float yPosition, float xPosition, String[] titulosTabela, PDPageContentStream fluxoConteudo){       
        PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        
        try{
            if(layout == 1 || layout == 3 ||layout == 4 || layout == 5 || layout == 6){
                // Definir os t�tulos das colunas na p�gina
                for (int i = 0; i < titulosTabela.length; i++) {
                    if(i != 0){
                        switch (i) {
                            case 2 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 125; // Calcula a posi��o horizontal para cada t�tulo
                            case 5 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 25; // Calcula a posi��o horizontal para cada t�tulo
                            case 6 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 20; // Calcula a posi��o horizontal para cada t�tulo
                            default -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 13; // Calcula a posi��o horizontal para cada t�tulo
                        }
                    }
                    fluxoConteudo.beginText();
                    fluxoConteudo.setFont(timesBold, 11);
                    fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posi��o do t�tulo
                    fluxoConteudo.showText(titulosTabela[i]); // Texto do t�tulo
                    fluxoConteudo.endText();
                } 
            }else if(layout == 2){
                // Desenhar os t�tulos das colunas na p�gina
                for (int i = 0; i < titulosTabela.length; i++) {
                    if(i != 0){
                        switch (i) {
                            case 3 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 125; // Calcula a posi��o horizontal para cada t�tulo
                            case 5 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 25; // Calcula a posi��o horizontal para cada t�tulo
                            case 6 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 20; // Calcula a posi��o horizontal para cada t�tulo
                            default -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 13; // Calcula a posi��o horizontal para cada t�tulo
                        }
                    }
                    fluxoConteudo.beginText();
                    fluxoConteudo.setFont(timesBold, 11);
                    fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posi��o do t�tulo
                    fluxoConteudo.showText(titulosTabela[i]); // Texto do t�tulo
                    fluxoConteudo.endText();
                }  
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar os t�tulos da coluna", "Aten��o", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void tituloColunaRelatorioContaCaixa (int layout, float yPosition, float xPosition, String[] titulosTabela, PDPageContentStream fluxoConteudo){       
        PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        final float tamanhoFonte = 12;
        
        try{
            if(layout == 1){
                // Definir os t�tulos das colunas na p�gina
                for (int i = 0; i < titulosTabela.length; i++) {
                    if(i != 0){
                        switch (i) {
                            case 1 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 35; // Calcula a posi��o horizontal para cada t�tulo
                            case 2 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 170; // Calcula a posi��o horizontal para cada t�tulo
                            case 4 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 30; // Calcula a posi��o horizontal para cada t�tulo
                            case 5 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 50; // Calcula a posi��o horizontal para cada t�tulo
                            default -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 13; // Calcula a posi��o horizontal para cada t�tulo
                        }
                    }
                    fluxoConteudo.beginText();
                    fluxoConteudo.setFont(timesBold, tamanhoFonte);
                    fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posi��o do t�tulo
                    fluxoConteudo.showText(titulosTabela[i]); // Texto do t�tulo
                    fluxoConteudo.endText();
                } 
            }else if(layout == 2){
                // Definir os t�tulos das colunas na p�gina
                for (int i = 0; i < titulosTabela.length; i++) {
                    if(i != 0){
                        switch (i) {
                            case 1 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 200; // Calcula a posi��o horizontal para cada t�tulo
                            case 2 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 30; // Calcula a posi��o horizontal para cada t�tulo
                            case 3 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 30; // Calcula a posi��o horizontal para cada t�tulo                         
                            case 4 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 60; // Calcula a posi��o horizontal para cada t�tulo
                        }
                    }
                    fluxoConteudo.beginText();
                    fluxoConteudo.setFont(timesBold, tamanhoFonte);
                    fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posi��o do t�tulo
                    fluxoConteudo.showText(titulosTabela[i]); // Texto do t�tulo
                    fluxoConteudo.endText();
                } 
            }else if(layout == 3){
                // Definir os t�tulos das colunas na p�gina
                for (int i = 0; i < titulosTabela.length; i++) {
                    if(i != 0){
                        switch (i) {
                            case 1 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 13; // Calcula a posi��o horizontal para cada t�tulo
                            case 2 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 35; // Calcula a posi��o horizontal para cada t�tulo
                            case 3 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 165; // Calcula a posi��o horizontal para cada t�tulo
                            case 4 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 20; // Calcula a posi��o horizontal para cada t�tulo
                            case 5 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 30; // Calcula a posi��o horizontal para cada t�tulo
                        }
                    }
                    fluxoConteudo.beginText();
                    fluxoConteudo.setFont(timesBold, tamanhoFonte);
                    fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posi��o do t�tulo
                    fluxoConteudo.showText(titulosTabela[i]); // Texto do t�tulo
                    fluxoConteudo.endText();
                } 
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar os t�tulos da coluna", "Aten��o", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void tituloColunaRelatorioRgDizimoOferta (int layout, float yPosition, float xPosition, String[] titulosTabela, PDPageContentStream fluxoConteudo){       
        final PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        final float tamanhoFonte = 11;
        
        try{
            if(layout == 1 || layout == 2 || layout == 3){
                // Definir os t�tulos das colunas na p�gina
                for (int i = 0; i < titulosTabela.length; i++) {
                    if(i != 0){
                        switch (i) {
                            case 1 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 70; // Calcula a posi��o horizontal para cada t�tulo
                            case 2 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 15; // Calcula a posi��o horizontal para cada t�tulo
                            case 3 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 15; // Calcula a posi��o horizontal para cada t�tulo
                            case 4 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 100; // Calcula a posi��o horizontal para cada t�tulo
                            case 5 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 25; // Calcula a posi��o horizontal para cada t�tulo
                            default -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 13; // Calcula a posi��o horizontal para cada t�tulo
                        }
                    }
                    fluxoConteudo.beginText();
                    fluxoConteudo.setFont(timesBold, tamanhoFonte);
                    fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posi��o do t�tulo
                    fluxoConteudo.showText(titulosTabela[i]); // Texto do t�tulo
                    fluxoConteudo.endText();
                } 
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar os t�tulos da coluna", "Aten��o", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void tituloColunaRelatorioTesourariaLocal (float yPosition, float xPosition, String[] titulosTabela, PDPageContentStream fluxoConteudo){       
        PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
         
        try{
            // Definir os t�tulos das colunas na p�gina
            for (int i = 0; i < titulosTabela.length; i++) {
                if(i != 0){
                    xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 340; // Calcula a posi��o horizontal para cada t�tulo
                }
                
                fluxoConteudo.beginText();
                fluxoConteudo.setFont(timesBold, 12);
                fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posi��o do t�tulo
                fluxoConteudo.showText(titulosTabela[i]); // Texto do t�tulo
                fluxoConteudo.endText();
            }
             
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar os t�tulos da coluna", "Aten��o", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void tituloColunaRelatorioTesourariaGeral (float yPosition, float xPosition, String[] titulosTabela, int layout, PDPageContentStream fluxoConteudo){       
        PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        
        try{
            if(layout == 1){
                // Definir os t�tulos das colunas na p�gina
                for (int i = 0; i < titulosTabela.length; i++) {
                    if(i != 0){
                        xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 377; // Calcula a posi��o horizontal para cada t�tulo
                    }

                    fluxoConteudo.beginText();
                    fluxoConteudo.setFont(timesBold, 12);
                    fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posi��o do t�tulo
                    fluxoConteudo.showText(titulosTabela[i]); // Texto do t�tulo
                    fluxoConteudo.endText();
                }
            }else if(layout == 2){
                for (int i = 0; i < titulosTabela.length; i++) {
                    if(i != 0){
                        switch (i) {
                            case 1 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 90; // Calcula a posi��o horizontal para cada t�tulo
                            case 2 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 195; // Calcula a posi��o horizontal para cada t�tulo
                            case 4 -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 10; // Calcula a posi��o horizontal para cada t�tulo                         
                            default -> xPosition += (timesBold.getStringWidth(titulosTabela[i-1])/1000 * 11) + 30; // Calcula a posi��o horizontal para cada t�tulo
                        }
                    }
                    fluxoConteudo.beginText();
                    fluxoConteudo.setFont(timesBold, 12);
                    fluxoConteudo.newLineAtOffset(xPosition, yPosition); // Posi��o do t�tulo
                    fluxoConteudo.showText(titulosTabela[i]); // Texto do t�tulo
                    fluxoConteudo.endText();
                } 
            }

             
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar os t�tulos da coluna", "Aten��o", JOptionPane.WARNING_MESSAGE);
        }
    }
       
    //Titulo layout centralizado
    public void tituloLayoutCentralizado(String SubTitulo, float yPosition, PDPageContentStream fluxoConteudo, PDPage paginaPDF){  
        
        float larguraPagina = paginaPDF.getMediaBox().getWidth(); // Largura da Pagina
        float alturaPagina = paginaPDF.getMediaBox().getHeight(); // Altura da P�gina
        float margemEsquerda;
        float margemSuperior = yPosition;
        float tamanhoFonte = 12;
        final PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont hevelticaBold =  new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD); //Definindo a fonte
        final PDFont heveltica =  new PDType1Font(Standard14Fonts.FontName.HELVETICA); //Definindo a fonte
        
        try {                                 
            //T�tulo relat�rio
            float larguraSubTitulo = timesBold.getStringWidth(SubTitulo)/1000 * tamanhoFonte; // Ajuste o tamanho da fonte         
            margemEsquerda = (larguraPagina - larguraSubTitulo) / 2;// Centraliza o texto
            //margemSuperior = 700;
            fluxoConteudo.beginText(); //Iniciando a escrita
            fluxoConteudo.setFont(timesBold, tamanhoFonte); //Definindo a fonte
            fluxoConteudo.newLineAtOffset(margemEsquerda, margemSuperior);  // Posi��o do texto
            fluxoConteudo.showText(SubTitulo);
            fluxoConteudo.endText();                 

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o Sub T�tulo", "Aten��o", JOptionPane.WARNING_MESSAGE);
        } 
    }
    
    //Titulos das separa��es das informa��es do relat�rio
    public void tituloLayoutEsquerda(String titulo, float yPosition, float xPosition, PDPageContentStream fluxoConteudo) throws IOException{
        
        PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        
        fluxoConteudo.beginText();
        fluxoConteudo.setFont(timesBold, 12);
        fluxoConteudo.newLineAtOffset(xPosition, yPosition);
        fluxoConteudo.showText(titulo);
        fluxoConteudo.endText();    
    }
    
    //Fun��o para gerar apenas um totalizador
    public void valoresUmTotalizador(String descricao, double total, float yPosition, float xPosition, PDPageContentStream fluxoConteudo) throws IOException{
        
        // Definindo a fonte normal e negrito
        final PDFont times = new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); // Fonte normal
        final PDFont timesBold = new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); // Fonte em negrito
        final float tamanhoFonte = 12;

        fluxoConteudo.beginText();
        fluxoConteudo.setFont(times, tamanhoFonte);

        // Total de entrada com a descri��o em negrito
        fluxoConteudo.newLineAtOffset(xPosition, yPosition);
        
        // Aplicando a fonte negrito para a descri��o
        fluxoConteudo.setFont(timesBold, tamanhoFonte);
        fluxoConteudo.showText(descricao); 

        // Voltando para a fonte normal para o restante do texto
        fluxoConteudo.setFont(times, tamanhoFonte);
        fluxoConteudo.showText(" R$ " + this.conversor.formatarDoubleString(total).replace(".", ","));

        fluxoConteudo.endText();
        
    }
    
    //Fun��o para gerar dois totalizados para o relat�rio 
    public void valoresDoisTotalizadores(String descricao1, String descricao2, double totalizador1, double totalizador2, float yPosition, PDPageContentStream fluxoConteudo) throws IOException{
        
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        final PDFont timesBold = new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); // Fonte em negrito
        float tamanhoFonte = 11;
        float xPosition = 40;

        fluxoConteudo.beginText();
        //fluxoConteudo.setFont(times, tamanhoFonte);

        //Total de entrada
        fluxoConteudo.newLineAtOffset(xPosition, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao1); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText(" R$ "+this.conversor.formatarDoubleString(totalizador1).replace(".", ","));
        yPosition =-12;

        //Total de Sa�da
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao2); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText(" R$ "+this.conversor.formatarDoubleString(totalizador2).replace(".", ","));

        fluxoConteudo.endText();
        
    }
    
    //Fun��o para gerar tr�s totalizados para o relat�rio
    public void valoresTresTotalizadores(String descricao1, String descricao2, String descricao3, double totalizador1, double totalizador2, double totalizador3, float yPosition, PDPageContentStream fluxoConteudo) throws IOException{
        
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        final PDFont timesBold = new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); // Fonte em negrito
        float tamanhoFonte = 11;
        float xPosition = 40;

        fluxoConteudo.beginText();
        //fluxoConteudo.setFont(times, tamanhoFonte);

        //Total de entrada
        fluxoConteudo.newLineAtOffset(xPosition, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao1); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador1).replace(".", ","));
        yPosition =-12; // Ajusta a posi��o da pr�xima linha

        //Total de Sa�da
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao2); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador2).replace(".", ","));

        //Saldo da conta caixa
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao3); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador3).replace(".", ","));

        fluxoConteudo.endText();
        
    }
    
    //Fun��o para gerar tr�s totalizados para o relat�rio
    public void valoresQuatroTotalizadores(String descricao1, String descricao2, String descricao3, String descricao4, double totalizador1, double totalizador2, double totalizador3, double totalizador4, float yPosition, PDPageContentStream fluxoConteudo) throws IOException{
        
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        final PDFont timesBold = new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); // Fonte em negrito
        float tamanhoFonte = 12;
        float xPosition = 40;

        fluxoConteudo.beginText();
        //fluxoConteudo.setFont(times, tamanhoFonte);

        //Total de entrada
        fluxoConteudo.newLineAtOffset(xPosition, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao1); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador1).replace(".", ","));
        yPosition =-12; // Ajusta a posi��o da pr�xima linha

        //Total de Sa�da
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao2); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador2).replace(".", ","));

        //Saldo da conta caixa
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao3); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador3).replace(".", ","));
        
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao4); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador4).replace(".", ","));

        fluxoConteudo.endText();
        
    }
    
    //Fun��o para gerar quatro totalizados para o relat�rio
    public void valoresQuatroTotalizadoresRelatorioMensal(String descricao1, String descricao2, String descricao3, String descricao4, double totalizador1, double totalizador2, double totalizador3, double totalizador4, float yPosition, float xPosition, PDPageContentStream fluxoConteudo) throws IOException{
        
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        final PDFont timesBold = new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); // Fonte em negrito
        float tamanhoFonte = 12;

        fluxoConteudo.beginText();

        //Totalizador 1
        fluxoConteudo.newLineAtOffset(xPosition, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao1); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador1).replace(".", ","));
        yPosition =-12; // Ajusta a posi��o da pr�xima linha

        //Totalizador 2
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao2); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador2).replace(".", ","));

        //Totalizador 3
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao3); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador3).replace(".", ","));

        //Totalizafor 4
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao4); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador4).replace(".", ","));

        
        fluxoConteudo.endText();
        
    }
    
    //Fun��o para gerar quatro totalizados para o relat�rio
    public void valoresCincoTotalizadoresRelatorioMensal(String descricao1, String descricao2, String descricao3, String descricao4, String descricao5, double totalizador1, double totalizador2, double totalizador3, double totalizador4, double totalizador5, float yPosition, float xPosition, PDPageContentStream fluxoConteudo) throws IOException{
        
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        final PDFont timesBold = new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); // Fonte em negrito
        float tamanhoFonte = 12;

        fluxoConteudo.beginText();

        //Totalizador 1
        fluxoConteudo.newLineAtOffset(xPosition, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao1); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador1).replace(".", ","));
        yPosition =-12; // Ajusta a posi��o da pr�xima linha

        //Totalizador 2
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao2); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador2).replace(".", ","));

        //Totalizador 3
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao3); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador3).replace(".", ","));

        //Totalizafor 4
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao4); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador4).replace(".", ","));

        //Totalizafor 5
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.setFont(timesBold, tamanhoFonte);// Aplicando a fonte negrito para a descri��o
        fluxoConteudo.showText(descricao5); 
        fluxoConteudo.setFont(times, tamanhoFonte);// Voltando para a fonte normal para o restante do texto
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalizador5).replace(".", ","));

        
        fluxoConteudo.endText();
        
    }
    
   
}
