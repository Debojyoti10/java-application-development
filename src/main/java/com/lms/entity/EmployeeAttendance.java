package com.lms.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "employee_attendance")
@Data
public class EmployeeAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long employeeId;

    @Column(nullable = false)
    private LocalDate attendanceDate;

    private LocalTime morningInTime;
    private LocalTime morningOutTime;
    private LocalTime afternoonInTime;
    private LocalTime afternoonOutTime;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus status; // PRESENT, ABSENT, HALF_DAY

    private String remarks;

    // Optional: Link to mentor (can be added later)
    private String mentorId;

    public enum AttendanceStatus {
        PRESENT, ABSENT, HALF_DAY
    }
}