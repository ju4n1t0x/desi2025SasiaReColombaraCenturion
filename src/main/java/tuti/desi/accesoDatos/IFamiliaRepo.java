package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tuti.desi.entidades.Familia;

public interface IFamiliaRepo extends JpaRepository<Familia, Integer>{
	
	List<Familia> findByNroFamilia(Integer nroFamilia); 

}
