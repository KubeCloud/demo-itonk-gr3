package com.onk.group3.Controllers;

import com.onk.group3.models.XOrder;
import com.onk.group3.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Lars on 18-04-2016.
 */
@RestController
@RequestMapping("order/orders")
public class OrderRestController {
    @Autowired
    private OrderRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<XOrder>> getAllOrders() {
        return new ResponseEntity<>((Collection<XOrder>) repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<XOrder> getOrderById(@PathVariable Long id) {
        return new ResponseEntity<>( repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<XOrder> createOrder(@RequestBody XOrder inputOrder)    {
        inputOrder.setCreateDate(new Date());
        inputOrder.setStatus("AwaitingRevision");
        return new ResponseEntity<>( repository.save(inputOrder), HttpStatus.CREATED);
    }
}
