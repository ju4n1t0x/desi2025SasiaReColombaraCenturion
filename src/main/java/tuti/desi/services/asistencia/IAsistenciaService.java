package tuti.desi.services.asistencia;

import org.springframework.beans.factory.annotation.Autowired;
import tuti.desi.dao.IAsistenciaRepo;
import tuti.desi.presentacion.models.AsistenciaModel;

import java.util.Date;
import java.util.List;


public interface IAsistenciaService {

    public AsistenciaModel crearAsistencia(AsistenciaModel asistenciaModel);

    public List<AsistenciaModel> obtenerAsistencias();

    public void eliminarAsistencia(Integer id);

    public AsistenciaModel actualizarAsistencia(Integer id, AsistenciaModel asistenciaModel);


}
