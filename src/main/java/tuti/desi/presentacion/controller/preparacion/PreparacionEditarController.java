package tuti.desi.presentacion.controller.preparacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tuti.desi.entidades.Preparacion;
import tuti.desi.entidades.Receta;
import tuti.desi.presentacion.models.PreparacionModel;
import tuti.desi.services.preparacion.PreparacionService;
import tuti.desi.services.receta.RecetaService;

@Controller
@RequestMapping("/preparaciones")
public class PreparacionEditarController {

    @Autowired
    private PreparacionService preparacionService;

    @Autowired
    private RecetaService recetaService;

    @GetMapping("/editar/{id}")
    public String modificarPreparacion(@PathVariable Long id, Model model) {
        PreparacionModel p = preparacionService.findPreparacion(id);
        model.addAttribute("preparacion", p);
        Receta receta = recetaService.findById(p.getRecetaId());
        model.addAttribute("receta",receta);
        return "preparaciones/editarPreparacion";
    }

}
