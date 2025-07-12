package tuti.desi.presentacion.models;

import java.sql.Date;
import java.util.List;

import tuti.desi.entidades.EntregaAsistencia;
import tuti.desi.entidades.Receta;

public class PreparacionModel {

	private long id;
	private Integer totalRacionesPreparadas;
	private Integer stockRacionesRestantes;
	private Date fechaCoccion;
	
	private Receta receta;
	
	private List<EntregaAsistenciaModel> entregaAsistencia;

	public PreparacionModel() {
		super();
	}

	public PreparacionModel(long id, Integer totalRacionesPreparadas, Integer stockRacionesRestantes, Date fechaCoccion,
			Receta receta, List<EntregaAsistenciaModel> entregaAsistencia) {
		super();
		this.id = id;
		this.totalRacionesPreparadas = totalRacionesPreparadas;
		this.stockRacionesRestantes = stockRacionesRestantes;
		this.fechaCoccion = fechaCoccion;
		this.receta = receta;
		this.entregaAsistencia = entregaAsistencia;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getTotalRacionesPreparadas() {
		return totalRacionesPreparadas;
	}

	public void setTotalRacionesPreparadas(Integer totalRacionesPreparadas) {
		this.totalRacionesPreparadas = totalRacionesPreparadas;
	}

	public Integer getStockRacionesRestantes() {
		return stockRacionesRestantes;
	}

	public void setStockRacionesRestantes(Integer stockRacionesRestantes) {
		this.stockRacionesRestantes = stockRacionesRestantes;
	}

	public Date getFechaCoccion() {
		return fechaCoccion;
	}

	public void setFechaCoccion(Date fechaCoccion) {
		this.fechaCoccion = fechaCoccion;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public List<EntregaAsistenciaModel> getEntregaAsistencia() {
		return entregaAsistencia;
	}

	public void setEntregaAsistencia(List<EntregaAsistenciaModel> entregaAsistencia) {
		this.entregaAsistencia = entregaAsistencia;
	}
	
	
}
