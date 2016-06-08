package com.onk.group3.controllers;


import com.onk.group3.models.Cart;
import com.onk.group3.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("web/carts")
public class CartRestController {
    @Autowired
    private CartRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Cart>> getAllCarts() {
        return new ResponseEntity<>((Collection<Cart>) repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Cart> getCartWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
        return new ResponseEntity<>(repository.save(cart), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable String id, @RequestBody Cart cart) {
        cart.setId(new Long(id));
        return new ResponseEntity<>(repository.save(cart), HttpStatus.OK);
    }
}
