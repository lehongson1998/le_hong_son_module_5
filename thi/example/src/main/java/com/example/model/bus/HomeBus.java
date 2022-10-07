package com.example.model.bus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "home_bus")
public class HomeBus {
    @Id
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "type_bus_id", referencedColumnName = "id")
    private TypeBus typeBus;
    @ManyToOne
    @JoinColumn(name = "go_locations", referencedColumnName = "id")
    private Locations goLocations;
    @ManyToOne
    @JoinColumn(name = "back_locations", referencedColumnName = "id")
    private Locations backLocations;
    private String phone;
    private String email;
    private String startTime;
    private String endTime;
}
