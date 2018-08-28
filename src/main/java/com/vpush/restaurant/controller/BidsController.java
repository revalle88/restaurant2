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
    public List<Bid> getAllBids() {
        return orderService.findAllBids();
    }

    @GetMapping("/buyorders")
    public List<Bid> getBuyProducts() {
         return orderService.getByStatus("buy");
    }

    @GetMapping("/storeorders")
    public List<Bid> getStoreOrders() {
        return orderService.getByStatus("new");
    }


    @PostMapping("/orders")
    public Bid createBid(@RequestBody Bid bid) {
        System.out.println(bid.getName());
         return bidRepository.save(bid);
    }


    @DeleteMapping("/orders/{id}")
    public String deleteBid(@PathVariable Long id) {
        bidRepository.deleteById(id);
        return "OK";
    }

    //TODO
    @PostMapping("/orders/buy")
    public String buyBid(@RequestParam("id") Long id) {
        orderService.setStatusNew(id);
         return "OK";
    }

    @PostMapping("/orders/send")
    public String sendBid(@RequestParam("id") Long id) {
        orderService.setStatusComplete(id);
        return "OK";
    }


    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }


}
