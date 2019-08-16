package com.example.voizfonica.controller;


import com.example.voizfonica.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller

@RequestMapping("/invoice1")
public class Invoice1Controller {
    @GetMapping
    public String show_invoice1(Model model, @SessionAttribute("order") Order order){
        model.addAttribute("order",order);
        return "invoice1";
    }

}
