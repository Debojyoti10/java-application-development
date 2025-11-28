package com.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee_address_info")
@Data
public class EmployeeAddressInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column(nullable = false)
    private Long employeeId;

    private String addressType; // permanent, current
    private String street;
    private String city;
    private String state;
    private String zipCode;
}