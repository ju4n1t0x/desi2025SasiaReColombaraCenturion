package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.ItemReceta;

@Repository
public interface IItemRecetaRepo extends JpaRepository<ItemReceta, Long>{
	
	List<ItemReceta> findBy(Long id);

}
