package com.vpush.restaurant.repository;

import com.vpush.restaurant.domain.Order;
import com.vpush.restaurant.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 27.08.2018.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
