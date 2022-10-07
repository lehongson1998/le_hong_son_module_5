package com.example.model.bus;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "goLocations", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<HomeBus> homeBusList;
    @JsonIgnore
    @OneToMany(mappedBy = "backLocations", cascade = CascadeType.ALL)
    private List<HomeBus> homeBusList1;

    public Locations(String name, List<HomeBus> homeBusList, List<HomeBus> homeBusList1) {
        this.name = name;
        this.homeBusList = homeBusList;
        this.homeBusList1 = homeBusList1;
    }
}
