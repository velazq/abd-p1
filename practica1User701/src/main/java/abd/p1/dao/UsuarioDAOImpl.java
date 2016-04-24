package abd.p1.dao;

import java.util.ArrayList;
import java.util.List;

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
		String hql = "from Usuario as u where u.email = :email";
		Usuario usuario = null;
		try {
			Session s = begin();
			Query q = s.createQuery(hql);
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
	
	@SuppressWarnings("unchecked")
	public List<Usuario> nearestUsers(Usuario usr, String nameFilter, int limit) {
		String hql = "from Usuario as u ";
		if (nameFilter != null)
			hql += "where lower(u.nombre) like :nameFilter ";
		hql += "order by power(u.latitud - :latitud, 2) + power(u.longitud - :longitud, 2)";
		List<Usuario> usrs = null;
		try {
			Session s = begin();
			Query q = s.createQuery(hql);
			q.setDouble("latitud", usr.getLatitud());
			q.setDouble("longitud", usr.getLongitud());
			if (nameFilter != null)
				q.setString("nameFilter", '%' + nameFilter.toLowerCase() + '%');
			if (limit > 0)
				q.setMaxResults(limit);
			usrs = (List<Usuario>) q.list();
			commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
		}
		return usrs;
	}

}
