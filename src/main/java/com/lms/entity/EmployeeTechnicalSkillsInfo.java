package com.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee_technicalskills_info")
@Data
public class EmployeeTechnicalSkillsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column(nullable = false)
    private Long employeeId;

    private String skillName;
    private String proficiency; // beginner, intermediate, expert
}