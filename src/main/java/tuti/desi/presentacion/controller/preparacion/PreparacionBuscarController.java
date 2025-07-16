package tuti.desi.presentacion.controller.preparacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tuti.desi.services.preparacion.PreparacionService;

@Controller
//@RequestMapping("/preparacion")
public class PreparacionBuscarController {

    @Autowired
    private PreparacionService preparacionService;

    @GetMapping("/preparaciones/buscarPreparacion")
    public String buscarPreparacion (Model model){
    model.addAttribute("preparacion", preparacionService.getAll());
        return "preparaciones/buscarPreparacion";
    }

}
