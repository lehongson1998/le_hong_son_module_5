package com.example.controller;

import com.example.model.bus.Locations;
import com.example.service.ILocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("locations")
public class LocationsRestController {
    @Autowired
    private ILocationsService locationsService;

    @GetMapping("")
    public ResponseEntity<List<Locations>> findAll(){
        List<Locations> locations = locationsService.listLocations();
        if (locations.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locations> findById(@PathVariable Long id){
        Locations locations = locationsService.findLocationsById(id);
        if (locations == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }
}
