package tuti.desi.entidades;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Preparacion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private Integer totalRacionesPreparadas;
	private Integer stockRacionesRestantes;
	 @Column(name = "fecha_coccion") 
	private Date fechaCoccion;
	
	@ManyToOne
	private Receta receta;
	
	@OneToMany(mappedBy = "preparacion")
	private List<EntregaAsistencia> entregaAsistencia;

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

	public List<EntregaAsistencia> getEntregaAsistencia() {
		return entregaAsistencia;
	}

	public void setEntregaAsistencia(List<EntregaAsistencia> entregaAsistencia) {
		this.entregaAsistencia = entregaAsistencia;
	}
	
	
}
