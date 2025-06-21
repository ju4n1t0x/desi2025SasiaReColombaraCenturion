package tuti.desi.services.ingrediente;

import java.util.List;


import tuti.desi.entidades.Ingrediente;


public interface IIngredienteService {

	public List<Ingrediente> getAll();
	
	public void saveIngrediente(Ingrediente ingrediente);
	
	public void deleteIngrediente(Long id);
	
	public Ingrediente findIngrediente(Long id);
	
	public void editIngrediente(Long irOirignal, Long nuevoId, String nuevoNombre, Integer nuevasCalorias, Float nuevoStockDisponible, Float nuevoPrecioActual);
	
}
