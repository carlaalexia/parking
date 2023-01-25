package com.example.Springparking.controller;


import com.example.Springparking.service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UsuarioController {


    @Autowired
    UsuarioServicio usuarioServicio;


    @GetMapping("/userForm")
    public String userForm(Model model) {
        model.addAttribute("userList", usuarioServicio.listarUsuarios());
        model.addAttribute("listTab", "active");
        return "user/user-view";
    }




}

