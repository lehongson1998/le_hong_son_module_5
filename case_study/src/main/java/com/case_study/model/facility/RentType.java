package com.case_study.model.facility;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "rentType", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Facility> facilityList;

    public RentType(String name, List<Facility> facilityList) {
        this.name = name;
        this.facilityList = facilityList;
    }
}
