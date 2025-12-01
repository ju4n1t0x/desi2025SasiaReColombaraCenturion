package tuti.desi.presentacion.apiControllers.preparacion;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tuti.desi.presentacion.dto.preparacionDto.PreparacionListadoDto;
import tuti.desi.presentacion.dto.preparacionDto.PreparacionRequestDto;
import tuti.desi.presentacion.models.PreparacionModel;
import tuti.desi.services.preparacion.IPreparacionService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/preparacion")
@Tag(name= "Raciones", description = "S02 - Raciones")
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

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, value = "/recetaId")
    @ResponseBody
    public List<PreparacionListadoDto> findByRecetaId(@RequestParam Integer recetaId) {
        List<PreparacionModel> preapracionesPorRecetaId = preparacionService.findPreparacionesPorRecetaId(recetaId);
        return preapracionesPorRecetaId
                .stream()
                .map(this::toDto)
                .toList();
    }


    // POST
    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PreparacionListadoDto> create(@RequestBody PreparacionRequestDto body) {
        PreparacionModel model = new PreparacionModel();
        model.setFechaCoccion(body.fechaCoccion());
        model.setTotalRacionesPreparadas(body.totalRacionesPreparadas());
        model.setFechaVencimiento(body.fechaVencimiento());
        model.setRecetaId(body.recetaId());
        PreparacionModel creada = preparacionService.save(model);

        PreparacionListadoDto dto = toDto(creada);

        URI location = URI.create("/preparacion/" + creada.getId());
        return ResponseEntity.created(location).body(dto); // 201 + Location
    }


    // PUT
    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PreparacionListadoDto> update(@PathVariable Integer id, @RequestBody PreparacionRequestDto body) {
        PreparacionModel encontrada = preparacionService.findPreparacion(id);
        encontrada.setFechaCoccion(body.fechaCoccion());
        encontrada.setTotalRacionesPreparadas(body.totalRacionesPreparadas());
        encontrada.setFechaVencimiento(body.fechaVencimiento());
        encontrada.setRecetaId(body.recetaId());
        PreparacionModel actualizada = preparacionService.editPreparacion(encontrada);
        PreparacionListadoDto dto = toDto(actualizada);
        return ResponseEntity.ok(dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        preparacionService.deletePreparacionModel(id);
        return ResponseEntity.noContent().build(); // 204
    }


    // Mapeo de Model -> DTO
    private PreparacionListadoDto toDto(PreparacionModel p) {
        String urlRecetas = "/recetas/?id=" + p.getId();
        return new PreparacionListadoDto(
                p.getId(),
                p.getFechaCoccion(),
                p.getTotalRacionesPreparadas(),
                p.getStockRacionesRestantes(),
                p.getFechaVencimiento(),
                p.getReceta().getId(),
                urlRecetas
        );
    }
}
