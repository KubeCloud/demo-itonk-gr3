package com.onk.group3.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private CampaignType type;

    private int value;

    private ArrayList<Long> AffectedProducts;

    private ArrayList<Long> AffectedCountries;


    public Campaign(Long id, CampaignType type, int value, ArrayList<Long> affectedProducts, ArrayList<Long> affectedCountries) {
        this.id = id;
        this.type = type;
        this.value = value;
        AffectedProducts = affectedProducts;
        AffectedCountries = affectedCountries;
    }

    public Campaign() { }

    public Long getId() {
        return id;
    }

    public CampaignType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public ArrayList<Long> getAffectedProducts() {
        return AffectedProducts;
    }

    public ArrayList<Long> getAffectedCountries() {
        return AffectedCountries;
    }
}
