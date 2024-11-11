
package ferramentas;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Conversores{
     
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
            // Lançando uma exceção se a string estiver em um formato inválido
            throw new IllegalArgumentException("Erro ao tentar converte Date em String", e);
        }
    }
    
    public Date convertendoStringDateSql(String data) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            // Converte a string para LocalDate
            LocalDate localDate = LocalDate.parse(data, formatoData);

            // Converte LocalDate para java.sql.Date, usando o método from() e Instant
            return java.sql.Date.valueOf(localDate);
        } catch (DateTimeParseException e) {
            // Lançando uma exceção se a string estiver em um formato inválido
            throw new IllegalArgumentException("Erro ao tentar converter String em Date", e);
        }
    }
    
    public Integer validarStringNula(String valor){
        // Verifica se a string é nula ou vazia
        if (valor == null || valor.trim().isEmpty()) {
            return null;  
        }

        try {
            // Tenta converter a string para um Integer
            return Integer.parseInt(valor.trim());
        } catch (NumberFormatException e) {
            // Trata o erro de formato e retorna null ou valor padrão
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
    
}
