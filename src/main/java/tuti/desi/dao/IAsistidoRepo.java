package tuti.desi.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Asistido;
import tuti.desi.entidades.Familia;

@Repository
public interface IAsistidoRepo extends JpaRepository<Asistido, Long>{
	
	List<Asistido> findByDni(Integer dni);

	long countByFamiliaNroFamilia(Integer nroFamilia);

	long countByFamilia(Familia familia);
}