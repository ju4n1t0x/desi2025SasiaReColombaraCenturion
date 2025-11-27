package tuti.desi.presentacion.models;


import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsistidoModel extends PersonaModel {

    @NotNull
    private LocalDate fechaRegistro;


    @NotNull
    private Integer familiaNroFamilia;





}

