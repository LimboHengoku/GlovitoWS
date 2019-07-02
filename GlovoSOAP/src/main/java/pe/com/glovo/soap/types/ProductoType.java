package pe.com.glovo.soap.types;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "producto", propOrder = { "nombreProducto", "precioUnidad", "estado"
			, "usuarioRegistro", "fechaRegistro","usuarioModificacion","fechaModificacion" })
public class ProductoType {

	@XmlElement
	protected Integer idProducto;
//	private Categoria categoria;
//	private Proveedor proveedor;
	@XmlElement
	protected String nombreProducto;

	@XmlElement
	protected Long precioUnidad;

	@XmlElement
	protected String estado;

	@XmlElement
	protected String usuarioRegistro;

	@XmlElement
	protected Date fechaRegistro;

	@XmlElement
	protected String usuarioModificacion;

	@XmlElement
	protected Date fechaModificacion;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Long getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(Long precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

}
