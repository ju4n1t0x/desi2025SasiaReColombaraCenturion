package tuti.desi.entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Voluntario extends Persona{

	private long nroSeguro;
	
	@OneToMany(mappedBy="voluntario")
	private List<EntregaAsistencia> entregaAsistnecia;

	public long getNroSeguro() {
		return nroSeguro;
	}

	public void setNroSeguro(long nroSeguro) {
		this.nroSeguro = nroSeguro;
	}

	public List<EntregaAsistencia> getEntregaAsistnecia() {
		return entregaAsistnecia;
	}

	public void setEntregaAsistnecia(List<EntregaAsistencia> entregaAsistnecia) {
		this.entregaAsistnecia = entregaAsistnecia;
	}
	
	
}
