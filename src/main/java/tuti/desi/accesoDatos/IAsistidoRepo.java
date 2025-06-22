package tuti.desi.accesoDatos;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Asistido;

@Repository
public interface IAsistidoRepo extends JpaRepository<Asistido, Long>{
	
	List<Asistido> findByDni(Integer dni);

}