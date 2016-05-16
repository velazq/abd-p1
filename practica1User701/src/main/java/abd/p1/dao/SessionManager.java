package abd.p1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SessionManager {
	
	private static SessionManager instance = null;
	
	private static SessionFactory sessionFactory = null;
	
	private Session session = null;
	
	private Transaction transaction = null;

	private SessionManager() {
	}
	
	public static SessionManager getInstance() {
		if (instance == null) {
			instance = new SessionManager();
		}
		return instance;
	}
	
	public static void setSessionFactory(SessionFactory sf) {
		sessionFactory = sf;
	}
	
	public void closeSession() {
		if (session != null) {
			session.close();
			session = null;
		}
	}
	
	public Session getSession() {
		if (session == null || !session.isOpen()) {
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	public Session begin() {
		transaction = getSession().beginTransaction();
		return session;
	}
	
	public void commit() {
		if (transaction != null) {
			transaction.commit();
			transaction = null;
		}
	}
	
	public void rollback() {
		if (transaction != null) {
			transaction.rollback();
			transaction = null;
		}
	}

}
