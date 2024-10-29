
package model;

import java.util.Objects;


public class ContaCaixa extends Entidades{

    public ContaCaixa(String descricao, String dataCadastro) {
        super(descricao, dataCadastro);
    }

    public ContaCaixa(String descricao, String dataCadastro, int codigo) {
        super(descricao, dataCadastro, codigo);
    }

    public ContaCaixa(String descricao, int codigo) {
        super(descricao, codigo);
    }

    public ContaCaixa() {
    }
    

}
