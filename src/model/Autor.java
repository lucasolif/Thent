
package model;


public class Autor extends Entidades{

    public Autor(String descricao, String dataCadastro) {
        super(descricao, dataCadastro);
    }

    public Autor(String descricao, String dataCadastro, Integer codigo) {
        super(descricao, dataCadastro, codigo);
    }

    public Autor(String descricao, Integer codigo) {
        super(descricao, codigo);
    }

    public Autor() {
    }
    
}
