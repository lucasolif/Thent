
package model;

import java.util.Date;


public class Autor extends Entidades{

    public Autor(String descricao, Date dataCadastro) {
        super(descricao, dataCadastro);
    }

    public Autor(String descricao, Date dataCadastro, Integer codigo) {
        super(descricao, dataCadastro, codigo);
    }

    public Autor(String descricao, Integer codigo) {
        super(descricao, codigo);
    }

    public Autor() {
    }
    
}
