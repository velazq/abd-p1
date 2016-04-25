package abd.p1.controller;

import abd.p1.dao.UsuarioDAO;
import abd.p1.model.Usuario;

public class UsuarioController {
	
	private final UsuarioDAO usuarioDAO;

	public UsuarioController(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public Usuario login(String email, String passwd) {
		Usuario usuario = usuarioDAO.findByEmail(email);
		if (usuario != null && !passwd.equals(usuario.getContrasena())) {
			return null;
		}
		return usuario;
	}

}
