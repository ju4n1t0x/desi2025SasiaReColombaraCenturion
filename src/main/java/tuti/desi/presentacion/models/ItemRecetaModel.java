package tuti.desi.presentacion.models;

import lombok.*;
import tuti.desi.entidades.Ingrediente;
import tuti.desi.entidades.ItemReceta;
import tuti.desi.entidades.Producto;
import tuti.desi.entidades.Receta;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemRecetaModel {
	
	private long id;
	
	private Integer cantidad;
	
	private Integer calorias;
	
	private Receta receta;

	private Ingrediente ingrediente;

	private double subTotal;

	public static ItemRecetaModel toPojo(ItemReceta itemReceta){
		double precio = itemReceta.getIngrediente() instanceof Producto ? ((Producto) itemReceta.getIngrediente()).getPrecioActual() : 0;

		return ItemRecetaModel.builder()
				.id(itemReceta.getId())
				.cantidad(itemReceta.getCantidad())
				.calorias(itemReceta.getCalorias())
				.receta(itemReceta.getReceta())
				.ingrediente(itemReceta.getIngrediente())
				.subTotal(precio * itemReceta.getCantidad())
				.build();
	}

}
