package tuti.desi.entidades;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Familia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer nroFamilia;
	
	private String nombre;
	private Date fechaRegistro;
	

	@OneToMany(mappedBy = "familia", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EntregaAsistencia> entregaAsistencia = new ArrayList<>();
	

	@OneToMany(mappedBy = "familia", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Asistido> asistido = new ArrayList<>();

	public Integer getNroFamilia() {
		return nroFamilia;
	}

	public void setNroFamilia(Integer nroFamilia) {
		this.nroFamilia = nroFamilia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	

	public List<EntregaAsistencia> getEntregaAsistencia() {
		return entregaAsistencia;
	}

	public void setEntregaAsistencia(List<EntregaAsistencia> entregaAsistencia) {
		this.entregaAsistencia = entregaAsistencia;
	}

	public List<Asistido> getAsistido() {
		return asistido;
	}

	public void setAsistido(List<Asistido> asistido) {
		this.asistido = asistido;
	}
	
	
}
