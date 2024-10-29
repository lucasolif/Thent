
package model;


public class ContaResultado extends Entidades{

    private String tipoContaResultado;
    
    public ContaResultado(){
        
    }

    public ContaResultado(String tipoContaResultado, String descricao, String dataCadastro) {
        super(descricao, dataCadastro);
        this.tipoContaResultado = tipoContaResultado;
    }

    public ContaResultado(String tipoContaResultado, String descricao, String dataCadastro, Integer codigo) {
        super(descricao, dataCadastro, codigo);
        this.tipoContaResultado = tipoContaResultado;
    }

    public ContaResultado(String tipoContaResultado, String descricao, Integer codigo) {
        super(descricao, codigo);
        this.tipoContaResultado = tipoContaResultado;
    }

    public ContaResultado(String tipoContaResultado) {
        this.tipoContaResultado = tipoContaResultado;
    }

    public String getTipoContaResultado() {
        return tipoContaResultado;
    }

    public void setTipoContaResultado(String tipoContaResultado) {
        this.tipoContaResultado = tipoContaResultado;
    }
    
    
    
}
