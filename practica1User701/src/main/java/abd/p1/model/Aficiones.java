package abd.p1.model;

import javax.persistence.*;

@Entity
@IdClass(Lista_aficiones.class)
public class Aficiones {
	@Id
	private Integer id;
	@Id
	private Usuarios usuario;
	private String texto;
	
	public Aficiones(){}
	
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
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}


}
