package abd.p1.dao;

import java.util.List;

import abd.p1.model.Pregunta;

public interface PreguntaDAO extends GenericDAO<Pregunta, Integer> {
	
	List<Pregunta> topQuestions(int limit);

}
