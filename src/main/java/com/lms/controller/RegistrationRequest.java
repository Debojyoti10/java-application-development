package com.lms.controller;

import lombok.Data;
import java.time.LocalDate;

@Data
public class RegistrationRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private String gender;
    private String department;
    private String designation;
}