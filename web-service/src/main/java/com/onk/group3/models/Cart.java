package com.onk.group3.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 2048)
    private ArrayList<Long> products;

    private BigDecimal price;

    private Long customerId;

    public Cart(Long id, ArrayList<Long> products, BigDecimal price, Long customerId) {
        this.id = id;
        this.products = products;
        this.price = price;
        this.customerId = customerId;
    }

    public Cart() { }

    public Long getId() {
        return id;
    }

    public ArrayList<Long> getProducts() {
        return products;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
