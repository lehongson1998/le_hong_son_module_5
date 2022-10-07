package com.example.repository;

import com.example.model.bus.Locations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocationsRepository extends JpaRepository<Locations, Long> {
}
