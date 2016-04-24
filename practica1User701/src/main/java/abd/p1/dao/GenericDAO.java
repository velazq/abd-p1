package abd.p1.dao;

import java.io.Serializable;

public interface GenericDAO<Entity, Id extends Serializable> {
	public void persist(Entity entity);
	public void update(Entity entity);
	public Entity findById(Id id);
	public void delete(Entity entity);
}
