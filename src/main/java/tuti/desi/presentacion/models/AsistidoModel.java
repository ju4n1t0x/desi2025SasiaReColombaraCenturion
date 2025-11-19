package tuti.desi.presentacion.models;


import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class AsistidoModel extends PersonaModel {

    @NotNull
    private LocalDate fechaRegistro;


    @NotNull
    private Integer familiaNroFamilia;



    public AsistidoModel() {
        super();
    }
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getFamiliaNroFamilia() {
        return familiaNroFamilia;
    }

    public void setFamiliaNroFamilia(Integer familiaNroFamilia) {
        this.familiaNroFamilia = familiaNroFamilia;
    }


}
