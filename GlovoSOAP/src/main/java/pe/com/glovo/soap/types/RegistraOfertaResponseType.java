package pe.com.glovo.soap.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "genericoResponse" })
@XmlRootElement(name = "registraOfertaResponse")
public class RegistraOfertaResponseType {
	
	@XmlElement(required = true)
	protected GenericoResponseType genericoResponse;

	public GenericoResponseType getGenericoResponse() {
		return genericoResponse;
	}

	public void setGenericoResponse(GenericoResponseType genericoResponse) {
		this.genericoResponse = genericoResponse;
	}

}
