package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value="/Distilleries")
    public ResponseEntity<List<Distillery>> findDistilleryFilterByRegion(
            @RequestParam(name="region", required = false) String region,
            @RequestParam(name="age", required = false) Integer age){
        if (region != null && age!= null){
            return new ResponseEntity<>(distilleryRepository.findDistilleriesByRegionAndWhiskiesAge(region, age), HttpStatus.OK);
        } else if (region != null) {
            return new ResponseEntity<>(distilleryRepository.findDistilleriesByRegion(region), HttpStatus.OK);
        } else if (age != null) {
            return new ResponseEntity<>(distilleryRepository.findDistilleriesByWhiskiesAge(age), HttpStatus.OK);
        }
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }


}
