package tuti.desi.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import tuti.desi.entidades.Familia;

import java.util.List;
import java.util.Optional;

public interface IFamiliaRepo extends JpaRepository<Familia, Integer>{
    @EntityGraph(attributePaths = {"asistidos"})
    @Query("SELECT f FROM Familia f")
    List<Familia> findAllWithAsistidos();
    
    List<Familia> findByActivoTrue();

    Optional<Familia> findByNroFamiliaAndActivoTrue(int nroFamilia);
     List<Familia> findByActivoTrueAndNroFamilia(int nroFamilia);

     List<Familia> findByActivoFalse();

}
