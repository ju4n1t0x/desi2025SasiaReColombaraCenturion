package tuti.desi.presentacion.models;

import java.sql.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import tuti.desi.dao.IFamiliaRepo;
import tuti.desi.entidades.Familia;
import tuti.desi.entidades.Preparacion;

public class EntregaAsistenciaModel {
	@NotNull
	private long id;

	@NotNull
	private Date fecha;

	@NotNull(message = "La cantidad de raciones no puede estar vacía.")
	@Min(value = 1, message = "La cantidad de raciones debe ser mayor a 0.")
	private Integer cantidadRaciones;

	@NotNull(message = "Debe seleccionar una preparacion.")
	private Preparacion preparacion;

	private VoluntarioModel voluntario;

	@NotNull(message = "Debe seleccionar una familia.")
	private FamiliaModel familia;


	public EntregaAsistenciaModel() {
		super();
	}

	public EntregaAsistenciaModel(long id, Date fecha, Integer cantidadRaciones, Preparacion preparacion, VoluntarioModel voluntario, FamiliaModel familia) {
		this.id = id;
		this.fecha = fecha;
		this.cantidadRaciones = cantidadRaciones;
		this.preparacion = preparacion;
		this.voluntario = voluntario;
		this.familia = familia;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getCantidadRaciones() {
		return cantidadRaciones;
	}

	public void setCantidadRaciones(Integer cantidadRaciones) {
		this.cantidadRaciones = cantidadRaciones;
	}

	public Preparacion getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(Preparacion preparacion) {
		this.preparacion = preparacion;
	}

	public VoluntarioModel getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(VoluntarioModel voluntario) {
		this.voluntario = voluntario;
	}

	public FamiliaModel getFamilia() {
		return familia;
	}

	public void setFamilia(FamiliaModel familia) {
		this.familia = familia;
	}
}
