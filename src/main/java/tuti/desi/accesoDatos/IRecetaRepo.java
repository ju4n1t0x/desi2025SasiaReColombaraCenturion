package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Receta;

@Repository
public interface IRecetaRepo extends JpaRepository<Receta, Long>{
	
	List<Receta> findByNombre(String nombre);
}
