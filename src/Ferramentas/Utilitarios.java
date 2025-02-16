
package Ferramentas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Utilitarios{
     
    //Arredondando o valor para cima se for maior que 0.5 e para baixo se for menos que 0.5
    public double arrendodarValores(double valor){
        BigDecimal bd = new BigDecimal(valor).setScale(2, RoundingMode.HALF_DOWN); 
        double novoValorArredondado = bd.doubleValue();
        
        return novoValorArredondado;
    }
    
    public Integer formatarValores(double valor, int qtdCasasDecimais){
        DecimalFormat df = new DecimalFormat();
        
        if(qtdCasasDecimais == 0){
            df = new DecimalFormat("0");
        }

        String numeroFormatado = df.format(valor);
        
        return Integer.valueOf(numeroFormatado);
    }
    
    public String formatarDoubleString(double valor){
         return String.format("%.2f", valor);
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
    
    public String anoAtual(){
        int ano = LocalDate.now().getYear();
        String anoAtual = String.valueOf(ano);
        
        return anoAtual;
    }
    
    public String mesAnterior(){
        // Obter o mês anterior
        LocalDate dataAnterior = LocalDate.now().minusMonths(1);
        
        // Definir o formato para o nome do mês
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM");
        
        // Obter o nome do mês anterior como String
        String nomeMesAnterior = dataAnterior.format(formatter);
          
        return nomeMesAnterior;
    }
    
    public Integer obterNumMes(String nomeMes){
        
        // Criar o mapa de meses
        Map<String, Integer> meses = new HashMap<>();
        meses.put("Janeiro", 1);
        meses.put("Fevereiro", 2);
        meses.put("Março", 3);
        meses.put("Abril", 4);
        meses.put("Maio", 5);
        meses.put("Junho", 6);
        meses.put("Julho", 7);
        meses.put("Agosto", 8);
        meses.put("Setembro", 9);
        meses.put("Outubro", 10);
        meses.put("Novembro", 11);
        meses.put("Dezembro", 12);
        
        Integer numMes = meses.get(nomeMes);
        
        return numMes;
        
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
    
    public String somarDatas(String data, Integer meses){
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String novaDataString = null;
        
        // A string que representa a data
        
        try {
            // Converter a string para o tipo LocalDate
            LocalDate date = LocalDate.parse(data, formato);
            
            // Adicionar um mês à data
            LocalDate newDate = date.plus(Period.ofMonths(meses));
            
            // Converte a nova data de volta para string
            novaDataString = newDate.format(formato);
            
        } catch (DateTimeParseException e) {
            // Lidar com possíveis erros de parsing
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar os cálculos de data", "Erro 080", JOptionPane.ERROR_MESSAGE);
        }
        
        return novaDataString;
    } 
    
    public int diferencaDatas(String primeiraData, String segundaData){
        // Definindo o formato de data (dd/MM/yyyy)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Convertendo as strings para LocalDate
        LocalDate dataInicial = LocalDate.parse(primeiraData, formatter);
        LocalDate dataFinal = LocalDate.parse(segundaData, formatter);

        // Calculando a diferença em meses
        int meses = (int) ChronoUnit.MONTHS.between(dataInicial, dataFinal);

        return meses;
    }
    
    public Integer compararDataComDataAtual(String vencimento){
        
        Integer valor = null;
        
        try {           
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            Date dtAtual = sdf.parse(dataAtualString());
            Date dtVencimento = sdf.parse(vencimento);

            if (dtVencimento.compareTo(dtAtual) < 0) {
                valor = 1; //Nesse caso a data de vencimento é menor que a data atual, ou seja, ja venceu
            } else if (dtVencimento.compareTo(dtAtual) == 0) {
                valor = 2; //Nesse caso as data são iguais, logo, vence hoje
            } else {
                valor = 3; // O vencimento é maior que a data atual, ou seja, não venceu
            }

        }catch (ParseException ex) {
            
        }
        
        return valor;
    }
}
