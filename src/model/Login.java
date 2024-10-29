
package model;

import java.util.Objects;

public class Login {
    private Integer codUsuario;
    private String usuario;
    private String hashSenha;
    private String saltSenha;

    public Login() {
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codUsuario);
        hash = 79 * hash + Objects.hashCode(this.usuario);
        hash = 79 * hash + Objects.hashCode(this.hashSenha);
        hash = 79 * hash + Objects.hashCode(this.saltSenha);
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
        final Login other = (Login) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.hashSenha, other.hashSenha)) {
            return false;
        }
        if (!Objects.equals(this.saltSenha, other.saltSenha)) {
            return false;
        }
        return Objects.equals(this.codUsuario, other.codUsuario);
    }
      
    
}
