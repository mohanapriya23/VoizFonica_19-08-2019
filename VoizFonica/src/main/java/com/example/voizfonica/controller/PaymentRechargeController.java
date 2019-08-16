package com.example.voizfonica.controller;

import com.example.voizfonica.data.OrderRepository;
import com.example.voizfonica.data.PaymentRechargeRepository;
import com.example.voizfonica.model.Order;
import com.example.voizfonica.model.PaymentRecharge;
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
@SessionAttributes({"register", "order"})
@Document(collection = "payRecharge")
@RequestMapping("/payrecharge")
public class PaymentRechargeController{
    private PaymentRechargeRepository paymentRechargeRepository;
    private OrderRepository orderRepository;

    @Autowired
    public PaymentRechargeController(OrderRepository orderRepository,PaymentRechargeRepository paymentRechargeRepository){
        this.orderRepository = orderRepository;
        this.paymentRechargeRepository = paymentRechargeRepository;
    }

    @ModelAttribute
    @GetMapping
    public String show_paymentRecharge(Model model){
        model.addAttribute("paymentRecharge",new PaymentRecharge());
        return "payrecharge";
    }

    @PostMapping
    public String processPaymentRecharge(@Valid PaymentRecharge paymentRecharge,Errors errors,@ModelAttribute Order order){
        if (errors.hasErrors()) {
            return "payrecharge";
        }
        paymentRechargeRepository.save(paymentRecharge);
        order.setPaymentRecharge(paymentRecharge);
        orderRepository.save(order);
        return "redirect:/payment1";
    }
}