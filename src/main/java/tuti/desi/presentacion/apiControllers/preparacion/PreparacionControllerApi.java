package tuti.desi.presentacion.apiControllers.preparacion;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tuti.desi.presentacion.dto.PreparacionListadoDto;
import tuti.desi.entidades.Preparacion;
import tuti.desi.presentacion.models.PreparacionModel;
import tuti.desi.services.preparacion.IPreparacionService;

import java.util.List;

@RestController
@RequestMapping("/preparacion")
@Tag(name= "Preparaciones", description = "Preparaciones")
public class PreparacionControllerApi {

    @Autowired
    private IPreparacionService preparacionService;

    // Read
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<PreparacionListadoDto> buscarPreparacion() {
        return preparacionService.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    // Mapeo de Model -> DTO
    private PreparacionListadoDto toDto(PreparacionModel p) {
        return new PreparacionListadoDto(
                p.getId(),
                p.getFechaCoccion(),
                p.getTotalRacionesPreparadas(),
                p.getReceta().getNombre()
        );
    }
}
