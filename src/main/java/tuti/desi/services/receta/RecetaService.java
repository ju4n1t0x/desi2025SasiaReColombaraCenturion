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

	@Override
	public List<Receta> getAll() {
		List<Receta> listaRecetas = recetaRepo.findAll();
		return listaRecetas;
	}

	@Override
	public void saveReceta(String nombre, String descripcion, List<Long> productoIds, List<Double> productoCantidades, List<Long> condimentoIds) {
		Receta receta = new Receta();
		receta.setNombre(nombre);
		receta.setDescripcion(descripcion);
		receta.setItemReceta(new ArrayList<>());

		// Procesar productos
		if (productoIds != null && !productoIds.isEmpty()) {
			for (int i = 0; i < productoIds.size(); i++) {
				Long productoId = productoIds.get(i);
				Double cantidad = productoCantidades.get(i);

				ingredienteService.findProductoById(productoId).ifPresent(producto -> {
					ItemReceta itemReceta = itemRecetaService.saveItemReceta(producto, cantidad);
					itemReceta.setReceta(receta); // ← Establecer la relación bidireccional
					receta.getItemReceta().add(itemReceta);
				});
			}
		}

		// Procesar condimentos
		if (condimentoIds != null && !condimentoIds.isEmpty()) {
			for (Long condimentoId : condimentoIds) {
				ingredienteService.findCondimentoById(condimentoId).ifPresent(condimento -> {
					ItemReceta itemReceta = itemRecetaService.saveItemRecetaCondimento(condimento);
					itemReceta.setReceta(receta);
					receta.getItemReceta().add(itemReceta);
				});
			}
		}

		recetaRepo.save(receta);
	}

	@Override
	public void saveReceta(Receta receta) {
		recetaRepo.save(receta);
	}

/*
	@Override
	public Receta findReceta(Long id) {
		Receta rece = recetaRepo.findById(id).orElse(null);
		return rece;
	}
*/

	@Override
	public RecetaModel findById(Integer id) {
		Receta receta = recetaRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Receta no encontrada"));
		return modelMapper.map(receta, RecetaModel.class);
	}

	public void editReceta(Integer idOriginal, String nuevoNombre, String nuevaDescripcion, List<ItemReceta> nuevoItemReceta, List<Preparacion> nuevasPreparaciones) {
		Receta rece = this.findById(idOriginal);
		rece.setNombre(nuevoNombre);
		rece.setDescripcion(nuevaDescripcion);
		rece.setPreparaciones(nuevasPreparaciones);
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
