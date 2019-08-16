package com.example.voizfonica.controller;
import com.example.voizfonica.data.OrderRepository;

import com.example.voizfonica.data.RegisterRepository;
import com.example.voizfonica.model.Order;

import com.example.voizfonica.data.Payment2Repository;
import com.example.voizfonica.model.Payment2;
import com.example.voizfonica.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Document(collection = "order")
@RequestMapping("/payment2")
@SessionAttributes({"register", "order"})
public class Payment2Controller {
    private final Payment2Repository paymentrepo2;
    private final OrderRepository orderRepository;
    private final RegisterRepository registerRepository;
    @Autowired
    public Payment2Controller(Payment2Repository paymentrepo2, OrderRepository orderRepository, RegisterRepository registerRepository) {
        this.paymentrepo2 = paymentrepo2;
        this.orderRepository = orderRepository;
        this.registerRepository = registerRepository;
    }

    @ModelAttribute
    @GetMapping
    public String showPayment(Model model,@SessionAttribute Register register){
        model.addAttribute("payment2",new Payment2());
        return "payment2";
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @RequestMapping(value = "/{payment2}",method = RequestMethod.GET)
    public String processOrder(@PathVariable Payment2 payment2, @ModelAttribute Order order, Model model, String id){
        return "redirect:/payment2";
    }


    @PostMapping
    public String processPayment(@Valid Payment2 payment2, Errors errors, Register register, @ModelAttribute Order order, Model model, String id) {
        if (errors.hasErrors()) {
            return "payment2";
        }
        order.setId(id);
        order.setPayment2(payment2);
        register.setOrder(order);
        System.out.println(order);
        orderRepository.save(order);
        registerRepository.save(register);
        paymentrepo2.save(payment2);
        return "redirect:/invoice2";
    }

}
