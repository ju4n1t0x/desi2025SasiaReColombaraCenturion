package tuti.desi.presentacion.asistido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tuti.desi.services.asistido.IAsistidoService;

@RestController
public class AsistidoController {

	@Autowired
	private IAsistidoService interAsistido;
	
	
}
