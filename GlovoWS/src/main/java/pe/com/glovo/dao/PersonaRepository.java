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

import pe.com.glovo.entidades.Persona;
import pe.com.glovo.util.Constantes;

@Repository(value = "personaRepository")
@Transactional
public class PersonaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public List<Persona> listaPersonas(String idTransaccion, String nroDocumento) {

		List<Persona> lista = new ArrayList<>();

		try {

			String sql = "";

			if (!nroDocumento.isEmpty() || !nroDocumento.equals("")) {
				sql = sql + "from Persona p where p.nroDocumento = '" + nroDocumento + "'";
			} else {
				sql = sql + "from Persona p";
			}

			lista = em.createQuery(sql).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;

	}

	public Map<String, String> registrarPersona(String idTransaccion, Persona p) {

		Map<String, String> out = new HashMap<>();

		try {

			em.persist(p);
			out.put(Constantes.CODIGO_GENERADO, String.valueOf(p.getIdPersona()));
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
