package abd.p1.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import abd.p1.model.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO {

	public UsuarioDAOImpl(SessionFactory sf) {
		super(sf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Usuario> getEntityClass() {
		return Usuario.class;
	}
	
	public Usuario login(String loginName, String passwd) {
		Usuario usuario = null;
		try {
			Session s = begin();
			Query q = s.createQuery("from usuario as u where u.email = :email");
			q.setString("email", loginName);
			Usuario usr = (Usuario) q.uniqueResult();
			if (usr != null && usr.getContrasena() == passwd) {
				usuario = usr;
			}
			commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
		}
		return usuario;
	}

}
