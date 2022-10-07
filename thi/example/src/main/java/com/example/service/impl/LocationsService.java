package com.example.service.impl;

import com.example.model.bus.Locations;
import com.example.repository.ILocationsRepository;
import com.example.service.ILocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationsService implements ILocationsService {
    @Autowired
    private ILocationsRepository locationsRepository;

    @Override
    public List<Locations> listLocations() {
        return locationsRepository.findAll();
    }

    @Override
    public Locations findLocationsById(Long id) {
        return locationsRepository.findById(id).orElse(null);
    }
}
