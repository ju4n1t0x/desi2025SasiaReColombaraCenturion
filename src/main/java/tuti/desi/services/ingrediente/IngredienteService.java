package tuti.desi.services.ingrediente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.IIngredienteRepo;

import tuti.desi.entidades.Ingrediente;


@Service
public class IngredienteService implements IIngredienteService{

	@Autowired
	private IIngredienteRepo ingredienteRepo;
	
	@Override
	public List<Ingrediente> getAll() {
		List<Ingrediente> listaIngredientes = ingredienteRepo.findAll();
		return listaIngredientes;
	}

	@Override
	public void saveIngrediente(Ingrediente ingrediente) {
		ingredienteRepo.save(ingrediente);
		
	}

	@Override
	public void deleteIngrediente(Long id) {
		ingredienteRepo.deleteById(id);
		
	}

	@Override
	public Ingrediente findIngrediente(Long id) {
		Ingrediente ingre = ingredienteRepo.findById(id).orElse(null);
		return ingre;
	}

	@Override
	public void editIngrediente(Long idOriginal, String nuevoNombre, Integer nuevasCalorias, Float nuevoStockDisponible, Float nuevoPrecioActual) {
		Ingrediente ingre = this.findIngrediente(idOriginal);
		ingre.setNombre(nuevoNombre);
		ingre.setCalorias(nuevasCalorias);
		
	}

}
