package tuti.desi.presentacion.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuti.desi.entidades.Asistido;
import tuti.desi.entidades.Preparacion;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsistenciaModel {

    private Integer id;


    private Integer asistidoId;


    private Integer racionId;



    private Date fechaEntrega;
}
