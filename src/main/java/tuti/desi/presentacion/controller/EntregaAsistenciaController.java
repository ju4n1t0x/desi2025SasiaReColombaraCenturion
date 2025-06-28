package tuti.desi.presentacion.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import tuti.desi.entidades.Familia;
import tuti.desi.entidades.Preparacion;
import tuti.desi.presentacion.models.EntregaAsistenciaModel;

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
        

        List<Preparacion> preparacionesDelDia = preparacionService.getAll();
        model.addAttribute("preparaciones", preparacionesDelDia);
        
        // Obtener todas las familias a través del service
        List<Familia> familias = familiaService.getAll();
        model.addAttribute("familias", familias); 
        
        return "entrega/altaEntrega";
    }


    
   
}

