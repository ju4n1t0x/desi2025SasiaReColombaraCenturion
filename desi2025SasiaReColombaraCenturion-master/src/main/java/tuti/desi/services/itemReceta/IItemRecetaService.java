package tuti.desi.services.itemReceta;

import java.util.List;

import tuti.desi.entidades.Ingrediente;
import tuti.desi.entidades.ItemReceta;
import tuti.desi.entidades.Receta;

public interface IItemRecetaService {
	

	
	public List<ItemReceta> getAll();
	
	public void saveItemReceta(ItemReceta itemReceta);
	
	public void deleteItemReceta(Long id);
	
	public ItemReceta findItemReceta(Long id);
	
	public void editItemReceta(Long idOriginal, Integer nuevasCalorias, Integer nuevaCantidad, Ingrediente nuevoIngrediente, Receta nuevaReceta);
	
}
