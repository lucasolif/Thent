
package Services;

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


public class Relatorios {
    
    private final Utilitarios conversor = new Utilitarios();
    
    public void tituloRelatorio(String titulo, PDPageContentStream fluxoConteudo, PDPage paginaPDF){  
        
        float larguraPagina = paginaPDF.getMediaBox().getWidth(); // Largura da Pagina
        float alturaPagina = paginaPDF.getMediaBox().getHeight(); // Altura da P�gina
        float margemEsquerda;
        float margemSuperior;
        float tamanhoFonteData = 10;
        float tamanhoFonteTitulo = 18;
        final String dataRelatorio = conversor.dataAtualString();    
        final PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont hevelticaBold =  new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD); //Definindo a fonte
        final PDFont heveltica =  new PDType1Font(Standard14Fonts.FontName.HELVETICA); //Definindo a fonte
        
        try {                     
            //Data da emiss�o do relat�rio
            margemEsquerda = larguraPagina - 130; // 100 pixels da borda direita
            margemSuperior = alturaPagina - 20; // 20 pixels da borda superior
            fluxoConteudo.beginText(); //Inicinado o texto
            fluxoConteudo.setFont(hevelticaBold, tamanhoFonteData); //Fonte e tamanho
            fluxoConteudo.newLineAtOffset(margemEsquerda, margemSuperior); // Posi��o do texto
            fluxoConteudo.showText("Data Emiss�o: "); //Texto
            fluxoConteudo.setFont(heveltica, tamanhoFonteData); //Fonte e tamanho
            fluxoConteudo.showText(dataRelatorio); //Texto
            fluxoConteudo.endText(); //Finaliza o texto
            
            //T�tulo relat�rio
            float larguraTitulo = timesBold.getStringWidth(titulo)/1000 * tamanhoFonteTitulo; // Ajuste o tamanho da fonte         
            margemEsquerda = (larguraPagina - larguraTitulo) / 2;// Centraliza o texto
            margemSuperior = 760;
            fluxoConteudo.beginText(); //Iniciando a escrita
            fluxoConteudo.setFont(timesBold, tamanhoFonteTitulo); //Definindo a fonte
            fluxoConteudo.newLineAtOffset(margemEsquerda, margemSuperior);  // Posi��o do texto
            fluxoConteudo.showText(titulo);
            fluxoConteudo.endText();                 

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar t�tulo", "Aten��o", JOptionPane.WARNING_MESSAGE);
        } 
    }
    
    public void subTituloRelatorio(String SubTitulo, PDPageContentStream fluxoConteudo, PDPage paginaPDF){  
        
        float larguraPagina = paginaPDF.getMediaBox().getWidth(); // Largura da Pagina
        float alturaPagina = paginaPDF.getMediaBox().getHeight(); // Altura da P�gina
        float margemEsquerda;
        float margemSuperior;
        float tamanhoFonte = 10;
        final PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont hevelticaBold =  new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD); //Definindo a fonte
        final PDFont heveltica =  new PDType1Font(Standard14Fonts.FontName.HELVETICA); //Definindo a fonte
        
        try {                                 
            //T�tulo relat�rio
            float larguraSubTitulo = timesBold.getStringWidth(SubTitulo)/1000 * tamanhoFonte; // Ajuste o tamanho da fonte         
            margemEsquerda = (larguraPagina - larguraSubTitulo) / 2;// Centraliza o texto
            margemSuperior = 740;
            fluxoConteudo.beginText(); //Iniciando a escrita
            fluxoConteudo.setFont(timesBold, tamanhoFonte); //Definindo a fonte
            fluxoConteudo.newLineAtOffset(margemEsquerda, margemSuperior);  // Posi��o do texto
            fluxoConteudo.showText(SubTitulo);
            fluxoConteudo.endText();                 

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o Sub T�tulo", "Aten��o", JOptionPane.WARNING_MESSAGE);
        } 
    }
    
    public void salvarRelatorioPDF(String nome, PDDocument documentoPDF){

        // Configura��o do conte�do
        try {
            // Aqui � onde voc� pedir� ao usu�rio o local para salvar o PDF
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Salvar Relat�rio PDF");
            
            String dataAtual = this.conversor.dataAtualString().replace("/", "-");
            String nomeArquivo = nome+"-"+dataAtual+".pdf";
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
                    fluxoConteudo.setFont(timesBold, 11);
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
                    fluxoConteudo.setFont(timesBold, 11);
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

    public void descricaoTotalizadores (double totalEntrada, double totalSaida, float yPosition, float xPosition, PDPageContentStream fluxoConteudo) throws IOException{
        
        PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        float tamanhoFonte = 10;

        fluxoConteudo.beginText();
        fluxoConteudo.setFont(timesBold, tamanhoFonte);

        //Total de entrada
        fluxoConteudo.newLineAtOffset(xPosition+320, yPosition-30);
        fluxoConteudo.showText("TOTAL DE ENTRADA:");
        yPosition -= 555; // Ajusta a posi��o da pr�xima linha

        //Total de Sa�da
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.showText("TOTAL DE SA�DA:");

        //Saldo da conta caixa
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.showText("SALDO ATUAL:");

        fluxoConteudo.endText();
        
    }
    
    public void valoresTotalizadores (double totalEntrada, double totalSaida, float yPosition, float xPosition, PDPageContentStream fluxoConteudo) throws IOException{
        
        final PDFont times =  new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN); //Definindo a fonte
        float tamanhoFonte = 11;

        fluxoConteudo.beginText();
        fluxoConteudo.setFont(times, tamanhoFonte);

        //Total de entrada
        fluxoConteudo.newLineAtOffset(xPosition+440, yPosition-30);
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalEntrada).replace(".", ","));
        yPosition -= 555; // Ajusta a posi��o da pr�xima linha

        //Total de Sa�da
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalSaida).replace(".", ","));

        //Saldo da conta caixa
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalEntrada-totalSaida).replace(".", ","));

        fluxoConteudo.endText();
        
    }
    
    
}
