package tuti.desi.presentacion.controller.entrega;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import tuti.desi.presentacion.models.EntregaAsistenciaModel;
import tuti.desi.services.entregaAsistencia.EntregaAsistenciaService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ListadoDeEntregasController {
    @Autowired
    private EntregaAsistenciaService entregaAsistenciaService;
    @GetMapping("entrega/listadoEntregas")
    public String listarEntregas(
        @RequestParam(value="fecha", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
        @RequestParam(value="nroFamilia", required = false) Long nroFamilia,
        @RequestParam(value="nombreFamilia", required = false) String nombreFamilia,
        Model model){

        List<EntregaAsistenciaModel> entregas;
            if (fecha != null || nroFamilia != null || (nombreFamilia != null && !nombreFamilia.isEmpty())) {
                entregas = entregaAsistenciaService.findAll(fecha, nroFamilia, nombreFamilia);
            } else {
                entregas = entregaAsistenciaService.findAll();
            }
            model.addAttribute("entregas", entregas);
            return "entrega/listadoEntregas";
        }

         @GetMapping("entrega/eliminar/{id}")
         public String eliminarEntrega(@PathVariable Long id) {
             entregaAsistenciaService.deleteEntregaAsistencia(id);
             return "redirect:/entrega/listadoEntregas";
         }

}
