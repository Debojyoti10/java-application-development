package com.lms.repository;

import com.lms.entity.EmployeeEducationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeEducationInfoRepository extends JpaRepository<EmployeeEducationInfo, Long> {
    List<EmployeeEducationInfo> findByEmployeeId(Long employeeId);
}