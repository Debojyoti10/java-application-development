package com.lms.controller;

import com.lms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String employeeId, @RequestParam String oldPassword, @RequestParam String newPassword) {
        boolean success = service.resetPassword(employeeId, oldPassword, newPassword);
        if (success) {
            return ResponseEntity.ok("Password reset successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid old password");
        }
    }
}