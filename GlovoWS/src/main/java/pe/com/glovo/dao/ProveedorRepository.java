package pe.com.glovo.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pe.com.glovo.entidades.Proveedor;
import pe.com.glovo.util.Constantes;

@Repository(value = "proveedorRepository")
@Transactional
public class ProveedorRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public List<Proveedor> listaProveedores(String idTransaccion, String ruc) {

		List<Proveedor> lista = new ArrayList<>();

		try {

			String sql = "";

			if (!ruc.isEmpty() || !ruc.equals("")) {
				sql = sql + "from Proveedor p where p.nroDocumento ='" + ruc + "'";
			} else {
				sql = sql + "from Proveedor p";
			}

			lista = em.createQuery(sql).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;

	}

	public Map<String, String> registrarProveedor(String idTransaccion, Proveedor prov) {

		Map<String, String> out = new HashMap<>();

		try {

			em.persist(prov);

			out.put(Constantes.CODIGO_GENERADO, String.valueOf(prov.getIdProveedor()));
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_RESPUESTA_OK);
			out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_RESPUESTA_OK);

		} catch (Exception e) {
			out.put(Constantes.CODIGO_GENERADO, "0");
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_ERROR);
			out.put(Constantes.MENSAJE_RESPUESTA, e.getMessage() + e);
			e.printStackTrace();
		}

		return out;

	}

}
