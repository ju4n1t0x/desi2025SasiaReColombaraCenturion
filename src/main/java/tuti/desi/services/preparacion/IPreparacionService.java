package tuti.desi.services.preparacion;

import java.sql.Date;
import java.util.List;

import tuti.desi.entidades.Preparacion;
import tuti.desi.entidades.Receta;

public interface IPreparacionService {

	public List<Preparacion> getAll();
	
	public void savePreparacion(Preparacion preparacion);
	
	public void deletePreparacion(Long id);
	
	public Preparacion findPreparacion(Long id);
	
	public void editPreparacion(Long idOriginal, Date nuevaFechaCoccion, Integer nuevoTotalRaciones, Integer nuevoStockRaciones, Receta receta);
}
