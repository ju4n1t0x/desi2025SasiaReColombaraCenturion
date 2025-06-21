package tuti.desi.services.entregaAsistencia;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.IEntregaAsistenciaRepo;
import tuti.desi.entidades.EntregaAsistencia;
import tuti.desi.entidades.Preparacion;

@Service
public class EntregaAsistenciaService implements IEntregaAsistenciaService{

	@Autowired
	private IEntregaAsistenciaRepo entregaAsistenciaRepo;

	@Override
	public List<EntregaAsistencia> getAll() {
		List<EntregaAsistencia> listaEntregaAsistencias = entregaAsistenciaRepo.findAll();
		return listaEntregaAsistencias;
	}

	@Override
	public void saveEntregaAsistencia(EntregaAsistencia entregaAsistencia) {
		entregaAsistenciaRepo.save(entregaAsistencia);
		
	}

	@Override
	public void deleteEntregaAsistencia(Long id) {
		entregaAsistenciaRepo.deleteById(id);
		
	}

	@Override
	public EntregaAsistencia findEntregaAsistencia(Long id) {
		EntregaAsistencia entregaAsis = entregaAsistenciaRepo.findById(id).orElse(null);
		return entregaAsis;
	}

	@Override
	public void editEntregaAsistencia(Long idOriginal, Date nuevaFecha, Integer nuevaCantidadRaciones, Preparacion nuevaPreparacion) {
		EntregaAsistencia entregaAsis = this.findEntregaAsistencia(idOriginal);
		entregaAsis.setFecha(nuevaFecha);
		entregaAsis.setCantidadRaciones(nuevaCantidadRaciones);
		entregaAsis.setPreparacion(nuevaPreparacion);
	}
	
	
}
