package pe.com.glovo.soap.types;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "listaTipoPago","genericoResponse" })
@XmlRootElement(name = "listarTipoPagoResponse")
public class ListarTipoPagoResponseType {

	@XmlElement(required = true)
	protected List<TipoPagoRequestType> listaTipoPago;

	@XmlElement(required = true)
	protected GenericoResponseType genericoResponse;

	public List<TipoPagoRequestType> getListaTipoPago() {
		return listaTipoPago;
	}

	public void setListaTipoPago(List<TipoPagoRequestType> listaTipoPago) {
		this.listaTipoPago = listaTipoPago;
	}

	public GenericoResponseType getGenericoResponse() {
		return genericoResponse;
	}

	public void setGenericoResponse(GenericoResponseType genericoResponse) {
		this.genericoResponse = genericoResponse;
	}

}
