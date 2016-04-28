package abd.p1.model;

import java.io.Serializable;

public class RespondeID implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Opcion opcion;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Opcion getOpcion() {
		return opcion;
	}
	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((opcion == null) ? 0 : opcion.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RespondeID other = (RespondeID) obj;
		if (opcion == null) {
			if (other.opcion != null)
				return false;
		} else if (!opcion.equals(other.opcion))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}