package tuti.desi.presentacion.dto;

import java.sql.Date;

public record PreparacionListadoDto (Long id,
    Date fechaCoccion,
    Integer totalRacionesPreparadas,
    String nombreReceta)
{}
