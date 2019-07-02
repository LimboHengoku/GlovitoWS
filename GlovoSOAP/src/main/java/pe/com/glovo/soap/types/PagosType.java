package pe.com.glovo.soap.types;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pagos", propOrder = { "idPago", "tipoPagoType", "fechaPago", "montoApagar", "estado" })
public class PagosType {

	@XmlElement(required = true)
	protected int idPago;

	@XmlElement(required = true)
	protected TipoPagoRequestType tipoPagoType;

	@XmlElement(required = true)
	protected Date fechaPago;

	@XmlElement(required = true)
	protected String montoApagar;

	@XmlElement(required = true)
	protected String estado;

	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public TipoPagoRequestType getTipoPagoType() {
		return tipoPagoType;
	}

	public void setTipoPagoType(TipoPagoRequestType tipoPagoType) {
		this.tipoPagoType = tipoPagoType;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getMontoApagar() {
		return montoApagar;
	}

	public void setMontoApagar(String montoApagar) {
		this.montoApagar = montoApagar;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
