package abd.p1.controller;

import java.util.List;

import abd.p1.dao.PreguntaDAO;
import abd.p1.model.Pregunta;

public class PreguntaController {

	private static final int MAX_QUESTIONS_IN_LIST = 20;
	
	private final PreguntaDAO preguntaDAO;
	
	public PreguntaController(PreguntaDAO preguntaDAO) {
		this.preguntaDAO = preguntaDAO;
	}
	
	public List<Pregunta> topQuestions() {
		return preguntaDAO.topQuestions(MAX_QUESTIONS_IN_LIST);
	}

}
