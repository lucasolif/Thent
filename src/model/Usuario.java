
package model;

import java.util.Objects;

public class Usuario {
    private Integer codigo; 
    private Integer ativo;
    private Igreja igreja;
    private String login; 
    private String nome;
    private String email;
    private String celular;
    private String hashSenha;
    private String saltSenha;
    private FuncoesUsuario funcaoCargo;
    private Integer todasIgrejas;
    

    public Usuario() {
    }

    public Integer getTodasIgrejas() {
        return todasIgrejas;
    }

    public void setTodasIgrejas(Integer todasIgrejas) {
        this.todasIgrejas = todasIgrejas;
    }
    
    public FuncoesUsuario getFuncaoCargo() {
        return funcaoCargo;
    }

    public void setFuncaoCargo(FuncoesUsuario funcaoCargo) {
        this.funcaoCargo = funcaoCargo;
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

    public Igreja getIgreja() {
        return igreja;
    }

    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(String hashSenha) {
        this.hashSenha = hashSenha;
    }

    public String getSaltSenha() {
        return saltSenha;
    }

    public void setSaltSenha(String saltSenha) {
        this.saltSenha = saltSenha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.codigo);
        hash = 47 * hash + Objects.hashCode(this.ativo);
        hash = 47 * hash + Objects.hashCode(this.igreja);
        hash = 47 * hash + Objects.hashCode(this.login);
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Objects.hashCode(this.email);
        hash = 47 * hash + Objects.hashCode(this.celular);
        hash = 47 * hash + Objects.hashCode(this.hashSenha);
        hash = 47 * hash + Objects.hashCode(this.saltSenha);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.celular, other.celular)) {
            return false;
        }
        if (!Objects.equals(this.hashSenha, other.hashSenha)) {
            return false;
        }
        if (!Objects.equals(this.saltSenha, other.saltSenha)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.ativo, other.ativo)) {
            return false;
        }
        return Objects.equals(this.igreja, other.igreja);
    }

    @Override
    public String toString() {
        return login;
    }
 
}
