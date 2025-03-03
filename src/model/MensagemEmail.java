
package model;

import java.util.Date;

public class MensagemEmail {
    private Integer codigo;
    private ServidorEmail servidorEmailRemetente;
    private String enderecoEmailDestinatario;
    private String assunto;
    private String textoEmail;
    private Date dataHoraEnvio;
    private Usuario UsuarioEnvio;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public ServidorEmail getServidorEmailRemetente() {
        return servidorEmailRemetente;
    }

    public void setServidorEmailRemetente(ServidorEmail servidorEmailRemetente) {
        this.servidorEmailRemetente = servidorEmailRemetente;
    }

    public String getEnderecoEmailDestinatario() {
        return enderecoEmailDestinatario;
    }

    public void setEnderecoEmailDestinatario(String enderecoEmailDestinatario) {
        this.enderecoEmailDestinatario = enderecoEmailDestinatario;
    }

    public String getTextoEmail() {
        return textoEmail;
    }

    public void setTextoEmail(String textoEmail) {
        this.textoEmail = textoEmail;
    }   

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Date getDataHoraEnvio() {
        return dataHoraEnvio;
    }

    public void setDataHoraEnvio(Date dataHoraEnvio) {
        this.dataHoraEnvio = dataHoraEnvio;
    }

    public Usuario getUsuarioEnvio() {
        return UsuarioEnvio;
    }

    public void setUsuarioEnvio(Usuario UsuarioEnvio) {
        this.UsuarioEnvio = UsuarioEnvio;
    }
    
    
}
