package tuti.desi.services.familia;

import java.sql.Date;
import java.util.List;

import tuti.desi.accesoDatos.IFamiliaRepo;
import tuti.desi.entidades.Asistido;
import tuti.desi.entidades.Familia;

public class FamiliaService implements IFamiliaService{
	
	private IFamiliaRepo familiaRepo;

	@Override
	public List<Familia> getAll() {
		List<Familia> listaFamilias = familiaRepo.findAll();
		return listaFamilias;
	}

	@Override
	public void saveFamilia(Familia familia) {
		familiaRepo.save(familia);
		
	}

	@Override
	public void deleteFamilia(Integer nroFamilia) {
		familiaRepo.deleteById(nroFamilia);
		
	}

	@Override
	public Familia findFamilia(Integer nroFamilia) {
		Familia fami = familiaRepo.findById(nroFamilia).orElse(null);
		return fami;
	}

	@Override
	public void editFamilia(Integer nroFamilia, String nuevoNombre, Date nuevaFrechaRegistro, List<Asistido> nuevaListaAsistidos) {
		Familia fami = this.findFamilia(nroFamilia);
		fami.setNombre(nuevoNombre);
		fami.setFechaRegistro(nuevaFrechaRegistro);
		fami.setAsistido(nuevaListaAsistidos);
		
	}

}
