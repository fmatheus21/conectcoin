package com.firecode.app.controller.resource;

import com.firecode.app.controller.rule.FinanceiroRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/financeiro")
public class FinanceiroResource {

    @Autowired
    private FinanceiroRule financeiroRule;

    @GetMapping("/saldo")
    public String openViewBalance(Model model) {
        model.addAttribute("pageTitle", "Saldo Resumido");
        model.addAttribute("headerTitle", "Saldo Resumido");
        return "app/page/financeiro/saldo";
    }

    @GetMapping("/extrato")
    public String openReaderExtrato(Model model) {
        model.addAttribute("pageTitle", "Extrato Detalhado");
        model.addAttribute("headerTitle", "Extrato Detalhado");
        model.addAttribute("modelExtratos", financeiroRule.listExtract());
        return "app/page/financeiro/extrato";
    }

    @GetMapping("/saques")
    public String openReaderWithdraw(Model model) {
        model.addAttribute("pageTitle", "Solicitações de Saque");
        model.addAttribute("headerTitle", "Solicitações de Saque");
        model.addAttribute("modelSaques", financeiroRule.listWithdraw());
        return "app/page/financeiro/saques";
    }

    @GetMapping("/pagar")
    public String openReaderPay(Model model) {
        model.addAttribute("pageTitle", "Pagar Pedido com Saldo");
        model.addAttribute("headerTitle", "Pagar Pedido com Saldo");
        return "app/page/financeiro/pagar-pedido-saldo";
    }

}
