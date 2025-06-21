package tuti.desi.services;

import java.sql.Date;
import java.util.List;


import tuti.desi.entidades.Asistido;
import tuti.desi.entidades.Familia;


public interface IAsistidoService {

	public List<Asistido> getAll();
	
	public void saveAsistido (Asistido asistido);
	
	public void deleteAsistido (Long id);
	
	public Asistido findAsistido (Long Id);
	
	public void editAsistido (Long idOriginal, Long nuevoId, Integer nuevoDni, String nuevoDomicilio, String nuevoNombre, String nuevoApellido, Date nuevaFechaNac, String nuevaOcupacion, Date nuevaFechaReg, Familia nuevaFamilia);
}

