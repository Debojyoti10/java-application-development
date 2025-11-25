package com.lms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee_education_info")
@Data
public class EmployeeEducationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String employeeId;

    private String degree;
    private String university;
    private Integer yearOfPassing;
    private String grade;
}