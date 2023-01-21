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
import org.springframework.web.bind.annotation.PathVariable;
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

        return "client/client-view";
    }

    @GetMapping("/editClient/{id}")
    public String getEditUserForm(Model model, @PathVariable(name="id") Long id) throws Exception {
        Client client = clientService.getUserById(id);

        model.addAttribute("clientForm", client);
        model.addAttribute("clientList", clientService.getAllClients());
        model.addAttribute("garage",garageRepository.findAll());
        model.addAttribute("formTab","active");


        model.addAttribute("editMode",true);//Mira siguiente seccion para mas informacion

        return "client/client-view";
    }

    @PostMapping("/editClient")
    public String postEditUserForm(@ModelAttribute("clientForm")Client client, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("clientForm", client);
            model.addAttribute("formTab","active");
            model.addAttribute("editMode","true");
        }else {
            try {
                clientService.updateClient(client);
                model.addAttribute("clientForm", new Client());
                model.addAttribute("listTab","active");
            } catch (Exception e) {
                model.addAttribute("formErrorMessage",e.getMessage());
                model.addAttribute("clientForm", client);
                model.addAttribute("formTab","active");
                model.addAttribute("clientList", clientService.getAllClients());
                model.addAttribute("garage",garageRepository.findAll());
                model.addAttribute("editMode","true");
            }
        }

        model.addAttribute("clientList", clientService.getAllClients());
        model.addAttribute("garage",garageRepository.findAll());
        return "redirect:/clientForm";

    }

    @GetMapping("/clientForm/cancel")
    public String cancelEditUser(Model model) {
        return "redirect:/clientForm";
    }


    @GetMapping("/deleteClient/{id}")
    public String deleteClient(Model model, @PathVariable(name="id") Long id) {
        try {
            clientService.deleteClient(id);
        } catch (Exception e) {
            model.addAttribute("deleteError","The user could not be deleted.");
        }
        return clientForm(model);
    }
}
