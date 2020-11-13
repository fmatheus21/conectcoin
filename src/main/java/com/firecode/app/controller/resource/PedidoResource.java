package com.firecode.app.controller.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pedidos")
public class PedidoResource {

    @GetMapping
    public String readerPedido(Model model) {
        model.addAttribute("pageTitle", "Pedidos");
        model.addAttribute("headerTitle", "Meus Pedidos");
        return "app/page/pedido/pedidos";
    }

    @GetMapping("/{id}")
    public String openUpdate(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {
        model.addAttribute("pageTitle", "Pedido");
        model.addAttribute("headerTitle", "Pedido");
            return "app/page/pedido/pedido";
    }

}
