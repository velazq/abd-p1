package abd.p1.model;

import javax.persistence.*;

@Entity
@IdClass(AficionID.class)
public class Aficion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Id
	@ManyToOne
	private Usuario usuario;
	private String texto;
	
	public Aficion(){}
	
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
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}


}
