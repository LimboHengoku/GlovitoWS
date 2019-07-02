package pe.com.glovo.soap.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "pagos" })
@XmlRootElement(name = "registraPagoRequest")
public class RegistraPagoRequestType {

	@XmlElement(required = true)
	protected PagosType pagos;

	public PagosType getPagos() {
		return pagos;
	}

	public void setPagos(PagosType pagos) {
		this.pagos = pagos;
	}

}
