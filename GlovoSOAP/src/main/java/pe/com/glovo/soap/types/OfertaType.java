package pe.com.glovo.soap.types;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oferta", propOrder = { "idOferta", "producto", "fechaInicioOferta", "fechaFinOferta", "estado",
		"fechaRegistro", "usuarioRegistro", "fechaMod", "usuarioMod" })
public class OfertaType {

	@XmlElement
	protected Integer idOferta;
	
	@XmlElement
	protected ProductoType producto;
	
	@XmlElement
	protected Date fechaInicioOferta;
	
	@XmlElement
	protected Date fechaFinOferta;
	
	@XmlElement
	protected String estado;
	
	@XmlElement
	protected Date fechaRegistro;
	
	@XmlElement
	protected String usuarioRegistro;
	
	@XmlElement
	protected Date fechaMod;
	
	@XmlElement
	protected String usuarioMod;

	public Integer getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(Integer idOferta) {
		this.idOferta = idOferta;
	}

	public ProductoType getProducto() {
		return producto;
	}

	public void setProducto(ProductoType producto) {
		this.producto = producto;
	}

	public Date getFechaInicioOferta() {
		return fechaInicioOferta;
	}

	public void setFechaInicioOferta(Date fechaInicioOferta) {
		this.fechaInicioOferta = fechaInicioOferta;
	}

	public Date getFechaFinOferta() {
		return fechaFinOferta;
	}

	public void setFechaFinOferta(Date fechaFinOferta) {
		this.fechaFinOferta = fechaFinOferta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public Date getFechaMod() {
		return fechaMod;
	}

	public void setFechaMod(Date fechaMod) {
		this.fechaMod = fechaMod;
	}

	public String getUsuarioMod() {
		return usuarioMod;
	}

	public void setUsuarioMod(String usuarioMod) {
		this.usuarioMod = usuarioMod;
	}

}
