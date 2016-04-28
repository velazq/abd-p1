package abd.p1.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import abd.p1.model.Aficion;
import abd.p1.model.Opcion;
import abd.p1.model.Pregunta;
import abd.p1.model.Usuario;

public class Facade {
	
	private final SessionFactory sessionFactory;
	
	private final UsuarioDAO usuarios;
	private final PreguntaDAO preguntas;
	private final OpcionDAO opciones;

	public Facade(SessionFactory sf) {
		sessionFactory = sf;
		sf.openSession();
		
		usuarios = new UsuarioDAOImpl(sessionFactory);
		preguntas = new PreguntaDAOImpl(sessionFactory);
		opciones = new OpcionDAOImpl(sessionFactory);
	}
	
	/* === Usuario === */
	
	public Usuario findUserById(Integer id){
		return usuarios.findById(id);
	}
	
	public void insertUser(Usuario u){
		usuarios.persist(u);
	}
	
	public void updateUser(Usuario u){
		usuarios.update(u);
	}
	
	public void deleteUser(Usuario u){
		usuarios.delete(u);
	}

	public Usuario findUserByEmail(String email){
		return usuarios.findByEmail(email);
	}

	public int userCompatibility(Usuario usr1, Usuario usr2){
		return usuarios.compatibility(usr1, usr2);
	}

	public Usuario findUserByName(String name){
		return usuarios.findByName(name);
	}

	List<Usuario> nearestUsers(Usuario usr, String nameFilter, int limit){
		return usuarios.nearestUsers(usr, nameFilter, limit);
	}

	List<Aficion> commonHobbies(Usuario usr1, Usuario usr2){
		return usuarios.commonHobbies(usr1, usr2);
	}
	
	/* === Pregunta == */

	
	public void insertQuestion(Pregunta p){
		preguntas.persist(p);
	}
	
	public void updateQuestion(Pregunta p){
		preguntas.update(p);
	}
	
	public void deleteQuestion(Pregunta p){
		for (Opcion o : p.getOpciones())
			deleteOption(o); // FIXME
		preguntas.delete(p);
	}
	
	public List<Pregunta> topQuestions(int limit){
		return preguntas.topQuestions(limit);
	}
	
	public Pregunta randomQuestion(){
		return preguntas.randomQuestion();
	}
	
	public List<Pregunta> findQuestionsContaining(String text){
		return preguntas.findQuestionsContaining(text);
	}
	
	public List<Pregunta> getAllQuestions(){
		return preguntas.getAllQuestions();
	}
	
	/* === Opcion === */
	
	public void insertOption(Opcion o){
		opciones.persist(o);
	}
	
	public void updateOption(Opcion o){
		opciones.update(o);
	}
	
	public void deleteOption(Opcion o){
		opciones.delete(o);
	}

}
