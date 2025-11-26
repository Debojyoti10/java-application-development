package com.lms.repository;

import com.lms.entity.EmployeeSecondaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeSecondaryInfoRepository extends JpaRepository<EmployeeSecondaryInfo, Long> {
    Optional<EmployeeSecondaryInfo> findByEmployeeId(Long employeeId);
}