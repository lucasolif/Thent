
package model;

import java.util.List;


public class ParticipanteCampanha extends Pessoa {
    private double valorTotalPago;
    private double valorTotalPendente;
    private double qtdParcelasPagas;
    private double qtdParcelasPendentes;
    private Campanha campanha;
    private Integer status;
    private String descricaoStatus;
    private List<ContasReceberCampanha> listaCrCampanha;

    public double getValorTotalPago() {
        return valorTotalPago;
    }

    public void setValorTotalPago(double valorTotalPago) {
        this.valorTotalPago = valorTotalPago;
    }

    public double getValorTotalPendente() {
        return valorTotalPendente;
    }

    public void setValorTotalPendente(double valorTotalPendente) {
        this.valorTotalPendente = valorTotalPendente;
    }

    public double getQtdParcelasPagas() {
        return qtdParcelasPagas;
    }

    public void setQtdParcelasPagas(double qtdParcelasPagas) {
        this.qtdParcelasPagas = qtdParcelasPagas;
    }

    public double getQtdParcelasPendentes() {
        return qtdParcelasPendentes;
    }

    public void setQtdParcelasPendentes(double qtdParcelasPendentes) {
        this.qtdParcelasPendentes = qtdParcelasPendentes;
    }

    public Campanha getCampanha() {
        return campanha;
    }

    public void setCampanha(Campanha campanha) {
        this.campanha = campanha;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
    
}
