package com.onk.group3.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private ArrayList<Long> products;

    public Catalog(Long id, String name, ArrayList<Long> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Catalog() { }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Long> getProducts() {
        return products;
    }
}
