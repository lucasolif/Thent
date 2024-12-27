
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
        float alturaPagina = paginaPDF.getMediaBox().getHeight(); // Altura da Página
        float margemEsquerda;
        float margemSuperior;
        float tamanhoFonteData = 10;
        float tamanhoFonteTitulo = 18;
        final String dataRelatorio = conversor.dataAtualString();    
        final PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont hevelticaBold =  new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD); //Definindo a fonte
        final PDFont heveltica =  new PDType1Font(Standard14Fonts.FontName.HELVETICA); //Definindo a fonte
        
        try {                     
            //Data da emissão do relatório
            margemEsquerda = larguraPagina - 130; // 100 pixels da borda direita
            margemSuperior = alturaPagina - 20; // 20 pixels da borda superior
            fluxoConteudo.beginText(); //Inicinado o texto
            fluxoConteudo.setFont(hevelticaBold, tamanhoFonteData); //Fonte e tamanho
            fluxoConteudo.newLineAtOffset(margemEsquerda, margemSuperior); // Posição do texto
            fluxoConteudo.showText("Data Emissão: "); //Texto
            fluxoConteudo.setFont(heveltica, tamanhoFonteData); //Fonte e tamanho
            fluxoConteudo.showText(dataRelatorio); //Texto
            fluxoConteudo.endText(); //Finaliza o texto
            
            //Título relatório
            float larguraTitulo = timesBold.getStringWidth(titulo)/1000 * tamanhoFonteTitulo; // Ajuste o tamanho da fonte         
            margemEsquerda = (larguraPagina - larguraTitulo) / 2;// Centraliza o texto
            margemSuperior = 760;
            fluxoConteudo.beginText(); //Iniciando a escrita
            fluxoConteudo.setFont(timesBold, tamanhoFonteTitulo); //Definindo a fonte
            fluxoConteudo.newLineAtOffset(margemEsquerda, margemSuperior);  // Posição do texto
            fluxoConteudo.showText(titulo);
            fluxoConteudo.endText();                 

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar título", "Atenção", JOptionPane.WARNING_MESSAGE);
        } 
    }
    
    public void subTituloRelatorio(String SubTitulo, PDPageContentStream fluxoConteudo, PDPage paginaPDF){  
        
        float larguraPagina = paginaPDF.getMediaBox().getWidth(); // Largura da Pagina
        float alturaPagina = paginaPDF.getMediaBox().getHeight(); // Altura da Página
        float margemEsquerda;
        float margemSuperior;
        float tamanhoFonte = 10;
        final PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont hevelticaBold =  new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD); //Definindo a fonte
        final PDFont heveltica =  new PDType1Font(Standard14Fonts.FontName.HELVETICA); //Definindo a fonte
        
        try {                                 
            //Título relatório
            float larguraSubTitulo = timesBold.getStringWidth(SubTitulo)/1000 * tamanhoFonte; // Ajuste o tamanho da fonte         
            margemEsquerda = (larguraPagina - larguraSubTitulo) / 2;// Centraliza o texto
            margemSuperior = 740;
            fluxoConteudo.beginText(); //Iniciando a escrita
            fluxoConteudo.setFont(timesBold, tamanhoFonte); //Definindo a fonte
            fluxoConteudo.newLineAtOffset(margemEsquerda, margemSuperior);  // Posição do texto
            fluxoConteudo.showText(SubTitulo);
            fluxoConteudo.endText();                 

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar o Sub Título", "Atenção", JOptionPane.WARNING_MESSAGE);
        } 
    }
    
    public void salvarRelatorioPDF(String nome, PDDocument documentoPDF){

        // Configuração do conteúdo
        try {
            // Aqui é onde você pedirá ao usuário o local para salvar o PDF
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Salvar Relatório PDF");
            
            String dataAtual = this.conversor.dataAtualString().replace("/", "-");
            String nomeArquivo = nome+"-"+dataAtual+".pdf";
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
                    fluxoConteudo.setFont(timesBold, 11);
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
                    fluxoConteudo.setFont(timesBold, 11);
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

    public void descricaoTotalizadores (double totalEntrada, double totalSaida, float yPosition, float xPosition, PDPageContentStream fluxoConteudo) throws IOException{
        
        PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        float tamanhoFonte = 10;

        fluxoConteudo.beginText();
        fluxoConteudo.setFont(timesBold, tamanhoFonte);

        //Total de entrada
        fluxoConteudo.newLineAtOffset(xPosition+320, yPosition-30);
        fluxoConteudo.showText("TOTAL DE ENTRADA:");
        yPosition -= 555; // Ajusta a posição da próxima linha

        //Total de Saída
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.showText("TOTAL DE SAÍDA:");

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
        yPosition -= 555; // Ajusta a posição da próxima linha

        //Total de Saída
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalSaida).replace(".", ","));

        //Saldo da conta caixa
        fluxoConteudo.newLineAtOffset(0, yPosition);
        fluxoConteudo.showText("R$ "+this.conversor.formatarDoubleString(totalEntrada-totalSaida).replace(".", ","));

        fluxoConteudo.endText();
        
    }
    
    
}
