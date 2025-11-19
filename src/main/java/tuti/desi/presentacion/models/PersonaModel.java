package tuti.desi.presentacion.models;

import java.sql.Date;
import java.time.LocalDate;

public class PersonaModel {

	private Integer id;

	private Integer dni;
	private String domicilio;
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String ocupacion;

	public PersonaModel() {
		super();
	}

	public PersonaModel(Integer id, Integer dni, String domicilio, String nombre, String apellido, LocalDate fechaNacimiento,
			String ocupacion) {
		super();
		this.id = id;
		this.dni = dni;
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.ocupacion = ocupacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

}
