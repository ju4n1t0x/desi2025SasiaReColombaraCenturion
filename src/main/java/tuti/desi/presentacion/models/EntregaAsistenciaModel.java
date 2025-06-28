package tuti.desi.presentacion.models;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import tuti.desi.dao.IFamiliaRepo;
import tuti.desi.entidades.Preparacion;

public class EntregaAsistenciaModel {
	
	@NotNull
	private Date fecha;
	@NotNull
	private Integer cantidadRaciones;

	@NotNull
	private Integer numeroFamilia;
	
	private String nombreFamilia;
	
	@NotNull
	private Long idEntrega;
	
	private Preparacion preparacion;
	
	private IFamiliaRepo familiaRepo;
	
	public EntregaAsistenciaModel() {
		super();
	}



	public EntregaAsistenciaModel(@NotNull Date fecha, @NotNull Integer cantidadRaciones,
			@NotNull Integer numeroFamilia, @NotNull Long idEntrega, @NotNull Long preparacionId, @NotNull Preparacion preparacion) {
		super();
		this.fecha = fecha;
		this.cantidadRaciones = cantidadRaciones;
		this.numeroFamilia = numeroFamilia;
		this.idEntrega = idEntrega;
		this.preparacion = preparacion;
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



	public Integer getNumeroFamilia() {
		return numeroFamilia;
	}



	public void setNumeroFamilia(Integer numeroFamilia) {
		this.numeroFamilia = numeroFamilia;
	}


	public Long getIdEntrega() {
		return idEntrega;
	}




	public void setIdEntrega(Long idEntrega) {
		this.idEntrega = idEntrega;
	}



	public Preparacion getPreparacion() {
		return preparacion;
	}



	public void setPreparacion(Preparacion preparacion) {
		this.preparacion = preparacion;
	}




	
}
