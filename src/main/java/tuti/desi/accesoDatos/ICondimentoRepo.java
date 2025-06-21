package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Condimento;

@Repository
public interface ICondimentoRepo extends JpaRepository<Condimento, Long>{
	List<Condimento> findBy(Long id);
}
