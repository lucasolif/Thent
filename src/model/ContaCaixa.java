
package model;

import java.util.Date;


public class ContaCaixa extends Entidades{
    
    Integer constaRelatorio;

    public Integer getConstaRelatorio() {
        return constaRelatorio;
    }

    public void setConstaRelatorio(Integer constaRelatorio) {
        this.constaRelatorio = constaRelatorio;
    }

    public ContaCaixa(String descricao, Date dataCadastro) {
        super(descricao, dataCadastro);
    }

    public ContaCaixa(String descricao, Date dataCadastro, Integer codigo) {
        super(descricao, dataCadastro, codigo);
    }

    public ContaCaixa(String descricao, Integer codigo) {
        super(descricao, codigo);
    }

    public ContaCaixa() {
    }
}
