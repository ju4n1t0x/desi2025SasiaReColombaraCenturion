package tuti.desi.services.condimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.dao.ICondimentoRepo;
import tuti.desi.entidades.Condimento;
import tuti.desi.entidades.ItemReceta;

@Service
public class CondimentoService implements ICondimentoService {
	
	@Autowired
	private ICondimentoRepo condimentoRepo;

	@Override
	public List<Condimento> getAll() {
		List<Condimento> listaCondimentos = condimentoRepo.findAll();
		return listaCondimentos;
	}

	@Override
	public void saveCondimento(Condimento condimento) {
		condimentoRepo.save(condimento);
	}

	@Override
	public void deleteCondimento(Long id) {
		condimentoRepo.deleteById(id);
		
	}

	@Override
	public Condimento findCondimento(Long id) {
		Condimento condi = condimentoRepo.findById(id).orElse(null);
		return condi;
	}

	@Override
	public void editCondimento(Long idOriginal, String nuevoNombre, Integer nuevasCalorias, List<ItemReceta> nuevoItemReceta) {
		Condimento condi = this.findCondimento(idOriginal);
		condi.setNombre(nuevoNombre);
		condi.setCalorias(nuevasCalorias);
		condi.setItemReceta(nuevoItemReceta);
		

	}

}
