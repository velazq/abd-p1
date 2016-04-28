package abd.p1.model;

import java.util.LinkedList;
import javax.persistence.*;

import java.util.List;

@Entity
public class Pregunta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String enunciado;
	
	@OneToMany (mappedBy = "preguntaMadre", fetch = FetchType.EAGER)
	private List<Opcion> opciones;
	
	@OneToMany(mappedBy = "pregunta")
	private List<Invitacion> invitaciones;//FIXME: no lo necesitamos

	public Pregunta () {}
        
        //PRUEBA
        public Pregunta(Integer id, String enunciado){
            this.id = id;
            this.enunciado = enunciado;
            this.opciones = new LinkedList<>();
        }
	
//	public Pregunta() {
//		opciones = new ArrayList<>();
//	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public List<Opcion> getOpciones() {
		return opciones;
	}
	
	public void addOpcion(Opcion o) {
		o.setPreguntaMadre(this);
		o.setNumeroOrden(opciones.size() + 1);
		opciones.add(o);
	}
	
	public void removeOpcion(Opcion o) {
		int ordenOpcion = o.getNumeroOrden();
		for (int i = ordenOpcion + 1; i <= opciones.size(); i++) {
			opciones.get(i - 1).setNumeroOrden(i - 1);
		}
		o.setPreguntaMadre(null);
		opciones.remove(ordenOpcion - 1);
	}
	
	public int getNumOpciones() {
		return opciones.size();
	}
	
	public Opcion getOpcion(int num) {
		return opciones.get(num - 1);
	}
	
	public void intercambiarOpciones(int i, int j) {
		Opcion opcI = opciones.get(i - 1);
		Opcion opcJ = opciones.get(j - 1);
		opcI.setNumeroOrden(j);
		opcJ.setNumeroOrden(i);
		opciones.set(i - 1, opcJ);
		opciones.set(j - 1, opcI);
	}

	@Override
	public String toString() {
		return "Pregunta [enunciado=" + enunciado + ", opciones=" + opciones + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enunciado == null) ? 0 : enunciado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((invitaciones == null) ? 0 : invitaciones.hashCode());
		result = prime * result + ((opciones == null) ? 0 : opciones.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pregunta other = (Pregunta) obj;
		if (enunciado == null) {
			if (other.enunciado != null)
				return false;
		} else if (!enunciado.equals(other.enunciado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (invitaciones == null) {
			if (other.invitaciones != null)
				return false;
		} else if (!invitaciones.equals(other.invitaciones))
			return false;
		if (opciones == null) {
			if (other.opciones != null)
				return false;
		} else if (!opciones.equals(other.opciones))
			return false;
		return true;
	}
}
