package tuti.desi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;
import tuti.desi.entidades.EntregaAsistencia;
import tuti.desi.entidades.Familia;
import tuti.desi.entidades.Preparacion;
import tuti.desi.dao.IEntregaAsistenciaRepo;
import tuti.desi.dao.IFamiliaRepo;
import tuti.desi.dao.IPreparacionRepo;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional // Asegura que cada test se ejecute en su propia transacción y se revierta al final
class Desi2025SasiaReColombaraCenturionApplicationTests {

	/*
    @Autowired
    private IEntregaAsistenciaService entregaAsistenciaService;

    @Autowired
    private IFamiliaRepo familiaRepo;

    @Autowired
    private IPreparacionRepo preparacionRepo;

    @Autowired
    private IEntregaAsistenciaRepo entregaAsistenciaRepo;

    @Test
    void contextLoads() {
        // Test básico para asegurar que el contexto de Spring se carga correctamente
        assertNotNull(entregaAsistenciaService);
        assertNotNull(familiaRepo);
        assertNotNull(preparacionRepo);
        assertNotNull(entregaAsistenciaRepo);
    }

    @Test
    void testCrearEntregaAsistencia() {
        // Preparación de datos
        Familia familia = new Familia();
        familia.setNroFamilia(101L);
        familia.setNombre("Familia de Prueba");
        familia.setCantidadIntegrantes(4);
        familiaRepo.save(familia);

        Preparacion preparacion = new Preparacion();
        preparacion.setNombre("Guiso de Lentejas");
        preparacion.setStock(50);
        preparacionRepo.save(preparacion);

        EntregaAsistencia entrega = new EntregaAsistencia();
        entrega.setFamilia(familia);
        entrega.setPreparacion(preparacion);
        entrega.setCantidadRaciones(3);
        entrega.setFechaEntrega(LocalDate.now());

        // Ejecución
        EntregaAsistencia entregaGuardada = entregaAsistenciaRepo.save(entrega);

        // Verificación
        assertNotNull(entregaGuardada.getId());
        assertEquals(101L, entregaGuardada.getFamilia().getNroFamilia());
        assertEquals(3, entregaGuardada.getCantidadRaciones());
    }

    @Test
    void testNoPermitirDosEntregasMismoDiaMismaFamilia() {
        // Preparación de datos
        Familia familia = new Familia();
        familia.setNroFamilia(102L);
        familia.setNombre("Familia Test Duplicado");
        familiaRepo.save(familia);

        Preparacion preparacion = new Preparacion();
        preparacion.setNombre("Pollo al Horno");
        preparacion.setStock(30);
        preparacionRepo.save(preparacion);

        EntregaAsistencia primeraEntrega = new EntregaAsistencia();
        primeraEntrega.setFamilia(familia);
        primeraEntrega.setPreparacion(preparacion);
        primeraEntrega.setCantidadRaciones(2);
        primeraEntrega.setFechaEntrega(LocalDate.now());
        entregaAsistenciaRepo.save(primeraEntrega);

        // Ejecución y Verificación
        // Se espera una excepción porque ya existe una entrega para esta familia en el día de hoy.
        // NOTA: Esto asume que tienes una restricción a nivel de base de datos (UNIQUE constraint)
        // en las columnas (familia_id, fecha_entrega).
        assertThrows(DataIntegrityViolationException.class, () -> {
            EntregaAsistencia segundaEntrega = new EntregaAsistencia();
            segundaEntrega.setFamilia(familia);
            segundaEntrega.setPreparacion(preparacion);
            segundaEntrega.setCantidadRaciones(1);
            segundaEntrega.setFechaEntrega(LocalDate.now());
            entregaAsistenciaRepo.saveAndFlush(segundaEntrega); // saveAndFlush para forzar la escritura inmediata
        });
    }

    @Test
    void testNoEntregarMasRacionesQueIntegrantes() {
        // Esta es una prueba conceptual. La lógica real debe estar en el servicio.
        // Preparación de datos
        Familia familia = new Familia();
        familia.setNroFamilia(103L);
        familia.setNombre("Familia Raciones Excedidas");
        familia.setCantidadIntegrantes(3);
        familiaRepo.save(familia);

        Preparacion preparacion = new Preparacion();
        preparacion.setNombre("Milanesas con Puré");
        preparacion.setStock(20);
        preparacionRepo.save(preparacion);

        EntregaAsistencia entrega = new EntregaAsistencia();
        entrega.setFamilia(familia);
        entrega.setPreparacion(preparacion);
        entrega.setCantidadRaciones(4); // 4 raciones para 3 integrantes
        entrega.setFechaEntrega(LocalDate.now());

        // Ejecución y Verificación
        // El servicio debería lanzar una excepción personalizada.
        // Aquí simulamos la validación que debería hacer el servicio.
        assertThrows(IllegalArgumentException.class, () -> {
            entregaAsistenciaService.validarEntrega(entrega);
            // Si no lanza excepción, forzamos el fallo del test
            // fail("Debería haber lanzado una excepción por exceso de raciones.");
        }, "No se puede entregar más raciones que integrantes registrados para la familia.");
    }

    @Test
    void testActualizarStockDespuesDeEntrega() throws Exception {
        // Preparación de datos
        Familia familia = new Familia();
        familia.setNroFamilia(104L);
        familia.setNombre("Familia Stock");
        familia.setCantidadIntegrantes(2);
        familiaRepo.save(familia);

        Preparacion preparacion = new Preparacion();
        preparacion.setNombre("Pastel de Papas");
        preparacion.setStock(15);
        preparacionRepo.save(preparacion);

        int stockInicial = preparacion.getStock();
        int racionesAEntregar = 2;

        EntregaAsistencia entrega = new EntregaAsistencia();
        entrega.setFamilia(familia);
        entrega.setPreparacion(preparacion);
        entrega.setCantidadRaciones(racionesAEntregar);

        // Ejecución
        entregaAsistenciaService.save(entrega);

        // Verificación
        Optional<Preparacion> preparacionActualizadaOpt = preparacionRepo.findById(preparacion.getId());
        assertTrue(preparacionActualizadaOpt.isPresent());
        Preparacion preparacionActualizada = preparacionActualizadaOpt.get();

        assertEquals(stockInicial - racionesAEntregar, preparacionActualizada.getStock());
    }
    */

}
