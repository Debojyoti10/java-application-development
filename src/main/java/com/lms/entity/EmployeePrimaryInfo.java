package com.lms.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "employee_primary_info")
@Data
public class EmployeePrimaryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private String gender;
    private String department;
    private String designation;
    @Column(unique = true)
    private String username;
    private String password;
    private String status = "ACTIVE";
}