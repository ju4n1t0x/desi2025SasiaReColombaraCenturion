package tuti.desi.presentacion.models;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuti.desi.entidades.Receta;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class RecetaModel extends Receta {

	private Integer id;
	private String nombre;
	private String descripcion;
	private Double pesoRacion;
	private Integer caloriasRacion;

}


