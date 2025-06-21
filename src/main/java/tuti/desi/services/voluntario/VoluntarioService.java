package tuti.desi.services.voluntario;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.IVoluntarioRepo;
import tuti.desi.entidades.EntregaAsistencia;
import tuti.desi.entidades.Voluntario;

@Service
public class VoluntarioService implements IVoluntarioService{
	
	private IVoluntarioRepo voluntarioRepo;

	@Override
	public List<Voluntario> getAll() {
		List<Voluntario> listaVoluntarios = voluntarioRepo.findAll();
		return listaVoluntarios;
	}

	@Override
	public void saveVoluntario(Voluntario voluntario) {
		voluntarioRepo.save(voluntario);
		
	}

	@Override
	public void deleteVoluntario(Long id) {
		voluntarioRepo.deleteById(id);
		
	}

	@Override
	public Voluntario findVoluntario(Long id) {
		Voluntario volu = voluntarioRepo.findById(id).orElse(null);
		return volu;
	}

	@Override
	public void editVoluntario(Long idOriginal, Integer nuevoDni, String nuevoNombre,
			String nuevoApellido, Date nuevaFechaNac, String nuevaOcupacion, Long nuevoNumeroSeguro, List<EntregaAsistencia> nuevaEntregaAsistencia) {
		Voluntario volu = this.findVoluntario(idOriginal);
		volu.setDni(nuevoDni);
		volu.setNombre(nuevoNombre);
		volu.setApellido(nuevoApellido);
		volu.setFechaNacimiento(nuevaFechaNac);
		volu.setOcupacion(nuevaOcupacion);
		volu.setNroSeguro(0);
		volu.setEntregaAsistnecia(nuevaEntregaAsistencia);
		
	}

}
