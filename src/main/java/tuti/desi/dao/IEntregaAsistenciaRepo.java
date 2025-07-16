package tuti.desi.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.EntregaAsistencia;

@Repository
public interface IEntregaAsistenciaRepo extends JpaRepository<EntregaAsistencia, Long>{
	List<EntregaAsistencia> findByFecha(Date fecha);

	@Query("SELECT ea FROM EntregaAsistencia ea JOIN FETCH ea.familia JOIN FETCH ea.preparacion")
	List<EntregaAsistencia> buscarPorFamiliaYPreparacion();

	List<EntregaAsistencia> findByFecha(LocalDate fecha);
	List<EntregaAsistencia> findByFamilia_NroFamilia(Integer nroFamilia);
	List<EntregaAsistencia> findByFamilia_NombreContainingIgnoreCase(String nombre);

	@Query("SELECT ea FROM EntregaAsistencia ea JOIN FETCH ea.familia f JOIN FETCH ea.preparacion p " +
	"WHERE (:fecha IS NULL OR ea.fecha = :fecha)" +
	"AND (:nroFamilia IS NULL OR f.nroFamilia = :nroFamilia)" +
	"AND (:nombreFamilia IS NULL OR LOWER(f.nombre) LIKE LOWER(CONCAT('%', :nombreFamilia, '%')))")
	List<EntregaAsistencia> findByFechaAndFamiliaNroFamiliaAndFamiliaNombre(LocalDate fecha, Long nroFamilia, String nombreFamilia);

}
