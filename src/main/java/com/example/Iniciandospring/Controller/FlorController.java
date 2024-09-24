package com.example.Iniciandospring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value = "/flores")

public class FlorController {

@GetMapping("/listar")
public String listarFlores(){
    return "listar";

}

@GetMapping("/registrar")
public String registrarFlores(){
    return "registrar";
}
}
