package tuti.desi.presentacion.models;

import java.sql.Date;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PreparacionModel {

	private Long id;

	@NotNull(message = "La cantidad de raciones es obligatoria")
	@Min(value = 1, message = "Debe preparar al menos 1 ración")
	@Max(value = 999, message = "No puede preparar más de 999 raciones")
	private Integer totalRacionesPreparadas;

	private Integer stockRacionesRestantes;

	@NotNull(message = "La fecha es obligatoria")
	@PastOrPresent(message = "La fecha no puede ser futura")
	private Date fechaCoccion;

	@NotNull(message = "La receta es obligatoria")
	@Min(value = 1, message = "Debe seleccionar una receta válida")
	private Long recetaId;

	private RecetaModel receta;

	private Boolean activo = true;




	@Override
	public String toString() {
		return "PreparacionModel{" +
				"id=" + id +
				", totalRacionesPreparadas=" + totalRacionesPreparadas +
				", stockRacionesRestantes=" + stockRacionesRestantes +
				", fechaCoccion=" + fechaCoccion +
				", recetaId=" + recetaId +
				'}';
	}
}
