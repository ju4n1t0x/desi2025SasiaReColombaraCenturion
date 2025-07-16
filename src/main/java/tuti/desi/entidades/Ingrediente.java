package tuti.desi.entidades;



import java.util.List;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_ingrediente", discriminatorType = DiscriminatorType.STRING)
public class Ingrediente {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
    private String nombre;
    private Integer calorias;
    // Getters y Setters
    
    @OneToMany(mappedBy = "ingrediente")
    private List<ItemReceta> itemReceta;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCalorias() {
		return calorias;
	}

	public void setCalorias(Integer calorias) {
		this.calorias = calorias;
	}

	public List<ItemReceta> getItemReceta() {
		return itemReceta;
	}

	public void setItemReceta(List<ItemReceta> itemReceta) {
		this.itemReceta = itemReceta;
	}
    
    
}
