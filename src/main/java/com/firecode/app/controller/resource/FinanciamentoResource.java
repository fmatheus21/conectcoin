package com.firecode.app.controller.resource;

import com.firecode.app.controller.rule.FinanciamentoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/financiamento")
public class FinanciamentoResource {

    @Autowired
    private FinanciamentoRule financiamentoRule;

    @GetMapping("/pagamentos")
    public String openViewBalance(Model model) {
        model.addAttribute("pageTitle", "Programação de Pagamentos");
        model.addAttribute("headerTitle", "Programação de Pagamentos");
        model.addAttribute("modelPagamentos", financiamentoRule.listPaymentSchedule());
        return "app/page/financiamento/programacao-pagamento";
    }

}
