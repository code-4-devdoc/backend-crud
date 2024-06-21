package com.devdoc.backend.repository;

import com.devdoc.backend.model.Certification;
import com.devdoc.backend.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CertificationRepository extends JpaRepository<Certification, Integer > {
    List<Certification> findByResumeId(Integer resumeId);

    Optional<Certification> findByIdAndResumeId(Integer certificationId, Integer resumeId);
}
