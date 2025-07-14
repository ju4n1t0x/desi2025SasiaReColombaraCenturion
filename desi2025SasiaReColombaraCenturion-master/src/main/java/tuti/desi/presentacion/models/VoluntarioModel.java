package tuti.desi.presentacion.models;

import java.util.List;

public class VoluntarioModel extends PersonaModel{

	private long nroSeguro;
	
	private List<EntregaAsistenciaModel> entregaAsistencia;

	public VoluntarioModel() {
		super();
	}

	public VoluntarioModel(long nroSeguro, List<EntregaAsistenciaModel> entregaAsistencia) {
		super();
		this.nroSeguro = nroSeguro;
		this.entregaAsistencia = entregaAsistencia;
	}

	public long getNroSeguro() {
		return nroSeguro;
	}

	public void setNroSeguro(long nroSeguro) {
		this.nroSeguro = nroSeguro;
	}

	public List<EntregaAsistenciaModel> getEntregaAsistencia() {
		return entregaAsistencia;
	}

	public void setEntregaAsistencia(List<EntregaAsistenciaModel> entregaAsistencia) {
		this.entregaAsistencia = entregaAsistencia;
	}
	
	
}
