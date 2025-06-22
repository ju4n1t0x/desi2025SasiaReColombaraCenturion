package tuti.desi.services.familia;

import java.sql.Date;
import java.util.List;

import tuti.desi.entidades.Asistido;
import tuti.desi.entidades.Familia;

public interface IFamiliaService {

	public List<Familia> getAll();
	
	public void saveFamilia(Familia familia);
	
	public void deleteFamilia(Integer nroFamilia);
	
	public Familia findFamilia(Integer nroFamilia);
	
	public void editFamilia(Integer nroFamilia, String nuevoNombre, Date nuevaFrechaRegistro, List<Asistido> nuevaListaAsistidos);
}
