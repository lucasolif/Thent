
package model;

import java.util.Objects;


public class Pessoa {
    
    private String nome, cpfCnpj, dataNascimento, rg, celular, email, sexo; 
    private Igreja igreja;
    private Endereco endereco;
    private Integer codigo, ativo;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpfCnpj, String dataNascimento, String rg, String celular, String email, String sexo, Igreja igreja, Endereco endereco, Integer ativo) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.celular = celular;
        this.email = email;
        this.sexo = sexo;
        this.igreja = igreja;
        this.endereco = endereco;
        this.ativo = ativo;
    }
    
    public Pessoa(String nome, String cpfCnpj, String dataNascimento, String rg, String celular, String email, String sexo, Igreja igreja, Endereco endereco, Integer codigo, Integer ativo) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.celular = celular;
        this.email = email;
        this.sexo = sexo;
        this.igreja = igreja;
        this.endereco = endereco;
        this.codigo = codigo;
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Igreja getIgreja() {
        return igreja;
    }

    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.nome);
        hash = 13 * hash + Objects.hashCode(this.cpfCnpj);
        hash = 13 * hash + Objects.hashCode(this.dataNascimento);
        hash = 13 * hash + Objects.hashCode(this.rg);
        hash = 13 * hash + Objects.hashCode(this.celular);
        hash = 13 * hash + Objects.hashCode(this.email);
        hash = 13 * hash + Objects.hashCode(this.sexo);
        hash = 13 * hash + Objects.hashCode(this.igreja);
        hash = 13 * hash + Objects.hashCode(this.endereco);
        hash = 13 * hash + Objects.hashCode(this.codigo);
        hash = 13 * hash + Objects.hashCode(this.ativo);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpfCnpj, other.cpfCnpj)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.celular, other.celular)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.igreja, other.igreja)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return Objects.equals(this.ativo, other.ativo);
    }

    
    @Override
    public String toString() {
        return nome;
    }

}
