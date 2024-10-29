
package model;

import java.util.Objects;


public class SubContaResultado {
    private Integer codigo;
    private String descricao;
    private ContaResultado contaResultado;
    private String dataCadastro;

    public SubContaResultado() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ContaResultado getContaResultado() {
        return contaResultado;
    }

    public void setContaResultado(ContaResultado contaResultado) {
        this.contaResultado = contaResultado;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.codigo);
        hash = 67 * hash + Objects.hashCode(this.descricao);
        hash = 67 * hash + Objects.hashCode(this.contaResultado);
        hash = 67 * hash + Objects.hashCode(this.dataCadastro);
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
        final SubContaResultado other = (SubContaResultado) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.dataCadastro, other.dataCadastro)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return Objects.equals(this.contaResultado, other.contaResultado);
    }
    
    @Override
    public String toString() {
        return descricao;
    }
}
