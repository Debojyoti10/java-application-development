package com.lms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mentor_details")
@Data
public class MentorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mentorId;
    private String name;
    private String email;
    private String phone;
    private String expertise;
}