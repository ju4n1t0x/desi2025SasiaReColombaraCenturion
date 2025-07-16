package tuti.desi.services.preparacion;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.dao.IPreparacionRepo;
import tuti.desi.entidades.Preparacion;
import tuti.desi.entidades.Receta;
import tuti.desi.presentacion.models.PreparacionModel;
import tuti.desi.services.receta.RecetaService;

@Service
public class PreparacionService implements IPreparacionService {

    @Autowired
    private IPreparacionRepo preparacionRepo;

    @Autowired
    private RecetaService recetaService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PreparacionModel convertToModel(Preparacion preparacion){
        return modelMapper.map(preparacion, PreparacionModel.class);
    }

    @Override
    public List<PreparacionModel> getAll() {
        List<Preparacion> listaPreparaciones = preparacionRepo.findByActivoTrueOrderByFechaCoccion();
        return modelMapper.map(listaPreparaciones, List.class);
    }

    @Override
    public PreparacionModel save(PreparacionModel preparacionModel){

        Preparacion preparacion = modelMapper.map(preparacionModel, Preparacion.class);

        if (preparacionModel.getRecetaId() != null) {
            Receta receta = recetaService.findReceta(preparacionModel.getRecetaId());
            preparacion.setReceta(receta);
        }
        Preparacion preparacionGuardada = preparacionRepo.save(preparacion);

        System.out.println(preparacion);
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
        Preparacion preparacion = preparacionRepo.findById(preparacionModel.getId())
                .orElseThrow(() -> new RuntimeException("Preparacion no encontrada"));
        preparacion.setId(preparacionModel.getId());
        preparacion.setReceta(modelMapper.map(preparacionModel.getRecetaId(), Receta.class));
        preparacion.setFechaCoccion(preparacionModel.getFechaCoccion());
        preparacionRepo.save(preparacion);

    }

    @Override
    public List<Preparacion> findByFechaCoccionAndActivoTrue(java.sql.Date fecha){
        return preparacionRepo.findByFechaCoccionAndActivoTrue(fecha);
    }

    public List<PreparacionModel> findPreparacionesDelDiaConStock(){
        List<Preparacion> listaPreparacionesDelDiaConStock = preparacionRepo.findPreparacionesDelDiaConStock();
        return modelMapper.map(listaPreparacionesDelDiaConStock, List.class);
    }

}