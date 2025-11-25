package com.lms.repository;

import com.lms.entity.BatchDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchDetailsRepository extends JpaRepository<BatchDetails, Long> {
}