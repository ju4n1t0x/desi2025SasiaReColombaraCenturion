package tuti.desi.services.producto;

import java.util.List;

import tuti.desi.entidades.ItemReceta;
import tuti.desi.entidades.Producto;

public interface IProductoService {

	public List<Producto> getAll();
	
	public void saveProducto(Producto producto);
	
	public void deleteProducto(Long id);
	
	public Producto findProducto(Long id);
	
	public void editProducto(Long idOriginal, String nuevoNombre, Integer nuevasCalorias, List<ItemReceta> nuevoItemReceta, Float nuevoStock, Float nuevoPrecio);
}
