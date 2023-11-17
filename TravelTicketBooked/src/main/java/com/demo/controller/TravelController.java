package com.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Travel;
import com.demo.services.TravelService;
import com.demo.services.TravelUpdateException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/travels")
public class TravelController {
    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @PostMapping("/save")
    public ResponseEntity<Travel> saveTravel(@Valid @RequestBody Travel travel, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        Travel savedTravel = travelService.saveTravel(travel);
        return ResponseEntity.ok(savedTravel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Travel> getTravel(@PathVariable Long id) {
        Travel travel = travelService.getTravelById(id);
        if (travel != null) {
            return ResponseEntity.ok(travel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Travel> updateTravel(@Valid @RequestBody Travel travel, 
    		BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        try {
            Travel updatedTravel = travelService.updateTravel(travel);
            return ResponseEntity.ok(updatedTravel);
        } catch (TravelUpdateException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTravel(@PathVariable Long id) {
        travelService.deleteTravel(id);
        return ResponseEntity.noContent().build();
    }
}