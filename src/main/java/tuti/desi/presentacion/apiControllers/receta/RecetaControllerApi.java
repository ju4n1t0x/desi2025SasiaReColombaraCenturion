package tuti.desi.presentacion.apiControllers.receta;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import tuti.desi.presentacion.dto.RecetaDto;
import tuti.desi.presentacion.models.RecetaModel;
import tuti.desi.services.receta.IRecetaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/recetas")
@Tag(name = "Recetas", description = "Servicio S04 - Recetas")
public class RecetaControllerApi {
    @Autowired
    private IRecetaService recetaService;

    // GET ALL
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RecetaDto>> getAll() {
        List<RecetaDto> dto = recetaService.findAll()
                .stream()
                .map(this::toDto)
                .toList();
        return ResponseEntity.ok(dto);
    }

    // GET by id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecetaDto> getById(@PathVariable Integer id) {
        RecetaModel model = recetaService.findById(id);
        return ResponseEntity.ok(toDto(model));
    }

    // POST
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecetaDto> create(@RequestBody RecetaModel body) {
        RecetaModel creada = recetaService.create(body);
        RecetaDto dto = toDto(creada);

        URI location = URI.create("/recetas/" + dto.id());
        return ResponseEntity.created(location).body(dto); // 201 + Location
    }

    // PUT
    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecetaDto> update(@PathVariable Integer id,
                                            @RequestBody RecetaModel body) {
        RecetaModel actualizada = recetaService.update(id, body);
        return ResponseEntity.ok(toDto(actualizada));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        recetaService.delete(id);
        return ResponseEntity.noContent().build(); // 204
    }

    // ------------ helpers ------------

    private RecetaDto toDto(RecetaModel m) {
        // link HATEOAS a las preparaciones de esta receta
        String urlPreparaciones = "/preparacion?recetaId=" + m.getId();
        return new RecetaDto(
                m.getId(),
                m.getNombre(),
                m.getPesoRacion(),
                m.getCaloriasRacion(),
                urlPreparaciones
        );
    }
}

