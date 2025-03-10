
package model;

import java.util.Date;
import java.util.Objects;


public class RegistroDizimoOferta {
    
    private Integer codigo;
    private TipoOferta tpOferta;
    private double valorOfertaEntrada;
    private double valorOfertaSaida;
    private double valorTotal;
    private FormaPagto formaPagto;
    private Pessoa ofertante;
    private Date dataOferta;
    private Date dataMovimento;
    private Igreja igreja;
    private Usuario usuario;
    private ContaCaixa contaCaixa;
    private String complemento;
    private SubContaResultado subContaResultado;
    
    public RegistroDizimoOferta() {
    }
    
    public RegistroDizimoOferta(TipoOferta tpOferta, double valorOferta, FormaPagto formaPagto, Pessoa ofertante, Date dataOferta, Igreja igreja, ContaCaixa contaCaixa, SubContaResultado subContaResultado) {
        this.tpOferta = tpOferta;
        this.valorOfertaEntrada = valorOferta;
        this.formaPagto = formaPagto;
        this.ofertante = ofertante;
        this.dataOferta = dataOferta;
        this.igreja = igreja;
        this.contaCaixa = contaCaixa;
        this.subContaResultado = subContaResultado;
    }

    //Construtor utilizado na consulta de Dizimo e Ofertas
    public RegistroDizimoOferta(Integer codRegistro, TipoOferta tpOferta, double valorOferta, FormaPagto formaPagto, Pessoa ofertante, Date dataOferta, Igreja igreja, ContaCaixa contaCaixa, Date dataCadastro ) {
        this.codigo = codRegistro;
        this.tpOferta = tpOferta;
        this.valorOfertaEntrada = valorOferta;
        this.formaPagto = formaPagto;
        this.ofertante = ofertante;
        this.dataOferta = dataOferta;
        this.igreja = igreja;
        this.contaCaixa = contaCaixa;
        this.dataMovimento = dataCadastro;
    }
    
    public RegistroDizimoOferta(Integer codigo, TipoOferta tpOferta, double valorOferta, FormaPagto formaPagto, Pessoa ofertante, Date dataOferta, Igreja igreja, ContaCaixa contaCaixa, Usuario usuario) {
        this.codigo = codigo;
        this.tpOferta = tpOferta;
        this.valorOfertaEntrada = valorOferta;
        this.formaPagto = formaPagto;
        this.ofertante = ofertante;
        this.dataOferta = dataOferta;
        this.igreja = igreja;
        this.contaCaixa = contaCaixa;
        this.usuario = usuario;
    }

    public RegistroDizimoOferta(TipoOferta tpOferta, double valorOferta, FormaPagto formaPagto, Pessoa ofertante, Date dataOferta, Igreja igreja, ContaCaixa contaCaixa, Usuario usuario) {
        this.tpOferta = tpOferta;
        this.valorOfertaEntrada = valorOferta;
        this.formaPagto = formaPagto;
        this.ofertante = ofertante;
        this.dataOferta = dataOferta;
        this.igreja = igreja;
        this.contaCaixa = contaCaixa;
        this.usuario = usuario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public double getValorOfertaSaida() {
        return valorOfertaSaida;
    }

    public void setValorOfertaSaida(double valorOfertaSaida) {
        this.valorOfertaSaida = valorOfertaSaida;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public TipoOferta getTpOferta() {
        return tpOferta;
    }

    public void setTpOferta(TipoOferta tpOferta) {
        this.tpOferta = tpOferta;
    }

    public double getValorOfertaEntrada() {
        return valorOfertaEntrada;
    }

    public void setValorOfertaEntrada(double valorOfertaEntrada) {
        this.valorOfertaEntrada = valorOfertaEntrada;
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

    public Date getDataOferta() {
        return dataOferta;
    }

    public void setDataOferta(Date dataOferta) {
        this.dataOferta = dataOferta;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
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
        hash = 67 * hash + Objects.hashCode(this.codigo);
        hash = 67 * hash + Objects.hashCode(this.tpOferta);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.valorOfertaEntrada) ^ (Double.doubleToLongBits(this.valorOfertaEntrada) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.formaPagto);
        hash = 67 * hash + Objects.hashCode(this.ofertante);
        hash = 67 * hash + Objects.hashCode(this.dataOferta);
        hash = 67 * hash + Objects.hashCode(this.dataMovimento);
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
        if (Double.doubleToLongBits(this.valorOfertaEntrada) != Double.doubleToLongBits(other.valorOfertaEntrada)) {
            return false;
        }
        if (!Objects.equals(this.dataOferta, other.dataOferta)) {
            return false;
        }
        if (!Objects.equals(this.dataMovimento, other.dataMovimento)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
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
