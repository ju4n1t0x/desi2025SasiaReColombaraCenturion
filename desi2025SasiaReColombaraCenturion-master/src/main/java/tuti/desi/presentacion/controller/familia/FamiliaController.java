package tuti.desi.presentacion.controller.familia;

import tuti.desi.entidades.Familia;
import tuti.desi.services.familia.IFamiliaService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/familias")
public class FamiliaController {

    @Autowired
    private IFamiliaService IFamiliaService;


    @GetMapping
    public String listarFamilias(Model model) {
        List<Familia> familias = IFamiliaService.obtenerTodasLasFamiliasActivas();
        model.addAttribute("listaFamilias", familias);
        return "listarFamilias";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaFamilia(Model model) {
        model.addAttribute("familia", new Familia());
        return "formulario";
    }

    @PostMapping("/nuevo")
    public String guardarNuevaFamilia(@Valid @ModelAttribute("familia") Familia familia,
                                      BindingResult result,
                                      RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "formulario";
        }
        IFamiliaService.crearFamilia(familia);
        redirectAttributes.addFlashAttribute("mensaje", "Familia creada exitosamente!");
        return "redirect:/familias";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarFamilia(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Familia familia = IFamiliaService.obtenerPorId(id);
        if (familia == null) {
            redirectAttributes.addFlashAttribute("error", "Familia no encontrada o inactiva.");
            return "redirect:/familias";
        }
        model.addAttribute("familia", familia);
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    public String actualizarFamilia(@PathVariable int id,
                                    @Valid @ModelAttribute("familia") Familia familia,
                                    BindingResult result,
                                    RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "formulario";
        }
        IFamiliaService.actualizarFamilia(id, familia);
        redirectAttributes.addFlashAttribute("mensaje", "Familia actualizada exitosamente!");
        return "redirect:/familias";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFamilia(@PathVariable int id, RedirectAttributes redirectAttributes) {
        try {
            IFamiliaService.eliminarFamilia(id);
            redirectAttributes.addFlashAttribute("mensaje", "Familia eliminada exitosamente!");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar la familia: " + e.getMessage());
        }
        return "redirect:/familias";
    }
}
