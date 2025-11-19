package tuti.desi.services.asistido;

import java.util.List;


import tuti.desi.presentacion.models.AsistidoModel; // ⬅️ Necesitas crear esta clase

public interface IAsistidoService {


    public List<AsistidoModel> findAll();


    public void saveAsistido (AsistidoModel asistidoModel);


    public void deleteAsistido (Integer id); // ⬅️ Tipo de ID ajustado a Integer


    public AsistidoModel findAsistido (Integer id); // ⬅️ Tipo de ID ajustado a Integer


}

