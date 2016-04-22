package abd.p1.model;

import javax.persistence.*;
@Entity
@IdClass(InvitacionID.class)
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name="id_men", 
        referencedColumnName="id_mensaje"),
    @PrimaryKeyJoinColumn(name="id_usu1",
        referencedColumnName="id_usuario1"),
    @PrimaryKeyJoinColumn(name="id_usu2", 
    referencedColumnName="id_usuario2")
})
public class Invitacion extends Mensaje {
//	@Id
//	private Mensajes msg;
//	@Id
	private Pregunta pta;
	
	public Invitacion(){}
//	
//	public Mensajes getMsg() {
//		return msg;
//	}
//	public void setMsg(Mensajes msg) {
//		this.msg = msg;
//	}
	public Pregunta getPta() {
		return pta;
	}
	public void setPta(Pregunta pta) {
		this.pta = pta;
	}
	

}
