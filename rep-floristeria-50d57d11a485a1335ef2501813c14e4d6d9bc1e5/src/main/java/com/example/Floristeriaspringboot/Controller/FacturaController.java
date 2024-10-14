package com.example.Floristeriaspringboot.Controller;

import com.example.Floristeriaspringboot.Entities.FacturaEntity;
import com.example.Floristeriaspringboot.Service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/facturas")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @GetMapping("/listar")
    public String listarFacturas(Model model) {
        List<FacturaEntity> facturas = facturaService.findAll();
        System.out.println("Facturas encontradas: " + facturas.size()); // Verifica cuántas facturas se obtienen
        model.addAttribute("facturas", facturas);
        return "listar_facturas"; // Asegúrate de tener una plantilla listar_facturas.html
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistrar(Model model) {
        model.addAttribute("factura", new FacturaEntity());
        return "registrar_factura"; // Asegúrate de tener una plantilla registrar_factura.html
    }

    @PostMapping("/guardar")
    public String guardarFactura(@ModelAttribute("factura") FacturaEntity factura, Model model) {
        facturaService.addFactura(factura);
        return "redirect:/facturas/listar";
    }


}