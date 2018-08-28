package com.vpush.restaurant.repository;

import com.vpush.restaurant.domain.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by admin on 27.08.2018.
 */
public interface BidRepository extends JpaRepository<Bid, Long> {
    @Query("select o.id, o.name, o.description, o.status from Bid o where o.status = 'new'")
    List<Bid> getBuyOrders();

    @Modifying
    @Query("update Bid bid set bid.status = :status where bid.id = :id")
    int setStatusForBid(@Param("status") String status, @Param("id") Long id);

    List<Bid> findByStatus(String status);

}
