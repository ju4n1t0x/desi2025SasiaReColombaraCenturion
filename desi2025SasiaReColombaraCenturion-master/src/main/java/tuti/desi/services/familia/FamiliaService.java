package tuti.desi.services.familia;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import tuti.desi.dao.IFamiliaRepo;
import tuti.desi.entidades.Familia;
import tuti.desi.presentacion.models.FamiliaModel;

@Service
public class FamiliaService implements IFamiliaService{
	@Autowired
	private IFamiliaRepo familiaRepo;
	
    @Override
	public FamiliaModel findFamilia(Integer nroFamilia) {
		// TODO Auto-generated method stub
		return null;
	}
    @Override
    public List<Familia> obtenerTodas() {
       return familiaRepo.findByActivoTrue();
    }

    @Override
    public List<Familia> obtenerTodasLasFamiliasActivas() {
        return familiaRepo.findByActivoTrue();
    }

    @Override
   public Familia crearFamilia(Familia familia) {
        familia.setFechaRegistro(LocalDate.now());
        familia.setActivo(true);
        return familiaRepo.save(familia);
    }

    @Override
    public Familia obtenerPorId(int nroFamilia) {
        return familiaRepo.findByNroFamiliaAndActivoTrue(nroFamilia) 
                .orElse(null);
    }

    @Override
    public void eliminarFamilia(int nroFamilia) {
        
        Optional<Familia> familiaOptional = familiaRepo.findById(nroFamilia); 
        if (familiaOptional.isPresent()) {
            Familia familia = familiaOptional.get();
            familia.setActivo(false);
            familiaRepo.save(familia);
            System.out.println("Se realizó eliminación lógica de la familia con nroFamilia: " + nroFamilia);
        } else {
            throw new RuntimeException("Familia con NroFamilia " + nroFamilia + " no encontrada para eliminación lógica.");
        }
    }

    @Override
     public Familia actualizarFamilia(int nroFamilia, Familia familiaActualizada) { 
        Optional<Familia> familiaExistenteOptional = familiaRepo.findById(nroFamilia); 
        if (familiaExistenteOptional.isPresent()) {
            Familia familiaExistente = familiaExistenteOptional.get();
            familiaExistente.setNombre(familiaActualizada.getNombre());
            familiaExistente.setFechaRegistro(familiaActualizada.getFechaRegistro());
            
            return familiaRepo.save(familiaExistente);
        }
        return null; 
    }

     public List<Familia> obtenerFamiliasInactivas() {
        return familiaRepo.findByActivoFalse();
    }

    public Familia reactivarFamilia(int nroFamilia) {
        Optional<Familia> familiaOptional = familiaRepo.findById(nroFamilia); 
        if (familiaOptional.isPresent()) {
            Familia familia = familiaOptional.get();
            familia.setActivo(true);
            return familiaRepo.save(familia);
        }
        return null;
    }

    

}
