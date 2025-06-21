package tuti.desi.services.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.IProductoRepo;
import tuti.desi.entidades.ItemReceta;
import tuti.desi.entidades.Producto;

@Service
public class ProductoService implements IProductoService{
	
	@Autowired
	private IProductoRepo productoRepo;

	@Override
	public List<Producto> getAll() {
		List<Producto> listaProductos = productoRepo.findAll();
		return listaProductos;
	}

	@Override
	public void saveProducto(Producto producto) {
		productoRepo.save(producto);
		
	}

	@Override
	public void deleteProducto(Long id) {
		productoRepo.deleteById(id);
		
	}

	@Override
	public Producto findProducto(Long id) {
		Producto produc = productoRepo.findById(id).orElse(null);
		return produc;
	}

	@Override
	public void editProducto(Long idOriginal, String nuevoNombre, Integer nuevasCalorias, List<ItemReceta> nuevoItemReceta, Float nuevoStock, Float nuevoPrecio) {
		Producto produc = this.findProducto(idOriginal);
		produc.setNombre(nuevoNombre);
		produc.setCalorias(nuevasCalorias);
		produc.setItemReceta(nuevoItemReceta);
		produc.setSockDisponible(nuevoStock);
		produc.setPrecioActual(nuevoPrecio);;
		
		
	}

}
