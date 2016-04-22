package abd.p1.model;

import java.io.Serializable;

public class RespuestaID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuarios usuario;
	private Opcion opcion;
	
	public Usuarios getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	public Opcion getOpcion() {
		return opcion;
	}
	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}
}