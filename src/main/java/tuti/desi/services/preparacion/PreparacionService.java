package tuti.desi.services.preparacion;

import java.sql.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.dao.IPreparacionRepo;
import tuti.desi.entidades.EntregaAsistencia;
import tuti.desi.entidades.Preparacion;
import tuti.desi.entidades.Receta;
import tuti.desi.presentacion.models.EntregaAsistenciaModel;
import tuti.desi.presentacion.models.PreparacionModel;

@Service
public class PreparacionService implements IPreparacionService {

    @Autowired
    private IPreparacionRepo preparacionRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PreparacionModel convertToModel(Preparacion preparacion){
        return modelMapper.map(preparacion, PreparacionModel.class);
    }

    @Override
    public List<PreparacionModel> getAll() {
        List<Preparacion> listaPreparaciones = preparacionRepo.findAll();
        return modelMapper.map(listaPreparaciones, List.class);
                
    }

    @Override
    public PreparacionModel save(PreparacionModel preparacionModel){
        Preparacion preparacion = modelMapper.map(preparacionModel, Preparacion.class);
        Preparacion preparacionGuardada = preparacionRepo.save(preparacion);
        return modelMapper.map(preparacionGuardada, PreparacionModel.class);
    }

    @Override
    public void deletePreparacionModel(Long id){
        preparacionRepo.deleteById(id);
    }
    @Override
    public PreparacionModel findPreparacion(Long id){
        Preparacion preparacion = preparacionRepo.findById(id).orElse(null);
        if (preparacion != null) {
            return modelMapper.map(preparacion, PreparacionModel.class);
        }
        return null;
    }


    @Override
    public void editPreparacion(PreparacionModel preparacionModel){
        Preparacion preparacionExistente = preparacionRepo.findById(preparacionModel.getId())
                .orElseThrow(() -> new RuntimeException("Preparacion no encontrada"));

        modelMapper.map(preparacionModel, preparacionExistente);

        Preparacion preparacionGuardada = preparacionRepo.save(preparacionExistente);
        modelMapper.map(preparacionGuardada, PreparacionModel.class);
    }
    public List<PreparacionModel> findPreparacionesDelDiaConStock(){
    List<Preparacion> listaPreparacionesDelDiaConStock = preparacionRepo.findPreparacionesDelDiaConStock();
    return modelMapper.map(listaPreparacionesDelDiaConStock, List.class);}

}