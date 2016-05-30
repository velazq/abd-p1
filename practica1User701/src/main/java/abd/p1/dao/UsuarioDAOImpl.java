package abd.p1.dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import abd.p1.model.Aficion;
import abd.p1.model.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO {

	/*public UsuarioDAOImpl() {
		super();
	}*/
	
	public UsuarioDAOImpl(SessionFactory sf) {
		super(sf);
	}

	@Override
	public Class<Usuario> getEntityClass() {
		return Usuario.class;
	}
	
	@Override
	public Usuario findByName(String name) {
		String hql = "from Usuario as u where u.nombre = :nombre";
		Usuario usuario = null;
		try {
			Session s = getSession();
			Transaction tx = s.beginTransaction();
			//Session s = begin();
			Query q = s.createQuery(hql);
			q.setString("nombre", name);
			usuario = (Usuario) q.uniqueResult();
			s.evict(usuario); // Desenganchamos al usuario de la sesión para poder cambiarlo sin que se guarden los cambios
			tx.commit();
			
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
		}
		return usuario;
	}
	
	public Usuario findByEmail(String email) {
		String hql = "from Usuario as u where u.email = :email";
		Usuario usuario = null;
		Session s = getSession();
		try {
			Transaction tx = s.beginTransaction();
			Query q = s.createQuery(hql);
			q.setString("email", email);
			q.setMaxResults(1);
			usuario = (Usuario) q.uniqueResult();
			s.evict(usuario);
			tx.commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
		}
		return usuario;
	}

	/*
	@SuppressWarnings("unchecked")
	private List<Usuario> nearest(Usuario usr, String nameFilter, int limit, String hql) {
		String name = (nameFilter == null) ? "" : nameFilter.trim().toLowerCase();
		boolean filtering = !name.equals("");
		if (filtering)
			hql += "and lower(u.nombre) like :name ";
		hql += "order by power(:latitud - u.latitud, 2) + power(:longitud - u.longitud, 2)";
		List<Usuario> usrs = null;
		try {
			//Session s = begin();
			Session s = getSession();
			Transaction tx = s.beginTransaction();
			Query q = s.createQuery(hql);
			q.setInteger("thisId", usr.getId());
			q.setString("preferencia", usr.getOpcionSexual());
			q.setDouble("latitud", usr.getLatitud());
			q.setDouble("longitud", usr.getLongitud());
			if (filtering)
				q.setString("name", '%' + name + '%');
			if (limit > 0)
				q.setMaxResults(limit);
			usrs = (List<Usuario>) q.list();
			tx.commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
		}
		return usrs;
	}

	@Override
	public List<Usuario> nearestUsers(Usuario usr, String nameFilter, int limit) {
		String hql = "from Usuario as u "
				+ "where u.genero = :preferencia and u.id != :thisId ";
		return nearest(usr, nameFilter, limit, hql);
	}

	@Override
	public List<Usuario> nearestFriends(Usuario usr, String nameFilter, int limit) {
		String hql = "select a from Usuario u join Usuario.amigos a "
				+ "where u.genero = :preferencia and u.id = :thisId ";
		return nearest(usr, nameFilter, limit, hql);
	}
	*/
	
	public List<Usuario> listPeople(Usuario usr, boolean nearest, boolean friends, String nameFilter, int limit) {
		String hql = "";
		
		if (friends) {
			hql = "select a from Usuario u join Usuario.amigos a where u.id = :thisId ";
		} else {
			hql = "from Usuario as u where u.id != :thisId ";
		}
		
		boolean preferenciaOK = usr.getOpcionSexual() != null && !usr.getOpcionSexual().equals("");
		if (preferenciaOK) {
			hql += "and u.genero = :preferencia ";
		}
		
		boolean nameOK = nameFilter != null && !nameFilter.trim().toLowerCase().equals("");
		String name = "";
		if (nameOK) {
			hql += "and lower(u.nombre) like :name ";
			name = nameFilter.trim().toLowerCase();
		}
		
		boolean coordOK = nearest && usr.getLatitud() != null && usr.getLongitud() != null;
		if (coordOK) {
			hql += "order by power(:latitud - u.latitud, 2) + power(:longitud - u.longitud, 2)";
		}
		
		List<Usuario> usrs = new LinkedList<>();
		
		try {
			//Session s = begin();
			Session s = getSession();
			Transaction tx = s.beginTransaction();
			
			Query q = s.createQuery(hql);
			q.setInteger("thisId", usr.getId());
			if (preferenciaOK) {
				q.setString("preferencia", usr.getOpcionSexual());
			}
			if (coordOK) {
	 			q.setDouble("latitud", usr.getLatitud());
				q.setDouble("longitud", usr.getLongitud());
			}
			if (nameOK) {
				q.setString("name", '%' + name + '%');
			}
			if (limit > 0) {
				q.setMaxResults(limit);
			}
			
			for (Object obj: q.list()) {
				usrs.add((Usuario)obj);
			}
			
			tx.commit();
			
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
		}
		
		return usrs;
	}
	
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Aficion> commonHobbies(Usuario usr1, Usuario usr2) {
		String hql = "select a1 "
				+ "from Usuario u1 join u1.aficiones a1 join Usuario u2 join u2.aficiones a2 "
				+ "where u1.id = :id1 and u2.id = :id2 and lower(a1.texto) = lower(a2.texto)";
		List<Aficion> hobbies = null;
		try {
			Session s = begin();
			Query q = s.createQuery(hql);
			q.setInteger("id1", usr1.getId());
			q.setInteger("id2", usr2.getId());
			hobbies = (List<Aficion>) q.list();
			commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
		}
		return hobbies;
	}

	@Override
	public void evict(Usuario usr) {
		Session s = begin();
		s.evict(usr);
		commit();
	}
}
