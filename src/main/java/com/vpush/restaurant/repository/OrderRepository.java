package com.vpush.restaurant.repository;

import com.vpush.restaurant.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 27.08.2018.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {


}
