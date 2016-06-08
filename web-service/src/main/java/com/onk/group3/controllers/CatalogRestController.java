package com.onk.group3.controllers;

import com.onk.group3.models.Catalog;
import com.onk.group3.repositories.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("web/catalogs")
public class CatalogRestController {
    @Autowired
    private CatalogRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Catalog>> getAllCatalogs() {
        return new ResponseEntity<>((Collection<Catalog>) repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Catalog> getCatalogWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Catalog> addCatalog(@RequestBody Catalog catalog) {
        return new ResponseEntity<>(repository.save(catalog), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public ResponseEntity<Catalog> updateCatalog(@RequestBody Catalog catalog) {
        return new ResponseEntity<>(repository.save(catalog), HttpStatus.OK);
    }
}
