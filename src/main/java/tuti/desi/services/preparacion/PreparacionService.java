package tuti.desi.services.preparacion;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.dao.IPreparacionRepo;
import tuti.desi.entidades.Preparacion;
import tuti.desi.entidades.Receta;
import tuti.desi.presentacion.models.PreparacionModel;
import tuti.desi.presentacion.models.RecetaModel;
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
    public List<PreparacionModel> findAll(){
        return preparacionRepo.findByActivoTrueOrderByFechaCoccion()
                .stream()
                .map(this::convertToModelSimple)
                .toList();
    }

    private PreparacionModel convertToModelSimple(Preparacion p) {
        PreparacionModel model = new PreparacionModel();

        model.setId(p.getId());
        model.setFechaCoccion(p.getFechaCoccion());
        model.setTotalRacionesPreparadas(p.getTotalRacionesPreparadas());

        if (p.getReceta() != null) {
            RecetaModel recetaModel = new RecetaModel();
            //recetaModel.setId(p.getReceta().getId());
            recetaModel.setNombre(p.getReceta().getNombre());
            model.setReceta(recetaModel);
        }

        return model;
    }

    @Override
    public PreparacionModel save(PreparacionModel preparacionModel){

        Preparacion preparacion = modelMapper.map(preparacionModel, Preparacion.class);

        if (preparacionModel.getRecetaId() != null) {
            RecetaModel receta = recetaService.findById(preparacionModel.getRecetaId());
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

    public List<PreparacionModel> findPreparacionesPorRecetaId(Integer recetaId){
        List<Preparacion> listaPreparaciones = preparacionRepo.findByReceta_IdAndActivoTrue(recetaId);
        return modelMapper.map(listaPreparaciones, List.class);
    }
}