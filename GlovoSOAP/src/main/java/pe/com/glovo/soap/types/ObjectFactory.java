//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.06.30 a las 03:06:00 AM COT 
//

package pe.com.glovo.soap.types;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the pe.com.glovo.soap.ws package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	public ObjectFactory() {
	}

	public GenericoResponseType createGenericoResponse() {
		return new GenericoResponseType();
	}

	public ListarTipoPagoResponseType createListarTipoPagoResponseType() {
		return new ListarTipoPagoResponseType();
	}

	public PagosType createPagosType() {
		return new PagosType();
	}

	public RegistraPagoRequestType createRegistraPagoRequestType() {
		return new RegistraPagoRequestType();
	}

	public RegistraPagoResponseType createRegistraPagoResponseType() {
		return new RegistraPagoResponseType();
	}

	public RegistraTipoPagoRequestType createRegistraTipoPagoRequest() {
		return new RegistraTipoPagoRequestType();
	}

	public RegistraTipoPagoResponseType createRegistraTipoPagoResponse() {
		return new RegistraTipoPagoResponseType();
	}

	public TipoPagoRequestType createTipoPagoType() {
		return new TipoPagoRequestType();
	}

}
