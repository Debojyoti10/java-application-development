package com.lms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee_technicalskills_info")
@Data
public class EmployeeTechnicalSkillsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long employeeId;

    private String skillName;
    private String proficiency; // beginner, intermediate, expert
}