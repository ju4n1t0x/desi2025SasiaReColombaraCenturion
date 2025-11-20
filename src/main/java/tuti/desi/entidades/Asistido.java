package tuti.desi.entidades;

import java.sql.Date;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn; // ⬅️ Nueva Importación
import jakarta.persistence.ManyToOne;

@Entity
public class Asistido extends Persona {

    private LocalDate fechaRegistro;


    @ManyToOne
    @JoinColumn(name = "familia_nro_familia")
    private Familia familia;


    public Asistido() {
        super();
    }


    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }


}

