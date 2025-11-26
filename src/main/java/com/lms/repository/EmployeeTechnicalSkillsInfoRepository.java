package com.lms.repository;

import com.lms.entity.EmployeeTechnicalSkillsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeTechnicalSkillsInfoRepository extends JpaRepository<EmployeeTechnicalSkillsInfo, Long> {
    List<EmployeeTechnicalSkillsInfo> findByEmployeeId(Long employeeId);
}