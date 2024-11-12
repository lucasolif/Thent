
package model;

import java.util.Date;
import java.util.Objects;


public class Entidades {
    private String nome;
    private Date dataCadastro;
    private Integer codigo;

    public Entidades(String descricao, Date dataCadastro) {
        this.nome = descricao;
        this.dataCadastro = dataCadastro;
    }

    public Entidades(String descricao, Date dataCadastro, Integer codigo) {
        this.nome = descricao;
        this.dataCadastro = dataCadastro;
        this.codigo = codigo;
    }

    public Entidades(String descricao, Integer codigo) {
        this.nome = descricao;
        this.codigo = codigo;
    }

    public Entidades() {
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.nome);
        hash = 11 * hash + Objects.hashCode(this.dataCadastro);
        hash = 11 * hash + Objects.hashCode(this.codigo);
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
        final Entidades other = (Entidades) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.dataCadastro, other.dataCadastro)) {
            return false;
        }
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return nome;
    }

}
