package com.lms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee_bank_details")
@Data
public class EmployeeBankDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String employeeId;

    private String accountNumber;
    private String bankName;
    private String ifscCode;
    private String accountType;
}