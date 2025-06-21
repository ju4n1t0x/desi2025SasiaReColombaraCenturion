package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tuti.desi.entidades.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Long>{
	
	List<Producto> findBy(Long id);
}
