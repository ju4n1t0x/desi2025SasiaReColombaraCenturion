package tuti.desi.services.entregaAsistencia;

import java.sql.Date;
import java.util.List;

import tuti.desi.entidades.EntregaAsistencia;
import tuti.desi.entidades.Preparacion;

public interface IEntregaAsistenciaService {

	public List<EntregaAsistencia> getAll();
	
	public void saveEntregaAsistencia(EntregaAsistencia entregaAsistencia);
	
	public void deleteEntregaAsistencia(Long id);
	
	public EntregaAsistencia findEntregaAsistencia(Long id);
	
	public void editEntregaAsistencia(Long idOriginal, Long nuevoId, Date nuevaFecha, Integer nuevaCantidadRaciones, Preparacion nuevaPreparacion);
}
