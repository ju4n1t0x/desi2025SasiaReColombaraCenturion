package tuti.desi.presentacion.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuti.desi.entidades.ItemReceta;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredienteModel {

	private long id;
	
	private String nombre;
	
	private Integer calorias;
	
	private List<ItemRecetaModel> itemReceta;


	
	
}
