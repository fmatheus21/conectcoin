package com.firecode.app.controller.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/carreira")
public class CarreiraResource {

    @GetMapping("/plano")
    public String readerContribuicao(Model model) {
        model.addAttribute("pageTitle", "Plano de Carreira");
        model.addAttribute("headerTitle", "Plano de Carreira");
        return "app/page/carreira/plano";
    }

}
