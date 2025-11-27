package tuti.desi.presentacion.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FamiliaModel {
	
	private Integer nroFamilia;
	
	private String nombre;
	
	private Date fechaRegistro;
	
	private List<EntregaAsistenciaModel> entregaAistencia; 
	
	private List<AsistidoModel> asistido;


	
	

}
