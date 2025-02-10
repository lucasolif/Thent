
package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import jdbc.Conexao;


public class AgendadorTarefas {
    
    private Connection conexao = null;
    private ResultSet rs = null;
    private PreparedStatement stmSelect = null;
    private PreparedStatement stmInsert = null;
    
    public void executarTarefasDiarias(){
        
         // Criação do agendador para rodar a executarTarefasDiarias todos os dias (1 vez ao dia)
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        Runnable tarefa = new Runnable() {
            @Override
            public void run() {
                // Chama a função que irá consultar o banco, realizar o cálculo e salvar novamente os dados no banco de dados
                tarefaAplicacaoBancaria();
            }
        };
        
        // Agendar a execução da executarTarefasDiarias todos os dias (24 horas)
        scheduler.scheduleAtFixedRate(tarefa, 0, 24, TimeUnit.HOURS);
    }
    
    
    private void tarefaAplicacaoBancaria() {
        
        try { 
            conexao = Conexao.getDataSource().getConnection();
            stmSelect = conexao.prepareStatement(sql);
            
            // Recebendo os dados da consulta
            if (rs.next()) {
                double valor1 = rs.getDouble("valor1");
                double valor2 = rs.getDouble("valor2");

                // Realize o cálculo necessário
                double resultado = valor1 + valor2;  // Exemplo simples, substitua conforme a sua lógica

                // Agora, insira o resultado de volta no banco
                String inserirSQL = "INSERT INTO resultados (resultado) VALUES (?)";
                try (PreparedStatement pstmt = connection.prepareStatement(inserirSQL)) {
                    pstmt.setDouble(1, resultado);
                    pstmt.executeUpdate();
                }
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o processo de cálculo diário das aplicações", "Erro 011", JOptionPane.ERROR_MESSAGE);
        }finally{
            // Fechar recursos
            try{
                if (rs != null) rs.close();
                if (stmSelect != null) stmSelect.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar fechar a conexão com o banco de dados", "Erro 012", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
