package abd.p1.model;

import javax.persistence.*;
@Entity
@PrimaryKeyJoinColumn(name="id_mensaje")
public class Invitacion extends Mensaje {
//	@Id
//	private Mensajes msg;
//	@Id
	
	@ManyToOne
	private Pregunta pregunta;
	
	public Invitacion(){}
	
	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
}
