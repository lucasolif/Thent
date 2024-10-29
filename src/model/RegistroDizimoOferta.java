
package model;

import java.util.Objects;


public class RegistroDizimoOferta {
    
    private Integer codRegistro;
    private TipoOferta tpOferta;
    private double valorOferta;
    private FormaPagto formaPagto;
    private Pessoa ofertante;
    private String dataOferta, DataCadastro;
    private Igreja igreja;
    private Usuario usuario;
    private ContaCaixa contaCaixa;
    private SubContaResultado subContaResultado;
    
    public RegistroDizimoOferta() {
    }
    
    public RegistroDizimoOferta(TipoOferta tpOferta, double valorOferta, FormaPagto formaPagto, Pessoa ofertante, String dataOferta, Igreja igreja, ContaCaixa contaCaixa, SubContaResultado subContaResultado) {
        this.tpOferta = tpOferta;
        this.valorOferta = valorOferta;
        this.formaPagto = formaPagto;
        this.ofertante = ofertante;
        this.dataOferta = dataOferta;
        this.igreja = igreja;
        this.contaCaixa = contaCaixa;
        this.subContaResultado = subContaResultado;
    }

    //Construtor utilizado na consulta de Dizimo e Ofertas
    public RegistroDizimoOferta(Integer codRegistro, TipoOferta tpOferta, double valorOferta, FormaPagto formaPagto, Pessoa ofertante, String dataOferta, Igreja igreja, ContaCaixa contaCaixa, String dataCadastro ) {
        this.codRegistro = codRegistro;
        this.tpOferta = tpOferta;
        this.valorOferta = valorOferta;
        this.formaPagto = formaPagto;
        this.ofertante = ofertante;
        this.dataOferta = dataOferta;
        this.igreja = igreja;
        this.contaCaixa = contaCaixa;
        this.DataCadastro = dataCadastro;
    }
    
    public RegistroDizimoOferta(Integer codigo, TipoOferta tpOferta, double valorOferta, FormaPagto formaPagto, Pessoa ofertante, String dataOferta, Igreja igreja, ContaCaixa contaCaixa, Usuario usuario) {
        this.codRegistro = codigo;
        this.tpOferta = tpOferta;
        this.valorOferta = valorOferta;
        this.formaPagto = formaPagto;
        this.ofertante = ofertante;
        this.dataOferta = dataOferta;
        this.igreja = igreja;
        this.contaCaixa = contaCaixa;
        this.usuario = usuario;
    }

    public RegistroDizimoOferta(TipoOferta tpOferta, double valorOferta, FormaPagto formaPagto, Pessoa ofertante, String dataOferta, Igreja igreja, ContaCaixa contaCaixa, Usuario usuario) {
        this.tpOferta = tpOferta;
        this.valorOferta = valorOferta;
        this.formaPagto = formaPagto;
        this.ofertante = ofertante;
        this.dataOferta = dataOferta;
        this.igreja = igreja;
        this.contaCaixa = contaCaixa;
        this.usuario = usuario;
    }

    public Integer getCodRegistro() {
        return codRegistro;
    }

    public void setCodRegistro(Integer codRegistro) {
        this.codRegistro = codRegistro;
    }

    public TipoOferta getTpOferta() {
        return tpOferta;
    }

    public void setTpOferta(TipoOferta tpOferta) {
        this.tpOferta = tpOferta;
    }

    public double getValorOferta() {
        return valorOferta;
    }

    public void setValorOferta(double valorOferta) {
        this.valorOferta = valorOferta;
    }

    public FormaPagto getFormaPagto() {
        return formaPagto;
    }

    public void setFormaPagto(FormaPagto formaPagto) {
        this.formaPagto = formaPagto;
    }

    public Pessoa getOfertante() {
        return ofertante;
    }

    public void setOfertante(Pessoa ofertante) {
        this.ofertante = ofertante;
    }

    public String getDataOferta() {
        return dataOferta;
    }

    public void setDataOferta(String dataOferta) {
        this.dataOferta = dataOferta;
    }

    public String getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(String DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public Igreja getIgreja() {
        return igreja;
    }

    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ContaCaixa getContaCaixa() {
        return contaCaixa;
    }

    public void setContaCaixa(ContaCaixa contaCaixa) {
        this.contaCaixa = contaCaixa;
    }

    public SubContaResultado getSubContaResultado() {
        return subContaResultado;
    }

    public void setSubContaResultado(SubContaResultado subContaResultado) {
        this.subContaResultado = subContaResultado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.codRegistro);
        hash = 67 * hash + Objects.hashCode(this.tpOferta);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.valorOferta) ^ (Double.doubleToLongBits(this.valorOferta) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.formaPagto);
        hash = 67 * hash + Objects.hashCode(this.ofertante);
        hash = 67 * hash + Objects.hashCode(this.dataOferta);
        hash = 67 * hash + Objects.hashCode(this.DataCadastro);
        hash = 67 * hash + Objects.hashCode(this.igreja);
        hash = 67 * hash + Objects.hashCode(this.usuario);
        hash = 67 * hash + Objects.hashCode(this.contaCaixa);
        hash = 67 * hash + Objects.hashCode(this.subContaResultado);
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
        final RegistroDizimoOferta other = (RegistroDizimoOferta) obj;
        if (Double.doubleToLongBits(this.valorOferta) != Double.doubleToLongBits(other.valorOferta)) {
            return false;
        }
        if (!Objects.equals(this.dataOferta, other.dataOferta)) {
            return false;
        }
        if (!Objects.equals(this.DataCadastro, other.DataCadastro)) {
            return false;
        }
        if (!Objects.equals(this.codRegistro, other.codRegistro)) {
            return false;
        }
        if (!Objects.equals(this.tpOferta, other.tpOferta)) {
            return false;
        }
        if (!Objects.equals(this.formaPagto, other.formaPagto)) {
            return false;
        }
        if (!Objects.equals(this.ofertante, other.ofertante)) {
            return false;
        }
        if (!Objects.equals(this.igreja, other.igreja)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.contaCaixa, other.contaCaixa)) {
            return false;
        }
        return Objects.equals(this.subContaResultado, other.subContaResultado);
    }

 
}
