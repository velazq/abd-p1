package abd.p1.model;

import java.io.Serializable;

public class InvitacionesID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Mensajes msg;
	private Pregunta pta;
	
	public Mensajes getMsg() {
		return msg;
	}
	public void setMsg(Mensajes msg) {
		this.msg = msg;
	}
	public Pregunta getPta() {
		return pta;
	}
	public void setPta(Pregunta pta) {
		this.pta = pta;
	}
}
