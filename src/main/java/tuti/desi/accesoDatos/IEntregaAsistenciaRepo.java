package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.EntregaAsistencia;

@Repository
public interface IEntregaAsistenciaRepo extends JpaRepository<EntregaAsistencia, Long>{
	List<EntregaAsistencia> findBy(Long id);
}
