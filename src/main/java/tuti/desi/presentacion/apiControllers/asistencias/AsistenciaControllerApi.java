package tuti.desi.presentacion.apiControllers.asistencias;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tuti.desi.presentacion.dto.asistenciaDto.AsistenciaDto;
import tuti.desi.presentacion.dto.asistenciaDto.AsistenciaRequestDto;
import tuti.desi.presentacion.dto.preparacionDto.PreparacionListadoDto;
import tuti.desi.presentacion.dto.recetaDto.RecetaDto;
import tuti.desi.presentacion.models.AsistenciaModel;
import tuti.desi.presentacion.models.PreparacionModel;
import tuti.desi.presentacion.models.RecetaModel;
import tuti.desi.services.asistencia.AsistenciaService;
import tuti.desi.services.asistencia.IAsistenciaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/asistencias")
@Tag(name= "Asistencias", description = "S03 - Asistencias")
public class AsistenciaControllerApi {

    @Autowired
    private IAsistenciaService asistenciaService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("listar")
    @ResponseBody
    public ResponseEntity<List<AsistenciaDto>> listarAsistencias() {
        List<AsistenciaDto> dto = asistenciaService.obtenerAsistencias()
                .stream()
                .map(this::toDto)
                .toList();
        return ResponseEntity.ok(dto);
    }

    @PostMapping("crear")
    public ResponseEntity<AsistenciaDto> crearAsistencia(@RequestBody  AsistenciaRequestDto asistenciaRequestDto) {
        AsistenciaModel model = new AsistenciaModel();
        model.setFechaEntrega(asistenciaRequestDto.fechaEntrega());
        model.setAsistidoId(asistenciaRequestDto.idPersona());
        model.setRacionId(asistenciaRequestDto.idRacion());
        AsistenciaModel creada = asistenciaService.crearAsistencia(model);

        AsistenciaDto dto = toDto(creada);
        URI location = URI.create("/asistencias/" + creada.getId());
        return ResponseEntity.created(location).body(dto);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarAsistencia(@PathVariable Integer id) {
        asistenciaService.eliminarAsistencia(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<AsistenciaDto> actualizarAsistencia(@PathVariable Integer id, @RequestBody AsistenciaRequestDto body ) {
        AsistenciaModel creada = asistenciaService.findById(id);
        creada.setAsistidoId(body.idPersona());
        creada.setRacionId(body.idRacion());
        creada.setFechaEntrega(body.fechaEntrega());
        AsistenciaModel actualizada = asistenciaService.actualizarAsistencia(creada);
        AsistenciaDto dto = toDto(actualizada);
        return ResponseEntity.ok(dto);
    }



    // Mapeo de Model -> DTO
    private AsistenciaDto toDto(AsistenciaModel asistenciaModel) {
        String urlPreparacion = "/preparacion/recetaId?id=" + asistenciaModel.getRacionId();
        String urlAsistido = "/asistido/asistidoId?id=" + asistenciaModel.getAsistidoId();
        return new AsistenciaDto(
                asistenciaModel.getId(),
                asistenciaModel.getAsistidoId(),
                asistenciaModel.getRacionId(),
                asistenciaModel.getFechaEntrega(),
                urlPreparacion,
                urlAsistido
        );
    }
}
