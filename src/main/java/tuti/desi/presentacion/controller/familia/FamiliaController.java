package tuti.desi.presentacion.controller.familia;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tuti.desi.entidades.Familia;
import tuti.desi.presentacion.models.FamiliaModel;
import tuti.desi.services.familia.IFamiliaService;

@Controller
@RequestMapping("/familias") 
public class FamiliaController {

    @Autowired
    private IFamiliaService familiaService;


    @GetMapping("/listado")
    public String listarFamilias(Model modelo) {

        List<Familia> familias = familiaService.getAll(); 
        modelo.addAttribute("familias", familias);
        return "familia/listadoFamilias";
    }


    @GetMapping({"/nueva", "/editar/{id}"})
    public String prepararFormulario(@PathVariable(name = "id", required = false) Integer id, Model modelo) {
        if (id == null) {

            Familia familia = new Familia();
            familia.setFechaRegistro(Date.valueOf(LocalDate.now())); 
            modelo.addAttribute("familia", familia);
            modelo.addAttribute("isEdit", false);
        } else {

            FamiliaModel familiaModel = familiaService.findFamilia(id);
            if (familiaModel == null) {
                return "redirect:/familias/listado";
            }
            modelo.addAttribute("familiaModel", familiaModel);
            modelo.addAttribute("isEdit", true);
        }
        return "familia/formFamilia";
    }


    @PostMapping("/guardar")
    public String guardarFamilia(@ModelAttribute("familia") Familia familia, RedirectAttributes ra) {
        familiaService.saveFamilia(familia);
        ra.addFlashAttribute("mensaje", "Familia registrada con éxito.");
        return "redirect:/familias/listado";
    }

    @PostMapping("/actualizar")
    public String actualizarFamilia(@ModelAttribute("familiaModel") @Valid FamiliaModel familiaModel,
                                    BindingResult result,
                                    Model modelo,
                                    RedirectAttributes ra) {


        if (result.hasErrors()) {

            modelo.addAttribute("isEdit", true);


            return "familia/formFamilia";
        }


        familiaService.editFamilia(familiaModel); // Llama al método que usa el DTO
        ra.addFlashAttribute("mensaje", "Familia modificada con éxito.");
        return "redirect:/familias/listado";
    }
    

    @GetMapping("/eliminar/{id}")
    public String eliminarFamilia(@PathVariable("id") Integer id, RedirectAttributes ra) {
        familiaService.deleteFamilia(id);
        ra.addFlashAttribute("mensaje", "Familia eliminada con éxito.");
        return "redirect:/familias/listado";
    }
}