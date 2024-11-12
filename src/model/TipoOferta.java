
package model;

import java.util.Date;
import java.util.Objects;

public class TipoOferta extends Entidades{

    public TipoOferta(String descricao, Date dataCadastro) {
        super(descricao, dataCadastro);
    }

    public TipoOferta(String descricao, Date dataCadastro, Integer codigo) {
        super(descricao, dataCadastro, codigo);
    }

    public TipoOferta(String descricao, Integer codigo) {
        super(descricao, codigo);
    }
    
    public TipoOferta() {
    }

}
