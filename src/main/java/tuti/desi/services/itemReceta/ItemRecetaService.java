package tuti.desi.services.itemReceta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.IItemRecetaRepo;
import tuti.desi.entidades.Ingrediente;
import tuti.desi.entidades.ItemReceta;
import tuti.desi.entidades.Receta;

	
@Service
public class ItemRecetaService implements IItemRecetaService{

	@Autowired
	private IItemRecetaRepo itemRecetaRepo;
	
	@Override
	public List<ItemReceta> getAll() {
		List<ItemReceta> listaItemReceta = itemRecetaRepo.findAll();
		return listaItemReceta;
	}

	@Override
	public void saveItemReceta(ItemReceta itemReceta) {
		itemRecetaRepo.save(itemReceta);
		
	}

	@Override
	public void deleteItemReceta(Long id) {
		itemRecetaRepo.deleteById(id);
		
	}

	@Override
	public ItemReceta findItemReceta(Long id) {
		ItemReceta itemRec = itemRecetaRepo.findById(id).orElse(null);
		return itemRec;
	}

	@Override
	public void editItemReceta(Long idOriginal, Long nuevoId, Integer nuevasCalorias, Integer nuevaCantidad, Ingrediente nuevoIngrediente, Receta nuevaReceta) {
		ItemReceta itemRec = this.findItemReceta(idOriginal);
		itemRec.setId(nuevoId);
		itemRec.setCantidad(nuevaCantidad);
		itemRec.setCalorias(nuevasCalorias);
		itemRec.setIngrediente(nuevoIngrediente);
		itemRec.setReceta(nuevaReceta);
		
	}
	

}
