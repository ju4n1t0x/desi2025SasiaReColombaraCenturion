package tuti.desi.services.asistido;

import java.sql.Date;
import java.util.List;


import tuti.desi.entidades.Asistido;
import tuti.desi.entidades.Familia;


public interface IAsistidoService {

	//método para traer todos los asistidos
	public List<Asistido> getAll();
	
	//método para guardar un nuevo asistido
	public void saveAsistido (Asistido asistido);
	
	//método para borrar un asistido
	public void deleteAsistido (Long id);
	
	//método para buscar por id un asistido
	public Asistido findAsistido (Long Id);
	
	//metodo para editar un asistido
	public void editAsistido (Long idOriginal, Long nuevoId, Integer nuevoDni, String nuevoDomicilio, String nuevoNombre, String nuevoApellido, Date nuevaFechaNac, String nuevaOcupacion, Date nuevaFechaReg, Familia nuevaFamilia);
}

