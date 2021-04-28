package com.musicDB.rest.controller;

import com.musicDB.entity.User;
import com.musicDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/auth/login", produces = "text/html")
    public String login(Model model) {
        model.addAttribute("user", new User());

        return "login.jsp";
    }

    @GetMapping(value = "/auth/signup", produces = "text/html")
    public String signupForm(Model model) {
        model.addAttribute("user", new User());

        return "signup.jsp";
    }

    @PostMapping("/auth/signup")
    public String signup(@Valid @ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/auth/signup.jsp";
        } else {
            model.addAttribute("user", userService.register(user));
        }

        return "redirect:/auth/login.jsp";
    }
}
