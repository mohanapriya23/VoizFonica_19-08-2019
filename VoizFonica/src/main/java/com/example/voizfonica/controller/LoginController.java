package com.example.voizfonica.controller;

import com.example.voizfonica.data.OrderRepository;
import com.example.voizfonica.data.RegisterRepository;
import com.example.voizfonica.model.Login;
import com.example.voizfonica.model.Order;
import com.example.voizfonica.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@SessionAttributes({"register"})
@Controller
@RequestMapping("/login")
public class LoginController {
    private RegisterRepository registerrepo;
    private OrderRepository orderRepository;
    @Autowired
    private LoginController(RegisterRepository registerrepo,OrderRepository orderRepository)
    {
        this.registerrepo=registerrepo;
        this.orderRepository = orderRepository;
    }
    @GetMapping
    public String login(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping
    public String user1(@Valid @ModelAttribute Login login, Errors errors, Model model, @ModelAttribute Order order,String id) {
        if (errors.hasErrors()) {
            return "login";
        } else {
            List<Register> register = registerrepo.findByEmailAndAndPassword(login.getEmail(), login.getPassword());
            login.setEmail(login.getEmail());
            order.setPlanId(id);
            order.setLogin(login);
            System.out.println(login);
            orderRepository.save(order);
            if (register.isEmpty()) {
                errors.rejectValue("password","invalid password");
                return "redirect:/login";
            } else {
                model.addAttribute("register", register);
                return "redirect:/dashboard";
            }
        }
    }}