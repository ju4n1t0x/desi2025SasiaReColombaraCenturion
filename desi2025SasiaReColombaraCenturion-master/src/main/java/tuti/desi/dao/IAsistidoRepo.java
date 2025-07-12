package tuti.desi.dao;


import tuti.desi.entidades.Asistido;
import tuti.desi.entidades.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAsistidoRepo extends JpaRepository<Asistido, Integer> {
    List<Asistido> findByActivoTrue();


    Optional<Asistido> findByIdAndActivoTrue(int id);


    List<Asistido> findByFamiliaAndActivoTrue(Familia familia);

    List<Asistido> findByActivoFalse();
    List<Asistido> findByFamiliaAndActivoFalse(Familia familia);
}