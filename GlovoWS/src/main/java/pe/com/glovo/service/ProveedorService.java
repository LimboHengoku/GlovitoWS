package pe.com.glovo.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.glovo.dao.ProveedorRepository;
import pe.com.glovo.entidades.Proveedor;
import pe.com.glovo.request.RegistrarProveedorRequest;
import pe.com.glovo.response.CodigoGeneradoResponse;
import pe.com.glovo.util.Constantes;
import pe.com.glovo.util.Util;

@Service(value = "proveedorService")
public class ProveedorService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProveedorRepository proveedorRepository;

	public CodigoGeneradoResponse registrarProveedor(String idTransaccion, RegistrarProveedorRequest req) {

		CodigoGeneradoResponse response = new CodigoGeneradoResponse();

		boolean rucCorrecto = false;

		try {

			String ruc = req.getProveedor().getNroDocumento().trim();

			rucCorrecto = Util.validarLongitudRUC(ruc);

			if (rucCorrecto) {

				List<Proveedor> buscaReg = proveedorRepository.listaProveedores(idTransaccion, ruc);

				if (buscaReg.isEmpty()) {

					req.getProveedor().setFechaRegistro(new Date());

					Map<String, String> result = proveedorRepository.registrarProveedor(idTransaccion,
							req.getProveedor());

					if (result.get(Constantes.CODIGO_RESPUESTA).toString().equals(Constantes.CODIGO_OK)) {
						response.setCodigoGenerado(Integer.valueOf(result.get(Constantes.CODIGO_GENERADO).toString()));
						response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
						response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());
					} else {
						response.setCodigoGenerado(0);
						response.setCodigoRespuesta(Constantes.VALOR_CODIGO_REGISTRO_NO_EXITOSO);
						response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_REGISTRO_NO_EXITOSO);
					}

				} else {
					response.setCodigoGenerado(0);
					response.setCodigoRespuesta(Constantes.VALOR_CODIGO_RESPUESTA_EXISTE);
					response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_RESPUESTA_EXISTE);

				}

			} else {
				response.setCodigoGenerado(0);
				response.setCodigoRespuesta(Constantes.VALOR_CODIGO_VALIDAR_TAM_RUC);
				response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_VALIDAR_TAM_RUC);
			}

		} catch (Exception e) {
			response.setCodigoGenerado(0);
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta("Error en : " + e);
			e.printStackTrace();
		}

		return response;

	}

}
