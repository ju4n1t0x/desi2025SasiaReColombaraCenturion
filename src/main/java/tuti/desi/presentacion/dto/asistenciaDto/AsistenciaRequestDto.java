package tuti.desi.presentacion.dto.asistenciaDto;

import java.util.Date;

public record AsistenciaRequestDto(
        Integer idPersona,
        Integer idRacion,
        Date fechaEntrega
) {
}
