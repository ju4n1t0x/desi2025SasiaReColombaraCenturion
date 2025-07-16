package tuti.desi.services.familia;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.dao.IFamiliaRepo;
import tuti.desi.entidades.Asistido;
import tuti.desi.entidades.Familia;
import tuti.desi.entidades.Preparacion;
import tuti.desi.presentacion.models.FamiliaModel;
import tuti.desi.presentacion.models.PreparacionModel;

@Service
public class FamiliaService implements IFamiliaService{
	@Autowired
	private IFamiliaRepo familiaRepo;
    @Autowired
    private ModelMapper modelMapper;

	@Override
	public List<Familia> getAll() {
		List<Familia> listaFamilias = familiaRepo.findAll();
		return listaFamilias;
	}

	@Override
	public void saveFamilia(Familia familia) {
		familiaRepo.save(familia);
		
	}

	@Override
	public void deleteFamilia(Integer nroFamilia) {
		familiaRepo.deleteById(nroFamilia);
		
	}

	@Override
	public FamiliaModel findFamilia(Integer nroFamilia) {
		Familia familia = familiaRepo.findById(nroFamilia).orElse(null);
		if (familia != null) {
			return modelMapper.map(familia, FamiliaModel.class);
		}
		return null;
	}

	@Override
	public void editFamilia(FamiliaModel familiaModel) {
		Familia familia = familiaRepo.findById(familiaModel.getNroFamilia())
				.orElseThrow(() -> new RuntimeException("Familia no encontrada"));
		familia.setNombre(familiaModel.getNombre());
		familia.setFechaRegistro(familiaModel.getFechaRegistro());
		// Si necesitas mapear la lista de asistidos del modelo a entidades:
		List<Asistido> asistidos = familiaModel.getAsistido().stream()
				.map(asistidoModel -> modelMapper.map(asistidoModel, Asistido.class))
				.toList();
		familia.setAsistido(asistidos);
		familiaRepo.save(familia);
	}
	public List<FamiliaModel> findAllFamilias() {
		return familiaRepo.findAllWithAsistidos().stream()
				.map(familia -> modelMapper.map(familia, FamiliaModel.class))
				.collect(Collectors.toList());
	}

}
