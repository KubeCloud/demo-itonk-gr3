package com.onk.group3.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Lars on 18-04-2016.
 */
@Entity
public class XOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal total;
    private java.util.Date createDate;
    private String status;

    private Long customerId;
    private Long[] productIds;

    public XOrder(BigDecimal total, Long customerId, Long[] productIds)
    {
        this.total = total;
        this.createDate = new Date();
        this.status = "AwaitingRevision";

        this.customerId = customerId;
        this.productIds = productIds;
    }

    public XOrder(){}

    public BigDecimal getTotal()
    {
        return this.total;
    }

    public java.util.Date getCreateDate()
    {
        return this.createDate;
    }

    public void setCreateDate(Date date) {
        createDate = date;
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long[] getProductIds()
    {
        return this.productIds;
    }

    public Long getCustomerId()
    {
        return this.customerId;
    }
}

