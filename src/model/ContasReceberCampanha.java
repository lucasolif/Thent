
package model;

import java.util.Date;
import java.util.Objects;


public class ContasReceberCampanha {
    private Integer codigo;
    private Campanha campanha;
    private SubContaResultado contaResultado;
    private Date dataVencimento;
    private Date dataPagamento;
    private ParticipanteCampanha participante;
    private Integer numParcela;    
    private Integer parcela;
    private double valorParcela;
    private double valorPago;
    private double valorPendente;
    private Integer statusPagamento;
    private String descricaoStatus;
    private Igreja igreja;
    private String observacaoPagamento;

    public Integer getNumParcela() {
        return numParcela;
    }
    
    public void setNumParcela(Integer numParcela) {
        this.numParcela = numParcela;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Campanha getCampanha() {
        return campanha;
    }

    public void setCampanha(Campanha campanha) {
        this.campanha = campanha;
    }

    public SubContaResultado getContaResultado() {
        return contaResultado;
    }

    public void setContaResultado(SubContaResultado contaResultado) {
        this.contaResultado = contaResultado;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Pessoa getParticipante() {
        return participante;
    }

    public void setParticipante(ParticipanteCampanha participante) {
        this.participante = participante;
    }

    public Integer getParcela() {
        return parcela;
    }

    public void setParcela(Integer parcela) {
        this.parcela = parcela;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getValorPendente() {
        return valorPendente;
    }

    public void setValorPendente(double valorPendente) {
        this.valorPendente = valorPendente;
    }

    public Integer getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(Integer statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public String getDescricaoStatus() {
        return descricaoStatus;
    }

    public void setDescricaoStatus(String descricaoStatus) {
        this.descricaoStatus = descricaoStatus;
    }

    public Igreja getIgreja() {
        return igreja;
    }

    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
    }

    public String getObservacaoPagamento() {
        return observacaoPagamento;
    }

    public void setObservacaoPagamento(String observacaoPagamento) {
        this.observacaoPagamento = observacaoPagamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.codigo);
        hash = 47 * hash + Objects.hashCode(this.campanha);
        hash = 47 * hash + Objects.hashCode(this.dataVencimento);
        hash = 47 * hash + Objects.hashCode(this.dataPagamento);
        hash = 47 * hash + Objects.hashCode(this.participante);
        hash = 47 * hash + Objects.hashCode(this.parcela);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.valorParcela) ^ (Double.doubleToLongBits(this.valorParcela) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.valorPago) ^ (Double.doubleToLongBits(this.valorPago) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.valorPendente) ^ (Double.doubleToLongBits(this.valorPendente) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.statusPagamento);
        hash = 47 * hash + Objects.hashCode(this.igreja);
        hash = 47 * hash + Objects.hashCode(this.observacaoPagamento);
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
        final ContasReceberCampanha other = (ContasReceberCampanha) obj;
        if (Double.doubleToLongBits(this.valorParcela) != Double.doubleToLongBits(other.valorParcela)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorPago) != Double.doubleToLongBits(other.valorPago)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorPendente) != Double.doubleToLongBits(other.valorPendente)) {
            return false;
        }
        if (!Objects.equals(this.observacaoPagamento, other.observacaoPagamento)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.campanha, other.campanha)) {
            return false;
        }
        if (!Objects.equals(this.dataVencimento, other.dataVencimento)) {
            return false;
        }
        if (!Objects.equals(this.dataPagamento, other.dataPagamento)) {
            return false;
        }
        if (!Objects.equals(this.participante, other.participante)) {
            return false;
        }
        if (!Objects.equals(this.parcela, other.parcela)) {
            return false;
        }
        if (!Objects.equals(this.statusPagamento, other.statusPagamento)) {
            return false;
        }
        return Objects.equals(this.igreja, other.igreja);
    }

}
