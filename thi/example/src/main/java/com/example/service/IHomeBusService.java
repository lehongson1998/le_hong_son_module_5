package com.example.service;

import com.example.model.bus.HomeBus;
import com.example.model.bus.Locations;
import com.example.model.bus.TypeBus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IHomeBusService {
    Page<HomeBus> listHomeBus(String name, Pageable pageable);

    HomeBus findHomeBusById(String id);

    void save(HomeBus homeBus);

    void update(HomeBus homeBus);

    void delete(String id);
}
