package abd.p1.model;

import javax.persistence.*;

@Entity
//@PrimaryKeyJoinColumns({
//    @PrimaryKeyJoinColumn(name = "id_men", referencedColumnName="id_mensaje"),
//    @PrimaryKeyJoinColumn(name="id_usu111",
//        referencedColumnName="id_usuario1"),
//    @PrimaryKeyJoinColumn(name="id_usu222", 
//    referencedColumnName="id_usuario2")
//})
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
