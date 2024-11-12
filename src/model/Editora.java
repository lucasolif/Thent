
package model;

import java.util.Date;


public class Editora extends Entidades{

    public Editora(String descricao, Date dataCadastro) {
        super(descricao, dataCadastro);
    }

    public Editora(String descricao, Date dataCadastro, Integer codigo) {
        super(descricao, dataCadastro, codigo);
    }

    public Editora(String descricao, Integer codigo) {
        super(descricao, codigo);
    }

    public Editora() {
    }

}
