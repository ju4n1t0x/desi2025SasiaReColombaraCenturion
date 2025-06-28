package tuti.desi.services.preparacion;

import java.sql.Date;
import java.util.List;

import tuti.desi.entidades.Preparacion;
import tuti.desi.entidades.Receta;
import tuti.desi.presentacion.models.PreparacionModel;

public interface IPreparacionService {

	public List<PreparacionModel> getAll();

	public PreparacionModel convertToModel(Preparacion preparacion);

	public PreparacionModel save(PreparacionModel preparacionModel);
	
	public void deletePreparacionModel(Long id);
	
	public PreparacionModel findPreparacion(Long id);
	
	public void editPreparacion(PreparacionModel preparacionModel);
}
