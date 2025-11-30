package tuti.desi.presentacion.dto;

import java.time.LocalDate;

public record AsistidoResponseDto(Integer dni,
                                  String nombre,
                                  String domicilio,
                                  LocalDate fechaNacimiento,
                                  Integer edad,
                                  String id) { }
