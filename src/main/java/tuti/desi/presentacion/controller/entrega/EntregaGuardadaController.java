package tuti.desi.presentacion.controller.entrega;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EntregaGuardadaController {
    @GetMapping("/entrega/entregaGuardada")
    public String mostrarEntregaGuardadaString() {
        return "entrega/entregaGuardada";
    }
}
