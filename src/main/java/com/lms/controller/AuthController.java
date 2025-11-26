package com.lms.controller;

import com.lms.entity.EmployeePrimaryInfo;
import com.lms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody EmployeePrimaryInfo employee) {
        try {
            // Check if username already exists
            if (service.findByUsername(employee.getUsername()).isPresent()) {
                return ResponseEntity.badRequest().body("Username already exists");
            }

            // Create the employee
            EmployeePrimaryInfo created = service.createPrimaryInfo(employee);
            return ResponseEntity.ok("Employee registered successfully with ID: " + created.getId());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        // Basic authentication - check if user exists and password matches
        var employee = service.findByUsername(username);
        if (employee.isPresent()) {
            // Verify password matches the encoded password in database
            if (passwordEncoder.matches(password, employee.get().getPassword())) {
                return ResponseEntity.ok("Login successful for user: " + username);
            } else {
                return ResponseEntity.badRequest().body("Invalid username or password");
            }
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam Long id, @RequestParam String oldPassword, @RequestParam String newPassword) {
        boolean success = service.resetPassword(id, oldPassword, newPassword);
        if (success) {
            return ResponseEntity.ok("Password reset successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid old password");
        }
    }
}