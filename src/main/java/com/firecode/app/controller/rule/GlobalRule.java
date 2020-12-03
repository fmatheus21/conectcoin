package com.firecode.app.controller.rule;

import com.firecode.app.controller.security.AppUserSecurity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class GlobalRule {

    public Model model(Model model, AppUserSecurity appUserSecurity) {
        model.addAttribute("footerLink", "https://firecodesystems.com");
        model.addAttribute("footerName", "Firecode Systems");
        model.addAttribute("loggedUser", appUserSecurity);
        model.addAllAttributes(this.listUrl(model));
        return model;
    }

    private Collection<Model> listUrl(Model model) {
        List<Model> list = new ArrayList<>();
        model.addAttribute("dashboard", "/app/dashboard");
        model.addAttribute("pagamentos", "/app/financiamentos/pagamentos");
        model.addAttribute("contribuicoes", "/app/contribuicoes");
        model.addAttribute("pedidos", "/app/pedidos");
        model.addAttribute("indicados", "/app/redes/indicados");
        model.addAttribute("unilateral", "/app/redes/unilateral");
        model.addAttribute("saldos", "/app/financeiro/saldos");
        model.addAttribute("extratos", "/app/financeiro/extratos");
        model.addAttribute("saques", "/app/financeiro/saques");
        model.addAttribute("pagar", "/app/financeiro/pagar");
        model.addAttribute("plano", "/app/carreira/plano");
        model.addAttribute("tickets", "/app/suporte/tickets");
        model.addAttribute("perfil", "/app/conta/perfil");
        model.addAttribute("endereco", "/app/conta/endereco");
        model.addAttribute("senha", "/app/conta/senha");
        model.addAttribute("google", "/app/conta/google/autenticacao");
        model.addAttribute("sair", "/app/logout");

        list.add(model);

        return list;
    }

}
