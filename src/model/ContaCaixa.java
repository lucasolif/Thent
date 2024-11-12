
package model;

import java.util.Date;

public class ContaCaixa extends Entidades{

    public ContaCaixa(String descricao, Date dataCadastro) {
        super(descricao, dataCadastro);
    }

    public ContaCaixa(String descricao, Date dataCadastro, int codigo) {
        super(descricao, dataCadastro, codigo);
    }

    public ContaCaixa(String descricao, int codigo) {
        super(descricao, codigo);
    }

    public ContaCaixa() {
    }
    

}
