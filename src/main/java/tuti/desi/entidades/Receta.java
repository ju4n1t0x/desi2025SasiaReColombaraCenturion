package tuti.desi.entidades;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
public class Receta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//cambie long por int
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "decripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemReceta> itemReceta;
	
	@OneToMany(mappedBy = "receta")
	private List<Preparacion> preparaciones;

	//nuevo
	@Setter
    @Column(name="peso_racion", nullable = false)
	private Double pesoRacion;

	@Column(name="calorias_totales", nullable = false)
	private Integer caloriasTotales;

	public Integer getId() {
		return id;
	}

	public void setId() {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Preparacion> getPreparaciones() {
		return preparaciones;
	}

	public void setPreparaciones(List<Preparacion> preparaciones) {
		this.preparaciones = preparaciones;
	}

	public Integer getCaloriasTotales() {
		// Si no está calculado, calcularlo automáticamente
		if (caloriasTotales == null) {
			calcularCaloriasTotales();
		}
		return caloriasTotales;
	}

	// Metodo para establecer calorías manualmente
	public void setCaloriasTotales(Integer caloriasTotales) {
		this.caloriasTotales = caloriasTotales;
	}

	// Metodo principal para calcular calorías automáticamente
	public void calcularCaloriasTotales() {
		if (itemReceta == null || itemReceta.isEmpty()) {
			this.caloriasTotales = 0;
			return;
		}
		int totalCalorias = 0;
		for (ItemReceta item : itemReceta) {
			if (item.getCalorias() != null) {
				totalCalorias += item.getCalorias();
			}
		}
		this.caloriasTotales = totalCalorias;
	}

	// Metodo para recalcular calorías
	public void recalcularCalorias() {
		calcularCaloriasTotales();
	}

    public void setCaloriasRacion(Integer caloriasRacion) {
		this.caloriasTotales = caloriasRacion;
	}
}
