package tuti.desi.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PRODUCTO")
public class Producto extends Ingrediente{

	
	private float sockDisponible;
	private float precioActual;
	
	public float getSockDisponible() {
		return sockDisponible;
	}
	public void setSockDisponible(float sockDisponible) {
		this.sockDisponible = sockDisponible;
	}
	public float getPrecioActual() {
		return precioActual;
	}
	public void setPrecioActual(float precioActual) {
		this.precioActual = precioActual;
	}
	
	
	
}