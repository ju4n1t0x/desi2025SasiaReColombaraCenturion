package tuti.desi.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import tuti.desi.entidades.Familia;

import java.time.LocalDate;
import java.util.List;


public interface IFamiliaRepo extends JpaRepository<Familia, Integer>{
    @EntityGraph(attributePaths = {"asistidos"})
    @Query("SELECT f FROM Familia f")
    List<Familia> findAllWithAsistidos();


}
