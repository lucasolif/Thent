/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author Lucas Oliveira
 */
public class MovimentoCaixa {
    private Integer codigo, excluido;
    private RegistroDizimoOferta rgOferta;
    private ContasPagar contaPagar;
    private String complemento, dataMovimento, dataPagamentoRecebimento;
    private double valorEntrada, valorSaida;
    private Pessoa pessoa;
    private ContaCaixa contaCaixa;
    private FormaPagto formaPagto;
    private Igreja igreja;
    private Usuario usuarioCadastro;
    private TransferenciaConta transferecia;

    public MovimentoCaixa() {
    }

    public MovimentoCaixa(Integer excluido, RegistroDizimoOferta rgOferta, String complemento, String dataMovimento, double valorEntrada, double valorSaida, ContaCaixa contaCaixa, FormaPagto formaPagto, Igreja igreja, Usuario usuarioCadastro) {
        this.excluido = excluido;
        this.rgOferta = rgOferta;
        this.complemento = complemento;
        this.dataMovimento = dataMovimento;
        this.valorEntrada = valorEntrada;
        this.valorSaida = valorSaida;
        this.contaCaixa = contaCaixa;
        this.formaPagto = formaPagto;
        this.igreja = igreja;
        this.usuarioCadastro = usuarioCadastro;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Integer getExcluido() {
        return excluido;
    }

    public RegistroDizimoOferta getRgOferta() {
        return rgOferta;
    }

    public ContasPagar getContaPagar() {
        return contaPagar;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getDataMovimento() {
        return dataMovimento;
    }

    public String getDataPagamentoRecebimento() {
        return dataPagamentoRecebimento;
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public double getValorSaida() {
        return valorSaida;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public ContaCaixa getContaCaixa() {
        return contaCaixa;
    }

    public FormaPagto getFormaPagto() {
        return formaPagto;
    }

    public Igreja getIgreja() {
        return igreja;
    }

    public Usuario getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public TransferenciaConta getTransferecia() {
        return transferecia;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setExcluido(Integer excluido) {
        this.excluido = excluido;
    }
    
    public void setRgOferta(RegistroDizimoOferta rgOferta) {
        this.rgOferta = rgOferta;
    }

    public void setContaPagar(ContasPagar contaPagar) {
        this.contaPagar = contaPagar;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setDataMovimento(String dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public void setDataPagamentoRecebimento(String dataPagamentoRecebimento) {
        this.dataPagamentoRecebimento = dataPagamentoRecebimento;
    }

    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public void setValorSaida(double valorSaida) {
        this.valorSaida = valorSaida;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setContaCaixa(ContaCaixa contaCaixa) {
        this.contaCaixa = contaCaixa;
    }

    public void setFormaPagto(FormaPagto formaPagto) {
        this.formaPagto = formaPagto;
    }

    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
    }

    public void setUsuarioCadastro(Usuario usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

    public void setTransferecia(TransferenciaConta transferecia) {
        this.transferecia = transferecia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.codigo);
        hash = 37 * hash + Objects.hashCode(this.excluido);
        hash = 37 * hash + Objects.hashCode(this.rgOferta);
        hash = 37 * hash + Objects.hashCode(this.contaPagar);
        hash = 37 * hash + Objects.hashCode(this.complemento);
        hash = 37 * hash + Objects.hashCode(this.dataMovimento);
        hash = 37 * hash + Objects.hashCode(this.dataPagamentoRecebimento);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.valorEntrada) ^ (Double.doubleToLongBits(this.valorEntrada) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.valorSaida) ^ (Double.doubleToLongBits(this.valorSaida) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.pessoa);
        hash = 37 * hash + Objects.hashCode(this.contaCaixa);
        hash = 37 * hash + Objects.hashCode(this.formaPagto);
        hash = 37 * hash + Objects.hashCode(this.igreja);
        hash = 37 * hash + Objects.hashCode(this.usuarioCadastro);
        hash = 37 * hash + Objects.hashCode(this.transferecia);
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
        final MovimentoCaixa other = (MovimentoCaixa) obj;
        if (Double.doubleToLongBits(this.valorEntrada) != Double.doubleToLongBits(other.valorEntrada)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorSaida) != Double.doubleToLongBits(other.valorSaida)) {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento)) {
            return false;
        }
        if (!Objects.equals(this.dataMovimento, other.dataMovimento)) {
            return false;
        }
        if (!Objects.equals(this.dataPagamentoRecebimento, other.dataPagamentoRecebimento)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.excluido, other.excluido)) {
            return false;
        }
        if (!Objects.equals(this.rgOferta, other.rgOferta)) {
            return false;
        }
        if (!Objects.equals(this.contaPagar, other.contaPagar)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.contaCaixa, other.contaCaixa)) {
            return false;
        }
        if (!Objects.equals(this.formaPagto, other.formaPagto)) {
            return false;
        }
        if (!Objects.equals(this.igreja, other.igreja)) {
            return false;
        }
        if (!Objects.equals(this.usuarioCadastro, other.usuarioCadastro)) {
            return false;
        }
        return Objects.equals(this.transferecia, other.transferecia);
    }

    

   
}
