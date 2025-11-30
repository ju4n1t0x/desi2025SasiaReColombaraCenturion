package tuti.desi.services.preparacion;

import java.sql.Date;
import java.util.List;

import tuti.desi.entidades.Preparacion;
import tuti.desi.entidades.Receta;
import tuti.desi.presentacion.models.PreparacionModel;

public interface IPreparacionService {

	public List<PreparacionModel> getAll();

	public PreparacionModel convertToModel(Preparacion preparacion);

    List<PreparacionModel> findAll();

    PreparacionModel save(PreparacionModel preparacionModel);

	public void deletePreparacionModel(Integer id);

	public PreparacionModel findPreparacion(Integer id);

	public PreparacionModel editPreparacion(PreparacionModel preparacionModel);

	List<PreparacionModel> findPreparacionesDelDiaConStock();

	List<Preparacion> findByFechaCoccionAndActivoTrue(Date fecha);
	public List<PreparacionModel> findPreparacionesPorRecetaId(Integer recetaId);
}

