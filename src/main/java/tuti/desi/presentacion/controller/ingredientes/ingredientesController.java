package tuti.desi.presentacion.controller.ingredientes;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import tuti.desi.presentacion.models.CondimentoModel;

import tuti.desi.presentacion.models.ProductoModel;

import tuti.desi.services.ingrediente.IIngredienteService;


@Controller
@RequestMapping("/ingredientes")
public class ingredientesController {

    @Autowired
    private IIngredienteService ingredienteService;

    @GetMapping("/altaProducto")
    public String mostrarAltaProducto(@ModelAttribute("producto") ProductoModel productoModel){
        return "ingredientes/altaProducto";
    }

    @GetMapping("/altaCondimento")
    public String mostrarAltaCondimento(@ModelAttribute("condimento") CondimentoModel condimentoModel){
        return "ingredientes/altaCondimento";
    }

    @PostMapping("/productos")
    public String guardarProducto(@Valid @ModelAttribute("producto")ProductoModel productoModel){
        ingredienteService.saveProducto(productoModel);
       return "ingredientes/altaProducto";

    }

    @PostMapping("/condimentos")
    public String guardarCondimento(@Valid @ModelAttribute("condimento")CondimentoModel condimentoModel){
        ingredienteService.saveCondimento(condimentoModel);
        return "ingredientes/altaCondimento";

    }

    @GetMapping("listado")
    public String stockDisponible(){
        ingredienteService.getAllProductos();
        ingredienteService.getAllCondimentos();
        return "ingredientes/stockDisponible";
    }

    @PostMapping("/productos/editar/{id}")
    public String editarProducto(@RequestParam Long id, ProductoModel productoModel){
        ingredienteService.editProducto(id, productoModel);
        return "ingredientes/producto";
    }
    @PostMapping("/condimentos/editar/{id}")
    public String editarCondimento(@RequestParam Long id, CondimentoModel condimentoModel){
        ingredienteService.editCondimento(id, condimentoModel);
        return "ingredientes/condimento";
    }
}
