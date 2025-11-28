package com.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee_education_info")
@Data
public class EmployeeEducationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column(nullable = false)
    private Long employeeId;

    private String degree;
    private String university;
    private Integer yearOfPassing;
    private String grade;
}