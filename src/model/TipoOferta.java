
package model;

import java.util.Objects;

public class TipoOferta extends Entidades{

    public TipoOferta(String descricao, String dataCadastro) {
        super(descricao, dataCadastro);
    }

    public TipoOferta(String descricao, String dataCadastro, Integer codigo) {
        super(descricao, dataCadastro, codigo);
    }

    public TipoOferta(String descricao, Integer codigo) {
        super(descricao, codigo);
    }
    
    public TipoOferta() {
    }

}
