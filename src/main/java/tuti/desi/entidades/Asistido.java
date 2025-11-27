package tuti.desi.entidades;

import java.sql.Date;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Asistido extends Persona {

    private LocalDate fechaRegistro;


    @ManyToOne
    @JoinColumn(name = "familia_nro_familia")
    private Familia familia;




}

