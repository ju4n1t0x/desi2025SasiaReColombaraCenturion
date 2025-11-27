package tuti.desi.services.ingrediente;

import java.util.List;


import tuti.desi.entidades.Ingrediente;
import tuti.desi.presentacion.models.CondimentoModel;
import tuti.desi.presentacion.models.IngredienteModel;
import tuti.desi.presentacion.models.ProductoModel;


public interface IIngredienteService {

	public List<ProductoModel> getAllProductos();
	public List<CondimentoModel> getAllCondimentos();

	public ProductoModel saveProducto(ProductoModel productoModel);
	public CondimentoModel saveCondimento(CondimentoModel condimentoModel);
	
	public void deleteIngrediente(Long id);
	
	public Ingrediente findIngrediente(Long id);

	public void editProducto(Long id, ProductoModel productoModel);
	public void editCondimento(Long id, CondimentoModel condimentoModel);
	
}
