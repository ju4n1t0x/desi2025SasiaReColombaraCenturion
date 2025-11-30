package tuti.desi.presentacion.apiControllers.asistido;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asistido")
@Tag(name= "Asistidos", description = "S01 - Personas asitidas por el centro")
public class AsistidoControllerApi {

    @GetMapping("/listado")
    public String listarAsistidos(){
        return "Listado de asistidos";
    }
}
