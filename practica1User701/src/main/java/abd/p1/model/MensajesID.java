package abd.p1.model;

import java.io.Serializable;

public class MensajesID implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuarios usuario1;
	private Usuarios usuario2;
	private Integer id;
	
	public Usuarios getUsuario1() {
		return usuario1;
	}
	public void setUsuario1(Usuarios usuario1) {
		this.usuario1 = usuario1;
	}
	public Usuarios getUsuario2() {
		return usuario2;
	}
	public void setUsuario2(Usuarios usuario2) {
		this.usuario2 = usuario2;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}