
package model;

import java.util.Objects;


public class TransferenciaConta {
    
    private Integer codigo;
    private ContaCaixa cxSaida, cxEntrada,cxSaidaEntrada;
    private double valorEntradaSaida;
    private Pessoa pessoa;


    public TransferenciaConta() {
    }

    public TransferenciaConta(Integer codigo, ContaCaixa cxSaida, ContaCaixa cxEntrada, double valorEntradaSaida, Pessoa pessoa) {
        this.codigo = codigo;
        this.cxSaida = cxSaida;
        this.cxEntrada = cxEntrada;
        this.valorEntradaSaida = valorEntradaSaida;
        this.pessoa = pessoa;
    }

    //Construtor para transferir o valor de uma conta para outra
    public TransferenciaConta(ContaCaixa cxSaida, ContaCaixa cxEntrada, double valorEntradaSaida, Pessoa pessoa) {
        this.cxSaida = cxSaida;
        this.cxEntrada = cxEntrada;
        this.valorEntradaSaida = valorEntradaSaida;
        this.pessoa = pessoa;

    }
    

    public Integer getCodigo() {
        return codigo;
    }

    public ContaCaixa getCxSaida() {
        return cxSaida;
    }

    public ContaCaixa getCxEntrada() {
        return cxEntrada;
    }

    public ContaCaixa getCxSaidaEntrada() {
        return cxSaidaEntrada;
    }

    public double getValorEntradaSaida() {
        return valorEntradaSaida;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setCxSaida(ContaCaixa cxSaida) {
        this.cxSaida = cxSaida;
    }

    public void setCxEntrada(ContaCaixa cxEntrada) {
        this.cxEntrada = cxEntrada;
    }

    public void setCxSaidaEntrada(ContaCaixa cxSaidaEntrada) {
        this.cxSaidaEntrada = cxSaidaEntrada;
    }

    public void setValorEntradaSaida(double valorEntradaSaida) {
        this.valorEntradaSaida = valorEntradaSaida;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codigo);
        hash = 79 * hash + Objects.hashCode(this.cxSaida);
        hash = 79 * hash + Objects.hashCode(this.cxEntrada);
        hash = 79 * hash + Objects.hashCode(this.cxSaidaEntrada);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.valorEntradaSaida) ^ (Double.doubleToLongBits(this.valorEntradaSaida) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.pessoa);
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
        final TransferenciaConta other = (TransferenciaConta) obj;
        if (Double.doubleToLongBits(this.valorEntradaSaida) != Double.doubleToLongBits(other.valorEntradaSaida)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.cxSaida, other.cxSaida)) {
            return false;
        }
        if (!Objects.equals(this.cxEntrada, other.cxEntrada)) {
            return false;
        }
        if (!Objects.equals(this.cxSaidaEntrada, other.cxSaidaEntrada)) {
            return false;
        }
        return Objects.equals(this.pessoa, other.pessoa);
    }
}
