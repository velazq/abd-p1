package abd.p1.dao;

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
	
	/* (non-Javadoc)
	 * @see abd.p1.dao.UsuarioDAO#login(java.lang.String, java.lang.String)
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see abd.p1.dao.UsuarioDAO#nearestUsers(abd.p1.model.Usuario, java.lang.String, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> nearestUsers(Usuario usr, String nameFilter, int limit) {
		String hql = "from Usuario as u ";
		if (nameFilter != null)
			hql += "where lower(u.nombre) like :nameFilter ";
		hql += "order by power(:latitud - u.latitud, 2) + power(:longitud - u.longitud, 2)";
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
	
	/* (non-Javadoc)
	 * @see abd.p1.dao.UsuarioDAO#compatibility(abd.p1.model.Usuario, abd.p1.model.Usuario)
	 */
	@Override
	public int compatibility(Usuario usr1, Usuario usr2) {
		String hqlMTotal = "select sum(r1.valoracion + r2.valoracion) "
				+ "from Usuario u1 join u1.respuestas as r1 join r1.opcion as o1 join o1.preguntaMadre as p1 "
				+ "join Usuario u2 join u2.respuestas as r2 join r2.opcion as o2 join o2.preguntaMadre as p2 "
				+ "where p1.id = p2.id and u1.id = :id1 and u2.id = :id2";
		String hqlMAcierto = "select sum(r1.valoracion + r2.valoracion) "
				+ "from Usuario u1 join u1.respuestas as r1 join r1.opcion as o1 join o1.preguntaMadre as p1 "
				+ "join Usuario u2 join u2.respuestas as r2 join r2.opcion as o2 join o2.preguntaMadre as p2 "
				+ "where p1.id = p2.id and o1.id = o2.id and u1.id = :id1 and u2.id = :id2";
		
		Integer id1 = usr1.getId();
		Integer id2 = usr2.getId();
		Integer compat = 0;
		Integer mTotal = 0;
		Integer mAcierto = 0;
		try {
			Session s = begin();
			Query q = s.createQuery(hqlMTotal);
			q.setInteger("id1", id1);
			q.setInteger("id2", id2);
			mTotal = (Integer) q.uniqueResult();
			
			Query q2 = s.createQuery(hqlMAcierto);
			q2.setInteger("id1", id1);
			q2.setInteger("id2", id2);
			mAcierto = (Integer) q2.uniqueResult();
			commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
		}
		if (mTotal > 0)
			compat = Math.round(100 * (mAcierto / mTotal));
		return compat;
	}

}
