package tuti.desi.presentacion.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaModel {

	private Integer id;

	private Integer dni;
	private String domicilio;
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String ocupacion;



}
