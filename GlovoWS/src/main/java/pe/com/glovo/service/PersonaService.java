package pe.com.glovo.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.glovo.dao.PersonaRepository;
import pe.com.glovo.entidades.Persona;
import pe.com.glovo.request.RegistraPersonalRequest;
import pe.com.glovo.response.CodigoGeneradoResponse;
import pe.com.glovo.util.Constantes;
import pe.com.glovo.util.Util;

@Service(value = "personaService")
public class PersonaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PersonaRepository personaRepository;

	public CodigoGeneradoResponse RegistrarPersonal(String idTransaccion, RegistraPersonalRequest req) {

		CodigoGeneradoResponse response = new CodigoGeneradoResponse();

		boolean dniCorrecto = false;

		try {

			String nroDoc = req.getPersona().getNroDocumento().trim();

			req.getPersona().setFechaRegistro(new Date());

			dniCorrecto = Util.validarLongitudDNI(nroDoc);

			if (dniCorrecto) {

				List<Persona> buscaReg = personaRepository.listaPersonas(idTransaccion,
						req.getPersona().getNroDocumento());

				if (buscaReg.isEmpty()) {
					Map<String, String> result = personaRepository.registrarPersona(idTransaccion, req.getPersona());

					if (result.get(Constantes.CODIGO_GENERADO).toString().equals(Constantes.CODIGO_OK)) {
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
				response.setCodigoRespuesta(Constantes.VALOR_CODIGO_VALIDAR_TAM_DNI);
				response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_VALIDAR_TAM_DNI);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}

}