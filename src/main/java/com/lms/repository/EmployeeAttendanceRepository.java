package com.lms.repository;

import com.lms.entity.EmployeeAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendance, Long> {

    List<EmployeeAttendance> findByEmployeeId(String employeeId);

    List<EmployeeAttendance> findByEmployeeIdAndAttendanceDate(String employeeId, LocalDate date);

    List<EmployeeAttendance> findByAttendanceDate(LocalDate date);

    // Optional: For mentor integration
    List<EmployeeAttendance> findByMentorId(String mentorId);

    // Get the latest attendance record for employee and date
    default EmployeeAttendance findLatestByEmployeeIdAndDate(String employeeId, LocalDate date) {
        List<EmployeeAttendance> attendances = findByEmployeeIdAndAttendanceDate(employeeId, date);
        return attendances.isEmpty() ? null : attendances.get(attendances.size() - 1);
    }
}