package tuti.desi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Ingrediente;

@Repository
public interface IIngredienteRepo extends JpaRepository<Ingrediente, Long>{

	List<Ingrediente> findByNombre(String nombre);
}
