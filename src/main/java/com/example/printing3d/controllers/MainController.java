package com.example.printing3d.controllers;

import com.example.printing3d.managing.Orders;
import com.example.printing3d.managing.OrdersRepository;
import com.example.printing3d.managing.Size;
import com.example.printing3d.managing.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private OrdersRepository ordersRepo;
    @Autowired
    private SizeRepository sizeRepo;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("size", sizeRepo.findAll());
        return "homepage";
    }
    @PostMapping("/orders")
    public String addNewOrder(@RequestParam String name,@RequestParam String color, @RequestParam String material, Model model) {
        Orders item=new Orders(name, color, material);
        ordersRepo.save(item);
        return "redirect:/";
    }
    @GetMapping("/orders")
    public String seeOrders(Model model){
        model.addAttribute("orders", ordersRepo.findAll());
        return "basket";
    }
    @PostMapping("/size/add")
    public @ResponseBody
    String addNewMaterial(@RequestBody Size size) {
        sizeRepo.save(size);
        return "OK";
    }
}

