
package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexao {
   
    private static BasicDataSource dataSource;

    //Inicializando a conexão com o banco de dados
    public static boolean inicializandoBancoDados(Configuracao config) {
        
        boolean conectado = false;
        
        if(dataSource == null){
            dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:sqlserver://"+config.getServidor()+";databaseName="+config.getBancoDados()+";user="+config.getLogin()+";password="+config.getSenha()+";encrypt=true;trustServerCertificate=true");
            dataSource.setUsername(config.getLogin());
            dataSource.setPassword(config.getSenha());

            // Configurações adicionais do pool
            dataSource.setInitialSize(20); // Número inicial de conexões no pool
            dataSource.setMaxTotal(50);    // Número máximo de conexões no pool
            dataSource.setMinIdle(5);      // Número mínimo de conexões ociosas no pool
            dataSource.setMaxIdle(10);     // Número máximo de conexões ociosas no pool
            dataSource.setMaxWaitMillis(10000); // Tempo máximo de espera por uma conexão
        }
        
        // Valida a conexão com o banco de dados
        try (Connection conn = dataSource.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                conectado = true;
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao tentar estabelecer a conexão com o banco de dados.", "Concluído", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao tentar estabelecer a conexão com o banco de dados.", "Concluído", JOptionPane.ERROR_MESSAGE);
        }
        return conectado;

    }

    //Usa a conexão
    public static synchronized BasicDataSource getDataSource() {
        if (dataSource == null) {
            throw new IllegalStateException("DataSource não foi inicializado.");
        }
        return dataSource;
    }
    
    //Fecha a conexão
    public void closeDataSource() {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }    
}
