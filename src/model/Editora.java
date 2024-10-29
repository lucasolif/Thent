
package model;


public class Editora extends Entidades{

    public Editora(String descricao, String dataCadastro) {
        super(descricao, dataCadastro);
    }

    public Editora(String descricao, String dataCadastro, Integer codigo) {
        super(descricao, dataCadastro, codigo);
    }

    public Editora(String descricao, Integer codigo) {
        super(descricao, codigo);
    }

    public Editora() {
    }

}
