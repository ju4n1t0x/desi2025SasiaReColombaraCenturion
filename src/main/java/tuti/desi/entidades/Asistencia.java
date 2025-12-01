package tuti.desi.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Asistencia {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "asistido_id")
    private Asistido asistido;

    @OneToOne
    @JoinColumn(name = "racion_id")
    private Preparacion racion;


    @Column(name = "fecha_entrega")
    @NotNull
    private Date fechaEntrega;



}
