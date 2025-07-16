package tuti.desi.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;

@Entity
public class Asistido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del asistido no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El apellido del asistido no puede estar vacío")
    private String apellido;

    @NotNull(message = "El DNI del asistido no puede estar vacío")
    @Column(unique = true)
    private Integer dni;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "La ocupación no puede estar vacía")
    private String ocupacion;
    
    
    private String domicilio;
	
    @Column(nullable = false)
    private boolean activo = true;

    @ManyToOne
    @JoinColumn(name = "familia_id", nullable = false)
    @NotNull(message = "El asistido debe pertenecer a una familia")
    private Familia familia;

    public Asistido() {
    }

    
    
    
    public Asistido(Long id, @NotBlank(message = "El nombre del asistido no puede estar vacío") String nombre,
			@NotBlank(message = "El apellido del asistido no puede estar vacío") String apellido,
			@NotNull(message = "El DNI del asistido no puede estar vacío") Integer dni,
			@NotNull(message = "La fecha de nacimiento no puede ser nula") LocalDate fechaNacimiento,
			@NotBlank(message = "La ocupación no puede estar vacía") String ocupacion, String domicilio, boolean activo,
			@NotNull(message = "El asistido debe pertenecer a una familia") Familia familia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.ocupacion = ocupacion;
		this.domicilio = domicilio;
		this.activo = activo;
		this.familia = familia;
	}




	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }
}
