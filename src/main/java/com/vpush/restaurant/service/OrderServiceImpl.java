package com.vpush.restaurant.service;

import com.vpush.restaurant.domain.Bid;
import com.vpush.restaurant.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 27.08.2018.
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private BidRepository bidRepository;

   /* public Bid completeOrder(Long id){
        Bid order = orderRepository.findOne(id);
        return order;
    }
*/
    @Override
   public List<Bid> findBuyStatus(){
       return bidRepository.findAll();
   }
    @Override
    public List<Bid> findAllBids(){
        return bidRepository.findAll();
    }
    @Override
    public void setStatusComplete(Long id){
        Optional<Bid> bid = bidRepository.findById(id);
        Bid bid1 = bid.get();
      bid1.setStatus("complete");
       bidRepository.save(bid1);

    }
    @Override
    public List<Bid> getByStatus(String status){

       return bidRepository.findByStatus(status);
    }

}
