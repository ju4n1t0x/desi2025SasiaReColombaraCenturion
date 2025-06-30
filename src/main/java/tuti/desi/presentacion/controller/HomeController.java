package tuti.desi.presentacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping({ "index", "" })
    public String index() {
        return "index";
    }

    @GetMapping("/familia/altaFamilia")
    public String altaFamilia() {
        return "familia/altaFamilia";
    }

    @GetMapping("/familia/eliminacionFamilia")
    public String eliminacionFamilia() {
        return "familia/eliminacionFamilia";
    }

    @GetMapping("/familia/modificacionFamilia")
    public String modificacionFamilia() {
        return "familia/modificacionFamilia";
    }

    @GetMapping("/familia/listadoFamilia")
    public String listadoFamilia() {
        return "familia/listadoFamilia";
    }
    
    
    //receta
    @GetMapping("/receta/altaReceta")
    public String altaReceta() {
        return "receta/altaReceta";
    }

    @GetMapping("/receta/eliminacionReceta")
    public String eliminacionReceta() {
        return "receta/eliminacionReceta";
    }

    @GetMapping("/receta/modificacionReceta")
    public String modificacionReceta() {
        return "receta/modificacionReceta";
    }

    @GetMapping("/receta/listadoReceta")
    public String listadoReceta() {
    	return "receta/listadoReceta";
    }
    
    //PREPARACION
    @GetMapping("/preparaciones/altaPreparacion")
    public String altaPreparacion() {
        return "preparaciones/altaPreparacion";
    }

    @GetMapping("/preparaciones/eliminacionPreparacion")
    public String eliminacionPreparacion() {
        return "preparaciones/eliminacionPreparacion";
    }

    @GetMapping("/preparaciones/modificacionPreparacion")
    public String modificacionPreparacion() {
        return "preparaciones/modificacionPreparacion";
    }

    @GetMapping("/preparaciones/listadoPreparacion")
    public String listadoPrepracion() {
        return "preparaciones/listadoPreparacion";
    }
    
    //Entrega
    
    
    @GetMapping("/entrega/eliminacionEntrega")
    public String eliminacionEntrega() {
        return "entrega/eliminacionEntrega";
    }
    
    @GetMapping("/entrega/listadoEntrega")
    public String listadoEntrega() {
        return "listadoFamiliasAsistidas";
    }
}