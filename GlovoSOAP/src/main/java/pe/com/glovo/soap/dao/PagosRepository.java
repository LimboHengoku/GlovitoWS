package pe.com.glovo.soap.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pe.com.glovo.soap.entidades.Pagos;
import pe.com.glovo.soap.entidades.Tipopago;
import pe.com.glovo.soap.util.Constantes;

@Repository(value = "pagoRepository")
@Transactional
public class PagosRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public List<Tipopago> listaTipoPagos(String idTransaccion, String descripcion) {

		List<Tipopago> lista = new ArrayList<Tipopago>();

		try {
			String sql = "";
			if (!descripcion.isEmpty() || !descripcion.equals("")) {
				sql = sql + "from Tipopago tp where tp.descripcion ='" + descripcion + "'";
			} else {
				sql = sql + "from Tipopago";
			}

			lista = em.createQuery(sql).getResultList();

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public Map<String, String> registrarTipoPagos(String idTransaccion, Tipopago tp) {

		Map<String, String> out = new HashMap<>();

		try {

			em.persist(tp);
			out.put(Constantes.CODIGO_GENERADO, String.valueOf(tp.getIdTipoPago()));
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_RESPUESTA_OK);
			out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_RESPUESTA_OK);

		} catch (Exception e) {
			e.printStackTrace();
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_ERROR);
			out.put(Constantes.MENSAJE_RESPUESTA, e.getMessage() + " : " + e);
		}

		return out;

	}

	public Map<String, String> registrarPago(String idTransaccion, Pagos pago) {

		Map<String, String> out = new HashMap<>();

		try {

			em.persist(pago);
			out.put(Constantes.CODIGO_GENERADO, String.valueOf(pago.getIdPago()));
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_RESPUESTA_OK);
			out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_RESPUESTA_OK);

		} catch (Exception e) {
			e.printStackTrace();
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_ERROR);
			out.put(Constantes.MENSAJE_RESPUESTA, e.getMessage() + " : " + e);
		}

		return out;

	}

}
