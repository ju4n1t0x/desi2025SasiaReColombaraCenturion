package tuti.desi.presentacion.models;

import java.sql.Date;
import java.util.List;

import tuti.desi.entidades.Receta;

public class RecetaModel {

	private long id;
	private String nombre;
	private String descripcion;

	private List<ItemRecetaModel> itemReceta;

	private List<PreparacionModel> preparaciones;

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

	public List<ItemRecetaModel> getItemReceta() {
		return itemReceta;
	}
}


