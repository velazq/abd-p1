package abd.p1.model;

import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String email;
	private String contrasena;
	private String nombre;
	private String genero;
	private String opcion_sexual;
	private Integer latitud;
	private Integer longitud;

	@Column (nullable = true)
	@Temporal(TemporalType.DATE)
	private Date fecha_nacimiento;

	@Column (nullable = true)
	private byte[] foto;

	@Column (nullable = true)
	private String descripcion;
	
	@Column (nullable = true)
	@ElementCollection
	@OneToMany(mappedBy="usuario")
	private List<Aficion> aficiones;
	
	@ManyToMany
	private Set<Usuario> quiero; // Usuarios a las que he solicitado amistad
	
	@ManyToMany(mappedBy="quiero")
	private Set<Usuario> meQuieren; // Usuarios que me han solicitado amistad
	
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
	public String getOpcion_sexual() {
		return opcion_sexual;
	}
	public void setOpcion_sexual(String opcion_sexual) {
		this.opcion_sexual = opcion_sexual;
	}
	public Integer getLatitud() {
		return latitud;
	}
	public void setLatitud(Integer latitud) {
		this.latitud = latitud;
	}
	public Integer getLongitud() {
		return longitud;
	}
	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
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

}
