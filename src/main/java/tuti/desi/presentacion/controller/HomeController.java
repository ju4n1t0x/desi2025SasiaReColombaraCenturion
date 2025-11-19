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

}