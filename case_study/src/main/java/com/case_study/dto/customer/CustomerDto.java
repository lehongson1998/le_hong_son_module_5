package com.case_study.dto.customer;

import com.case_study.until.RegexCustomer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class CustomerDto extends PersonDto implements Validator {
    private Long Id;
    private Boolean gender;
    private TypeCustomerDto typeCustomerDto;

    public CustomerDto() {
    }

    public CustomerDto(String name, LocalDate dateOfBirth, String idCard, String phoneNumber, String email, String address, Long id, Boolean gender, TypeCustomerDto typeCustomerDto) {
        super(name, dateOfBirth, idCard, phoneNumber, email, address);
        Id = id;
        this.gender = gender;
        this.typeCustomerDto = typeCustomerDto;
    }

    public CustomerDto(String name, LocalDate dateOfBirth, String idCard, String phoneNumber, String email, String address, Boolean gender, TypeCustomerDto typeCustomerDto) {
        super(name, dateOfBirth, idCard, phoneNumber, email, address);
        this.gender = gender;
        this.typeCustomerDto = typeCustomerDto;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public TypeCustomerDto getTypeCustomerDto() {
        return typeCustomerDto;
    }

    public void setTypeCustomerDto(TypeCustomerDto typeCustomerDto) {
        this.typeCustomerDto = typeCustomerDto;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if (!RegexCustomer.checkRegexName(customerDto)){
            errors.rejectValue("name", "wrong.create","* tên gồm 3 - 4 từ và mỗi từ bắt đầu bằng chữ viết hoa");
        }
        if (customerDto.getDateOfBirth() != null){
            if (!RegexCustomer.checkDateOfBirth(customerDto)){
                errors.rejectValue("dateOfBirth", "wrong.create","* tuổi phải trên 18 và nhỏ hơn hoặc bằng 100");
            }
        }else {
            errors.rejectValue("dateOfBirth", "wrong.create","* không để rỗng trường này");
        }
        if (!RegexCustomer.checkRegexIdCard(customerDto)){
            errors.rejectValue("idCard", "wrong.create","* số CMND phải là số có 9 đến 11 chữ số");
        }
        if (!RegexCustomer.checkRegexAddress(customerDto)){
            errors.rejectValue("address", "wrong.create","* địa chỉ có thể là chữ hoặc số có thể chứa khoảng trắng dấu\',\' dấu \'/\' ko chứa kí tự đặc biệt");
        }

        if(customerDto.gender == null){
            errors.rejectValue("gender", "wrong.create","* không được để trống trường này");
        }

        if(customerDto.typeCustomerDto == null){
            errors.rejectValue("typeCustomerDto", "wrong.create","* không được để trống trường này");
        }
    }
}
