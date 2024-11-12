
package model;

import java.util.Date;


public class FormaPagto extends Entidades{

    public FormaPagto(String descricao, Date dataCadastro, Integer codigo) {
        super(descricao, dataCadastro, codigo);
    }

    public FormaPagto(String descricao, Integer codigo) {
        super(descricao, codigo);
    }

    public FormaPagto() {
    }

    
}
