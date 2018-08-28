package com.vpush.restaurant.service;

import com.vpush.restaurant.domain.Bid;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 27.08.2018.
 */

public interface OrderService {
    public List<Bid> findAllBids();
    public List<Bid> findBuyStatus();
    public void setStatusComplete(Long id);
    public void setStatusNew(Long id);
    public List<Bid> getByStatus(String status);
}
