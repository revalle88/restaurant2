package com.vpush.restaurant.controller;

import com.vpush.restaurant.domain.Bid;
import com.vpush.restaurant.domain.Product;
import com.vpush.restaurant.repository.BidRepository;
import com.vpush.restaurant.repository.ProductRepository;
import com.vpush.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by admin on 27.08.2018.
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class BidsController {

    @Autowired
    BidRepository bidRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderService orderService;

    // Get All Orders
    @GetMapping("/orders")
    public List<Bid> getAllProducts() {
        return bidRepository.findAll();
    }

    @GetMapping("/buyorders")
    public List<Bid> getBuyProducts() {
       // return bidRepository.getBuyOrders();
       // return orderService.findBuyStatus();
        return bidRepository.findByStatus("buy");
    }

    @GetMapping("/storeorders")
    public List<Bid> getStoreOrders() {

        return bidRepository.findByStatus("new");
    }

    @CrossOrigin
    @PostMapping("/orders")
    public Bid createBid(@RequestBody Bid bid) {
        System.out.println(bid.getName());
       // System.out.println(order.getStatus());
        Product product = new Product();
        return bidRepository.save(bid);
    }

    @CrossOrigin
    @DeleteMapping("/orders/{id}")
    public String deleteBid(@PathVariable Long id) {

        bidRepository.deleteById(id);
        return "OK";
    }

    //TODO
    @PostMapping("/orders/buy")
    public String buyBid(@RequestParam("id") Long id) {
        orderService.setStatusComplete(id);
       // bidRepository.setStatusForBid("complete", id);
        return "OK";
    }

    @CrossOrigin
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {

        //Product product = new Product();
        return productRepository.save(product);
    }


}
