package tuti.desi.services.itemReceta;

import java.util.List;

import tuti.desi.entidades.*;
import tuti.desi.presentacion.models.ItemRecetaModel;
import tuti.desi.presentacion.models.ProductoModel;

public interface IItemRecetaService {
	

	
	public List<ItemReceta> getAll();
	
	public ItemReceta saveItemReceta(Producto producto, Double cantidad);
	public ItemReceta saveItemRecetaCondimento(Condimento condimento);



}
