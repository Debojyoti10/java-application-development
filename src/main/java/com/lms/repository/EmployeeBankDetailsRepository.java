package com.lms.repository;

import com.lms.entity.EmployeeBankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeBankDetailsRepository extends JpaRepository<EmployeeBankDetails, Long> {
    Optional<EmployeeBankDetails> findByEmployeeId(Long employeeId);
}