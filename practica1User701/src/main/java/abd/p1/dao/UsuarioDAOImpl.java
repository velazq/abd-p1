package abd.p1.dao;

import org.hibernate.SessionFactory;

import abd.p1.model.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO {

	public UsuarioDAOImpl(SessionFactory sf) {
		super(sf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Usuario> getEntityClass() {
		return Usuario.class;
	}

}
