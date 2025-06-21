package tuti.desi.entidades;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Asistido extends Persona {
	
	private Date fechaRegistro;
	
	@ManyToOne
	private Familia familia;

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}
	
	
}
