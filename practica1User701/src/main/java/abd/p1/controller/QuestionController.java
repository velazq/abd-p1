package abd.p1.controller;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import abd.p1.dao.Facade;
import abd.p1.model.Opcion;
import abd.p1.model.Pregunta;


public class QuestionController {
//    private final GenericDBFacade<Pregunta, Opcion> dao;
	private final Facade dao;
    private final Pregunta model;
    private final DefaultListModel<Opcion> answersModel;

//    public QuestionController(GenericDBFacade<Pregunta, Opcion> dao, Pregunta model, DefaultListModel<Opcion> answersModel) {
    public QuestionController(Facade dao, Pregunta model, DefaultListModel<Opcion> answersModel) {
        this.dao = dao;
        this.model = model;
        this.answersModel = answersModel;
    }
    
    public String getQuestionStatement() {
    	return model.getEnunciado();
    }
    
    public String setQuestionStatement() {
        String newStatement = JOptionPane.showInputDialog("Introduce el nuevo enunciado:", model.getEnunciado());
        if (newStatement != null && !newStatement.trim().isEmpty()) {
        	model.setEnunciado(newStatement);
            dao.updateQuestion(model);
        }
        return newStatement;
    }
    
    public void addAnswer() {
        String answerText = JOptionPane.showInputDialog("Introduce nueva respuesta:");
        if (answerText != null && !answerText.trim().isEmpty()) {
            Opcion newAnswer = new Opcion();
            newAnswer.setTexto(answerText);
            model.addOpcion(newAnswer);
            answersModel.addElement(newAnswer);
            dao.insertOption(newAnswer);
        }
    }
    
    public void editAnswer(Opcion a) {
        String answerNewText = JOptionPane.showInputDialog("Introduce nuevo nombre de respuesta:", a.getTexto());
        if (answerNewText != null && !answerNewText.trim().isEmpty()) {
        	a.setTexto(answerNewText);
            dao.updateOption(a);
        }
    }

    public void removeAnswer(Opcion answer) {
    	model.removeOpcion(answer);
        int number = answer.getNumeroOrden();
        int numAnswers = model.getNumOpciones();
        answersModel.removeElement(answer);
        dao.deleteOption(answer);
        for (int i = number; i <= numAnswers; i++) {
        	Opcion currentAnswer = model.getOpcion(i);
            dao.updateOption(currentAnswer);
        }
    }

    public void moveAnswerUp(Opcion answer) {
    	int number = answer.getNumeroOrden();
        if (number > 1) {
        	Opcion previousAnswer = model.getOpcion(number - 1);
        	model.intercambiarOpciones(number, number - 1);
            answersModel.set(number - 1, previousAnswer);
            answersModel.set(number - 2, answer);
            dao.updateOption(answer);
            dao.updateOption(previousAnswer);
        }
    }

    public void moveAnswerDown(Opcion answer) {
    	int number = answer.getNumeroOrden();
    	int numAnswers = model.getNumOpciones();
        if (number < numAnswers) {
        	Opcion nextAnswer = model.getOpcion(number + 1);
        	model.intercambiarOpciones(number, number + 1);
            answersModel.set(number - 1, nextAnswer);
            answersModel.set(number, answer);
            dao.updateOption(answer);
            dao.updateOption(nextAnswer);
        }
    }
}
