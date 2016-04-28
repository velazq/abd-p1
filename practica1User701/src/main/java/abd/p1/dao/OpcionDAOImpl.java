package abd.p1.dao;

import org.hibernate.SessionFactory;

import abd.p1.model.Opcion;

public class OpcionDAOImpl extends GenericDAOImpl<Opcion, Integer> implements OpcionDAO {

	public OpcionDAOImpl(SessionFactory sf) {
		super(sf);
	}

	@Override
	public Class<Opcion> getEntityClass() {
		return Opcion.class;
	}


}
