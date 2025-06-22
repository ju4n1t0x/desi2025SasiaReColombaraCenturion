package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.ItemReceta;
import tuti.desi.entidades.Preparacion;

@Repository
public interface IPreparacionRepo extends JpaRepository<Preparacion, Long>{
	List<ItemReceta> findByReceta_id(Long recetaId);
}
