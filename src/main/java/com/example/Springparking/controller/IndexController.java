package com.example.Springparking.controller;

import com.example.Springparking.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    ClientService servicio;

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo) {
        modelo.addAttribute("empl", servicio.getAllClients());
        return "inicio";
    }

    @GetMapping("/inicio")
    public String verInicio(){
        return "inicio";
    }

}
