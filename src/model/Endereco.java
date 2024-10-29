
package model;

import java.util.Objects;


public class Endereco {
    private String logradouro;
    private int numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;

    public Endereco() {
    }

    public Endereco(String logradouro, int numero, String cep, String bairro, String cidade, String estado, String complemento) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
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

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
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

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash = 23 * hash + Objects.hashCode(this.cidade);
        hash = 23 * hash + Objects.hashCode(this.estado);
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
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return Objects.equals(this.complemento, other.complemento);
    }

    @Override
    public String toString() {
        return "Endereco{" + "logradouro=" + logradouro + ", numero=" + numero + ", cep=" + cep + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", complemento=" + complemento + '}';
    }   
    
}
