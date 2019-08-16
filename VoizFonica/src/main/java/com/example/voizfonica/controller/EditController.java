package com.example.voizfonica.controller;
import com.example.voizfonica.data.EditRepository;
import com.example.voizfonica.data.RegisterRepository;
import com.example.voizfonica.model.Edit;
import com.example.voizfonica.model.Login;
import com.example.voizfonica.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/edit")
@SessionAttributes("register")
public class EditController {

    private EditRepository editRepository;
    private RegisterRepository userCredentialRepository;
    private String userId;
    @Autowired
    private EditController(RegisterRepository userCredentialRepository,EditRepository editRepository) {
        this.userCredentialRepository = userCredentialRepository;
         this.editRepository=editRepository;
    }


    @ModelAttribute(name = "register1")
    public Register register1() {
        return new Register();
    }
    @GetMapping
    public String getEdit(@Valid @ModelAttribute Login login, Register userCredential, Model model) {
        Register user = userCredentialRepository.findByEmail(userCredential.getEmail());
        model.addAttribute("user", user);
        System.out.println(user);
        return "edit";
    }
    @PostMapping
    public String setChanges(@ModelAttribute Login login, @ModelAttribute @Valid Register userCredential, @ModelAttribute @Valid Edit edit,Errors errors, Model model){
        if(errors.hasErrors()){
            return "redirect:/edit";
        }
        Register user=userCredentialRepository.findByEmail(userCredential.getEmail());
        Register user1 = new Register();
       // userId =  .get_id();
        user1.set_id(userCredential.get_id());
        user1.setName(userCredential.getName());
        user1.setEmail(edit.getEmail());
        user1.setPassword(edit.getPassword());
       user1.setAddress(edit.getAddress());
        user1.setPhone(edit.getPhone());
        user1.setState(edit.getState());
        user1.setCode(edit.getCode());
        System.out.println(user1);
        userCredentialRepository.save(user1);
        return "redirect:/dashboard";
    }
}

