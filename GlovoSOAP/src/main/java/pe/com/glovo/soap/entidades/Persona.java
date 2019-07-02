package pe.com.glovo.soap.entidades;
// Generated 28-jun-2019 12:16:57 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Persona generated by hbm2java
 */
@Entity
@Table(name = "persona", catalog = "glovo")
public class Persona implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idPersona;
	private String nombre;
	private String apellidos;
	private String nroTelefono;
	private String direccion;
	private String estado;
	private String nroDocumento;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private String usuarioModificacion;
	private Date fechaModificacion;
	private Set<Detallepedido> detallepedidos = new HashSet<Detallepedido>(0);

	public Persona() {
	}

	public Persona(Integer idPersona, String nombre, String apellidos, String nroTelefono, String direccion,
			String estado, String nroDocumento, String usuarioRegistro, Date fechaRegistro, String usuarioModificacion,
			Date fechaModificacion, Set<Detallepedido> detallepedidos) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nroTelefono = nroTelefono;
		this.direccion = direccion;
		this.estado = estado;
		this.nroDocumento = nroDocumento;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
		this.usuarioModificacion = usuarioModificacion;
		this.fechaModificacion = fechaModificacion;
		this.detallepedidos = detallepedidos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idPersona", unique = true, nullable = false)
	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellidos", length = 100)
	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Column(name = "nroTelefono", length = 45)
	public String getNroTelefono() {
		return this.nroTelefono;
	}

	public void setNroTelefono(String nroTelefono) {
		this.nroTelefono = nroTelefono;
	}

	@Column(name = "direccion", length = 100)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "estado", length = 10)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name = "usuarioRegistro", length = 45)
	public String getUsuarioRegistro() {
		return this.usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaRegistro", length = 26)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "usuarioModificacion", length = 45)
	public String getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaModificacion", length = 26)
	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
	public Set<Detallepedido> getDetallepedidos() {
		return this.detallepedidos;
	}

	public void setDetallepedidos(Set<Detallepedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}

	@Column(name = "nroDocumento", length = 26)
	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

}
