package com.devdoc.backend.repository;

import com.devdoc.backend.model.EducationCompletion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EducationCompletionRepository extends JpaRepository<EducationCompletion, Integer> {

    List<EducationCompletion> findByResumeId(Integer resumeId);
    Optional<EducationCompletion> findByIdAndResumeId(Integer id, Integer resumeId);
}
