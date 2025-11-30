package tuti.desi.services.receta;

import java.util.List;
import tuti.desi.entidades.ItemReceta;
import tuti.desi.entidades.Preparacion;
import tuti.desi.entidades.Receta;
import tuti.desi.presentacion.models.RecetaModel;

public interface IRecetaService {

	//renombro getAll() -> findAll()
	//public List<RecetaModel> findAll();

	//public void deleteReceta(Long id);
	
	//public Receta findReceta(Long id);
	public List<Receta> findAll();
	//nuevo
	public RecetaModel findById(Integer id);

	public RecetaModel create(RecetaModel model);

	public RecetaModel update(Integer id, RecetaModel model);

	public void delete(Integer id);

}
