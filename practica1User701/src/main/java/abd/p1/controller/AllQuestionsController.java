package abd.p1.controller;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import abd.p1.view.QuestionEditor;
import abd.p1.dao.Facade;
import abd.p1.model.Opcion;
import abd.p1.model.Pregunta;

/**
 * Controlador de la ventana principal.
 * 
 * @author Manuel Montenegro (mmontene@ucm.es)
 */
public class AllQuestionsController {
//    private final GenericDBFacade<Pregunta, Opcion> dao;
	private final Facade dao;
    private final DefaultListModel<Pregunta> questionsModel;
    
    

//    public AllQuestionsController(DefaultListModel<Pregunta> questionsModel, GenericDBFacade<Pregunta, Opcion> dao) {
    public AllQuestionsController(DefaultListModel<Pregunta> questionsModel, Facade dao) {
        this.questionsModel = questionsModel;
        this.dao = dao;
    }
    
    
    
    public Pregunta newQuestion(JDialog parent)  {
    	Pregunta newQuestion = new Pregunta();
        String statement = JOptionPane.showInputDialog("Introduce el enunciado de la pregunta:");
        if (statement != null && !statement.trim().isEmpty()) {
        	newQuestion.setEnunciado(statement);
            DefaultListModel<Opcion> answersModel = new DefaultListModel<>();
            QuestionController ctrl = new QuestionController(dao, newQuestion, answersModel);
            QuestionEditor editor = new QuestionEditor(ctrl, answersModel);
            editor.setLocationRelativeTo(parent);
            dao.insertQuestion(newQuestion);
            editor.setVisible(true);
            questionsModel.addElement(newQuestion);
        }
        return newQuestion;
    }
    
    public void gatherAllQuestions() {
        List<Pregunta> questions = dao.getAllQuestions();
        questionsModel.clear();
        for (Pregunta q : questions) {
            questionsModel.addElement(q);
        }
    }
    
    public void findByName(String name) {
        List<Pregunta> questions = dao.findQuestionsContaining(name);
        questionsModel.clear();
        for (Pregunta q : questions) {
            questionsModel.addElement(q);
        }
    }

    public void removeQuestion(Pregunta selected) {
        questionsModel.removeElement(selected);
        dao.deleteQuestion(selected);
    }

    public void updateQuestion(Pregunta question, JDialog parent) {
        Iterable<Opcion> answers = question.getOpciones(); 
        DefaultListModel<Opcion> mod = new DefaultListModel<>();
        for (Opcion a : answers) {
            mod.addElement(a);
        }
        QuestionController ctrl = new QuestionController(dao, question, mod);
        QuestionEditor editor = new QuestionEditor(ctrl, mod);
        editor.setLocationRelativeTo(parent);
        editor.setVisible(true);
    }
    
}
