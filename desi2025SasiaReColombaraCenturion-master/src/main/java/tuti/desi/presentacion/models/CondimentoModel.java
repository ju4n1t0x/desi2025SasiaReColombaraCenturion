package tuti.desi.presentacion.models;

import java.util.List;

import tuti.desi.entidades.ItemReceta;

public class CondimentoModel extends IngredienteModel{

	public CondimentoModel() {
		super();
	}

	public CondimentoModel(long id, String nombre, Integer calorias, List<ItemRecetaModel> itemReceta) {
		super(id, nombre, calorias, itemReceta);
	}

	

	
	
}
