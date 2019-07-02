package pe.com.glovo.entidades;
// Generated 28-jun-2019 12:16:57 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ofertas generated by hbm2java
 */
@Entity
@Table(name = "ofertas", catalog = "glovo")
public class Ofertas implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idOferta;
	private Producto producto;
	private Date fechaInicioOferta;
	private Date fechaFinOferta;
	private String estado;
	private Date fechaRegistro;
	private String usuarioRegistro;
	private Date fechaMod;
	private String usuarioMod;

	public Ofertas() {
	}

	public Ofertas(Producto producto, Date fechaInicioOferta, Date fechaFinOferta, String estado, Date fechaRegistro,
			String usuarioRegistro, Date fechaMod, String usuarioMod) {
		this.producto = producto;
		this.fechaInicioOferta = fechaInicioOferta;
		this.fechaFinOferta = fechaFinOferta;
		this.estado = estado;
		this.fechaRegistro = fechaRegistro;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaMod = fechaMod;
		this.usuarioMod = usuarioMod;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idOferta", unique = true, nullable = false)
	public Integer getIdOferta() {
		return this.idOferta;
	}

	public void setIdOferta(Integer idOferta) {
		this.idOferta = idOferta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProducto")
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaInicioOferta", length = 26)
	public Date getFechaInicioOferta() {
		return this.fechaInicioOferta;
	}

	public void setFechaInicioOferta(Date fechaInicioOferta) {
		this.fechaInicioOferta = fechaInicioOferta;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaFinOferta", length = 26)
	public Date getFechaFinOferta() {
		return this.fechaFinOferta;
	}

	public void setFechaFinOferta(Date fechaFinOferta) {
		this.fechaFinOferta = fechaFinOferta;
	}

	@Column(name = "estado", length = 10)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaRegistro", length = 26)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "usuarioRegistro", length = 45)
	public String getUsuarioRegistro() {
		return this.usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaMod", length = 26)
	public Date getFechaMod() {
		return this.fechaMod;
	}

	public void setFechaMod(Date fechaMod) {
		this.fechaMod = fechaMod;
	}

	@Column(name = "usuarioMod", length = 45)
	public String getUsuarioMod() {
		return this.usuarioMod;
	}

	public void setUsuarioMod(String usuarioMod) {
		this.usuarioMod = usuarioMod;
	}

}
