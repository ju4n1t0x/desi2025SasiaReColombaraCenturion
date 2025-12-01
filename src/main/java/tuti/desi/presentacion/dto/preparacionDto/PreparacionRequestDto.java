package tuti.desi.presentacion.dto.preparacionDto;

import java.sql.Date;

public record PreparacionRequestDto(
        Date fechaCoccion,
        Integer totalRacionesPreparadas,
        Integer recetaId,
        Date fechaVencimiento
) {
}
