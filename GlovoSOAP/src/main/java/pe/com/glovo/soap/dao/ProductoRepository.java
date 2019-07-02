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

import pe.com.glovo.soap.entidades.Ofertas;
import pe.com.glovo.soap.entidades.Producto;
import pe.com.glovo.soap.util.Constantes;

@Repository(value = "productoRespository")
@Transactional
public class ProductoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public List<Ofertas> listaOfertas(String idTransaccion, String nombreProducto) {

		List<Ofertas> lista = new ArrayList<>();

		try {

			String sql = "";

			if (!nombreProducto.isEmpty() || !nombreProducto.equals("")) {
				sql = sql + "from Ofertas o where o.producto.nombreProducto like '%" + nombreProducto + "'%";
			} else {
				sql = sql + "from Ofertas o";
			}

			lista = em.createQuery(sql).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;

	}

	public Map<String, String> registrarOferta(String idTransaccion, Ofertas o) {

		Map<String, String> out = new HashMap<>();

		try {

			em.persist(o);
			out.put(Constantes.CODIGO_GENERADO, String.valueOf(o.getIdOferta()));
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_RESPUESTA_OK);
			out.put(Constantes.MENSAJE_RESPUESTA, Constantes.VALOR_MENSAJE_RESPUESTA_OK);

		} catch (Exception e) {
			e.printStackTrace();
			out.put(Constantes.CODIGO_RESPUESTA, Constantes.VALOR_CODIGO_ERROR);
			out.put(Constantes.MENSAJE_RESPUESTA, e.getMessage() + " : " + e);
		}

		return out;

	}

	public List<Producto> buscaProducto(String idTransaccion, int codProd) {

		List<Producto> lista = new ArrayList<>();

		try {

			String sql = "";

			if (codProd != 0) {
				sql = sql + "from Producto p where p.idProducto =" + codProd;
			} else {
				sql = sql + "from Producto p";
			}

			lista = em.createQuery(sql).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;

	}

	public List<Ofertas> getOfertas(String idTransaccion, String nombeOferta) {
		List<Ofertas> lista = new ArrayList<>();

		try {

			String sql = "";
			
			if(!nombeOferta.isEmpty() || !nombeOferta.equals("")) {
				sql = sql + "from Ofertas o where o. = '" +nombeOferta + "'";
			}else {
				sql = sql + "from Ofertas o ";
			}
			
			lista = em.createQuery(sql).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}

}
