
package model;

import java.util.Objects;

public class RegistroBiblioteca {
    
    private Integer codigo;
    private Biblioteca biblioteca;
    private Livro livro;
    private Integer qtdLivro;

    public RegistroBiblioteca() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Integer getQtdLivro() {
        return qtdLivro;
    }

    public void setQtdLivro(Integer qtdLivro) {
        this.qtdLivro = qtdLivro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.codigo);
        hash = 67 * hash + Objects.hashCode(this.biblioteca);
        hash = 67 * hash + Objects.hashCode(this.livro);
        hash = 67 * hash + Objects.hashCode(this.qtdLivro);
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
        final RegistroBiblioteca other = (RegistroBiblioteca) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.biblioteca, other.biblioteca)) {
            return false;
        }
        if (!Objects.equals(this.livro, other.livro)) {
            return false;
        }
        return Objects.equals(this.qtdLivro, other.qtdLivro);
    }

}
