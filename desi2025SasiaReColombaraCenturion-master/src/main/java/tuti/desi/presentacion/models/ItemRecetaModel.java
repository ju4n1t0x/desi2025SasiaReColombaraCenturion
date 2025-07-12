package tuti.desi.presentacion.models;

import tuti.desi.entidades.Ingrediente;
import tuti.desi.entidades.Receta;

public class ItemRecetaModel {
	
	private long id;
	
	private Integer cantidad;
	
	private Integer calorias;
	
	private Receta receta;
	
	private IngredienteModel ingrediente;

	public ItemRecetaModel() {
		super();
	}

	public ItemRecetaModel(long id, Integer cantidad, Integer calorias, Receta receta, IngredienteModel ingrediente) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.calorias = calorias;
		this.receta = receta;
		this.ingrediente = ingrediente;
	}

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

	public IngredienteModel getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(IngredienteModel ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	

}
