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
	
}
