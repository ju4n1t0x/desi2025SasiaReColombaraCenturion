package tuti.desi.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Asistido;
import tuti.desi.entidades.Familia;
import java.util.Optional;

@Repository
public interface IAsistidoRepo extends JpaRepository<Asistido, Long>{
	long countByFamiliaNroFamilia(Integer nroFamilia);

	long countByFamilia(Familia familia);
	
	 List<Asistido> findByActivoTrue();


	    Optional<Asistido> findByIdAndActivoTrue(int id);


	    List<Asistido> findByFamiliaAndActivoTrue(Familia familia);

	    List<Asistido> findByActivoFalse();
	    List<Asistido> findByFamiliaAndActivoFalse(Familia familia);

		Optional<Asistido> findById(int id);
}