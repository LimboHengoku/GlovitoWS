package pe.com.glovo.soap.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.glovo.soap.dao.ProductoRepository;

@Service(value = "productoService")
public class ProductoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProductoRepository productoRepository;

}
