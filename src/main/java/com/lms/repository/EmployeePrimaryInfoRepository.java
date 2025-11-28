package com.lms.repository;

import com.lms.entity.EmployeePrimaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeePrimaryInfoRepository extends JpaRepository<EmployeePrimaryInfo, Long> {
    Optional<EmployeePrimaryInfo> findByUsername(String username);
    Optional<EmployeePrimaryInfo> findByPassword(String password);
}