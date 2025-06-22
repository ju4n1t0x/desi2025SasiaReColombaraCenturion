package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Voluntario;

@Repository
public interface IVoluntarioRepo extends JpaRepository<Voluntario, Long>{

	List<Voluntario> findByDni(Integer dni);
}
