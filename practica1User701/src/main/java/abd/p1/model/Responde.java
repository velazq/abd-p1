package abd.p1.model;

import javax.persistence.*;

@Entity
@IdClass(Lista_respuesta.class)
public class Responde {
	@Id
	@ManyToMany
	private Usuarios usuario;
	@Id
	@ManyToMany (mappedBy="usuario")
	private Opcion opcion;
	private String valoracion;
	
	public Responde(){}
	
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
	public String getValoracion() {
		return valoracion;
	}
	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}

}
