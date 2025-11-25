package com.lms.repository;

import com.lms.entity.MentorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MentorDetailsRepository extends JpaRepository<MentorDetails, Long> {
    Optional<MentorDetails> findByMentorId(String mentorId);
}