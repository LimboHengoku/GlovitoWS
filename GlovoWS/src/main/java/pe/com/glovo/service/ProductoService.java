package pe.com.glovo.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.glovo.dao.ProductoRepository;
import pe.com.glovo.entidades.Categoria;
import pe.com.glovo.entidades.Producto;
import pe.com.glovo.request.RegistrarCategoriaRequest;
import pe.com.glovo.request.RegistrarProductoRequest;
import pe.com.glovo.response.CodigoGeneradoResponse;
import pe.com.glovo.util.Constantes;

@Service(value = "productoService")
public class ProductoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProductoRepository productoRepository;

	public CodigoGeneradoResponse registrarProductos(String idTransaccion, RegistrarProductoRequest req) {

		CodigoGeneradoResponse response = new CodigoGeneradoResponse();

		try {

			List<Producto> buscaReg = productoRepository.listaProductos(idTransaccion,
					req.getProducto().getNombreProducto());

			if (buscaReg.isEmpty()) {

				req.getProducto().setFechaRegistro(new Date());

				Map<String, String> result = productoRepository.registrarProducto(idTransaccion, req.getProducto());

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

		} catch (Exception e) {
			response.setCodigoGenerado(0);
			response.setCodigoRespuesta(Constantes.VALOR_CODIGO_ERROR);
			response.setMensajeRespuesta("Error en : " + e);
			e.printStackTrace();
		}

		return response;

	}

	public CodigoGeneradoResponse registrarCategoria(String idTransaccion, RegistrarCategoriaRequest req) {

		CodigoGeneradoResponse response = new CodigoGeneradoResponse();

		try {

			List<Categoria> cat = productoRepository.getCategoria(idTransaccion, req.getCategoria().getDescripcion());

			if (cat.isEmpty()) {

				req.getCategoria().setFechaRegistro(new Date());

				Map<String, String> result = productoRepository.registrarCategoria(idTransaccion, req.getCategoria());

				response.setCodigoGenerado(Integer.valueOf(result.get(Constantes.CODIGO_GENERADO).toString()));
				response.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
				response.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());

			} else {
				response.setCodigoGenerado(0);
				response.setCodigoRespuesta(Constantes.VALOR_CODIGO_RESPUESTA_EXISTE);
				response.setMensajeRespuesta(Constantes.VALOR_MENSAJE_RESPUESTA_EXISTE);
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
