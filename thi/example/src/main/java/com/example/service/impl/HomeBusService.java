package com.example.service.impl;

import com.example.model.bus.HomeBus;
import com.example.repository.IHomeBusRepository;
import com.example.service.IHomeBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeBusService implements IHomeBusService {
    @Autowired
    private IHomeBusRepository homeBusRepository;

    @Override
    public Page<HomeBus> listHomeBus(String name, Pageable pageable) {
        return homeBusRepository.findAllByName(name, pageable);
    }

    @Override
    public HomeBus findHomeBusById(String id) {
        return homeBusRepository.findById(id).orElse(null);
    }

    @Override
    public void save(HomeBus homeBus) {
        homeBusRepository.saveHomBus(homeBus.getId(), homeBus.getName(),
                homeBus.getTypeBus().getId(),
                homeBus.getGoLocations().getId(), homeBus.getBackLocations().getId(),
                homeBus.getStartTime(), homeBus.getEndTime(),
                homeBus.getPhone(), homeBus.getEmail()
                );
    }

    @Override
    public void update(HomeBus homeBus) {
        homeBusRepository.updateHomeBus(homeBus.getName(),
                homeBus.getTypeBus().getId(),
                homeBus.getGoLocations().getId(), homeBus.getBackLocations().getId(),
                homeBus.getStartTime(), homeBus.getEndTime(),
                homeBus.getPhone(), homeBus.getEmail(),homeBus.getId()
        );
    }

    @Override
    public void delete(String id) {
        homeBusRepository.delete(findHomeBusById(id));
    }
}
