
package model;

import java.util.Date;
import java.util.Objects;


public class EmprestimoLivro {
    
    private Integer codigo;
    private Pessoa pessoa;
    private Livro livro;
    private Biblioteca biblioteca;
    private Integer StatusEmprestimo;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public EmprestimoLivro() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Integer getStatusEmprestimo() {
        return StatusEmprestimo;
    }

    public void setStatusEmprestimo(Integer StatusEmprestimo) {
        this.StatusEmprestimo = StatusEmprestimo;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.codigo);
        hash = 37 * hash + Objects.hashCode(this.pessoa);
        hash = 37 * hash + Objects.hashCode(this.livro);
        hash = 37 * hash + Objects.hashCode(this.biblioteca);
        hash = 37 * hash + Objects.hashCode(this.StatusEmprestimo);
        hash = 37 * hash + Objects.hashCode(this.dataEmprestimo);
        hash = 37 * hash + Objects.hashCode(this.dataDevolucao);
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
        final EmprestimoLivro other = (EmprestimoLivro) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.livro, other.livro)) {
            return false;
        }
        if (!Objects.equals(this.biblioteca, other.biblioteca)) {
            return false;
        }
        if (!Objects.equals(this.StatusEmprestimo, other.StatusEmprestimo)) {
            return false;
        }
        if (!Objects.equals(this.dataEmprestimo, other.dataEmprestimo)) {
            return false;
        }
        return Objects.equals(this.dataDevolucao, other.dataDevolucao);
    }

}
