package tuti.desi.services.condimento;

import java.util.List;

import tuti.desi.entidades.Condimento;
import tuti.desi.entidades.ItemReceta;

public interface ICondimentoService {

	public List<Condimento> getAll();
	
	public void saveCondimento(Condimento condimento);
	
	public void deleteCondimento(Long id);
	
	public Condimento findCondimento (Long id);
	
	public void editCondimento(Long idOriginal, Long nuevoId, String nuevoNombre, Integer nuevasCalorias, List<ItemReceta> nuevoItemReceta);
	
}
