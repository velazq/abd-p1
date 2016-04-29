package abd.p1.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

import org.hibernate.SessionFactory;

import abd.p1.dao.UsuarioDAO;
import abd.p1.dao.UsuarioDAOImpl;
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
	
	//public UsuarioController() {}
	
	private final UsuarioDAO usuarioDAO;

	public UsuarioController(SessionFactory sf, PrincipalJFrame mainWindow) {
		this.usuarioDAO = new UsuarioDAOImpl(sf);
		this.mainWindow = mainWindow;
	}
	
	/*
	public Usuario loginCheck(String email, String passwd) {
		Usuario usuario = usuarioDAO.findByEmail(email);
		if (usuario != null && !passwd.equals(usuario.getContrasena())) {
			return null;
		}
		return usuario;
	}
	*/
	
	public void listUsers(Usuario usr, String filterByName, boolean friends) {
		List<Usuario> usrs = null;
		if (friends) {
			usrs = usuarioDAO.nearestFriends(usr, filterByName, MAX_USERS_IN_LIST);
		} else {
			usrs = usuarioDAO.nearestUsers(usr, filterByName, MAX_USERS_IN_LIST);
		}
		mainWindow.listUsers(usrs);
	}
	
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
		usuarioDAO.update(usr);
	}
	
	public void loginShow() {
		Usuario usr = null;
		
        InicioSesionJDialog loginDialog = new InicioSesionJDialog(null, true);
        loginDialog.setVisible(true);
        
    	String email = loginDialog.getEmail();
    	String pass = loginDialog.getPassword();
    	//usr = Facade.getInstance().findUserByEmail(email);
        usr = usuarioDAO.findByEmail(email);
        
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
            	usr.setNombre("Sin nombre");
            	usr.setFechaNacimiento(new Date());
            	//Facade.getInstance().insertUser(usr);
            	usuarioDAO.persist(usr);
            }
        }

    	if (usr != null) {
        	//Facade.getInstance().evictUser(usr);
    		usuarioDAO.evict(usr);
    		mainWindow.setUser(usr);
    		mainWindow.setVisible(true);
    		if (loginDialog.isNuevoUsuario()) {
            	EditarPerfil perfil = new EditarPerfil(mainWindow, true, usr);
                perfil.setVisible(true);
    		}
    	}
	}
	
	public void save(Usuario usr) {
		usuarioDAO.persist(usr);
	}
}
