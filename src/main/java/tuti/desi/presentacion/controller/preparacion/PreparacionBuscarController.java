package tuti.desi.presentacion.controller.preparacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tuti.desi.entidades.Preparacion;
import tuti.desi.presentacion.models.PreparacionModel;
import tuti.desi.services.preparacion.PreparacionService;

@Controller
@RequestMapping("/preparaciones")
public class PreparacionBuscarController {

    @Autowired
    private PreparacionService preparacionService;

    @GetMapping("/buscarPreparacion")
    public String buscarPreparacion (Model model){
    model.addAttribute("preparacion", preparacionService.getAll());
        return "preparaciones/buscarPreparacion";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPreparacion(@PathVariable Long id, Model model) {
        PreparacionModel p = preparacionService.findPreparacion(id);
        p.setActivo(false);
        preparacionService.save(p);
        model.addAttribute("mensaje", "Preparacion eliminada con exito .");
        model.addAttribute("tipoMensaje", "success");
        return "redirect:/preparaciones/buscarPreparacion";
    }

}
