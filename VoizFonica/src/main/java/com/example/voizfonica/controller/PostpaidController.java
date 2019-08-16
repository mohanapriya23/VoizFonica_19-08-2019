package com.example.voizfonica.controller;

import com.example.voizfonica.data.OrderRepository;
import com.example.voizfonica.data.PlanRepository;
import com.example.voizfonica.model.Order;
import com.example.voizfonica.model.PostpaidPlans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Document (collection = "order")
@RequestMapping("/postpaid")
@SessionAttributes({"register", "order"})
public class PostpaidController {

    private final PlanRepository postpaidRepo;
    private OrderRepository orderRepository;
    @Autowired
    public PostpaidController(PlanRepository postpaidRepo, OrderRepository orderRepository) {
        this.postpaidRepo=postpaidRepo;
        this.orderRepository=orderRepository;
    }

    public PostpaidController(PlanRepository postpaidRepo) {
        this.postpaidRepo = postpaidRepo;
    }

    @GetMapping
    public String postPlanFunc(Model model) {
        List<PostpaidPlans> plans = postpaidRepo.findAll();
        model.addAttribute("plans",plans);
        return  "postpaidplans";
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @RequestMapping(value = "/{postpaidPlans}",method = RequestMethod.GET)
    public String processOrder(@PathVariable PostpaidPlans postpaidPlans, @ModelAttribute Order order,Model model,String id){
        order.setPlanId(id);
        order.setPostpaidPlans(postpaidPlans);
        orderRepository.save(order);
        System.out.println(order);
        return "redirect:/payment";
    }
    @PostMapping
    public String processPlanFrom(@Valid PostpaidController postPaidController, Model model){
        model.addAttribute("payment",postPaidController);
        return "redirect:/payment";
    }
}