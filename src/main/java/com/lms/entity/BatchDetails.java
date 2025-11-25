package com.lms.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "batch_details")
@Data
public class BatchDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String batchName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String mentorId;
    private String description;
}