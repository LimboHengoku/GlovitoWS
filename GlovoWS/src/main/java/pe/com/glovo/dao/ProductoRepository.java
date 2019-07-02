package pe.com.glovo.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pe.com.glovo.entidades.Categoria;
import pe.com.glovo.entidades.Producto;
import pe.com.glovo.util.Constantes;

@Repository(value = "productoRepository")
@Transactional
public class ProductoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public List<Producto> listaProductos(String idTransaccion, String nombreProducto) {

		List<Producto> lista = new ArrayList<>();

		try {

			String sql = "";

			if (!nombreProducto.isEmpty() || !nombreProducto.equals("")) {
				sql = "from Producto p where p.nombreProducto ='" + nombreProducto + "'";
			} else {
				sql = "from Producto p";
			}

			lista = em.createQuery(sql).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;

	}

	public Producto getProducto(String idTransaccion, String nombrePro) {

		Producto pro = null;

		try {

			Query query = em.createQuery("from Producto p where p.nombreProducto = '" + nombrePro + "'");

			pro = (Producto) query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pro;

	}

	public Map<String, String> registrarProducto(String idTransaccion, Producto pro) {

		Map<String, String> out = new HashMap<>();

		try {

			em.persist(pro);

			out.put(Constantes.CODIGO_GENERADO, String.valueOf(pro.getIdProducto()));
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

	public List<Categoria> getCategoria(String idTransaccion, String nombreCat) {

		List<Categoria> cat = new ArrayList<Categoria>();

		try {

			Query query = em.createQuery("from Categoria p where p.descripcion = '" + nombreCat + "'");

			cat = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cat;

	}

	public Map<String, String> registrarCategoria(String idTransaccion, Categoria c) {

		Map<String, String> out = new HashMap<>();

		try {

			em.persist(c);

			out.put(Constantes.CODIGO_GENERADO, String.valueOf(c.getIdCategoria()));
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
