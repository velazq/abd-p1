package abd.p1.controller;

import org.hibernate.SessionFactory;

import abd.p1.model.Usuario;
import abd.p1.view.PrincipalJFrame;

public class ControllersFacade {
	
	private static SessionFactory SF = null;
	private static PrincipalJFrame MAINWINDOW = null;
	
	private static ControllersFacade INSTANCE = null;
	
	private final UsuarioController uCtrl;
	
	public static ControllersFacade getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ControllersFacade();
		}
		return INSTANCE;
	}
	
	public static void setParams(SessionFactory sf, PrincipalJFrame mainWindow) {
		SF = sf;
		MAINWINDOW = mainWindow;
	}

	public ControllersFacade() {
		uCtrl = new UsuarioController(SF, MAINWINDOW);
	}
	
	public void runApp() {
		uCtrl.loginShow();
	}
	
	public void listUsers(Usuario usr, String filtro, boolean amigos) {
		uCtrl.listUsers(usr, filtro, amigos);
	}
	
	public void saveUser(Usuario usr) {
		uCtrl.save(usr);
	}

}
