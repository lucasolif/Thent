
package jdbc;


public class Configuracao {
    
    private String servidor;
    private String bancoDados;
    private String login;
    private String senha;

    public Configuracao(String servidor, String bancoDados, String login, String senha) {
        this.servidor = servidor;
        this.bancoDados = bancoDados;
        this.login = login;
        this.senha = senha;
    }

    public String getServidor() {
        return servidor;
    }

    public String getBancoDados() {
        return bancoDados;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public void setBancoDados(String bancoDados) {
        this.bancoDados = bancoDados;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
