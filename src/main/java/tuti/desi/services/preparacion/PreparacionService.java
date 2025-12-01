package tuti.desi.services.preparacion;

import java.time.LocalDate;
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
    public List<PreparacionModel> findAll() {
        List<Preparacion> listaPreparaciones = preparacionRepo.findByActivoTrueOrderByFechaCoccion();
        return listaPreparaciones.stream()
                .map(p -> {
                    PreparacionModel model = modelMapper.map(p, PreparacionModel.class);
                    if (p.getReceta() != null) {
                        model.setRecetaId(p.getReceta().getId());
                    }
                    return model;
                })
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
        if(preparacionModel.getFechaCoccion() != null && preparacionModel.getFechaCoccion().toLocalDate().isAfter(LocalDate.now())){
            throw new RuntimeException("La fecha de cocción no puede ser futura");
        }
        if(preparacionModel.getFechaVencimiento().toLocalDate().isBefore(preparacionModel.getFechaCoccion().toLocalDate())){
            throw new RuntimeException("La fecha de vencimiento no puede ser anterior a la fecha de cocción");
        }
        Preparacion preparacion = modelMapper.map(preparacionModel, Preparacion.class);

        if (preparacionModel.getRecetaId() != null) {
            RecetaModel receta = recetaService.findById(preparacionModel.getRecetaId());
            Receta entidad = modelMapper.map(receta, Receta.class);
            preparacion.setReceta(entidad);
        }
        Preparacion preparacionGuardada = preparacionRepo.save(preparacion);

        System.out.println(preparacion);
        return modelMapper.map(preparacionGuardada, PreparacionModel.class);
    }

    @Override
    public void deletePreparacionModel(Integer id){
        preparacionRepo.deleteById(id);
    }

    @Override
    public PreparacionModel findPreparacion(Integer id){
        Preparacion preparacion = preparacionRepo.findById(id).orElse(null);
        if (preparacion != null) {
            return modelMapper.map(preparacion, PreparacionModel.class);
        }
        return null;
    }

    @Override
    public PreparacionModel editPreparacion(PreparacionModel preparacionModel){
        Preparacion preparacion = preparacionRepo.findById(preparacionModel.getId())
                .orElseThrow(() -> new RuntimeException("Preparacion no encontrada"));
        preparacion.setReceta(modelMapper.map(recetaService.findById(preparacionModel.getRecetaId()), Receta.class));
        preparacion.setTotalRacionesPreparadas(preparacionModel.getTotalRacionesPreparadas());
        preparacion.setFechaVencimiento(preparacionModel.getFechaVencimiento());
        preparacion.setFechaCoccion(preparacionModel.getFechaCoccion());
        preparacionRepo.save(preparacion);
        return preparacionModel;
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

        return listaPreparaciones.stream()
                .map(p -> modelMapper.map(p, PreparacionModel.class))
                .toList();

    }
}