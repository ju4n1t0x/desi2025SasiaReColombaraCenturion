package tuti.desi.entidades;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
public class Preparacion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "total_raciones_preparadas", nullable = false)
	private Integer totalRacionesPreparadas;

	@Column(name = "stock_raciones_preparadas")
	private Integer stockRacionesRestantes;

	@Column(name = "fecha_coccion")
	private Date fechaCoccion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receta_id", nullable = false)
	private Receta receta;

	@Column(name = "activo")
	private Boolean activo = true;
	
	@OneToMany(mappedBy = "preparacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EntregaAsistencia> entregaAsistencia;

	public Preparacion() {}

	public Preparacion(Integer totalRacionesPreparadas, Date fechaCoccion, Receta receta) {
		this.totalRacionesPreparadas = totalRacionesPreparadas;
		this.stockRacionesRestantes = totalRacionesPreparadas; // Lógica inicial
		this.fechaCoccion = fechaCoccion;
		this.receta = receta;
		this.activo = true; // Valor por defecto
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTotalRacionesPreparadas() {
		return totalRacionesPreparadas;
	}
	public void setTotalRacionesPreparadas(Integer totalRacionesPreparadas) {
		this.totalRacionesPreparadas = totalRacionesPreparadas;
		if (this.stockRacionesRestantes == null) {
			this.stockRacionesRestantes = totalRacionesPreparadas;
		}
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

	public Boolean getActivo() { return activo; }
	public void setActivo(Boolean activo) { this.activo = activo; }

	public List<EntregaAsistencia> getEntregaAsistencia() {
		return entregaAsistencia;
	}
	public void setEntregaAsistencia(List<EntregaAsistencia> entregaAsistencia) {
		this.entregaAsistencia = entregaAsistencia;
	}

	public Integer getRecetaId() {
		return receta != null ? receta.getId() : null;
	}

	public Integer getCaloriasPorPlato() {
		return receta != null ? receta.getCaloriasTotales() : 0;
	}

	public void consumirRaciones(Integer cantidad) {
		if (cantidad <= stockRacionesRestantes) {
			this.stockRacionesRestantes -= cantidad;
		} else {
			throw new IllegalArgumentException("No hay suficientes raciones disponibles");
		}
	}

	public boolean hayStock() {
		return stockRacionesRestantes != null && stockRacionesRestantes > 0;
	}

	@Override
	public String toString() {
		return "Preparacion{" +
				"id=" + id +
				", totalRacionesPreparadas=" + totalRacionesPreparadas +
				", stockRacionesRestantes=" + stockRacionesRestantes +
				", fechaCoccion=" + fechaCoccion +
				", receta=" + receta +
				", activo=" + activo +
				", entregaAsistencia=" + entregaAsistencia +
				'}';
	}
}
