package abd.p1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SessionMgr {
	
	private static SessionFactory sessionFactory = null;
	
	private static Session session = null;

	private SessionMgr() {
	}
	
	public static void setSessionFactory(SessionFactory sf) {
		sessionFactory = sf;
	}
	
	public static Session getSession() {
		if (session == null || !session.isOpen()) {
			session = sessionFactory.openSession();
		}
		return session;
	}

}
