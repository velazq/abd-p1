package abd.p1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SessionManager {
	
	//private static SessionManager instance = null;
	
	private static SessionFactory sf = null;
	
	//private Session session = null;
	
	private static Session session = null;

	private SessionManager() {
		
	}
	
	/*public SessionManager getInstance() {
		if (instance == null) {
			instance = new SessionManager();
		}
		return instance;
	}*/
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		sf = sessionFactory;
	}
	
	public void closeSession() {
		if (session != null) {
			session.close();
			session = null;
		}
	}
	
	public Session openSession() {
		closeSession();
		session = sf.openSession();
		return session;
	}
	
	public Session getSession() {
		if (session == null) {
			openSession();
		}
		return session;
	}
	
	/*public Session begin() {
		getSession();
		session.beginTransaction();
		return session;
	}*/

}
