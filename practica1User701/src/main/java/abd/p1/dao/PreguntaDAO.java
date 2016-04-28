package abd.p1.dao;

import java.util.List;

import abd.p1.model.Pregunta;

public interface PreguntaDAO extends GenericDAO<Pregunta, Integer> {
	
	public List<Pregunta> topQuestions(int limit);
	
	public List<Pregunta> findQuestionsContaining(String text);
	
	public List<Pregunta> getAllQuestions();
	
	public Pregunta randomQuestion();

}
