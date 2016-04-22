package abd.p1.model;

import javax.persistence.*;

@Entity
@IdClass(RespuestaID.class)
public class Responde {
//	@Id
//	@ManyToMany
//	private Usuario usuario;
//	@Id
//	@ManyToMany(mappedBy="usuario")
//	private Opcion opcion;

	@Id
	@ManyToOne
	private Usuario usuario;
	@Id
	@ManyToOne
	private Opcion opcion;
	
	private String valoracion;
	
	public Responde(){}
	
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
	public String getValoracion() {
		return valoracion;
	}
	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}

}
