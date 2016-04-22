package abd.p1.model;

import java.io.Serializable;

public class AficionID implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Usuario usuario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
