package com.musicDB.rest.controller;

import com.musicDB.service.UserService;
import com.musicDB.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/private")
public class PrivateController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String index(Authentication auth, HttpSession session) {

        String username = auth.getName();

        if (session.getAttribute("user") == null) {
            User user = userService.findByUsername(username);
            user.setPassword(null);
            session.setAttribute("user", user);
        }

        return "index";
    }


}
