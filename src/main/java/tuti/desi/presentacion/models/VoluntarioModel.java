package tuti.desi.presentacion.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoluntarioModel extends PersonaModel{

	private long nroSeguro;
	
	private List<EntregaAsistenciaModel> entregaAsistencia;


	
	
}
