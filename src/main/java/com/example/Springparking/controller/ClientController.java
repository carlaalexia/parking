package com.example.Springparking.controller;



import com.example.Springparking.entity.Client;
import com.example.Springparking.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ClientController {

    @Autowired
    ClientService clientService;


    @GetMapping("/clientForm")
    public String clientForm(Model model){
        model.addAttribute("clientForm", new Client());
        model.addAttribute("clientList", clientService.getAllClients());
        model.addAttribute("listTab","active");
        return "client/client-view";
    }

    @PostMapping("/clientForm")
    public String crearClient(@Valid @ModelAttribute("clientForm")Client client, BindingResult result, Model model){
        if(result.hasErrors()) {
            model.addAttribute("clientForm", client);
            model.addAttribute("formTab","active");
        }else {
            try {
                clientService.createClient(client);
                model.addAttribute("clientForm", new Client());
                model.addAttribute("listTab","active");
            } catch (Exception e) {
                model.addAttribute("formError",e.getMessage());
                model.addAttribute("clientForm", client);
                model.addAttribute("formTab","active");
                model.addAttribute("clientList", clientService.getAllClients());


            }
        }

        model.addAttribute("clientList", clientService.getAllClients());

        return "client/client-view";
    }
}
