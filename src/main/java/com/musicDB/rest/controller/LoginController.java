package com.musicDB.rest.controller;

import com.musicDB.entity.User;
import com.musicDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/auth/registro")
    public String registroForm(Model model) {
        model.addAttribute("usuario", new User());

        return "registro";
    }

    @PostMapping("/auth/registro")
    public String registro(@Valid @ModelAttribute User usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/auth/registro";
        } else {
            model.addAttribute("usuario", userService.register(usuario));
        }

        return "redirect:/auth/login";
    }
}
