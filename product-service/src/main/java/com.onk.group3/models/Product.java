package com.onk.group3.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(length = 2048)
    private String description;

    private double price;

    private ProductStatus status;

    private ArrayList<Long> items;

    private ArrayList<Long> catalogs;

    private ArrayList<Long> campaigns;

    private ArrayList<Long> orders;


    public Product(Long id, ProductStatus type, double value, String name, String description, ArrayList<Long> items, ArrayList<Long> catalogs, ArrayList<Long> campaigns, ArrayList<Long> orders) {
        this.id = id;
        this.status = type;
        this.name = name;
        this.description = description;
        this.price = value;
        this.items = items;
        this.catalogs = catalogs;
        this.campaigns = campaigns;
        this.orders = orders;
    }

    public Product() { }

    public Long getId() {
        return this.id;
    }

    public ProductStatus getType() {
        return this.status;
    }

    public double getPrice() { return this.price; }

    public String getName() { return this.name; }

    public String getDescription() { return this.description; }

    public ArrayList<Long> getItems() {
        return this.items;
    }

    public ArrayList<Long> getCampaigns() {
        return this.campaigns;
    }

    public ArrayList<Long> getCatalogs() {
        return this.catalogs;
    }

    public ArrayList<Long> getOrders() {
        return this.orders;
    }
}
