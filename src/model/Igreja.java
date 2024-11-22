
package model;

import java.util.Date;
import java.util.Objects;

public class Igreja extends Entidades{

    private Endereco endereco;
    private Integer status;

    public Igreja() {
    }

    public Igreja(Endereco endereco, String descricao, Integer codigo) {
        super(descricao, codigo);
        this.endereco = endereco;
    }

    public Igreja(Integer codigo, String descricao, Date dataCadastro, Endereco endereco) {
        super(descricao, dataCadastro, codigo);
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.endereco);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Igreja other = (Igreja) obj;
        return Objects.equals(this.endereco, other.endereco);
    }

}
