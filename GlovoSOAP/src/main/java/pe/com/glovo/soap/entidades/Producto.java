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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Producto generated by hbm2java
 */
@Entity
@Table(name = "producto", catalog = "glovo")
public class Producto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idProducto;
	private Categoria categoria;
	private Proveedor proveedor;
	private String nombreProducto;
	private Long precioUnidad;
	private String estado;
	private String usuarioRegistro;
	private Date fechaRegistro;
	private String usuarioModificacion;
	private Date fechaModificacion;
	private Set<Detallepedido> detallepedidos = new HashSet<Detallepedido>(0);
	private Set<Ofertas> ofertases = new HashSet<Ofertas>(0);

	public Producto() {
	}

	public Producto(Categoria categoria, Proveedor proveedor, String nombreProducto, Long precioUnidad, String estado,
			String usuarioRegistro, Date fechaRegistro, String usuarioModificacion, Date fechaModificacion,
			Set<Detallepedido> detallepedidos, Set<Ofertas> ofertases) {
		this.categoria = categoria;
		this.proveedor = proveedor;
		this.nombreProducto = nombreProducto;
		this.precioUnidad = precioUnidad;
		this.estado = estado;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
		this.usuarioModificacion = usuarioModificacion;
		this.fechaModificacion = fechaModificacion;
		this.detallepedidos = detallepedidos;
		this.ofertases = ofertases;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idProducto", unique = true, nullable = false)
	public Integer getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCategoria")
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProveedor")
	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Column(name = "nombreProducto", length = 45)
	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	@Column(name = "precioUnidad", precision = 10, scale = 0)
	public Long getPrecioUnidad() {
		return this.precioUnidad;
	}

	public void setPrecioUnidad(Long precioUnidad) {
		this.precioUnidad = precioUnidad;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
	public Set<Detallepedido> getDetallepedidos() {
		return this.detallepedidos;
	}

	public void setDetallepedidos(Set<Detallepedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
	public Set<Ofertas> getOfertases() {
		return this.ofertases;
	}

	public void setOfertases(Set<Ofertas> ofertases) {
		this.ofertases = ofertases;
	}

}
