package com.example.service;

import com.example.model.bus.Locations;

import java.util.List;

public interface ILocationsService {
    List<Locations> listLocations();

    Locations findLocationsById(Long id);
}
