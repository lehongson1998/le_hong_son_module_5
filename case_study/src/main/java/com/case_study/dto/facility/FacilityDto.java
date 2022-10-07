package com.case_study.dto.facility;

import com.case_study.model.contract.Contract;
import com.case_study.model.facility.FacilityType;
import com.case_study.model.facility.RentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityDto{
    private Long id;
    @NotBlank(message = "* không được để trống trường này")
    @Pattern(regexp = "^([A-Z][a-z ]+)+[0-9]*$", message = "* Tên dịch vụ được phép chứa số,các kí tự đầu tiên của mỗi từ phải viết hoa.")
    private String name;
    @Min(value = 0, message = "* diện tích phải lớn hơn hoặc bằng 0.")
    private int area;
    @Min(value = 0, message = "* giá phải lớn hơn hoặc bằng 0.")
    private double cost;
    @Min(value = 0, message = "* số người phải lớn hơn hoặc bằng 0.")
    private int maxPeople;
    @NotBlank(message = "* không được để trống trường này.")
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Min(value = 0, message = "* diện tích hồ bơi phải lớn hơn hoặc bằng 0")
    private double poolArea;
    @Min(value = 0, message = "* số tầng phải lớn hơn hoặc bằng 0")
    private int numberOfFloors;
    private String facilityFree;
    private FacilityType facilityId;
    private RentType rentType;
    private List<Contract> contractList;

    public FacilityDto(String name, int area, double cost, int maxPeople, String standardRoom, String descriptionOtherConvenience, double poolArea, int numberOfFloors, String facilityFree, FacilityType facilityId, RentType rentType, List<Contract> contractList) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.facilityId = facilityId;
        this.rentType = rentType;
        this.contractList = contractList;
    }
}
