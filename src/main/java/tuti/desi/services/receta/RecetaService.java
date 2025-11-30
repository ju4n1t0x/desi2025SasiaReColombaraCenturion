package tuti.desi.services.receta;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.dao.IRecetaRepo;
import tuti.desi.entidades.ItemReceta;
import tuti.desi.entidades.Preparacion;
import tuti.desi.entidades.Producto;
import tuti.desi.entidades.Receta;
import tuti.desi.presentacion.models.ItemRecetaModel;
import tuti.desi.presentacion.models.RecetaModel;
import tuti.desi.services.ingrediente.IIngredienteService;
import tuti.desi.services.itemReceta.ItemRecetaService;

@Service
public class RecetaService implements IRecetaService{

	@Autowired
	private IRecetaRepo recetaRepo;

	@Autowired
	private ItemRecetaService itemRecetaService;

	@Autowired
	private IIngredienteService ingredienteService;

    @Autowired
    private ModelMapper modelMapper;


	@Override
	public List<Receta> findAll() {
		List<Receta> listaRecetas = recetaRepo.findAll();
		return listaRecetas;
	}

	@Override
	public RecetaModel findById(Integer id) {
		Receta receta = recetaRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Receta no encontrada"));
		return modelMapper.map(receta, RecetaModel.class);
	}


	@Override
	public RecetaModel create(RecetaModel model) {
		validarDatos(model);

		if (recetaRepo.existsByNombre(model.getNombre())) {
			throw new RuntimeException("Ya existe una receta con ese nombre");
		}

		Receta entidad = modelMapper.map(model, Receta.class);

		Receta guardada = recetaRepo.save(entidad);
		return modelMapper.map(guardada, RecetaModel.class);
	}

	@Override
	public RecetaModel update(Integer id, RecetaModel model) {
		validarDatos(model);

		Receta receta = recetaRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Receta no encontrada"));

		// si cambian el nombre, chequeo duplicados
		if (!receta.getNombre().equals(model.getNombre())
				&& recetaRepo.existsByNombre(model.getNombre())) {
			throw new RuntimeException("Ya existe una receta con ese nombre");
		}

		receta.setNombre(model.getNombre());
		receta.setPesoRacion(model.getPesoRacion());
		receta.setCaloriasRacion(model.getCaloriasRacion());

		Receta guardada = recetaRepo.save(receta);
		return modelMapper.map(guardada, RecetaModel.class);
	}

	@Override
	public void delete(Integer id) {
		Receta receta = recetaRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Receta no encontrada"));
		recetaRepo.delete(receta);
	}

	private void validarDatos(RecetaModel model) {
		if (model.getNombre() == null || model.getNombre().isBlank()) {
			throw new RuntimeException("El nombre es obligatorio");
		}
		if (model.getPesoRacion() == null || model.getPesoRacion() <= 0) {
			throw new RuntimeException("El peso de la ración debe ser positivo");
		}
		if (model.getCaloriasRacion() == null || model.getCaloriasRacion() <= 0) {
			throw new RuntimeException("Las calorías deben ser un entero positivo");
		}
	}

}
