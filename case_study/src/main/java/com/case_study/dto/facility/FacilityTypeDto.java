package com.case_study.dto.facility;

import com.case_study.model.facility.Facility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityTypeDto {
    private Long id;
    private String name;
    private List<Facility> facility;
}
