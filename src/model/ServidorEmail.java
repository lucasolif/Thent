
package model;


public class ServidorEmail {
    private Integer codigo;
    private String nomeRemetente;
    private String servidorEmail;
    private String enderecoEmail;
    private String senhaEmail;
    private String tipoSeguranca;
    private Integer portaServidor;
    private Usuario usuario;
    private Integer status;
    private Integer emailPrincipal;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipoSeguranca() {
        return tipoSeguranca;
    }

    public void setTipoSeguranca(String tipoSeguranca) {
        this.tipoSeguranca = tipoSeguranca;
    } 

    public Integer getEmailPrincipal() {
        return emailPrincipal;
    }

    public void setEmailPrincipal(Integer emailPrincipal) {
        this.emailPrincipal = emailPrincipal;
    }
    
    public String getNomeRemetente() {
        return nomeRemetente;
    }

    public void setNomeRemetente(String nomeRemetente) {
        this.nomeRemetente = nomeRemetente;
    }

    public String getServidorEmail() {
        return servidorEmail;
    }

    public void setServidorEmail(String servidorEmail) {
        this.servidorEmail = servidorEmail;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    public String getSenhaEmail() {
        return senhaEmail;
    }

    public void setSenhaEmail(String senhaEmail) {
        this.senhaEmail = senhaEmail;
    }

    public Integer getPortaServidor() {
        return portaServidor;
    }

    public void setPortaServidor(Integer portaServidor) {
        this.portaServidor = portaServidor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
      
}
