package abd.p1.model;

import java.io.Serializable;

public class MensajeID implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario remitente;
	private Usuario destinatario;
	private Integer id;
	
	public Usuario getRemitente() {
		return remitente;
	}
	public void setRemitente(Usuario remitente) {
		this.remitente = remitente;
	}
	public Usuario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}