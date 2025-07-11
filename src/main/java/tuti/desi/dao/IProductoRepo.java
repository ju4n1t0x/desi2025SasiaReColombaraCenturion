package tuti.desi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Producto;

@Repository
public interface IProductoRepo extends JpaRepository<Producto, Long>{
	
	List<Producto> findByNombre(String nombre);
}
