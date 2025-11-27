package tuti.desi.entidades;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class 	Familia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer nroFamilia;
	
	private String nombre;
	private Date fechaRegistro;
	

	@OneToMany(mappedBy = "familia", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EntregaAsistencia> entregaAsistencia = new ArrayList<>();
	

	@OneToMany(mappedBy = "familia", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Asistido> asistido = new ArrayList<>();


	
	
}
