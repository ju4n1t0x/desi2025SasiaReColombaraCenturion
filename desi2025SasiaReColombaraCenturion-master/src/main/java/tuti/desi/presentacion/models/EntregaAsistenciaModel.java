package tuti.desi.presentacion.models;


import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import tuti.desi.entidades.Preparacion;

public class EntregaAsistenciaModel {

	private Long id;


	private LocalDate fecha;

	@NotNull(message = "La cantidad de raciones no puede estar vacía.")
	@Min(value = 1, message = "La cantidad de raciones debe ser mayor a 0.")
	private Integer cantidadRaciones;

	@NotNull(message = "Debe seleccionar una preparacion.")
	private Long idPreparacion;

	private PreparacionModel preparacion;

	private VoluntarioModel voluntario;

	@NotNull(message = "Debe seleccionar una familia.")
	private Integer nroFamilia;

	private FamiliaModel familia;


	public EntregaAsistenciaModel() {
		super();
	}

	public EntregaAsistenciaModel(Long id, LocalDate fecha, Integer cantidadRaciones, Long idPreparacion, PreparacionModel preparacion, VoluntarioModel voluntario, Integer nroFamilia, FamiliaModel familia) {
		this.id = id;
		this.fecha = fecha;
		this.cantidadRaciones = cantidadRaciones;
		this.idPreparacion = idPreparacion;
		this.preparacion = preparacion;
		this.voluntario = voluntario;
		this.nroFamilia = nroFamilia;
		this.familia = familia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Integer getCantidadRaciones() {
		return cantidadRaciones;
	}

	public void setCantidadRaciones(Integer cantidadRaciones) {
		this.cantidadRaciones = cantidadRaciones;
	}

	public Long getIdPreparacion() {
		return idPreparacion;
	}

	public void setIdPreparacion(Long idPreparacion) {
		this.idPreparacion = idPreparacion;
	}

	public PreparacionModel getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(PreparacionModel preparacion) {
		this.preparacion = preparacion;
	}

	public VoluntarioModel getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(VoluntarioModel voluntario) {
		this.voluntario = voluntario;
	}

	public Integer getNroFamilia() {
		return nroFamilia;
	}

	public void setNroFamilia(Integer nroFamilia) {
		this.nroFamilia = nroFamilia;
	}

	public FamiliaModel getFamilia() {
		return familia;
	}

	public void setFamilia(FamiliaModel familia) {
		this.familia = familia;
	}
}
