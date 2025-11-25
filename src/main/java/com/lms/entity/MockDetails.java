package com.lms.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "mock_details")
@Data
public class MockDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mockName;
    private LocalDate date;
    private String employeeId;
    private Integer score;
    private String feedback;
}