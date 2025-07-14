package tuti.desi.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Receta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	private String descripcion;
	
	@OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemReceta> itemReceta;
	
	@OneToMany(mappedBy = "receta")
	private List<Preparacion> preparaciones;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ItemReceta> getItemReceta() {
		return itemReceta;
	}

	public void setItemReceta(List<ItemReceta> itemReceta) {
		this.itemReceta = itemReceta;
	}

	public List<Preparacion> getPreparaciones() {
		return preparaciones;
	}

	public void setPreparaciones(List<Preparacion> preparaciones) {
		this.preparaciones = preparaciones;
	}
	
	
}
