package tuti.desi.services.ingrediente;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.dao.ICondimentoRepo;
import tuti.desi.dao.IIngredienteRepo;

import tuti.desi.dao.IProductoRepo;
import tuti.desi.entidades.Condimento;
import tuti.desi.entidades.Ingrediente;
import tuti.desi.entidades.Producto;
import tuti.desi.presentacion.models.CondimentoModel;
import tuti.desi.presentacion.models.EntregaAsistenciaModel;
import tuti.desi.presentacion.models.IngredienteModel;
import tuti.desi.presentacion.models.ProductoModel;


@Service
public class IngredienteService implements IIngredienteService{

	@Autowired
	private IIngredienteRepo ingredienteRepo;
	@Autowired
	private IProductoRepo productoRepo;
	@Autowired
	private ICondimentoRepo condimentoRepository;
    @Autowired
    private ModelMapper modelMapper;


	@Override
	public List<ProductoModel> getAllProductos() {
		List<Producto> listaProductos = productoRepo.findAll();

		List<ProductoModel> listadoDeProductosModel = listaProductos.stream()
				.map(producto -> modelMapper.map(producto, ProductoModel.class))
				.collect(Collectors.toList());
		return listadoDeProductosModel;
	}
	@Override
	public List<CondimentoModel> getAllCondimentos() {
		List<Condimento> listaCondimentos = condimentoRepository.findAll();

		List<CondimentoModel> listadoDeCondimentosModel = listaCondimentos.stream()
				.map(condimento -> modelMapper.map(condimento, CondimentoModel.class))
				.collect(Collectors.toList());
		return listadoDeCondimentosModel;
	}

	@Override
	public ProductoModel saveProducto(ProductoModel productoModel) {
		List<Producto> productosExistentes = productoRepo.findByNombre(productoModel.getNombre());
		if (productosExistentes == null && productosExistentes.isEmpty()) {
			try {
				Producto nuevoProducto = modelMapper.map(productoModel, Producto.class);
				productoRepo.save(nuevoProducto);
				productoModel.setId(nuevoProducto.getId());
				return productoModel;
			} catch (Exception e) {
				System.out.println("No se ha podido crear el producto: " + e.getMessage());
				return null;
			}
		} else {
			System.out.println("El producto con nombre " + productoModel.getId() + " ya existe.");
			return null;
		}
	}

	@Override
	public CondimentoModel saveCondimento(CondimentoModel condimentoModel) {
		List<Condimento> condimentosExistentes = condimentoRepository.findByNombre(condimentoModel.getNombre());
		if (condimentosExistentes == null && condimentosExistentes.isEmpty()) {
			try {
				Condimento nuevoCondimento = modelMapper.map(condimentoModel, Condimento.class);
				condimentoRepository.save(nuevoCondimento);
				condimentoModel.setId(nuevoCondimento.getId());
				return condimentoModel;
			} catch (Exception e) {
				System.out.println("No se ha podido crear el condimento: " + e.getMessage());
				return null;
			}
		} else {
			System.out.println("El producto con nombre " + condimentoModel.getId() + " ya existe.");
			return null;
		}
	}

	@Override
	public void deleteIngrediente(Long id) {
		Producto productoExistente = productoRepo.findById(id).orElse(null);
		if (productoExistente != null) {
			try{
				productoRepo.deleteById(id);
			} catch (Exception e) {
				System.out.println("No se ha podido eliminar el producto: " + e.getMessage());
			}
		} else {
			System.out.println("El producto que desea eliminar, no existe");
		}
		ingredienteRepo.deleteById(id);
		
	}

	@Override
	public Ingrediente findIngrediente(Long id) {
		Ingrediente ingre = ingredienteRepo.findById(id).orElse(null);
		return ingre;
	}

	@Override
	public void editProducto(Long id, ProductoModel productoModel) {
		Producto productoExistente = productoRepo.findById(productoModel.getId()).orElse(null);
		if (productoExistente != null) {
			try {
				modelMapper.map(productoModel, productoExistente);
				productoRepo.save(productoExistente);
			} catch (Exception e) {
				System.out.println("No se ha podido editar el producto: " + e.getMessage());
			}
		} else {
			System.out.println("El producto que desea editar, no existe");
		}

		
	}
	@Override
	public void editCondimento(Long id, CondimentoModel condimentoModel) {
		Condimento condimentoExistente = condimentoRepository.findById(condimentoModel.getId()).orElse(null);
		if (condimentoExistente != null) {
			try {
				modelMapper.map(condimentoModel, condimentoExistente);
				condimentoRepository.save(condimentoExistente);
			} catch (Exception e) {
				System.out.println("No se ha podido editar el producto: " + e.getMessage());
			}
		} else {
			System.out.println("El producto que desea editar, no existe");
		}


	}

}
