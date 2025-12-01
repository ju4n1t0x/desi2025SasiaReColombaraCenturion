package tuti.desi.entidades;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EntregaAsistencia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDate fecha;
	private Integer cantidadRaciones;
	
	@ManyToOne()
	private Preparacion preparacion;

	@ManyToOne
	private Voluntario voluntario;
	
	@ManyToOne
	private Familia familia;
	

	
	
	
}
