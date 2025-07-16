package tuti.desi.presentacion.controller.preparacion;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tuti.desi.entidades.Preparacion;
import tuti.desi.presentacion.models.PreparacionModel;
import tuti.desi.services.preparacion.PreparacionService;
import tuti.desi.services.receta.RecetaService;

@Controller
@Valid
@RequestMapping("/preparaciones")
public class PreparacionAltaController {

    @Autowired
    private PreparacionService preparacionService;

    @Autowired
    private RecetaService recetaService;

    @GetMapping("/altaPreparacion")
    public String altaPreparacion(Model model) {
        // Crear nuevo model para el formulario
        model.addAttribute("preparacion", new PreparacionModel());

        return "preparaciones/altaPreparacion";
    }
}
