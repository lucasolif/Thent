
package model;

import java.util.Date;
import java.util.Objects;

public class TipoCampanha extends Entidades{
    
    private Integer status;

    public TipoCampanha(String descricao, Date dataCadastro) {
        super(descricao, dataCadastro);
    }

    public TipoCampanha(String descricao, Date dataCadastro, Integer codigo) {
        super(descricao, dataCadastro, codigo);
    }

    public TipoCampanha(String descricao, Integer codigo) {
        super(descricao, codigo);
    }

    public TipoCampanha() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.status);
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
        final TipoCampanha other = (TipoCampanha) obj;
        return Objects.equals(this.status, other.status);
    }

}
