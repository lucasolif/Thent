
package model;

import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Campanha {
    private Integer codigo;
    private Pessoa responsável;
    private TipoCampanha tipoCampanha;
    private String descricaoCampanha;
    private Igreja igreja;
    private Integer tempoMeses;
    private Date dataInicial;
    private Date dataFinal;
    private Date dataLimitePagamento;
    private String observacao;
    private List<Pessoa> membro;
    private double valorTotalCampanha;
    private Integer statusCapamnha;

    public Campanha() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Pessoa getResponsável() {
        return responsável;
    }

    public void setResponsável(Pessoa responsável) {
        this.responsável = responsável;
    }

    public TipoCampanha getTipoCampanha() {
        return tipoCampanha;
    }

    public void setTipoCampanha(TipoCampanha tipoCampanha) {
        this.tipoCampanha = tipoCampanha;
    }

    public String getDescricaoCampanha() {
        return descricaoCampanha;
    }

    public void setDescricaoCampanha(String descricaoCampanha) {
        this.descricaoCampanha = descricaoCampanha;
    }

    public Igreja getIgreja() {
        return igreja;
    }

    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
    }

    public Integer getTempoMeses() {
        return tempoMeses;
    }

    public void setTempoMeses(Integer tempoMeses) {
        this.tempoMeses = tempoMeses;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Pessoa> getMembro() {
        return membro;
    }

    public void setMembro(List<Pessoa> membro) {
        this.membro = membro;
    }

    public double getValorTotalCampanha() {
        return valorTotalCampanha;
    }

    public void setValorTotalCampanha(double valorTotalCampanha) {
        this.valorTotalCampanha = valorTotalCampanha;
    }

    public Integer getStatusCapamnha() {
        return statusCapamnha;
    }

    public void setStatusCapamnha(Integer statusCapamnha) {
        this.statusCapamnha = statusCapamnha;
    }

    public Date getDataLimitePagamento() {
        return dataLimitePagamento;
    }

    public void setDataLimitePagamento(Date dataLimitePagamento) {
        this.dataLimitePagamento = dataLimitePagamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.codigo);
        hash = 29 * hash + Objects.hashCode(this.responsável);
        hash = 29 * hash + Objects.hashCode(this.tipoCampanha);
        hash = 29 * hash + Objects.hashCode(this.descricaoCampanha);
        hash = 29 * hash + Objects.hashCode(this.igreja);
        hash = 29 * hash + Objects.hashCode(this.tempoMeses);
        hash = 29 * hash + Objects.hashCode(this.dataInicial);
        hash = 29 * hash + Objects.hashCode(this.dataFinal);
        hash = 29 * hash + Objects.hashCode(this.dataLimitePagamento);
        hash = 29 * hash + Objects.hashCode(this.observacao);
        hash = 29 * hash + Objects.hashCode(this.membro);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.valorTotalCampanha) ^ (Double.doubleToLongBits(this.valorTotalCampanha) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.statusCapamnha);
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
        final Campanha other = (Campanha) obj;
        if (Double.doubleToLongBits(this.valorTotalCampanha) != Double.doubleToLongBits(other.valorTotalCampanha)) {
            return false;
        }
        if (!Objects.equals(this.descricaoCampanha, other.descricaoCampanha)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.responsável, other.responsável)) {
            return false;
        }
        if (!Objects.equals(this.tipoCampanha, other.tipoCampanha)) {
            return false;
        }
        if (!Objects.equals(this.igreja, other.igreja)) {
            return false;
        }
        if (!Objects.equals(this.tempoMeses, other.tempoMeses)) {
            return false;
        }
        if (!Objects.equals(this.dataInicial, other.dataInicial)) {
            return false;
        }
        if (!Objects.equals(this.dataFinal, other.dataFinal)) {
            return false;
        }
        if (!Objects.equals(this.dataLimitePagamento, other.dataLimitePagamento)) {
            return false;
        }
        if (!Objects.equals(this.membro, other.membro)) {
            return false;
        }
        return Objects.equals(this.statusCapamnha, other.statusCapamnha);
    }
    
    
    
    @Override
    public String toString() {
        return  descricaoCampanha;
    }

}
