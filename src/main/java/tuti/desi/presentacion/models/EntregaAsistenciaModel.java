package tuti.desi.presentacion.models;


import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuti.desi.entidades.Preparacion;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntregaAsistenciaModel {

	private Integer id;


	private LocalDate fecha;

	@NotNull(message = "La cantidad de raciones no puede estar vacía.")
	@Min(value = 1, message = "La cantidad de raciones debe ser mayor a 0.")
	private Integer cantidadRaciones;

	@NotNull(message = "Debe seleccionar una preparacion.")
	private Integer idPreparacion;

	private PreparacionModel preparacion;

	private VoluntarioModel voluntario;

	@NotNull(message = "Debe seleccionar una familia.")
	private Integer nroFamilia;

	private FamiliaModel familia;



}
