package com.lms.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "employee_experience_info")
@Data
public class EmployeeExperienceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long employeeId;

    private String companyName;
    private String role;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
}