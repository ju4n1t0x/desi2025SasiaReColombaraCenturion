package tuti.desi.presentacion.dto;

import java.sql.Date;
import java.time.LocalDate;

public record PreparacionRequestDto(
        Date fechaCoccion,
        Integer totalRacionesPreparadas,
        Integer recetaId,
        Date fechaVencimiento
) {
}
