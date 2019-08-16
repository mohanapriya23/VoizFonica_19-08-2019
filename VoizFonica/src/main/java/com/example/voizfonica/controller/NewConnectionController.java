package com.example.voizfonica.controller;

import com.example.voizfonica.data.NewConnectionRepository;
import com.example.voizfonica.data.RegisterRepository;
import com.example.voizfonica.model.NewConnection;
import com.example.voizfonica.model.Register;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@Document(collection = "newConnection")
@RequestMapping("/newconnection")
@SessionAttributes("newConnection")

public class NewConnectionController {


    private NewConnectionRepository newConnectionRepository;
    private final RegisterRepository registerRepository;

    @Autowired
    public NewConnectionController(RegisterRepository registerRepository,NewConnectionRepository newConnectionRepository) {
        this.registerRepository = registerRepository;
        this.newConnectionRepository = newConnectionRepository;
    }

    @ModelAttribute
    @GetMapping
    public String show_register(Model model){
        model.addAttribute("newConnection",new NewConnection());
        return "newconnection";
    }

/*
    @PostMapping
    public String processRegister(@Valid NewConnection newConnection, @ModelAttribute Register register, Errors errors) {
        if (errors.hasErrors()) {
            return "newConnection";
        }
        newConnectionRepository.save(newConnection);
        register.setNewConnection(newConnection);
        registerRepository.save(register);
        return "redirect:/newconnectionresult"; *//*success*//*
    }*/
@PostMapping
public String post(@Valid NewConnection newConnection, Errors errors, Model model){
    if (errors.hasErrors()) {
        return "newConnection";
    }
    newConnectionRepository.save(newConnection);
    model.addAttribute("newConnection",newConnection);

    return "newconnectionresult";
}
}
