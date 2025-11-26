package com.lms.repository;

import com.lms.entity.EmployeeAddressInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeAddressInfoRepository extends JpaRepository<EmployeeAddressInfo, Long> {
    List<EmployeeAddressInfo> findByEmployeeId(Long employeeId);
}