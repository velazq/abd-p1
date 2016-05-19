package abd.p1.dao;

import java.util.List;

import abd.p1.model.Aficion;
import abd.p1.model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {

	public Usuario findByEmail(String email);

	public int compatibility(Usuario usr1, Usuario usr2);

	public Usuario findByName(String name);

	//public List<Usuario> nearestUsers(Usuario usr, String nameFilter, int limit);
	
	//public List<Usuario> nearestFriends(Usuario usr, String nameFilter, int limit);
	
	public List<Usuario> listPeople(Usuario usr, boolean nearest, boolean friends, String nameFilter, int limit);

	public List<Aficion> commonHobbies(Usuario usr1, Usuario usr2);
	
	public void evict(Usuario usr);

}