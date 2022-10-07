package com.example.model.bus;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "type_bus")
public class TypeBus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "typeBus", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<HomeBus> homeBusList;

    public TypeBus(String name, List<HomeBus> homeBusList) {
        this.name = name;
        this.homeBusList = homeBusList;
    }
}
