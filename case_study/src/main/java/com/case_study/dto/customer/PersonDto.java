package com.case_study.dto.customer;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public abstract class PersonDto {
    @NotBlank(message = "* không được để trống trường này" )
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotBlank(message = "* không được để trống trường này" )
    private String idCard;
    @NotBlank(message = "* không được để trống trường này" )
    @Pattern(regexp = "^0[1-9]\\d{8,9}$", message = "số điện thoại phải là số việt nam")
    private String phoneNumber;
    @NotBlank(message = "* không được để trống trường này" )
    @Email
    private String email;
    @NotBlank(message = "* không được để trống trường này" )
    private String address;

    public PersonDto() {
    }

    public PersonDto(String name, LocalDate dateOfBirth, String idCard, String phoneNumber, String email, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
