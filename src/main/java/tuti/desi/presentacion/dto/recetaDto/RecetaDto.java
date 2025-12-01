package tuti.desi.presentacion.dto.recetaDto;

public record RecetaDto (
        Integer id,
        String nombre,
        Double pesoRacion,
        Integer caloriasRacion,
        String urlPreparaciones
){
}
