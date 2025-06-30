package tuti.desi.presentacion.controller;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tuti.desi.entidades.Familia;
import tuti.desi.entidades.Preparacion;
import tuti.desi.presentacion.models.EntregaAsistenciaModel;

import tuti.desi.presentacion.models.FamiliaModel;
import tuti.desi.presentacion.models.PreparacionModel;
import tuti.desi.services.entregaAsistencia.EntregaAsistenciaService;
import tuti.desi.services.familia.FamiliaService;
import tuti.desi.services.preparacion.PreparacionService;

@Controller
public class EntregaAsistenciaController {
    
    @Autowired
    private EntregaAsistenciaService entregaAsistenciaService;
    
    @Autowired
    private FamiliaService familiaService;
    
    @Autowired
    private PreparacionService preparacionService;
    
    // ✅ Eliminar constructor manual - @Autowired se encarga de la inyección
    
    @GetMapping("/entrega/altaEntrega")
    public String altaEntrega(Model model) {
        // Crear nuevo model para el formulario
        model.addAttribute("entrega", new EntregaAsistenciaModel());
        cargarDatosParaFormulario(model);

        return "entrega/altaEntrega";
    }

    @PostMapping("/guardarEntrega")
    public String guardarEntrega(@Valid @ModelAttribute("entrega") EntregaAsistenciaModel entregaAsistenciaModel,
                                 BindingResult bindingResult, Model model) {

        // Si hay errores de validación de entrada (campos nulos, formato incorrecto, etc.)
        if (bindingResult.hasErrors()) {
            // Se vuelve a cargar los datos necesarios para los <select> del formulario
            cargarDatosParaFormulario(model);
            return "entrega/altaEntrega"; // Vuelve a mostrar el formulario con los errores
        }

        try {
            // Si la validación de entrada es correcta, se intenta guardar
            EntregaAsistenciaModel entregaGuardada = entregaAsistenciaService.save(entregaAsistenciaModel);
            model.addAttribute("entrega", entregaGuardada);
            return "entrega/entregaGuardada";

        } catch (IllegalArgumentException | EntityNotFoundException e) {
            // Si el servicio lanza una excepción de negocio (ej: "No hay stock")
            model.addAttribute("errorMessage", e.getMessage()); // Añade el mensaje de error al modelo
            // Se vuelve a cargar los datos necesarios para los <select> del formulario
            cargarDatosParaFormulario(model);
            return "entrega/altaEntrega"; // Vuelve a mostrar el formulario con el error de negocio
        }
    }


    private void cargarDatosParaFormulario(Model model){
        List<PreparacionModel> preparacionesDelDiaConStock = preparacionService.findPreparacionesDelDiaConStock();
        model.addAttribute("preparaciones", preparacionesDelDiaConStock);

        // Obtener todas las familias a través del service
        List<FamiliaModel> listaFamilias = entregaAsistenciaService.findAllFamilias();
        model.addAttribute("listaFamilias", listaFamilias);
    }
   
}

