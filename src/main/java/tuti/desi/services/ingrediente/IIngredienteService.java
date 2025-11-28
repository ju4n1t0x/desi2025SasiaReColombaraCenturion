package tuti.desi.services.ingrediente;

import java.util.List;
import java.util.Optional;

import tuti.desi.entidades.Condimento;
import tuti.desi.entidades.Ingrediente;
import tuti.desi.entidades.Producto;
import tuti.desi.presentacion.models.CondimentoModel;
import tuti.desi.presentacion.models.ProductoModel;

public interface IIngredienteService {

    // LECTURA
    List<ProductoModel> getAllProductos();
    List<CondimentoModel> getAllCondimentos();

    // BÚSQUEDA POR ID
    Ingrediente findIngrediente(Long id);
    Optional<Condimento> findCondimentoById(Long id);
    Optional<Producto> findProductoById(Long id);

    // ESCRITURA (CREATE/UPDATE)
    // No declaramos throws aquí porque usamos excepciones Unchecked (RuntimeException)
    ProductoModel saveProducto(ProductoModel productoModel);
    CondimentoModel saveCondimento(CondimentoModel condimentoModel);

    void editProducto(Long id, ProductoModel productoModel);
    void editCondimento(Long id, CondimentoModel condimentoModel);

    // ELIMINACIÓN
    void deleteIngrediente(Long id);
}