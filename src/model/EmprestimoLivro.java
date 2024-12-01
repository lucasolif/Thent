
package model;

import java.util.Date;
import java.util.List;
import java.util.Objects;


public class EmprestimoLivro {
    
    private Integer codigoInternoEmprestimo;
    private Integer codigoEmprestimo;
    private Pessoa pessoa;
    private List<Livro> listaLivro;
    private Livro livro;
    private Biblioteca biblioteca;
    private String StatusEmprestimo;
    private String descricaoStatus;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public EmprestimoLivro() {
    }

    public Integer getCodigoEmprestimo() {
        return codigoEmprestimo;
    }

    public void setCodigoEmprestimo(Integer codigoEmprestimo) {
        this.codigoEmprestimo = codigoEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public String getDescricaoStatus() {
        return descricaoStatus;
    }

    public void setDescricaoStatus(String descricaoStatus) {
        this.descricaoStatus = descricaoStatus;
    }
    
    public Integer getCodigoInternoEmprestimo() {
        return codigoInternoEmprestimo;
    }

    public void setCodigoInternoEmprestimo(Integer codigoInternoEmprestimo) {
        this.codigoInternoEmprestimo = codigoInternoEmprestimo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Livro> getListaLivro() {
        return listaLivro;
    }

    public void setListaLivro(List<Livro> listaLivro) {
        this.listaLivro = listaLivro;
    }
    
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String getStatusEmprestimo() {
        return StatusEmprestimo;
    }

    public void setStatusEmprestimo(String StatusEmprestimo) {
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
        hash = 37 * hash + Objects.hashCode(this.codigoInternoEmprestimo);
        hash = 37 * hash + Objects.hashCode(this.pessoa);
        hash = 37 * hash + Objects.hashCode(this.listaLivro);
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
        if (!Objects.equals(this.codigoInternoEmprestimo, other.codigoInternoEmprestimo)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.listaLivro, other.listaLivro)) {
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
