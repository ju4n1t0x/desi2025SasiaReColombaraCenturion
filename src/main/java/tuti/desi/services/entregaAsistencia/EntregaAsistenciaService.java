package tuti.desi.services.entregaAsistencia;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tuti.desi.dao.IAsistidoRepo;
import tuti.desi.dao.IEntregaAsistenciaRepo;
import tuti.desi.dao.IFamiliaRepo;
import tuti.desi.dao.IPreparacionRepo;
import tuti.desi.entidades.EntregaAsistencia;
import tuti.desi.entidades.Familia;
import tuti.desi.entidades.Preparacion;
import tuti.desi.presentacion.models.EntregaAsistenciaModel;
import tuti.desi.presentacion.models.FamiliaModel;
import tuti.desi.services.transform.Transformator;


@Service
@Transactional
public class EntregaAsistenciaService implements IEntregaAsistenciaService {

	@Autowired
	private IEntregaAsistenciaRepo entregaAsistenciaRepo;
	@Autowired
	private IFamiliaRepo familiaRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private IPreparacionRepo preparacionRepo;
	@Autowired
	private IAsistidoRepo asistidoRepo;
    @Autowired
    private Transformator transformator;


	public EntregaAsistenciaModel convertToModel(EntregaAsistencia entregaAsistencia) {
		return modelMapper.map(entregaAsistencia, EntregaAsistenciaModel.class);
	}

	@Override
	public EntregaAsistenciaModel save(EntregaAsistenciaModel entregaAsistenciaModel) {
		System.out.println("comiendo del save");
		Familia familia = familiaRepo.findById(entregaAsistenciaModel.getFamilia().getNroFamilia()).orElse(null);
		Preparacion preparacion = preparacionRepo.findById(entregaAsistenciaModel.getPreparacion().getId()).orElse(null);
		long cantidadIntegrantes = asistidoRepo.countByFamilia(familia);

		if(entregaAsistenciaModel.getCantidadRaciones() > cantidadIntegrantes) {
			throw new IllegalArgumentException("La cantidad de raciones no puede ser mayor a la cantidad de integrantes de la familia");
		}
		if(entregaAsistenciaModel.getCantidadRaciones() > preparacion.getStockRacionesRestantes()) {
			throw new IllegalArgumentException("La cantidad de raciones no puede ser mayor al stock restante de la preparacion");
		}

		int nuevoStock = preparacion.getStockRacionesRestantes() - entregaAsistenciaModel.getCantidadRaciones();
		preparacion.setStockRacionesRestantes(nuevoStock);

		EntregaAsistencia entregaAsistencia = new EntregaAsistencia();
		entregaAsistencia.setFamilia(familia);
		entregaAsistencia.setPreparacion(preparacion);
		entregaAsistencia.setCantidadRaciones(entregaAsistenciaModel.getCantidadRaciones());
		entregaAsistencia.setFecha(LocalDate.now());
		EntregaAsistencia entregaGuardada = entregaAsistenciaRepo.save(entregaAsistencia);
		return modelMapper.map(entregaGuardada, EntregaAsistenciaModel.class);
}


	@Override
	public void deleteEntregaAsistencia(Integer id) {
		EntregaAsistencia entrega = entregaAsistenciaRepo.findById(id)
		                          .orElseThrow(() ->new RuntimeException("Entrega de asistencia no encontrada"));
		 Preparacion preparacion = entrega.getPreparacion();
		           preparacion.setStockRacionesRestantes(preparacion.getStockRacionesRestantes() + entrega.getCantidadRaciones());
		           preparacionRepo.save(preparacion);

		           entregaAsistenciaRepo.deleteById(id);

	}

	@Override
	public EntregaAsistenciaModel findEntregaAsistencia(Integer id) {
    EntregaAsistencia entregaAsis = entregaAsistenciaRepo.findById(id).orElse(null);
    if (entregaAsis != null) {
		if(entregaAsis.getPreparacion().getStockRacionesRestantes() != 0)
        return modelMapper.map(entregaAsis, EntregaAsistenciaModel.class);
    }
    return null;
}

// 4. Edit - Refactorizado para usar Models
@Override
public EntregaAsistenciaModel editEntregaAsistencia(EntregaAsistenciaModel entregaAsistenciaModel) {
    // Buscar la entidad existente
    EntregaAsistencia entregaExistente = entregaAsistenciaRepo.findById(entregaAsistenciaModel.getId())
        .orElseThrow(() -> new RuntimeException("EntregaAsistencia no encontrada"));

    // Mapear los cambios del modelo a la entidad
    modelMapper.map(entregaAsistenciaModel, entregaExistente);

    // Guardar y retornar el modelo actualizado
    EntregaAsistencia entregaGuardada = entregaAsistenciaRepo.save(entregaExistente);
    return modelMapper.map(entregaGuardada, EntregaAsistenciaModel.class);
}

	public List<FamiliaModel> findAllFamilias() {
		List<Familia> familiaEntities = familiaRepo.findAll();
		return familiaEntities.stream()
				.map(familia -> modelMapper.map(familia, FamiliaModel.class))
				.collect(Collectors.toList());

	}

	@Override
     public List<EntregaAsistenciaModel> findAll() {

		     // 1. Obtiene la lista de todas las entidades 'EntregaAsistencia' desde el repositorio.
		    List<EntregaAsistencia> entregasEntidades = this.entregaAsistenciaRepo.buscarPorFamiliaYPreparacion();

		     // 2. Usa un Stream de Java para transformar cada entidad a su 'Model' correspondiente.
		     //    Esto es más eficiente y moderno que un bucle 'for'.
		List<EntregaAsistenciaModel> listadoDeEntregas = entregasEntidades.stream()
		        .map(entrega -> modelMapper.map(entrega, EntregaAsistenciaModel.class))
		        .collect(Collectors.toList());

		    // 3. Devuelve la lista de modelos lista para la vista.
		    return listadoDeEntregas;

	}

	public List<EntregaAsistenciaModel> findAll(LocalDate fecha, Long nroFamilia, String nombreFamilia){
		List<EntregaAsistencia> entregasEntidadesLista = entregaAsistenciaRepo.findByFechaAndFamiliaNroFamiliaAndFamiliaNombre(fecha, nroFamilia, nombreFamilia);
		return entregasEntidadesLista.stream()
				.map(entrega -> modelMapper.map(entrega, EntregaAsistenciaModel.class))
				.collect(Collectors.toList());
	}





}
