package abd.p1.controller;

/**
 * Excepción lanzada por la herramienta de inserción de preguntas.
 *
 * @author Manuel Montenegro (mmontene@ucm.es)
 */
public class AdminUIException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AdminUIException(String msg) {
        super(msg);
    }    
}
