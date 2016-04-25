package abd.p1.dao;

import java.util.List;

import abd.p1.model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {

	Usuario findByEmail(String email);

	int compatibility(Usuario usr1, Usuario usr2);

	Usuario findByName(String name);

	List<Usuario> nearestUsers(Usuario usr, String nameFilter, int limit);

}