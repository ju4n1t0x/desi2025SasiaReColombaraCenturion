package tuti.desi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Receta;

@Repository
public interface IRecetaRepo extends JpaRepository<Receta, Integer>{
	
	List<Receta> findByNombre(String nombre);

	boolean existsByNombre(String nombre);

}
