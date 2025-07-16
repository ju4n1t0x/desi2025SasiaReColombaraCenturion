package tuti.desi.presentacion.models;

import java.sql.Date;

import jakarta.validation.constraints.*;

public class PreparacionModel {

	private Long id;

	@NotNull(message = "La cantidad de raciones es obligatoria")
	@Min(value = 1, message = "Debe preparar al menos 1 ración")
	@Max(value = 999, message = "No puede preparar más de 999 raciones")
	private Integer totalRacionesPreparadas;

	private Integer stockRacionesRestantes;

	@NotNull(message = "La fecha es obligatoria")
	@PastOrPresent(message = "La fecha no puede ser futura")
	private Date fechaCoccion;

	@NotNull(message = "La receta es obligatoria")
	@Min(value = 1, message = "Debe seleccionar una receta válida")
	private Long recetaId;

	private RecetaModel receta;

	private Boolean activo = true;


	public PreparacionModel() {
	}

	public PreparacionModel(Integer totalRacionesPreparadas, Date fechaCoccion,
			Long recetaId, RecetaModel receta) {
		this.totalRacionesPreparadas = totalRacionesPreparadas;
		this.stockRacionesRestantes = totalRacionesPreparadas;
		this.fechaCoccion = fechaCoccion;
		this.recetaId = recetaId;
		this.receta = receta;
		this.activo = true;
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

	public Long getRecetaId() {
		return recetaId;
	}

	public void setRecetaId(Long recetaId) {
		this.recetaId = recetaId;
	}

	public RecetaModel getReceta() {
		return receta;
	}

	public void setReceta(RecetaModel receta) {
		this.receta = receta;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActivo() { return activo; }
	public void setActivo(Boolean activo) { this.activo = activo; }

	@Override
	public String toString() {
		return "PreparacionModel{" +
				"id=" + id +
				", totalRacionesPreparadas=" + totalRacionesPreparadas +
				", stockRacionesRestantes=" + stockRacionesRestantes +
				", fechaCoccion=" + fechaCoccion +
				", recetaId=" + recetaId +
				'}';
	}
}
