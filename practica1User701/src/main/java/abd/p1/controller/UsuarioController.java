package abd.p1.controller;

import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

import abd.p1.dao.Facade;
import abd.p1.math.SphericalGeometry;
import abd.p1.model.Usuario;
import abd.p1.view.EditarPerfil;
import abd.p1.view.InicioSesionJDialog;
import abd.p1.view.PrincipalJFrame;

public class UsuarioController {
	
	private static final int MAX_USERS_IN_LIST = 20;
	
	private static final double LATITUDE_LOWER_BOUND = 40.0;
	private static final double LATITUDE_UPPER_BOUND = 41.2;
	private static final double LONGITUDE_LOWER_BOUND = 3.0;
	private static final double LONGITUDE_UPPER_BOUND = 4.5;
	
	private PrincipalJFrame mainWindow;
	
	public UsuarioController() {}
	
	/*private final UsuarioDAO usuarioDAO;

	public UsuarioController(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public Usuario loginCheck(String email, String passwd) {
		Usuario usuario = usuarioDAO.findByEmail(email);
		if (usuario != null && !passwd.equals(usuario.getContrasena())) {
			return null;
		}
		return usuario;
	}
	
	public List<Usuario> listUsers(Usuario usr, String filterByName) {
		return usuarioDAO.nearestUsers(usr, filterByName, MAX_USERS_IN_LIST);
	}*/
	
	public long distance(Usuario usr1, Usuario usr2) {
		double phi1 = usr1.getLatitud();
		double theta1 = usr1.getLongitud();
		double phi2 = usr2.getLatitud();
		double theta2 = usr2.getLongitud();
		double d = SphericalGeometry.haversineFormulaDegrees(phi1, theta1, phi2, theta2);
		return Math.round(d);
	}
	
	public void storeRandomCoordinates(Usuario usr) {
		double latitude = ThreadLocalRandom.current().nextDouble(LATITUDE_LOWER_BOUND, LATITUDE_UPPER_BOUND);
		double longitude = ThreadLocalRandom.current().nextDouble(LONGITUDE_LOWER_BOUND, LONGITUDE_UPPER_BOUND);
		usr.setLatitud(latitude);
		usr.setLongitud(longitude);
		Facade.getInstance().updateUser(usr);
	}
	
	public void loginShow() {
		Usuario usr = null;
		
        InicioSesionJDialog loginDialog = new InicioSesionJDialog(null, true);
        loginDialog.setVisible(true);
        
    	String email = loginDialog.getEmail();
    	String pass = loginDialog.getPassword();
    	usr = Facade.getInstance().findUserByEmail(email);
        
        if (loginDialog.isAceptar()) {
        	if (usr == null) {
        		JOptionPane.showMessageDialog(loginDialog,
                        "El usuario no está registrado.",
                        "Error de usuario",
                        JOptionPane.ERROR_MESSAGE);
        	}
        } else if (loginDialog.isNuevoUsuario()) {
            if(usr != null) {
                JOptionPane.showMessageDialog(loginDialog,
	                "El usuario ya está registrado.",
	                "Usuario registrado",
	                JOptionPane.ERROR_MESSAGE);
            } else {
            	usr = new Usuario();
            	usr.setEmail(email);
            	usr.setContrasena(pass);
            	Facade.getInstance().insertUser(usr);
            }
        }

    	if (usr != null) {
        	Facade.getInstance().evictUser(usr);
    		mainWindow = new PrincipalJFrame(usr, this);
    		mainWindow.setVisible(true);
    		if (loginDialog.isNuevoUsuario()) {
            	EditarPerfil perfil = new EditarPerfil(mainWindow, true);
                perfil.setVisible(true);
    		}
    	}
	}

}
