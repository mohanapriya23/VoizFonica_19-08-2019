package com.example.voizfonica.controller;
import com.example.voizfonica.data.OrderRepository;
import com.example.voizfonica.data.Payment1Repository;
import com.example.voizfonica.data.RegisterRepository;
import com.example.voizfonica.model.Order;
import com.example.voizfonica.model.Payment;
import com.example.voizfonica.data.PaymentRepository;
import com.example.voizfonica.model.Payment1;
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
@RequestMapping("/payment1")
@SessionAttributes({"register", "order"})
public class Payment1Controller {
    private final Payment1Repository paymentrepo1;
    private final OrderRepository orderRepository;
    private final RegisterRepository registerRepository;
    @Autowired
    public Payment1Controller(Payment1Repository paymentrepo1, OrderRepository orderRepository, RegisterRepository registerRepository) {
        this.paymentrepo1 = paymentrepo1;
        this.orderRepository = orderRepository;
        this.registerRepository = registerRepository;
    }

    @ModelAttribute
    @GetMapping
    public String showPayment(Model model,@SessionAttribute Register register){
        model.addAttribute("payment1",new Payment());
        return "payment1";
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @RequestMapping(value = "/{payment1}",method = RequestMethod.GET)
    public String processOrder(@PathVariable Payment1 payment1, @ModelAttribute Order order, Model model, String id){
        return "redirect:/payment1";
    }


    @PostMapping
    public String processPayment(@Valid Payment1 payment1, Errors errors, Register register, @ModelAttribute Order order, Model model, String id) {
        if (errors.hasErrors()) {
            return "payment1";
        }
        order.setPlanId(id);
        order.setPayment1(payment1);
        register.setOrder(order);
        System.out.println(order);
        orderRepository.save(order);
        registerRepository.save(register);
        paymentrepo1.save(payment1);
        return "redirect:/invoice1";
    }

}
