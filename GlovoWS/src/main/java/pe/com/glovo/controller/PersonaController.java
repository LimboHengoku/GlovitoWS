package pe.com.glovo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.glovo.request.RegistraPersonalRequest;
import pe.com.glovo.response.CodigoGeneradoResponse;
import pe.com.glovo.service.PersonaService;
import pe.com.glovo.util.Constantes;

@RestController
@RequestMapping(value = "/persona")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@PostMapping(value = "registrar", headers = "Accept=application/json")
	public ResponseEntity<CodigoGeneradoResponse> registarPersona(@RequestBody RegistraPersonalRequest req) {

		ResponseEntity<CodigoGeneradoResponse> entity = null;

		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyhhmmss");
		Date fecha = new Date();
		String idTransaccion = format.format(fecha);

		try {

			String datosRequest = new ObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"))
					.writerWithDefaultPrettyPrinter().writeValueAsString(req);

			System.out.println("datosRequest : \n" + datosRequest);

			CodigoGeneradoResponse response = personaService.RegistrarPersonal(idTransaccion, req);
			
			String datosResponse = new ObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"))
					.writerWithDefaultPrettyPrinter().writeValueAsString(response);


			System.out.println("response : \n" + datosResponse);

			if (response.getCodigoRespuesta().equals(Constantes.CODIGO_OK)) {
				entity = new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				entity = new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return entity;

	}

}
