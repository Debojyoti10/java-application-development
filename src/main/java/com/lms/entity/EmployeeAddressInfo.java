package com.lms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee_address_info")
@Data
public class EmployeeAddressInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String employeeId;

    private String addressType; // permanent, current
    private String street;
    private String city;
    private String state;
    private String zipCode;
}