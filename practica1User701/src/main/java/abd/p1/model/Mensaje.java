package abd.p1.model;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Mensaje {
	@Id
	@GeneratedValue(generator = "IdGenerator", strategy = GenerationType.TABLE)
	@TableGenerator(name = "IdGenerator", pkColumnValue = "Id", table = "Id_Mensajes", allocationSize = 1)
	@Column(name = "id_mensaje")
	private Integer id;
	private boolean leido;
	@ManyToOne
	private Usuario remitente;
	@ManyToOne
	private Usuario destinatario;

	private Timestamp timestamp;

	public Mensaje() {}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public boolean isLeido() {
		return leido;
	}
	
	public void setLeido(boolean leido) {
		this.leido = leido;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Usuario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}

}
