
package api.viaCep;

import com.google.gson.Gson;
import dao.LogsDao;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.JOptionPane;
import model.Endereco;

public class ViaCep {
    
    private final LogsDao logsDao = new LogsDao();
    
    // Método que busca o endereço pelo CEP e retorna um objeto Endereco
    public Endereco buscarEnderecoPorCep(String cep) {
        // Monta a URL da requisição para a API ViaCEP
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            // Cria o HttpClient para fazer a requisição HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Cria a requisição HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            // Envia a requisição e obtém a resposta como String
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Se a resposta for válida, converte para um objeto Endereco usando o Gson
            if (response.statusCode() == 200) {
                Gson gson = new Gson(); // Instancia o Gson para conversão
                Endereco endereco = gson.fromJson(response.body(), Endereco.class); // Mapeia o JSON para a classe Endereco
                System.out.println("Resposta JSON: " + response.body());
                return endereco;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao buscar o CEP - "+response.statusCode(), "Atenção", JOptionPane.WARNING_MESSAGE);
                logsDao.gravaLogsErro("ViaCep - "+response.statusCode());
            }
        } catch (Exception ex) {           
            JOptionPane.showMessageDialog(null, "Erro ao realizar a requisição", "Atenção", JOptionPane.WARNING_MESSAGE);
            logsDao.gravaLogsErro("ViaCep - "+ex.getMessage());
        }

        return null; // Retorna null caso haja algum erro ou se o CEP não for encontrado
    }
}
