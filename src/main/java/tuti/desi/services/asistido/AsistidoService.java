package tuti.desi.services.asistido;

import tuti.desi.entidades.*;
import tuti.desi.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistidoService implements IAsistidoService {

    @Autowired
    private IAsistidoRepo IAsistidoRepo;

    @Override
    public List<Asistido> obtenerTodosAsistidosActivos() { 
        return IAsistidoRepo.findByActivoTrue();
    }

    @Override
    public List<Asistido> obtenerAsistidosActivosPorFamilia(Familia familia) { 
        return IAsistidoRepo.findByFamiliaAndActivoTrue(familia);
    }

    @Override
    public Optional<Asistido> obtenerAsistidoPorId(int id) { 
       
        return IAsistidoRepo.findByIdAndActivoTrue(id);
    }

    @Override
    public Asistido crearAsistido(Asistido asistido) {
        asistido.setActivo(true); 
        return IAsistidoRepo.save(asistido);
    }

    @Override
    public Asistido actualizarAsistido(int id, Asistido asistidoDetalles) { 
        Optional<Asistido> asistidoExistenteOptional = IAsistidoRepo.findById(id);
        if (asistidoExistenteOptional.isPresent()) {
            Asistido asistidoExistente = asistidoExistenteOptional.get();
            
            asistidoExistente.setNombre(asistidoDetalles.getNombre());
            asistidoExistente.setApellido(asistidoDetalles.getApellido());
            asistidoExistente.setFechaNacimiento(asistidoDetalles.getFechaNacimiento()); 
            asistidoExistente.setDni(asistidoDetalles.getDni());
            asistidoExistente.setOcupacion(asistidoDetalles.getOcupacion());
            
            return IAsistidoRepo.save(asistidoExistente);
        } else {
            throw new RuntimeException("Asistido con ID " + id + " no encontrado para actualizar.");
        }
    }

    @Override
    public void eliminarAsistido(int id) { 
        Optional<Asistido> asistidoOptional = IAsistidoRepo.findById(id);
        if (asistidoOptional.isPresent()) {
            Asistido asistido = asistidoOptional.get();
            asistido.setActivo(false);
            IAsistidoRepo.save(asistido);
            System.out.println("Se realizó eliminación lógica del asistido con id: " + id);
        } else {
            throw new RuntimeException("Asistido con ID " + id + " no encontrado para eliminación lógica.");
        }
    }

    

    public Asistido reactivarAsistido(int id) { 
        Optional<Asistido> asistidoOptional = IAsistidoRepo.findById(id);
        if (asistidoOptional.isPresent()) {
            Asistido asistido = asistidoOptional.get();
            asistido.setActivo(true);
            return IAsistidoRepo.save(asistido);
        }
        return null;
    }

    public List<Asistido> obtenerAsistidosInactivos() {
        return IAsistidoRepo.findByActivoFalse();
    }

    public List<Asistido> obtenerAsistidosInactivosPorFamilia(Familia familia) {
        return IAsistidoRepo.findByFamiliaAndActivoFalse(familia);
    }
}
