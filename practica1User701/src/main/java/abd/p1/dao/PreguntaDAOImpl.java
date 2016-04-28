package abd.p1.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import abd.p1.model.Pregunta;

public class PreguntaDAOImpl extends GenericDAOImpl<Pregunta, Integer> implements PreguntaDAO {

	public PreguntaDAOImpl(SessionFactory sf) {
		super(sf);
	}

	@Override
	public Class<Pregunta> getEntityClass() {
		return Pregunta.class;
	}

	@SuppressWarnings("unchecked")
	public List<Pregunta> topQuestions(int limit) {
		String hql = "from Pregunta p join p.opciones o join o.respuestas r "
				+ "group by p.id "
				+ "order by avg(r.valoracion) desc ";
		List<Pregunta> questions = null;
		try {
			Session s = begin();
			Query q = s.createSQLQuery(hql);
			if (limit > 0)
				q.setMaxResults(limit);
			questions = (List<Pregunta>) q.list();
			commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
		}
		return questions;
	}
	
	public Pregunta randomQuestion() {
		String hql = "from Pregunta order by rand()";
		Pregunta question = null;
		try {
			Session s = begin();
			Query q = s.createSQLQuery(hql);
			q.setMaxResults(1);
			question = (Pregunta) q.uniqueResult();
			commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
		}
		return question;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pregunta> findQuestionsContaining(String text) {
		String hql = "from Pregunta p where p.enunciado like :enunciado";
		List<Pregunta> questions = null;
		try {
			Session s = begin();
			Query q = s.createSQLQuery(hql);
			q.setString("enunciado", text);
			questions = (List<Pregunta>) q.list();
			commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
		}
		return questions;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pregunta> getAllQuestions() {
		String hql = "from Pregunta";
		List<Pregunta> questions = null;
		try {
			Session s = begin();
			Query q = s.createSQLQuery(hql);
			questions = (List<Pregunta>) q.list();
			commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
		}
		return questions;
	}
	
}
