package com.example.voizfonica.controller;

import com.example.voizfonica.model.NewConnection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/newconnectionresult")
@SessionAttributes("newConnection")
public class newConnectionResultController {

    @ModelAttribute
    @GetMapping
    public String show(Model model, @SessionAttribute("newConnection") NewConnection newConnection){

        model.addAttribute("newConnection",new NewConnection());
        return "newconnectionresult";
    }

}
