package abd.p1.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Opcion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Pregunta preguntaMadre;
	private int numeroOrden;
	private String texto;
	
	@OneToMany(mappedBy="opcion")
	private Set<Responde> respuestas;

	public Opcion() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Pregunta getPreguntaMadre() {
		return preguntaMadre;
	}

	public void setPreguntaMadre(Pregunta preguntaMadre) {
		this.preguntaMadre = preguntaMadre;
	}

	public int getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + numeroOrden + ") " + texto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + numeroOrden;
		result = prime * result + ((preguntaMadre == null) ? 0 : preguntaMadre.hashCode());
		result = prime * result + ((respuestas == null) ? 0 : respuestas.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
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
		Opcion other = (Opcion) obj;
		if (id != other.id)
			return false;
		if (numeroOrden != other.numeroOrden)
			return false;
		if (preguntaMadre == null) {
			if (other.preguntaMadre != null)
				return false;
		} else if (!preguntaMadre.equals(other.preguntaMadre))
			return false;
		if (respuestas == null) {
			if (other.respuestas != null)
				return false;
		} else if (!respuestas.equals(other.respuestas))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}
}
