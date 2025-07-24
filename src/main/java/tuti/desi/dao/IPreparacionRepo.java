package tuti.desi.dao;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tuti.desi.entidades.Preparacion;

@Repository
public interface IPreparacionRepo extends JpaRepository<Preparacion, Long> {

    // Obtener preparaciones activas
    List<Preparacion> findByActivoTrueOrderByFechaCoccion();


    
    // Obtener preparaciones del día con stock
    @Query("SELECT p FROM Preparacion p WHERE p.fechaCoccion = CURRENT_DATE AND p.stockRacionesRestantes > 0 AND p.activo = true")
    List<Preparacion> findPreparacionesDelDiaConStock();

    // ===== CONSULTAS BÁSICAS =====
    List<Preparacion> findByActivoTrue();

    List<Preparacion> findByActivoFalse();

    // BUSCAR POR FECHA
    List<Preparacion> findByFechaCoccionAndActivoTrue(Date fechaCoccion);

    List<Preparacion> findByFechaCoccionBetweenAndActivoTrue(Date fechaInicio, Date fechaFin);

    List<Preparacion> findByRecetaNombreContainingIgnoreCaseAndActivoTrue(String nombreReceta);

    // BUSCAR POR STOCK
    //List<Preparacion> findByStockRacionesRestantesGreaterThanAndActivoTrue(Integer cantidad);

    //List<Preparacion> findByStockRacionesRestantesEqualsAndActivoTrue(Integer cantidad);


}