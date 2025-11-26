package com.lms.service;

import com.lms.entity.EmployeePrimaryInfo;
import com.lms.repository.EmployeePrimaryInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeePrimaryInfoRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<EmployeePrimaryInfo> employeeOpt = employeeRepository.findByUsername(username);

        if (employeeOpt.isEmpty()) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        EmployeePrimaryInfo employee = employeeOpt.get();

        // Create UserDetails from EmployeePrimaryInfo
        return User.builder()
                .username(employee.getUsername())
                .password(employee.getPassword()) // Already encoded with BCrypt
                .roles("EMPLOYEE") // You can add role-based logic later
                .build();
    }
}