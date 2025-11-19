package tuti.desi.services.asistido;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.dao.IAsistidoRepo;
import tuti.desi.entidades.Asistido;
import tuti.desi.entidades.Familia;
import tuti.desi.presentacion.models.AsistidoModel;
import tuti.desi.services.familia.IFamiliaService;

@Service
public class AsistidoService implements IAsistidoService{

    @Autowired
    private IAsistidoRepo asistidoRepo;
    @Autowired
    private IFamiliaService familiaService;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<AsistidoModel> findAll() {
        return asistidoRepo.findAll().stream()

                .map(asistido -> {

                    AsistidoModel model = modelMapper.map(asistido, AsistidoModel.class);


                    if (asistido.getFamilia() != null) {

                        model.setFamiliaNroFamilia(asistido.getFamilia().getNroFamilia());
                    }

                    return model;
                })
                .collect(Collectors.toList());
    }


    @Override
    public void saveAsistido(AsistidoModel asistidoModel) {


        Integer id = asistidoModel.getId();
        boolean isNew = (id == null || id.equals(0));


        Asistido asistido = modelMapper.map(asistidoModel, Asistido.class);


        if (asistidoModel.getFamiliaNroFamilia() != null) {


            Familia familia = familiaService.getFamiliaById(asistidoModel.getFamiliaNroFamilia());


            asistido.setFamilia(familia);
        }


        if (isNew) {

            asistido.setId(null);


            asistido.setFechaRegistro(LocalDate.now());
        }


        asistidoRepo.save(asistido); // Guarda (Alta) o Actualiza (Modificación)
    }

    // 3. deleteAsistido
    @Override
    public void deleteAsistido(Integer id) {
        asistidoRepo.deleteById(id);
    }


    @Override
    public AsistidoModel findAsistido(Integer id) {
        Asistido asistido = asistidoRepo.findById(id).orElse(null);
        if (asistido != null) {
            return modelMapper.map(asistido, AsistidoModel.class);
        }
        return null;
    }
}
