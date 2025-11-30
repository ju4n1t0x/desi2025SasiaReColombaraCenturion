package tuti.desi.presentacion.controller.receta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tuti.desi.presentacion.models.ItemRecetaModel;
import tuti.desi.presentacion.models.RecetaModel;
import tuti.desi.services.ingrediente.IIngredienteService;
import tuti.desi.services.itemReceta.IItemRecetaService;
import tuti.desi.services.receta.IRecetaService;

import java.util.List;


@Controller
@RequestMapping("/receta")
public class recetaController {

    @Autowired
    private IRecetaService recetaService;

    @Autowired
    private IIngredienteService ingredienteService;

    @Autowired
    private IItemRecetaService itemRecetaService;

    @GetMapping("/altaReceta")
    public String altaReceta(Model model) {
        model.addAttribute("productos", ingredienteService.getAllProductos());
        model.addAttribute("condimentos", ingredienteService.getAllCondimentos());
        return "receta/altaReceta";
    }


    @PostMapping("/guardar")
    public String guardar(
            @RequestParam String nombre,
            @RequestParam String descripcion,
            @RequestParam(required = false) List<Long> productoIds,
            @RequestParam(required = false) List<Double> productoCantidades,
            @RequestParam(required = false) List<Long> condimentoIds,
            RedirectAttributes ra
    ) {


        recetaService.saveReceta(nombre, descripcion, productoIds, productoCantidades, condimentoIds);
        ra.addFlashAttribute("mensajeExito", "Receta guardada con éxito.");
        return "redirect:/receta/listado";
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("recetas", recetaService.getAll());
        return "receta/listado";
    }
}


