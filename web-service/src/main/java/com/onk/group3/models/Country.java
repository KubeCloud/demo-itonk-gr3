package com.onk.group3.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String twoLetterCode;

    private String threeLetterCode;

    private String currencyCode;

    private String currencyName;

    private BigDecimal exchangeRateToDKK;

    private String cultureInfo;

    private ArrayList<Long> customers;

    private ArrayList<Long> campaigns;

    private ArrayList<Long> suppliers;

    public Country(Long id, String name, String twoLetterCode, String threeLetterCode, String currencyCode, String currencyName, BigDecimal exchangeRateToDKK, String cultureInfo, ArrayList<Long> customers, ArrayList<Long> campaigns, ArrayList<Long> suppliers) {
        this.id = id;
        this.name = name;
        this.twoLetterCode = twoLetterCode;
        this.threeLetterCode = threeLetterCode;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.exchangeRateToDKK = exchangeRateToDKK;
        this.cultureInfo = cultureInfo;
        this.customers = customers;
        this.campaigns = campaigns;
        this.suppliers = suppliers;
    }

    public Country(String name, String twoLetterCode, String threeLetterCode, String currencyCode, String currencyName, BigDecimal exchangeRateToDKK, String cultureInfo) {
        this.name = name;
        this.twoLetterCode = twoLetterCode;
        this.threeLetterCode = threeLetterCode;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.exchangeRateToDKK = exchangeRateToDKK;
        this.cultureInfo = cultureInfo;
    }

    public Country() { }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTwoLetterCode() {
        return twoLetterCode;
    }

    public String getThreeLetterCode() {
        return threeLetterCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public BigDecimal getExchangeRateToDKK() {
        return exchangeRateToDKK;
    }

    public String getCultureInfo() {
        return cultureInfo;
    }

    public ArrayList<Long> getCustomers() {
        return customers;
    }

    public ArrayList<Long> getCampaigns() {
        return campaigns;
    }

    public ArrayList<Long> getSuppliers() {
        return suppliers;
    }
}
