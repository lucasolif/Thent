
package Ferramentas;

import dao.AplicacaoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingWorker;
import model.Aplicacao;


public class AgendadorTarefas {
    
    private Connection conexao = null;
    private ResultSet rs = null;
    private PreparedStatement stmSelect = null;
    private PreparedStatement stmInsert = null;
    private AplicacaoDao aplicacaoDao = new AplicacaoDao();
    
    public void executarTarefasDiarias(){
        
         // Criação do agendador para rodar a executarTarefasDiarias todos os dias (1 vez ao dia) as 02:30
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);      
        
        // Definir o horário de execução: 02:30
        LocalTime horaExecucao = LocalTime.of(2, 30); // 02:30
        
        // Pega o horário atual
        LocalDateTime agora = LocalDateTime.now();
        
        // Pega o próximo horário de execução (02:30 do próximo dia)
        LocalDateTime proximaExecucao = agora.with(horaExecucao).plusDays(agora.toLocalTime().isAfter(horaExecucao) ? 1 : 0);
        
        // Calcula o tempo até o próximo agendamento (em milissegundos)
        long delay = Duration.between(agora, proximaExecucao).toMillis();
        
        Runnable tarefa = new Runnable() {
            @Override
            public void run() {
                //Pega o dia atual
                LocalDate hoje = LocalDate.now();
                int diaAtual = hoje.getDayOfMonth();
                
                //Verifica se há alguma aplicação para ser calculada nesse dia
                List<Aplicacao> listaAplicacaoMensal = aplicacaoDao.totalRendimentoParaCalcularRendimentoMensal(diaAtual);
                List<Aplicacao> listaAplicacaoDiaria = aplicacaoDao.totalRendimentoParaCalcularRendimentoDiario();
                
                //Verifica se tem aplicação mensal para ser executada
                if(!listaAplicacaoMensal.isEmpty()){
                    // Chama a função que irá realizar o cálculo e salvar novamente os dados no banco de dados
                    tarefaAplicacaoBancariaMensal(listaAplicacaoMensal);
                }
           
                //Verifica se tem aplicação diária para ser executada
                if(!listaAplicacaoDiaria.isEmpty()){
                    // Chama a função que irá realizar o cálculo e salvar novamente os dados no banco de dados
                    tarefaAplicacaoBancariaDiaria(listaAplicacaoDiaria);
                }
            }
        };
        
        // Usando SwingWorker para rodar o agendador em segundo plano
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Agendar a execução da tarefa para o primeiro horário de execução (02:30)
                scheduler.scheduleAtFixedRate(tarefa, delay, TimeUnit.DAYS.toMillis(1), TimeUnit.MILLISECONDS);
                return null;
            }
        };

        worker.execute(); // Inicia o SwingWorker em segundo plano
       
    }
    
    private void tarefaAplicacaoBancariaMensal(List<Aplicacao> listaAplicacao) {
        
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
    
    private void tarefaAplicacaoBancariaDiaria(List<Aplicacao> listaAplicacao) {
        
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
        
        this.aplicacaoDao.inserirRendimentoMensalAutomatico(listaAplicacaoCalculada);
            
    }
}
