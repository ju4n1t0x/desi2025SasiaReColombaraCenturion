package tuti.desi.presentacion.controller.ingredientes;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import tuti.desi.entidades.Producto;
import tuti.desi.presentacion.models.CondimentoModel;
import tuti.desi.presentacion.models.ProductoModel;
import tuti.desi.services.ingrediente.IIngredienteService;

import tuti.desi.entidades.Condimento;
import tuti.desi.excepciones.CondimentoInvalidoException;
import tuti.desi.excepciones.ProductoInvalidoException;
import tuti.desi.excepciones.IngredienteNoEncontradoException;

@Controller
@RequestMapping("/ingredientes")
public class ingredientesController {

    @Autowired
    private IIngredienteService ingredienteService;

    // ====================================================================
    // Mapeos de VISTAS (GET)
    // ====================================================================

    @GetMapping("/altaProducto")
    public String mostrarAltaProducto(@ModelAttribute("producto") ProductoModel productoModel){
        return "ingredientes/altaProducto";
    }

    @GetMapping("/altaCondimento")
    public String mostrarAltaCondimento(@ModelAttribute("condimento") CondimentoModel condimentoModel){
        return "ingredientes/altaCondimento";
    }

    @GetMapping("/stockDisponible")
    public String stockDisponible(Model model){
        model.addAttribute("productos", ingredienteService.getAllProductos());
        model.addAttribute("condimentos", ingredienteService.getAllCondimentos());
        return "ingredientes/stockDisponible";
    }

    /**
     * Muestra el formulario de edición de un Producto (maneja la solicitud GET).
     */
    @GetMapping("/productos/editar/{id}")
    public String mostrarEditarProducto(@PathVariable Long id, Model model){
        try {
            Producto producto = ingredienteService.findProductoById(id)
                    .orElseThrow(() -> new IngredienteNoEncontradoException("Producto no encontrado con ID: " + id));

            // Mapear Producto a ProductoModel para el formulario
            ProductoModel productoModel = new ProductoModel();
            productoModel.setId(producto.getId());
            productoModel.setNombre(producto.getNombre());

            // CORRECCIÓN: Usamos getStockDisponible() que existe en la entidad Producto.
            // Asumimos que ProductoModel tiene setStockDisponible().
            productoModel.setStockDisponible(producto.getStockDisponible());

            productoModel.setCalorias(producto.getCalorias());

            model.addAttribute("producto", productoModel);

            // Se asume que usa la misma vista de alta para la edición
            return "ingredientes/altaProducto";

        } catch (IngredienteNoEncontradoException e) {
            return "redirect:/ingredientes/stockDisponible?error=Producto_No_Encontrado";
        } catch (Exception e) {
            // Manejo de otros errores no esperados
            return "redirect:/ingredientes/stockDisponible?error=Error_Carga";
        }
    }


    @GetMapping("/condimentos/editar/{id}")
    public String mostrarEditarCondimento(@PathVariable Long id, Model model){
        try {
            Condimento condimento = ingredienteService.findCondimentoById(id)
                    .orElseThrow(() -> new IngredienteNoEncontradoException("Condimento no encontrado con ID: " + id));

            CondimentoModel condimentoModel = new CondimentoModel();
            condimentoModel.setId(condimento.getId());
            condimentoModel.setNombre(condimento.getNombre());
            condimentoModel.setCalorias(condimento.getCalorias());

            model.addAttribute("condimento", condimentoModel);

            return "ingredientes/altaCondimento";

        } catch (IngredienteNoEncontradoException e) {
            return "redirect:/ingredientes/stockDisponible?error=Condimento_No_Encontrado";
        } catch (Exception e) {
            return "redirect:/ingredientes/stockDisponible?error=Error_Carga";
        }
    }


    // ====================================================================
    // Mapeos de ACCIONES (POST)
    // ====================================================================

    @PostMapping("/altaProducto")
    public String guardarProducto(@Valid @ModelAttribute("producto")ProductoModel productoModel, BindingResult result, Model model){

        if (result.hasErrors()) {
            return "ingredientes/altaProducto";
        }

        try {
            ingredienteService.saveProducto(productoModel);
        } catch (ProductoInvalidoException e) {
            model.addAttribute("errorProducto", e.getMessage());
            return "ingredientes/altaProducto";
        }
        return "redirect:/ingredientes/altaProducto?success";
    }

    @PostMapping("/condimentos")
    public String guardarCondimento(@Valid @ModelAttribute("condimento")CondimentoModel condimentoModel, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "ingredientes/altaCondimento";
        }

        try {
            ingredienteService.saveCondimento(condimentoModel);
        } catch (CondimentoInvalidoException e) {
            model.addAttribute("errorCondimento", e.getMessage());
            return "ingredientes/altaCondimento";
        }

        return "redirect:/ingredientes/altaCondimento?success";
    }

    @PostMapping("/productos/editar/{id}")
    public String editarProducto(@PathVariable Long id, @Valid @ModelAttribute("producto") ProductoModel productoModel){
        // Note: Faltaría el BindingResult aquí si necesitas validación en el POST de edición
        ingredienteService.editProducto(id, productoModel);
        return "redirect:/ingredientes/stockDisponible";
    }

    @PostMapping("/condimentos/editar/{id}")
    public String guardarEdicionCondimento(@PathVariable Long id, @Valid @ModelAttribute("condimento") CondimentoModel condimentoModel, Model model){
        try {
            ingredienteService.editCondimento(id, condimentoModel);
        } catch (CondimentoInvalidoException e) {
            model.addAttribute("errorCondimento", e.getMessage());
            model.addAttribute("condimento", condimentoModel);
            return "ingredientes/altaCondimento";
        } catch (IngredienteNoEncontradoException e) {
            return "redirect:/ingredientes/stockDisponible?error=Condimento_No_Encontrado";
        }

        return "redirect:/ingredientes/stockDisponible";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarIngrediente(@PathVariable Long id) {
        ingredienteService.deleteIngrediente(id);
        return "redirect:/ingredientes/stockDisponible";
    }
}