package abd.p1.view;

import abd.p1.model.Usuario;

public class ViewMgr {
	
	private static PrincipalJFrame mainWindow = null;
	private static Usuario usuario = null;
	private static Usuario usuarioVisualizado = null;

	private ViewMgr() {
	}

	public static PrincipalJFrame getMainWindow() {
		return mainWindow;
	}

	public static void setMainWindow(PrincipalJFrame mainWindow) {
		ViewMgr.mainWindow = mainWindow;
	}

	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		ViewMgr.usuario = usuario;
	}

	public static Usuario getUsuarioVisualizado() {
		return usuarioVisualizado;
	}

	public static void setUsuarioVisualizado(Usuario usuario) {
		ViewMgr.usuarioVisualizado = usuario;
	}
	
	

}
