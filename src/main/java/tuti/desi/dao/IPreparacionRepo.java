package tuti.desi.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Preparacion;

@Repository
public interface IPreparacionRepo extends JpaRepository<Preparacion, Long> {
    
    // Método para obtener preparaciones del día actual
    @Query("SELECT p FROM Preparacion p WHERE p.fechaCoccion = CURRENT_DATE")
    List<Preparacion> findPreparacionesDelDia();

    // Método para preparaciones con stock disponible
    @Query("SELECT p FROM Preparacion p WHERE p.stockRacionesRestantes > 0")
    List<Preparacion> findPreparacionesConStock();
    
    // Método combinado: preparaciones del día con stock
    @Query("SELECT p FROM Preparacion p WHERE p.fechaCoccion = CURRENT_DATE AND p.stockRacionesRestantes > 0")
    List<Preparacion> findPreparacionesDelDiaConStock();
}