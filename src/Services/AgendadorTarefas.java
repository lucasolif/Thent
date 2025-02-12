
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
        
         // Criação do agendador para rodar a executarTarefasDiarias todos os dias (1 vez ao dia)
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);       
        
        Runnable tarefa = new Runnable() {
            @Override
            public void run() {
                //Pega o dia atual
                LocalDate hoje = LocalDate.now();
                int diaAtual = hoje.getDayOfMonth();
                
                //Verifica se há alguma aplicação para ser calculada nesse dia
                List<Aplicacao> listaAplicacao = aplicacaoDao.totalRendimentoParaCalcularRendimentoMensal(diaAtual);
                
                if(!listaAplicacao.isEmpty()){
                    // Chama a função que irá realizar o cálculo e salvar novamente os dados no banco de dados
                    tarefaAplicacaoBancaria(listaAplicacao);
                }
            }
        };
        
        // Agendar a execução da executarTarefasDiarias todos os dias (24 horas)
        scheduler.scheduleAtFixedRate(tarefa, 0, 24, TimeUnit.HOURS);
    }
    
    public void executarTarefasDiariaVerificaDia(int diaDoMes) {
        
        int hora = 02;
        int minuto = 30;
        
        // Criação do agendador para rodar a tarefa todos os dias
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable tarefa = new Runnable() {
            @Override
            public void run() {
                Calendar hoje = Calendar.getInstance();
                int diaAtual = hoje.get(Calendar.DAY_OF_MONTH);

                // Verifica se hoje é o dia de execução especificado
                if (diaAtual == diaDoMes) {
                    // Define o horário fixo para a execução
                    hoje.set(Calendar.HOUR_OF_DAY, hora);
                    hoje.set(Calendar.MINUTE, minuto);
                    hoje.set(Calendar.SECOND, 0);
                    hoje.set(Calendar.MILLISECOND, 0);

                    // Verifica se já passou do horário de execução, caso sim, agenda para o próximo mês
                    long tempoParaExecucao = hoje.getTimeInMillis() - System.currentTimeMillis();
                    if (tempoParaExecucao <= 0) {
                        // Se o horário já passou, agendar para o próximo mês
                        hoje.add(Calendar.MONTH, 1);
                        tempoParaExecucao = hoje.getTimeInMillis() - System.currentTimeMillis();
                    }

                    // Agendar a tarefa para o horário fixo
                    //scheduler.schedule(() -> //Função que irá executar a tarefa, tempoParaExecucao, TimeUnit.MILLISECONDS);
                }
            }
        };

        // Agendar a execução da tarefa para rodar todos os dias
        scheduler.scheduleAtFixedRate(tarefa, 0, 1, TimeUnit.DAYS);
    }

    
    
    public void executarTarefasMensalDiaEspecifico(int diaDoMes) {
        
        int hora = 02;
        int minuto = 30;
        // Criação do agendador para rodar a tarefa no dia e horário especificado
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable tarefa = new Runnable() {
            @Override
            public void run() {
                // Chama a função que irá consultar o banco, realizar o cálculo e salvar novamente os dados no banco de dados
                //tarefaAplicacaoBancaria();
            }
        };

        // Agendar a execução da tarefa no próximo dia do mês e no horário especificado
        scheduler.schedule(() -> {
            Calendar agora = Calendar.getInstance();
            int hojeDia = agora.get(Calendar.DAY_OF_MONTH);

            // Calcular a diferença entre o dia atual e o dia de execução
            int diasParaExecucao = diaDoMes - hojeDia;
            
            // Se o dia já passou neste mês, agendar para o próximo mês
            if (diasParaExecucao < 0) {
                agora.add(Calendar.MONTH, 1);
                agora.set(Calendar.DAY_OF_MONTH, diaDoMes);
                diasParaExecucao = agora.get(Calendar.DAY_OF_YEAR) - Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
            } else {
                agora.set(Calendar.DAY_OF_MONTH, diaDoMes);
            }

            // Definir a hora e o minuto exatos da execução
            agora.set(Calendar.HOUR_OF_DAY, hora);
            agora.set(Calendar.MINUTE, minuto);
            agora.set(Calendar.SECOND, 0);
            agora.set(Calendar.MILLISECOND, 0);

            // Calcular a diferença em milissegundos até o horário de execução
            long tempoParaExecucao = agora.getTimeInMillis() - System.currentTimeMillis();

            // Se o tempo de execução for negativo (o horário já passou hoje), agendar para o próximo mês
            if (tempoParaExecucao < 0) {
                agora.add(Calendar.MONTH, 1);
                tempoParaExecucao = agora.getTimeInMillis() - System.currentTimeMillis();
            }

            // Agendar a execução da tarefa para o horário calculado
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
