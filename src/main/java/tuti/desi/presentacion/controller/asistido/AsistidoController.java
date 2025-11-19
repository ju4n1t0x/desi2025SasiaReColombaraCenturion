package tuti.desi.presentacion.controller.asistido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tuti.desi.entidades.Familia;
import tuti.desi.presentacion.models.AsistidoModel;
import tuti.desi.services.asistido.IAsistidoService;
import tuti.desi.services.familia.IFamiliaService;

@Controller
@RequestMapping("/asistidos")
public class AsistidoController {

    @Autowired
    private IAsistidoService asistidoService;

    @Autowired
    private IFamiliaService familiaService;

    // --- C. Listado (READ) ---
    @GetMapping("/listado")
    public String listarAsistidos(Model modelo) {
        // Obtiene la lista de AsistidoModel del servicio
        List<AsistidoModel> asistidos = asistidoService.findAll();
        modelo.addAttribute("asistidos", asistidos);


        return "asistido/listadoAsistidos";
    }


    @GetMapping({"/nuevo", "/editar/{id}"})
    public String prepararFormulario(@PathVariable(name = "id", required = false) Integer id, Model modelo) {
        AsistidoModel asistido = new AsistidoModel();


        if (id != null) {
            asistido = asistidoService.findAsistido(id);
        }


        List<Familia> familias = familiaService.getAll();

        modelo.addAttribute("asistido", asistido);
        modelo.addAttribute("familias", familias);


        return "asistido/formAsistido";
    }


    @PostMapping("/guardar")
    public String guardarAsistido(@ModelAttribute("asistido") AsistidoModel asistidoModel, RedirectAttributes ra) {


        asistidoService.saveAsistido(asistidoModel);

        ra.addFlashAttribute("success", "Asistido guardado/actualizado correctamente.");
        return "redirect:/asistidos/listado";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarAsistido(@PathVariable("id") Integer id, RedirectAttributes ra) {

        asistidoService.deleteAsistido(id);

        ra.addFlashAttribute("warning", "Asistido eliminado.");
        return "redirect:/asistidos/listado";
    }
}