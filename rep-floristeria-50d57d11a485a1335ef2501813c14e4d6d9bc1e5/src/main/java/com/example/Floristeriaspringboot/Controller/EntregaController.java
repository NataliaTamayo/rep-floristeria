package com.example.Floristeriaspringboot.Controller;

import com.example.Floristeriaspringboot.Entities.EntregaEntity;
import com.example.Floristeriaspringboot.Service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/entregas")
public class EntregaController {
    @Autowired
    private EntregaService entregaService;

    @GetMapping("/listar")
    public String listarEntregas(Model model) {
        List<EntregaEntity> entregas = entregaService.findAll();
        model.addAttribute("entregas", entregas);
        return "listar_entregas"; // Asegúrate de tener una plantilla listar_entregas.html
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistrar(Model model) {
        model.addAttribute("entrega", new EntregaEntity());
        return "registrar_entrega"; // Asegúrate de tener una plantilla registrar_entrega.html
    }

    @PostMapping("/guardar")
    public String guardarEntrega(@ModelAttribute("entrega") EntregaEntity entrega, Model model) {
        entregaService.addEntrega(entrega);
        return "redirect:/entregas/listar";
    }
}