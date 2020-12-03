package com.firecode.app.controller.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/authentication")
public class AutenticationResource {

    @GetMapping
    public String openLogin(Model model) {
        model.addAttribute("pageTitle", "Login");
        model.addAttribute("headerTitle", "Login");

        return "app/login";
    }

}
