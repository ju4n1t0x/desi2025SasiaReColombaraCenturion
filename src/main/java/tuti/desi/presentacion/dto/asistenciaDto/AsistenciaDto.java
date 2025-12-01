package tuti.desi.presentacion.dto.asistenciaDto;

import java.util.Date;

public record AsistenciaDto(
        Integer id,
        Integer idPersona,
        Integer idRacion,
        Date fechaEntrega,
        String urlPreparacion,
        String urlAsistido
) {
}
