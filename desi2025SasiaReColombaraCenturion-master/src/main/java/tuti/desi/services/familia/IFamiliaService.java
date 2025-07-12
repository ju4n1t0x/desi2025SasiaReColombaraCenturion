package tuti.desi.services.familia;

import tuti.desi.entidades.Familia;
import tuti.desi.presentacion.models.FamiliaModel;
import java.util.List;

public interface IFamiliaService {
	
	public FamiliaModel findFamilia(Integer nroFamilia);
	
	List<Familia> obtenerTodas();

    
    List<Familia> obtenerTodasLasFamiliasActivas();

    Familia crearFamilia(Familia familia);

    Familia obtenerPorId(int nroFamilia);

    void eliminarFamilia(int nroFamilia);

    Familia actualizarFamilia(int nroFamilia, Familia familia);
}


