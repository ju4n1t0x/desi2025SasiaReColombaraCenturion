package tuti.desi.services.familia;

import java.sql.Date;
import java.util.List;

import tuti.desi.entidades.Asistido;
import tuti.desi.entidades.Familia;
import tuti.desi.presentacion.models.FamiliaModel;

public interface IFamiliaService {

	public List<Familia> getAll();
	
	public void saveFamilia(Familia familia);
	
	public void deleteFamilia(Integer nroFamilia);
	
	public FamiliaModel findFamilia(Integer nroFamilia);

	public void editFamilia(FamiliaModel familiaModel);
}
