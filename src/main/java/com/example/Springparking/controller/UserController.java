package com.example.Springparking.controller;


import com.example.Springparking.entity.User;
import com.example.Springparking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {



    @Autowired
    UserService userService;

    @GetMapping("/userForm")
    public String userForm(Model model) {
        model.addAttribute("userForm", new User());
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("listTab", "active");
        return "user/user-view";
    }

    @PostMapping("/userForm")
    public String createUser(@ModelAttribute("userForm")User user,
                             BindingResult result, Model model) throws Exception {
        userService.createUser(user);
        model.addAttribute("userForm", new User());
        model.addAttribute("listTab","active");

        model.addAttribute("userList", userService.getAllUsers());
        return "user/user-view";
    }
    @GetMapping("/editUser/{id}")
    public String getEditUserForm(Model model, @PathVariable(name="id") Long id) throws Exception {
        User user = userService.getUserByid(id);
        model.addAttribute("userForm", user);
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("formTab","active");
        model.addAttribute("editMode",true);
        return "user/user-view";
    }
    @PostMapping("/editUser")
    public String postEditUserForm(@ModelAttribute("userForm")User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("userForm", user);
            model.addAttribute("formTab","active");
            model.addAttribute("editMode","true");
        }else {
            try {
                userService.updateUser(user);
                model.addAttribute("userForm", new User());
                model.addAttribute("listTab","active");
            } catch (Exception e) {
                model.addAttribute("formErrorMessage",e.getMessage());
                model.addAttribute("userForm", user);
                model.addAttribute("formTab","active");
                model.addAttribute("userList", userService.getAllUsers());
                model.addAttribute("editMode","true");
            }
        }
        model.addAttribute("userList", userService.getAllUsers());
        return "redirect:/userForm";

    }
    @GetMapping("/userForm/cancel")
    public String cancelEditUser(Model model) {
        return "redirect:/userForm";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(Model model, @PathVariable(name="id") Long id) {
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            model.addAttribute("deleteError","The user could not be deleted.");
        }
        return userForm(model);
    }

}

