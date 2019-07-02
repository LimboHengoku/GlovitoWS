package pe.com.glovo.soap.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.glovo.soap.dao.ProductoRepository;
import pe.com.glovo.soap.entidades.Ofertas;
import pe.com.glovo.soap.entidades.Producto;
import pe.com.glovo.soap.types.GenericoResponseType;
import pe.com.glovo.soap.types.ListarOfertasRequestType;
import pe.com.glovo.soap.types.ListarOfertasResponseType;
import pe.com.glovo.soap.types.OfertaType;
import pe.com.glovo.soap.types.RegistraOfertaRequestType;
import pe.com.glovo.soap.types.RegistraOfertaResponseType;
import pe.com.glovo.soap.util.Constantes;
import pe.com.glovo.soap.util.Util;

@Service(value = "productoService")
public class ProductoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProductoRepository productoRepository;

	public RegistraOfertaResponseType registraOferta(String idTransaccion, RegistraOfertaRequestType req) {

		RegistraOfertaResponseType responseType = new RegistraOfertaResponseType();

		GenericoResponseType genericoType = new GenericoResponseType();

		boolean validaFechas = false;

		try {

			Ofertas oferta = new Ofertas();
			Producto producto = new Producto();

			validaFechas = Util.validarRangoDeFechas(req.getOferta().getFechaInicioOferta(),
					req.getOferta().getFechaFinOferta());

			if (validaFechas) {

				producto.setIdProducto(req.getOferta().getProducto().getIdProducto());
				producto.setNombreProducto(req.getOferta().getProducto().getNombreProducto());

				oferta.setFechaInicioOferta(req.getOferta().getFechaInicioOferta());
				oferta.setFechaFinOferta(req.getOferta().getFechaFinOferta());
				oferta.setEstado(req.getOferta().getEstado());
				oferta.setProducto(producto);
				oferta.setFechaRegistro(new Date());

				List<Producto> buscaReg = productoRepository.buscaProducto(idTransaccion, producto.getIdProducto());

				if (!buscaReg.isEmpty()) {
					Map<String, String> result = productoRepository.registrarOferta(idTransaccion, oferta);

					if (result.get(Constantes.CODIGO_RESPUESTA).toString().equals(Constantes.CODIGO_OK)) {

						genericoType
								.setCodigoGenerado(Integer.valueOf(result.get(Constantes.CODIGO_GENERADO).toString()));
						genericoType.setCodigoRespuesta(result.get(Constantes.CODIGO_RESPUESTA).toString());
						genericoType.setMensajeRespuesta(result.get(Constantes.MENSAJE_RESPUESTA).toString());

					} else {
						genericoType.setCodigoGenerado(0);
						genericoType.setCodigoRespuesta(Constantes.VALOR_CODIGO_REGISTRO_NO_EXITOSO);
						genericoType.setMensajeRespuesta(Constantes.VALOR_MENSAJE_REGISTRO_NO_EXITOSO);
					}
				} else {
					genericoType.setCodigoGenerado(0);
					genericoType.setCodigoRespuesta(Constantes.VALOR_CODIGO_REGISTRO_NO_EXISTE);
					genericoType.setMensajeRespuesta(Constantes.VALOR_MENSAJE_REGISTRO_NO_EXISTE);

				}

			} else {
				genericoType.setCodigoGenerado(0);
				genericoType.setCodigoRespuesta(Constantes.VALOR_CODIGO_FECHA_NO_VALIDA);
				genericoType.setMensajeRespuesta(Constantes.VALOR_MENSAJE_FECHA_NO_VALIDA);
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

	public ListarOfertasResponseType buscarOfertas(String idTransaccion, ListarOfertasRequestType req) {

		ListarOfertasResponseType responseType = new ListarOfertasResponseType();
		GenericoResponseType genericoType = new GenericoResponseType();
		List<OfertaType> listaOfertasType = new ArrayList<>();

		try {

			List<Ofertas> lista = productoRepository.getOfertas(idTransaccion, req.getNombreOferta().trim());

			if (!lista.isEmpty()) {

				for (Ofertas o : lista) {
					OfertaType type = new OfertaType();
					type.setIdOferta(o.getIdOferta());
					type.setDescripcionOferta(o.getDescripcionOferta());
					type.setFechaInicioOferta(o.getFechaInicioOferta());
					type.setFechaFinOferta(o.getFechaFinOferta());
					type.setEstado(o.getEstado());
					listaOfertasType.add(type);
				}

				genericoType.setCodigoGenerado(0);
				genericoType.setCodigoRespuesta(Constantes.VALOR_CODIGO_LISTA_NO_VACIA);
				genericoType.setMensajeRespuesta(Constantes.VALOR_MENSAJE_LISTA_NO_VACIA);

			} else {
				genericoType.setCodigoGenerado(0);
				genericoType.setCodigoRespuesta(Constantes.VALOR_CODIGO_LISTA_VACIA);
				genericoType.setMensajeRespuesta(Constantes.VALOR_MENSAJE_LISTA_VACIA);

			}
			responseType.setListaOfertas(listaOfertasType);
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

}
