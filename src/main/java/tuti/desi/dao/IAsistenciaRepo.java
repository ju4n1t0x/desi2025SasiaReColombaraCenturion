package tuti.desi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tuti.desi.entidades.Asistencia;

public interface IAsistenciaRepo extends JpaRepository<Asistencia, Integer> {
}
