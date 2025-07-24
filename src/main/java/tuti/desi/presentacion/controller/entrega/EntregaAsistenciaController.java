package tuti.desi.presentacion.controller.entrega;

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
import org.springframework.web.bind.annotation.RequestMapping;
import tuti.desi.dao.IFamiliaRepo;
import tuti.desi.presentacion.models.EntregaAsistenciaModel;

import tuti.desi.presentacion.models.FamiliaModel;
import tuti.desi.presentacion.models.PreparacionModel;
import tuti.desi.services.entregaAsistencia.EntregaAsistenciaService;
import tuti.desi.services.familia.FamiliaService;
import tuti.desi.services.preparacion.PreparacionService;

@Controller@Valid
@RequestMapping("/entrega")
public class EntregaAsistenciaController {
    
    @Autowired
    private EntregaAsistenciaService entregaAsistenciaService;
    
    @Autowired
    private FamiliaService familiaService;
    
    @Autowired
    private PreparacionService preparacionService;


    // ✅ Eliminar constructor manual - @Autowired se encarga de la inyección
    
    @GetMapping("/mostrarFormulario")
    public String altaEntrega(Model model) {
        // Crear nuevo model para el formulario
        model.addAttribute("entrega", new EntregaAsistenciaModel());
        cargarDatosParaFormulario(model);

        return "entrega/mostrarFormulario";
    }

    @PostMapping("/guardarEntrega")
    public String guardarEntrega(@Valid @ModelAttribute("entrega") EntregaAsistenciaModel entregaAsistenciaModel,
                                 BindingResult bindingResult, Model model) {


        if (bindingResult.hasErrors()) {
            System.out.println("estoy en el binding result");

            cargarDatosParaFormulario(model);
            return "entrega/mostrarFormulario";

        }

        try {
            FamiliaModel familia = familiaService.findFamilia(entregaAsistenciaModel.getNroFamilia());
            PreparacionModel preparacion = preparacionService.findPreparacion(entregaAsistenciaModel.getIdPreparacion());
            entregaAsistenciaModel.setFamilia(familia);
            entregaAsistenciaModel.setPreparacion(preparacion);
            EntregaAsistenciaModel entregaGuardada = entregaAsistenciaService.save(entregaAsistenciaModel);
            model.addAttribute("entrega", entregaGuardada);
            return "entrega/entregaGuardada";

        } catch (IllegalArgumentException | EntityNotFoundException e) {


            model.addAttribute("errorMessage", e.getMessage()); // Añade el mensaje de error al modelo

            cargarDatosParaFormulario(model);
            return "entrega/mostrarFormulario"; // Vuelve a mostrar el formulario con el error de negocio
        }
    }


    private void cargarDatosParaFormulario(Model model){
        List<PreparacionModel> preparacionesDelDiaConStock = preparacionService.findPreparacionesDelDiaConStock();
        System.out.println("numero de preparaciones encontradas para hoy con stock: " + preparacionesDelDiaConStock.size());
        model.addAttribute("preparaciones", preparacionesDelDiaConStock);

        // Obtener todas las familias a través del service
        List<FamiliaModel> listaFamilias = entregaAsistenciaService.findAllFamilias();
        model.addAttribute("listaFamilias", listaFamilias);
    }

   
}

