package abd.p1.model;

import javax.persistence.*;

@Entity
@IdClass(RespondeID.class)
public class Responde {
	@Id
	@ManyToOne
	private Usuario usuario;
	@Id
	@ManyToOne
	private Opcion opcion;
	
	private Integer valoracion;
	
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
	public Integer getValoracion() {
		return valoracion;
	}
	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

}
