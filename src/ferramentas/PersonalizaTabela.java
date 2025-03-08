
package ferramentas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class PersonalizaTabela {
    
    // Função para intercalar as cores das linhas da tabela
    public void alternarCorLinhaTabela(JTable tabela) {
        // Criando um renderizador personalizado para intercalar as cores
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                // Chama o método original para configurar a célula
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                // Altera a cor de fundo das linhas alternadas
                if (row % 2 == 0) {
                    comp.setBackground(Color.WHITE); // Linha branca
                } else {
                    comp.setBackground(Color.LIGHT_GRAY); // Linha cinza claro
                }
                
                return comp;
            }
        };

        // Definindo o renderizador para todas as células da tabela
        tabela.setDefaultRenderer(Object.class, renderer);
    }
    
    public void definirNegritoTituloColuna(JTable tabela){
        // Obtendo o renderizador de cabeçalho (título das colunas)
        JTableHeader tableHeader = tabela.getTableHeader();
        String nomeFonte = tableHeader.getFont().getFontName();
        int tamanhoFonte = tableHeader.getFont().getSize();
        tableHeader.setFont(new Font(nomeFonte, Font.BOLD, tamanhoFonte));  // Definindo a fonte para o cabeçalho (negrito)
    }
    
}
