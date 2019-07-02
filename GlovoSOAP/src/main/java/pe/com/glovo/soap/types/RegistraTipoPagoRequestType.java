package pe.com.glovo.soap.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "tipoPagoType" })
@XmlRootElement(name = "registraTipoPagoRequest")
public class RegistraTipoPagoRequestType {

	@XmlElement(required = true)
	protected TipoPagoRequestType tipoPagoType;

	public TipoPagoRequestType getTipoPagoType() {
		return tipoPagoType;
	}

	public void setTipoPagoType(TipoPagoRequestType tipoPagoType) {
		this.tipoPagoType = tipoPagoType;
	}

}
