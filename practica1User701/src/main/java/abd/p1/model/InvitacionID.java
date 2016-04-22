package abd.p1.model;

import java.io.Serializable;

public class InvitacionID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Mensaje msg;
	private Pregunta pta;
	
	public Mensaje getMsg() {
		return msg;
	}
	public void setMsg(Mensaje msg) {
		this.msg = msg;
	}
	public Pregunta getPta() {
		return pta;
	}
	public void setPta(Pregunta pta) {
		this.pta = pta;
	}
}
