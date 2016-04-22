package abd.p1.model;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name="id_men", 
        referencedColumnName="id_mensaje"),
    @PrimaryKeyJoinColumn(name="id_usu11",
        referencedColumnName="id_usuario1"),
    @PrimaryKeyJoinColumn(name="id_usu22", 
    referencedColumnName="id_usuario2")
})
public class Solicitud_amistad extends Mensajes {
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
//	public String getTexto() {
//		return texto;
//	}
//	public void setTexto(String texto) {
//		this.texto = texto;
//	}

}
