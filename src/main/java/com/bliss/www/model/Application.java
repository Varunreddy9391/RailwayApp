package com.bliss.www.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Application {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dateOfJoining;
    private String roomNumber;
    private String name;
    private String dateOfBirth;
    private Integer age;
    private String adhereNumber;
    private String address;
    private String candidateMobileNumber;
    private String parentMobileNumber;
    private String purposeOfJoining;
    private Boolean vehicle;
    private String vehicleNumber;
    private Boolean termsConditions;
    private String nextFeeDate;
    private String paymentCompleted;
    private String feeAmount;
    private String vacatedFromHostel;
    private String role;
    
}
