package tuti.desi.services.asistencia;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.dao.IAsistenciaRepo;
import tuti.desi.dao.IAsistidoRepo;
import tuti.desi.dao.IPreparacionRepo;
import tuti.desi.entidades.Asistencia;
import tuti.desi.entidades.Asistido;
import tuti.desi.entidades.Preparacion;
import tuti.desi.presentacion.models.AsistenciaModel;
import tuti.desi.services.asistido.IAsistidoService;
import tuti.desi.services.preparacion.IPreparacionService;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AsistenciaService implements IAsistenciaService {

    @Autowired
    private IAsistenciaRepo asistenciaRepo;
    @Autowired
    private IPreparacionRepo preparacionRepo;
    @Autowired
    private IAsistidoRepo asistidoRepo;
    @Autowired
    private IPreparacionService preparacionService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AsistenciaModel crearAsistencia(AsistenciaModel asistenciaModel) {
        Date fechaVencimientoRacion = preparacionService.findPreparacion(asistenciaModel.getAsistidoId()).getFechaVencimiento();
        if(asistenciaModel.getFechaEntrega().after(fechaVencimientoRacion))
        {
            throw new IllegalArgumentException("La fecha de entrega no puede ser posterior a la fecha de vencimiento de la racion");
        }

        Asistencia asistencia = new Asistencia();
        asistencia.setRacion(preparacionRepo.findById(asistenciaModel.getRacionId())
                .orElseThrow(()->new RuntimeException("No existe la racion con el id: "+asistenciaModel.getRacionId())));
        asistencia.setAsistido(asistidoRepo.findById(asistenciaModel.getAsistidoId())
                .orElseThrow(()->new RuntimeException("No existe el asistido con el id: "+asistenciaModel.getAsistidoId())));
        asistencia.setFechaEntrega(asistenciaModel.getFechaEntrega());
        return modelMapper.map(asistenciaRepo.save(asistencia), AsistenciaModel.class);
    }

    @Override
    public List<AsistenciaModel> obtenerAsistencias() {
        List<Asistencia> listaAsistencias = asistenciaRepo.findAll();
        return listaAsistencias.stream()
                .map(this::convertToModel)
                .toList();
    }

    @Override
    public String eliminarAsistencia(Integer id) {
        try{
        asistenciaRepo.deleteById(id);
        return "Asistencia con id: "+id+" eliminada correctamente.";}
        catch (Exception e){
            return "No se pudo eliminar la asistencia con id: "+id;
        }

    }

    @Override
    public AsistenciaModel actualizarAsistencia(Integer id, AsistenciaModel asistenciaModel) {
        return null;
    }

    private AsistenciaModel convertToModel(Asistencia asistencia){
        AsistenciaModel model = new AsistenciaModel();

        model.setId(asistencia.getId());
        model.setFechaEntrega(asistencia.getFechaEntrega());

        if (asistencia.getRacion() != null) {
            model.setRacionId(asistencia.getRacion().getId());
        }

        if (asistencia.getAsistido() != null) {
            model.setAsistidoId(asistencia.getAsistido().getId());
        }

        return model;
    }
}
