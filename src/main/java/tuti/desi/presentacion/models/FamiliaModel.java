package tuti.desi.presentacion.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



public class FamiliaModel {
	
	private Integer nroFamilia;
	
	private String nombre;
	
	private Date fechaRegistro;
	
	private List<EntregaAsistenciaModel> entregaAistencia; 
	
	private List<AsistidoModel> asistido;

	public FamiliaModel() {
		super();

        this.asistido = new ArrayList<>();

        this.entregaAistencia = new ArrayList<>();
	}

	public FamiliaModel(Integer nroFamilia, String nombre, Date fechaRegistro, List<EntregaAsistenciaModel> entregaAistencia,
			List<AsistidoModel> asistido) {
		super();
		this.nroFamilia = nroFamilia;
		this.nombre = nombre;
		this.fechaRegistro = fechaRegistro;
		this.entregaAistencia = entregaAistencia;
		this.asistido = asistido;
	}

	public Integer getNroFamilia() {
		return nroFamilia;
	}

	public void setNroFamilia(Integer nroFamilia) {
		this.nroFamilia = nroFamilia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<EntregaAsistenciaModel> getEntregaAistencia() {
		return entregaAistencia;
	}

	public void setEntregaAistencia(List<EntregaAsistenciaModel> entregaAistencia) {
		this.entregaAistencia = entregaAistencia;
	}

	public List<AsistidoModel> getAsistido() {
		return asistido;
	}

	public void setAsistido(List<AsistidoModel> asistido) {
		this.asistido = asistido;
	}
	
	
	

}
