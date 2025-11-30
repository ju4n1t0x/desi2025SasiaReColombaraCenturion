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
		if(producto.getStockDisponible() != null && producto.getStockDisponible() > cantidad) {
			try {
				ItemReceta itemReceta = new ItemReceta();
				itemReceta.setIngrediente(producto);
				itemReceta.setCantidad(cantidad.intValue());
				itemReceta.setCalorias((int) (cantidad * producto.getCalorias()));

				return itemReceta;

			} catch (Exception e) {
				throw new IllegalArgumentException("Error al crear el ItemReceta para el producto: " + producto.getNombre(), e);
			}
		}else{
			throw new IllegalArgumentException("No hay suficiente stock disponible para el producto: " + producto.getNombre());
		}

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
