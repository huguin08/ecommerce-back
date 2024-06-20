package com.example.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BienvenidaController {

    @GetMapping("/bienvenida")
    public String getBienvenida() {
        return "Bienvenido";
    }

    @GetMapping("/version")
    public String getVersion() {
        return "v1.0.0";
    }
}
