package pe.com.glovo.soap.types;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "listaOfertas", "genericoResponse" })
@XmlRootElement(name = "listarOfertasResponse")
public class ListarOfertasResponseType {

	@XmlElement(required = true)
	protected List<OfertaType> listaOfertas;

	@XmlElement(required = true)
	protected GenericoResponseType genericoResponse;

	public List<OfertaType> getListaOfertas() {
		return listaOfertas;
	}

	public void setListaOfertas(List<OfertaType> listaOfertas) {
		this.listaOfertas = listaOfertas;
	}

	public GenericoResponseType getGenericoResponse() {
		return genericoResponse;
	}

	public void setGenericoResponse(GenericoResponseType genericoResponse) {
		this.genericoResponse = genericoResponse;
	}

}
