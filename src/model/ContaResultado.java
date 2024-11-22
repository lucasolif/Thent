
package model;

import java.util.Date;


public class ContaResultado extends Entidades{

    private String tipoReceitaDespesa;
    
    public ContaResultado(){
        
    }

    public ContaResultado(String tipoContaResultado, String descricao, Date dataCadastro) {
        super(descricao, dataCadastro);
        this.tipoReceitaDespesa = tipoContaResultado;
    }

    public ContaResultado(String tipoContaResultado, String descricao, Date dataCadastro, Integer codigo) {
        super(descricao, dataCadastro, codigo);
        this.tipoReceitaDespesa = tipoContaResultado;
    }

    public ContaResultado(String tipoContaResultado, String descricao, Integer codigo) {
        super(descricao, codigo);
        this.tipoReceitaDespesa = tipoContaResultado;
    }

    public ContaResultado(String tipoContaResultado) {
        this.tipoReceitaDespesa = tipoContaResultado;
    }

    public String getTipoReceitaDespesa() {
        return tipoReceitaDespesa;
    }

    public void setTipoReceitaDespesa(String tipoReceitaDespesa) {
        this.tipoReceitaDespesa = tipoReceitaDespesa;
    }    
    
}
