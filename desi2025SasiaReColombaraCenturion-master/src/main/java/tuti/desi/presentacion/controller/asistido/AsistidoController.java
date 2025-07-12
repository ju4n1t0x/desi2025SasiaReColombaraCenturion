package tuti.desi.presentacion.controller.asistido;

import tuti.desi.services.asistido.*;
import tuti.desi.services.familia.*;
import tuti.desi.entidades.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/familias/{nroFamilia}/asistidos")
public class AsistidoController {

    @Autowired
    private IAsistidoService asistidoService;

    @Autowired
    private IFamiliaService IFamiliaService;


    @GetMapping
    public String listarAsistidosPorFamilia(@PathVariable int nroFamilia, Model model) {
        Familia familia = IFamiliaService.obtenerPorId(nroFamilia);
        if (familia == null) {

            return "redirect:/familias";
        }

        List<Asistido> asistidos = asistidoService.obtenerAsistidosActivosPorFamilia(familia);
        model.addAttribute("familia", familia);
        model.addAttribute("listaAsistidos", asistidos);
        return "listarAsistidos";
    }


    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoAsistido(@PathVariable int nroFamilia, Model model) {
        Familia familia = IFamiliaService.obtenerPorId(nroFamilia);
        if (familia == null) {
            return "redirect:/familias";
        }
        Asistido asistido = new Asistido();
        asistido.setFamilia(familia);

        model.addAttribute("asistido", asistido);
        model.addAttribute("familia", familia);
        model.addAttribute("accion", "/familias/" + nroFamilia + "/asistidos/guardar");

        
        List<String> opcionesOcupacion = Arrays.asList(
                "Empleado", "Desempleado", "Estudiante", "Ama de Casa", "Otro"
        );
        model.addAttribute("ocupaciones", opcionesOcupacion);

        return "formularioAsistido";
    }


    @PostMapping("/guardar")
    public String guardarNuevoAsistido(@PathVariable int nroFamilia,
                                       @Valid @ModelAttribute("asistido") Asistido asistido,
                                       BindingResult result,
                                       RedirectAttributes redirectAttributes) {
        Familia familia = IFamiliaService.obtenerPorId(nroFamilia);
        if (familia == null) {
            redirectAttributes.addFlashAttribute("error", "La familia a la que intenta añadir el asistido no existe.");
            return "redirect:/familias";
        }
        asistido.setFamilia(familia);

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.asistido", result);
            redirectAttributes.addFlashAttribute("asistido", asistido);
            redirectAttributes.addFlashAttribute("error", "Error en el formulario. Por favor, revisa los campos.");

            return "redirect:/familias/" + nroFamilia + "/asistidos/nuevo";
        }

        try {
            asistidoService.crearAsistido(asistido);
            redirectAttributes.addFlashAttribute("mensaje", "Asistido guardado con éxito!");
            
            return "redirect:/familias/" + nroFamilia + "/asistidos";
        } catch (Exception e) {
            
            redirectAttributes.addFlashAttribute("error", "Error al guardar el asistido: " + e.getMessage());
            redirectAttributes.addFlashAttribute("asistido", asistido);
            return "redirect:/familias/" + nroFamilia + "/asistidos/nuevo";
        }
    }


    @GetMapping("/editar/{asistidoId}")
    public String mostrarFormularioEditarAsistido(@PathVariable int nroFamilia, @PathVariable int asistidoId, Model model) { // <--- CORREGIDO: asistidoId a int
        Familia familia = IFamiliaService.obtenerPorId(nroFamilia);
        if (familia == null) {
            return "redirect:/familias";
        }


        Optional<Asistido> asistidoOptional = asistidoService.obtenerAsistidoPorId(asistidoId);

        if (asistidoOptional.isPresent()) {
            Asistido asistido = asistidoOptional.get();
            
            if (asistido.getFamilia() != null && asistido.getFamilia().getNroFamilia() == nroFamilia) {
                model.addAttribute("asistido", asistido);
                model.addAttribute("familia", familia);
                model.addAttribute("accion", "/familias/" + nroFamilia + "/asistidos/actualizar/" + asistidoId);

                List<String> opcionesOcupacion = Arrays.asList(
                        "Empleado", "Desempleado", "Estudiante", "Ama de Casa", "Otro"
                );
                model.addAttribute("ocupaciones", opcionesOcupacion);

                return "formularioAsistido";
            }
        }
        model.addAttribute("error", "Asistido no encontrado o no pertenece a esta familia.");
        return "redirect:/familias/" + nroFamilia + "/asistidos";
    }


    @PostMapping("/actualizar/{asistidoId}")
    public String actualizarAsistido(@PathVariable int nroFamilia,
                                     @PathVariable int asistidoId,
                                     @Valid @ModelAttribute("asistido") Asistido asistido,
                                     BindingResult result,
                                     RedirectAttributes redirectAttributes) {
        Familia familia = IFamiliaService.obtenerPorId(nroFamilia);
        if (familia == null) {
            redirectAttributes.addFlashAttribute("error", "La familia del asistido no existe.");
            return "redirect:/familias";
        }
        asistido.setFamilia(familia);

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.asistido", result);
            redirectAttributes.addFlashAttribute("asistido", asistido);
            redirectAttributes.addFlashAttribute("error", "Error en el formulario. Por favor, revisa los campos.");
            
            return "redirect:/familias/" + nroFamilia + "/asistidos/editar/" + asistidoId;
        }

        try {
            asistidoService.actualizarAsistido(asistidoId, asistido);
            redirectAttributes.addFlashAttribute("mensaje", "Asistido actualizado con éxito!");
            return "redirect:/familias/" + nroFamilia + "/asistidos";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el asistido: " + e.getMessage());
            redirectAttributes.addFlashAttribute("asistido", asistido);
            return "redirect:/familias/" + nroFamilia + "/asistidos/editar/" + asistidoId;
        }
    }


    @GetMapping("/eliminar/{asistidoId}")
    public String eliminarAsistido(@PathVariable int nroFamilia, @PathVariable int asistidoId, RedirectAttributes redirectAttributes) {
        try {
            asistidoService.eliminarAsistido(asistidoId);
            redirectAttributes.addFlashAttribute("mensaje", "Asistido eliminado lógicamente con éxito!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar el asistido: " + e.getMessage());
        }
        return "redirect:/familias/" + nroFamilia + "/asistidos";
    }
}
