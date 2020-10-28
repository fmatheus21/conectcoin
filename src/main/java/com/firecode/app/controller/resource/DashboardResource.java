package com.firecode.app.controller.resource;

import com.firecode.app.controller.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dashboard")
public class DashboardResource {

    @Autowired
    private GlobalService globalService;

    @GetMapping
    public String openDashboard(Model model) {
        globalService.returnGlobalModal(model);
        model.addAttribute("pageTitle", "Dashboard");
        model.addAttribute("formTitle", "Dashboard");

        return "app/page/dashboard";
    }

}
