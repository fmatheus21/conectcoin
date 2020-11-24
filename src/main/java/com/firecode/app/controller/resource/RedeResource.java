package com.firecode.app.controller.resource;

import com.firecode.app.controller.rule.RedeRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/app/redes")
public class RedeResource {

    @Autowired
    private RedeRule redeRule;

    @GetMapping("/indicados")
    public String readerIndicado(Model model) {
        model.addAttribute("pageTitle", "Meus Indicados");
        model.addAttribute("headerTitle", "Meus Indicados");
        model.addAttribute("modelIndicados", redeRule.listIndicated());
        return "app/page/rede/indicados";
    }
    
     @GetMapping("/unilateral")
    public String readerUnilateral(Model model) {
        model.addAttribute("pageTitle", "Rede Unilateral");
        model.addAttribute("headerTitle", "Rede Unilateral");
        model.addAttribute("modelIndicados", redeRule.listIndicated());
        return "app/page/rede/unilateral";
    }

    @GetMapping("/{id}")
    public String openView(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {
        model.addAttribute("pageTitle", "Pedido");
        model.addAttribute("headerTitle", "Pedido");
        return "app/page/rede/pedido";
    }

}
