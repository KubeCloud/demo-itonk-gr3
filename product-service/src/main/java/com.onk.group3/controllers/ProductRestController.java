package com.onk.group3.controllers;

import com.onk.group3.models.Product;
import com.onk.group3.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("product/products")
public class ProductRestController {
	@Autowired
	private ProductRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Product>> getAllProducts() {
		return new ResponseEntity<>((Collection<Product>) repository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Product> getProductWithId(@PathVariable Long id) {
		return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return new ResponseEntity<>(repository.save(product), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PATCH)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		return new ResponseEntity<>(repository.save(product), HttpStatus.OK);
	}
}
