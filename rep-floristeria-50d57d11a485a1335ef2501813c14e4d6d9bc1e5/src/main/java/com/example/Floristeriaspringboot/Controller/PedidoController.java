package com.example.Floristeriaspringboot.Controller;

import com.example.Floristeriaspringboot.Entities.FlorEntity;
import com.example.Floristeriaspringboot.Entities.PedidoEntity;
import com.example.Floristeriaspringboot.Service.FlorService;
import com.example.Floristeriaspringboot.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private FlorService florService;

    @GetMapping("/listar")
    public String listarPedidos(Model model) {
        List<PedidoEntity> pedidos = pedidoService.findAll();
        model.addAttribute("pedidos", pedidos);
        return "listar_pedidos"; // Asegúrate de tener una plantilla listar_pedidos.html
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistrar(Model model) {
        model.addAttribute("pedido", new PedidoEntity());
        List<FlorEntity> flores = florService.findAll();
        model.addAttribute("flores", flores);
        return "pedidos_registrar"; // Nombre de la vista Thymeleaf
    }

    @PostMapping("/guardar")
    public String guardarPedido(@ModelAttribute("pedido") PedidoEntity pedido, Model model) {
        try {
            pedidoService.addPedido(pedido);
            return "redirect:/pedidos/listar"; // Redirigir a la lista de pedidos
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error al guardar el pedido.");
            return "pedidos_registrar"; // Volver al formulario en caso de error
        }
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        PedidoEntity pedido = pedidoService.findById(id); // Necesitas implementar findById en PedidoService
        List<FlorEntity> flores = florService.findAll();
        model.addAttribute("pedido", pedido);
        model.addAttribute("flores", flores);
        return "pedidos_editar"; // Asegúrate de tener esta vista
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarPedido(@PathVariable Long id, @ModelAttribute("pedido") PedidoEntity pedido) {
        // Lógica para actualizar el pedido
        pedidoService.updatePedido(id, pedido); // Necesitas implementar updatePedido en PedidoService
        return "redirect:/pedidos/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPedido(@PathVariable Long id) {
        pedidoService.deletePedido(id); // Necesitas implementar deletePedido en PedidoService
        return "redirect:/pedidos/listar";
    }
}
