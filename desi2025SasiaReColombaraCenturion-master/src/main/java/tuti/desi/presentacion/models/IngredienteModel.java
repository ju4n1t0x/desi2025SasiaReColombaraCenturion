package tuti.desi.presentacion.models;

import java.util.List;

import tuti.desi.entidades.ItemReceta;

public class IngredienteModel {

	private long id;
	
	private String nombre;
	
	private Integer calorias;
	
	private List<ItemRecetaModel> itemReceta;

	public IngredienteModel() {
		super();
	}

	public IngredienteModel(long id, String nombre, Integer calorias, List<ItemRecetaModel> itemReceta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.calorias = calorias;
		this.itemReceta = itemReceta;
	}

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

	public List<ItemRecetaModel> getItemReceta() {
		return itemReceta;
	}

	public void setItemReceta(List<ItemRecetaModel> itemReceta) {
		this.itemReceta = itemReceta;
	}
	
	
}
