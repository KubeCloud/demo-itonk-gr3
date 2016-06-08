package com.onk.group3.controllers;

import com.onk.group3.models.Campaign;
import com.onk.group3.repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("web/campaigns")
public class CampaignRestController {
    @Autowired
    private CampaignRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Campaign>> getAllCampaigns() {
        return new ResponseEntity<>((Collection<Campaign>) repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Campaign> getCampaignWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign campaign) {
        return new ResponseEntity<>(repository.save(campaign), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public ResponseEntity<Campaign> updateCampaign(@RequestBody Campaign campaign) {
        return new ResponseEntity<>(repository.save(campaign), HttpStatus.OK);
    }
}
