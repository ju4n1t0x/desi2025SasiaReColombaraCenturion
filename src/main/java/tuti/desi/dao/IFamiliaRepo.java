package tuti.desi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tuti.desi.entidades.Familia;

import java.time.LocalDate;


public interface IFamiliaRepo extends JpaRepository<Familia, Integer>{
	


}
