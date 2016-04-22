package abd.p1.model;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@IdClass(Lista_mensajes.class)
public class Mensajes {
	@Id
	@GeneratedValue(generator = "IdGenerator",strategy = GenerationType.TABLE)
	@TableGenerator(name = "IdGenerator",pkColumnValue = "Id",table="Id_Mensajes",allocationSize=1 )
	@Column(name = "id_mensaje")
	private Integer id;
	@Id
	@Column(name = "id_usuario1")
	private Usuarios usuario1;
	@Id
	@Column(name = "id_usuario2")
	private Usuarios usuario2;
	
	private Byte leido;
	private Timestamp fecha_y_hora;

	public Mensajes() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Byte getLeido() {
		return leido;
	}
	public void setLeido(Byte leido) {
		this.leido = leido;
	}
	public Timestamp getFecha_y_hora() {
		return fecha_y_hora;
	}
	public void setFecha_y_hora(Timestamp fecha_y_hora) {
		this.fecha_y_hora = fecha_y_hora;
	}

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

}
