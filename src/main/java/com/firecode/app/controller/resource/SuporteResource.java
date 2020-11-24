package com.firecode.app.controller.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/suporte")
public class SuporteResource {

    @GetMapping("/tickets")
    public String readerTicket(Model model) {
        model.addAttribute("pageTitle", "Meus Tickets");
        model.addAttribute("headerTitle", "Meus Tickets");
        return "app/page/suporte/tickets";
    }
    
     @GetMapping("/tickets/create")
    public String createTicket(Model model) {
        model.addAttribute("pageTitle", "Novo Ticket");
        model.addAttribute("headerTitle", "Novo Ticket");
        return "app/page/suporte/ticket";
    }

}
