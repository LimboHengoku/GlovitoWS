package pe.com.glovo.soap.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "genericoResponse",
propOrder = { "codigoGenerado", "codigoRespuesta", "mensajeRespuesta" })
public class GenericoResponseType {

	@XmlElement
	protected int codigoGenerado;

	@XmlElement
	protected String codigoRespuesta;

	@XmlElement
	protected String mensajeRespuesta;

	public int getCodigoGenerado() {
		return codigoGenerado;
	}

	public void setCodigoGenerado(int codigoGenerado) {
		this.codigoGenerado = codigoGenerado;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}

}
