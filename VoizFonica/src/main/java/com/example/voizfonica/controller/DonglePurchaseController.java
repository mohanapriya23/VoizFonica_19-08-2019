package com.example.voizfonica.controller;

import com.example.voizfonica.data.DongleRepository;
import com.example.voizfonica.data.OrderRepository;
import com.example.voizfonica.model.DonglePurchase;
import com.example.voizfonica.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@Document (collection = "order")
@RequestMapping("/donglepurchase")
@SessionAttributes({"register", "order"})
public class DonglePurchaseController {

    private final DongleRepository dongleRepo;
    private OrderRepository orderRepository;
    @Autowired
    public DonglePurchaseController(DongleRepository dongledRepo, OrderRepository orderRepository) {
        this.dongleRepo=dongledRepo;
        this.orderRepository=orderRepository;
    }



    @GetMapping
    public String dongleFunc(Model model) {
        List<DonglePurchase> donglepurchase = new ArrayList<>();
        dongleRepo.findAll().forEach(i -> donglepurchase.add(i));
        model.addAttribute("donglepurchase",donglepurchase);
        return "donglepurchase";
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @RequestMapping(value = "/{donglepurchase}",method = RequestMethod.GET)
    public String processOrder(@PathVariable DonglePurchase donglepurchase, @ModelAttribute Order order,Model model,String id){
        order.setDonglePurchase(donglepurchase);
        orderRepository.save(order);
        System.out.println(order);
        return "redirect:/payment2";
    }
    @PostMapping
    public String processPlanFrom( Model model,@ModelAttribute Order order, @Valid DonglePurchase donglepurchase,DonglePurchaseController donglePurchaseController){
       order.setDonglePurchase(donglepurchase);
        return "redirect:/payment2";
    }
}






/*

package com.example.voizfonica.controller;


import com.example.voizfonica.data.DongleRepository;
import com.example.voizfonica.data.OrderRepository;
import com.example.voizfonica.model.DonglePurchase;
import com.example.voizfonica.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Document(collection = "order")
@RequestMapping("/donglepurchase")
@SessionAttributes({"register", "order"})
public class DonglePurchaseController {

    private final DongleRepository dongleRepository;
    private OrderRepository orderRepository;
    @Autowired
    public DonglePurchaseController(DongleRepository dongleRepository, OrderRepository orderRepository) {
        this.dongleRepository=dongleRepository;
        this.orderRepository=orderRepository;
        System.out.println(dongleRepository);
    }


    @GetMapping
    public String donglePurchaseFunc(Model model) {
        //List<DonglePurchase> donglePurchase = dongleRepository.findAll();
        model.addAttribute("donglePurchase",new DonglePurchase());
        return  "donglepurchase";
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @RequestMapping(value = "/{donglePurchase}",method = RequestMethod.GET)
    public String processOrder(@PathVariable DonglePurchase donglePurchase, @ModelAttribute Order order,Model model,String id){
        model.addAttribute("donglePurchase",donglePurchase);
        dongleRepository.save(donglePurchase);
        order.setDonglePurchase(donglePurchase);
        System.out.println(donglePurchase);
        orderRepository.save(order);
        System.out.println(order);
        return "redirect:/payment2";
    }
    @PostMapping
    public String processPlanFrom(@Valid DonglePurchaseController donglePurchaseController, Model model,Order order,DonglePurchase donglePurchase){
        model.addAttribute("donglePurchase",donglePurchase);

        return "redirect:/payment2";
    }
}
*/




/*

package com.example.voizfonica.controller;


import com.example.voizfonica.data.DongleRepository;
import com.example.voizfonica.data.OrderRepository;
import com.example.voizfonica.model.DonglePurchase;
import com.example.voizfonica.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Document(collection = "order")
@RequestMapping("/donglepurchase")
@SessionAttributes({"register", "order"})
public class DonglePurchaseController {

    private final DongleRepository dongleRepository;
    private OrderRepository orderRepository;
    @Autowired
    public DonglePurchaseController(DongleRepository dongleRepository, OrderRepository orderRepository) {
        this.dongleRepository=dongleRepository;
        this.orderRepository=orderRepository;
        System.out.println(dongleRepository);
    }


    @GetMapping
    public String donglePurchaseFunc(Model model) {
        List<DonglePurchase> purchase = dongleRepository.findAll();
        model.addAttribute("purchase",purchase);
        return  "donglepurchase";
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @RequestMapping(value = "/{donglePurchase}",method = RequestMethod.GET)
    public String processOrder(@PathVariable DonglePurchase donglePurchase, @ModelAttribute Order order,Model model,String id){
        model.addAttribute("donglePurchase",donglePurchase);
        dongleRepository.save(donglePurchase);
        order.setDonglePurchase(donglePurchase);
        System.out.println(donglePurchase);
        orderRepository.save(order);
        System.out.println(order);
        return "redirect:/payment2";
    }
    @PostMapping
    public String processPlanFrom(@Valid DonglePurchaseController donglePurchaseController, Model model,Order order,DonglePurchase donglePurchase){
        model.addAttribute("donglePurchase",donglePurchase);

        return "redirect:/payment2";
    }
}
*/
