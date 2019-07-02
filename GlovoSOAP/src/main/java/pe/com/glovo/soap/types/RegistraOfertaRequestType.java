package pe.com.glovo.soap.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "oferta" })
@XmlRootElement(name = "registraOfertaRequest")
public class RegistraOfertaRequestType {

	@XmlElement(required = true)
	protected OfertaType oferta;

	public OfertaType getOferta() {
		return oferta;
	}

	public void setOferta(OfertaType oferta) {
		this.oferta = oferta;
	}

}
