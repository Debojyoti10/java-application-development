package com.lms.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "employee_secondary_info")
@Data
public class EmployeeSecondaryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long employeeId;

    private LocalDate joiningDate;
    private String managerId;
    private String employmentType;
    private Double salary;
}