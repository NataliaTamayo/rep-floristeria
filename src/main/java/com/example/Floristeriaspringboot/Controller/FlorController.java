
package com.example.Floristeriaspringboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Floristeriaspringboot.Entities.FlorEntity;
import com.example.Floristeriaspringboot.Service.FlorService;

@Controller
@RequestMapping("/flores")
public class FlorController {

    // Inyección de dependencia de FlorService
    @SuppressWarnings("rawtypes")
    @Autowired
    private FlorService florService;

    // Método para listar todas las flores
    @GetMapping("/listar")
    public String listarFlores(Model model) {
        try {
            // Obtener todas las flores desde el servicio
            @SuppressWarnings("unchecked")
            List<FlorEntity> flores = florService.findAll();
            model.addAttribute("flores", flores);
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error al listar las flores.");
        }
        // Devolver la vista "flores" (plantilla Thymeleaf)
        return "flores";
    }

    // Método para mostrar el formulario de registro de flores
    @GetMapping("/registrar")
    public String mostrarFormularioRegistrar(Model model) {
        // Agregar un nuevo objeto FlorEntity para el formulario
        model.addAttribute("flor", new FlorEntity());
        return "registrar";
    }

    // Método para manejar el registro de una nueva flor
    @PostMapping("/guardar")
    public String guardarFlor(@ModelAttribute("flor") FlorEntity flor, Model model) {
        try {
            // Guardar la nueva flor a través del servicio
            florService.save(flor);
            // Redirigir al listado después de guardar
            return "redirect:/flores/listar";
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error al guardar la flor.");
            return "registrar";
        }
    }
}
