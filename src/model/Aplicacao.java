
package model;

import java.util.Date;


public class Aplicacao {
    
    private Integer codigo;
    private Integer diaAniversario;
    private String descricao;
    private double valorInicial;
    private double percentual;
    private String tipoRendimento;
    private Date dataAplicacao;
    private Date dataResgateEncerramento;
    private Date dataCadastro;
    private double valorRetirada;
    private double valorRendimento;
    private ContaCaixa contaCaixa;
    private Igreja igreja;
    private int statusAplicacao;

    public Integer getDiaAniversario() {
        return diaAniversario;
    }

    public void setDiaAniversario(Integer diaAniversario) {
        this.diaAniversario = diaAniversario;
    }

    public double getValorRendimento() {
        return valorRendimento;
    }

    public void setValorRendimento(double valorRendimento) {
        this.valorRendimento = valorRendimento;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }

    public String getTipoRendimento() {
        return tipoRendimento;
    }

    public void setTipoRendimento(String tipoRendimento) {
        this.tipoRendimento = tipoRendimento;
    }

    public Date getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(Date dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public Date getDataResgateEncerramento() {
        return dataResgateEncerramento;
    }

    public void setDataResgateEncerramento(Date dataResgateEncerramento) {
        this.dataResgateEncerramento = dataResgateEncerramento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public double getValorRetirada() {
        return valorRetirada;
    }

    public void setValorRetirada(double valorRetirada) {
        this.valorRetirada = valorRetirada;
    }

    public ContaCaixa getContaCaixa() {
        return contaCaixa;
    }

    public void setContaCaixa(ContaCaixa contaCaixa) {
        this.contaCaixa = contaCaixa;
    }

    public Igreja getIgreja() {
        return igreja;
    }

    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
    }

    public int getStatusAplicacao() {
        return statusAplicacao;
    }

    public void setStatusAplicacao(int statusAplicacao) {
        this.statusAplicacao = statusAplicacao;
    }

    @Override
    public String toString() {
        return descricao;
    }
  
}
