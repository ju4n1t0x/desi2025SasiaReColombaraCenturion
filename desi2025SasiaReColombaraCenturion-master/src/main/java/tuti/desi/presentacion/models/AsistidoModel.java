package tuti.desi.presentacion.models;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;

public class AsistidoModel extends PersonaModel {
	@NotNull
	private Date fechaRegistro;
	@NotNull
	private FamiliaModel familia;

	public AsistidoModel() {
		super();
	}

	public AsistidoModel(@NotNull Date fechaRegistro, @NotNull FamiliaModel familia) {
		super();
		this.fechaRegistro = fechaRegistro;
		this.familia = familia;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public FamiliaModel getFamilia() {
		return familia;
	}

	public void setFamilia(FamiliaModel familia) {
		this.familia = familia;
	}

}
