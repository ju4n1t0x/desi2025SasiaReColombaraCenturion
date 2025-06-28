package tuti.desi.services.entregaAsistencia;

import java.sql.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.dao.IEntregaAsistenciaRepo;
import tuti.desi.entidades.EntregaAsistencia;
import tuti.desi.presentacion.models.EntregaAsistenciaModel;


@Service
public class EntregaAsistenciaService implements IEntregaAsistenciaService {

	@Autowired
	private IEntregaAsistenciaRepo entregaAsistenciaRepo;
	@Autowired
	private ModelMapper modelMapper;

	public EntregaAsistenciaModel convertToModel(EntregaAsistencia entregaAsistencia) {
		return modelMapper.map(entregaAsistencia, EntregaAsistenciaModel.class);
	}


	@Override
	public EntregaAsistenciaModel save(EntregaAsistenciaModel entregaAsistenciaModel) {
    EntregaAsistencia entregaAsistencia = modelMapper.map(entregaAsistenciaModel, EntregaAsistencia.class);
    EntregaAsistencia entregaGuardada = entregaAsistenciaRepo.save(entregaAsistencia);
    return modelMapper.map(entregaGuardada, EntregaAsistenciaModel.class);
}


	@Override
	public void deleteEntregaAsistencia(Long id) {
		entregaAsistenciaRepo.deleteById(id);

	}

	@Override
	public EntregaAsistenciaModel findEntregaAsistencia(Long id) {
    EntregaAsistencia entregaAsis = entregaAsistenciaRepo.findById(id).orElse(null);
    if (entregaAsis != null) {
        return modelMapper.map(entregaAsis, EntregaAsistenciaModel.class);
    }
    return null;
}

// 4. Edit - Refactorizado para usar Models
@Override
public EntregaAsistenciaModel editEntregaAsistencia(EntregaAsistenciaModel entregaAsistenciaModel) {
    // Buscar la entidad existente
    EntregaAsistencia entregaExistente = entregaAsistenciaRepo.findById(entregaAsistenciaModel.getIdEntrega())
        .orElseThrow(() -> new RuntimeException("EntregaAsistencia no encontrada"));

    // Mapear los cambios del modelo a la entidad
    modelMapper.map(entregaAsistenciaModel, entregaExistente);

    // Guardar y retornar el modelo actualizado
    EntregaAsistencia entregaGuardada = entregaAsistenciaRepo.save(entregaExistente);
    return modelMapper.map(entregaGuardada, EntregaAsistenciaModel.class);
}

}
