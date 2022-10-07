package com.example.repository;

import com.example.model.bus.HomeBus;
import com.example.model.bus.TypeBus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITypeBusRepository extends JpaRepository<TypeBus, Long> {
}
