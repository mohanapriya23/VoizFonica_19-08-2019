package com.example.voizfonica.controller;
import com.example.voizfonica.data.OrderRepository;
import com.example.voizfonica.data.RegisterRepository;
import com.example.voizfonica.model.Order;
import com.example.voizfonica.model.Payment;
import com.example.voizfonica.data.PaymentRepository;
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
@RequestMapping("/payment")
@SessionAttributes({"register", "order"})
public class PaymentController {
    private final PaymentRepository paymentrepo;
    private final OrderRepository orderRepository;
    private final RegisterRepository registerRepository;
    @Autowired
    public PaymentController(PaymentRepository paymentrepo, OrderRepository orderRepository, RegisterRepository registerRepository)
    {
        this.paymentrepo=paymentrepo;
        this.orderRepository = orderRepository;
        this.registerRepository = registerRepository;
    }
    @ModelAttribute
    @GetMapping
    public String showPayment(Model model,@SessionAttribute Register register){
        model.addAttribute("payment",new Payment());
        return "payment";
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @RequestMapping(value = "/{payment}",method = RequestMethod.GET)
    public String processOrder(@PathVariable Payment payment, @ModelAttribute Order order,Model model,String id){
        return "redirect:/payment";
    }


    @PostMapping
    public String processPayment(@Valid Payment payment, Errors errors, Register register, @ModelAttribute Order order, Model model, String id) {
        if (errors.hasErrors()) {
            return "payment";
        }
        order.setPlanId(id);
        order.setPayment(payment);
        register.setOrder(order);
        System.out.println(order);
        orderRepository.save(order);
        registerRepository.save(register);
        paymentrepo.save(payment);
        return "redirect:/invoice";
    }

}
