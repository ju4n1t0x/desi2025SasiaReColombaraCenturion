package tuti.desi.presentacion.models;

import java.util.List;

public class ProductoModel extends IngredienteModel {

	private float stockDisponible;
	private float precioActual;

	public ProductoModel() {
		super();
	}

	public ProductoModel(long id, String nombre, Integer calorias, List<ItemRecetaModel> itemReceta,
			float stockDisponible, float precioActual) {
		super(id, nombre, calorias, itemReceta);
		this.stockDisponible = stockDisponible;
		this.precioActual = precioActual;
	}

	public float getStockDisponible() {
		return stockDisponible;
	}

	public void setStockDisponible(float stockDisponible) {
		this.stockDisponible = stockDisponible;
	}

	public float getPrecioActual() {
		return precioActual;
	}

	public void setPrecioActual(float precioActual) {
		this.precioActual = precioActual;
	}

}
