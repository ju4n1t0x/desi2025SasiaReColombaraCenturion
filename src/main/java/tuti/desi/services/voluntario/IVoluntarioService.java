package tuti.desi.services.voluntario;

import java.sql.Date;
import java.util.List;

import tuti.desi.entidades.EntregaAsistencia;
import tuti.desi.entidades.Voluntario;

public interface IVoluntarioService {

	public List<Voluntario> getAll();
	
	public void saveVoluntario(Voluntario voluntario);
	
	public void deleteVoluntario(Long id);
	
	public Voluntario findVoluntario(Long id);
	
	public void editVoluntario(Long idOiriginal, Long nuevoId, Integer nuevoDni, String nuevoNombre, String nuevoApellido, Date nuevaFechaNac, String nuevaOcupacion, Long nuevoNumeroSeguro, List<EntregaAsistencia> nuevaEntregaAsistencia);
}
