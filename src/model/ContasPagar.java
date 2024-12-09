
package model;

import java.util.Date;
import java.util.Objects;


public class ContasPagar {
    private Integer codigo;
    private Integer parcela;
    private Integer numNota;
    private Integer status;
    private String descricaoStatus;
    private String descricaoConta;
    private Date dataVencimento; 
    private Date dataCadastro;
    private Date dataPagamento; 
    private String boleto;
    private String observacao;
    private double valor;
    private double valorPago;
    private double valorPendente;
    private Pessoa fornecedor;
    private FormaPagto formaPagto;
    private SubContaResultado subContaResultado;
    private Igreja igreja;

    public ContasPagar() {
    }

    public ContasPagar(Pessoa fornecedor, Integer parcela, Integer numNota, Integer status, String descricaoStatus, String descricaoConta, Date dataVencimento, String boleto, String observacao, double valor, double valorPago, double valorPendente, FormaPagto formaPagto, SubContaResultado subContaResultado, Igreja igreja) {
        this.fornecedor = fornecedor;
        this.parcela = parcela;
        this.numNota = numNota;
        this.status = status;
        this.descricaoStatus = descricaoStatus;
        this.descricaoConta = descricaoConta;
        this.dataVencimento = dataVencimento;
        this.boleto = boleto;
        this.observacao = observacao;
        this.valor = valor;
        this.valorPago = valorPago;
        this.valorPendente = valorPendente;
        this.formaPagto = formaPagto;
        this.subContaResultado = subContaResultado;
        this.igreja = igreja;
    }

    //Para utilizar nos filtros da efetivação das contas
    public ContasPagar(Integer codigo, Integer numNota, Integer status, String descricaoConta, Date dataVencimento, Date dataCadastro, Date dataPagamento, Pessoa fornecedor, SubContaResultado subContaResultado) {
        this.codigo = codigo;
        this.numNota = numNota;
        this.status = status;
        this.descricaoConta = descricaoConta;
        this.dataVencimento = dataVencimento;
        this.dataCadastro = dataCadastro;
        this.dataPagamento = dataPagamento;
        this.fornecedor = fornecedor;
        this.subContaResultado = subContaResultado;
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

    public String getDescricaoStatus() {
        return descricaoStatus;
    }

    public void setDescricaoStatus(String descricaoStatus) {
        this.descricaoStatus = descricaoStatus;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getParcela() {
        return parcela;
    }

    public void setParcela(Integer parcela) {
        this.parcela = parcela;
    }

    public Integer getNumNota() {
        return numNota;
    }

    public void setNumNota(Integer numNota) {
        this.numNota = numNota;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescricaoConta() {
        return descricaoConta;
    }

    public void setDescricaoConta(String descricaoConta) {
        this.descricaoConta = descricaoConta;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getBoleto() {
        return boleto;
    }

    public void setBoleto(String boleto) {
        this.boleto = boleto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Pessoa getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Pessoa fornecedor) {
        this.fornecedor = fornecedor;
    }

    public FormaPagto getFormaPagto() {
        return formaPagto;
    }

    public void setFormaPagto(FormaPagto formaPagto) {
        this.formaPagto = formaPagto;
    }

    public SubContaResultado getSubContaResultado() {
        return subContaResultado;
    }

    public void setSubContaResultado(SubContaResultado subContaResultado) {
        this.subContaResultado = subContaResultado;
    }

    public Igreja getIgreja() {
        return igreja;
    }

    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.codigo);
        hash = 61 * hash + Objects.hashCode(this.parcela);
        hash = 61 * hash + Objects.hashCode(this.numNota);
        hash = 61 * hash + Objects.hashCode(this.status);
        hash = 61 * hash + Objects.hashCode(this.descricaoConta);
        hash = 61 * hash + Objects.hashCode(this.dataVencimento);
        hash = 61 * hash + Objects.hashCode(this.dataCadastro);
        hash = 61 * hash + Objects.hashCode(this.dataPagamento);
        hash = 61 * hash + Objects.hashCode(this.boleto);
        hash = 61 * hash + Objects.hashCode(this.observacao);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 61 * hash + Objects.hashCode(this.fornecedor);
        hash = 61 * hash + Objects.hashCode(this.formaPagto);
        hash = 61 * hash + Objects.hashCode(this.subContaResultado);
        hash = 61 * hash + Objects.hashCode(this.igreja);
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
        final ContasPagar other = (ContasPagar) obj;
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.descricaoConta, other.descricaoConta)) {
            return false;
        }
        if (!Objects.equals(this.dataVencimento, other.dataVencimento)) {
            return false;
        }
        if (!Objects.equals(this.dataCadastro, other.dataCadastro)) {
            return false;
        }
        if (!Objects.equals(this.dataPagamento, other.dataPagamento)) {
            return false;
        }
        if (!Objects.equals(this.boleto, other.boleto)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.parcela, other.parcela)) {
            return false;
        }
        if (!Objects.equals(this.numNota, other.numNota)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        if (!Objects.equals(this.formaPagto, other.formaPagto)) {
            return false;
        }
        if (!Objects.equals(this.subContaResultado, other.subContaResultado)) {
            return false;
        }
        return Objects.equals(this.igreja, other.igreja);
    }
}
