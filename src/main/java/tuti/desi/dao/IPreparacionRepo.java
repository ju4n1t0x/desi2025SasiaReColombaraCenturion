package tuti.desi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tuti.desi.entidades.Preparacion;

@Repository
public interface IPreparacionRepo extends JpaRepository<Preparacion, Long> {

    // Obtener preparaciones activas
    List<Preparacion> findByActivoTrueOrderByFechaCoccion();

    // Obtener preparaciones del día actual
    @Query("SELECT p FROM Preparacion p WHERE p.fechaCoccion = CURRENT_DATE AND p.activo = true")
    List<Preparacion> findPreparacionesDelDia();

    // Obtener preparaciones con stock disponible
    @EntityGraph(attributePaths = {"receta"})
    @Query("SELECT p FROM Preparacion p WHERE p.fechaCoccion = CURRENT_DATE AND p.stockRacionesRestantes > 0 AND p.activo = true")
    List<Preparacion> findPreparacionesConStock();
    
    // Obtener preparaciones del día con stock
    @Query("SELECT p FROM Preparacion p WHERE p.fechaCoccion = CURRENT_DATE AND p.stockRacionesRestantes > 0 AND p.activo = true")
    List<Preparacion> findPreparacionesDelDiaConStock();

    //Verificar si ya existe una preparacion de la misma receta en el mismo dia
    //@Query("SELECT p FROM Preparacion p WHERE p.receta_id = :recetaId AND p.fecha_coccion = :fechaCoccion AND p.activo = true")
    //Optional<Preparacion> findByRecetaIdAndFechaAndActivoTrue(@Param("recetaId") Long recetaId, @Param("fecha") Date fechaCoccion);

}