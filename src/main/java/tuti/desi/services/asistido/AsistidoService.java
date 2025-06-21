package tuti.desi.services.asistido;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IAsistidoRepo;
import tuti.desi.entidades.Asistido;
import tuti.desi.entidades.Familia;

@Service
public class AsistidoService implements IAsistidoService{

	@Autowired
	private IAsistidoRepo asistidoRepo;
	
	@Override
	public List<Asistido> getAll() {
		List<Asistido> listaAsistidos = asistidoRepo.findAll();
		return listaAsistidos;
	}

	@Override
	public void saveAsistido(Asistido asistido) {
		asistidoRepo.save(asistido);
		
	}

	@Override
	public void deleteAsistido(Long id) {
		asistidoRepo.deleteById(id);
		
	}

	@Override
	public Asistido findAsistido(Long Id) {
		Asistido asis = asistidoRepo.findById(Id).orElse(null);
		return asis;
	}
	
	@Override
	public void editAsistido(Long idOriginal, Long nuevoId, Integer nuevoDni, String nuevoDomicilio, String nuevoNombre, String nuevoApellido, Date nuevaFechaNac, String nuevaOcupacion, Date nuevaFechaReg, Familia nuevaFamilia) {
		Asistido asis = this.findAsistido(idOriginal);
		asis.setId(nuevoId);
		asis.setDni(nuevoDni);
		asis.setApellido(nuevoApellido);
		asis.setNombre(nuevoNombre);
		asis.setDomicilio(nuevoDomicilio);
		asis.setFechaNacimiento(nuevaFechaNac);
		asis.setOcupacion(nuevaOcupacion);
		asis.setFechaRegistro(nuevaFechaReg);
		asis.setFamilia(nuevaFamilia);
		
		
		
	}
	
}
