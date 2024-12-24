
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
        final String dataRelatorio = conversor.dataAtualString();    
        final PDFont timesBold =  new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD); //Definindo a fonte
        final PDFont hevelticaBold =  new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD); //Definindo a fonte
        final PDFont heveltica =  new PDType1Font(Standard14Fonts.FontName.HELVETICA); //Definindo a fonte
        
        try {                     
            //Data da emissão do relatório
            margemEsquerda = larguraPagina - 130; // 100 pixels da borda direita
            margemSuperior = alturaPagina - 20; // 20 pixels da borda superior
            fluxoConteudo.beginText(); //Inicinado o texto
            fluxoConteudo.setFont(hevelticaBold, 8); //Fonte e tamanho
            fluxoConteudo.newLineAtOffset(margemEsquerda, margemSuperior); // Posição do texto
            fluxoConteudo.showText("Data Emissão: "); //Texto
            fluxoConteudo.setFont(heveltica, 8); //Fonte e tamanho
            fluxoConteudo.showText(dataRelatorio); //Texto
            fluxoConteudo.endText(); //Finaliza o texto
            
            //Título relatório
            float larguraTitulo = timesBold.getStringWidth(titulo)/1000 * 14; // Ajuste o tamanho da fonte         
            margemEsquerda = (larguraPagina - larguraTitulo) / 2;// Centraliza o texto
            margemSuperior = 760;
            fluxoConteudo.beginText(); //Iniciando a escrita
            fluxoConteudo.setFont(timesBold, 14); //Definindo a fonte
            fluxoConteudo.newLineAtOffset(margemEsquerda, margemSuperior);  // Posição do texto
            fluxoConteudo.showText(titulo);
            fluxoConteudo.endText();                 

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar título", "Atenção", JOptionPane.WARNING_MESSAGE);
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
    
}
