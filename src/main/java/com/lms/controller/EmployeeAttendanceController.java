package com.lms.controller;

import com.lms.entity.EmployeeAttendance;
import com.lms.service.EmployeeAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class EmployeeAttendanceController {

    @Autowired
    private EmployeeAttendanceService attendanceService;

    @PostMapping
    public ResponseEntity<EmployeeAttendance> markAttendance(@RequestBody EmployeeAttendance attendance) {
        EmployeeAttendance saved = attendanceService.markAttendance(attendance);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EmployeeAttendance>> getEmployeeAttendance(@PathVariable Long employeeId) {
        List<EmployeeAttendance> attendances = attendanceService.getEmployeeAttendance(employeeId);
        return ResponseEntity.ok(attendances);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<EmployeeAttendance>> getAttendanceByDate(@PathVariable String date) {
        LocalDate attendanceDate = LocalDate.parse(date);
        List<EmployeeAttendance> attendances = attendanceService.getAttendanceByDate(attendanceDate);
        return ResponseEntity.ok(attendances);
    }

    @GetMapping("/employee/{employeeId}/date/{date}")
    public ResponseEntity<EmployeeAttendance> getAttendanceByEmployeeAndDate(
            @PathVariable Long employeeId,
            @PathVariable String date) {
        LocalDate attendanceDate = LocalDate.parse(date);
        EmployeeAttendance attendance = attendanceService.getAttendanceByEmployeeAndDate(employeeId, attendanceDate);
        return attendance != null ? ResponseEntity.ok(attendance) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return ResponseEntity.noContent().build();
    }
}