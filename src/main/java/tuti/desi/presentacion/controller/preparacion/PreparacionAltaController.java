package tuti.desi.presentacion.controller.preparacion;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tuti.desi.entidades.Preparacion;
import tuti.desi.presentacion.models.PreparacionModel;
import tuti.desi.services.preparacion.PreparacionService;
import tuti.desi.services.receta.RecetaService;

import java.util.Objects;

@Controller
@Valid
@RequestMapping("/preparaciones")
public class PreparacionAltaController {

    @Autowired
    private PreparacionService preparacionService;

    @Autowired
    private RecetaService recetaService;

    @GetMapping("/altaPreparacion")
    public String altaPreparacion(Model model) {
        // Crear nuevo model para el formulario
        model.addAttribute("preparacion", new PreparacionModel());
        model.addAttribute("recetas", recetaService.findAll());
        return "preparaciones/altaPreparacion";
    }

    @PostMapping("/altaPreparacion")
    public String procesarAltaPreparacion(
            @Valid @ModelAttribute("preparacion") PreparacionModel preparacionModel,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes) {
        System.out.println("entrando al controller");
        // Si hay errores de validación, volver al formulario
        System.out.println("contiene errores" + result.hasErrors());
        System.out.println("contiene errores" + result.getAllErrors());

        if (result.hasErrors()) {
            // Volver a cargar las recetas para el select
            model.addAttribute("recetas", recetaService.findAll());
            return "preparaciones/altaPreparacion";
        }
        System.out.println("antes del try");
        try {

            //Validamos que no haya recetas del mismo
            java.sql.Date fecha = preparacionModel.getFechaCoccion();
            Integer recetaId = preparacionModel.getRecetaId();
            boolean existe = preparacionService.findByFechaCoccionAndActivoTrue(fecha)
                    .stream()
                    .anyMatch(p -> Objects.equals(p.getReceta().getId(), recetaId));
            if (existe) {
                model.addAttribute("mensaje", "Ya existe una preparación para esta receta en la fecha seleccionada.");
                model.addAttribute("tipoMensaje", "danger");
                model.addAttribute("recetas", recetaService.findAll());
                return "preparaciones/altaPreparacion";
            }

            // Guardar la preparación
            System.out.println("antes del save");
            preparacionService.save(preparacionModel);

            // Mensaje de éxito
            redirectAttributes.addFlashAttribute("mensaje", "Preparación agregada exitosamente");
            redirectAttributes.addFlashAttribute("tipoMensaje", "success");

            // Redireccionar para evitar reenvío del formulario
            return "redirect:/preparaciones/altaPreparacion";

        } catch (Exception e) {
            // En caso de error
            model.addAttribute("mensaje", "Error al guardar la preparación: " + e.getMessage());
            model.addAttribute("tipoMensaje", "danger");
            model.addAttribute("recetas", recetaService.findAll());
            return "preparaciones/altaPreparacion";
        }
    }
}
