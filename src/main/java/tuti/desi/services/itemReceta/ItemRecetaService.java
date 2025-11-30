package tuti.desi.services.itemReceta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.dao.IItemRecetaRepo;
import tuti.desi.entidades.*;
import tuti.desi.presentacion.models.ItemRecetaModel;
import tuti.desi.presentacion.models.ProductoModel;


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
	public ItemReceta saveItemReceta(Producto producto, Double cantidad) {
		ItemReceta itemReceta = new ItemReceta();
		itemReceta.setIngrediente(producto);
		itemReceta.setCantidad(cantidad.intValue());
		itemReceta.setCalorias((int)(cantidad * producto.getCalorias()));

		return itemReceta;

	}

	@Override
	public ItemReceta saveItemRecetaCondimento(Condimento condimento) {
		ItemReceta itemRecetaCondimento = new ItemReceta();
		itemRecetaCondimento.setCantidad(0);
		itemRecetaCondimento.setCalorias(0);
		itemRecetaCondimento.setIngrediente(condimento);

		return itemRecetaCondimento;

	}

	

}
