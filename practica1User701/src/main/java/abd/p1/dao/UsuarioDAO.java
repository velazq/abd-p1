package abd.p1.dao;

import java.util.List;

import abd.p1.model.Usuario;

public interface UsuarioDAO {

	Usuario login(String loginName, String passwd);

	List<Usuario> nearestUsers(Usuario usr, String nameFilter, int limit);

	int compatibility(Usuario usr1, Usuario usr2);

}