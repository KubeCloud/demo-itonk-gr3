package com.onk.group3.controllers;

import com.onk.group3.models.Country;
import com.onk.group3.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("web/countries")
public class CountryRestController {
    @Autowired
    private CountryRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Country>> getAllCountrys() {
        return new ResponseEntity<>((Collection<Country>) repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Country> getCountryWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        return new ResponseEntity<>(repository.save(country), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public ResponseEntity<Country> updateCountry(@ModelAttribute Country country) {
        return new ResponseEntity<>(repository.save(country), HttpStatus.OK);
    }
}
