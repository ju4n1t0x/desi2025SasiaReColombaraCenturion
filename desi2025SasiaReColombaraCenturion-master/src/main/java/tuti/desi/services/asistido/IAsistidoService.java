package tuti.desi.services.asistido;

import tuti.desi.entidades.Asistido;
import tuti.desi.entidades.Familia;

import java.util.List;
import java.util.Optional;

public interface IAsistidoService {

   List<Asistido> obtenerTodosAsistidosActivos();

    List<Asistido> obtenerAsistidosActivosPorFamilia(Familia familia);

    Optional<Asistido> obtenerAsistidoPorId(int id); 

    Asistido crearAsistido(Asistido asistido);

    Asistido actualizarAsistido(int id, Asistido asistido);

    void eliminarAsistido(int id); 
}

