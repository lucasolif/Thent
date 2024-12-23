
package model;

import java.util.List;

public class Fornecedor extends Pessoa{
    private List<ContasPagar> listaContasPagar;

    public List<ContasPagar> getListaContasPagar() {
        return listaContasPagar;
    }

    public void setListaContasPagar(List<ContasPagar> listaContasPagar) {
        this.listaContasPagar = listaContasPagar;
    }
      
}
