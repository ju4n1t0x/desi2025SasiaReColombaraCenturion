package tuti.desi.services.preparacion;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.IPreparacionRepo;
import tuti.desi.entidades.Preparacion;
import tuti.desi.entidades.Receta;

@Service
public class PreparacionService implements IPreparacionService{

	@Autowired
	private IPreparacionRepo preparacionRepo;

	@Override
	public List<Preparacion> getAll() {
		List<Preparacion> listaPreparaciones = preparacionRepo.findAll();
		return listaPreparaciones;
	}

	@Override
	public void savePreparacion(Preparacion preparacion) {
		preparacionRepo.save(preparacion);
		
	}

	@Override
	public void deletePreparacion(Long id) {
		preparacionRepo.deleteById(id);
		
	}

	@Override
	public Preparacion findPreparacion(Long id) {
		Preparacion prep = preparacionRepo.findById(id).orElse(null);
		return prep;
	}

	@Override
	public void editPreparacion(Long idOriginal, Long nuevoId, Date nuevaFechaCoccion, Integer nuevoTotalRaciones,
			Integer nuevoStockRaciones, Receta nuevaReceta) {
		Preparacion prep = this.findPreparacion(idOriginal);
		prep.setId(nuevoId);
		prep.setFechaCondicion(nuevaFechaCoccion);
		prep.setTotalRacionesPreparadas(nuevoTotalRaciones);
		prep.setStockRacionesRestantes(nuevoStockRaciones);
		prep.setReceta(nuevaReceta);
		
	}
}
