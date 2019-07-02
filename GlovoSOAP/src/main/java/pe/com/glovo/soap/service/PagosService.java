package pe.com.glovo.soap.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.glovo.soap.dao.PagosRepository;
import pe.com.glovo.soap.entidades.Pagos;
import pe.com.glovo.soap.entidades.Tipopago;
import pe.com.glovo.soap.types.GenericoResponseType;
import pe.com.glovo.soap.types.ListarTipoPagoResponseType;
import pe.com.glovo.soap.types.RegistraPagoRequestType;
import pe.com.glovo.soap.types.RegistraPagoResponseType;
import pe.com.glovo.soap.types.RegistraTipoPagoRequestType;
import pe.com.glovo.soap.types.RegistraTipoPagoResponseType;
import pe.com.glovo.soap.types.TipoPagoRequestType;
//import pe.com.glovo.soap.request.RegistraPagoRequest;
//import pe.com.glovo.soap.request.RegistraTipoPagoRequest;
//import pe.com.glovo.soap.response.CodigoGeneradoResponse;
import pe.com.glovo.soap.util.Constantes;
import pe.com.glovo.soap.util.Util;

@Service(value = "pagoService")
public class PagosService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PagosRepository pagoRepository;

	public RegistraTipoPagoResponseType registrarTipoPago(String idTransaccion, RegistraTipoPagoRequestType req) {

		RegistraTipoPagoResponseType responseType = new RegistraTipoPagoResponseType();

		GenericoResponseType genericoType = new GenericoResponseType();

		try {

			Tipopago tipoPago = new Tipopago();

			tipoPago.setDescripcion(req.getTipoPagoType().getDescripcion());

			List<Tipopago> buscaReg = pagoRepository.listaTipoPagos(idTransaccion, tipoPago.getDescripcion());

			if (buscaReg.isEmpty()) {

				Map<String, String> result = pagoRepository.registrarTipoPagos(idTransaccion, tipoPago);

				if (result.get(Constantes.CODIGO_RESPUESTA).toString().equals(Constantes.CODIGO_OK)) {

					genericoType.setCodigoGenerado(Integer.valueOf(result.get(Constantes.CODIGO_GENERADO).toString()));
					genericoType.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
					genericoType.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());

				} else {
					genericoType.setCodigoGenerado(0);
					genericoType.setCodigoRespuesta(Constantes.VALOR_CODIGO_REGISTRO_NO_EXITOSO);
					genericoType.setMensajeRespuesta(Constantes.VALOR_MENSAJE_REGISTRO_NO_EXITOSO);
				}

			} else {

				genericoType.setCodigoGenerado(0);
				genericoType.setCodigoRespuesta(Constantes.VALOR_CODIGO_RESPUESTA_EXISTE);
				genericoType.setMensajeRespuesta(Constantes.VALOR_MENSAJE_RESPUESTA_EXISTE);

			}

			responseType.setGenericoResponse(genericoType);

		} catch (Exception e) {
			genericoType.setCodigoGenerado(0);
			genericoType.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			genericoType.setMensajeRespuesta("Error en : " + e);
			responseType.setGenericoResponse(genericoType);
			e.printStackTrace();
		}

		return responseType;

	}

	public ListarTipoPagoResponseType listarTipoPagos(String idTransaccion) {

		ListarTipoPagoResponseType responseType = new ListarTipoPagoResponseType();

		GenericoResponseType genericoType = new GenericoResponseType();

		List<TipoPagoRequestType> listaTipoPago = new ArrayList<TipoPagoRequestType>();

		try {

			List<Tipopago> lista = pagoRepository.listaTipoPagos(idTransaccion, "");

			if (!lista.isEmpty()) {

				for (Tipopago tp : lista) {
					TipoPagoRequestType type = new TipoPagoRequestType();
					type.setIdTipoPago(tp.getIdTipoPago());
					type.setDescripcion(tp.getDescripcion());
					listaTipoPago.add(type);
				}

				genericoType.setCodigoGenerado(0);
				genericoType.setCodigoRespuesta(Constantes.VALOR_CODIGO_LISTA_NO_VACIA);
				genericoType.setMensajeRespuesta(Constantes.VALOR_MENSAJE_LISTA_NO_VACIA);

			} else {
				genericoType.setCodigoGenerado(0);
				genericoType.setCodigoRespuesta(Constantes.VALOR_CODIGO_LISTA_VACIA);
				genericoType.setMensajeRespuesta(Constantes.VALOR_MENSAJE_LISTA_VACIA);
			}

			responseType.setListaTipoPago(listaTipoPago);
			responseType.setGenericoResponse(genericoType);

		} catch (Exception e) {
			genericoType.setCodigoGenerado(0);
			genericoType.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			genericoType.setMensajeRespuesta("Error en : " + e);
			responseType.setGenericoResponse(genericoType);
			e.printStackTrace();
		}

		return responseType;
	}

	public RegistraPagoResponseType registrarPago(String idTransaccion, RegistraPagoRequestType req) {

		RegistraPagoResponseType responseType = new RegistraPagoResponseType();

		GenericoResponseType genericoType = new GenericoResponseType();

		boolean isDecimal = false;

		try {

			Tipopago tipoPago = new Tipopago();
			Pagos pago = new Pagos();

//			double campoAValidar = req.getPagos().getMontoApagar();
			System.out.println("Validar :" + req.getPagos().getMontoApagar());

			isDecimal = Util.validarDecimales(String.valueOf(req.getPagos().getMontoApagar()));

			if (isDecimal) {
				tipoPago.setIdTipoPago(req.getPagos().getTipoPagoType().getIdTipoPago());

				pago.setTipopago(tipoPago);
				pago.setFechaPago(req.getPagos().getFechaPago());
				pago.setMontoApagar(Double.valueOf(req.getPagos().getMontoApagar()));
				pago.setEstado(req.getPagos().getEstado());

				Map<String, String> result = pagoRepository.registrarPago(idTransaccion, pago);
				
				if(result.get(Constantes.CODIGO_RESPUESTA).toString().equals(Constantes.CODIGO_OK)) {
					genericoType.setCodigoGenerado(Integer.valueOf(
							result.get(Constantes.CODIGO_GENERADO).toString()));
					genericoType.setCodigoRespuesta(Constantes.VALOR_CODIGO_RESPUESTA_OK);
					genericoType.setMensajeRespuesta(Constantes.VALOR_MENSAJE_RESPUESTA_OK);
				}else {
					genericoType.setCodigoGenerado(0);
					genericoType.setCodigoRespuesta(Constantes.VALOR_CODIGO_REGISTRO_NO_EXITOSO);
					genericoType.setMensajeRespuesta(Constantes.VALOR_MENSAJE_REGISTRO_NO_EXITOSO);
				}
				
			} else {
				genericoType.setCodigoGenerado(0);
				genericoType.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR_DECIMAL);
				genericoType.setMensajeRespuesta(Constantes.VALOR_MENSAJE_ERROR_DECIMAL);
			}
			
			responseType.setGenericoResponse(genericoType);

		} catch (Exception e) {
			genericoType.setCodigoGenerado(0);
			genericoType.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			genericoType.setMensajeRespuesta("Error en : " + e);
			responseType.setGenericoResponse(genericoType);
			e.printStackTrace();
		}

		return responseType;

	}

//	public CodigoGeneradoResponse registrarTipoPago(String idTransaccion, RegistraTipoPagoRequest req) {
//
//		CodigoGeneradoResponse response = new CodigoGeneradoResponse();
//
//		try {
//			
//			List<Tipopago> buscaReg = pagoRepository.listaTipoPagos(idTransaccion, req.getTipopago().getDescripcion());
//			
//			if(buscaReg.isEmpty()) {
//				
//				Map<String, String> result = pagoRepository.registrarTipoPagos(idTransaccion, req.getTipopago());
//				
//				if(result.get(Constantes.CODIGO_RESPUESTA).toString().equals(Constantes.CODIGO_OK)) {
//
//					response.setCodigoGenerado(Integer.valueOf(result.get(Constantes.CODIGO_GENERADO).toString()));
//					response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
//					response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());
//				}else {
//					response.setCodigoGenerado(0);
//					response.setCodigoRespuesta(Constantes.VALOR_CODIGO_REGISTRO_NO_EXITOSO);
//					response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_REGISTRO_NO_EXITOSO);
//				}
//				
//			}else {
//				response.setCodigoGenerado(0);
//				response.setCodigoRespuesta(Constantes.VALOR_CODIGO_RESPUESTA_EXISTE);
//				response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_RESPUESTA_EXISTE);
//			}
//			
//
//		} catch (Exception e) {
//			response.setCodigoGenerado(0);
//			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
//			response.setMensajeRespuesta("Error en : " + e);
//			e.printStackTrace();
//		}
//
//		return response;
//
//	}
//
//	public CodigoGeneradoResponse registrarPago(String idTransaccion, RegistraPagoRequest req) {
//
//		CodigoGeneradoResponse response = new CodigoGeneradoResponse();
//
//		boolean isDecimal = false;
//
//		try {
//
//			double monto = req.getPago().getMontoApagar();
//
//			isDecimal = Util.validarDecimales(String.valueOf(monto));
//
//			if (isDecimal) {
//				
//				Map<String, String> result = pagoRepository.registrarPago(idTransaccion, req.getPago());
//				
//				if(result.get(Constantes.CODIGO_GENERADO).toString().equals(Constantes.CODIGO_OK)) {
//					
//					response.setCodigoGenerado(Integer.valueOf(result.get(Constantes.CODIGO_GENERADO).toString()));
//					response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
//					response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());
//					
//				}else {
//					response.setCodigoGenerado(0);
//					response.setCodigoRespuesta(Constantes.VALOR_CODIGO_REGISTRO_NO_EXITOSO);
//					response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_REGISTRO_NO_EXITOSO);
//				}
//				
//
//			} else {
//				response.setCodigoGenerado(0);
//				response.setCodigoRespuesta(Constantes.VALOR_CODIGO_VALIDAR_DECIMAL);
//				response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_VALIDAR_DECIMAL);
//			}
//
//		} catch (Exception e) {
//			response.setCodigoGenerado(0);
//			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
//			response.setMensajeRespuesta("Error en : " + e);
//			e.printStackTrace();
//		}
//
//		return response;
//	}

}
