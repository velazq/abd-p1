package abd.p1.model;

import java.io.Serializable;

public class AficionesID implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Usuarios usuario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuarios getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
}
