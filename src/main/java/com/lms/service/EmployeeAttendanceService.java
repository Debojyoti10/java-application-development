package com.lms.service;

import com.lms.entity.EmployeeAttendance;
import com.lms.repository.EmployeeAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeAttendanceService {

    @Autowired
    private EmployeeAttendanceRepository attendanceRepository;

    public EmployeeAttendance markAttendance(EmployeeAttendance attendance) {
        // Check if attendance already exists for this employee and date
        EmployeeAttendance existing = getLatestAttendanceByEmployeeAndDate(attendance.getEmployeeId(), attendance.getAttendanceDate());

        if (existing != null) {
            // Update existing record
            if (attendance.getMorningInTime() != null) {
                existing.setMorningInTime(attendance.getMorningInTime());
            }
            if (attendance.getMorningOutTime() != null) {
                existing.setMorningOutTime(attendance.getMorningOutTime());
            }
            if (attendance.getAfternoonInTime() != null) {
                existing.setAfternoonInTime(attendance.getAfternoonInTime());
            }
            if (attendance.getAfternoonOutTime() != null) {
                existing.setAfternoonOutTime(attendance.getAfternoonOutTime());
            }
            if (attendance.getStatus() != null) {
                existing.setStatus(attendance.getStatus());
            }
            if (attendance.getRemarks() != null) {
                existing.setRemarks(attendance.getRemarks());
            }
            if (attendance.getMentorId() != null) {
                existing.setMentorId(attendance.getMentorId());
            }
            return attendanceRepository.save(existing);
        } else {
            // Create new record
            return attendanceRepository.save(attendance);
        }
    }

    public List<EmployeeAttendance> getEmployeeAttendance(String employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId);
    }

    public List<EmployeeAttendance> getAttendanceByDate(LocalDate date) {
        return attendanceRepository.findByAttendanceDate(date);
    }

    public EmployeeAttendance getAttendanceByEmployeeAndDate(String employeeId, LocalDate date) {
        List<EmployeeAttendance> attendances = attendanceRepository.findByEmployeeIdAndAttendanceDate(employeeId, date);
        return attendances.isEmpty() ? null : attendances.get(0);
    }

    public EmployeeAttendance getLatestAttendanceByEmployeeAndDate(String employeeId, LocalDate date) {
        return attendanceRepository.findLatestByEmployeeIdAndDate(employeeId, date);
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}