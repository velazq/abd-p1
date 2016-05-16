package abd.p1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String email;
	private String contrasena;
	private String nombre;
	private String genero;
	private String opcionSexual;
	private Double latitud;		// En grados decimales
	private Double longitud;	// En grados decimales

	@Column (nullable = true)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	@Column (nullable = true)
	private byte[] foto;

	@Column (nullable = true)
	private String descripcion;
	
	@Column (nullable = true)
	@ElementCollection
	//@OneToMany(mappedBy="usuario", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	@OneToMany(mappedBy="usuario", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Aficion> aficiones;
	
//	@ManyToMany
//	private Set<Usuario> quiero; // Usuarios a las que he solicitado amistad
//	
//	@ManyToMany(mappedBy="quiero")
//	private Set<Usuario> meQuieren; // Usuarios que me han solicitado amistad
	
	@ManyToMany
	private Set<Usuario> amigos;
	
	@OneToMany(mappedBy="usuario")
	private Set<Responde> respuestas;
	
	@OneToMany(mappedBy="remitente")
	private Set<Mensaje> mensajesEnviados;
	
	@OneToMany(mappedBy="destinatario")
	private Set<Mensaje> mensajesRecibidos;

	public Usuario () {} //Necesario para @Entity
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Aficion> getAficiones() {
		if (aficiones == null)
			aficiones = new ArrayList<>();
		return aficiones;
	}

	public void setAficiones(List<Aficion> aficiones) {
		this.aficiones = aficiones;
	}

	public Set<Usuario> getAmigos() {
		if (amigos == null)
			amigos = new HashSet<>();
		return amigos;
	}

	public void setAmigos(Set<Usuario> amigos) {
		this.amigos = amigos;
	}

	public Set<Responde> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Set<Responde> respuestas) {
		this.respuestas = respuestas;
	}

	public Set<Mensaje> getMensajesEnviados() {
		return mensajesEnviados;
	}

	public void setMensajesEnviados(Set<Mensaje> mensajesEnviados) {
		this.mensajesEnviados = mensajesEnviados;
	}

	public Set<Mensaje> getMensajesRecibidos() {
		return mensajesRecibidos;
	}

	public void setMensajesRecibidos(Set<Mensaje> mensajesRecibidos) {
		this.mensajesRecibidos = mensajesRecibidos;
	}

	public String getOpcionSexual() {
		return opcionSexual;
	}

	public void setOpcionSexual(String opcionSexual) {
		this.opcionSexual = opcionSexual;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aficiones == null) ? 0 : aficiones.hashCode());
		result = prime * result + ((amigos == null) ? 0 : amigos.hashCode());
		result = prime * result + ((contrasena == null) ? 0 : contrasena.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + Arrays.hashCode(foto);
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((latitud == null) ? 0 : latitud.hashCode());
		result = prime * result + ((longitud == null) ? 0 : longitud.hashCode());
		result = prime * result + ((mensajesEnviados == null) ? 0 : mensajesEnviados.hashCode());
		result = prime * result + ((mensajesRecibidos == null) ? 0 : mensajesRecibidos.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((opcionSexual == null) ? 0 : opcionSexual.hashCode());
		result = prime * result + ((respuestas == null) ? 0 : respuestas.hashCode());
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
		Usuario other = (Usuario) obj;
		if (aficiones == null) {
			if (other.aficiones != null)
				return false;
		} else if (!aficiones.equals(other.aficiones))
			return false;
		if (amigos == null) {
			if (other.amigos != null)
				return false;
		} else if (!amigos.equals(other.amigos))
			return false;
		if (contrasena == null) {
			if (other.contrasena != null)
				return false;
		} else if (!contrasena.equals(other.contrasena))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (!Arrays.equals(foto, other.foto))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (latitud == null) {
			if (other.latitud != null)
				return false;
		} else if (!latitud.equals(other.latitud))
			return false;
		if (longitud == null) {
			if (other.longitud != null)
				return false;
		} else if (!longitud.equals(other.longitud))
			return false;
		if (mensajesEnviados == null) {
			if (other.mensajesEnviados != null)
				return false;
		} else if (!mensajesEnviados.equals(other.mensajesEnviados))
			return false;
		if (mensajesRecibidos == null) {
			if (other.mensajesRecibidos != null)
				return false;
		} else if (!mensajesRecibidos.equals(other.mensajesRecibidos))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (opcionSexual == null) {
			if (other.opcionSexual != null)
				return false;
		} else if (!opcionSexual.equals(other.opcionSexual))
			return false;
		if (respuestas == null) {
			if (other.respuestas != null)
				return false;
		} else if (!respuestas.equals(other.respuestas))
			return false;
		return true;
	}
	*/

	@Override
	public int hashCode() {
		return email.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return email.equals(other.getEmail());
	}
	
	public String toString() {
		return "NOMBRE: " + this.getNombre() + ", EMAIL: " + this.getEmail() +
				", CONTRASEÑA: " + this.getContrasena() + ", DESCRIPCION: " + this.getDescripcion() +
				", FECHA NAC: " + this.getFechaNacimiento();
	}
}
