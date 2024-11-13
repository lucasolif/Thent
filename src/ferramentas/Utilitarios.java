
package ferramentas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import javax.swing.JOptionPane;

public class Utilitarios{
     
    //Arredondando o valor para cima se for maior que 0.5 e para baixo se for menos que 0.5
    public double arrendodarValores(double valor){
        BigDecimal bd = new BigDecimal(valor).setScale(2, RoundingMode.HALF_DOWN); 
        double novoValorArredondado = bd.doubleValue();
        
        return novoValorArredondado;
    }
    
    public String convertendoDataStringSql(java.sql.Date data){
        
        try{
            if(data == null){
                return " ";
            }else{
                DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate localDate = data.toLocalDate();

                String dataFormatada = localDate.format(formatoData);

                return dataFormatada;
            }
        } catch (DateTimeParseException e) {
            // Lan�ando uma exce��o se a string estiver em um formato inv�lido
            throw new IllegalArgumentException("Erro ao tentar converte Date em String", e);
        }
    }
    
    public Date convertendoStringDateSql(String data) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            // Converte a string para LocalDate
            LocalDate localDate = LocalDate.parse(data, formatoData);

            // Converte LocalDate para java.sql.Date, usando o m�todo from() e Instant
            return java.sql.Date.valueOf(localDate);
        } catch (DateTimeParseException e) {
            // Lan�ando uma exce��o se a string estiver em um formato inv�lido
            throw new IllegalArgumentException("Erro ao tentar converter String em Date", e);
        }
    }
    
    public Integer validarStringNula(String valor){
        // Verifica se a string � nula ou vazia
        if (valor == null || valor.trim().isEmpty()) {
            return null;  
        }

        try {
            // Tenta converter a string para um Integer
            return Integer.parseInt(valor.trim());
        } catch (NumberFormatException e) {
            // Trata o erro de formato e retorna null ou valor padr�o
            System.out.println("Erro ao converter a string para Integer: " + e.getMessage());
            return null;  
        }
    }
    
    public String dataAtualString(){
        LocalDateTime dataAtual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataAtual.format(formato);
        
        return dataFormatada;

    }
    
    private static boolean verificarNumero(String valor) {
        return valor != null && valor.matches("[0-9]*");
    }
    
    public String calcularData(String data, Integer meses){
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String novaDataString = null;
        
        // A string que representa a data
        
        try {
            // Converter a string para o tipo LocalDate
            LocalDate date = LocalDate.parse(data, formato);
            
            // Adicionar um m�s � data
            LocalDate newDate = date.plus(Period.ofMonths(meses));
            
            // Converte a nova data de volta para string
            novaDataString = newDate.format(formato);
            
        } catch (DateTimeParseException e) {
            // Lidar com poss�veis erros de parsing
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar os c�lculos de data", "Erro 080", JOptionPane.ERROR_MESSAGE);
        }
        
        return novaDataString;
    } 
    
    
}