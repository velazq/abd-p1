package abd.p1.dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class GenericDAOImpl<Entity, Id extends Serializable> implements GenericDAO<Entity, Id> {
	
	private final SessionFactory sf;

	public GenericDAOImpl(SessionFactory sf) {
		this.sf = sf;
	}
	
	public abstract Class<Entity> getEntityClass();
	
	protected Session begin() {
		Session session = this.sf.openSession();
		session.beginTransaction();
		return session;
	}
	
	protected void commit() {
		Session session = this.sf.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.commit();
		session.close();
	}
	
	protected void rollback() {
		Session session = this.sf.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.rollback();
		session.close();
	}

	@Override
	public void persist(Entity entity) {
		try {
			Session s = begin();
			s.save(entity);
			commit();
		} catch (HibernateException e) {
			rollback();
		}
	}

	@Override
	public void update(Entity entity) {
		try {
			Session s = begin();
			s.update(entity);
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		
	}

	@Override
	public Entity findById(Id id) {
		Entity entity = null;
		try {
			Session s = begin();
			s.load(getEntityClass(), id);
			commit();
		} catch (HibernateException e) {
			rollback();
		}
		return entity;
	}

	@Override
	public void delete(Entity entity) {
		try {
			Session s = begin();
			s.delete(entity);
			commit();
		} catch (HibernateException e) {
			rollback();
		}
	}

}
