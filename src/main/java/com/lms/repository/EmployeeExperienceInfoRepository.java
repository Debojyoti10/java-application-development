package com.lms.repository;

import com.lms.entity.EmployeeExperienceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeExperienceInfoRepository extends JpaRepository<EmployeeExperienceInfo, Long> {
    List<EmployeeExperienceInfo> findByEmployeeId(Long employeeId);
}