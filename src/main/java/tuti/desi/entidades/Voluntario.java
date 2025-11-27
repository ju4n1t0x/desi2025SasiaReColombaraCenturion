package tuti.desi.entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Voluntario extends Persona{

	private long nroSeguro;
	
	@OneToMany(mappedBy="voluntario")
	private List<EntregaAsistencia> entregaAsistnecia;


	
	
}
