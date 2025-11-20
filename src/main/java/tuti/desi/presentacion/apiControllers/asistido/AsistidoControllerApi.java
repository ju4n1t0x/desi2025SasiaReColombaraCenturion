package tuti.desi.presentacion.apiControllers.asistido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tuti.desi.presentacion.models.AsistidoModel;
import tuti.desi.services.asistido.IAsistidoService;
import tuti.desi.services.familia.IFamiliaService;

import java.util.List;

@RestController
@RequestMapping("/asistidos")
public class AsistidoControllerApi {

    @Autowired
    private IAsistidoService asistidoService;

    @Autowired
    private IFamiliaService familiaService;

    // --- C. Listado (READ) ---
    @GetMapping("/list")
    @ResponseBody
    public List<AsistidoModel> listarAsistidos(Model modelo) {
        // Obtiene la lista de AsistidoModel del servicio
        List<AsistidoModel> asistidos = asistidoService.findAll();

        return asistidos;
    }



    @PostMapping("/save")
    public void guardarAsistido(@RequestBody AsistidoModel asistidoModel) {

        asistidoService.saveAsistido(asistidoModel);

    }


   /*@GetMapping("/eliminar/{id}")
    public String eliminarAsistido(@PathVariable("id") Integer id, RedirectAttributes ra) {

        asistidoService.deleteAsistido(id);

        ra.addFlashAttribute("warning", "Asistido eliminado.");
        return "redirect:/asistidos/listado";
    }*/
}