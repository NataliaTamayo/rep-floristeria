package com.example.Floristeriaspringboot.Controller;

import com.example.Floristeriaspringboot.Entities.FlorEntity;
import com.example.Floristeriaspringboot.Service.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/flores")
public class FlorController {

    // Inyección de dependencia de FlorService
    @Autowired
    private FlorService florService;

    // Método para listar todas las flores
    @GetMapping("/listar")
    public String listarFlores(Model model) {
        try {
            // Obtener todas las flores desde el servicio
            List<FlorEntity> flores = florService.findAll();
            model.addAttribute("flores", flores);
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error al listar las flores.");
            e.printStackTrace(); // Opcional: o usa logging en lugar de printStackTrace
        }
        // Devolver la vista "flores" (plantilla Thymeleaf)
        return "flores";
    }

    // Método para mostrar el formulario de registro de flores
    @GetMapping("/registrar")
    public String mostrarFormularioRegistrar(Model model) {
        // Agregar un nuevo objeto FlorEntity para el formulario
        model.addAttribute("flor", new FlorEntity());
        return "registrar"; // Asegúrate de que esta plantilla existe
    }

    // Método para manejar el registro de una nueva flor
    @PostMapping("/guardar")
    public String guardarFlor(@ModelAttribute("flor") FlorEntity flor, Model model) {
        try {
            // Guardar la nueva flor a través del servicio
            florService.addFlor(flor);
            // Redirigir al listado después de guardar
            return "redirect:/flores/listar";
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error al guardar la flor.");
            e.printStackTrace(); // Opcional: o usa logging en lugar de printStackTrace
            return "registrar";
        }
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        Optional<FlorEntity> flor = florService.getFlorById(id); // Asegúrate de que este método existe
        if (flor.isPresent()) {
            model.addAttribute("flor", flor.get());
            return "editar_flor"; // Asegúrate de tener una plantilla editar_flor.html
        }
        return "redirect:/flores/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarFlor(@PathVariable("id") Long id, @ModelAttribute("flor") FlorEntity florDetails) {
        florService.updateFlor(id, florDetails);
        return "redirect:/flores/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFlor(@PathVariable("id") Long id) {
        florService.deleteFlor(id);
        return "redirect:/flores/listar";
    }
}