package tuti.desi.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("producto")
public class Producto extends Ingrediente{

	
	private Double stockDisponible;
	private Double precioActual;
	@OneToMany(mappedBy = "ingrediente")
	private List<ItemReceta> itemReceta;
	

	
	
}