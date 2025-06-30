package tuti.desi.services.entregaAsistencia;

import java.sql.Date;
import java.util.List;

import tuti.desi.entidades.EntregaAsistencia;
import tuti.desi.entidades.Preparacion;
import tuti.desi.presentacion.models.EntregaAsistenciaModel;
import tuti.desi.presentacion.models.FamiliaModel;

public interface IEntregaAsistenciaService {


        EntregaAsistenciaModel save(EntregaAsistenciaModel entregaAsistenciaModel);

        void deleteEntregaAsistencia(Long id);

        EntregaAsistenciaModel findEntregaAsistencia(Long id);

        EntregaAsistenciaModel editEntregaAsistencia(EntregaAsistenciaModel entregaAsistenciaModel);

        List<FamiliaModel> findAllFamilias();


    }
