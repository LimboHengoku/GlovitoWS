package pe.com.glovo.soap.endpoint;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pe.com.glovo.soap.service.PagosService;
import pe.com.glovo.soap.types.ListarTipoPagoRequestType;
import pe.com.glovo.soap.types.ListarTipoPagoResponseType;
import pe.com.glovo.soap.types.RegistraPagoRequestType;
import pe.com.glovo.soap.types.RegistraPagoResponseType;
import pe.com.glovo.soap.types.RegistraTipoPagoRequestType;
import pe.com.glovo.soap.types.RegistraTipoPagoResponseType;

@Endpoint
public class GlovoEndPoint {

	public static final String NAMESPACE_URI = "http://glovo.com.pe/GlovoSOAP/types";

	private PagosService pagosService;

	public GlovoEndPoint() {

	}

	@Autowired
	public GlovoEndPoint(PagosService pagosService) {
		this.pagosService = pagosService;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "registraTipoPagoRequest")
	@ResponsePayload
	public RegistraTipoPagoResponseType registraTipoPago(@RequestPayload RegistraTipoPagoRequestType req) {

		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyhhmmss");
		Date fecha = new Date();
		String idTransaccion = format.format(fecha);

		RegistraTipoPagoResponseType response = pagosService.registrarTipoPago(idTransaccion, req);

		System.out.println("response : \n" + response);

		return response;

	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "listarTipoPagoRequest")
	@ResponsePayload
	public ListarTipoPagoResponseType listarTipoPago(@RequestPayload ListarTipoPagoRequestType req) {

		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyhhmmss");
		Date fecha = new Date();
		String idTransaccion = format.format(fecha);

		ListarTipoPagoResponseType response = pagosService.listarTipoPagos(idTransaccion);

		return response;

	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "registraPagoRequest")
	@ResponsePayload
	public RegistraPagoResponseType registrarPago(@RequestPayload RegistraPagoRequestType req) {
		

		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyhhmmss");
		Date fecha = new Date();
		String idTransaccion = format.format(fecha);
		
		RegistraPagoResponseType response = pagosService.registrarPago(idTransaccion, req);
		
		return response;
	}

}
