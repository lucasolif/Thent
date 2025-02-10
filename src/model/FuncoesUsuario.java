
package model;

import java.util.Date;


public class FuncoesUsuario extends Entidades{

    public FuncoesUsuario(String descricao, Date dataCadastro) {
        super(descricao, dataCadastro);
    }

    public FuncoesUsuario(String descricao, Date dataCadastro, Integer codigo) {
        super(descricao, dataCadastro, codigo);
    }

    public FuncoesUsuario(String descricao, Integer codigo) {
        super(descricao, codigo);
    }

    public FuncoesUsuario() {
    } 
    
}
