package com.example.Springparking.controller;



import com.example.Springparking.entity.Client;
import com.example.Springparking.repository.GarageRepository;
import com.example.Springparking.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    GarageRepository garageRepository;


    @GetMapping("/clientForm")
    public String clientForm(Model model){
        model.addAttribute("clientForm", new Client());
        model.addAttribute("clientList", clientService.getAllClients());
        model.addAttribute("garage",garageRepository.findAll());
        model.addAttribute("listTab","active");
        return "client/client-view";
    }

    @PostMapping("/clientForm")
    public String crearClient(@ModelAttribute("clientForm")Client client, BindingResult result, Model model) throws Exception {
        clientService.createClient(client);
        model.addAttribute("clientForm", new Client());
        model.addAttribute("listTab","active");
        model.addAttribute("garage",garageRepository.findAll());

        model.addAttribute("clientList", clientService.getAllClients());

        return "redirect:/clientForm";
    }
}
