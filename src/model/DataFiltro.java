
package model;


public class DataFiltro {
    private String dataOfertaInicial;
    private String dataOfertaFinal;
    private String dataCadastroFinal;
    private String dataCadastroInicial;

    public DataFiltro() {
    }
    
    public DataFiltro(String dataOfertaInicial, String dataOfertaFinal, String dataCadastroFinal, String dataCadastroInicial) {
        this.dataOfertaInicial = dataOfertaInicial;
        this.dataOfertaFinal = dataOfertaFinal;
        this.dataCadastroFinal = dataCadastroFinal;
        this.dataCadastroInicial = dataCadastroInicial;
    }

    public String getDataOfertaInicial() {
        return dataOfertaInicial;
    }

    public String getDataOfertaFinal() {
        return dataOfertaFinal;
    }

    public String getDataCadastroFinal() {
        return dataCadastroFinal;
    }

    public String getDataCadastroInicial() {
        return dataCadastroInicial;
    }

    public void setDataOfertaInicial(String dataOfertaInicial) {
        this.dataOfertaInicial = dataOfertaInicial;
    }

    public void setDataOfertaFinal(String dataOfertaFinal) {
        this.dataOfertaFinal = dataOfertaFinal;
    }

    public void setDataCadastroFinal(String dataCadastroFinal) {
        this.dataCadastroFinal = dataCadastroFinal;
    }

    public void setDataCadastroInicial(String dataCadastroInicial) {
        this.dataCadastroInicial = dataCadastroInicial;
    }
    
    
}
