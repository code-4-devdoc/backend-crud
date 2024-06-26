package com.devdoc.backend.repository;

import com.devdoc.backend.model.AboutMe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AboutMeRepository extends JpaRepository<AboutMe, Integer> {

    List<AboutMe> findByResumeId(Integer resumeId);
    Optional<AboutMe> findByIdAndResumeId(Integer id, Integer resumeId);
}
