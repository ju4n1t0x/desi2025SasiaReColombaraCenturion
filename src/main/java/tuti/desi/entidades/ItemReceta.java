package tuti.desi.entidades;

import jakarta.persistence.*;

@Entity
public class ItemReceta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Integer cantidad; // cantidad en gramos

	private Integer calorias; // calorías calculadas para esta cantidad

	// Relación Many-to-One con Receta
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receta_id", nullable = false)
	private Receta receta;

	// Relación Many-to-One con Ingrediente
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ingrediente_id", nullable = false)
	private Ingrediente ingrediente;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getCalorias() {
		return calorias;
	}

	public void setCalorias(Integer calorias) {
		this.calorias = calorias;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	
	
}
