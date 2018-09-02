package com.vpush.restaurant.service;

import com.vpush.restaurant.domain.Bid;
import com.vpush.restaurant.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 27.08.2018.
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private BidRepository bidRepository;
    @Override
    public List<Bid> findBuyStatus(){
       return bidRepository.findAll();
   }
    @Override
    public List<Bid> findAllBids(){
        return bidRepository.findAll();
    }

    @Transactional
    @Override
    public void setStatusComplete(Long id){
        Optional<Bid> bid = bidRepository.findById(id);
        Bid bid1 = bid.get();
        bid1.setStatus("complete");
     }

    @Transactional
    @Override
    public void setStatusNew(Long id){
        Optional<Bid> bid = bidRepository.findById(id);
        Bid bid1 = bid.get();
        bid1.setStatus("new");
     }

    @Override
    public List<Bid> getByStatus(String status){
       return bidRepository.findByStatus(status);
    }

}
