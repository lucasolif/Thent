
package model;

import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Campanha {
    private Integer codigo;
    private String descricaoCampanha;
    private Igreja igreja;
    private Integer duracaoMeses;
    private Date dataInicial;
    private Date dataFinal;
    private Integer diaPagamento;
    private String observacao;
    private List<Pessoa> participante;
    private List<ContasReceberCampanha> listaCrCampanha;
    private double valorTotalCampanha;
    private Integer statusCampanha;
    private String descricaoStatus;
    private Date dataCadastro;

    public Campanha() {
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDescricaoStatus() {
        return descricaoStatus;
    }

    public void setDescricaoStatus(String descricaoStatus) {
        this.descricaoStatus = descricaoStatus;
    }

    public List<ContasReceberCampanha> getListaCrCampanha() {
        return listaCrCampanha;
    }

    public void setListaCrCampanha(List<ContasReceberCampanha> listaCrCampanha) {
        this.listaCrCampanha = listaCrCampanha;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public Integer getDuracaoMeses() {
        return duracaoMeses;
    }

    public void setDuracaoMeses(Integer duracaoMeses) {
        this.duracaoMeses = duracaoMeses;
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

    public List<Pessoa> getParticipante() {
        return participante;
    }

    public void setParticipante(List<Pessoa> participante) {
        this.participante = participante;
    }

    public double getValorTotalCampanha() {
        return valorTotalCampanha;
    }

    public void setValorTotalCampanha(double valorTotalCampanha) {
        this.valorTotalCampanha = valorTotalCampanha;
    }

    public Integer getStatusCampanha() {
        return statusCampanha;
    }

    public void setStatusCampanha(Integer statusCampanha) {
        this.statusCampanha = statusCampanha;
    }

    public Integer getDiaPagamento() {
        return diaPagamento;
    }

    public void setDiaPagamento(Integer diaPagamento) {
        this.diaPagamento = diaPagamento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.codigo);
        hash = 29 * hash + Objects.hashCode(this.descricaoCampanha);
        hash = 29 * hash + Objects.hashCode(this.igreja);
        hash = 29 * hash + Objects.hashCode(this.duracaoMeses);
        hash = 29 * hash + Objects.hashCode(this.dataInicial);
        hash = 29 * hash + Objects.hashCode(this.dataFinal);
        hash = 29 * hash + Objects.hashCode(this.diaPagamento);
        hash = 29 * hash + Objects.hashCode(this.observacao);
        hash = 29 * hash + Objects.hashCode(this.participante);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.valorTotalCampanha) ^ (Double.doubleToLongBits(this.valorTotalCampanha) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.statusCampanha);
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
        if (!Objects.equals(this.igreja, other.igreja)) {
            return false;
        }
        if (!Objects.equals(this.duracaoMeses, other.duracaoMeses)) {
            return false;
        }
        if (!Objects.equals(this.dataInicial, other.dataInicial)) {
            return false;
        }
        if (!Objects.equals(this.dataFinal, other.dataFinal)) {
            return false;
        }
        if (!Objects.equals(this.diaPagamento, other.diaPagamento)) {
            return false;
        }
        if (!Objects.equals(this.participante, other.participante)) {
            return false;
        }
        return Objects.equals(this.statusCampanha, other.statusCampanha);
    }
    
    @Override
    public String toString() {
        return  descricaoCampanha;
    }

}
