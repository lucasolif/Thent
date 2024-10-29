
package model;

import java.util.Objects;


public class Livro {
    
    private Integer codInterno; 
    private Integer codLivro;
    private Integer volume;
    private Integer anoPublicacao;
    private String nomeLivro;
    private Autor autor;
    private String caracteristica;
    private Editora editora;
    private String dataCadastro;
    private Integer status;

    public Livro() {
    }

    public Integer getCodInterno() {
        return codInterno;
    }

    public void setCodInterno(Integer codInterno) {
        this.codInterno = codInterno;
    }

    public Integer getCodLivro() {
        return codLivro;
    }

    public void setCodLivro(Integer codLivro) {
        this.codLivro = codLivro;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
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
        hash = 67 * hash + Objects.hashCode(this.codInterno);
        hash = 67 * hash + Objects.hashCode(this.codLivro);
        hash = 67 * hash + Objects.hashCode(this.volume);
        hash = 67 * hash + Objects.hashCode(this.anoPublicacao);
        hash = 67 * hash + Objects.hashCode(this.nomeLivro);
        hash = 67 * hash + Objects.hashCode(this.autor);
        hash = 67 * hash + Objects.hashCode(this.caracteristica);
        hash = 67 * hash + Objects.hashCode(this.editora);
        hash = 67 * hash + Objects.hashCode(this.dataCadastro);
        hash = 67 * hash + Objects.hashCode(this.status);
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
        final Livro other = (Livro) obj;
        if (!Objects.equals(this.nomeLivro, other.nomeLivro)) {
            return false;
        }
        if (!Objects.equals(this.caracteristica, other.caracteristica)) {
            return false;
        }
        if (!Objects.equals(this.dataCadastro, other.dataCadastro)) {
            return false;
        }
        if (!Objects.equals(this.codInterno, other.codInterno)) {
            return false;
        }
        if (!Objects.equals(this.codLivro, other.codLivro)) {
            return false;
        }
        if (!Objects.equals(this.volume, other.volume)) {
            return false;
        }
        if (!Objects.equals(this.anoPublicacao, other.anoPublicacao)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.editora, other.editora)) {
            return false;
        }
        return Objects.equals(this.status, other.status);
    }

    
    
    @Override
    public String toString() {
        return nomeLivro;
    }   
    
}
