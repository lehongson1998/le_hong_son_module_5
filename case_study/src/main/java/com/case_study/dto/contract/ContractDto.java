package com.case_study.dto.contract;

import com.case_study.model.contract.ContractDetail;
import com.case_study.model.customer.Customer;
import com.case_study.model.employee.Employee;
import com.case_study.model.facility.Facility;
import com.case_study.until.ContractValidate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto implements Validator {
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDay;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDay;
    private double deposit;
    private Customer customer;
    private Employee employee;
    private Facility facility;
    private List<ContractDetail> contractDetail;

    public ContractDto(LocalDate startDay, LocalDate endDay, double deposit, Customer customer, Employee employee, Facility facility, List<ContractDetail> contractDetail) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.deposit = deposit;
        this.customer = customer;
        this.employee = employee;
        this.facility = facility;
        this.contractDetail = contractDetail;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        if (contractDto.startDay != null) {
            if (!ContractValidate.checkStartDay(contractDto.startDay)) {
                errors.rejectValue("startDay", "day.lon", "* ngày làm hợp đồng phải là ngày hiện tại.");
            }
        }
        if (contractDto.endDay != null) {
            if (!ContractValidate.checkEndDay(contractDto.endDay)) {
                errors.rejectValue("endDay", "day.lon", "* ngày kết thúc hợp đồng không được nhỏ hơn ngày hiện tại á.");
            }
        }
    }
}
