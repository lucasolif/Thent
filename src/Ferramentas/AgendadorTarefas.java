
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
        
         // Cria��o do agendador para rodar a executarTarefasDiarias todos os dias (1 vez ao dia) as 02:30
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);      
        
        // Definir o hor�rio de execu��o: 02:30
        LocalTime horaExecucao = LocalTime.of(2, 30); // 02:30
        
        // Pega o hor�rio atual
        LocalDateTime agora = LocalDateTime.now();
        
        // Pega o pr�ximo hor�rio de execu��o (02:30 do pr�ximo dia)
        LocalDateTime proximaExecucao = agora.with(horaExecucao).plusDays(agora.toLocalTime().isAfter(horaExecucao) ? 1 : 0);
        
        // Calcula o tempo at� o pr�ximo agendamento (em milissegundos)
        long delay = Duration.between(agora, proximaExecucao).toMillis();
        
        Runnable tarefa = new Runnable() {
            @Override
            public void run() {
                //Pega o dia atual
                LocalDate hoje = LocalDate.now();
                int diaAtual = hoje.getDayOfMonth();
                
                //Verifica se h� alguma aplica��o para ser calculada nesse dia
                List<Aplicacao> listaAplicacaoMensal = aplicacaoDao.totalRendimentoParaCalcularRendimentoMensal(diaAtual);
                List<Aplicacao> listaAplicacaoDiaria = aplicacaoDao.totalRendimentoParaCalcularRendimentoDiario();
                
                //Verifica se tem aplica��o mensal para ser executada
                if(!listaAplicacaoMensal.isEmpty()){
                    // Chama a fun��o que ir� realizar o c�lculo e salvar novamente os dados no banco de dados
                    tarefaAplicacaoBancariaMensal(listaAplicacaoMensal);
                }
           
                //Verifica se tem aplica��o di�ria para ser executada
                if(!listaAplicacaoDiaria.isEmpty()){
                    // Chama a fun��o que ir� realizar o c�lculo e salvar novamente os dados no banco de dados
                    tarefaAplicacaoBancariaDiaria(listaAplicacaoDiaria);
                }
            }
        };
        
        // Usando SwingWorker para rodar o agendador em segundo plano
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Agendar a execu��o da tarefa para o primeiro hor�rio de execu��o (02:30)
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
