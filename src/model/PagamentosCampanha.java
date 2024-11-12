
package model;

import java.util.Date;
import java.util.Objects;


public class PagamentosCampanha {
    private Integer codigo;
    private Campanha campanha;
    private SubContaResultado contaResultado;
    private Date dataLancamento;
    private Date dataPagamento;
    private Pessoa pessoa;
    private Integer parcela;
    private double valor;
    private double valorPago;
    private double valorPendente;
    private Integer statusPagamento;
    private String descricaoStatus;
    private Igreja igreja;
    private String observacaoPagamento;

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

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Integer getParcela() {
        return parcela;
    }

    public void setParcela(Integer parcela) {
        this.parcela = parcela;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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
        hash = 47 * hash + Objects.hashCode(this.dataLancamento);
        hash = 47 * hash + Objects.hashCode(this.dataPagamento);
        hash = 47 * hash + Objects.hashCode(this.pessoa);
        hash = 47 * hash + Objects.hashCode(this.parcela);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
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
        final PagamentosCampanha other = (PagamentosCampanha) obj;
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
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
        if (!Objects.equals(this.dataLancamento, other.dataLancamento)) {
            return false;
        }
        if (!Objects.equals(this.dataPagamento, other.dataPagamento)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
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
