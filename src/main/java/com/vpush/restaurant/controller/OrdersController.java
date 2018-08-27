package com.vpush.restaurant.controller;

import com.vpush.restaurant.domain.Order;
import com.vpush.restaurant.domain.Product;
import com.vpush.restaurant.repository.OrderRepository;
import com.vpush.restaurant.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by admin on 27.08.2018.
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrdersController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    // Get All Orders
    @GetMapping("/orders")
    public List<Order> getAllProducts() {
        return orderRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/orders")
    public Order createNote(@RequestBody Order order) {
        System.out.println(order.getName());
       // System.out.println(order.getStatus());
        Product product = new Product();
        return orderRepository.save(order);
    }

    @CrossOrigin
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        //  System.out.println(order.getName());
        //  System.out.println(order.getStatus());
        //Product product = new Product();
        return productRepository.save(product);
    }


}
