package abd.p1.dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class GenericDAOImpl<Entity, Id extends Serializable> implements GenericDAO<Entity, Id> {
	
	private SessionFactory sf;
	private Session session;

	//public GenericDAOImpl() {}
	
	public GenericDAOImpl(SessionFactory sf) {
		this.sf = sf;
		this.session = sf.openSession();
	}
	
	public abstract Class<Entity> getEntityClass();
	
	/*protected Session getSession() {
		//return SessionManager.getInstance().getSession();
		return SessionMgr.getSession();
	}*/
	
	protected Session getSession() {
		if (!session.isOpen()) {
			session = sf.openSession();
		}
		return session;
	}
	
	protected Session begin() {
		Session session = getSession();
		session.beginTransaction();
		return session;
	}
	
	protected void commit() {
		Session session = getSession();
		Transaction tx = session.getTransaction();
		tx.commit();
	}
	
	protected void rollback() {
		Session session = getSession();
		Transaction tx = session.getTransaction();
		tx.rollback();
	}

	@Override
	public void persist(Entity entity) {
		//Session s = this.sf.openSession();
		//Session s = getSession();
		try {
			Session s = begin();
			//Session s = getSession();
			Transaction tx = s.beginTransaction();
			s.save(entity);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			rollback();
		}
	}

	@Override
	public void update(Entity entity) {
		Session s = getSession();
		try {
			//Session s = begin();
			Transaction tx = s.beginTransaction();
			s.update(entity);
			tx.commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		} 
		
	}

	@Override
	public Entity findById(Id id) {
		Entity entity = null;
		Session s = begin();
		try {
			s.load(getEntityClass(), id);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public void delete(Entity entity) {
		Session s = begin();
		try {
			s.delete(entity);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}

}
