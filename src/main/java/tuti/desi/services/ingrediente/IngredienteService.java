package tuti.desi.services.ingrediente;

import java.util.List;
import java.util.Optional;
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
import tuti.desi.presentacion.models.ProductoModel;
import tuti.desi.excepciones.CondimentoInvalidoException;
import tuti.desi.excepciones.ProductoInvalidoException;
import tuti.desi.excepciones.IngredienteNoEncontradoException;


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


    // ====================================================================
    // MÉTODOS DE LECTURA (GET ALL)
    // ====================================================================

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

    // ====================================================================
    // MÉTODOS DE BÚSQUEDA POR ID
    // ====================================================================

    @Override
    public Ingrediente findIngrediente(Long id) {
        Ingrediente ingre = ingredienteRepo.findById(id).orElse(null);
        return ingre;
    }

    @Override
    public Optional<Condimento> findCondimentoById(Long id) {
        return condimentoRepository.findById(id);
    }

    @Override
    public Optional<Producto> findProductoById(Long id) {
        return productoRepo.findById(id);
    }

    // ====================================================================
    // MÉTODOS DE ESCRITURA (SAVE/CREATE/UPDATE)
    // ====================================================================

    @Override
    public ProductoModel saveProducto(ProductoModel productoModel) {

        Long id = productoModel.getId();

        if (id == null || id <= 0L) {
            // Es una creación, verificamos unicidad del nombre
            if (!productoRepo.findByNombre(productoModel.getNombre()).isEmpty()) {
                // Lanzamos la excepción ProductoInvalidoException
                throw new ProductoInvalidoException("El producto con nombre " + productoModel.getNombre() + " ya existe.");
            }
        }

        try {
            Producto producto = modelMapper.map(productoModel, Producto.class);
            Producto savedProducto = productoRepo.save(producto);
            productoModel.setId(savedProducto.getId());
            return productoModel;
        } catch (Exception e) {
            // En caso de error de persistencia, se lanza una RuntimeException
            throw new RuntimeException("Error al guardar/actualizar el producto.", e);
        }
    }

    @Override
    public CondimentoModel saveCondimento(CondimentoModel condimentoModel) {

        Long id = condimentoModel.getId();

        if (id == null || id <= 0L) {
            // Es una creación, verificamos unicidad del nombre
            if (!condimentoRepository.findByNombre(condimentoModel.getNombre()).isEmpty()) {
                // Lanzar CondimentoInvalidoException
                throw new CondimentoInvalidoException("El condimento con nombre " + condimentoModel.getNombre() + " ya existe.");
            }
        }

        try {
            Condimento condimento = modelMapper.map(condimentoModel, Condimento.class);
            Condimento savedCondimento = condimentoRepository.save(condimento);
            condimentoModel.setId(savedCondimento.getId());
            return condimentoModel;
        } catch (Exception e) {
            // En caso de error de persistencia, se lanza una RuntimeException
            throw new RuntimeException("Error al guardar/actualizar el condimento.", e);
        }
    }

    @Override
    public void editProducto(Long id, ProductoModel productoModel) {
        Producto productoExistente = productoRepo.findById(id).orElse(null);
        if (productoExistente != null) {
            try {
                productoModel.setId(id);
                modelMapper.map(productoModel, productoExistente);
                productoRepo.save(productoExistente);
            } catch (Exception e) {
                throw new RuntimeException("No se ha podido editar el producto.", e);
            }
        } else {
            throw new IngredienteNoEncontradoException("El producto que desea editar con ID " + id + ", no existe.");
        }
    }

    @Override
    public void editCondimento(Long id, CondimentoModel condimentoModel) {
        Condimento condimentoExistente = condimentoRepository.findById(id).orElse(null);
        if (condimentoExistente != null) {
            try {
                condimentoModel.setId(id);
                modelMapper.map(condimentoModel, condimentoExistente);
                condimentoRepository.save(condimentoExistente);
            } catch (Exception e) {
                throw new RuntimeException("No se ha podido editar el condimento.", e);
            }
        } else {
            throw new IngredienteNoEncontradoException("El condimento que desea editar con ID " + id + ", no existe.");
        }
    }

    // ====================================================================
    // MÉTODOS DE ELIMINACIÓN
    // ====================================================================

    @Override
    public void deleteIngrediente(Long id) {
        if (productoRepo.existsById(id)) {
            try{
                productoRepo.deleteById(id);
                System.out.println("Producto con ID " + id + " eliminado.");
                return;
            } catch (Exception e) {
                System.out.println("No se ha podido eliminar el producto: " + e.getMessage());
                return;
            }
        }

        if (condimentoRepository.existsById(id)) {
            try {
                condimentoRepository.deleteById(id);
                System.out.println("Condimento con ID " + id + " eliminado.");
                return;
            } catch (Exception e) {
                System.out.println("No se ha podido eliminar el condimento: " + e.getMessage());
                return;
            }
        }

        System.out.println("El ingrediente con ID " + id + " no existe como Producto ni como Condimento.");
    }
}