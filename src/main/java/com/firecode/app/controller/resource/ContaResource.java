package com.firecode.app.controller.resource;

import com.firecode.app.controller.rule.ContaRule;
import com.firecode.app.controller.rule.GlobalRule;
import com.firecode.app.controller.security.AppUserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/app/conta")
public class ContaResource {

    @Autowired
    private GlobalRule globalRule;

    @Autowired
    private ContaRule contaRule;

    @GetMapping("/perfil")
    public String openPerfil(Model model, @AuthenticationPrincipal AppUserSecurity appUserSecurity) {
        globalRule.model(model, appUserSecurity);
        model.addAttribute("pageTitle", "Meus Dados");
        model.addAttribute("headerTitle", "Meus Dados");
        model.addAttribute("modelGeneros", contaRule.listarGeneros());
        model.addAttribute("modelPerfil", contaRule.carregaClienteLogado(appUserSecurity));

        return "app/page/conta/perfil";
    }

    @GetMapping("/{id}")
    public String openView(@PathVariable("id") int id, RedirectAttributes attributes, Model model) {
        model.addAttribute("pageTitle", "Pedido");
        model.addAttribute("headerTitle", "Pedido");
        return "app/page/pedido/pedido";
    }

}
