package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tuti.desi.entidades.Ingrediente;

public interface IIngredienteRepo extends JpaRepository<Ingrediente, Long>{

	List<Ingrediente> findByNombre(String nombre);
}
