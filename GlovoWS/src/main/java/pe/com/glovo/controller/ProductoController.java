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

import pe.com.glovo.request.RegistrarProductoRequest;
import pe.com.glovo.response.CodigoGeneradoResponse;
import pe.com.glovo.service.ProductoService;
import pe.com.glovo.util.Constantes;

@RestController
@RequestMapping(value = "/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@PostMapping(value = "registrar", headers = "Accept=application/json")
	public ResponseEntity<CodigoGeneradoResponse> registrarProducto(@RequestBody RegistrarProductoRequest req) {

		ResponseEntity<CodigoGeneradoResponse> entity = null;

		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyhhmmss");
		Date fecha = new Date();
		String idTransaccion = format.format(fecha);

		CodigoGeneradoResponse response = new CodigoGeneradoResponse();

		try {

			response = productoService.registrarProductos(idTransaccion, req);

			if (response.getCodigoRespuesta().equals(Constantes.CODIGO_OK)) {
				entity = new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				entity = new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
			}

		} catch (Exception e) {
			entity = new ResponseEntity<>(HttpStatus.FORBIDDEN);
			e.printStackTrace();
		}

		return entity;

	}

}
