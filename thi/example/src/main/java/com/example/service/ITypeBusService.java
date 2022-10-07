package com.example.service;

import com.example.model.bus.TypeBus;

import java.util.List;

public interface ITypeBusService {
    List<TypeBus> listTypeBus();

    TypeBus findTypeBusById(Long id);
}
