package tuti.desi.services.receta;

import java.util.List;

import tuti.desi.entidades.ItemReceta;
import tuti.desi.entidades.Preparacion;
import tuti.desi.entidades.Receta;
import tuti.desi.presentacion.models.RecetaModel;

public interface IRecetaService {

	public List<Receta> getAll();
	
	public void saveReceta(String nombre, String descripcion,List<Long> productoIds,List<Double> productoCantidades,List<Long> condimentoIds);
	
	public void deleteReceta(Long id);
	
	public Receta findReceta(Long id);
	
	public void editReceta(Long idOriginal, String nuevoNombre, String nuevaDescripcion,List<ItemReceta> nuevoItemReceta, List<Preparacion> nuevasPreparaciones);
}
