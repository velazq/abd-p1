package abd.p1.model;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id_mensaje")
public class Texto extends Mensaje {
	//@Id
	//private Mensajes msg;
	private String texto;

	public Texto(){}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
//	public Mensajes getMsg() {
//		return msg;
//	}
//	public void setMsg(Mensajes msg) {
//		this.msg = msg;
//	}

}
