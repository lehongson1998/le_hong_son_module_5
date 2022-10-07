package com.example.repository;

import com.example.model.bus.HomeBus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface IHomeBusRepository extends JpaRepository<HomeBus, String> {
    HomeBus homeBus = new HomeBus();
    @Query(value = "SELECT * FROM home_bus hb WHERE hb.name like ?1",
            countQuery = "select * from home_bus hb where hb.name like ?1",
            nativeQuery = true
    )
    Page<HomeBus> findAllByName(String name, Pageable pageable);

    @Modifying
    @Query(value = "insert into home_bus(id,name, type_bus_id, go_locations, back_locations, start_time, end_time, phone, email)" +
            "values(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)", nativeQuery = true)
    void saveHomBus(String id,
                    String name,
                    Long typeId,
                    Long goLocations,
                    Long BackLocation,
                    String startTime,
                    String endTime,
                    String phone,
                    String email);
    @Modifying
    @Query(value = "update home_bus set name = ?1, type_bus_id = ?2, go_locations = ?3, back_locations = ?4, start_time = ?5, end_time = ?6, phone = ?7, email = ?8 where id = ?9", nativeQuery = true)
    void updateHomeBus(
                    String name,
                    Long typeId,
                    Long goLocations,
                    Long BackLocation,
                    String startTime,
                    String endTime,
                    String phone,
                    String email,
                    String id);
}
