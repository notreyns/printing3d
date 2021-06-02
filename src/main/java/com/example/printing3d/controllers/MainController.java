package com.example.printing3d.controllers;

import com.example.printing3d.managing.Orders;
import com.example.printing3d.managing.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private OrdersRepository ordersRepo;



    @GetMapping("/")
    public String home() {
        return "homepage";
    }
    @PostMapping("/orders")
    public @ResponseBody
    String addNewUser(@RequestBody Orders item) {
        ordersRepo.save(item);
        return "OK";
    }
    @GetMapping("/orders")
    public String seeOrders(Model model){
        model.addAttribute("orders", ordersRepo.findAll());
        return "basket";
    }
}

