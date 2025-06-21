package tuti.desi.entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Voluntario extends Persona{

	private long nroSeguimiento;
	
	@OneToMany(mappedBy="voluntario")
	private List<EntregaAsistencia> entregaAsistnecia;

	public long getNroSeguimiento() {
		return nroSeguimiento;
	}

	public void setNroSeguimiento(long nroSeguimiento) {
		this.nroSeguimiento = nroSeguimiento;
	}

	public List<EntregaAsistencia> getEntregaAsistnecia() {
		return entregaAsistnecia;
	}

	public void setEntregaAsistnecia(List<EntregaAsistencia> entregaAsistnecia) {
		this.entregaAsistnecia = entregaAsistnecia;
	}
	
	
}
