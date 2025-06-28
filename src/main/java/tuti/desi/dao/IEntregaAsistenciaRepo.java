package tuti.desi.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.EntregaAsistencia;

@Repository
public interface IEntregaAsistenciaRepo extends JpaRepository<EntregaAsistencia, Long>{
	List<EntregaAsistencia> findByFecha(Date fecha);

	Long id(long id);
}
