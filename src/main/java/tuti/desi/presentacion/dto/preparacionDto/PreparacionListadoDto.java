package tuti.desi.presentacion.dto.preparacionDto;

import java.sql.Date;

public record PreparacionListadoDto(
        Integer id,
        Date fechaCoccion,
        Integer totalRacionesPreparadas,
        Integer stockRacionesRestantes,
        Date fechaVencimiento,
        Integer recetaId,
        String urlRecetas) {

}


