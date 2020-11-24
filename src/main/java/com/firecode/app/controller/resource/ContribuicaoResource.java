package com.firecode.app.controller.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/app/contribuicao")
public class ContribuicaoResource {

    @GetMapping 
    public String readerContribuicao(Model model) {
        model.addAttribute("pageTitle", "Minhas Contribuições");
        model.addAttribute("headerTitle", "Minhas Contribuições");
        return "app/page/contribuicao/contribuicao"; 
    } 

}
