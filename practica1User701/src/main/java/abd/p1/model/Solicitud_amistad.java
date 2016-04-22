package abd.p1.model;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id_mensaje")
public class Solicitud_amistad extends Mensaje {
	//@Id
	//private Mensajes msg;
	private String texto;
	
	public Solicitud_amistad(){}
//	public Mensajes getMsg() {
//		return msg;
//	}
//	public void setMsg(Mensajes msg) {
//		this.msg = msg;
//	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

}
