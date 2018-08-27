package com.vpush.restaurant.domain;

import javax.persistence.*;

/**
 * Created by admin on 27.08.2018.
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
