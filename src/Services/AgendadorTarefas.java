
package Services;

import dao.AplicacaoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import model.Aplicacao;


public class AgendadorTarefas {
    
    private Connection conexao = null;
    private ResultSet rs = null;
    private PreparedStatement stmSelect = null;
    private PreparedStatement stmInsert = null;
    private AplicacaoDao aplicacaoDao = new AplicacaoDao();
    
    public void executarTarefasDiarias(){
        
         // Cria��o do agendador para rodar a executarTarefasDiarias todos os dias (1 vez ao dia)
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);       
        
        Runnable tarefa = new Runnable() {
            @Override
            public void run() {
                //Pega o dia atual
                LocalDate hoje = LocalDate.now();
                int diaAtual = hoje.getDayOfMonth();
                
                //Verifica se h� alguma aplica��o para ser calculada nesse dia
                List<Aplicacao> listaAplicacao = aplicacaoDao.totalRendimentoParaCalcularRendimentoMensal(diaAtual);
                
                if(!listaAplicacao.isEmpty()){
                    // Chama a fun��o que ir� realizar o c�lculo e salvar novamente os dados no banco de dados
                    tarefaAplicacaoBancaria(listaAplicacao);
                }
            }
        };
        
        // Agendar a execu��o da executarTarefasDiarias todos os dias (24 horas)
        scheduler.scheduleAtFixedRate(tarefa, 0, 24, TimeUnit.HOURS);
    }
    
    public void executarTarefasDiariaVerificaDia(int diaDoMes) {
        
        int hora = 02;
        int minuto = 30;
        
        // Cria��o do agendador para rodar a tarefa todos os dias
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable tarefa = new Runnable() {
            @Override
            public void run() {
                Calendar hoje = Calendar.getInstance();
                int diaAtual = hoje.get(Calendar.DAY_OF_MONTH);

                // Verifica se hoje � o dia de execu��o especificado
                if (diaAtual == diaDoMes) {
                    // Define o hor�rio fixo para a execu��o
                    hoje.set(Calendar.HOUR_OF_DAY, hora);
                    hoje.set(Calendar.MINUTE, minuto);
                    hoje.set(Calendar.SECOND, 0);
                    hoje.set(Calendar.MILLISECOND, 0);

                    // Verifica se j� passou do hor�rio de execu��o, caso sim, agenda para o pr�ximo m�s
                    long tempoParaExecucao = hoje.getTimeInMillis() - System.currentTimeMillis();
                    if (tempoParaExecucao <= 0) {
                        // Se o hor�rio j� passou, agendar para o pr�ximo m�s
                        hoje.add(Calendar.MONTH, 1);
                        tempoParaExecucao = hoje.getTimeInMillis() - System.currentTimeMillis();
                    }

                    // Agendar a tarefa para o hor�rio fixo
                    //scheduler.schedule(() -> //Fun��o que ir� executar a tarefa, tempoParaExecucao, TimeUnit.MILLISECONDS);
                }
            }
        };

        // Agendar a execu��o da tarefa para rodar todos os dias
        scheduler.scheduleAtFixedRate(tarefa, 0, 1, TimeUnit.DAYS);
    }

    
    
    public void executarTarefasMensalDiaEspecifico(int diaDoMes) {
        
        int hora = 02;
        int minuto = 30;
        // Cria��o do agendador para rodar a tarefa no dia e hor�rio especificado
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable tarefa = new Runnable() {
            @Override
            public void run() {
                // Chama a fun��o que ir� consultar o banco, realizar o c�lculo e salvar novamente os dados no banco de dados
                //tarefaAplicacaoBancaria();
            }
        };

        // Agendar a execu��o da tarefa no pr�ximo dia do m�s e no hor�rio especificado
        scheduler.schedule(() -> {
            Calendar agora = Calendar.getInstance();
            int hojeDia = agora.get(Calendar.DAY_OF_MONTH);

            // Calcular a diferen�a entre o dia atual e o dia de execu��o
            int diasParaExecucao = diaDoMes - hojeDia;
            
            // Se o dia j� passou neste m�s, agendar para o pr�ximo m�s
            if (diasParaExecucao < 0) {
                agora.add(Calendar.MONTH, 1);
                agora.set(Calendar.DAY_OF_MONTH, diaDoMes);
                diasParaExecucao = agora.get(Calendar.DAY_OF_YEAR) - Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
            } else {
                agora.set(Calendar.DAY_OF_MONTH, diaDoMes);
            }

            // Definir a hora e o minuto exatos da execu��o
            agora.set(Calendar.HOUR_OF_DAY, hora);
            agora.set(Calendar.MINUTE, minuto);
            agora.set(Calendar.SECOND, 0);
            agora.set(Calendar.MILLISECOND, 0);

            // Calcular a diferen�a em milissegundos at� o hor�rio de execu��o
            long tempoParaExecucao = agora.getTimeInMillis() - System.currentTimeMillis();

            // Se o tempo de execu��o for negativo (o hor�rio j� passou hoje), agendar para o pr�ximo m�s
            if (tempoParaExecucao < 0) {
                agora.add(Calendar.MONTH, 1);
                tempoParaExecucao = agora.getTimeInMillis() - System.currentTimeMillis();
            }

            // Agendar a execu��o da tarefa para o hor�rio calculado
            scheduler.schedule(tarefa, tempoParaExecucao, TimeUnit.MILLISECONDS);
        }, 0, TimeUnit.DAYS);
    }
    
    private void tarefaAplicacaoBancaria(List<Aplicacao> listaAplicacao) {
        
        Aplicacao aplicacao = new Aplicacao();
        List<Aplicacao> listaAplicacaoCalculada = new ArrayList<>();
        
        for(Aplicacao aplic : listaAplicacao){
            
            double rendimento = aplic.getValorRendimento();
            double percentual = aplic.getPercentual()/100;
            
            double rendimentoMensal = rendimento * percentual;
            
            aplicacao.setCodigo(aplic.getCodigo());
            aplicacao.setValorRendimento(rendimentoMensal);
            
            listaAplicacaoCalculada.add(aplicacao);
            
        }
        
        aplicacaoDao.inserirRendimentoMensalAutomatico(listaAplicacaoCalculada);
            
    }
}
