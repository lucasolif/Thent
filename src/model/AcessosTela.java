
package model;


public class AcessosTela {
    private Usuario usuario;
    private Integer codFuncao;
    private Integer menuId;
    private Integer podeAcesasr;
    private Integer editar;
    private Integer excluir;
    private Integer cadastrar;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getCodFuncao() {
        return codFuncao;
    }

    public void setCodFuncao(Integer codFuncao) {
        this.codFuncao = codFuncao;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getPodeAcesasr() {
        return podeAcesasr;
    }

    public void setPodeAcesasr(Integer podeAcesasr) {
        this.podeAcesasr = podeAcesasr;
    }

    public Integer getEditar() {
        return editar;
    }

    public void setEditar(Integer editar) {
        this.editar = editar;
    }

    public Integer getExcluir() {
        return excluir;
    }

    public void setExcluir(Integer excluir) {
        this.excluir = excluir;
    }

    public Integer getCadastrar() {
        return cadastrar;
    }

    public void setCadastrar(Integer cadastrar) {
        this.cadastrar = cadastrar;
    }
    
    
}
