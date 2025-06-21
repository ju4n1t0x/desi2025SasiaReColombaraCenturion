package tuti.desi.services.receta;

import java.util.List;

import tuti.desi.entidades.ItemReceta;
import tuti.desi.entidades.Preparacion;
import tuti.desi.entidades.Receta;

public interface IRecetaService {

	public List<Receta> getAll();
	
	public void saveReceta(Receta receta);
	
	public void deleteReceta(Long id);
	
	public Receta findReceta(Long id);
	
	public void editReceta(Long idOriginal, Long nuevoId, String nuevoNombre, String nuevaDescripcion,List<ItemReceta> nuevoItemReceta, List<Preparacion> nuevasPreparaciones);
}
