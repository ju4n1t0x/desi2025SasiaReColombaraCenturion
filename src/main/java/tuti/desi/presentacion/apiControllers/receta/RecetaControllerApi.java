package tuti.desi.presentacion.apiControllers.receta;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import tuti.desi.presentacion.dto.RecetaDto;
import tuti.desi.presentacion.dto.RecetaRequestDto;
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

    @Autowired
    private ModelMapper modelMapper;

    // GET ALL
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RecetaDto>> getAll() {
        List<RecetaDto> dto = recetaService.findAll()
                .stream()
                .map(receta -> modelMapper.map(receta, RecetaModel.class))
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
    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecetaDto> create(@RequestBody RecetaRequestDto body) {
        RecetaModel model = new RecetaModel();
        model.setNombre(body.nombre());
        model.setPesoRacion(body.pesoRacion());
        model.setCaloriasRacion(body.caloriasRacion());

        RecetaModel creada = recetaService.create(model);

        RecetaDto dto = toDto(creada);

        URI location = URI.create("/recetas/" + creada.getId());
        return ResponseEntity.created(location).body(dto); // 201 + Location
    }

    // PUT
    @PutMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecetaDto> update(@PathVariable Integer id,
                                            @RequestBody RecetaRequestDto body) {
        RecetaModel model = new RecetaModel();
        model.setNombre(body.nombre());
        model.setPesoRacion(body.pesoRacion());
        model.setCaloriasRacion(body.caloriasRacion());
        RecetaModel actualizada = recetaService.update(id, model);

        RecetaDto dto = toDto(actualizada);

        return ResponseEntity.ok(dto);
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
        String urlPreparaciones = "/preparacion/recetaId?recetaId=" + m.getId();
        return new RecetaDto(
                m.getId(),
                m.getNombre(),
                m.getPesoRacion(),
                m.getCaloriasRacion(),
                urlPreparaciones
        );
    }

}

