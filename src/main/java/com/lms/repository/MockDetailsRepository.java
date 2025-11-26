package com.lms.repository;

import com.lms.entity.MockDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MockDetailsRepository extends JpaRepository<MockDetails, Long> {
    List<MockDetails> findByEmployeeId(Long employeeId);
}