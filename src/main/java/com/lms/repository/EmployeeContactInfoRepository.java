package com.lms.repository;

import com.lms.entity.EmployeeContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeContactInfoRepository extends JpaRepository<EmployeeContactInfo, Long> {
    List<EmployeeContactInfo> findByEmployeeId(Long employeeId);
}