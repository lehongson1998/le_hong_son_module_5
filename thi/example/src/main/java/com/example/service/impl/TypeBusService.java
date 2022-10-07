package com.example.service.impl;

import com.example.model.bus.TypeBus;
import com.example.repository.ITypeBusRepository;
import com.example.service.ITypeBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeBusService implements ITypeBusService {
    @Autowired
    private ITypeBusRepository typeBusRepository;
    @Override
    public List<TypeBus> listTypeBus() {
        return typeBusRepository.findAll();
    }
    @Override
    public TypeBus findTypeBusById(Long id) {
        return typeBusRepository.findById(id).orElse(null);
    }
}
