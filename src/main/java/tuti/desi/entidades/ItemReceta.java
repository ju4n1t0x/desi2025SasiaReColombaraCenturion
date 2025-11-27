package tuti.desi.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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




	
	
}
