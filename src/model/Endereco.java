
package model;

import java.util.Objects;


public class Endereco {
    private String logradouro;
    private int numero;
    private String cep;
    private String bairro;
    private String localidade;
    private String uf;
    private String complemento;

    public Endereco() {
    }

    public Endereco(String logradouro, int numero, String cep, String bairro, String cidade, String estado, String complemento) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.localidade = cidade;
        this.uf = estado;
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getCep() {
        return cep;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.logradouro);
        hash = 23 * hash + this.numero;
        hash = 23 * hash + Objects.hashCode(this.cep);
        hash = 23 * hash + Objects.hashCode(this.bairro);
        hash = 23 * hash + Objects.hashCode(this.localidade);
        hash = 23 * hash + Objects.hashCode(this.uf);
        hash = 23 * hash + Objects.hashCode(this.complemento);
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
        final Endereco other = (Endereco) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.logradouro, other.logradouro)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.localidade, other.localidade)) {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        return Objects.equals(this.complemento, other.complemento);
    }

    @Override
    public String toString() {
        return "Endereco{" + "logradouro=" + logradouro + ", numero=" + numero + ", cep=" + cep + ", bairro=" + bairro + ", cidade=" + localidade + ", estado=" + uf + ", complemento=" + complemento + '}';
    }   
    
}
