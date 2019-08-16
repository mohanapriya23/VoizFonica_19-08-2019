package com.example.voizfonica.controller;

import com.example.voizfonica.model.Login;
import com.example.voizfonica.model.Order;
import com.example.voizfonica.model.Register;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"order","login"})
@RequestMapping("/dashboard")
public class DashboardController {
    @GetMapping
    public String show_dashboard(Model model, @SessionAttribute("register")Register register, Order order){
        model.addAttribute("register",register);
        model.addAttribute("order",order);
        System.out.println(model);
        return "dashboard";
    }
}
