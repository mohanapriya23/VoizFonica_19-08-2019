package com.example.voizfonica.controller;


import com.example.voizfonica.model.Register;
import com.example.voizfonica.data.RegisterRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@NoArgsConstructor(force = true)
@RequestMapping("/register")

public class RegisterController {
    private RegisterRepository registerRepo;

    @Autowired
    public RegisterController(RegisterRepository registerRepo) {
        this.registerRepo = registerRepo;
    }
    @Autowired
    private JavaMailSender javaMail;


    @GetMapping
    public String registerForm(Model model) {
        model.addAttribute("register", new Register());
        return "register";
    }

    @PostMapping
    public String registerValid(@Valid Register register, Errors errors,
                                SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "register";
        }

        SimpleMailMessage msg=new SimpleMailMessage();
        msg.setTo(register.getEmail());
        msg.setSubject("WELCOME TO VOIZFONICA");
        msg.setText("Hi "+register.getName()+", thanks for joining VoizFonica!!!");
        javaMail.send(msg);
        registerRepo.save(register);
        sessionStatus.setComplete();
        return "index";

    }


}

