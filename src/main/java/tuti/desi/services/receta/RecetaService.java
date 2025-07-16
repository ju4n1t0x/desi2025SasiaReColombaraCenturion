package tuti.desi.services.receta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.dao.IRecetaRepo;
import tuti.desi.entidades.ItemReceta;
import tuti.desi.entidades.Preparacion;
import tuti.desi.entidades.Receta;

@Service
public class RecetaService implements IRecetaService{

	@Autowired
	private IRecetaRepo recetaRepo;

	@Override
	public List<Receta> getAll() {
		List<Receta> listaRecetas = recetaRepo.findAll();
		return listaRecetas;
	}

	@Override
	public void saveReceta(Receta receta) {
		recetaRepo.save(receta);
	}

	@Override
	public void deleteReceta(Long id) {
		recetaRepo.deleteById(id);
		
	}

	@Override
	public Receta findReceta(Long id) {
		Receta rece = recetaRepo.findById(id).orElse(null);
		return rece;
	}

	@Override
	public void editReceta(Long idOriginal, String nuevoNombre, String nuevaDescripcion, List<ItemReceta> nuevoItemReceta, List<Preparacion> nuevasPreparaciones) {
		Receta rece = this.findReceta(idOriginal);
		rece.setNombre(nuevoNombre);
		rece.setDescripcion(nuevaDescripcion);
		rece.setItemReceta(nuevoItemReceta);
		rece.setPreparaciones(nuevasPreparaciones);
		
	}

}
